package contacts;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person extends Contacts {
    private String name;
    private String surname;
    private String birth;
    private String gender;


    //    public Person(String name, String surName, String number, String birthDate, String gender) {
//        super(number);
//        this.name = name;
//        this.surname = surName;
//        this.birthDate = birthDate;
//        this.gender = gender;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public String getBirth() {
        if (this.birth == null) {
            return "[no data]";
        }
        return birth;
    }

    public void setBirth(String birth) {
        if (birth.isEmpty()) {
            System.out.print("Bad birth date!\n");
            return;
        }
        this.birth = birth;
    }

    public String getGender() {
        if (this.gender == null) {
            return "[no data]";
        }
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.matches("[MF]")) {
            System.out.print("Bad gender!\n");
            return;
        }
        this.gender = gender;
    }


    @Override
    public String getNameInfo() {
        return getName() + " " + getSurname();
    }

    @Override
    public List<Field> getInstanceDeclaredFields() {
        List<Field> fields = new ArrayList<>();

        Field[] superFields = this.getClass().getSuperclass().getDeclaredFields();
        Field[] instanceFields = this.getClass().getDeclaredFields();

        fields.addAll(Arrays.asList(instanceFields));

        for (Field field : superFields) {
            if (!(field.getName().equals("created") || field.getName().equals("lastEdit"))) {
                fields.add(field);
            }
        }

        return fields;
    }

    @Override
    public List<Method> getAllSetters() {
        Method[] allMethods = this.getClass().getMethods();
        List<Method> setters = new ArrayList<>();
        for (Method method : allMethods) {
            if (method.getName().startsWith("set")) {
                setters.add(method);
            }
        }
        return setters;
    }

    @Override
    public void getSetter(String methodName, String value) {

        String output = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        String methodCall = "set" + output;
        try {
            Method setMethod = this.getClass().getMethod(methodCall, String.class);
            setMethod.invoke(this, value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\n"
                + "Surname: " + getSurname() + "\n"
                + "Birth date: " + getBirth() + "\n"
                + "Gender: " + getGender() + "\n"
                + "Number: " + getNumber() + "\n"
                + "Time created: " + getCreated() + "\n"
                + "Time last edit: " + getLastEdit() + "\n";
    }
}

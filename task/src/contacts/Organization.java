package contacts;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Organization extends Contacts{

    private String name;
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getNameInfo() {
        return getName();
    }

    @Override
    public List<Field> getInstanceDeclaredFields() {
        List<Field> fields = new ArrayList<>();

        Field[] superFields = this.getClass().getSuperclass().getDeclaredFields();
        Field[] instanceFields = this.getClass().getDeclaredFields();


        Collections.addAll(fields, instanceFields);

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
        return "Organization name: " + getName() + "\n"
                + "Address: " + getAddress() + "\n"
                + "Number: " + getNumber() + "\n"
                + "Time created: " + getCreated() + "\n"
                + "Time last edit: " + getLastEdit() + "\n";
    }
}

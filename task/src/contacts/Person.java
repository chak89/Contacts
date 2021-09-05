package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person extends Contacts {
    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public Person(Type type) {
        setType(type);
    }

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

    public String getBirthDate() {
        if (this.birthDate == null) {
            return "[no data]";
        }
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate.isEmpty()) {
            System.out.print("Bad birth date!\n");
            return;
        }
        this.birthDate = birthDate;
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
    public String toString() {
        return "Name: " + getName() + "\n"
                + "Surname: " + getSurname() + "\n"
                + "Birth date: " + getBirthDate() + "\n"
                + "Gender: " + getGender() + "\n"
                + "Number: " + getNumber() + "\n"
                + "Time created: " + getCreated() + "\n"
                + "Time last edit: " + getLastEdit() + "\n";
    }
}

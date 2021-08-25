package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacts {
    private String name;
    private String surName;
    private String number;

    public Contacts(String name, String surName, String number) {
        this.name = name;
        this.surName = surName;
        setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {

        if (isNumberValid(number)) {
            this.number = number;
        } else {
            this.number = "";
            System.out.println("Wrong number format!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public boolean hasNumber() {
        return !number.isEmpty();
    }

    private boolean isNumberValid(String number) {

        String countryCode = "\\+?(((\\w+)([\\s\\-]\\w{2,})*([\\s\\-]\\(\\w{2,}\\))?([\\s\\-]\\w{2,})*)|((\\(\\w+\\))([\\s\\-]\\w{2,})*))";

        Pattern pattern = Pattern.compile(countryCode);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }


    @Override
    public String toString() {

        if (this.hasNumber()) {
            return this.name + " " + this.surName
                    +", " + this.number;
        } else {
            return this.name + " " + this.surName
                    +", " + "[no number]";
        }
    }
}

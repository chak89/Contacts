package contacts;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contacts implements Serializable {

    private String number;
    private LocalDateTime created;
    private LocalDateTime lastEdit;

    public Contacts() {
        this.created = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        this.lastEdit = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
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

    public boolean hasNumber() {
        return !number.isEmpty();
    }

    private boolean isNumberValid(String number) {

        String countryCode = "\\+?(((\\w+)([\\s\\-]\\w{2,})*([\\s\\-]\\(\\w{2,}\\))?([\\s\\-]\\w{2,})*)|((\\(\\w+\\))([\\s\\-]\\w{2,})*))";

        Pattern pattern = Pattern.compile(countryCode);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit() {
        this.lastEdit = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    public abstract String getNameInfo();

    public abstract List<Field> getInstanceDeclaredFields();

    public abstract List<Method> getAllSetters();

    public abstract void getSetter(String methodeName, String value);

    public abstract String toString();
}

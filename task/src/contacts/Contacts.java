package contacts;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contacts {
    public enum Type {
        PERSON,
        ORGANIZATION
    }

    private Type type;
    private String number;
    private LocalDateTime created;
    private LocalDateTime lastEdit;

    public Contacts() {
        this.created = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        this.lastEdit = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(LocalDateTime lastEdit) {
        this.lastEdit = lastEdit;
    }

    public abstract String getNameInfo();
}

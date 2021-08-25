package contacts;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        UserInterface userInterface = new UserInterface(phoneBook);
        userInterface.userInput();
    }
}

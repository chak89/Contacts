package contacts;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        boolean saveToDisk = false;
        String fileName = null;

        if (args.length == 2) {
            fileName = args[1];

            try {
                phoneBook = (PhoneBook) ReadWriteFile.deserialize(fileName);
            } catch (IOException e) {
                {
                    System.out.println("File does not exist.");
                    System.out.println("Create a new one.");
                    try {
                        ReadWriteFile.serialize(phoneBook, fileName);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            saveToDisk = true;
        }
        UserInterface userInterface = new UserInterface(phoneBook,saveToDisk,fileName);
        userInterface.userInput();
    }
}

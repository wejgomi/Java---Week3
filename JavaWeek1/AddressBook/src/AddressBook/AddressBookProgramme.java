package AddressBook;

import java.io.File;

public class AddressBookProgramme {

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        try{
            addressBook.LoadContactsFromFile(new File("ContactDetails.txt"));
            System.out.println("Success!");
        }catch(Exception e) {
            System.out.println("Failure!" + e);
        }
        addressBook.printAllContacts();
    }
}
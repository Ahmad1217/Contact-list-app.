package contactlist;
import java.util.Scanner;
import contactlist.ContactList;
import contactlist.ContactListPersistentService;
import contactlist.AddPerson;


public class Assignment4 {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        ContactListPersistentService persistentService = new ContactListPersistentService("contacts.json");
        contactList.setContacts(persistentService.loadContacts());

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nContact List App");
            System.out.println("1. Add Person");
            System.out.println("2. Print Contacts");
            System.out.println("3. Search Contacts");
            System.out.println("4. Save and Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    AddPerson.execute(scanner, contactList);
                    break;
                case 2:
                    contactList.printContacts();
                    break;
                case 3:
                    System.out.print("Search by (name/email/phone): ");
                    String field = scanner.nextLine();
                    System.out.print("Enter search term: ");
                    String term = scanner.nextLine();
                    contactList.searchContacts(field, term);
                    break;
                case 4:
                    persistentService.saveContacts(contactList.getContacts());
                    System.out.println("Contacts saved. Exiting.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while(choice != 4);

        scanner.close();
    }
}
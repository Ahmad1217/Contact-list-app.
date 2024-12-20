package contactlist;

import java.util.Scanner;

public class AddPerson {
    public static void execute(Scanner scanner, ContactList contactList) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        Person person = new Person(name, email, phone, address, age);
        contactList.addPerson(person);
    }
}
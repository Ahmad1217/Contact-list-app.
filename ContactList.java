package contactlist;

import java.util.ArrayList;
import java.util.List;

public class ContactList {
    private List<Person> contacts = new ArrayList<>();

    public void addPerson(Person person) {
        contacts.add(person);
        System.out.println("Person was added.");
    }

    public void printContacts() {
        if(contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
            return;
        }
        for(Person p : contacts) {
            System.out.println(p);
        }
    }

    public void searchContacts(String field, String term) {
        List<Person> results = new ArrayList<>();
        for(Person p : contacts) {
            switch(field.toLowerCase()) {
                case "name":
                    if(p.getName().equalsIgnoreCase(term)) results.add(p);
                    break;
                case "email":
                    if(p.getEmail().equalsIgnoreCase(term)) results.add(p);
                    break;
                case "phone":
                    if(p.getPhone().equalsIgnoreCase(term)) results.add(p);
                    break;
                default:
                    System.out.println("Unknown search field.");
                    return;
            }
        }
        if(results.isEmpty()) {
            System.out.println("No matching contacts was found.");
        } else {
            for(Person p : results) {
                System.out.println(p);
            }
        }
    }

    public List<Person> getContacts() {
        return contacts;
    }

    public void setContacts(List<Person> contacts) {
        this.contacts = contacts;
    }
}
package contactlist;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ContactListPersistentService {
    private String filename;
    private Gson gson = new Gson();

    public ContactListPersistentService(String filename) {
        this.filename = filename;
    }

    public void saveContacts(List<Person> contacts) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(contacts, writer);
            System.out.println("Contacts were successfully saved.");
        } catch(IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public List<Person> loadContacts() {
        try (FileReader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Person>>(){}.getType();
            List<Person> contacts = gson.fromJson(reader, listType);
            return contacts != null ? contacts : new ArrayList<>();
        } catch(IOException e) {
            System.out.println("No existing contacts found. Starting fresh.");
            return new ArrayList<>();
        }
    }
}
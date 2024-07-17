import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {
    Map<String, String> contacts = new HashMap<>();

    public int add (String name, String phone) {
        contacts.put(name, phone);
        return contacts.size();
    }
    public String findByNumber(String phone) {
        return contacts.entrySet().stream()
                .filter(entry -> entry.getValue().equals(phone))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
    public String findByName(String name) {
        return contacts.entrySet().stream()
                .filter(entry -> entry.getKey().equals(name))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
    public void printAllNames () {
        Set<String> sortedNames = new TreeSet<>(contacts.keySet());
        for (String name : sortedNames) {
            System.out.println(name);
        }
    }
}


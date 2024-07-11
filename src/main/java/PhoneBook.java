import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, String> contacts = new HashMap<>();

    public int add (String name, String phone) {
        contacts.put(name, phone);
        return contacts.size();
    }
    public String findByNumber(String phone) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(phone)) {
                return entry.getKey();
            }
        }
        return null;
    }
}


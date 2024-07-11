import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PhoneBookTest {
    PhoneBook contacts;
    @BeforeEach
    void startTest () {
        System.out.println("Начало теста");
        contacts = new PhoneBook();
    }
    @AfterEach
    void endTest () {
        System.out.println("Конец теста");
    }
    @Test
    void addTest() {
        var expeated = 1;
        var actual = contacts.add("Василий", "+79545255464");
        System.out.println("Контакт добавлен");
        Assertions.assertEquals(expeated, actual);
    }
}

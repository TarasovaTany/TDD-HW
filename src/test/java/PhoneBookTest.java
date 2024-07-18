import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(expeated, actual);
    }

    @Test
    void findByNumberTest () {
        contacts.add("Александра", "+79515779121");
        contacts.add("Мария", "+79123601661");
        contacts.add("Роман", "+79234520692");
        var expeated = "Мария";
        var actual = contacts.findByNumber("+79123601661");
        System.out.println("Поиск по номеру воспроизводится");
        assertEquals(expeated, actual);
    }
    @Test
    void findByNameTest () {
        contacts.add("Татьяна", "+79344576227");
        contacts.add("Владимир", "+79645272257");
        contacts.add("Дмитрий", "+79678467848");
        var expeated = "+79678467848";
        var actual = contacts.findByName("Дмитрий");
        System.out.println("Поиск по имени воспроизводится");
        assertEquals(expeated, actual);
    }
    @Test
    void printAllNamesTest () {
        contacts.add("Татьяна", "+79344576227");
        contacts.add("Владимир", "+79645272257");
        contacts.add("Дмитрий", "+79678467848");
        contacts.add("Александра", "+79515779121");
        contacts.add("Мария", "+79123601661");
        contacts.add("Роман", "+79234520692");

        String expectedOutput = "Александра\r\nВладимир\r\nДмитрий\r\nМария\r\nРоман\r\nТатьяна\r\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        contacts.printAllNames();

        System.setOut(System.out); // Восстанавливаем стандартный вывод
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);
    }
}

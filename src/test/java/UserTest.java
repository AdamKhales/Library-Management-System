import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    public void TestSearchBook1() {
        LibraryManagementSystem.catalog.clear();
        String keyword = "1984";
        LibraryManagementSystem.catalog.add(new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 10, 328));
        LibraryManagementSystem.catalog.add(new PaperBook("Animal Farm", "George Orwell", "Penguin", 1002, 2,300));
        LibraryManagementSystem.catalog.add(new PaperBook("1984 and Philosophy", "William Irwin", "Open Court", 1007, 3, 350));
        LibraryManagementSystem.catalog.add(new PaperBook("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1003, 7, 281));
        LibraryManagementSystem.catalog.add(new AudioBook("Becoming", "Michelle Obama", "Crown", 1002, 1140));
        LibraryManagementSystem.catalog.add(new AudioBook("Sapiens", "Yuval Noah Harari", "Harper", 1004, 900));

        List<Book> expected = new ArrayList<Book>();
        expected.add(LibraryManagementSystem.catalog.get(0));
        expected.add(LibraryManagementSystem.catalog.get(2));

        List<Book> result = User.searchBooks(keyword);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestSearchBook2() {
        LibraryManagementSystem.catalog.clear();
        String keyword = "GeOrgE ORWeLl";
        LibraryManagementSystem.catalog.add(new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 10, 328));
        LibraryManagementSystem.catalog.add(new PaperBook("Animal Farm", "George Orwell", "Penguin", 1002, 2,300));
        LibraryManagementSystem.catalog.add(new PaperBook("1984 and Philosophy", "William Irwin", "Open Court", 1007, 3, 350));
        LibraryManagementSystem.catalog.add(new PaperBook("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1003, 7, 281));
        LibraryManagementSystem.catalog.add(new AudioBook("Becoming", "Michelle Obama", "Crown", 1002, 1140));
        LibraryManagementSystem.catalog.add(new AudioBook("Sapiens", "Yuval Noah Harari", "Harper", 1004, 900));

        List<Book> expected = new ArrayList<Book>();
        expected.add(LibraryManagementSystem.catalog.get(0));
        expected.add(LibraryManagementSystem.catalog.get(1));

        List<Book> result = User.searchBooks(keyword);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestSearchBook3() {
        LibraryManagementSystem.catalog.clear();
        String keyword = "";
        LibraryManagementSystem.catalog.add(new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 10, 328));
        LibraryManagementSystem.catalog.add(new PaperBook("Animal Farm", "George Orwell", "Penguin", 1002, 2,300));
        LibraryManagementSystem.catalog.add(new PaperBook("1984 and Philosophy", "William Irwin", "Open Court", 1007, 3, 350));
        LibraryManagementSystem.catalog.add(new PaperBook("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1003, 7, 281));
        LibraryManagementSystem.catalog.add(new AudioBook("Becoming", "Michelle Obama", "Crown", 1002, 1140));
        LibraryManagementSystem.catalog.add(new AudioBook("Sapiens", "Yuval Noah Harari", "Harper", 1004, 900));

        List<Book> expected = new ArrayList<Book>();

        List<Book> result = User.searchBooks(keyword);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestSearchBook4() {
        LibraryManagementSystem.catalog.clear();
        String keyword = null;
        LibraryManagementSystem.catalog.add(new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 10, 328));
        LibraryManagementSystem.catalog.add(new PaperBook("Animal Farm", "George Orwell", "Penguin", 1002, 2,300));
        LibraryManagementSystem.catalog.add(new PaperBook("1984 and Philosophy", "William Irwin", "Open Court", 1007, 3, 350));
        LibraryManagementSystem.catalog.add(new PaperBook("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1003, 7, 281));
        LibraryManagementSystem.catalog.add(new AudioBook("Becoming", "Michelle Obama", "Crown", 1002, 1140));
        LibraryManagementSystem.catalog.add(new AudioBook("Sapiens", "Yuval Noah Harari", "Harper", 1004, 900));

        List<Book> expected = new ArrayList<Book>();

        List<Book> result = User.searchBooks(keyword);

        Assertions.assertEquals(expected, result);
    }
}

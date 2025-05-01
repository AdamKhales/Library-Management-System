import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibrarianTest {

    @Test
    public void TestAddBook1() {
        LibraryManagementSystem.catalog.clear();
        Librarian librarian = new Librarian("Adam");
        Book book1 = new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 10, 328);
        LibraryManagementSystem.catalog.add(book1);
        librarian.addBook(book1);

        Assertions.assertEquals(1, LibraryManagementSystem.catalog.size());
        Assertions.assertEquals(11,((PaperBook) LibraryManagementSystem.catalog.get(0)).getCopies());
    }

    @Test
    public void TestAddBook2() {
        LibraryManagementSystem.catalog.clear();

        Librarian librarian = new Librarian("Adam");
        Book book1 = new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 10, 328);
        librarian.addBook(book1);

        Assertions.assertEquals(1, LibraryManagementSystem.catalog.size());
        Assertions.assertEquals(10,((PaperBook) LibraryManagementSystem.catalog.get(0)).getCopies());
    }

    @Test
    public void TestAddBook3() {
        LibraryManagementSystem.catalog.clear();

        Librarian librarian = new Librarian("Adam");
        Book book1 = null;
        librarian.addBook(book1);

        Assertions.assertEquals(0, LibraryManagementSystem.catalog.size());
    }

    @Test
    public void TestRemoveBook1() {
        LibraryManagementSystem.catalog.clear();
        Librarian librarian = new Librarian("Adam");
        Book paperBook = new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 3, 328);
        LibraryManagementSystem.catalog.add(paperBook);

        librarian.removeBook(paperBook);

        Assertions.assertEquals(1, LibraryManagementSystem.catalog.size());
        Assertions.assertEquals(2, ((PaperBook) paperBook).getCopies());
    }

    @Test
    public void TestRemoveBook2() {
        LibraryManagementSystem.catalog.clear();
        Librarian librarian = new Librarian("Adam");
        Book paperBook = new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 1, 328);
        LibraryManagementSystem.catalog.add(paperBook);

        librarian.removeBook(paperBook);

        Assertions.assertEquals(0, LibraryManagementSystem.catalog.size());
    }

    @Test
    public void TestRemoveBook3() {
        LibraryManagementSystem.catalog.clear();
        Librarian librarian = new Librarian("Adam");
        Book audioBook = new AudioBook("Becoming", "Michelle Obama", "Crown", 1002, 1140);
        LibraryManagementSystem.catalog.add(audioBook);

        librarian.removeBook(audioBook);

        Assertions.assertEquals(0, LibraryManagementSystem.catalog.size());
        Assertions.assertFalse(LibraryManagementSystem.catalog.contains(audioBook));
    }

    @Test
    public void TestRemoveBook4() {
        LibraryManagementSystem.catalog.clear();
        Librarian librarian = new Librarian("Adam");
        Book book = null;

        librarian.removeBook(null);

        Assertions.assertEquals(0, LibraryManagementSystem.catalog.size());
        Assertions.assertFalse(LibraryManagementSystem.catalog.contains(book));
    }

    @Test
    public void TestIssueBook1() {
        LibraryManagementSystem.catalog.clear();
        Librarian librarian = new Librarian("Adam");
        Student student = new Student("Adam");
        Book paperBook = new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 3, 328);

        boolean expected = false;
        boolean result = librarian.issueBook(paperBook, student);

        librarian.issueBook(paperBook, student);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestIssueBook2() {
        LibraryManagementSystem.catalog.clear();
        Librarian librarian = new Librarian("Adam");
        Student student = new Student("Adam");
        Book paperBook = new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 3, 328);
        LibraryManagementSystem.catalog.add(paperBook);

        boolean expected = true;
        boolean result = librarian.issueBook(paperBook, student);

        librarian.issueBook(paperBook, student);

        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(1, LibraryManagementSystem.catalog.size());
        Assertions.assertEquals(2, ((PaperBook) paperBook).getCopies());
        Assertions.assertTrue(student.getBorrowedBooks().contains(paperBook));
    }

    @Test
    public void TestIssueBook3() {
        LibraryManagementSystem.catalog.clear();
        Librarian librarian = new Librarian("Adam");
        Student student = new Student("Adam");
        Book paperBook = null;
        LibraryManagementSystem.catalog.add(paperBook);

        boolean result = librarian.issueBook(paperBook, student);

        librarian.issueBook(paperBook, student);

        Assertions.assertFalse(result);
    }

    @Test
    public void TestIssueBook4() {
        LibraryManagementSystem.catalog.clear();
        Librarian librarian = new Librarian("Adam");
        Student student = null;
        Book paperBook = new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 3, 328);
        LibraryManagementSystem.catalog.add(paperBook);

        boolean result = librarian.issueBook(paperBook, student);

        librarian.issueBook(paperBook, student);

        Assertions.assertFalse(result);
    }


}

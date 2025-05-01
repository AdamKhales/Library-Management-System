import org.example.Book;
import org.example.LibraryManagementSystem;
import org.example.PaperBook;
import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    @Test
    public void TestBorrowBook1() {
        LibraryManagementSystem.catalog.clear();
        Student student = new Student("Adam Khales");
        Book book = new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 10, 328);
        LibraryManagementSystem.catalog.add(book);


        boolean result = student.borrowBook(book);

        Assertions.assertTrue(result);
        Assertions.assertEquals(1, student.getBorrowedBooks().size());
        Assertions.assertEquals(9, ((PaperBook)book).getCopies());
    }

    @Test
    public void TestBorrowBook2() {
        LibraryManagementSystem.catalog.clear();
        Student student = new Student("Adam Khales");
        Book book = new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 10, 328);
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        student.setBorrowedBooks(books);
        LibraryManagementSystem.catalog.add(book);


        boolean result = student.borrowBook(book);

        Assertions.assertFalse(result);
        Assertions.assertEquals(1, student.getBorrowedBooks().size());
        Assertions.assertEquals(10, ((PaperBook)book).getCopies());
    }

    @Test
    public void TestBorrowBook3() {
        LibraryManagementSystem.catalog.clear();
        Student student = new Student("Adam Khales");
        Book book = null;
        LibraryManagementSystem.catalog.add(book);


        boolean result = student.borrowBook(book);

        Assertions.assertFalse(result);

    }

    @Test
    public void TestReturnBook1() {
        LibraryManagementSystem.catalog.clear();
        Student student = new Student("Adam Khales");
        Book book = new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 10, 328);;
        LibraryManagementSystem.catalog.add(book);
        student.borrowBook(book);


        boolean result = student.returnBook(book);

        Assertions.assertTrue(result);
        Assertions.assertEquals(0, student.getBorrowedBooks().size());
        Assertions.assertEquals(10, ((PaperBook)book).getCopies());

    }

    @Test
    public void TestReturnBook2() {
        LibraryManagementSystem.catalog.clear();
        Student student = new Student("Adam Khales");
        Book book = null;

        boolean result = student.returnBook(book);

        Assertions.assertFalse(result);
        Assertions.assertEquals(0, student.getBorrowedBooks().size());
    }

    @Test
    public void TestReturnBook3() {
        LibraryManagementSystem.catalog.clear();
        Student student = new Student("Adam Khales");
        Book book = new PaperBook("1984", "George Orwell", "Secker & Warburg", 1001, 10, 328);;
        LibraryManagementSystem.catalog.add(book);


        boolean result = student.returnBook(book);

        Assertions.assertFalse(result);
        Assertions.assertEquals(0, student.getBorrowedBooks().size());
        Assertions.assertEquals(10, ((PaperBook)book).getCopies());
    }
}

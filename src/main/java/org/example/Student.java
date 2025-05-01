package org.example;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends User implements Borrowable{
    private int studentId;
    private static int nextStudentId = 1;
    private List<Book> borrowedBooks;

    public Student(String name) {
        super(name);
        this.studentId = nextStudentId++;
        this.borrowedBooks = new ArrayList<>();
    }

    public Student(String name, int studentId) {
        super(name);
        this.studentId = studentId;
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studentId == student.studentId && Objects.equals(borrowedBooks, student.borrowedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId, borrowedBooks);
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "studentId=" + studentId +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public static int getNextStudentId() {
        return nextStudentId;
    }

    public static void setNextStudentId(int nextStudentId) {
        Student.nextStudentId = nextStudentId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public void displayInfo() {
        String strBorrowedBooks = "\n";
        for (Book book : borrowedBooks) {
            strBorrowedBooks = book.getTitle() + " " + book.getAuthor() + "\n";
        }
        System.out.printf("Student ID: %d\nName: %s\nBorrowed books: %s", studentId, getName(),strBorrowedBooks);
    }

    /**
     * adds a book to the list of borrowed books and removes a copy if it is a paperBook
     * @param book a book to be borrowed
     * @return true if the book was successfully borrowed, else returns false
     */
    @Override
    public boolean borrowBook(Book book) {
        if (!LibraryManagementSystem.catalog.contains(book)) {
            return false;
        }
        if (borrowedBooks.contains(book)) {
            return false;
        }
        if (book instanceof PaperBook paperBook) {
            if (paperBook.getCopies() >= 1) {
                paperBook.setCopies(paperBook.getCopies() - 1);
                borrowedBooks.add(book);
                return true;
            } else {
                return false;
            }
        }
        if (book instanceof AudioBook audioBook) {
            borrowedBooks.add(audioBook);
            return true;
        }
        return false;
    }

    /**
     * removes the book from the list of borrowed books and increases the copies if the book is a PaperBook
     * @param book the book to be returned
     * @return true if the book is successfully returned else false.
     */
    @Override
    public boolean returnBook(Book book) {
        if (book != null && borrowedBooks.contains(book)) {
            if (book instanceof PaperBook paperBook) {
                paperBook.setCopies(paperBook.getCopies() + 1);
            }
            borrowedBooks.remove(book);
            return true;
        }
        return false;
    }
}

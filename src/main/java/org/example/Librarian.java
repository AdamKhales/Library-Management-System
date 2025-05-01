package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Librarian extends User{
    private int librarianId;
    private static int nextLibrarianId = 1;

    public Librarian(String name) {
        super(name);
        this.librarianId = nextLibrarianId++;
    }

    public Librarian(String name, int librarianId) {
        super(name);
        this.librarianId = librarianId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Librarian librarian = (Librarian) o;
        return librarianId == librarian.librarianId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), librarianId);
    }

    @Override
    public String toString() {
        return "Librarian{" + super.toString() +
                "librarianId=" + librarianId +
                '}';
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public static int getNextLibrarianId() {
        return nextLibrarianId;
    }

    public static void setNextLibrarianId(int nextLibrarianId) {
        Librarian.nextLibrarianId = nextLibrarianId;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Librarian ID: %d\nName: %s", librarianId, getName());
    }

    /**
     * adds a book to the catalog. If the catalog contains the book, copies increases by 1.
     * @param book the book to be added
     */
    public static void addBook(Book book){
        if (book == null){
            return;
        }
        for (Book existingBook : LibraryManagementSystem.catalog) {
            if (existingBook != null && existingBook.getSerialNumber() == book.getSerialNumber()) {
                if (book instanceof PaperBook paperBook) {
                    paperBook.setCopies(paperBook.getCopies() + 1);
                }
                return;
            }
        }
        LibraryManagementSystem.catalog.add(book);
    }

    /**
     * removes a book from the catalog. If the catalog contains the book, copies decreases by 1.
     * If copies is at 1, the book is removed completely from the catalog.
     * @param book the book to be removed
     */
    public void removeBook(Book book){
        if (book == null){
            return;
        }
        Iterator<Book> bookIterator = LibraryManagementSystem.catalog.iterator();

        while (bookIterator.hasNext()) {
            Book existingBook = bookIterator.next();
            if (existingBook != null && existingBook.getSerialNumber() == book.getSerialNumber()) {
                if (book instanceof PaperBook paperBook) {
                    if (paperBook.getCopies() > 1) {
                        paperBook.setCopies(paperBook.getCopies() - 1);
                    } else {
                        bookIterator.remove();
                    }
                } else {
                    bookIterator.remove();
                }
                return;
            }
        }
    }

    /**
     * adds a book from the catalog into the list of borrowed books of the student (removes a copy if it is a paper book)
     * @param book the book to be issued
     * @param student the student to borrow the book
     * @return true if successful,else, false
     */
    public boolean issueBook(Book book, Student student) {
        if (book == null || student == null){
            return false;
        }
        if (!LibraryManagementSystem.catalog.contains(book)){
            return false;
        }
        if (student.getBorrowedBooks().contains(book)){
            return false;
        }
        if (book instanceof PaperBook paperBook){
            if (paperBook.getCopies() > 0){
                student.borrowBook(paperBook);
                if (paperBook.getCopies() == 0){
                    LibraryManagementSystem.catalog.remove(paperBook);
                }
                return true;
            }
        }
        if (book instanceof AudioBook audioBook){
            List<Book> newBorrowedBooks = student.getBorrowedBooks();
            newBorrowedBooks.add(audioBook);
            student.setBorrowedBooks(newBorrowedBooks);
            return true;
        }
        return false;
    }
}

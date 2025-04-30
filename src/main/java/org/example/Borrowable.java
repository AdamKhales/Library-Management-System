package org.example;

public interface Borrowable {
    boolean borrowBook(Book book);
    boolean returnBook(Book book);
}

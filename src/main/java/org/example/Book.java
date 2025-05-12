package org.example;

import java.util.Comparator;
import java.util.Objects;

public abstract class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String publisher;
    private int serialNumber;

    public Book(String title, String author, String publisher, int serialNumber) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return serialNumber == book.serialNumber && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher, serialNumber);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", serialNumber=" + serialNumber +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public abstract void displayInfo();

    @Override
    public int compareTo(Book o) {
        return 100 * this.title.compareTo(o.title) + Integer.compare(this.serialNumber, o.serialNumber);
    }

    public static class SerialNumberComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            return Integer.compare(o1.getSerialNumber(), o2.getSerialNumber());
        }
    }
}

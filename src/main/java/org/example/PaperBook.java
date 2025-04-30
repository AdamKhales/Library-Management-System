package org.example;

import java.util.Objects;

public class PaperBook extends Book {
    private int copies;
    private int pages;

    public PaperBook(String title, String author, String publisher, int serialNumber, int copies, int pages) {
        super(title, author, publisher, serialNumber);
        this.copies = copies;
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PaperBook paperBook = (PaperBook) o;
        return copies == paperBook.copies && pages == paperBook.pages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), copies, pages);
    }

    @Override
    public String toString() {
        return "PaperBook{" + super.toString() +
                "copies=" + copies +
                ", pages=" + pages +
                '}';
    }

    @Override
    public void displayInfo() {
        System.out.printf("Title: %s\nAuthor: %s\nPublisher: %s\nSerialNumber: %d\nPages: %d\nCopies: %d"
                ,getTitle(),getAuthor(),getPublisher(),getSerialNumber(), pages, copies);
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


}

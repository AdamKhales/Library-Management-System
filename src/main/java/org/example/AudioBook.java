package org.example;

import java.util.Objects;

public class AudioBook extends Book {
    private int duration;

    public AudioBook(String title, String author, String publisher, int serialNumber, int duration) {
        super(title, author, publisher, serialNumber);
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AudioBook audioBook = (AudioBook) o;
        return duration == audioBook.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration);
    }

    @Override
    public String toString() {
        return "AudioBook{" + super.toString() +
                "duration=" + duration +
                '}';
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Title: %s\nAuthor: %s\nPublisher: %s\nSerialNumber: %d\nDuration in minutes: %d\n"
                ,getTitle(),getAuthor(),getPublisher(),getSerialNumber(),duration);
    }
}

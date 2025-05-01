package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void displayInfo();

    /**
     * Searches books based on a keyword.
     * it can be the title, the author,the publisher
     * @param keyword the keyword
     * @return a List of Books containing all the books found.
     */
    public static List<Book> searchBooks(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return new ArrayList<>();
        }
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : LibraryManagementSystem.catalog) {
            if (book == null) {
                continue;
            }
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())
                    || book.getPublisher().toLowerCase().contains(keyword.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}

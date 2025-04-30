package org.example;

import java.util.*;

public class LibraryManagementSystem {
    private List<Book> catalog;
    private List<User> users;

    public LibraryManagementSystem() {
        catalog = new ArrayList<>();
        users = new ArrayList<>();
    }

    public LibraryManagementSystem(List<Book> catalog, List<User> users) {
        this.catalog = catalog;
        this.users = users;
    }

    public void addBook(Book book) {}

    public void registerUser(User user) {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryManagementSystem that = (LibraryManagementSystem) o;
        return Objects.equals(catalog, that.catalog) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalog, users);
    }

    @Override
    public String toString() {
        return "LibraryManagementSystem{" +
                "catalog=" + catalog +
                ", users=" + users +
                '}';
    }
}

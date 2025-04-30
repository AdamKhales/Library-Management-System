package org.example;

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

    public void addBook(){
        //TODO
    }

    public void removeBook(){
        //TODO
    }

    public void issueBook() {
        //TODO
    }

}

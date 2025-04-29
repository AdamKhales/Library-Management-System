package org.example;

import java.util.Objects;

public abstract class User {
    private String name;
    private int id;
    private int nextId = 1;

    public User(String name) {
        this.name = name;
        this.id = nextId++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && nextId == user.nextId && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, nextId);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", nextId=" + nextId +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }


    public abstract void displayInfo();
    

}

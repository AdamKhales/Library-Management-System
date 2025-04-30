package org.example;

import java.util.Objects;

public class Student extends User{
    private int studentId;
    private static int nextId = 1;

    public Student(String name) {
        super(name);
        this.studentId = nextId++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId);
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "studentId=" + studentId +
                '}';
    }

    @Override
    public void displayInfo() {
        System.out.printf("Student ID: %d\nName: %s", studentId, getName());
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }


}

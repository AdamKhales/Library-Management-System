package org.example;

import java.util.Objects;

public class Student extends User implements Borrowable{
    private int studentId;
    private static int nextStudentId = 1;

    public Student(String name) {
        super(name);
        this.studentId = nextStudentId++;
    }

    public Student(String name, int studentId) {
        super(name);
        this.studentId = studentId;
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

    public static int getNextStudentId() {
        return nextStudentId;
    }

    public static void setNextStudentId(int nextStudentId) {
        Student.nextStudentId = nextStudentId;
    }

    @Override
    public boolean borrowBook(Book book) {
        return false;
    }

    @Override
    public boolean returnBook(Book book) {
        return false;
    }
}

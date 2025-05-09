package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LibraryManagementSystem {
    public static List<Book> catalog = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    public static List<Book> getCatalog() {
        return catalog;
    }

    public static void setCatalog(List<Book> catalog) {
        LibraryManagementSystem.catalog = catalog;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        LibraryManagementSystem.users = users;
    }

    public static void readFile() {
        readCatalog();
        readUsers();
    }

    private static void readCatalog() {
        try (Scanner input = new Scanner(new File("catalog.csv"))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] bookInfo = line.split(",");

                String title = bookInfo[0];
                String author = bookInfo[1];
                String publisher = bookInfo[2];
                int serialNumber = Integer.parseInt(bookInfo[3]);

                if (bookInfo.length == 6) {
                    int copies = Integer.parseInt(bookInfo[4]);
                    int pages = Integer.parseInt(bookInfo[5]);
                    catalog.add(new PaperBook(title, author, publisher, serialNumber, copies, pages));
                }else {
                    int duration = Integer.parseInt(bookInfo[4]);
                    catalog.add(new AudioBook(title, author, publisher, serialNumber, duration));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void readUsers() {
        try (Scanner input = new Scanner(new File("users.csv"))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] userInfo = line.split(",");
                String type = userInfo[0];
                String name = userInfo[1];
                int id = Integer.parseInt(userInfo[2]);

                if (type.equalsIgnoreCase("librarian")) {
                    users.add(new Librarian(name, id));
                }else {
                    if (type.equalsIgnoreCase("student")) {
                        users.add(new Student(name, id));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write() {
        writeCatalog();
        writeUsers();

    }

    private static void writeCatalog() {
        try (FileWriter fw = new FileWriter("catalog.csv")) {
            for (Book book : catalog) {
                String str = book.getTitle() + "," + book.getAuthor() + "," + book.getPublisher() + "," + book.getSerialNumber() + ",";

                if (book instanceof PaperBook paperBook) {
                    str += paperBook.getCopies() + "," + paperBook.getPages() + "\n";
                }

                if (book instanceof AudioBook audioBook) {
                    str += audioBook.getDuration() + "\n";
                }

                fw.write(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeUsers() {
        try (FileWriter fw = new FileWriter("users.csv")) {
            for (User user : users) {
                if (user instanceof Librarian librarian) {
                    String str = "librarian" + "," + librarian.getName() + "," + librarian.getLibrarianId() + "\n";
                    fw.write(str);
                }

                if (user instanceof Student student) {
                    String str = "student" + "," + student.getName() + "," + student.getStudentId() + "\n";
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

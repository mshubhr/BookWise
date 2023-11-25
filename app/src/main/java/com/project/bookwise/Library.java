package com.project.bookwise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {
    private List<Book> books;
    private List<User> users;
    private static final String BOOKS_FILE = "books.dat";
    private static final String USERS_FILE = "users.dat";

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        loadBooks();
        loadUsers();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to the library: " + book.getTitle());
    }

    // Load books from file
    private void loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BOOKS_FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                books = (List<Book>) obj;
                System.out.println("Books loaded from file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            // Handle file not found or class not found exceptions
            System.err.println("Error loading books from file. Starting with an empty library.");
            books = new ArrayList<>();
        }
    }

    // Save users to file
    public void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
            System.out.println("Users saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving users to file.");
        }
    }

    // Load users from file
    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                users = (List<User>) obj;
                System.out.println("Users loaded from file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            // Handle file not found or class not found exceptions
            System.err.println("Error loading users from file. Starting with an empty user list.");
            users = new ArrayList<>();
        }
    }

    // New method: Checkout a book
    public boolean checkoutBook(Book book, User user) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            user.borrowBook(book);
            System.out.println("Book '" + book.getTitle() + "' checked out by " + user.getUsername());
            return true;
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not available for borrowing.");
            return false;
        }
    }

    // New method: Return a book
    public boolean returnBook(Book book, User user) {
        if (user.getBorrowedBooks().contains(book)) {
            book.setAvailable(true);
            user.returnBook(book);
            System.out.println("Book '" + book.getTitle() + "' returned by " + user.getUsername());
            return true;
        } else {
            System.out.println("You did not borrow this book from the library.");
            return false;
        }
    }
}

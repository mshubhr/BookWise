package com.project.bookwise;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Getter methods

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    // Methods for adding and removing books/users

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to the library: " + book.getTitle());
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book removed from the library: " + book.getTitle());
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added to the library: " + user.getUsername());
    }

    public void removeUser(User user) {
        if (users.remove(user)) {
            System.out.println("User removed from the library: " + user.getUsername());
        } else {
            System.out.println("User not found in the library.");
        }
    }

    // Other methods for library functionality

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Method to allow users to add new books
    public void userAddBook(User user, Book book) {
        if (users.contains(user)) {
            if (!books.contains(book)) {
                addBook(book);
            } else {
                System.out.println("Book already exists in the library.");
            }
        } else {
            System.out.println("User not found in the library. Please add the user first.");
        }
    }

    // Override toString for user-friendly representation
    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", users=" + users +
                '}';
    }
}

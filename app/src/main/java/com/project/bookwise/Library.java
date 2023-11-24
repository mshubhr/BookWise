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

    public boolean checkoutBook(Book book, User user) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            return true;
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not available for borrowing.");
            return false;
        }
    }

    public boolean returnBook(Book book, User user) {
        if (user.getBorrowedBooks().contains(book)) {
            book.setAvailable(true);
            return true;
        } else {
            System.out.println("You did not borrow this book from the library.");
            return false;
        }
    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayUsers() {
        System.out.println("Users in the library:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", users=" + users +
                '}';
    }
}

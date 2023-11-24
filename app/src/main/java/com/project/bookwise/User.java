package com.project.bookwise;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Book> borrowedBooks;

    public User(String username) {
        this.username = username;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getter methods
    public String getUsername() {
        return username;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Methods for borrowing and returning books
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println("Book '" + book.getTitle() + "' borrowed by " + username);
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println("Book '" + book.getTitle() + "' returned by " + username);
        } else {
            System.out.println("You did not borrow this book.");
        }
    }

    // Override toString for user-friendly representation
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}

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

    public String getUsername() {
        return username;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Library library, Book book) {
        if (library.checkoutBook(book, this)) {
            borrowedBooks.add(book);
            System.out.println("Book '" + book.getTitle() + "' borrowed by " + username);
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not available for borrowing.");
        }
    }

    public void returnBook(Library library, Book book) {
        if (library.returnBook(book, this)) {
            borrowedBooks.remove(book);
            System.out.println("Book '" + book.getTitle() + "' returned by " + username);
        } else {
            System.out.println("You did not borrow this book from the library.");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}

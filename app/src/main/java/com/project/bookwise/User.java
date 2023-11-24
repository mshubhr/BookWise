package com.project.bookwise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
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

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println("Book '" + book.getTitle() + "' borrowed by " + username);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println("Book '" + book.getTitle() + "' returned by " + username);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}

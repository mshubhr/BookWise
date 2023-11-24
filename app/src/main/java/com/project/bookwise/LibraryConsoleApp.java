package com.project.bookwise;

import java.util.Scanner;

public class LibraryConsoleApp {
    private static Library library;
    private static User currentUser;

    public static void main(String[] args) {
        library = new Library();
        currentUser = null;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMainMenu();
            int choice;

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    handleLogin(scanner);
                    break;
                case 2:
                    handleBrowseBooks();
                    break;
                case 3:
                    handleViewBorrowedBooks();
                    break;
                case 4:
                    handleLogout();
                    break;
                case 5:
                    handleExit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n===== Library Management System =====");
        System.out.println("1. Login");
        System.out.println("2. Browse Books");
        System.out.println("3. View Borrowed Books");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleLogin(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        User user = findUser(username);

        if (user != null) {
            currentUser = user;
            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
        } else {
            System.out.println("User not found. Please try again.");
        }
    }

    private static User findUser(String username) {
        for (User user : library.getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private static void handleBrowseBooks() {
        if (library.getBooks().isEmpty()) {
            System.out.println("\nNo books available in the library.");
            return;
        }

        System.out.println("\n===== Available Books =====");
        for (Book book : library.getBooks()) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    private static void handleViewBorrowedBooks() {
        if (currentUser == null || currentUser.getBorrowedBooks().isEmpty()) {
            System.out.println("\nYou have not borrowed any books.");
            return;
        }

        System.out.println("\n===== Borrowed Books =====");
        for (Book book : currentUser.getBorrowedBooks()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    private static void handleLogout() {
        if (currentUser == null) {
            System.out.println("You are not logged in.");
            return;
        }

        currentUser = null;
        System.out.println("Logout successful. Goodbye!");
    }

    private static void handleExit() {
        System.out.println("Exiting Library Management System. Goodbye!");
        System.exit(0);
    }
}

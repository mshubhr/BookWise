package com.project.bookwise;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Book> bookList;
    private BookAdapter bookAdapter;
    private Library library;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Library, User, and bookList
        library = new Library();
        user = new User("JohnDoe");
        bookList = new ArrayList<>();
        bookAdapter = new BookAdapter(this, R.layout.book_item, bookList);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(bookAdapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAndBorrowBook();
            }
        });

        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnBook();
            }
        });
    }

    private void addAndBorrowBook() {
        // Create a new book
        Book newBook = new Book("New Book Title", "New Book Author");

        // Add the book to the library
        library.addBook(newBook);

        // Borrow the book for the user
        user.borrowBook(library, newBook);

        // Update the bookList and notify the adapter
        bookList.add(newBook);
        bookAdapter.notifyDataSetChanged();
    }

    private void returnBook() {
        if (!user.getBorrowedBooks().isEmpty()) {
            // Simulate returning the first borrowed book
            Book bookToReturn = user.getBorrowedBooks().get(0);

            // Return the book to the library
            user.returnBook(library, bookToReturn);

            // Update the bookList and notify the adapter
            bookList.remove(bookToReturn);
            bookAdapter.notifyDataSetChanged();
        } else {
            // Inform the user that they have no books to return
            System.out.println("You have no books to return.");
        }
    }
}
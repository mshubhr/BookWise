package com.project.bookwise;

import android.os.Bundle;
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

        library = new Library();
        user = new User("JohnDoe");
        bookList = new ArrayList<>();
        bookAdapter = new BookAdapter(this, R.layout.book_item, bookList);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(bookAdapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> addAndBorrowBook());

        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(v -> returnBook());
    }

    private void addAndBorrowBook() {
        Book newBook = new Book("New Book Title", "New Book Author");

        library.addBook(newBook);

        library.checkoutBook(newBook, user);

        bookList.add(newBook);
        bookAdapter.notifyDataSetChanged();
    }

    private void returnBook() {
        if (!user.getBorrowedBooks().isEmpty()) {
            Book bookToReturn = user.getBorrowedBooks().get(0);

            library.returnBook(bookToReturn, user);

            bookList.remove(bookToReturn);
            bookAdapter.notifyDataSetChanged();
        } else {
            System.out.println("You have no books to return.");
        }
    }
}
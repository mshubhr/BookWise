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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = new ArrayList<>();
        bookAdapter = new BookAdapter(this, R.layout.book_item, bookList);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(bookAdapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBook();
            }
        });
    }

    private void addBook() {
        // This is a placeholder method. In a real project, you would open a new activity or dialog to add a book.
        // For simplicity, we just add a dummy book here.
        Book book = new Book("New Book", "Unknown Author");
        bookList.add(book);
        bookAdapter.notifyDataSetChanged();
    }
}

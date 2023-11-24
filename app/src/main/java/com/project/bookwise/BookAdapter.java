package com.project.bookwise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    private Context context;
    private int resource;

    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> books) {
        super(context, resource, books);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView authorTextView = convertView.findViewById(R.id.authorTextView);

        Book book = getItem(position);

        if (book != null) {
            titleTextView.setText(book.getTitle());
            authorTextView.setText(book.getAuthor());
        }

        return convertView;
    }
}

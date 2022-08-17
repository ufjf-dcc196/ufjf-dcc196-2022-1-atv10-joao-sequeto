package com.example.atividade6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerBooks;
    private BookAdapter bookAdapter;
    List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        books = new ArrayList<Book>(){{
            add(new Book("1984"));
            add(new Book("Cidade do Sol"));
        }};

        recyclerBooks = findViewById(R.id.recyclerViewBooks);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerBooks.setLayoutManager(layoutManager);

        BookAdapter.OnBookClickListener listener = new BookAdapter.OnBookClickListener() {
            @Override
            public void OnBookClick(View source, int position) {
                Book book = books.get(position);
                bookAdapter.notifyItemChanged(position);
            }
        };

        bookAdapter = new BookAdapter(books, listener);
        recyclerBooks.setAdapter(bookAdapter);
    }
}
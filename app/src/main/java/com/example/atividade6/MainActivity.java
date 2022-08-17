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
    private AppDatabase database;
    List<Book> books;

    private List<Book> loadBooksList(){
        database = AppDatabase.getInstance(this.getApplicationContext());
        List<Book> books = database.bookDao().getAllBooks();

        return books;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        books = new ArrayList<Book>(){{
            add(new Book("1984"));
            add(new Book("Cidade do Sol"));
        }};

        database = AppDatabase.getInstance(this.getApplicationContext());
//        database.bookDao().insertBook(books.get(0));
//        books = loadBooksList();

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
package com.example.atividade6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<Book> books;
    private OnBookClickListener listener;

    public BookAdapter(List<Book> books, OnBookClickListener listener) {
        this.books = books;
        this.listener = listener;
    }

    @Override
    public int getItemCount(){
        return books.size();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context contexto = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View bookView = inflater.inflate(R.layout.book_layout, parent, false);
        BookViewHolder holder = new BookViewHolder(bookView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.textViewTitle.setText(book.getTitle());
        holder.textViewAuthor.setText(book.getAuthor());
        holder.textViewStatus.setText(book.getStatus());
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewAuthor;
        private TextView textViewStatus;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewBookSetTitle);
            textViewAuthor = itemView.findViewById(R.id.textViewBookSetAuthor);
            textViewStatus = itemView.findViewById(R.id.textViewSetStatus);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnBookClick(v, getAdapterPosition());
                }
            });
        }
    }

    public interface OnBookClickListener {
        void OnBookClick(View source, int position);
    }


}

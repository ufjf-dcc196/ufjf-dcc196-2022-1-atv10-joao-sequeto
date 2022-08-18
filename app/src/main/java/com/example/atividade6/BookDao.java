package com.example.atividade6;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {
    @Insert
    void insertBook(Book book);

    @Update
    void saveBook(Book book);

    @Query("SELECT * from Book")
    List<Book> getAllBooks();
}

package com.example.atividade6;

import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "book_app_db";
    private static AppDatabase INSTANCE;

    public abstract BookDao bookDao();

    public static AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DB_NAME
            ).allowMainThreadQueries().build();
        }

        return INSTANCE;
    }
}

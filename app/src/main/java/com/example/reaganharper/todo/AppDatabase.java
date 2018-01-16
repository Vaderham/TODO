package com.example.reaganharper.todo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.WorkerThread;


@Database(entities = {ToDoItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ToDoDao toDoDao();

    private static AppDatabase INSTANCE;

    @WorkerThread
    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "todos")
                    .allowMainThreadQueries() // TODO: 13/01/18 Put this on a background thread
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
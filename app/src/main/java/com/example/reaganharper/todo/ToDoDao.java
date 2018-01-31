package com.example.reaganharper.todo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ToDoDao {

    @Query("SELECT * FROM todos")
    List<ToDoItem> getAll();

    @Insert
    void insertAll(ToDoItem... toDoItems);

    @Insert
    void insertOneItem(ToDoItem... todoItem);
}

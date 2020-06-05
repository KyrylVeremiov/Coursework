package com.example.coursework;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HistoryDao {

    @Query("SELECT * FROM HistoryRecord")
    List<HistoryRecord> getAll();

    @Query("SELECT * FROM HistoryRecord WHERE id = :id")
    HistoryRecord getById(String id);

    @Insert
    void insert(HistoryRecord record);

    @Insert
    void insertAll(HistoryRecord... records);

    @Update
    void update(HistoryRecord record);

    @Delete
    void delete(HistoryRecord record);

}


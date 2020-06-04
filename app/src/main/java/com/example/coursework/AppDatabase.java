package com.example.coursework;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {HistoryRecord.class}, version = 1)//+query_time +user
public abstract class AppDatabase extends RoomDatabase {
    public abstract HistoryDao historyDao();
}
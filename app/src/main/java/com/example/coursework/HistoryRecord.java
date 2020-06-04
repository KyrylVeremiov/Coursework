package com.example.coursework;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HistoryRecord {
    HistoryRecord(String id,String title, String href){
        this.id=id;
        this.title=title;
        this.href=href;
    }
    @PrimaryKey
    @NonNull
    public String id;

    @ColumnInfo(name="title")
    public String title;

    @ColumnInfo(name="href")
    public String href;

}

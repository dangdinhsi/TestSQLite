package com.dangdinhsi.ss9;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;
    public abstract UserDAO userDAO();
    public static AppDatabase getAppDatabase(Context context){
        if(appDatabase ==null){
            appDatabase = Room.databaseBuilder(context,AppDatabase.class,"UserDB").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}

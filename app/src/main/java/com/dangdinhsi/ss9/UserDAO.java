package com.dangdinhsi.ss9;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDAO {
    @Insert(onConflict = REPLACE)
    void insertUser(User user);

    @Update
    void updateUser(User updateUser);

    @Delete
    void deleteUser(User deleteUser);

    @Query("SELECT * FROM user WHERE id=:id")
    User getUser(int id);

    @Query("SELECT * FROM user")
    List<User> getAllUser();

    @Query("DELETE FROM user")
    void deleteAllUser();
}

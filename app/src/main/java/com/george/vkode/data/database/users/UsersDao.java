package com.george.vkode.data.database.users;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UsersDao {

    @Insert
    void insert(LocalUser user);

    @Update
    void update(LocalUser user);

    @Delete
    void delete(LocalUser user);

    @Query("SELECT * FROM users_table WHERE userId LIKE :userId")
    LocalUser getUserById(int userId);

    @Query("SELECT * FROM users_table")
    LiveData<List<LocalUser>> getAllUsers();

}

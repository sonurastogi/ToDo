package com.example.taskmanagement;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertrecord(User users);


    @Query("SELECT EXISTS(SELECT * FROM User WHERE uid = :userId)")
    Boolean is_exist(int userId);


    @Query("SELECT * FROM User")
    List<User> getallusers();

    @Query("DELETE FROM User WHERE uid = :id")
    void deleteById(int id);


    @Query("UPDATE User SET first_name=:first_name, last_name=:last_name where uid=:id")
    void updateById(int id, String first_name, String last_name);

   // void updateById(int uid, String string, String string1);
}

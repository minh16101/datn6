package com.example.testdbentity.login.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LoginDAO {
    @Insert
    public void createAccount(LoginEntity loginEntity);

    //lay ra thong tin email de kiem tra xem email da ton tai chua
    @Query("SELECT * FROM login_table WHERE account_email_name = :email")
    public LiveData<LoginEntity> getAccountSameEmail(String email);

    @Query("SELECT * FROM login_table")
    public List<LoginEntity> getAll();
}

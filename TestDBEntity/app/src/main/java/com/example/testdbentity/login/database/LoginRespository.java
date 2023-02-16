package com.example.testdbentity.login.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.testdbentity.login.database.LoginDAO;
import com.example.testdbentity.login.database.LoginDatabase;
import com.example.testdbentity.login.database.LoginEntity;

import java.util.List;

public class LoginRespository {
    public LoginDAO loginDAO;
    public LoginRespository(Application application)
    {
        LoginDatabase loginDatabase = LoginDatabase.getDatabase(application);
        loginDAO = loginDatabase.loginDAO();
    }
    public void createAccount(LoginEntity loginEntity)
    {
        LoginDatabase.databaseWriteExecutor.execute(()->{
            loginDAO.createAccount(loginEntity);
        });
    }
    public LiveData<LoginEntity> getAccountSameEmail(String email)
    {
        return loginDAO.getAccountSameEmail(email);
    }
    public List<LoginEntity> getAll()
    {
        return loginDAO.getAll();
    }
}

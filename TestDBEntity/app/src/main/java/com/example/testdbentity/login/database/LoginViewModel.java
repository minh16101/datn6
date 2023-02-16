package com.example.testdbentity.login.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    public LoginRespository loginRespository;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginRespository = new LoginRespository(application);
    }
    public void createAccount(LoginEntity loginEntity)
    {
        loginRespository.createAccount(loginEntity);
    }
    public LiveData<LoginEntity> getAccountSameEmail(String email)
    {
        return loginRespository.getAccountSameEmail(email);
    }
    public List<LoginEntity> getAll()
    {
        return loginRespository.getAll();
    }
}

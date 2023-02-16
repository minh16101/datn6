package com.example.testdbentity.login.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "login_table")
public class LoginEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "account_id")
    public int idAccount;
    @NonNull
    @ColumnInfo(name = "account_first_name")
    public String nameFirstAccount;
    @NonNull
    @ColumnInfo(name = "account_last_name")
    public String nameLastAccount;
    @NonNull
    @ColumnInfo(name = "account_email_name")
    public String nameEmailAccount;
    @NonNull
    @ColumnInfo(name = "account_password")
    public String passwordAccount;
    @NonNull
    @ColumnInfo(name = "account_phone")
    public String phoneAccount;

    public LoginEntity(@NonNull String nameFirstAccount, @NonNull String nameLastAccount, @NonNull String nameEmailAccount, @NonNull String passwordAccount, @NonNull String phoneAccount) {
        this.nameFirstAccount = nameFirstAccount;
        this.nameLastAccount = nameLastAccount;
        this.nameEmailAccount = nameEmailAccount;
        this.passwordAccount = passwordAccount;
        this.phoneAccount = phoneAccount;
    }
}

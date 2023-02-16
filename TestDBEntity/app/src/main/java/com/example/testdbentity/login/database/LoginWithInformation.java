package com.example.testdbentity.login.database;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.login.database.LoginEntity;

public class LoginWithInformation {
    @Embedded
    public LoginEntity loginEntity;

    @Relation(
            parentColumn = "account_id",
            entityColumn = "information_user_fk"
    )
    public InformationEntity informationEntity;

}
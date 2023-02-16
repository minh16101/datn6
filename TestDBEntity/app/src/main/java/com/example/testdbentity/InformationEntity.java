package com.example.testdbentity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "information_user")
public class InformationEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "information_user_id")
    public int idInformationUser;
    @NonNull
    @ColumnInfo(name = "information_user_firstname")
    public String firstNaeInformationUser;

    @NonNull
    @ColumnInfo(name = "information_user_lastname")
    public String lastNaeInformationUser;

    @NonNull
    @ColumnInfo(name = "information_user_number")
    public String numberInformationUser;

    @ColumnInfo(name = "information_user_avater")
    public String avatarInformationUser;

    @NonNull
    @ColumnInfo(name = "information_user_address")
    public String addressInformationUser;

    @NonNull
    @ColumnInfo(name = "information_user_gioitinh")
    public int gioiTinhInformationUser;

    @NonNull
    @ColumnInfo(name = "information_user_email")
    public String emailInformationUser;

    @NonNull
    @ColumnInfo(name = "information_user_booking")
    public int isBookingroom;

    @NonNull
    @ColumnInfo(name = "information_user_fk")
    public int foreignKeyInformationUser;

    public InformationEntity(@NonNull String firstNaeInformationUser, @NonNull String lastNaeInformationUser, @NonNull String numberInformationUser, int gioiTinhInformationUser, @NonNull String emailInformationUser) {
        this.firstNaeInformationUser = firstNaeInformationUser;
        this.lastNaeInformationUser = lastNaeInformationUser;
        this.numberInformationUser = numberInformationUser;
        this.gioiTinhInformationUser = gioiTinhInformationUser;
        this.emailInformationUser = emailInformationUser;
        this.isBookingroom = 0;
        this.addressInformationUser = "";
    }
}

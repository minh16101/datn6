package com.example.testdbentity.homefragment.bookingcar.userwithcar;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"booking_car_id","information_user_id"})
public class UserAndCarREF {
    @ColumnInfo(name = "booking_car_id")
    public int idCar;
    @ColumnInfo(name = "information_user_id")
    public int idPeople;

    public UserAndCarREF(int idCar, int idPeople) {
        this.idCar = idCar;
        this.idPeople = idPeople;
    }
}

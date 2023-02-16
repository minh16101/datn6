package com.example.testdbentity.homefragment.bookingcar.userwithseat;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"booking_seat_id","information_user_id"})
public class UserAndSeatREF {
    @ColumnInfo(name = "booking_seat_id")
    public int idSeat;
    @ColumnInfo(name = "information_user_id")
    public int idPeople;

    public UserAndSeatREF(int idSeat, int idPeople) {
        this.idSeat = idSeat;
        this.idPeople = idPeople;
    }
}

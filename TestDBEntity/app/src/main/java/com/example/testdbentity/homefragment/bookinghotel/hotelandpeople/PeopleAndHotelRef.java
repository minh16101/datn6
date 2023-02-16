package com.example.testdbentity.homefragment.bookinghotel.hotelandpeople;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"booking_hotel_id","information_user_id"})
public class PeopleAndHotelRef {
    @ColumnInfo(name = "booking_hotel_id")
    public int idHotel;
    @ColumnInfo(name = "information_user_id")
    public int idPeople;

    public PeopleAndHotelRef(int idHotel, int idPeople) {
        this.idHotel = idHotel;
        this.idPeople = idPeople;
    }
}

package com.example.testdbentity.homefragment.bookinghotel.roomandpeople;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"booking_room_id","information_user_id"})
public class PeopleAndRoomRef {
    @ColumnInfo(name = "booking_room_id")
    public int idRoom;
    @ColumnInfo(name = "information_user_id")
    public int idPeople;

    public PeopleAndRoomRef(int idRoom, int idPeople) {
        this.idRoom = idRoom;
        this.idPeople = idPeople;
    }
}

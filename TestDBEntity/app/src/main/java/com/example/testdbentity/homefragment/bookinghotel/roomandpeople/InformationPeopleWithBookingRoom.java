package com.example.testdbentity.homefragment.bookinghotel.roomandpeople;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookinghotel.BookingRoomEntity;

import java.util.List;

public class InformationPeopleWithBookingRoom {
    @Embedded
    public InformationEntity informationEntity;
    @Relation(
            parentColumn = "information_user_id",
            entityColumn = "booking_room_id",
            associateBy = @Junction(PeopleAndRoomRef.class)
    )
    public List<BookingRoomEntity> bookingRoomEntityList;
}

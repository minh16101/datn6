package com.example.testdbentity.homefragment.bookinghotel.roomandpeople;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookinghotel.BookingRoomEntity;

import java.util.List;

public class BookingRoomWithInformationPeople {
    @Embedded
    public BookingRoomEntity bookingRoomEntity;
    @Relation(
            parentColumn = "booking_room_id",
            entityColumn = "information_user_id",
            associateBy = @Junction(PeopleAndRoomRef.class)
    )
    public List<InformationEntity> informationEntities;
}

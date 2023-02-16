package com.example.testdbentity.homefragment.bookingcar.userwithseat;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingSeatEntity;

import java.util.List;

public class SeatWithUser {
    @Embedded
    public BookingSeatEntity bookingSeatEntity;

    @Relation(
            parentColumn = "booking_seat_id",
            entityColumn = "information_user_id",
            associateBy = @Junction(UserAndSeatREF.class)
    )
    public List<InformationEntity> informationEntityList;
}

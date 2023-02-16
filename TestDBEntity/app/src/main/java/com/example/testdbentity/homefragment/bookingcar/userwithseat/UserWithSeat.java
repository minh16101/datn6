package com.example.testdbentity.homefragment.bookingcar.userwithseat;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingSeatEntity;

import java.util.List;

public class UserWithSeat {
    @Embedded
    public InformationEntity informationEntity;

    @Relation(
            parentColumn = "information_user_id",
            entityColumn = "booking_seat_id",
            associateBy = @Junction(UserAndSeatREF.class)
    )
    public List<BookingSeatEntity> bookingSeatEntityList;
}

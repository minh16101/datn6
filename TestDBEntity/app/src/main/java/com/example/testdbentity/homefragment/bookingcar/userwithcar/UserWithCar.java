package com.example.testdbentity.homefragment.bookingcar.userwithcar;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingCarEntity;

import java.util.List;

public class UserWithCar {
    @Embedded
    public InformationEntity informationEntity;

    @Relation(
            parentColumn = "information_user_id",
            entityColumn = "booking_car_id",
            associateBy = @Junction(UserAndCarREF.class)
    )
    public List<BookingCarEntity> bookingCarEntities;
}

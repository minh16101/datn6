package com.example.testdbentity.homefragment.bookingcar.userwithcar;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingCarEntity;

import java.util.List;

public class CarWithUser {
    @Embedded
    public BookingCarEntity bookingCarEntity;

    @Relation(
            parentColumn = "booking_car_id",
            entityColumn = "information_user_id",
            associateBy = @Junction(UserAndCarREF.class)
    )
    public List<InformationEntity> informationEntityList;
}

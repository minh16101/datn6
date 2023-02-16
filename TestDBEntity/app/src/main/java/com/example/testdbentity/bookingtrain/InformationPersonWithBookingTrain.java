package com.example.testdbentity.bookingtrain;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.testdbentity.InformationEntity;

import java.util.List;

public class InformationPersonWithBookingTrain{
    @Embedded
    public InformationEntity informationEntity;
    @Relation(
            parentColumn = "information_user_id",
            entityColumn = "booking_train_fk"
    )
    public List<BookingTrainEntity> bookingTrainEntities;
}

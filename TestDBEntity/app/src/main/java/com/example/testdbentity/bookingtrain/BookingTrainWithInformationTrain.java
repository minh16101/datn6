package com.example.testdbentity.bookingtrain;

import androidx.room.Embedded;
import androidx.room.Relation;

public class BookingTrainWithInformationTrain {
    @Embedded
    public BookingTrainEntity bookingTrainEntity;
    @Relation(
            parentColumn = "booking_train_id",
            entityColumn = "information_train_fk"
    )
    public InformationTrainOfBookingTrain informationTrainOfBookingTrain;
}

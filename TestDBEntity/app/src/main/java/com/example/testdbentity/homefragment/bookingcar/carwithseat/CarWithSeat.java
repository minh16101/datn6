package com.example.testdbentity.homefragment.bookingcar.carwithseat;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.testdbentity.homefragment.bookingcar.BookingCarEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingSeatEntity;

import java.util.List;

public class CarWithSeat {
    @Embedded
    public BookingCarEntity bookingCarEntity;
    @Relation(
            parentColumn = "booking_car_id",
            entityColumn = "booking_seat_fk"
    )
    public List<BookingSeatEntity> bookingSeatEntityList;
}

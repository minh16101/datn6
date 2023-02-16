package com.example.testdbentity.homefragment.bookinghotel.hotelandpeople;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookinghotel.BookingHotelEntity;

import java.util.List;

public class InformationPeopleWithBookingHotel {
    @Embedded public InformationEntity informationEntity;
    @Relation(
            parentColumn = "information_user_id",
            entityColumn = "booking_hotel_id",
            associateBy = @Junction(PeopleAndHotelRef.class)
    )
    public List<BookingHotelEntity> bookingHotelEntities;
}

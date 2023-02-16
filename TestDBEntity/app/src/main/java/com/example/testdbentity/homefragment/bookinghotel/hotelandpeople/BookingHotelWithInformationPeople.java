package com.example.testdbentity.homefragment.bookinghotel.hotelandpeople;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookinghotel.BookingHotelEntity;

import java.util.List;

public class BookingHotelWithInformationPeople {
    @Embedded
    public BookingHotelEntity bookingHotelEntity;
    @Relation(
            parentColumn = "booking_hotel_id",
            entityColumn = "information_user_id",
            associateBy = @Junction(PeopleAndHotelRef.class)
    )
    public List<InformationEntity> informationEntities;
}

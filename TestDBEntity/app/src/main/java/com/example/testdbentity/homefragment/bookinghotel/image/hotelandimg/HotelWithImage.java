package com.example.testdbentity.homefragment.bookinghotel.image.hotelandimg;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.testdbentity.homefragment.bookinghotel.BookingHotelEntity;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageHotel;

import java.util.List;

public class HotelWithImage {
    @Embedded
    public BookingHotelEntity bookingHotelEntity;
    @Relation(
            parentColumn = "booking_hotel_id",
            entityColumn = "image_hotel_fk"
    )
    public List<ImageHotel> imageHotelList;
}
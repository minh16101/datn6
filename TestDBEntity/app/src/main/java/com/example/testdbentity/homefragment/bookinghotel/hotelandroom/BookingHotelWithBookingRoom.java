package com.example.testdbentity.homefragment.bookinghotel.hotelandroom;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.testdbentity.homefragment.bookinghotel.BookingHotelEntity;
import com.example.testdbentity.homefragment.bookinghotel.BookingRoomEntity;

import java.util.List;

public class BookingHotelWithBookingRoom {
    @Embedded public BookingHotelEntity bookingHotelEntity;
    @Relation(
            parentColumn = "booking_hotel_id",
            entityColumn = "booking_room_fk"
    )
    public List<BookingRoomEntity> bookingRoomEntityList;
}

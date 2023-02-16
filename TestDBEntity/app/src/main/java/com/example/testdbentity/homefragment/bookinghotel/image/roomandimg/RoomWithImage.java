package com.example.testdbentity.homefragment.bookinghotel.image.roomandimg;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.testdbentity.homefragment.bookinghotel.BookingRoomEntity;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageRoom;

import java.util.List;

public class RoomWithImage {
    @Embedded
    public BookingRoomEntity bookingRoomEntity;
    @Relation(
            parentColumn = "booking_room_id",
            entityColumn = "image_room_fk"
    )
    public List<ImageRoom> imageRooms;
}

package com.example.testdbentity.homefragment.bookinghotel;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "booking_room_table")
public class BookingRoomEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "booking_room_id")
    public int idBookingRoom;
    @ColumnInfo(name = "booking_room_name")
    public String nameBookingRoom;

    @ColumnInfo(name = "booking_room_people")
    public int peopleBookingRoom;

    @ColumnInfo(name = "booking_room_price")
    public long priceBookingRoom;

    //new
    @ColumnInfo(name = "booking_room_day")
    public int day;

    @ColumnInfo(name = "booking_room_month")
    public int month;

    @ColumnInfo(name = "booking_room_year")
    public int year;

    @ColumnInfo(name = "booking_during_year")
    public int during;
    //end new
    @ColumnInfo(name = "booking_room_noti")
    public String notiBookingHotel;

    @ColumnInfo(name = "booking_room_dientich")
    public int dientichBookingHotel;

    @ColumnInfo(name = "booking_room_isbooking")
    public int isBookingRoom;

    @ColumnInfo(name = "booking_room_id_userbooking")
    public int idUserBookingRoom;

    @ColumnInfo(name = "booking_room_fk")
    public int fkBookingRoom;

    public BookingRoomEntity(String nameBookingRoom, int peopleBookingRoom, long priceBookingRoom, String notiBookingHotel, int isBookingRoom, int fkBookingRoom) {
        this.nameBookingRoom = nameBookingRoom;
        this.peopleBookingRoom = peopleBookingRoom;
        this.priceBookingRoom = priceBookingRoom;
        this.notiBookingHotel = notiBookingHotel;
        this.isBookingRoom = isBookingRoom;
        this.fkBookingRoom = fkBookingRoom;
        this.idUserBookingRoom = 0;
    }
}
package com.example.testdbentity.homefragment.bookinghotel;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "booking_hotel_table")
public class BookingHotelEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "booking_hotel_id")
    public int idBookingHotel;
    @ColumnInfo(name = "booking_hotel_name")
    public String nameBookingHotel;
    @ColumnInfo(name = "booking_hotel_like")
    public int likeBookingHotel;
    @ColumnInfo(name = "booking_hotel_quan")
    public String quanBookingHotel;
    @ColumnInfo(name = "booking_hotel_city")
    public String cityBookingHotel;
    @ColumnInfo(name = "booking_hotel_address")
    public String addressBookingHotel;
    @ColumnInfo(name = "booking_hotel_noti")
    public String notiBookingHotel;

    public BookingHotelEntity(String nameBookingHotel, int likeBookingHotel, String quanBookingHotel, String addressBookingHotel, String notiBookingHotel, String cityBookingHotel) {
        this.nameBookingHotel = nameBookingHotel;
        this.likeBookingHotel = likeBookingHotel;
        this.quanBookingHotel = quanBookingHotel;
        this.addressBookingHotel = addressBookingHotel;
        this.notiBookingHotel = notiBookingHotel;
        this.cityBookingHotel = cityBookingHotel;
    }
}

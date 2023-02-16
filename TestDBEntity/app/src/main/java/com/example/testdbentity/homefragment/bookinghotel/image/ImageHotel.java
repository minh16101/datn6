package com.example.testdbentity.homefragment.bookinghotel.image;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "image_hotel_table")
public class ImageHotel {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "image_hotel_id")
    public int idImageHotel;

    @ColumnInfo(name = "image_hotel_src")
    public int srcImageHotel;

    //khoa ngoai tham chieu dem hotelentity
    @ColumnInfo(name = "image_hotel_fk")
    public int fkImageHotel;

    public ImageHotel(int srcImageHotel, int fkImageHotel) {
        this.srcImageHotel = srcImageHotel;
        this.fkImageHotel = fkImageHotel;
    }
}

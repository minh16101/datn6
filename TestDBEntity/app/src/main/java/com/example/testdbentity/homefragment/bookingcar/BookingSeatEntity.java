package com.example.testdbentity.homefragment.bookingcar;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "booking_seat_table")
public class BookingSeatEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "booking_seat_id")
    public int idBookingSeat;

    @ColumnInfo(name = "booking_seat_name")
    public String nameBookingSeat;

    @ColumnInfo(name = "booking_seat_isfull")
    public int isFullBookingSeat;

    @ColumnInfo(name = "booking_seat_choosing")
    public int isChoosingSeat;

    @ColumnInfo(name = "booking_seat_fk")
    public int fkBookingSeat;

    @ColumnInfo(name = "booking_seat_price")
    public int priceBookingSeat;

    public BookingSeatEntity(String nameBookingSeat, int fkBookingSeat, int priceBookingSeat) {
        this.nameBookingSeat = nameBookingSeat;
        this.isFullBookingSeat = 0;
        this.isChoosingSeat = 0;
        this.priceBookingSeat = priceBookingSeat;
        this.fkBookingSeat = fkBookingSeat;
    }
}

package com.example.testdbentity.homefragment.bookingcar;

import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "booking_car_table")
public class BookingCarEntity
{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "booking_car_id")
    public int idBookingCar;
    @ColumnInfo(name = "booking_car_name")
    public String nameBookingCar;

    @ColumnInfo(name = "booking_car_startPlace")
    public String startPlaceBookingCar;

    @ColumnInfo(name = "booking_car_src")
    public int srcBookingCar;

    @ColumnInfo(name = "booking_car_endPlace")
    public String endPlaceBookingCar;

    @ColumnInfo(name = "booking_car_upPlace")
    public String upPlaceBookingCar;

    @ColumnInfo(name = "booking_car_downPlace")
    public String downPlaceBookingCar;

    @ColumnInfo(name = "booking_car_day")
    public int dayBookingCar;

    @ColumnInfo(name = "booking_car_month")
    public int monthBookingCar;

    @ColumnInfo(name = "booking_car_year")
    public int yearBookingCar;

    @ColumnInfo(name = "booking_car_number")
    public int numberSeatBookingCar;

    @ColumnInfo(name = "booking_car_isfull")
    public int isFullBookingCar;

    public BookingCarEntity(String nameBookingCar, String startPlaceBookingCar, String endPlaceBookingCar, String upPlaceBookingCar, String downPlaceBookingCar, int dayBookingCar, int monthBookingCar, int yearBookingCar, int numberSeatBookingCar, int srcBookingCar) {
        this.nameBookingCar = nameBookingCar;
        this.startPlaceBookingCar = startPlaceBookingCar;
        this.endPlaceBookingCar = endPlaceBookingCar;
        this.upPlaceBookingCar = upPlaceBookingCar;
        this.downPlaceBookingCar = downPlaceBookingCar;
        this.dayBookingCar = dayBookingCar;
        this.monthBookingCar = monthBookingCar;
        this.yearBookingCar = yearBookingCar;
        this.numberSeatBookingCar = numberSeatBookingCar;
        this.srcBookingCar = srcBookingCar;
        this.isFullBookingCar = 0;
    }
}

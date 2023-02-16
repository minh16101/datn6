package com.example.testdbentity.bookingtrain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "booking_train_table")
public class BookingTrainEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "booking_train_id")
    private int idBookingTrain;
    @ColumnInfo(name = "booking_train_from")
    private String fromBookingTrain;
    @ColumnInfo(name = "booking_train_to")
    private String toBookingTrain;

    @ColumnInfo(name = "booking_train_time")
    private Date dateTimeBookingTrain;

    @ColumnInfo(name = "booking_train_people_adult")
    private int peopleAdultBookingTrain;

    @ColumnInfo(name = "booking_train_people_child")
    private int peopleChildBookingTrain;

    @ColumnInfo(name = "booking_train_people_student")
    private int peopleStudentBookingTrain;

    @ColumnInfo(name = "booking_train_people_old")
    private int peopleOldBookingTrain;

    @ColumnInfo(name = "booking_train_seat")
    private int seatingBookingTrain;

    @ColumnInfo(name = "booking_train_fk")
    private int informationForeignKey;
}

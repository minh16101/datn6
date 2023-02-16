package com.example.testdbentity.bookingtrain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "informationTrain_of_booking_table")
public class InformationTrainOfBookingTrain {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "information_train_id")
    private int idInformationTrain;

    @ColumnInfo(name = "information_train_name")
    private String nameInformationTrain;

    @ColumnInfo(name = "information_train_name_toa")
    private String nameToaInformationTrain;

    @ColumnInfo(name = "information_train_number_seat")
    private int numberSeatInformationTrain;

    @ColumnInfo(name = "information_train_from")
    private Date dateTimeFromInformationTrain;

    @ColumnInfo(name = "information_train_to")
    private Date dateTimeToInformationTrain;

    @ColumnInfo(name = "information_train_fk")
    private int foreignKeyInformationTrain;
}

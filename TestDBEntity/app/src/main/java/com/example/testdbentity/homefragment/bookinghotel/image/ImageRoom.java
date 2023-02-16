package com.example.testdbentity.homefragment.bookinghotel.image;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "image_room_table")
public class ImageRoom {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "image_hroom_id")
    public int idImageRoom;

    @ColumnInfo(name = "image_room_src")
    public int srcImageRoom;

    //khoa ngoai tham chieu dem roomentity
    @ColumnInfo(name = "image_room_fk")
    public int fkImageRoom;

    public ImageRoom(int srcImageRoom, int fkImageRoom) {
        this.srcImageRoom = srcImageRoom;
        this.fkImageRoom = fkImageRoom;
    }
}

package com.example.testdbentity.homefragment.bookingcar.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingCarEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingSeatEntity;
import com.example.testdbentity.homefragment.bookingcar.dao.BookingCarDAO;
import com.example.testdbentity.homefragment.bookingcar.userwithcar.UserAndCarREF;
import com.example.testdbentity.homefragment.bookingcar.userwithseat.UserAndSeatREF;
import com.example.testdbentity.homefragment.bookinghotel.BookingHotelEntity;
import com.example.testdbentity.homefragment.bookinghotel.BookingRoomEntity;
import com.example.testdbentity.homefragment.bookinghotel.hotelandpeople.PeopleAndHotelRef;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageHotel;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageRoom;
import com.example.testdbentity.homefragment.bookinghotel.roomandpeople.PeopleAndRoomRef;
import com.example.testdbentity.login.database.LoginEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {BookingSeatEntity.class, BookingCarEntity.class,
        UserAndCarREF.class, InformationEntity.class,
        BookingRoomEntity.class, BookingHotelEntity.class,
        PeopleAndRoomRef.class, PeopleAndHotelRef.class,
        ImageHotel.class, ImageRoom.class, UserAndSeatREF.class, LoginEntity.class
}, version = 1, exportSchema = false)
public abstract class BookingCarDatabase extends RoomDatabase{
    public abstract BookingCarDAO bookingCarDAO();

    private static volatile BookingCarDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static BookingCarDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookingCarDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    BookingCarDatabase.class, "test_room_1")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

package com.example.testdbentity.homefragment.bookingcar.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;


import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingSeatEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingCarEntity;
import com.example.testdbentity.homefragment.bookingcar.carwithseat.CarWithSeat;
import com.example.testdbentity.homefragment.bookingcar.userwithcar.UserAndCarREF;
import com.example.testdbentity.homefragment.bookingcar.userwithseat.UserAndSeatREF;

import java.util.List;

@Dao
public interface BookingCarDAO {
    @Insert
    public void insertBookingCar(List<BookingCarEntity> bookingCarEntities);

    @Insert
    public void insertBookingSeat(List<BookingSeatEntity> bookingSeatEntityList);

    @Insert
    public void insertUserAndCarREF(List<UserAndCarREF> userAndCarREFS);

    @Insert
    public void insertUserAndSeatREF(List<UserAndSeatREF> userAndSeatREFS);

    @Query("SELECT booking_car_startPlace FROM booking_car_table WHERE booking_car_isfull = 0")
    public List<String> getAllStartPlace();

    @Query("SELECT booking_car_endPlace FROM booking_car_table WHERE booking_car_isfull = 0")
    public List<String> getAllEndPlace();

    @Transaction
    @Query("SELECT * FROM booking_car_table WHERE booking_car_id = :idCar")
    public CarWithSeat getAllSeatOfIdCar(int idCar);


    @Transaction
    @Query("SELECT * FROM booking_car_table WHERE booking_car_day = :day AND booking_car_month = :month " +
            "AND booking_car_year = :year AND booking_car_startPlace = :startPlace AND booking_car_endPlace = :endPlace")
    public LiveData<List<CarWithSeat>> getCarWithRequire(int day, int month, int year, String startPlace, String endPlace);

    @Transaction
    @Query("SELECT * FROM booking_car_table WHERE booking_car_day = :day AND booking_car_month = :month " +
            "AND booking_car_year = :year AND booking_car_startPlace = :startPlace AND booking_car_endPlace = :endPlace")
    public List<CarWithSeat> getCarWithRequireNoLiveData(int day, int month, int year, String startPlace, String endPlace);

    @Update
    public void updateIsChoosingSeat(BookingSeatEntity bookingSeatEntity);

    @Query("SELECT * FROM booking_seat_table WHERE booking_seat_id = :id")
    public BookingSeatEntity getOneBookingSeat(int id);

    @Query("SELECT * FROM booking_seat_table WHERE booking_seat_choosing = 1")
    public List<BookingSeatEntity> getListBookingSeatEntities();

    @Query("SELECT * FROM booking_car_table JOIN booking_seat_table " +
            "ON booking_car_table.booking_car_id = booking_seat_table.booking_seat_fk WHERE " +
            "booking_seat_table.booking_seat_isfull = 1")
    public LiveData<List<CarWithSeat>> getListBookingCarWithBookingSeat();

    @Query("SELECT * FROM information_user WHERE information_user_id = :idUser")
    public InformationEntity getInformationUser(int idUser);

    @Query("SELECT * FROM information_user WHERE information_user_id = :idUser")
    public LiveData<InformationEntity> getLiveDataInformationUser(int idUser);

    @Update
    public void updateInformationUser(InformationEntity informationEntity);

    @Transaction
    @Query("SELECT * FROM booking_car_table JOIN booking_seat_table ON booking_car_table.booking_car_id = booking_seat_table.booking_seat_fk " +
            "WHERE booking_seat_table.booking_seat_id = :idSeat")
    public CarWithSeat getCarWithSeatWithIdSeat(int idSeat);
}


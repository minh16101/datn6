package com.example.testdbentity.homefragment.bookingcar.respository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingCarEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingSeatEntity;
import com.example.testdbentity.homefragment.bookingcar.carwithseat.CarWithSeat;
import com.example.testdbentity.homefragment.bookingcar.dao.BookingCarDAO;
import com.example.testdbentity.homefragment.bookingcar.database.BookingCarDatabase;
import com.example.testdbentity.homefragment.bookingcar.userwithcar.UserAndCarREF;
import com.example.testdbentity.homefragment.bookingcar.userwithseat.UserAndSeatREF;

import java.util.List;

public class BookingCarRespository {

    private BookingCarDAO bookingCarDAO;
    public BookingCarRespository(Application application)
    {
        BookingCarDatabase bookingCarDatabase = BookingCarDatabase.getDatabase(application);
        bookingCarDAO = bookingCarDatabase.bookingCarDAO();
    }
    public void insertBookingCar(List<BookingCarEntity> bookingCarEntity)
    {
        BookingCarDatabase.databaseWriteExecutor.execute(() -> {
            bookingCarDAO.insertBookingCar(bookingCarEntity);
        });
    }
    public void insertBookingSeat(List<BookingSeatEntity> bookingSeatEntityList) {
        BookingCarDatabase.databaseWriteExecutor.execute(() -> {
            bookingCarDAO.insertBookingSeat(bookingSeatEntityList);
        });
    }
    public void insertUserAndCarREF(List<UserAndCarREF> userAndCarREFS){
        BookingCarDatabase.databaseWriteExecutor.execute(() -> {
            bookingCarDAO.insertUserAndCarREF(userAndCarREFS);
        });
    }
    public void insertUserAndSeatREF(List<UserAndSeatREF> userAndSeatREFS){
        BookingCarDatabase.databaseWriteExecutor.execute(() -> {
            bookingCarDAO.insertUserAndSeatREF(userAndSeatREFS);
        });
    }
    public List<String> getAllStartPlace(){
        return bookingCarDAO.getAllStartPlace();
    }
    public List<String> getAllEndPlace() {
        return bookingCarDAO.getAllEndPlace();
    }
    public CarWithSeat getAllSeatOfIdCar(int idCar) {
        return bookingCarDAO.getAllSeatOfIdCar(idCar);
    }
    public LiveData<List<CarWithSeat>> getCarWithRequire(int day, int month, int year, String startPlace, String endPlace){
        return bookingCarDAO.getCarWithRequire(day, month, year, startPlace, endPlace);
    }
    public List<CarWithSeat> getCarWithRequireNoLiveData(int day, int month, int year, String startPlace, String endPlace){
        return bookingCarDAO.getCarWithRequireNoLiveData(day, month, year, startPlace, endPlace);
    }

    public void updateIsChoosingSeat(BookingSeatEntity bookingSeatEntity) {
        BookingCarDatabase.databaseWriteExecutor.execute(() -> {
            bookingCarDAO.updateIsChoosingSeat(bookingSeatEntity);
        });
    }
    public BookingSeatEntity getOneBookingSeat(int id){
        return bookingCarDAO.getOneBookingSeat(id);
    }
    public InformationEntity getInformationUser(int idUser){
        return bookingCarDAO.getInformationUser(idUser);
    }
    public CarWithSeat getCarWithSeatWithIdSeat(int idSeat) {
        return bookingCarDAO.getCarWithSeatWithIdSeat(idSeat);
    }
    public List<BookingSeatEntity> getListBookingSeatEntities() {
        return bookingCarDAO.getListBookingSeatEntities();
    }
    public LiveData<List<CarWithSeat>> getListBookingCarWithBookingSeat(){
        return bookingCarDAO.getListBookingCarWithBookingSeat();
    }
    public void updateInformationUser(InformationEntity informationEntity){
        BookingCarDatabase.databaseWriteExecutor.execute(() -> {
            bookingCarDAO.updateInformationUser(informationEntity);
        });
    }
    public LiveData<InformationEntity> getLiveDataInformationUser(int idUser)
    {
        return bookingCarDAO.getLiveDataInformationUser(idUser);
    }
}

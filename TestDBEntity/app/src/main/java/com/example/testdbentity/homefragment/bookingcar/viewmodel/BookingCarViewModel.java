package com.example.testdbentity.homefragment.bookingcar.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingCarEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingSeatEntity;
import com.example.testdbentity.homefragment.bookingcar.carwithseat.CarWithSeat;
import com.example.testdbentity.homefragment.bookingcar.database.BookingCarDatabase;
import com.example.testdbentity.homefragment.bookingcar.respository.BookingCarRespository;
import com.example.testdbentity.homefragment.bookingcar.userwithcar.UserAndCarREF;
import com.example.testdbentity.homefragment.bookingcar.userwithseat.UserAndSeatREF;

import java.util.List;

public class BookingCarViewModel extends AndroidViewModel {
    private BookingCarRespository bookingCarRespository;

    public BookingCarViewModel(@NonNull Application application) {
        super(application);
        bookingCarRespository = new BookingCarRespository(application);
    }

    public void insertBookingCar(List<BookingCarEntity> bookingCarEntity) {
        bookingCarRespository.insertBookingCar(bookingCarEntity);
    }

    public void insertBookingSeat(List<BookingSeatEntity> bookingSeatEntityList) {
        bookingCarRespository.insertBookingSeat(bookingSeatEntityList);
    }
    public void insertUserAndCarREF(List<UserAndCarREF> userAndCarREFS){
        bookingCarRespository.insertUserAndCarREF(userAndCarREFS);
    }
    public void insertUserAndSeatREF(List<UserAndSeatREF> userAndSeatREFS){
        bookingCarRespository.insertUserAndSeatREF(userAndSeatREFS);
    }
    public List<String> getAllStartPlace(){
        return bookingCarRespository.getAllStartPlace();
    }
    public List<String> getAllEndPlace() {
        return bookingCarRespository.getAllEndPlace();
    }
    public CarWithSeat getAllSeatOfIdCar(int idCar) {
        return bookingCarRespository.getAllSeatOfIdCar(idCar);
    }
    public LiveData<List<CarWithSeat>> getCarWithRequire(int day, int month, int year, String startPlace, String endPlace) {
        return bookingCarRespository.getCarWithRequire(day, month, year, startPlace, endPlace);
    }
    public List<CarWithSeat> getCarWithRequireNoLiveData(int day, int month, int year, String startPlace, String endPlace){
        return bookingCarRespository.getCarWithRequireNoLiveData(day, month, year, startPlace, endPlace);
    }

    public void updateIsChoosingSeat(BookingSeatEntity bookingSeatEntity)
    {
        bookingCarRespository.updateIsChoosingSeat(bookingSeatEntity);
    }
    public BookingSeatEntity getOneBookingSeat(int id) {
        return bookingCarRespository.getOneBookingSeat(id);
    }

    public InformationEntity getInformationUser(int idUser) {
        return bookingCarRespository.getInformationUser(idUser);
    }
    public CarWithSeat getCarWithSeatWithIdSeat(int idSeat) {
        return bookingCarRespository.getCarWithSeatWithIdSeat(idSeat);
    }
    public List<BookingSeatEntity> getListBookingSeatEntities(){
        return bookingCarRespository.getListBookingSeatEntities();
    }

    public LiveData<List<CarWithSeat>> getListBookingCarWithBookingSeat(){
        return bookingCarRespository.getListBookingCarWithBookingSeat();
    }
    public void updateInformationUser(InformationEntity informationEntity){
        bookingCarRespository.updateInformationUser(informationEntity);
    }
    public LiveData<InformationEntity> getLiveDataInformationUser(int idUser)
    {
        return bookingCarRespository.getLiveDataInformationUser(idUser);
    }
}

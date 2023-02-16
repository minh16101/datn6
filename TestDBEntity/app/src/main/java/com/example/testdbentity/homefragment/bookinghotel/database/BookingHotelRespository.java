package com.example.testdbentity.homefragment.bookinghotel.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookinghotel.BookingHotelEntity;
import com.example.testdbentity.homefragment.bookinghotel.BookingRoomEntity;
import com.example.testdbentity.homefragment.bookinghotel.hotelandpeople.InformationPeopleWithBookingHotel;
import com.example.testdbentity.homefragment.bookinghotel.hotelandpeople.PeopleAndHotelRef;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageHotel;
import com.example.testdbentity.homefragment.bookinghotel.hotelandroom.BookingHotelWithBookingRoom;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageRoom;
import com.example.testdbentity.homefragment.bookinghotel.image.hotelandimg.HotelWithImage;
import com.example.testdbentity.homefragment.bookinghotel.image.roomandimg.RoomWithImage;
import com.example.testdbentity.homefragment.bookinghotel.roomandpeople.InformationPeopleWithBookingRoom;
import com.example.testdbentity.homefragment.bookinghotel.roomandpeople.PeopleAndRoomRef;

import java.util.List;

public class BookingHotelRespository {
    private BookingHotelDAO bookingHotelDAO;

    public BookingHotelRespository(Application application) {
        BookingHotelDatabase bookingHotelDatabase = BookingHotelDatabase.getDatabase(application);
        bookingHotelDAO = bookingHotelDatabase.bookingHotelDAO();
    }

    public void insertHotel(List<BookingHotelEntity> bookingHotelEntity) {
        BookingHotelDatabase.databaseWriteExecutor.execute(() -> {
            bookingHotelDAO.insertHotel(bookingHotelEntity);
        });
    }

    public void insertRoom(List<BookingRoomEntity> bookingHotelEntity) {
        BookingHotelDatabase.databaseWriteExecutor.execute(() -> {
            bookingHotelDAO.insertRoom(bookingHotelEntity);
        });
    }

    public void insertImageHotel(List<ImageHotel> imageHotels) {
        BookingHotelDatabase.databaseWriteExecutor.execute(() -> {
            bookingHotelDAO.insertImageHotel(imageHotels);
        });
    }

    public void insertImageRoom(List<ImageRoom> imageRooms) {
        BookingHotelDatabase.databaseWriteExecutor.execute(() -> {
            bookingHotelDAO.insertImageRoom(imageRooms);
        });
    }

    public void insertPeopleAndRoomREF(PeopleAndRoomRef peopleAndRoomRefs) {
        BookingHotelDatabase.databaseWriteExecutor.execute(() -> {
            bookingHotelDAO.insertPeopleAndRoomREF(peopleAndRoomRefs);
        });
    }

    public void insertPeopleAndHotelREF(PeopleAndHotelRef peopleAndHotelRefs) {
        BookingHotelDatabase.databaseWriteExecutor.execute(() -> {
            bookingHotelDAO.insertPeopleAndHotelREF(peopleAndHotelRefs);
        });
    }

    public void insertInformation(List<InformationEntity> informationEntities) {
        BookingHotelDatabase.databaseWriteExecutor.execute(() -> {
            bookingHotelDAO.insertInformation(informationEntities);
        });
    }

    public List<BookingHotelWithBookingRoom> getAllListRoomOfHotel() {
        return bookingHotelDAO.getAllListRoomOfHotel();
    }

    public LiveData<List<HotelWithImage>> getAllImageOfHotel() {
        return bookingHotelDAO.getAllImageOfHotel();
    }

    public LiveData<List<RoomWithImage>> getAllImageOfRoom() {
        return bookingHotelDAO.getAllImageOfRoom();
    }

    public List<InformationPeopleWithBookingHotel> getAllHotelOfUser() {
        return bookingHotelDAO.getAllHotelOfUser();
    }

    public List<InformationPeopleWithBookingRoom> getAllRoomOfUser() {
        return bookingHotelDAO.getAllRoomOfUser();
    }

    public List<BookingHotelWithBookingRoom> getAllRoomWithIdHotel(int idHotel) {
        return bookingHotelDAO.getAllRoomWithIdHotel(idHotel);
    }

    public List<InformationPeopleWithBookingRoom> getAllRoomOfUserWithIdUser(int idUser) {
        return bookingHotelDAO.getAllRoomOfUserWithIdUser(idUser);
    }

    public List<InformationPeopleWithBookingHotel> getAllHotelOfUserWithIdUser(int idUser) {
        return bookingHotelDAO.getAllHotelOfUserWithIdUser(idUser);
    }

    public List<BookingRoomEntity> getRoomOfUserWithIdHotel(int idHotel, int idUser) {
        return bookingHotelDAO.getRoomOfUserWithIdHotel(idHotel, idUser);
    }

    public List<BookingHotelEntity> getAllHotelOfDistrict(String district) {
        return bookingHotelDAO.getAllHotelOfDistrict(district);
    }

    public LiveData<List<RoomWithImage>> getAllImageOfRoomWithIdHotel(int idHotel) {
        return bookingHotelDAO.getAllImageOfRoomWithIdHotel(idHotel);
    }

    public void deleteUserAndRoomREF(PeopleAndRoomRef peopleAndRoomRef) {
        BookingHotelDatabase.databaseWriteExecutor.execute(() -> {
            bookingHotelDAO.deleteUserAndRoomREF(peopleAndRoomRef);
        });
    }

    public void deleteUserAndHotelREF(PeopleAndHotelRef peopleAndHotelRef) {
        BookingHotelDatabase.databaseWriteExecutor.execute(() -> {
            bookingHotelDAO.deleteUserAndHotelREF(peopleAndHotelRef);
        });
    }

    public PeopleAndRoomRef getUserAndRoomREF(int idUser, int idRoom) {
        return bookingHotelDAO.getUserAndRoomREF(idUser, idRoom);
    }

    public PeopleAndHotelRef getUserAndHotelREF(int idUser, int idHotel) {
        return bookingHotelDAO.getUserAndHotelREF(idUser, idHotel);
    }

    public LiveData<List<RoomWithImage>> getRoomWithUserId(int idUser) {
        return bookingHotelDAO.getRoomWithUserId(idUser);
    }

    public BookingRoomEntity getRoomById(int idRoom) {
        return bookingHotelDAO.getRoomById(idRoom);
    }

    public void updateRoomToBooked(BookingRoomEntity bookingRoomEntity) {
        BookingHotelDatabase.databaseWriteExecutor.execute(() -> {
            bookingHotelDAO.updateRoomToBooked(bookingRoomEntity);
        });
    }

    public LiveData<List<HotelWithImage>> getAllImageOfHotelWithDistrict(String city) {
        return bookingHotelDAO.getAllImageOfHotelWithDistrict(city);
    }
    public InformationEntity getBookingRoomUser(int idUser){
        return bookingHotelDAO.getBookingRoomUser(idUser);
    }
    public void updateWasBookingRoomInUser(InformationEntity informationEntity){
        BookingHotelDatabase.databaseWriteExecutor.execute(() -> {
            bookingHotelDAO.updateWasBookingRoomInUser(informationEntity);
        });
    }
    public LiveData<InformationEntity> getInformationOneUser(int fkid)
    {
        return bookingHotelDAO.getInformationOneUser(fkid);
    }
    public BookingHotelEntity getHotelById(int idHotel)
    {
        return bookingHotelDAO.getHotelById(idHotel);
    }
    public LiveData<HotelWithImage> getImageOfaHotel(int idHotel) {
        return bookingHotelDAO.getImageOfaHotel(idHotel);
    }
    public RoomWithImage getAllImageOfRoomWithIdRoom(int idRoom)
    {
        return bookingHotelDAO.getAllImageOfRoomWithIdRoom(idRoom);
    }
    public BookingHotelEntity getHotelFromForeignKeyRoom(int fkRoom)
    {
        return bookingHotelDAO.getHotelFromForeignKeyRoom(fkRoom);
    }
    public LiveData<BookingRoomEntity> getRoomWasBookedWithIdUser(int id)
    {
        return bookingHotelDAO.getRoomWasBookedWithIdUser(id);
    }
}

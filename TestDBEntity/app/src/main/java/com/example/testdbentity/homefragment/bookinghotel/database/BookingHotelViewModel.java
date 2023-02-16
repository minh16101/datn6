package com.example.testdbentity.homefragment.bookinghotel.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
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

public class BookingHotelViewModel extends AndroidViewModel {
    private BookingHotelRespository bookingHotelRespository;
    public BookingHotelViewModel(@NonNull Application application) {
        super(application);
        bookingHotelRespository = new BookingHotelRespository(application);
    }
    public void insertHotel(List<BookingHotelEntity> bookingHotelEntity)
    {
        bookingHotelRespository.insertHotel(bookingHotelEntity);
    }

    public void insertRoom(List<BookingRoomEntity> bookingHotelEntity)
    {
        bookingHotelRespository.insertRoom(bookingHotelEntity);
    }
    public void insertImageHotel(List<ImageHotel> imageHotels) {
        bookingHotelRespository.insertImageHotel(imageHotels);
    }
    public void insertImageRoom(List<ImageRoom> imageRooms){
        bookingHotelRespository.insertImageRoom(imageRooms);
    }
    public void insertPeopleAndRoomREF(PeopleAndRoomRef peopleAndRoomRefs) {
        bookingHotelRespository.insertPeopleAndRoomREF(peopleAndRoomRefs);
    }
    public void insertPeopleAndHotelREF(PeopleAndHotelRef peopleAndHotelRefs) {
        bookingHotelRespository.insertPeopleAndHotelREF(peopleAndHotelRefs);
    }
    public void insertInformation(List<InformationEntity> informationEntities){
        bookingHotelRespository.insertInformation(informationEntities);
    }
    public List<BookingHotelWithBookingRoom> getAllListRoomOfHotel(){
        return bookingHotelRespository.getAllListRoomOfHotel();
    }
    public LiveData<List<HotelWithImage>> getAllImageOfHotel() {
        return bookingHotelRespository.getAllImageOfHotel();
    }
    public LiveData<List<RoomWithImage>> getAllImageOfRoom(){
        return bookingHotelRespository.getAllImageOfRoom();
    }
    public List<InformationPeopleWithBookingHotel> getAllHotelOfUser() {
        return bookingHotelRespository.getAllHotelOfUser();
    }
    public List<InformationPeopleWithBookingRoom> getAllRoomOfUser(){
        return bookingHotelRespository.getAllRoomOfUser();
    }
    public List<BookingHotelWithBookingRoom> getAllRoomWithIdHotel(int idHotel) {
        return bookingHotelRespository.getAllRoomWithIdHotel(idHotel);
    }
    public List<InformationPeopleWithBookingRoom> getAllRoomOfUserWithIdUser(int idUser) {
        return bookingHotelRespository.getAllRoomOfUserWithIdUser(idUser);
    }
    public List<InformationPeopleWithBookingHotel> getAllHotelOfUserWithIdUser(int idUser){
        return bookingHotelRespository.getAllHotelOfUserWithIdUser(idUser);
    }
    public List<BookingRoomEntity> getRoomOfUserWithIdHotel(int idHotel, int idUser) {
        return bookingHotelRespository.getRoomOfUserWithIdHotel(idHotel, idUser);
    }
    public List<BookingHotelEntity> getAllHotelOfDistrict(String district) {
        return bookingHotelRespository.getAllHotelOfDistrict(district);
    }
    public LiveData<List<RoomWithImage>> getAllImageOfRoomWithIdHotel(int idHotel) {
        return bookingHotelRespository.getAllImageOfRoomWithIdHotel(idHotel);
    }
    public void deleteUserAndRoomREF(PeopleAndRoomRef peopleAndRoomRef){
        bookingHotelRespository.deleteUserAndRoomREF(peopleAndRoomRef);
    }
    public void deleteUserAndHotelREF(PeopleAndHotelRef peopleAndHotelRef){
        bookingHotelRespository.deleteUserAndHotelREF(peopleAndHotelRef);
    }
    public PeopleAndRoomRef getUserAndRoomREF(int idUser, int idRoom){
        return bookingHotelRespository.getUserAndRoomREF(idUser, idRoom);
    }
    public PeopleAndHotelRef getUserAndHotelREF(int idUser, int idHotel){
        return bookingHotelRespository.getUserAndHotelREF(idUser, idHotel);
    }
    public LiveData<List<RoomWithImage>> getRoomWithUserId(int idUser) {
        return bookingHotelRespository.getRoomWithUserId(idUser);
    }
    public BookingRoomEntity getRoomById(int idRoom) {
        return bookingHotelRespository.getRoomById(idRoom);
    }
    public void updateRoomToBooked(BookingRoomEntity bookingRoomEntity)
    {
        bookingHotelRespository.updateRoomToBooked(bookingRoomEntity);
    }
    public LiveData<List<HotelWithImage>> getAllImageOfHotelWithDistrict(String city) {
        return bookingHotelRespository.getAllImageOfHotelWithDistrict(city);
    }
    public InformationEntity getBookingRoomUser(int idUser){
        return bookingHotelRespository.getBookingRoomUser(idUser);
    }
    public void updateWasBookingRoomInUser(InformationEntity informationEntity) {
        bookingHotelRespository.updateWasBookingRoomInUser(informationEntity);
    }
    public LiveData<InformationEntity> getInformationOneUser(int fkid)
    {
        return bookingHotelRespository.getInformationOneUser(fkid);
    }
    public BookingHotelEntity getHotelById(int idHotel)
    {
        return bookingHotelRespository.getHotelById(idHotel);
    }
    public LiveData<HotelWithImage> getImageOfaHotel(int idHotel)
    {
        return bookingHotelRespository.getImageOfaHotel(idHotel);
    }
    public RoomWithImage getAllImageOfRoomWithIdRoom(int idRoom)
    {
        return bookingHotelRespository.getAllImageOfRoomWithIdRoom(idRoom);
    }
    public BookingHotelEntity getHotelFromForeignKeyRoom(int fkRoom)
    {
        return bookingHotelRespository.getHotelFromForeignKeyRoom(fkRoom);
    }
    public LiveData<BookingRoomEntity> getRoomWasBookedWithIdUser(int id)
    {
        return bookingHotelRespository.getRoomWasBookedWithIdUser(id);
    }
}

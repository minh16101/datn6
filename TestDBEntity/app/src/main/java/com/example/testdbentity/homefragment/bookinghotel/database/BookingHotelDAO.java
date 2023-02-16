package com.example.testdbentity.homefragment.bookinghotel.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.homefragment.bookinghotel.BookingHotelEntity;
import com.example.testdbentity.homefragment.bookinghotel.hotelandpeople.PeopleAndHotelRef;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageHotel;
import com.example.testdbentity.homefragment.bookinghotel.hotelandpeople.InformationPeopleWithBookingHotel;
import com.example.testdbentity.homefragment.bookinghotel.hotelandroom.BookingHotelWithBookingRoom;
import com.example.testdbentity.homefragment.bookinghotel.BookingRoomEntity;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageRoom;
import com.example.testdbentity.homefragment.bookinghotel.image.hotelandimg.HotelWithImage;
import com.example.testdbentity.homefragment.bookinghotel.image.roomandimg.RoomWithImage;
import com.example.testdbentity.homefragment.bookinghotel.roomandpeople.InformationPeopleWithBookingRoom;
import com.example.testdbentity.homefragment.bookinghotel.roomandpeople.PeopleAndRoomRef;

import java.util.List;

@Dao
public interface BookingHotelDAO {
    @Insert
    public void insertHotel(List<BookingHotelEntity> bookingHotelEntity);
    @Insert
    public void insertRoom(List<BookingRoomEntity> bookingRoomEntity);
    @Insert
    public void insertImageHotel(List<ImageHotel> imageHotels);
    @Insert
    public void insertImageRoom(List<ImageRoom> imageRooms);

    //Insert phong vao danh sach book phong cua nguoi dung
    //Insert cai REF nay chinh la khi nguoi dung click vao book phong. Thi can lay ra id cua hotel co cai phong do
    //sau do insert id nguoi dung va id hotel. Nhu vay la nguoi dung da book cai phong thuoc hotel do.
    //!> Nen insert quan he 1 nhieu giua nguoi va room boi vi nguoi dung se dat phong. Va tu phong do ta co the biet duoc no thuoc khach san nao
    //chu neu nhu insert theo nguoi dung va hotel. Thi chi biet duoc nguoi dung book cai hotel do chu khong biet duoc book phong vao trong hotel do
    //tam thoi comment cai user and hotel ben duoi vi khong dung!
    @Insert
    public void insertPeopleAndRoomREF(PeopleAndRoomRef peopleAndRoomRefs);
    @Insert
    public void insertPeopleAndHotelREF(PeopleAndHotelRef peopleAndHotelRefs);
    @Insert
    public void insertInformation(List<InformationEntity> informationEntities);

    //tim kiem binh thuong
    //tam thoi chi dung muc 4 va 5. 2 va 3 khong can thiet
    //1
    //1a. tim kiem khach san co nhung phong nao. Hotel va Room la quan he 1 nhieu
    //sau khi click vao 1 hotel thi can tra ra cac phong thuoc hotel do

    @Query("SELECT * FROM information_user WHERE information_user_fk = :fkid")
    public LiveData<InformationEntity> getInformationOneUser(int fkid);

    @Transaction
    @Query("SELECT * FROM booking_hotel_table")
    public List<BookingHotelWithBookingRoom> getAllListRoomOfHotel();

    @Transaction
    @Query("SELECT * FROM booking_hotel_table")
    public LiveData<List<HotelWithImage>> getAllImageOfHotel();

    @Transaction
    @Query("SELECT * FROM booking_hotel_table WHERE booking_hotel_id = :idHotel")
    public LiveData<HotelWithImage> getImageOfaHotel(int idHotel);

    @Transaction
    @Query("SELECT * FROM booking_hotel_table WHERE booking_hotel_quan = :city")
    public LiveData<List<HotelWithImage>> getAllImageOfHotelWithDistrict(String city);

    @Transaction
    @Query("SELECT * FROM booking_room_table")
    public LiveData<List<RoomWithImage>> getAllImageOfRoom();

    @Transaction
    @Query("SELECT * FROM booking_room_table WHERE booking_room_id = :idRoom")
    public RoomWithImage getAllImageOfRoomWithIdRoom(int idRoom);


    @Transaction
    @Query("SELECT * FROM booking_room_table WHERE booking_room_fk = :idHotel AND booking_room_isbooking = 0")
    public LiveData<List<RoomWithImage>> getAllImageOfRoomWithIdHotel(int idHotel);

    //2. Lay ra nhung hotel ma nguoi dung book
    @Transaction
    @Query("SELECT * FROM information_user")
    public List<InformationPeopleWithBookingHotel> getAllHotelOfUser();

    @Transaction
    @Query("SELECT * FROM information_user")
    public List<InformationPeopleWithBookingRoom> getAllRoomOfUser();

    @Transaction
    @Query("SELECT * FROM booking_hotel_table WHERE booking_hotel_id = :idHotel")
    public List<BookingHotelWithBookingRoom> getAllRoomWithIdHotel(int idHotel);

    @Query("SELECT * FROM booking_hotel_table WHERE booking_hotel_id = :fkRoom")
    public BookingHotelEntity getHotelFromForeignKeyRoom(int fkRoom);

    @Transaction
    @Query("SELECT * FROM information_user WHERE information_user_id = :idUser")
    public List<InformationPeopleWithBookingRoom> getAllRoomOfUserWithIdUser(int idUser);


    @Transaction
    @Query("SELECT * FROM information_user WHERE information_user_id = :idUser")
    public List<InformationPeopleWithBookingHotel> getAllHotelOfUserWithIdUser(int idUser);

    @Transaction
    @Query("SELECT * FROM booking_room_table " +
            "JOIN peopleandroomref ON booking_room_table.booking_room_id = peopleandroomref.booking_room_id " +
            "JOIN information_user ON information_user.information_user_id = peopleandroomref.information_user_id " +
            "JOIN booking_hotel_table ON booking_hotel_table.booking_hotel_id = booking_room_table.booking_room_fk " +
            "WHERE booking_hotel_table.booking_hotel_id = :idHotel AND information_user.information_user_id = :idUser")
    public List<BookingRoomEntity> getRoomOfUserWithIdHotel(int idHotel, int idUser);

    @Delete
    public void deleteUserAndRoomREF(PeopleAndRoomRef peopleAndRoomRef);
    @Query("SELECT * FROM information_user WHERE information_user_id = :idUser")
    public InformationEntity getBookingRoomUser(int idUser);
    @Update
    public void updateWasBookingRoomInUser(InformationEntity informationEntity);
    @Delete
    public void deleteUserAndHotelREF(PeopleAndHotelRef peopleAndHotelRef);
    @Transaction
    @Query("SELECT * FROM peopleandroomref WHERE information_user_id = :idUser AND booking_room_id = :idRoom")
    public PeopleAndRoomRef getUserAndRoomREF(int idUser, int idRoom);

    @Transaction
    @Query("SELECT * FROM peopleandhotelref WHERE information_user_id = :idUser AND booking_hotel_id = :idHotel")
    public PeopleAndHotelRef getUserAndHotelREF(int idUser, int idHotel);

    @Transaction
    @Query("SELECT * FROM booking_room_table JOIN peopleandroomref ON booking_room_table.booking_room_id = peopleandroomref.booking_room_id " +
            "JOIN information_user ON information_user.information_user_id = peopleandroomref.information_user_id " +
            "WHERE information_user.information_user_id = :idUser")
    public LiveData<List<RoomWithImage>> getRoomWithUserId(int idUser);

    //Lay ra booking room entity theo id room
    @Query("SELECT * FROM booking_room_table WHERE booking_room_id = :idRoom")
    public BookingRoomEntity getRoomById(int idRoom);

    @Query("SELECT * FROM booking_hotel_table WHERE booking_hotel_id = :idHotel")
    public BookingHotelEntity getHotelById(int idHotel);

    //update room chua book -> da book
    @Update
    public void updateRoomToBooked(BookingRoomEntity bookingRoomEntity);
    //tim kiem theo quan
    @Query("SELECT * FROM booking_hotel_table WHERE booking_hotel_quan = :district")
    public List<BookingHotelEntity> getAllHotelOfDistrict(String district);

    //lay ra phong da duoc book boi nguoi dung co id la ID
    @Query("SELECT * FROM booking_room_table WHERE booking_room_isbooking = 1 AND booking_room_id_userbooking = :id")
    public LiveData<BookingRoomEntity> getRoomWasBookedWithIdUser(int id);
}

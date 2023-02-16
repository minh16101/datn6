package com.example.testdbentity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.testdbentity.homefragment.bookingcar.BookingCarEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingSeatEntity;
import com.example.testdbentity.homefragment.bookingcar.viewmodel.BookingCarViewModel;
import com.example.testdbentity.homefragment.bookinghotel.BookingHotelEntity;
import com.example.testdbentity.homefragment.bookinghotel.BookingRoomEntity;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageHotel;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageRoom;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;
import com.example.testdbentity.homefragment.weather.WeatherMainActivity;
import com.example.testdbentity.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BookingHotelViewModel bookingHotelViewModel;
    private BookingCarViewModel bookingCarViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);
        bookingCarViewModel = new ViewModelProvider(this).get(BookingCarViewModel.class);
//        initdata();
//        Intent intent = new Intent(MainActivity.this, DisplayHotelActivity.class);
//        startActivity(intent);
//        List<InformationPeopleWithBookingHotel> informationPeopleWithBookingHotel = bookingHotelViewModel.getAllHotelOfUserWithIdUser(1);
//        Intent intent = new Intent(MainActivity.this, DisplayCarActivity.class);
//        startActivity(intent);


//        Intent intent = new Intent(MainActivity.this, MainPageActivity.class);
//        startActivity(intent);

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void initdata() {

        insertHotel();
        insertRoom();

        insertImageHotel();
        insertImageRoom();

//        insertInformation();

        insertBookingCar();
        insertBookingSeat();
    }
    private void insertBookingCar() {
        List<BookingCarEntity> bookingCarEntities = new ArrayList<>();
        bookingCarEntities.add(new BookingCarEntity("Xe hien dai1", "Ha Noi", "Nghe An", "BX My Dinh", "BX Nghe An", 31, 12, 2022, 45, R.drawable.car));
        bookingCarEntities.add(new BookingCarEntity("Xe hien dai2", "Ha Noi", "Nghe An", "BX My Dinh", "BX Nghe An", 31, 12, 2022, 45, R.drawable.car));
        bookingCarEntities.add(new BookingCarEntity("Xe hien dai3", "Ha Noi", "Nghe An", "BX My Dinh", "BX Nghe An", 30, 12, 2022, 45, R.drawable.car));
        bookingCarEntities.add(new BookingCarEntity("Xe hien dai4", "Ha Noi", "Nghe An", "BX My Dinh", "BX Nghe An", 30, 12, 2022, 45, R.drawable.car));

        bookingCarEntities.add(new BookingCarEntity("Xe truyen thong1", "Ha Noi", "Thanh Hoa", "BX My Dinh", "BX Nghe An", 31, 12, 2022, 45, R.drawable.car));
        bookingCarEntities.add(new BookingCarEntity("Xe truyen thong2", "Ha Noi", "Thanh Hoa", "BX My Dinh", "BX Nghe An", 31, 12, 2022, 45, R.drawable.car));
        bookingCarEntities.add(new BookingCarEntity("Xe truyen thong3", "Ha Noi", "Thanh Hoa", "BX My Dinh", "BX Nghe An", 30, 12, 2022, 45, R.drawable.car));
        bookingCarEntities.add(new BookingCarEntity("Xe truyen thong4", "Ha Noi", "Thanh Hoa", "BX My Dinh", "BX Nghe An", 30, 12, 2022, 45, R.drawable.car));

        bookingCarViewModel.insertBookingCar(bookingCarEntities);

    }
    private void insertBookingSeat(){
        List<BookingSeatEntity> bookingSeatEntityList = new ArrayList<>();

        bookingSeatEntityList.add(new BookingSeatEntity("A1",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A2",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A3",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A4",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A5",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A6",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A7",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A8",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A9",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A10",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A11",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A12",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A13",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A14",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A15",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A16",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A17",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A18",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A19",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A20",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A21",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A22",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A23",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A24",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A25",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A26",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A27",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A28",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A29",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A30",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A31",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A32",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A33",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A34",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A35",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A36",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A37",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A38",1, 200000));

        bookingSeatEntityList.add(new BookingSeatEntity("A1",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A2",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A3",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A4",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A5",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A6",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A7",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A8",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A9",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A10",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A11",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A12",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A13",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A14",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A15",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A16",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A17",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A18",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A19",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A20",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A21",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A22",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A23",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A24",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A25",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A26",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A27",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A28",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A29",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A30",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A31",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A32",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A33",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A34",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A35",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A36",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A37",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A38",2, 200000));

        bookingCarViewModel.insertBookingSeat(bookingSeatEntityList);
    }
    private void insertInformation()
    {
        List<InformationEntity> informationEntities = new ArrayList<>();
        informationEntities.add(new InformationEntity("Minh", "Hoang", "09123", 1,"minh.hn123"));
        informationEntities.add(new InformationEntity("Yen", "Nguyen", "09123", 2,"yen.ng123"));
        bookingHotelViewModel.insertInformation(informationEntities);
    }
    private void insertImageHotel()
    {
        List<ImageHotel> imageHotels = new ArrayList<>();
        imageHotels.add(new ImageHotel(R.drawable.hotelvinhome,1));
        imageHotels.add(new ImageHotel(R.drawable.roomvinhome2,1));
        imageHotels.add(new ImageHotel(R.drawable.hotelnhatrang,1));
        imageHotels.add(new ImageHotel(R.drawable.img1,1));
        imageHotels.add(new ImageHotel(R.drawable.img2,1));
        imageHotels.add(new ImageHotel(R.drawable.img3,1));

        imageHotels.add(new ImageHotel(R.drawable.recentimage1, 2));
        imageHotels.add(new ImageHotel(R.drawable.nghean, 2));
        imageHotels.add(new ImageHotel(R.drawable.recentimage1, 2));
        imageHotels.add(new ImageHotel(R.drawable.recentimage2, 2));
        imageHotels.add(new ImageHotel(R.drawable.room12, 2));
        imageHotels.add(new ImageHotel(R.drawable.room23, 2));

        imageHotels.add(new ImageHotel(R.drawable.room12, 3));
        imageHotels.add(new ImageHotel(R.drawable.nghean, 3));
        imageHotels.add(new ImageHotel(R.drawable.recentimage1, 3));
        imageHotels.add(new ImageHotel(R.drawable.recentimage2, 3));
        imageHotels.add(new ImageHotel(R.drawable.room12, 3));
        imageHotels.add(new ImageHotel(R.drawable.room23, 3));

        imageHotels.add(new ImageHotel(R.drawable.recentimage2, 4));
        imageHotels.add(new ImageHotel(R.drawable.nghean, 4));
        imageHotels.add(new ImageHotel(R.drawable.recentimage1, 4));
        imageHotels.add(new ImageHotel(R.drawable.recentimage2, 4));
        imageHotels.add(new ImageHotel(R.drawable.room12, 4));
        imageHotels.add(new ImageHotel(R.drawable.room23, 4));

        imageHotels.add(new ImageHotel(R.drawable.roomnhatrang1, 5));
        imageHotels.add(new ImageHotel(R.drawable.nghean, 5));
        imageHotels.add(new ImageHotel(R.drawable.recentimage1, 5));
        imageHotels.add(new ImageHotel(R.drawable.recentimage2, 5));
        imageHotels.add(new ImageHotel(R.drawable.room12, 5));
        imageHotels.add(new ImageHotel(R.drawable.room23, 5));

        imageHotels.add(new ImageHotel(R.drawable.roomnhatrang2, 6));
        imageHotels.add(new ImageHotel(R.drawable.nghean, 6));
        imageHotels.add(new ImageHotel(R.drawable.recentimage1, 6));
        imageHotels.add(new ImageHotel(R.drawable.recentimage2, 6));
        imageHotels.add(new ImageHotel(R.drawable.room12, 6));
        imageHotels.add(new ImageHotel(R.drawable.room23, 6));

        imageHotels.add(new ImageHotel(R.drawable.roomnhatrang3, 7));
        imageHotels.add(new ImageHotel(R.drawable.nghean, 7));
        imageHotels.add(new ImageHotel(R.drawable.recentimage1, 7));
        imageHotels.add(new ImageHotel(R.drawable.recentimage2, 7));
        imageHotels.add(new ImageHotel(R.drawable.room12, 7));
        imageHotels.add(new ImageHotel(R.drawable.room23, 7));

        imageHotels.add(new ImageHotel(R.drawable.loginback, 8));
        imageHotels.add(new ImageHotel(R.drawable.nghean, 8));
        imageHotels.add(new ImageHotel(R.drawable.recentimage1, 8));
        imageHotels.add(new ImageHotel(R.drawable.recentimage2, 8));
        imageHotels.add(new ImageHotel(R.drawable.room12, 8));
        imageHotels.add(new ImageHotel(R.drawable.room23, 8));

        imageHotels.add(new ImageHotel(R.drawable.roomvinhome2, 9));
        imageHotels.add(new ImageHotel(R.drawable.nghean, 9));
        imageHotels.add(new ImageHotel(R.drawable.recentimage1, 9));
        imageHotels.add(new ImageHotel(R.drawable.recentimage2, 9));
        imageHotels.add(new ImageHotel(R.drawable.room12, 9));
        imageHotels.add(new ImageHotel(R.drawable.room23, 9));

        imageHotels.add(new ImageHotel(R.drawable.roomnhatrang3, 10));
        imageHotels.add(new ImageHotel(R.drawable.nghean, 10));
        imageHotels.add(new ImageHotel(R.drawable.recentimage1, 10));
        imageHotels.add(new ImageHotel(R.drawable.recentimage2, 10));
        imageHotels.add(new ImageHotel(R.drawable.room12, 10));
        imageHotels.add(new ImageHotel(R.drawable.room23, 10));
        bookingHotelViewModel.insertImageHotel(imageHotels);
    }
    private void insertImageRoom()
    {
        List<ImageRoom> imageRooms = new ArrayList<>();
        imageRooms.add(new ImageRoom(R.drawable.roomvinhome1, 1));
        imageRooms.add(new ImageRoom(R.drawable.roomvinhome2, 1));
        imageRooms.add(new ImageRoom(R.drawable.roomvinhome3, 1));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang1, 1));

        imageRooms.add(new ImageRoom(R.drawable.roomvinhome2,2));
        imageRooms.add(new ImageRoom(R.drawable.loginback,2));
        imageRooms.add(new ImageRoom(R.drawable.room12,2));
        imageRooms.add(new ImageRoom(R.drawable.room23,2));

        imageRooms.add(new ImageRoom(R.drawable.roomvinhome3,3));
        imageRooms.add(new ImageRoom(R.drawable.loginback,3));
        imageRooms.add(new ImageRoom(R.drawable.room12,3));
        imageRooms.add(new ImageRoom(R.drawable.roomvinhome3,3));

        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang1,4));
        imageRooms.add(new ImageRoom(R.drawable.room23,4));
        imageRooms.add(new ImageRoom(R.drawable.hotelvinhome,4));
        imageRooms.add(new ImageRoom(R.drawable.room12,4));

        imageRooms.add(new ImageRoom(R.drawable.img1,5));
        imageRooms.add(new ImageRoom(R.drawable.img2,5));
        imageRooms.add(new ImageRoom(R.drawable.img3,5));
        imageRooms.add(new ImageRoom(R.drawable.img4,5));

        imageRooms.add(new ImageRoom(R.drawable.loginback,6));
        imageRooms.add(new ImageRoom(R.drawable.loginback,6));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang2,6));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang3,6));

        imageRooms.add(new ImageRoom(R.drawable.img4,7));
        imageRooms.add(new ImageRoom(R.drawable.loginback,7));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang2,7));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang3,7));

        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang2,8));
        imageRooms.add(new ImageRoom(R.drawable.loginback,8));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang2,8));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang3,8));

        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang2,9));
        imageRooms.add(new ImageRoom(R.drawable.loginback,9));
        imageRooms.add(new ImageRoom(R.drawable.room23,9));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang3,9));


        imageRooms.add(new ImageRoom(R.drawable.room12,10));
        imageRooms.add(new ImageRoom(R.drawable.loginback,10));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang2,10));
        imageRooms.add(new ImageRoom(R.drawable.room23,10));

        for (int i = 11; i <= 33 ; i++)
        {
            imageRooms.add(new ImageRoom(R.drawable.room12,i));
            imageRooms.add(new ImageRoom(R.drawable.loginback,i));
            imageRooms.add(new ImageRoom(R.drawable.roomnhatrang2,i));
            imageRooms.add(new ImageRoom(R.drawable.room23, i));
        }
        bookingHotelViewModel.insertImageRoom(imageRooms);
    }

    private void insertHotel() {
        List<BookingHotelEntity> bookingHotelEntity = new ArrayList<>();
        bookingHotelEntity.add(new BookingHotelEntity("Nhà trọ Bình Yên", 10, "Hoàn Kiếm", "10 Hàng Trống", "Khach san co dich vu tuyet voi", "Hà Nội"));
        bookingHotelEntity.add(new BookingHotelEntity("Nhà trọ Mặt Trời", 10, "Hoàn Kiếm", "25 Hàng Trống", "Khach san co dich vu tuyet voi", "Hà Nội"));
        bookingHotelEntity.add(new BookingHotelEntity("Nhà trọ Bách Khoa", 10, "Hai Bà Trưng", "10 Hàng Đào", "Khach san co dich vu tuyet voi", "Hà Nội"));
        bookingHotelEntity.add(new BookingHotelEntity("Nhà trọ Thông Minh", 10, "Hai Bà Trưng", "25 Hàng Đào", "Khach san co dich vu tuyet voi", "Hà Nội"));
        bookingHotelEntity.add(new BookingHotelEntity("Nhà trọ Latte", 10, "Hai Bà Trưng", "10 Nhà Chung", "Khach san co dich vu tuyet voi", "Hà Nội"));
        bookingHotelEntity.add(new BookingHotelEntity("Nhà trọ Machiato", 10, "Hai Bà Trưng", "25 Nhà Chung", "Khach san co dich vu tuyet voi", "Hà Nội"));
        bookingHotelEntity.add(new BookingHotelEntity("Nhà trọ Coffee", 10, "Hai Bà Trưng", "10 Hàng Đào", "Khach san co dich vu tuyet voi", "Hà Nội"));
        bookingHotelEntity.add(new BookingHotelEntity("Nhà trọ Cold Brew", 10, "Đống Đa", "10 Hàng Đào", "Khach san co dich vu tuyet voi", "Hà Nội"));
        bookingHotelEntity.add(new BookingHotelEntity("Nhà trọ Freeze", 10, "Đống Đa", "10 Hàng Gà", "Khach san co dich vu tuyet voi", "Hà Nội"));
        bookingHotelEntity.add(new BookingHotelEntity("Nhà trọ Matcha", 10, "Đống Đa", "25 Hàng Gà", "Khach san co dich vu tuyet voi", "Hà Nội"));
        bookingHotelEntity.add(new BookingHotelEntity("Nhà trọ Strawberry", 10, "Đống Đa", "10 Mã Mây", "Khach san co dich vu tuyet voi", "Hà Nội"));
        bookingHotelViewModel.insertHotel(bookingHotelEntity);
    }

    private void insertRoom(){
        List<BookingRoomEntity> bookingRoomEntities = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            bookingRoomEntities.add(new BookingRoomEntity("Phòng Super", 2, 5000000, "Booking noti", 0, i));
            bookingRoomEntities.add(new BookingRoomEntity("Phòng Little", 2, 5000000, "Booking noti", 0, i));
            bookingRoomEntities.add(new BookingRoomEntity("Phòng Baby", 2, 5000000, "Booking noti", 0, i));
        }

        bookingHotelViewModel.insertRoom(bookingRoomEntities);
    }
}

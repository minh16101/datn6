package com.example.testdbentity.homefragment.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.MainPageActivity;
import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;

public class DisplayPaymentHotelActivity extends AppCompatActivity {

    private int idUser;
    private int idRoom;
    private int idHotel;
    private int moneyValue;

    private BookingHotelViewModel bookingHotelViewModel;
    private InformationEntity informationEntity;

    private TextView nameTv;
    private TextView emailTv;
    private TextView phoneTv;

    private TextView hotelNametv;
    private TextView roomNametv;
    private TextView addresstv;
    private TextView fromTimetv;
    private TextView toTimetv;
    private TextView payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_payment_hotel);
        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);

        getView();
        getIntentData();
        getInformationUser();
        getInformationHotel();

        Button booking = findViewById(R.id.payment_hotel_button);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayPaymentHotelActivity.this, MainPageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getIntentData()
    {
        idUser = getIntent().getIntExtra("userId", 1);
        idRoom = getIntent().getIntExtra("roomId", 1);
        idHotel = getIntent().getIntExtra("hotelId", 1);
        moneyValue = getIntent().getIntExtra("money", 1);
    }
    private void getInformationUser() {
        informationEntity = bookingHotelViewModel.getBookingRoomUser(idUser);
        String name = informationEntity.firstNaeInformationUser + " " + informationEntity.lastNaeInformationUser;
        String email = informationEntity.emailInformationUser;
        String number = informationEntity.numberInformationUser;

        nameTv.setText(name);
        emailTv.setText(email);
        phoneTv.setText(number);
    }
    private void getInformationHotel()
    {
        BookingRoomEntity bookingRoomEntity = bookingHotelViewModel.getRoomById(idRoom);
        BookingHotelEntity bookingHotelEntity = bookingHotelViewModel.getHotelById(idHotel);

        String hotelRoom = bookingHotelEntity.nameBookingHotel;
        String addressHotel = bookingHotelEntity.addressBookingHotel;
        String nameRoom = bookingRoomEntity.nameBookingRoom;
        String timeFromBook = bookingRoomEntity.day+"/"+bookingRoomEntity.month+"/"+bookingRoomEntity.year;
        int toDate = bookingRoomEntity.day + bookingRoomEntity.during;
        String timeToBook = String.valueOf(toDate)+"/"+bookingRoomEntity.month+"/"+bookingRoomEntity.year;

        hotelNametv.setText(hotelRoom);
        roomNametv.setText(nameRoom);
        addresstv.setText(addressHotel);
        fromTimetv.setText(timeFromBook);
        toTimetv.setText(timeToBook);
        payment.setText(String.valueOf(moneyValue));
    }
    private void getView() {
        nameTv = findViewById(R.id.name_user_room_payment_value);
        emailTv = findViewById(R.id.name_gmail_room_payment_value);
        phoneTv = findViewById(R.id.phone_room_payment_value);

        hotelNametv = findViewById(R.id.name_hotel_payment);
        roomNametv = findViewById(R.id.name_room_payment_value);
        addresstv = findViewById(R.id.address_room_payment_value);
        fromTimetv = findViewById(R.id.from_time_room_payment_value);
        toTimetv = findViewById(R.id.to_time_room_payment_value);

        payment = findViewById(R.id.money_payment_hotel);
    }
}
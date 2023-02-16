package com.example.testdbentity.homefragment.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.adapter.ItemImageAdapter;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;
import com.example.testdbentity.homefragment.bookinghotel.image.hotelandimg.HotelWithImage;

import java.util.List;

public class DisplayDetailHotelActivity extends AppCompatActivity {

    private int idUser;
    private int idHotel;
    private int[] timeFrom;
    private int[] timeTo;

    private BookingHotelViewModel bookingHotelViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_detail_hotel);
        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);
        getIntentFromDisplayHotel();
        getImageHotel();
        fillDataDetailHotel();
        setOnClickHotelDetail();
    }

    private void getIntentFromDisplayHotel() {
        idUser = getIntent().getIntExtra("idInformationUser", 0);
        idHotel = getIntent().getIntExtra("idHotel", 0);
        timeFrom = getIntent().getIntArrayExtra("timeFrom");
        timeTo = getIntent().getIntArrayExtra("timeTo");
    }

    private void getImageHotel()
    {
        RecyclerView detailImageRecyclerView = findViewById(R.id.recycler_image_detail);
        detailImageRecyclerView.setNestedScrollingEnabled(false);
        ItemImageAdapter itemImageAdapter = new ItemImageAdapter();
        bookingHotelViewModel.getImageOfaHotel(idHotel).observe(this, new Observer<HotelWithImage>() {
            @Override
            public void onChanged(HotelWithImage hotelWithImage) {
                itemImageAdapter.setListPathImage(hotelWithImage.imageHotelList);
                itemImageAdapter.notifyDataSetChanged();
            }
        });
        detailImageRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        detailImageRecyclerView.setAdapter(itemImageAdapter);
    }

    private void fillDataDetailHotel()
    {
        setNameHotel();
        setDayBookHotel();
        setAddress();
    }

    private void setOnClickHotelDetail()
    {
        showAllRoom();
    }
    private void setNameHotel()
    {
        TextView nameVnHotel = findViewById(R.id.name_vn_hotel_detail);
        TextView nameUkHotel = findViewById(R.id.name_uk_hotel_detail);

        BookingHotelEntity bookingHotelEntity = bookingHotelViewModel.getHotelById(idHotel);
        String nameHotel = bookingHotelEntity.nameBookingHotel;
        String vnNameHotel = "Nhà trọ " + nameHotel;
        String ukNameHotel = nameHotel + " Motel";

        nameVnHotel.setText(vnNameHotel);
        nameUkHotel.setText(ukNameHotel);
    }
    private void setDayBookHotel()
    {
        TextView startDay = findViewById(R.id.start_day_room_book);
        TextView endDay = findViewById(R.id.end_day_room_book);

        String startTime = String.valueOf(timeFrom[0]) + " tháng " + String.valueOf(timeFrom[1]) + " năm " + String.valueOf(timeFrom[2]);
        String endTime = String.valueOf(timeTo[0]) + " tháng " + String.valueOf(timeTo[1]) + " năm " + String.valueOf(timeTo[2]);

        startDay.setText(startTime);
        endDay.setText(endTime);

    }

    private void setAddress()
    {
        TextView address = findViewById(R.id.address_detail_hotel);
        BookingHotelEntity hotelWithImage = bookingHotelViewModel.getHotelById(idHotel);
        address.setText(hotelWithImage.addressBookingHotel);
    }

    private void showAllRoom()
    {
        Button buttonShowAllRoom1 = findViewById(R.id.button_show_all_room_1);
        Button buttonShowAllRoom2 = findViewById(R.id.button_show_all_room_2);
        buttonShowAllRoom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayDetailHotelActivity.this, DisplayRoomActivity.class);
                intent.putExtra("idHotel", idHotel);
                intent.putExtra("idInformationUser", idUser);
                intent.putExtra("timeFrom", timeFrom);
                intent.putExtra("timeTo", timeTo);
                startActivity(intent);
            }
        });
        buttonShowAllRoom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayDetailHotelActivity.this, DisplayRoomActivity.class);
                intent.putExtra("idHotel", idHotel);
                intent.putExtra("idInformationUser", idUser);
                intent.putExtra("timeFrom", timeFrom);
                intent.putExtra("timeTo", timeTo);
                startActivity(intent);
            }
        });
    }
}

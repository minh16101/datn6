package com.example.testdbentity.shoppingfragment.hotelshopping;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.BookingRoomEntity;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;
import com.example.testdbentity.homefragment.bookinghotel.image.roomandimg.RoomWithImage;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator3;

public class HotelShoppingFragment extends Fragment {

    private BookingHotelViewModel bookingHotelViewModel;
    private ImageView imgRoom1, imgRoom2, imgRoom3, imgRoom4;
    private TextView checkIntv, checkOuttv, pricetv, nameRoomtv;
    private int idUser;
    public HotelShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotel_shopping, container, false);
        bindViewItem(view);
        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);
        getIntentItem();
        LiveData<BookingRoomEntity> bookingRoomEntity = bookingHotelViewModel.getRoomWasBookedWithIdUser(idUser);
        bookingRoomEntity.observe(getActivity(), new Observer<BookingRoomEntity>() {
            @Override
            public void onChanged(BookingRoomEntity bookingRoomEntity) {
                if(bookingRoomEntity != null) {
                    RoomWithImage roomWithImage = bookingHotelViewModel.getAllImageOfRoomWithIdRoom(bookingRoomEntity.idBookingRoom);
                    imgRoom1.setImageResource(roomWithImage.imageRooms.get(0).srcImageRoom);
                    imgRoom2.setImageResource(roomWithImage.imageRooms.get(1).srcImageRoom);
                    imgRoom3.setImageResource(roomWithImage.imageRooms.get(2).srcImageRoom);
                    imgRoom4.setImageResource(roomWithImage.imageRooms.get(3).srcImageRoom);
                }

            }
        });
        return view;
    }
    private void bindViewItem(View view)
    {
        imgRoom1 = view.findViewById(R.id.shopping_image_room_detail_1);
        imgRoom2 = view.findViewById(R.id.shopping_image_room_detail_2);
        imgRoom3 = view.findViewById(R.id.shopping_image_room_detail_3);
        imgRoom4 = view.findViewById(R.id.shopping_image_room_detail_4);

        checkIntv = view.findViewById(R.id.shopping_check_in_room_detail);
        checkOuttv = view.findViewById(R.id.shopping_check_out_room_detail);
        pricetv = view.findViewById(R.id.shopping_price_room_detail);
        nameRoomtv = view.findViewById(R.id.shopping_name_of_room_detail);



    }
    private void getIntentItem()
    {
        idUser = getActivity().getIntent().getIntExtra("idUserInformation", 0);
    }
}
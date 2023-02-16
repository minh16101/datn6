package com.example.testdbentity.homefragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.adapter.CarScrollAdapter;
import com.example.testdbentity.homefragment.adapter.CarScrollModel;
import com.example.testdbentity.homefragment.adapter.HotelScrollAdapter;
import com.example.testdbentity.homefragment.adapter.HotelScrollModel;
import com.example.testdbentity.homefragment.adapter.OnClickInScrollItemCar;
import com.example.testdbentity.homefragment.adapter.OnClickInScrollItemHotel;
import com.example.testdbentity.homefragment.bookingcar.DisplayCarActivity;
import com.example.testdbentity.homefragment.bookinghotel.DisplayHotelActivity;
import com.example.testdbentity.homefragment.bookinghotel.SearchHotelActivity;
import com.example.testdbentity.homefragment.weather.WeatherMainActivity;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private AppBarLayout appBarLayout;
    private int idInformationUser;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        idInformationUser = getActivity().getIntent().getIntExtra("idUserInformation", 0);
        clickButton(view);
        appBarLayout = view.findViewById(R.id.app_bar);

        List<CarScrollModel> carScrollModelList = new ArrayList<>();
        carScrollModelList.add(new CarScrollModel(R.drawable.hanoi, "Ha Noi", "Nghe An"));
        carScrollModelList.add(new CarScrollModel(R.drawable.nghean, "Ha Noi", "Nghe An"));
        carScrollModelList.add(new CarScrollModel(R.drawable.hanoi, "Ha Noi", "Thanh Hoa"));
        carScrollModelList.add(new CarScrollModel(R.drawable.thanhhoa, "Ha Noi", "Thanh Hoa"));

        List<HotelScrollModel> hotelScrollModels = new ArrayList<>();
        hotelScrollModels.add(new HotelScrollModel(R.drawable.hanoi, "Ha Noi"));
        hotelScrollModels.add(new HotelScrollModel(R.drawable.nghean, "Nghe An"));
        hotelScrollModels.add(new HotelScrollModel(R.drawable.thanhhoa, "Thanh Hoa"));

        RecyclerView recyclerView1 = view.findViewById(R.id.recycler_view_car_from_scroll_main);
        RecyclerView recyclerView2 = view.findViewById(R.id.recycler_view_hotel_from_scroll_main);

        recyclerView1.setNestedScrollingEnabled(false);
        recyclerView2.setNestedScrollingEnabled(false);

        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        CarScrollAdapter carScrollAdapter = new CarScrollAdapter(carScrollModelList);
        carScrollAdapter.setOnClickInScrollItemCar(new OnClickInScrollItemCar() {
            @Override
            public void onClickItemCar(int position) {
                String startPlace = carScrollModelList.get(position).getText1();
                String endPlace = carScrollModelList.get(position).getText2();
                Intent intent = new Intent(getActivity(), DisplayCarActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("idInformationUser", idInformationUser);
                intent.putExtra("startPlace", startPlace);
                intent.putExtra("endPlace", endPlace);
                startActivity(intent);
            }
        });
        recyclerView1.setAdapter(carScrollAdapter);

        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        HotelScrollAdapter hotelScrollAdapter = new HotelScrollAdapter(hotelScrollModels);
        hotelScrollAdapter.setOnClickInScrollItemHotel(new OnClickInScrollItemHotel() {
            @Override
            public void onClickItemHotel(int position) {
                String city = hotelScrollModels.get(position).getText1();
                Intent intent = new Intent(getActivity(), DisplayHotelActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("idInformationUser", idInformationUser);
                intent.putExtra("cityHotel", city);
                startActivity(intent);
            }
        });
        recyclerView2.setAdapter(hotelScrollAdapter);
        return view;
    }
    private void clickButton(View view)
    {
        CardView cardViewCar = view.findViewById(R.id.cardview_board_home_fragment1);
        CardView cardViewHotel = view.findViewById(R.id.cardview_board_home_fragment2);
        CardView weatherCardView = view.findViewById(R.id.card_view_weather_home);
        CardView weatherCardView1 = view.findViewById(R.id.cardview_board_home_fragment4);

        weatherCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WeatherMainActivity.class);
                intent.putExtra("idInformationUser", idInformationUser);
                startActivity(intent);
            }
        });
        weatherCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WeatherMainActivity.class);
                intent.putExtra("idInformationUser", idInformationUser);
                startActivity(intent);
            }
        });

        cardViewCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DisplayCarActivity.class);
                intent.putExtra("idInformationUser", idInformationUser);
                startActivity(intent);
            }
        });

        cardViewHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchHotelActivity.class);
                intent.putExtra("idInformationUser", idInformationUser);
                startActivity(intent);
            }
        });
    }
}
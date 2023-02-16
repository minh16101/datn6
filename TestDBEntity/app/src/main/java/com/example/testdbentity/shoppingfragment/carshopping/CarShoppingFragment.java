package com.example.testdbentity.shoppingfragment.carshopping;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookingcar.carwithseat.CarWithSeat;
import com.example.testdbentity.homefragment.bookingcar.viewmodel.BookingCarViewModel;
import com.example.testdbentity.shoppingfragment.carshopping.adapter.CarBookingAdapter;

import java.util.List;


public class CarShoppingFragment extends Fragment {

    private BookingCarViewModel bookingCarViewModel;

    public CarShoppingFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_car_shopping, container, false);
        bookingCarViewModel = new ViewModelProvider(this).get(BookingCarViewModel.class);
        LiveData<List<CarWithSeat>> carWithSeat = bookingCarViewModel.getListBookingCarWithBookingSeat();
        CarBookingAdapter carBookingAdapter = new CarBookingAdapter();

        carWithSeat.observe(getActivity(), new Observer<List<CarWithSeat>>() {
            @Override
            public void onChanged(List<CarWithSeat> carWithSeats) {
                carBookingAdapter.setData(carWithSeats);
                carBookingAdapter.notifyDataSetChanged();
            }
        });
        //carwithseat nay de cho vao recycler view
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_car_shopping);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(carBookingAdapter);
        return view;
    }
}
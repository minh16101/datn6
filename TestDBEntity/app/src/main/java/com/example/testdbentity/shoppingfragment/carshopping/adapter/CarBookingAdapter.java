package com.example.testdbentity.shoppingfragment.carshopping.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookingcar.carwithseat.CarWithSeat;

import java.util.ArrayList;
import java.util.List;

public class CarBookingAdapter extends RecyclerView.Adapter<CarBookingAdapter.CarBookingAHolder> {
    List<CarWithSeat> carWithSeat = new ArrayList<>();

    public CarBookingAdapter() {
    }
    public void setData(List<CarWithSeat> carWithSeat)
    {
        this.carWithSeat = carWithSeat;
    }

    @NonNull
    @Override
    public CarBookingAHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_shopping_car, parent, false);
        return new CarBookingAHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarBookingAHolder holder, int position) {
        CarWithSeat carWithSeatItem = carWithSeat.get(position);
        holder.imageView.setImageResource(carWithSeatItem.bookingCarEntity.srcBookingCar);
        holder.textViewFrom.setText(carWithSeatItem.bookingCarEntity.startPlaceBookingCar);
        holder.textViewTo.setText(carWithSeatItem.bookingCarEntity.endPlaceBookingCar);
        holder.textViewName.setText(carWithSeatItem.bookingCarEntity.nameBookingCar);
        holder.textViewStart.setText(String.valueOf(carWithSeatItem.bookingCarEntity.dayBookingCar) + "/" + String.valueOf(carWithSeatItem.bookingCarEntity.monthBookingCar) + "/" + String.valueOf(carWithSeatItem.bookingCarEntity.yearBookingCar));
    }

    @Override
    public int getItemCount() {
        return carWithSeat.size();
    }

    public class CarBookingAHolder extends RecyclerView.ViewHolder
    {
        private ImageView imageView;
        private TextView textViewName;
        private TextView textViewFrom;
        private TextView textViewTo;
        private TextView textViewStart;
        public CarBookingAHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_car_shopping);
            textViewName = itemView.findViewById(R.id.name_car_shopping);
            textViewFrom = itemView.findViewById(R.id.from_car_shopping);
            textViewTo = itemView.findViewById(R.id.to_car_shopping);
            textViewStart = itemView.findViewById(R.id.starttime_car_shopping);
        }
    }
}

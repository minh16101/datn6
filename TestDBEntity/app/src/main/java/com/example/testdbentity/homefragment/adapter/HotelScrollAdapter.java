package com.example.testdbentity.homefragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdbentity.R;

import java.util.ArrayList;
import java.util.List;

public class HotelScrollAdapter extends RecyclerView.Adapter<HotelScrollAdapter.HotelScrollHolder> {
    List<HotelScrollModel> hotelScrollModelList = new ArrayList<>();
    OnClickInScrollItemHotel onClickInScrollItemHotel;

    public HotelScrollAdapter(List<HotelScrollModel> hotelScrollModelList) {
        this.hotelScrollModelList = hotelScrollModelList;
    }

    public void setOnClickInScrollItemHotel(OnClickInScrollItemHotel onClickInScrollItemHotel)
    {
        this.onClickInScrollItemHotel = onClickInScrollItemHotel;
    }
    @NonNull
    @Override
    public HotelScrollHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scroll_hotel, parent, false);
        return new HotelScrollAdapter.HotelScrollHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelScrollHolder holder, int position) {
        HotelScrollModel hotelScrollModel = hotelScrollModelList.get(position);
        int tempposition = position;
        holder.imageView.setImageResource(hotelScrollModel.getSrc());
        holder.textView1.setText(hotelScrollModel.getText1());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickInScrollItemHotel.onClickItemHotel(tempposition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelScrollModelList.size();
    }

    public class HotelScrollHolder extends RecyclerView.ViewHolder
    {
        private ImageView imageView;
        private TextView textView1;
        private CardView cardView;
        public HotelScrollHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_scroll_hotel);
            textView1 = itemView.findViewById(R.id.tv_scroll_location_1_hotel);
            cardView = itemView.findViewById(R.id.card_view_booking_hotel);
        }
    }
}

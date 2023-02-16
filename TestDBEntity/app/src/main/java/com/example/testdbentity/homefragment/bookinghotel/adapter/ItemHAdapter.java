package com.example.testdbentity.homefragment.bookinghotel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.image.hotelandimg.HotelWithImage;

import java.util.List;

public class ItemHAdapter extends RecyclerView.Adapter<ItemHAdapter.ItemHHolder> {
    private List<HotelWithImage> imageHotelList;
    private OnClickHotel onClickHotel;
    public ItemHAdapter(List<HotelWithImage> imageHotelList) {
        this.imageHotelList = imageHotelList;
    }
    public void setOnClickHotel(OnClickHotel onClickHotel)
    {
        this.onClickHotel = onClickHotel;
    }

    public void setData(List<HotelWithImage> imageHotelList){
        this.imageHotelList = imageHotelList;
    }
    @NonNull
    @Override
    public ItemHHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_h, parent, false);
        return new ItemHHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHHolder holder, int position) {
        HotelWithImage hotelWithImage = imageHotelList.get(position);
        holder.imageView.setImageResource(hotelWithImage.imageHotelList.get(0).srcImageHotel);
        holder.nameH.setText(hotelWithImage.bookingHotelEntity.nameBookingHotel);
        holder.addressH.setText(hotelWithImage.bookingHotelEntity.addressBookingHotel);
        holder.priceH.setText("500USD");
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHotel.onClickAHotel(hotelWithImage.bookingHotelEntity.idBookingHotel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageHotelList.size();
    }

    public class ItemHHolder extends RecyclerView.ViewHolder
    {
        private ImageView imageView;
        private TextView nameH;
        private TextView addressH;
        private TextView priceH;
        private CardView cardView;
        public ItemHHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_h);
            nameH = itemView.findViewById(R.id.name_h);
            addressH = itemView.findViewById(R.id.address_h);
            priceH = itemView.findViewById(R.id.price_h);
            cardView = itemView.findViewById(R.id.cardview_h);
        }
    }
}

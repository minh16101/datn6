package com.example.testdbentity.homefragment.bookinghotel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.image.roomandimg.RoomWithImage;

import java.util.List;

public class ItemSAdapter extends RecyclerView.Adapter<ItemSAdapter.ItemSHolder> {
    List<RoomWithImage> roomWithImageList;
    public ItemSAdapter(List<RoomWithImage> roomWithImageList) {
        this.roomWithImageList = roomWithImageList;
    }
    public void setData(List<RoomWithImage> roomWithImageList ){
        this.roomWithImageList = roomWithImageList;
    }
    @NonNull
    @Override
    public ItemSHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_s, parent, false);
        return new ItemSHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemSHolder holder, int position) {
        RoomWithImage roomWithImage = roomWithImageList.get(position);

        holder.imageView.setImageResource(roomWithImage.imageRooms.get(0).srcImageRoom);
        holder.nameH.setText(roomWithImage.bookingRoomEntity.nameBookingRoom);
        holder.addressH.setText(roomWithImage.bookingRoomEntity.notiBookingHotel);
        holder.priceH.setText(String.valueOf(roomWithImage.bookingRoomEntity.priceBookingRoom));
    }

    @Override
    public int getItemCount() {
        return roomWithImageList.size();
    }

    public class ItemSHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView nameH;
        private TextView addressH;
        private TextView priceH;
        public ItemSHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_s);
            nameH = itemView.findViewById(R.id.name_s);
            addressH = itemView.findViewById(R.id.address_s);
            priceH = itemView.findViewById(R.id.price_s);
        }
    }
}

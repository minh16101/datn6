package com.example.testdbentity.homefragment.bookinghotel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.image.roomandimg.RoomWithImage;

import java.util.List;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder> {
    private List<RoomWithImage> roomWithImageList;
    private OnclickToDetail onclickToDetail;

    public RecentsAdapter(List<RoomWithImage> roomWithImageList) {
        this.roomWithImageList = roomWithImageList;
    }

    public void setOnclickToDetail(OnclickToDetail onclickToDetail) {
        this.onclickToDetail = onclickToDetail;
    }

    public void setRoomWithImageList(List<RoomWithImage> roomWithImageList) {
        this.roomWithImageList = roomWithImageList;
    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recents, parent, false);
        return new RecentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {
        RoomWithImage roomWithImage = roomWithImageList.get(position);
        holder.imageView.setImageResource(roomWithImage.imageRooms.get(0).srcImageRoom);
        holder.nameTv.setText(roomWithImage.bookingRoomEntity.nameBookingRoom);
        holder.placeTv.setText(String.valueOf(roomWithImage.bookingRoomEntity.priceBookingRoom) + "VND");
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickToDetail.OnClick(roomWithImage.bookingRoomEntity.idBookingRoom);
            }
        });
    }

    @Override
    public int getItemCount() {
        return roomWithImageList.size();
    }

    public class RecentsViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView placeTv;
        private TextView nameTv;
        private ConstraintLayout constraintLayout;
        public RecentsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image_recent);
            placeTv = itemView.findViewById(R.id.item_name_place_recent);
            nameTv = itemView.findViewById(R.id.item_country_recent);
            constraintLayout = itemView.findViewById(R.id.item_recent_btn);

        }
    }
}

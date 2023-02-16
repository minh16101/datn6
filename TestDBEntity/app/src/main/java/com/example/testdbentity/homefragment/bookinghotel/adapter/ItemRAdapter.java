package com.example.testdbentity.homefragment.bookinghotel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.testdbentity.R;
import com.example.testdbentity.accountfragment.SlideImageAdapter;
import com.example.testdbentity.homefragment.bookinghotel.image.roomandimg.RoomWithImage;

import java.util.List;

public class ItemRAdapter extends RecyclerView.Adapter<ItemRAdapter.ItemRHolder> {
    List<RoomWithImage> roomWithImageList;
    OnClickRoom onClickRoom;
    Context context;
    public ItemRAdapter(List<RoomWithImage> roomWithImageList) {
        this.roomWithImageList = roomWithImageList;
    }
    public void setOnClickRoom(OnClickRoom onClickRoom)
    {
        this.onClickRoom = onClickRoom;
    }

    public void setData(List<RoomWithImage> roomWithImageList)
    {
        this.roomWithImageList = roomWithImageList;
    }
    @NonNull
    @Override
    public ItemRHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room_activity, parent, false);
        return new ItemRHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRHolder holder, int position) {
        RoomWithImage roomWithImage = roomWithImageList.get(position);

        int[] arr = new int[4];
        for (int i = 0; i < 4; i++)
        {
            arr[i] = roomWithImage.imageRooms.get(i).srcImageRoom;
        }
        SlideImageAdapter slideImageAdapter = new SlideImageAdapter(context, arr);
        holder.imageView.setAdapter(slideImageAdapter);
        holder.imageView.setCurrentItem(0);
        holder.nameH.setText(roomWithImage.bookingRoomEntity.nameBookingRoom);
        holder.priceH.setText(String.valueOf(roomWithImage.bookingRoomEntity.priceBookingRoom));
//        holder.dientichRoom.setText(roomWithImage.bookingRoomEntity.dientichBookingHotel);

        holder.showDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRoom.onShowDetailRoom(roomWithImage.bookingRoomEntity.idBookingRoom);
            }
        });
    }

    @Override
    public int getItemCount() {
        return roomWithImageList.size();
    }

    public class ItemRHolder extends RecyclerView.ViewHolder{
        private ViewPager imageView;
        private TextView nameH;
        private TextView priceH;
        private TextView dientichRoom;
        private Button showDetail;
        public ItemRHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_room_activity);
            nameH = itemView.findViewById(R.id.name_room_activity);
            priceH = itemView.findViewById(R.id.price_of_room);
            showDetail = itemView.findViewById(R.id.button_show_detail_room);
            dientichRoom = itemView.findViewById(R.id.dien_tich_room);
        }
    }
}

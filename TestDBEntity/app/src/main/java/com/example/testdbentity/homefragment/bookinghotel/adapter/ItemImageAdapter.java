package com.example.testdbentity.homefragment.bookinghotel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageHotel;
import com.example.testdbentity.homefragment.bookinghotel.image.hotelandimg.HotelWithImage;

import java.util.List;

public class ItemImageAdapter extends RecyclerView.Adapter<ItemImageAdapter.ItemImageViewHolder> {
    private List<ImageHotel> listPathImage;

    public ItemImageAdapter() {
    }

    public void setListPathImage(List<ImageHotel> listPathImage) {
        this.listPathImage = listPathImage;
    }

    @NonNull
    @Override
    public ItemImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_image_room, parent, false);
        return new ItemImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemImageViewHolder holder, int position) {
        ImageHotel temp = listPathImage.get(position);
        holder.imageView.setImageResource(temp.srcImageHotel);
    }

    @Override
    public int getItemCount() {
        return listPathImage.size();
    }

    public class ItemImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public ItemImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image_detail);
        }
    }
}

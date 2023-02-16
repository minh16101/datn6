package com.example.testdbentity.accountfragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testdbentity.R;

import java.util.List;
interface OnClickImageAccount{
    public void setOnClickImageAccount(int position);
}
public class ItemImageAdapter extends RecyclerView.Adapter<ItemImageAdapter.ItemImageHolder> {
    List<String> listPaths;
    private OnClickImageAccount onClickImageAccount;

    public void setOnClickImageAccount(OnClickImageAccount onClickImageAccount) {
        this.onClickImageAccount = onClickImageAccount;
    }

    public ItemImageAdapter(List<String> listPaths) {
        this.listPaths = listPaths;
    }

    public void setListPaths(List<String> listPaths) {
        this.listPaths = listPaths;
    }

    @NonNull
    @Override
    public ItemImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_account, parent, false);
        return new ItemImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemImageHolder holder, int position) {
        String path = listPaths.get(position);
        Glide.with(holder.imageView).load(path).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickImageAccount.setOnClickImageAccount(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPaths.size();
    }

    public class ItemImageHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ItemImageHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_account_view);
        }
    }
}

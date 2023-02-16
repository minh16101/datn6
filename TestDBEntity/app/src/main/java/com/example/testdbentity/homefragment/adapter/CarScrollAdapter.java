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

public class CarScrollAdapter extends RecyclerView.Adapter<CarScrollAdapter.CarScrollHolder> {
    List<CarScrollModel> carScrollModelList = new ArrayList<>();
    private OnClickInScrollItemCar onClickInScrollItemCar;
    public CarScrollAdapter(List<CarScrollModel> carScrollModelList) {
        this.carScrollModelList = carScrollModelList;
    }

    public void setOnClickInScrollItemCar(OnClickInScrollItemCar onClickInScrollItemCar){
        this.onClickInScrollItemCar = onClickInScrollItemCar;
    }
    @NonNull
    @Override
    public CarScrollHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scroll_car, parent, false);
        return new CarScrollHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarScrollHolder holder, int position) {
        CarScrollModel carScrollModel = carScrollModelList.get(position);
        int pos = position;
        holder.imageView.setImageResource(carScrollModel.getSrc());
        holder.textView1.setText(carScrollModel.getText1());
        holder.textView2.setText(carScrollModel.getText2());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickInScrollItemCar.onClickItemCar(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carScrollModelList.size();
    }

    public class CarScrollHolder extends RecyclerView.ViewHolder
    {
        private CardView cardView;
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;
        public CarScrollHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_scroll_car);
            textView1 = itemView.findViewById(R.id.tv_scroll_location_2);
            textView2 = itemView.findViewById(R.id.tv_scroll_location_1);
            cardView = itemView.findViewById(R.id.cardview_scroll_car);
        }
    }
}

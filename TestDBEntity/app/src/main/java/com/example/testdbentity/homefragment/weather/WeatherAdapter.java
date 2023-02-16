package com.example.testdbentity.homefragment.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdbentity.R;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherHolder> {
    private Context context;
    private ArrayList<WeatherModel> weatherModels;

    public WeatherAdapter(Context context, ArrayList<WeatherModel> weatherModels) {
        this.context = context;
        this.weatherModels = weatherModels;
    }

    public void setData(ArrayList<WeatherModel> weatherModels)
    {
        this.weatherModels = weatherModels;
    }
    @NonNull
    @Override
    public WeatherAdapter.WeatherHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);
        return new WeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherHolder holder, int position) {
        WeatherModel weatherModel = weatherModels.get(position);
        holder.temperature.setText(weatherModel.getTemperature());
        holder.wind.setText(weatherModel.getWindSpeed()+"Km/h");
        Picasso.get().load("https:".concat(weatherModel.getIcon())).into(holder.condition);
        SimpleDateFormat simpleDateFormatIn = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("hh:mm aa");

        try {
            Date t = simpleDateFormatIn.parse(weatherModel.getTime());
            holder.time.setText(simpleDateFormatOut.format(t));
        }
        catch (ParseException e)
        {

        }
    }

    @Override
    public int getItemCount() {
        return weatherModels.size();
    }

    public class WeatherHolder extends RecyclerView.ViewHolder{
        private TextView wind, temperature, time;
        private ImageView condition;
        public WeatherHolder(@NonNull View itemView) {
            super(itemView);
            wind = itemView.findViewById(R.id.weather_item_wind);
            temperature = itemView.findViewById(R.id.item_weather_tv_temperature);
            time = itemView.findViewById(R.id.item_weather_tv_time);
            condition = itemView.findViewById(R.id.item_weather_tv_condition);
        }
    }
}

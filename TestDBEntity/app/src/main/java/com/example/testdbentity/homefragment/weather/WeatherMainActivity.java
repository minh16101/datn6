package com.example.testdbentity.homefragment.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.testdbentity.R;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WeatherMainActivity extends AppCompatActivity {

    private RelativeLayout homeLa;
    private ProgressBar loadingbar;
    private TextView cityName, temperature, condition;
    private RecyclerView recyclerViewWeather;
    private TextInputEditText cityEdit;
    private ImageView backIm, iconIm, searchIm;
    private ArrayList<WeatherModel> weatherModels;
    private WeatherAdapter weatherAdapter;
    private LocationManager locationManager;
    private int PERMISSION_CODE = 1;
    private String cityNameTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_main);
        homeLa = findViewById(R.id.relative_layout_weather);
//        loadingbar = findViewById(R.id.progress_weather);
        cityName = findViewById(R.id.city_name_weather);
        temperature = findViewById(R.id.text_temperature_weather);
        condition = findViewById(R.id.text_condition_weather);
        recyclerViewWeather = findViewById(R.id.recycler_weather);
        cityEdit = findViewById(R.id.text_input_edit_city_weather);
        backIm = findViewById(R.id.id_bg_weather);
        iconIm = findViewById(R.id.icon_temperature_weather);
        searchIm = findViewById(R.id.iccon_search_weather);

        //recycler view
        weatherModels = new ArrayList<>();
        weatherAdapter = new WeatherAdapter(this, weatherModels);
        recyclerViewWeather.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        recyclerViewWeather.setAdapter(weatherAdapter);

        //yeu cau cap quyen
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(WeatherMainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_CODE);

        }

        //lay dia diem hien tai
//        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//        cityNameTemp = getCityName(location.getLongitude(), location.getLatitude());
        cityNameTemp = "Hanoi";
        getWeatherInfor(cityNameTemp);

        searchIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nCity = cityEdit.getText().toString();
                if (nCity.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Khong co thanh pho nay", Toast.LENGTH_SHORT).show();
                } else {
                    cityName.setText(cityNameTemp);
                    getWeatherInfor(nCity);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSION_CODE)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
//                Toast.makeText()
            }
            else
            {
                finish();
            }
        }
    }

    //lay ten thanh pho hien tai
    private String getCityName(double longitude, double lastitude) {
        String nameCity = "Not found";
        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

        try {
            List<Address> addresses = geocoder.getFromLocation(lastitude, longitude, 10);
            for (Address adr : addresses) {
                if(adr != null)
                {
                    String city = adr.getLocality();
                    if(city != null && !city.equals(""))
                    {
                        nameCity = city;
                    }
                    else
                    {

                    }
                }
            }
        }
        catch (IOException e)
        {

        }
        return nameCity;
    }
    private void getWeatherInfor(String cName)
    {

        String url = "https://api.weatherapi.com/v1/forecast.json?key=a784939d2aff4017a9240027232301&q="+cName+"&days=1&aqi=yes&alerts=yes";

        cityName.setText(cName);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //lam cai loading
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                weatherModels.clear();
                try {
                    String temperatureTemp = response.getJSONObject("current").getString("temp_c");
                    temperature.setText(temperatureTemp+"*C");
                    int isDay = response.getJSONObject("current").getInt("is_day");
                    String conditionTemp = response.getJSONObject("current").getJSONObject("condition").getString("text");
                    String conditionIcon = response.getJSONObject("current").getJSONObject("condition").getString("icon");

                    Picasso.get().load("https:".concat(conditionIcon)).into(iconIm);
                    condition.setText(conditionTemp);
//                    if(isDay == 1)
//                    {
//                        Picasso.get().load("http:".concat("")).into(backIm);
//                    }
//                    else {
//                        Picasso.get().load("http:".concat("")).into(backIm);
//                    }
                    JSONObject forcaseJSON = response.getJSONObject("forecast");
                    JSONObject forcaseO = forcaseJSON.getJSONArray("forecastday").getJSONObject(0);
                    JSONArray hourArray = forcaseO.getJSONArray("hour");

                    for (int i = 0; i < hourArray.length(); i++) {
                        JSONObject hourObj = hourArray.getJSONObject(i);
                        String time = hourObj.getString("time");
                        String temper = hourObj.getString("temp_c");
                        String img = hourObj.getJSONObject("condition").getString("icon");
                        String wind = hourObj.getString("wind_kph");

                        weatherModels.add(new WeatherModel(time, temper, img, wind));
                    }
                    weatherAdapter.setData(weatherModels);
                    weatherAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //cho toast
                cityName.setText(error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
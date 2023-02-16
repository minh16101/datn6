package com.example.testdbentity.homefragment.bookingcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.MainPageActivity;
import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookingcar.viewmodel.BookingCarViewModel;

public class DisplaySuccessPaymentCarActivity extends AppCompatActivity {
    private BookingCarViewModel bookingCarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_success_payment_car);

        ImageButton btn1 = findViewById(R.id.back_after_success_bill_car);
        ImageButton btn2 = findViewById(R.id.home_after_success_bill_car);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToHome();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToHome();
            }
        });
        bookingCarViewModel = new ViewModelProvider(this).get(BookingCarViewModel.class);

        int idPeople = getIntent().getIntExtra("idUserSuccess", 1);
        int cost = getIntent().getIntExtra("priceSuccess", 0);
        String nameNhaXe = getIntent().getStringExtra("nameNhaXeSuccess");


        TextView userNameCar = findViewById(R.id.username_of_car_after_bill_value);
        TextView costCar = findViewById(R.id.money_total_success_value);
        TextView nhaxeNameCar = findViewById(R.id.nhaxe_user_value);

        InformationEntity informationEntity = bookingCarViewModel.getInformationUser(idPeople);
        userNameCar.setText(informationEntity.firstNaeInformationUser + " " + informationEntity.lastNaeInformationUser);
        costCar.setText(String.valueOf(cost)+"VND");
        nhaxeNameCar.setText(nameNhaXe);

    }
    private void backToHome()
    {
        Intent intent = new Intent(DisplaySuccessPaymentCarActivity.this, MainPageActivity.class);
        startActivity(intent);
    }
}
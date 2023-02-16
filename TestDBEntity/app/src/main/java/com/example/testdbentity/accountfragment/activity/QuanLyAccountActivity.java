package com.example.testdbentity.accountfragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.MainPageActivity;
import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookingcar.database.BookingCarDatabase;
import com.example.testdbentity.homefragment.bookingcar.viewmodel.BookingCarViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class QuanLyAccountActivity extends AppCompatActivity {

    private BookingCarViewModel bookingCarViewModel;
    private int idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_account);
        idUser = getIntent().getIntExtra("idUserInformation1", 0);
        bookingCarViewModel = new ViewModelProvider(this).get(BookingCarViewModel.class);
        InformationEntity informationEntity = bookingCarViewModel.getInformationUser(idUser);


        TextInputEditText hoAccount = findViewById(R.id.ho_account);
        TextInputEditText tenAccount = findViewById(R.id.ten_account);
        TextInputEditText emailAccount = findViewById(R.id.email_account);
        TextInputEditText sdtAccount = findViewById(R.id.sdt_account);
        TextInputEditText dobAccount = findViewById(R.id.dob_account);
        TextInputEditText cityAccount = findViewById(R.id.city_account);
        TextInputEditText addressAccount = findViewById(R.id.address_account);

        hoAccount.setText(informationEntity.firstNaeInformationUser);
        tenAccount.setText(informationEntity.lastNaeInformationUser);
        emailAccount.setText(informationEntity.emailInformationUser);
        sdtAccount.setText(informationEntity.numberInformationUser);
        cityAccount.setText(informationEntity.addressInformationUser);
        addressAccount.setText(informationEntity.addressInformationUser);

        Button button = findViewById(R.id.save_change_noti_infor);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenA = hoAccount.getText().toString();
                String hoA = tenAccount.getText().toString();
                String emailA = emailAccount.getText().toString();
                String sdtA = sdtAccount.getText().toString();
                String dobA = dobAccount.getText().toString();
                String addressA = addressAccount.getText().toString() + ", " + cityAccount.getText().toString();
                informationEntity.firstNaeInformationUser = hoA;
                informationEntity.lastNaeInformationUser = tenA;
                informationEntity.emailInformationUser = emailA;
                informationEntity.numberInformationUser = sdtA;
                informationEntity.addressInformationUser = addressA;
                bookingCarViewModel.updateInformationUser(informationEntity);

                Intent intent = new Intent(QuanLyAccountActivity.this, MainPageActivity.class);
                startActivity(intent);
            }
        });
    }
    private void getIntentData()
    {
    }
}

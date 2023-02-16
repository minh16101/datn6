package com.example.testdbentity.homefragment.bookingcar;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.testdbentity.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DisplayCarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText dateEdt;
    private int dayA;
    private int monthA;
    private int yearA;
    private String fromPlace;
    private String toPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_car);
        dateEdt = findViewById(R.id.idEdtDate);

        int idInformationUser = getIntent().getIntExtra("idInformationUser",0);

        String startPlace = "";
        startPlace = getIntent().getStringExtra("startPlace");
        String endPlace = "";
        endPlace = getIntent().getStringExtra("endPlace");
        // on below line we are adding click listener
        // for our pick date button
        dateEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCalendar();
            }
        });

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

        List<String> from = new ArrayList<String>();
        from.add("Ha Noi");
        from.add("Nghe An");
        from.add("Thanh Hoa");
        from.add("Ha Long");
        from.add("Bac Ninh");
        from.add("Da Nang");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, from);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);

        int vtS = 0;
        int vtE = 0;
        int i = 0;
        if(startPlace != "" && endPlace != "")
        {
            for (String x : from) {
                if (x.equals(startPlace)) {
                    vtS = i;
                }
                if (x.equals(endPlace)) {
                    vtE = i;
                }
                i++;
            }
            spinner1.setSelection(vtS);
            spinner2.setSelection(vtE);
        }

        Button button = findViewById(R.id.search_car_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayCarActivity.this, DisplayDetailCarActivity.class);
                intent.putExtra("dayCar", dayA);
                intent.putExtra("monthCar", monthA);
                intent.putExtra("yearCar", yearA);
                intent.putExtra("fromPlaceCar", fromPlace);
                intent.putExtra("toPlaceCar", toPlace);
                intent.putExtra("idUserInformation", idInformationUser);
                startActivity(intent);
            }
        });
        //back button
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                //back to main
            }
        };
        getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);
    }

    private void onClickCalendar() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                DisplayCarActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        dateEdt.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        dayA = dayOfMonth;
                        monthA = monthOfYear + 1;
                        yearA = year;
                    }
                },
                year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spin = (Spinner)adapterView;
        Spinner spin2 = (Spinner)adapterView;
        if(spin.getId() == R.id.spinner1)
        {
            fromPlace = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(this, "Your choose :" + fromPlace, Toast.LENGTH_SHORT).show();
        }
        if(spin2.getId() == R.id.spinner2)
        {
            toPlace = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(this, "Your choose :" + toPlace, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

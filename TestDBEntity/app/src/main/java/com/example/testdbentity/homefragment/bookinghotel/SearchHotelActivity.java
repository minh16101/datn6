package com.example.testdbentity.homefragment.bookinghotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.example.testdbentity.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SearchHotelActivity extends AppCompatActivity {

    private static final String[] cityNames = new String[]{
            "Hoàn Kiếm", "Hai Bà Trưng", "Đống Đa", "Ba Đình",
            "Tây Hồ", "Cầu Giấy", "Bắc Từ Liêm", "Nam Từ Liêm"
    };
    String place = "";
    private int dayFrom, monthFrom, yearFrom;
    private int dayTo, monthTo, yearTo;
    private String monthMain;
    private Long date1, date2 = null;
    private EditText edtFromDay, edtToDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hotel);
        int idInformationUser = getIntent().getIntExtra("idInformationUser", 1);
        showCalendar();
        AutoCompleteTextView searchCity = findViewById(R.id.location_hotel_search);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cityNames);
        searchCity.setAdapter(adapter);
        searchCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                place = adapterView.getItemAtPosition(i).toString();
            }
        });
        Button btnSearch = findViewById(R.id.search_hotel);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(date1);
                dayFrom = cal.get(Calendar.DAY_OF_MONTH);
                monthFrom = cal.get(Calendar.MONTH) + 1;
                yearFrom = cal.get(Calendar.YEAR);

                cal.setTimeInMillis(date2);
                dayTo = cal.get(Calendar.DAY_OF_MONTH);
                monthTo = cal.get(Calendar.MONTH) + 1;
                yearTo = cal.get(Calendar.YEAR);

                int[] listTimeFrom = new int[3];
                int[] listTimeTo = new int[3];
                listTimeFrom[0] = dayFrom;
                listTimeFrom[1] = monthFrom;
                listTimeFrom[2] = yearFrom;

                listTimeTo[0] = dayTo;
                listTimeTo[1] = monthTo;
                listTimeTo[2] = yearTo;
                Intent intent = new Intent(SearchHotelActivity.this, DisplayHotelActivity.class);
                intent.putExtra("cityHotel", place);
                intent.putExtra("idInformationUser", idInformationUser);
                intent.putExtra("timeFrom", listTimeFrom);
                intent.putExtra("toFrom", listTimeTo);
                startActivity(intent);
            }
        });
    }
    private void showCalendar()
    {
        edtFromDay = findViewById(R.id.from_book_day);
        edtToDay = findViewById(R.id.to_book_day);

        edtFromDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetFrom();
            }
        });

        edtToDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetTo();
            }
        });

    }

    private void showBottomSheetFrom() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_layout);

        CalendarView calendarView = bottomSheetDialog.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month++;
//                dayFrom = dayOfMonth;
//                monthFrom = month;
//                yearFrom = year;
                monthMain = getMonth(month);
                String sDateTemp = dayOfMonth + "-" + monthMain + "-" + year;
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                try {
                    Date d = formatter.parse(sDateTemp);
                    date1 = d.getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                getDate();
            }
        });
        bottomSheetDialog.show();
    }

    private void getDate() {
        Date dateD1 = new Date();
        Date dateD2 = new Date();
        if(date1 == null && date2 != null)
        {
            dateD2 = new Date(date2);
            DateFormat dateF = new SimpleDateFormat("dd-MMM-yyyy");
            String strDate2 = dateF.format(dateD2);
            edtToDay.setText(strDate2);
        }
        else if(date1 != null && date2 == null)
        {
            dateD1 = new Date(date1);
            DateFormat dateF = new SimpleDateFormat("dd-MMM-yyyy");
            String strDate1 = dateF.format(dateD1);
            edtFromDay.setText(strDate1);
        }
        else
        {
            if(date1 > date2)
            {
                long temp = date1;
                date1 = date2;
                date2 = temp;
            }

            dateD1 = new Date(date1);
            dateD2 = new Date(date2);

            DateFormat dateF = new SimpleDateFormat("dd-MMM-yyyy");
            String strDate1 = dateF.format(dateD1);
            String strDate2 = dateF.format(dateD2);
            edtFromDay.setText(strDate1);
            edtToDay.setText(strDate2);
        }
    }

    private String getMonth(int month) {
        switch (month)
        {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return "January";
    }

    private void showBottomSheetTo() {
        final BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(this);
        bottomSheetDialog1.setContentView(R.layout.bottom_sheet_dialog_layout);

        CalendarView calendarView = bottomSheetDialog1.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                month++;
//                dayTo = dayOfMonth;
//                monthTo = month;
//                yearTo = year;
                monthMain = getMonth(month);
                String sDateTemp = dayOfMonth + "-" + monthMain + "-" + year;
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                try {
                    Date d = formatter.parse(sDateTemp);
                    date2 = d.getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                getDate();
            }

        });
        bottomSheetDialog1.show();
    }

}
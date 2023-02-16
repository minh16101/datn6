package com.example.testdbentity.homefragment.bookingcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookingcar.adapter.CarAdapter;
import com.example.testdbentity.homefragment.bookingcar.adapter.OnClickSeat;
import com.example.testdbentity.homefragment.bookingcar.carwithseat.CarWithSeat;
import com.example.testdbentity.homefragment.bookingcar.userwithseat.UserAndSeatREF;
import com.example.testdbentity.homefragment.bookingcar.viewmodel.BookingCarViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class DisplayDetailCarActivity extends AppCompatActivity {

    private int day;
    private int month;
    private int year;
    private String startPlace;
    private String endPlace;
    CarAdapter carAdapter;
    List<UserAndSeatREF> userAndSeatREFS = new ArrayList<>();

    List<CarWithSeat> bookingCarEntityList;
    private BookingCarViewModel bookingCarViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_detail_car);

        setUpFilter();
        bookingCarViewModel = new ViewModelProvider(this).get(BookingCarViewModel.class);

        int idInformationUser = getIntent().getIntExtra("idUserInformation", 0);
        day = getIntent().getIntExtra("dayCar", 0);
        month = getIntent().getIntExtra("monthCar", 0);
        year = getIntent().getIntExtra("yearCar", 0);
        startPlace = getIntent().getStringExtra("fromPlaceCar");
        endPlace = getIntent().getStringExtra("toPlaceCar");
        RecyclerView recyclerView = findViewById(R.id.recycler_car);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        bookingCarViewModel.getCarWithRequire(day, month, year, startPlace, endPlace).observe(this, new Observer<List<CarWithSeat>>() {
            @Override
            public void onChanged(List<CarWithSeat> carWithSeats) {
                carAdapter.setData(carWithSeats);
                carAdapter.notifyDataSetChanged();
            }
        });
        List<BookingSeatEntity> bookingSeatEntityList = bookingCarViewModel.getListBookingSeatEntities();
        for (BookingSeatEntity a : bookingSeatEntityList) {
            a.isChoosingSeat = 0;
            bookingCarViewModel.updateIsChoosingSeat(a);
        }
        bookingCarEntityList = bookingCarViewModel.getCarWithRequireNoLiveData(day, month, year, startPlace, endPlace);
        carAdapter = new CarAdapter(bookingCarEntityList);
        carAdapter.setOnclickSeat(new OnClickSeat() {
            @Override
            public void setOnClickBookSeat(int idCar, int positionSeat, boolean check) {
                CarWithSeat carWithSeat = bookingCarViewModel.getAllSeatOfIdCar(idCar);
                BookingSeatEntity bookingSeatEntity = carWithSeat.bookingSeatEntityList.get(positionSeat);
                int idSeat = bookingSeatEntity.idBookingSeat;
                UserAndSeatREF userAndSeatREF = new UserAndSeatREF(idSeat, idInformationUser);
                BookingSeatEntity bookingSeatEntity1 = bookingCarViewModel.getOneBookingSeat(idSeat);
                //update ischoosing
                if(check == true) {
                    //update da duoc chon. Doi sang mau vang va insert va usertAndSeat
                    bookingSeatEntity1.isChoosingSeat = 1;
                    userAndSeatREFS.add(userAndSeatREF);
                }
                else {
                    //nguoc lai
                    UserAndSeatREF userAndSeatREFTemp = new UserAndSeatREF(userAndSeatREF.idSeat, userAndSeatREF.idPeople);
                    for (UserAndSeatREF temp : userAndSeatREFS){
                        if(temp.idSeat == userAndSeatREF.idSeat && temp.idPeople == userAndSeatREF.idPeople)
                        {
                            userAndSeatREFS.remove(temp);
                            break;
                        }
                    }
                    //doi ischooing sau neu ko se ko delete duoc
                    bookingSeatEntity1.isChoosingSeat = 0;
                }
                bookingCarViewModel.updateIsChoosingSeat(bookingSeatEntity1);
            }

            @Override
            public void setOnClickBookButton() {
                int size = userAndSeatREFS.size();
                int[] listIdSear = new int[size];
                for (int i = 0; i < size; i++)
                {
                    listIdSear[i] = userAndSeatREFS.get(i).idSeat;
                }
                Intent intent = new Intent(DisplayDetailCarActivity.this, DisplayPayCarActivity.class);
                intent.putExtra("listIdSeat", listIdSear);
                intent.putExtra("idPeople", idInformationUser);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(carAdapter);
    }
    private void setUpToolBar()
    {
        Toolbar toolbar = findViewById(R.id.toolbar_car);
    }
    private void setUpFilter()
    {
        Button buttonFilter = findViewById(R.id.filter_booking_car);
        buttonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialog();
            }
        });
    }
    private void showBottomSheetDialog()
    {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottm_sheat_filter_bookingcar);
        bottomSheetDialog.show();
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_filter_1_hotel:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_filter_2_hotel:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radio_filter_3_hotel:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radio_filter_4_hotel:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radio_filter_5_hotel:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
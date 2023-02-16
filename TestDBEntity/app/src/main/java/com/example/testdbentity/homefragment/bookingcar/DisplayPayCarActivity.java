package com.example.testdbentity.homefragment.bookingcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookingcar.carwithseat.CarWithSeat;
import com.example.testdbentity.homefragment.bookingcar.userwithseat.UserAndSeatREF;
import com.example.testdbentity.homefragment.bookingcar.viewmodel.BookingCarViewModel;

import java.util.ArrayList;
import java.util.List;

public class DisplayPayCarActivity extends AppCompatActivity {

    private BookingCarViewModel bookingCarViewModel;
    List<UserAndSeatREF> userAndSeatREFS = new ArrayList<>();
    int cost;
    String nameCarTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_pay_car);
        bookingCarViewModel = new ViewModelProvider(this).get(BookingCarViewModel.class);
        userAndSeatREFS = new ArrayList<>();
        int[] listIdseat = getIntent().getIntArrayExtra("listIdSeat");
        int idPeople = getIntent().getIntExtra("idPeople", 0);

        for (int i = 0; i < listIdseat.length; i++) {
            userAndSeatREFS.add(new UserAndSeatREF(listIdseat[i], idPeople));
        }
        TextView nameCar = findViewById(R.id.name_of_car_in_bill_value);
        TextView fromCar = findViewById(R.id.from_of_car_in_bill_value);
        TextView toCar = findViewById(R.id.to_of_car_in_bill_value);
        TextView stimeCar = findViewById(R.id.stime_of_car_in_bill_value);
        TextView etimeCar = findViewById(R.id.etime_of_car_in_bill_value);
        TextView seatCar = findViewById(R.id.seat_of_car_in_bill_value);
        TextView userNameCar = findViewById(R.id.username_of_car_in_bill_value);
        TextView costCar = findViewById(R.id.cost_of_car_in_bill_cost);


        InformationEntity informationEntity = bookingCarViewModel.getInformationUser(idPeople);
        userNameCar.setText(informationEntity.firstNaeInformationUser + " " + informationEntity.lastNaeInformationUser);

        nameCarTemp = "";
        String fromCarTemp = "";
        String toCarTemp = "";
        String stimeCarTemp = "";
        String etimeCarTemp = "";
        int seatCarTemp = 0;
        cost = 0;

        CarWithSeat carWithSeat = bookingCarViewModel.getCarWithSeatWithIdSeat(listIdseat[0]);
        nameCarTemp = carWithSeat.bookingCarEntity.nameBookingCar;
        fromCarTemp = carWithSeat.bookingCarEntity.startPlaceBookingCar;
        toCarTemp = carWithSeat.bookingCarEntity.endPlaceBookingCar;
        stimeCarTemp = String.valueOf(carWithSeat.bookingCarEntity.dayBookingCar) +"/"+String.valueOf(carWithSeat.bookingCarEntity.monthBookingCar)+"/"+String.valueOf(carWithSeat.bookingCarEntity.yearBookingCar);
        etimeCarTemp = String.valueOf(carWithSeat.bookingCarEntity.dayBookingCar) +"/"+String.valueOf(carWithSeat.bookingCarEntity.monthBookingCar)+"/"+String.valueOf(carWithSeat.bookingCarEntity.yearBookingCar);
        seatCarTemp = 1;
        for (int i = 1; i < listIdseat.length; i++) {
            carWithSeat = bookingCarViewModel.getCarWithSeatWithIdSeat(listIdseat[i]);

            if (!nameCarTemp.equals(carWithSeat.bookingCarEntity.nameBookingCar)) {
                nameCarTemp += "\n" + carWithSeat.bookingCarEntity.nameBookingCar;
            }
            fromCarTemp += "\n" + carWithSeat.bookingCarEntity.startPlaceBookingCar;
            toCarTemp += "\n" + carWithSeat.bookingCarEntity.endPlaceBookingCar;
            stimeCarTemp += "\n" + String.valueOf(carWithSeat.bookingCarEntity.dayBookingCar) + "/" + String.valueOf(carWithSeat.bookingCarEntity.monthBookingCar) + "/" + String.valueOf(carWithSeat.bookingCarEntity.yearBookingCar);
            etimeCarTemp += "\n" + String.valueOf(carWithSeat.bookingCarEntity.dayBookingCar) + "/" + String.valueOf(carWithSeat.bookingCarEntity.monthBookingCar) + "/" + String.valueOf(carWithSeat.bookingCarEntity.yearBookingCar);
            seatCarTemp++;
            for (BookingSeatEntity bookingSeatEntity : carWithSeat.bookingSeatEntityList) {
                cost += bookingSeatEntity.priceBookingSeat;
            }
        }
        nameCar.setText(nameCarTemp);
        fromCar.setText(fromCarTemp);
        toCar.setText(toCarTemp);
        stimeCar.setText(stimeCarTemp);
        etimeCar.setText(etimeCarTemp);
        seatCar.setText(String.valueOf(seatCarTemp));
        costCar.setText(String.valueOf(cost));
        Button btnBookingCar = findViewById(R.id.btn_booking_car);
        btnBookingCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cap nhat lai is Book seat
                bookingCarViewModel.insertUserAndSeatREF(userAndSeatREFS);
                for (int i = 0; i < userAndSeatREFS.size(); i++) {
                    UserAndSeatREF userAndSeatREF = userAndSeatREFS.get(i);
                    BookingSeatEntity bookingSeatEntity = bookingCarViewModel.getOneBookingSeat(userAndSeatREF.idSeat);
                    bookingSeatEntity.isFullBookingSeat = 1;
                    bookingCarViewModel.updateIsChoosingSeat(bookingSeatEntity);
                }
                Intent intent = new Intent(DisplayPayCarActivity.this, DisplaySuccessPaymentCarActivity.class);
                intent.putExtra("idUserSuccess", idPeople);
                intent.putExtra("priceSuccess",cost);
                intent.putExtra("nameNhaXeSuccess", nameCarTemp);
                startActivity(intent);
            }
        });
    }
}
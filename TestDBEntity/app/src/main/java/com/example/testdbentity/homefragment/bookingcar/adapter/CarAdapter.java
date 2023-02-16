package com.example.testdbentity.homefragment.bookingcar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookingcar.carwithseat.CarWithSeat;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarHolder> {
    List<CarWithSeat> bookingCarEntities;
    OnClickSeat onClickSeat;

    public CarAdapter(List<CarWithSeat> bookingCarEntities) {
        this.bookingCarEntities = bookingCarEntities;
    }

    public void setOnclickSeat(OnClickSeat onclickSeat)
    {
        this.onClickSeat = onclickSeat;
    }
    public void setData(List<CarWithSeat> bookingCarEntities) {
        this.bookingCarEntities = bookingCarEntities;
    }

    @NonNull
    @Override
    public CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false);
        return new CarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarHolder holder, int position) {
        CarWithSeat bookingCarEntity = bookingCarEntities.get(position);
        holder.imgCar.setImageResource(bookingCarEntity.bookingCarEntity.srcBookingCar);
        holder.nameCar.setText(bookingCarEntity.bookingCarEntity.nameBookingCar);
        holder.fromCar.setText(bookingCarEntity.bookingCarEntity.startPlaceBookingCar);
        holder.toCar.setText(bookingCarEntity.bookingCarEntity.endPlaceBookingCar);
        holder.startTimeCar.setText(String.valueOf(bookingCarEntity.bookingCarEntity.dayBookingCar) +"/" + String.valueOf(bookingCarEntity.bookingCarEntity.monthBookingCar));

        holder.btnBookCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSeat.setOnClickBookButton();
            }
        });
        int s1 = bookingCarEntity.bookingSeatEntityList.get(0).isFullBookingSeat;
        int s2 = bookingCarEntity.bookingSeatEntityList.get(1).isFullBookingSeat;
        int s3 = bookingCarEntity.bookingSeatEntityList.get(2).isFullBookingSeat;
        int s4 = bookingCarEntity.bookingSeatEntityList.get(3).isFullBookingSeat;
        int s5 = bookingCarEntity.bookingSeatEntityList.get(4).isFullBookingSeat;
        int s6 = bookingCarEntity.bookingSeatEntityList.get(5).isFullBookingSeat;
        int s7 = bookingCarEntity.bookingSeatEntityList.get(6).isFullBookingSeat;
        int s8 = bookingCarEntity.bookingSeatEntityList.get(7).isFullBookingSeat;
        int s9 = bookingCarEntity.bookingSeatEntityList.get(8).isFullBookingSeat;
        int s10 = bookingCarEntity.bookingSeatEntityList.get(9).isFullBookingSeat;
        int s11 = bookingCarEntity.bookingSeatEntityList.get(10).isFullBookingSeat;
        int s12 = bookingCarEntity.bookingSeatEntityList.get(11).isFullBookingSeat;
        int s13 = bookingCarEntity.bookingSeatEntityList.get(12).isFullBookingSeat;
        int s14 = bookingCarEntity.bookingSeatEntityList.get(13).isFullBookingSeat;
        int s15 = bookingCarEntity.bookingSeatEntityList.get(14).isFullBookingSeat;
        int s16 = bookingCarEntity.bookingSeatEntityList.get(15).isFullBookingSeat;
        int s17 = bookingCarEntity.bookingSeatEntityList.get(16).isFullBookingSeat;
        int s18 = bookingCarEntity.bookingSeatEntityList.get(17).isFullBookingSeat;
        int s19 = bookingCarEntity.bookingSeatEntityList.get(18).isFullBookingSeat;
        int s20 = bookingCarEntity.bookingSeatEntityList.get(19).isFullBookingSeat;
        int s21 = bookingCarEntity.bookingSeatEntityList.get(20).isFullBookingSeat;
        int s22 = bookingCarEntity.bookingSeatEntityList.get(21).isFullBookingSeat;
        int s23 = bookingCarEntity.bookingSeatEntityList.get(22).isFullBookingSeat;
        int s24 = bookingCarEntity.bookingSeatEntityList.get(23).isFullBookingSeat;
        int s25 = bookingCarEntity.bookingSeatEntityList.get(24).isFullBookingSeat;
        int s26 = bookingCarEntity.bookingSeatEntityList.get(25).isFullBookingSeat;
        int s27 = bookingCarEntity.bookingSeatEntityList.get(26).isFullBookingSeat;
        int s28 = bookingCarEntity.bookingSeatEntityList.get(27).isFullBookingSeat;
        int s29 = bookingCarEntity.bookingSeatEntityList.get(28).isFullBookingSeat;
        int s30 = bookingCarEntity.bookingSeatEntityList.get(29).isFullBookingSeat;
        int s31 = bookingCarEntity.bookingSeatEntityList.get(30).isFullBookingSeat;
        int s32 = bookingCarEntity.bookingSeatEntityList.get(31).isFullBookingSeat;
        int s33 = bookingCarEntity.bookingSeatEntityList.get(32).isFullBookingSeat;
        int s34 = bookingCarEntity.bookingSeatEntityList.get(33).isFullBookingSeat;
        int s35 = bookingCarEntity.bookingSeatEntityList.get(34).isFullBookingSeat;
        int s36 = bookingCarEntity.bookingSeatEntityList.get(35).isFullBookingSeat;
        int s37 = bookingCarEntity.bookingSeatEntityList.get(36).isFullBookingSeat;
        int s38 = bookingCarEntity.bookingSeatEntityList.get(37).isFullBookingSeat;

        //s1
        if(bookingCarEntity.bookingSeatEntityList.get(0).isChoosingSeat == 0 && s1 == 0) {
            holder.seatCar1.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(0).isChoosingSeat == 1 && s1 == 0)
        {
            holder.seatCar1.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s1 == 1){
            holder.seatCar1.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s2
        if(bookingCarEntity.bookingSeatEntityList.get(1).isChoosingSeat == 0 && s2 == 0) {
            holder.seatCar2.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(1).isChoosingSeat == 1 && s2 == 0)
        {
            holder.seatCar2.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s2 == 1) {
            holder.seatCar2.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s3
        if(bookingCarEntity.bookingSeatEntityList.get(2).isChoosingSeat == 0 && s3 == 0)
        {
            holder.seatCar3.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(2).isChoosingSeat == 1 && s3 == 0)
        {
            holder.seatCar3.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s3 == 1)
        {
            holder.seatCar3.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s4
        if(bookingCarEntity.bookingSeatEntityList.get(3).isChoosingSeat == 0 && s4 == 0)
        {
            holder.seatCar4.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(3).isChoosingSeat == 1 && s4 == 0)
        {
            holder.seatCar4.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s4 == 1) {
            holder.seatCar4.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s5
        if(bookingCarEntity.bookingSeatEntityList.get(4).isChoosingSeat == 0 && s5 == 0)
        {
            holder.seatCar5.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(4).isChoosingSeat == 1 && s5 == 0)
        {
            holder.seatCar5.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s5 == 1)
        {
            holder.seatCar5.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s6
        if(bookingCarEntity.bookingSeatEntityList.get(5).isChoosingSeat == 0 && s6 == 0)
        {
            holder.seatCar6.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(5).isChoosingSeat == 1 && s6 == 0)
        {
            holder.seatCar6.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s6 == 1)
        {
            holder.seatCar6.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s7
        if(bookingCarEntity.bookingSeatEntityList.get(6).isChoosingSeat == 0 && s7 == 0)
        {
            holder.seatCar7.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(6).isChoosingSeat == 1 && s7 == 0)
        {
            holder.seatCar7.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s7 == 1)
        {
            holder.seatCar7.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s8
        if(bookingCarEntity.bookingSeatEntityList.get(7).isChoosingSeat == 0 && s8 == 0) {
            holder.seatCar8.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(7).isChoosingSeat == 1 && s8 == 0)
        {
            holder.seatCar8.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s8 == 1)
        {
            holder.seatCar8.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s9
        if(bookingCarEntity.bookingSeatEntityList.get(8).isChoosingSeat == 0 && s9 == 0)
        {
            holder.seatCar9.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(8).isChoosingSeat == 1 && s9 == 0)
        {
            holder.seatCar9.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s9 == 1)
        {
            holder.seatCar9.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s10
        if(bookingCarEntity.bookingSeatEntityList.get(9).isChoosingSeat == 0 && s10 == 0)
        {
            holder.seatCar10.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(9).isChoosingSeat == 1 && s10 == 0)
        {
            holder.seatCar10.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s10 == 1)
        {
            holder.seatCar10.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s11
        if(bookingCarEntity.bookingSeatEntityList.get(10).isChoosingSeat == 0 && s11 == 0)
        {
            holder.seatCar11.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(10).isChoosingSeat == 1 && s11 == 0)
        {
            holder.seatCar11.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s11 == 1)
        {
            holder.seatCar11.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s12
        if(bookingCarEntity.bookingSeatEntityList.get(11).isChoosingSeat == 0 && s12 == 0)
        {
            holder.seatCar12.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(11).isChoosingSeat == 1 && s12 == 0)
        {
            holder.seatCar12.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s12 == 1)
        {
            holder.seatCar12.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s13
        if(bookingCarEntity.bookingSeatEntityList.get(12).isChoosingSeat == 0 && s13 == 0)
        {
            holder.seatCar13.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(12).isChoosingSeat == 1 && s13 == 0) {
            holder.seatCar13.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s13 == 1)
        {
            holder.seatCar13.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s14
        if(bookingCarEntity.bookingSeatEntityList.get(13).isChoosingSeat == 0 && s14 == 0)
        {
            holder.seatCar14.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(13).isChoosingSeat == 1 && s14 == 0)
        {
            holder.seatCar14.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s14 == 1) {
            holder.seatCar14.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s15
        if(bookingCarEntity.bookingSeatEntityList.get(14).isChoosingSeat == 0 && s15 == 0)
        {
            holder.seatCar15.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(14).isChoosingSeat == 1 && s15 == 0)
        {
            holder.seatCar15.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s15 == 1)
        {
            holder.seatCar15.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s16
        if(bookingCarEntity.bookingSeatEntityList.get(15).isChoosingSeat == 0 && s16 == 0)
        {
            holder.seatCar16.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(15).isChoosingSeat == 1 && s16 == 0)
        {
            holder.seatCar16.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s16 == 1) {
            holder.seatCar16.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s17
        if(bookingCarEntity.bookingSeatEntityList.get(16).isChoosingSeat == 0 && s17 == 0)
        {
            holder.seatCar17.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(16).isChoosingSeat == 1 && s17 == 0)
        {
            holder.seatCar17.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s17 == 1) {
            holder.seatCar17.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s18
        if(bookingCarEntity.bookingSeatEntityList.get(17).isChoosingSeat == 0 && s18 == 0)
        {
            holder.seatCar18.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(17).isChoosingSeat == 1 && s18 == 0)
        {
            holder.seatCar18.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s18 == 1)
        {
            holder.seatCar18.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s19
        if(bookingCarEntity.bookingSeatEntityList.get(18).isChoosingSeat == 0 && s19 == 0)
        {
            holder.seatCar19.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(18).isChoosingSeat == 1 && s19 == 0)
        {
            holder.seatCar19.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s19 == 1)
        {
            holder.seatCar19.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s20
        if(bookingCarEntity.bookingSeatEntityList.get(19).isChoosingSeat == 0 && s20 == 0)
        {
            holder.seatCar20.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(19).isChoosingSeat == 1 && s20 == 0)
        {
            holder.seatCar20.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s20 == 1)
        {
            holder.seatCar20.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s21
        if(bookingCarEntity.bookingSeatEntityList.get(20).isChoosingSeat == 0 && s21 == 0)
        {
            holder.seatCar21.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(20).isChoosingSeat == 1 && s21 == 0)
        {
            holder.seatCar21.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s21 == 1)
        {
            holder.seatCar21.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s22
        if(bookingCarEntity.bookingSeatEntityList.get(21).isChoosingSeat == 0 && s22 == 0) {
            holder.seatCar22.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(21).isChoosingSeat == 1 && s22 == 0)
        {
            holder.seatCar22.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s22 == 1)
        {
            holder.seatCar22.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s23
        if(bookingCarEntity.bookingSeatEntityList.get(22).isChoosingSeat == 0 && s23 == 0)
        {
            holder.seatCar23.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(22).isChoosingSeat == 1 && s23 == 0)
        {
            holder.seatCar23.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s23 == 1)
        {
            holder.seatCar23.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s24
        if(bookingCarEntity.bookingSeatEntityList.get(23).isChoosingSeat == 0 && s24 == 0)
        {
            holder.seatCar24.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(23).isChoosingSeat == 1 && s24 == 0)
        {
            holder.seatCar24.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s24 == 1)
        {
            holder.seatCar24.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s25
        if(bookingCarEntity.bookingSeatEntityList.get(24).isChoosingSeat == 0 && s25 == 0)
        {
            holder.seatCar25.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(24).isChoosingSeat == 1 && s25 == 0)
        {
            holder.seatCar25.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s25 == 1)
        {
            holder.seatCar25.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s26
        if(bookingCarEntity.bookingSeatEntityList.get(25).isChoosingSeat == 0 && s26 == 0)
        {
            holder.seatCar26.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(25).isChoosingSeat == 1 && s26 == 0)
        {
            holder.seatCar26.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s26 == 1)
        {
            holder.seatCar26.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s27
        if(bookingCarEntity.bookingSeatEntityList.get(26).isChoosingSeat == 0 && s27 == 0)
        {
            holder.seatCar27.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(26).isChoosingSeat == 1 && s27 == 0)
        {
            holder.seatCar27.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s27 == 1)
        {
            holder.seatCar27.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s28
        if(bookingCarEntity.bookingSeatEntityList.get(27).isChoosingSeat == 0 && s28 == 0)
        {
            holder.seatCar28.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(27).isChoosingSeat == 1 && s28 == 0)
        {
            holder.seatCar28.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s28 == 1)
        {
            holder.seatCar28.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s29
        if(bookingCarEntity.bookingSeatEntityList.get(28).isChoosingSeat == 0 && s29 == 0)
        {
            holder.seatCar29.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(28).isChoosingSeat == 1 && s29 == 0)
        {
            holder.seatCar29.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s29 == 1)
        {
            holder.seatCar29.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s30
        if(bookingCarEntity.bookingSeatEntityList.get(29).isChoosingSeat == 0 && s30 == 0)
        {
            holder.seatCar30.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(29).isChoosingSeat == 1 && s30 == 0) {
            holder.seatCar30.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s30 == 1)
        {
            holder.seatCar30.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s31
        if(bookingCarEntity.bookingSeatEntityList.get(30).isChoosingSeat == 0 && s31 == 0)
        {
            holder.seatCar31.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(30).isChoosingSeat == 1 && s31 == 0) {
            holder.seatCar31.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s31 == 1)
        {
            holder.seatCar31.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s32
        if(bookingCarEntity.bookingSeatEntityList.get(31).isChoosingSeat == 0 && s32 == 0)
        {
            holder.seatCar32.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(31).isChoosingSeat == 1 && s32 == 0)
        {
            holder.seatCar32.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s32 == 1)
        {
            holder.seatCar32.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s33
        if(bookingCarEntity.bookingSeatEntityList.get(32).isChoosingSeat == 0 && s33 == 0)
        {
            holder.seatCar33.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(32).isChoosingSeat == 1 && s33 == 0)
        {
            holder.seatCar33.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s33 == 1)
        {
            holder.seatCar33.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s34
        if(bookingCarEntity.bookingSeatEntityList.get(33).isChoosingSeat == 0 && s34 == 0)
        {
            holder.seatCar34.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(33).isChoosingSeat == 1 && s34 == 0)
        {
            holder.seatCar34.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s34 == 1)
        {
            holder.seatCar34.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s35
        if(bookingCarEntity.bookingSeatEntityList.get(34).isChoosingSeat == 0 && s35 == 0)
        {
            holder.seatCar35.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(34).isChoosingSeat == 1 && s35 == 0)
        {
            holder.seatCar35.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s35 == 1)
        {
            holder.seatCar35.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s36
        if(bookingCarEntity.bookingSeatEntityList.get(35).isChoosingSeat == 0 && s36 == 0)
        {
            holder.seatCar36.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(35).isChoosingSeat == 1 && s36 == 0)
        {
            holder.seatCar36.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s36 == 1)
        {
            holder.seatCar36.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s37
        if(bookingCarEntity.bookingSeatEntityList.get(36).isChoosingSeat == 0 && s37 == 0)
        {
            holder.seatCar37.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(36).isChoosingSeat == 0 && s37 == 0)
        {
            holder.seatCar37.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s37 == 1) {

            holder.seatCar37.setImageResource(R.drawable.confortable_chair_booked);
        }
        //s38
        if(bookingCarEntity.bookingSeatEntityList.get(37).isChoosingSeat == 0 && s38 == 0)
        {
            holder.seatCar38.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
        }
        else if(bookingCarEntity.bookingSeatEntityList.get(37).isChoosingSeat == 1 && s38 == 0)
        {
            holder.seatCar38.setImageResource(R.drawable.comfortable_chair_yellow);
        }
        else if(s38 == 1)
        {
            holder.seatCar38.setImageResource(R.drawable.confortable_chair_booked);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.cardViewDisplay.getVisibility() == View.GONE)
                {
                    holder.cardViewDisplay.setVisibility(View.VISIBLE);
                    holder.btnBookCar.setVisibility(View.VISIBLE);
                }
                else if(holder.cardViewDisplay.getVisibility() == View.VISIBLE)
                {
                    holder.cardViewDisplay.setVisibility(View.GONE);
                    holder.btnBookCar.setVisibility(View.GONE);
                }
            }
        });
        holder.seatCar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(0).isChoosingSeat == 0 && s1 == 0) {
                    holder.seatCar1.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 0, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(0).isChoosingSeat == 1 && s1 == 0)
                {
                    holder.seatCar1.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 0, false);
                }
                else if(s1 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(1).isChoosingSeat == 0 && s2 == 0) {
                    holder.seatCar2.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar,1,true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(1).isChoosingSeat == 1 && s2 == 0)
                {
                    holder.seatCar2.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 1,false);
                }
                else if(s2 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(2).isChoosingSeat == 0 && s3 == 0) {
                    holder.seatCar3.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 2,true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(2).isChoosingSeat == 1 && s3 == 0)
                {
                    holder.seatCar3.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 2,false);

                }
                else if(s3 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(3).isChoosingSeat == 0 && s4 == 0) {
                    holder.seatCar4.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 3, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(3).isChoosingSeat == 1 && s4 == 0)
                {
                    holder.seatCar4.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 3, false);

                }
                else if(s4 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(4).isChoosingSeat == 0 && s5 == 0) {
                    holder.seatCar5.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 4, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(4).isChoosingSeat == 1 && s5 == 0)
                {
                    holder.seatCar5.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 4, false);
                }
                else if(s5 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(5).isChoosingSeat == 0 && s6 == 0) {
                    holder.seatCar6.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 5, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(5).isChoosingSeat == 1 && s6 == 0)
                {
                    holder.seatCar6.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 5, false);
                }
                else if(s6 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(6).isChoosingSeat == 0 && s7 == 0) {
                    holder.seatCar7.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 6,true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(6).isChoosingSeat == 1 && s7 == 0)
                {
                    holder.seatCar7.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 6,false);
                }
                else if(s7 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(7).isChoosingSeat == 0 && s8 == 0) {
                    holder.seatCar8.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 7, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(7).isChoosingSeat == 1 && s8 == 0)
                {
                    holder.seatCar8.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 7, false);
                }
                else if(s8 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(8).isChoosingSeat == 0 && s9 == 0) {
                    holder.seatCar9.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 8,true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(8).isChoosingSeat == 1 && s9 == 0)
                {
                    holder.seatCar9.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 8,false);
                }
                else if(s9 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(9).isChoosingSeat == 0 && s10 == 0) {
                    holder.seatCar10.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 9,true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(9).isChoosingSeat == 1 && s10 == 0)
                {
                    holder.seatCar10.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 9,false);
                }
                else if(s10 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(10).isChoosingSeat == 0 && s11 == 0) {
                    holder.seatCar11.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 10, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(10).isChoosingSeat == 1 && s11 == 0)
                {
                    holder.seatCar11.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 10, false);
                }
                else if(s11 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(11).isChoosingSeat == 0 && s12 == 0) {
                    holder.seatCar12.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 11,true);

                }
                else if(bookingCarEntity.bookingSeatEntityList.get(11).isChoosingSeat == 1 && s12 == 0)
                {
                    holder.seatCar12.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 11,false);
                }
                else if(s12 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(12).isChoosingSeat == 0 && s13 == 0) {
                    holder.seatCar13.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 12,true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(12).isChoosingSeat == 1 && s13 == 0)
                {
                    holder.seatCar13.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 12,false);
                }
                else if(s13 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(13).isChoosingSeat == 0 && s14 == 0) {
                    holder.seatCar14.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 13,true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(13).isChoosingSeat == 1 && s14 == 0)
                {
                    holder.seatCar14.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 13,false);

                }
                else if(s14 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(14).isChoosingSeat == 0 && s15 == 0) {
                    holder.seatCar15.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 14,true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(14).isChoosingSeat == 1 && s15 == 0)
                {
                    holder.seatCar15.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 14, false);
                }
                else if(s15 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(15).isChoosingSeat == 0 && s16 == 0) {
                    holder.seatCar16.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 15, true);

                }
                else if(bookingCarEntity.bookingSeatEntityList.get(15).isChoosingSeat == 1 && s16 == 0)
                {
                    holder.seatCar16.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 15, false);
                }
                else if(s16 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //chua sua
        holder.seatCar17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(16).isChoosingSeat == 0 && s17 == 0) {
                    holder.seatCar17.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 16,true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(16).isChoosingSeat == 1 && s17 == 0)
                {
                    holder.seatCar17.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 16,false);

                }
                else if(s17 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(17).isChoosingSeat == 0 && s18 == 0) {
                    holder.seatCar18.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 17, true);

                }
                else if(bookingCarEntity.bookingSeatEntityList.get(17).isChoosingSeat == 1 && s18 == 0)
                {
                    holder.seatCar18.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 17, false);

                }
                else if(s18 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(18).isChoosingSeat == 0 && s19 == 0) {
                    holder.seatCar19.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 18, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(18).isChoosingSeat == 1 && s19 == 0)
                {
                    holder.seatCar19.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 18, false);
                }
                else if(s19 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(19).isChoosingSeat == 0 && s20 == 0) {
                    holder.seatCar20.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 19, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(19).isChoosingSeat == 1 && s20 == 0)
                {
                    holder.seatCar20.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 19, false);
                }
                else if(s20 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(20).isChoosingSeat == 0 && s21 == 0) {
                    holder.seatCar21.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 20, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(20).isChoosingSeat == 1 && s21 == 0)
                {
                    holder.seatCar21.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 20, false);
                }
                else if(s21 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(21).isChoosingSeat == 0 && s22 == 0) {
                    holder.seatCar22.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 21, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(21).isChoosingSeat == 1 && s22 == 0)
                {
                    holder.seatCar22.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 21, false);
                }
                else if(s22 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(22).isChoosingSeat == 0 && s23 == 0) {
                    holder.seatCar23.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 22, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(22).isChoosingSeat == 1 && s23 == 0)
                {
                    holder.seatCar23.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 22, false);
                }
                else if(s23 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(23).isChoosingSeat == 0 && s24 == 0) {
                    holder.seatCar24.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 23, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(23).isChoosingSeat == 1 && s24 == 0)
                {
                    holder.seatCar24.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 23, false);
                }
                else if(s24 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(24).isChoosingSeat == 0 && s25 == 0) {
                    holder.seatCar25.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 24, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(24).isChoosingSeat == 1 && s25 == 0)
                {
                    holder.seatCar25.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 24, false);
                }
                else if(s25 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(25).isChoosingSeat == 0 && s26 == 0) {
                    holder.seatCar26.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 25, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(25).isChoosingSeat == 1 && s26 == 0)
                {
                    holder.seatCar26.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 25, false);
                }
                else if(s26 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(26).isChoosingSeat == 0 && s27 == 0) {
                    holder.seatCar27.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 26, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(26).isChoosingSeat == 1 && s27 == 0)
                {
                    holder.seatCar27.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 26, false);
                }
                else if(s27 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(27).isChoosingSeat == 0 && s28 == 0) {
                    holder.seatCar28.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 27, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(27).isChoosingSeat == 1 && s28 == 0)
                {
                    holder.seatCar28.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 27, false);
                }
                else if(s28 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(28).isChoosingSeat == 0 && s29 == 0) {
                    holder.seatCar29.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 28, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(28).isChoosingSeat == 1 && s29 == 0)
                {
                    holder.seatCar29.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 28, false);
                }
                else if(s29 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(29).isChoosingSeat == 0 && s30 == 0) {
                    holder.seatCar30.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 29, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(29).isChoosingSeat == 1 && s30 == 0)
                {
                    holder.seatCar30.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 29, false);
                }
                else if(s30 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(30).isChoosingSeat == 0 && s31 == 0) {
                    holder.seatCar31.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 30, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(30).isChoosingSeat == 1 && s31 == 0)
                {
                    holder.seatCar31.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 30, false);
                }
                else if(s31 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(31).isChoosingSeat == 0 && s32 == 0) {
                    holder.seatCar32.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 31, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(31).isChoosingSeat == 1 && s32 == 0)
                {
                    holder.seatCar32.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 31, false);
                }
                else if(s32 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(32).isChoosingSeat == 0 && s33 == 0) {
                    holder.seatCar33.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 32, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(32).isChoosingSeat == 1 && s33 == 0)
                {
                    holder.seatCar33.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 32, false);
                }
                else if(s33 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(33).isChoosingSeat == 0 && s34 == 0) {
                    holder.seatCar34.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 33, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(33).isChoosingSeat == 1 && s34 == 0)
                {
                    holder.seatCar34.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 33, false);
                }
                else if(s34 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(34).isChoosingSeat == 0 && s35 == 0) {
                    holder.seatCar35.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 34, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(34).isChoosingSeat == 1 && s35 == 0)
                {
                    holder.seatCar35.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 34, false);
                }
                else if(s35 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(35).isChoosingSeat == 0 && s36 == 0) {
                    holder.seatCar36.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 35, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(35).isChoosingSeat == 1 && s36 == 0)
                {
                    holder.seatCar36.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 35, false);
                }
                else if(s36 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(36).isChoosingSeat == 0 && s37 == 0) {
                    holder.seatCar37.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 36, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(36).isChoosingSeat == 1 && s37 == 0)
                {
                    holder.seatCar37.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 36, false);
                }
                else if(s37 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.seatCar38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookingCarEntity.bookingSeatEntityList.get(37).isChoosingSeat == 0 && s38 == 0) {
                    holder.seatCar38.setImageResource(R.drawable.comfortable_chair_yellow);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 37, true);
                }
                else if(bookingCarEntity.bookingSeatEntityList.get(37).isChoosingSeat == 1 && s38 == 0)
                {
                    holder.seatCar38.setImageResource(R.drawable.comfortable_chair_svgrepo_com);
                    onClickSeat.setOnClickBookSeat(bookingCarEntity.bookingCarEntity.idBookingCar, 37, false);
                }
                else if(s38 == 1){
                    Toast.makeText(view.getContext(), "Booked!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return bookingCarEntities.size();
    }

    public class CarHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private TextView nameCar;
        private TextView fromCar;
        private TextView toCar;
        private TextView startTimeCar;
        private Button btnBookCar;
        private CardView cardViewDisplay;
        private ImageView seatCar1;
        private ImageView seatCar2;
        private ImageView seatCar3;
        private ImageView seatCar4;
        private ImageView seatCar5;
        private ImageView seatCar6;
        private ImageView seatCar7;
        private ImageView seatCar8;
        private ImageView seatCar9;
        private ImageView seatCar10;
        private ImageView seatCar11;
        private ImageView seatCar12;
        private ImageView seatCar13;
        private ImageView seatCar14;
        private ImageView seatCar15;
        private ImageView seatCar16;
        private ImageView seatCar17;
        private ImageView seatCar18;
        private ImageView seatCar19;
        private ImageView seatCar20;
        private ImageView seatCar21;
        private ImageView seatCar22;
        private ImageView seatCar23;
        private ImageView seatCar24;
        private ImageView seatCar25;
        private ImageView seatCar26;
        private ImageView seatCar27;
        private ImageView seatCar28;
        private ImageView seatCar29;
        private ImageView seatCar30;
        private ImageView seatCar31;
        private ImageView seatCar32;
        private ImageView seatCar33;
        private ImageView seatCar34;
        private ImageView seatCar35;
        private ImageView seatCar36;
        private ImageView seatCar37;
        private ImageView seatCar38;

        private ImageView imgCar;

        public CarHolder(@NonNull View itemView) {
            super(itemView);
            imgCar = itemView.findViewById(R.id.image_car);
            cardView = itemView.findViewById(R.id.cardview_car);
            nameCar = itemView.findViewById(R.id.name_car);
            fromCar = itemView.findViewById(R.id.from_car);
            toCar = itemView.findViewById(R.id.to_car);
            startTimeCar = itemView.findViewById(R.id.starttime_car);
            btnBookCar = itemView.findViewById(R.id.booking_car_btn);
            cardViewDisplay = itemView.findViewById(R.id.cardview_show_detail_car);
            seatCar1 = itemView.findViewById(R.id.seat_1);
            seatCar2 = itemView.findViewById(R.id.seat_2);
            seatCar3 = itemView.findViewById(R.id.seat_3);
            seatCar4 = itemView.findViewById(R.id.seat_4);
            seatCar5 = itemView.findViewById(R.id.seat_5);
            seatCar6 = itemView.findViewById(R.id.seat_6);
            seatCar7 = itemView.findViewById(R.id.seat_7);
            seatCar8 = itemView.findViewById(R.id.seat_8);
            seatCar9 = itemView.findViewById(R.id.seat_9);
            seatCar10 = itemView.findViewById(R.id.seat_10);
            seatCar11 = itemView.findViewById(R.id.seat_11);
            seatCar12 = itemView.findViewById(R.id.seat_12);
            seatCar13 = itemView.findViewById(R.id.seat_13);
            seatCar14 = itemView.findViewById(R.id.seat_14);
            seatCar15 = itemView.findViewById(R.id.seat_15);
            seatCar16 = itemView.findViewById(R.id.seat_16);
            seatCar17 = itemView.findViewById(R.id.seat_17);
            seatCar18 = itemView.findViewById(R.id.seat_18);
            seatCar19 = itemView.findViewById(R.id.seat_19);
            seatCar20 = itemView.findViewById(R.id.seat_20);
            seatCar21 = itemView.findViewById(R.id.seat_21);
            seatCar22 = itemView.findViewById(R.id.seat_22);
            seatCar23 = itemView.findViewById(R.id.seat_23);
            seatCar24 = itemView.findViewById(R.id.seat_24);
            seatCar25 = itemView.findViewById(R.id.seat_25);
            seatCar26 = itemView.findViewById(R.id.seat_26);
            seatCar27 = itemView.findViewById(R.id.seat_27);
            seatCar28 = itemView.findViewById(R.id.seat_28);
            seatCar29 = itemView.findViewById(R.id.seat_29);
            seatCar30 = itemView.findViewById(R.id.seat_30);
            seatCar31 = itemView.findViewById(R.id.seat_31);
            seatCar32 = itemView.findViewById(R.id.seat_32);
            seatCar33 = itemView.findViewById(R.id.seat_33);
            seatCar34 = itemView.findViewById(R.id.seat_34);
            seatCar35 = itemView.findViewById(R.id.seat_35);
            seatCar36 = itemView.findViewById(R.id.seat_36);
            seatCar37 = itemView.findViewById(R.id.seat_37);
            seatCar38 = itemView.findViewById(R.id.seat_38);
        }
    }
}

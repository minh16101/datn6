package com.example.testdbentity.homefragment;

import android.os.Bundle;

import com.example.testdbentity.R;
import com.google.android.material.appbar.AppBarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ScrollingMainActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    private CardView cardViewHoldButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_main);
    }
//        appBarLayout = findViewById(R.id.app_bar);
//        cardViewHoldButton = findViewById(R.id.card_view_hold_button_scroll);
//        displayHoldButton();
//
//        List<CarScrollModel> carScrollModelList = new ArrayList<>();
//        carScrollModelList.add(new CarScrollModel(R.drawable.hanoi, "Ha Noi", "Nghe An"));
//        carScrollModelList.add(new CarScrollModel(R.drawable.nghean, "Ha Noi", "Nghe An"));
//        carScrollModelList.add(new CarScrollModel(R.drawable.hanoi, "Ha Noi", "Thanh Hoa"));
//        carScrollModelList.add(new CarScrollModel(R.drawable.thanhhoa, "Ha Noi", "Thanh Hoa"));
//
//        List<HotelScrollModel> hotelScrollModels = new ArrayList<>();
//        hotelScrollModels.add(new HotelScrollModel(R.drawable.hanoi, "Ha Noi"));
//        hotelScrollModels.add(new HotelScrollModel(R.drawable.nghean, "Nghe An"));
//        hotelScrollModels.add(new HotelScrollModel(R.drawable.thanhhoa, "Thanh Hoa"));
//
//        RecyclerView recyclerView1 = findViewById(R.id.recycler_view_car_from_scroll_main);
//        RecyclerView recyclerView2 = findViewById(R.id.recycler_view_hotel_from_scroll_main);
//
//        recyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
//        CarScrollAdapter carScrollAdapter = new CarScrollAdapter(carScrollModelList);
//        carScrollAdapter.setOnClickInScrollItemCar(new OnClickInScrollItemCar() {
//            @Override
//            public void onClickItemCar(int position) {
//                String startPlace = carScrollModelList.get(position).getText1();
//                String endPlace = carScrollModelList.get(position).getText2();
//                Intent intent = new Intent(ScrollingMainActivity.this, DisplayCarActivity.class);
//                intent.putExtra("startPlace", startPlace);
//                intent.putExtra("endPlace", endPlace);
//                startActivity(intent);
//            }
//        });
//        recyclerView1.setAdapter(carScrollAdapter);
//
//        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
//        HotelScrollAdapter hotelScrollAdapter = new HotelScrollAdapter(hotelScrollModels);
//        recyclerView2.setAdapter(hotelScrollAdapter);
//    }
//    private void displayHoldButton()
//    {
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = false;
//            int scrollRange = -1;
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                scrollRange = appBarLayout.getTotalScrollRange();
//                if(scrollRange + verticalOffset == 0)
//                {
//                    isShow = true;
//                    //setvisible
//                    cardViewHoldButton.setVisibility(View.VISIBLE);
//                }
//                else if(isShow)
//                {
//                    isShow = false;
//                    //setgone
//                    cardViewHoldButton.setVisibility(View.GONE);
//                }
//            }
//        });
//    }
}
package com.example.testdbentity.shoppingfragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.testdbentity.shoppingfragment.carshopping.CarShoppingFragment;
import com.example.testdbentity.shoppingfragment.hotelshopping.HotelShoppingFragment;
import com.example.testdbentity.shoppingfragment.trainshopping.TrainShoppingFragment;

public class ShoppingViewAdapter extends FragmentStateAdapter {
    public ShoppingViewAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new CarShoppingFragment();
            case 1:
                return new HotelShoppingFragment();
        }
        return new CarShoppingFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

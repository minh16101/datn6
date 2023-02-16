package com.example.testdbentity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.testdbentity.accountfragment.AccountFragment;
import com.example.testdbentity.discoverfragment.DiscoveryFragment;
import com.example.testdbentity.homefragment.HomeFragment;
import com.example.testdbentity.shoppingfragment.ShoppingFragment;

public class ViewPageAdapter  extends FragmentStateAdapter {


    public ViewPageAdapter(@NonNull FragmentActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new ShoppingFragment();
            case 2:
                return new DiscoveryFragment();
            case 3:
                return new AccountFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}


package com.example.testdbentity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.testdbentity.accountfragment.AccountFragment;
import com.example.testdbentity.discoverfragment.DiscoveryFragment;
import com.example.testdbentity.homefragment.HomeFragment;
import com.example.testdbentity.shoppingfragment.ShoppingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainPageActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager;

    private NavigationBarView.OnItemSelectedListener onSelectItem = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.item_home:
                    fragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
                    return true;

                case R.id.item_bill:
                    fragment = new ShoppingFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
                    return true;

                case R.id.item_discover:
                    fragment = new DiscoveryFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
                    return true;

                case R.id.item_account:
                    fragment = new AccountFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        bottomNavigationView = findViewById(R.id.bottom_nav_main_page);

        bottomNavigationView.setOnItemSelectedListener(onSelectItem);
        bottomNavigationView.setSelectedItemId(R.id.item_home);
        Fragment fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();

    }

    @Override
    public void onBackPressed() {

    }
}
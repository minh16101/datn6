package com.example.testdbentity.login;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.testdbentity.R;
import com.example.testdbentity.login.LoginAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class LoginActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton floatingActionButton1;
    private FloatingActionButton floatingActionButton2;
    private FloatingActionButton floatingActionButton3;
    private LoginAdapter loginAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewPager2 = findViewById(R.id.view_pager_login);
        bottomNavigationView = findViewById(R.id.tab_layout_login);

        loginAdapter = new LoginAdapter(this);
        viewPager2.setAdapter(loginAdapter);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.login_home:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.login_sign_up:
                        viewPager2.setCurrentItem(1);
                        break;
                }
                return true;
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position)
                {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.login_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.login_sign_up).setChecked(true);
                        break;
                }

            }
        });
    }
}

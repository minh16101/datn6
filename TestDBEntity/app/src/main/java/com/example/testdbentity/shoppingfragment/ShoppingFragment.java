package com.example.testdbentity.shoppingfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testdbentity.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ShoppingFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;


    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shopping, container, false);
        tabLayout = view.findViewById(R.id.tab_layout_shopping);
        viewPager2 = view.findViewById(R.id.view_pager_sopping);
        ShoppingViewAdapter shoppingViewAdapter = new ShoppingViewAdapter(getActivity());
        viewPager2.setAdapter(shoppingViewAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position)
                {
                    case 0:
                        tab.setText("Car");
                        break;
                    case 1:
                        tab.setText("Hotel");
                        break;
                }
            }
        }).attach();
        return view;
    }
}
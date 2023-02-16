package com.example.testdbentity.discoverfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.adapter.ItemSAdapter;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;
import com.example.testdbentity.homefragment.bookinghotel.image.roomandimg.RoomWithImage;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryFragment extends Fragment {

    BookingHotelViewModel bookingHotelViewModel;

    public DiscoveryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discovery, container, false);
        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);
        int idInformationUser = getActivity().getIntent().getIntExtra("idUserInformation",0);

        LiveData<List<RoomWithImage>> roomWithImageList = bookingHotelViewModel.getRoomWithUserId(idInformationUser);
        ItemSAdapter itemSAdapter = new ItemSAdapter(new ArrayList<>());

        roomWithImageList.observe(getActivity(), new Observer<List<RoomWithImage>>() {
            @Override
            public void onChanged(List<RoomWithImage> roomWithImages) {
                itemSAdapter.setData(roomWithImages);
                itemSAdapter.notifyDataSetChanged();
            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.save_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(itemSAdapter);
        return view;
    }
}
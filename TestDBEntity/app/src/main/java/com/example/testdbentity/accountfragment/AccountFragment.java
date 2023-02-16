
package com.example.testdbentity.accountfragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.R;
import com.example.testdbentity.accountfragment.activity.QuanLyAccountActivity;
import com.example.testdbentity.discoverfragment.DiscoveryFragment;
import com.example.testdbentity.homefragment.bookingcar.viewmodel.BookingCarViewModel;
import com.example.testdbentity.homefragment.bookinghotel.DisplayRoomDetailActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class AccountFragment extends Fragment {

    public AccountFragment() {
        // Required empty public constructor
    }
    private ItemImageAdapter itemImageAdapter;
    private ShapeableImageView imageView;
    private RecyclerView recyclerView;
    private List<String> listPaths;
    private BookingCarViewModel bookingCarViewModel;
    private int idUser;
    private int idHotel;
    private ImaageObserver imaageObserver = new ImaageObserver(null){
        @Override
        public void onChange(boolean selfChange, @Nullable Uri uri) {
            super.onChange(selfChange, uri);
            DataImageAsyncTask dataImageAsyncTask = new DataImageAsyncTask(getContext());
            dataImageAsyncTask.setData(new DataImageAsyncTask.OnLoadImageData() {
                @Override
                public void setOnLoadImageData(List<String> loadImageData) {
                    listPaths = loadImageData;
                    itemImageAdapter.setListPaths(listPaths);
                    itemImageAdapter.notifyDataSetChanged();
                }
            });
            dataImageAsyncTask.execute();
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, imaageObserver);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().getContentResolver().unregisterContentObserver(imaageObserver);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        bookingCarViewModel = new ViewModelProvider(this).get(BookingCarViewModel.class);
        getIntentItem();
        //set name user
        TextView name = view.findViewById(R.id.account_name);
        LiveData<InformationEntity> informationEntity = bookingCarViewModel.getLiveDataInformationUser(idUser);
        informationEntity.observe(getActivity(), new Observer<InformationEntity>() {
            @Override
            public void onChanged(InformationEntity informationEntity) {
                name.setText(informationEntity.lastNaeInformationUser + " " + informationEntity.firstNaeInformationUser);
                if(informationEntity.avatarInformationUser != null) {
                    Glide.with(imageView).load(informationEntity.avatarInformationUser).into(imageView);
                }
            }
        });
        //set avatar user

        Button btnQLTK = view.findViewById(R.id.quan_ly_tai_khoan);
        btnQLTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QuanLyAccountActivity.class);
                intent.putExtra("idUserInformation1", idUser);
                startActivity(intent);
            }
        });

        Button saved = view.findViewById(R.id.account_saved);
        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiscoveryFragment fragment = new DiscoveryFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainerView, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        clickAvatar(view);
        return view;
    }
    private void getIntentItem()
    {
        idUser = getActivity().getIntent().getIntExtra("idUserInformation", 0);
        idHotel = getActivity().getIntent().getIntExtra("idHotel", 0);
    }
    private void clickAvatar(View view)
    {
        listPaths = new ArrayList<>();
        imageView = view.findViewById(R.id.item_avatar);
        DataImageAsyncTask dataImageAsyncTask = new DataImageAsyncTask(getContext());
        dataImageAsyncTask.setData(new DataImageAsyncTask.OnLoadImageData() {
            @Override
            public void setOnLoadImageData(List<String> loadImageData) {
                listPaths = loadImageData;
            }
        });
        dataImageAsyncTask.execute();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomDialog();
            }
        });
    }
    private void showBottomDialog()
    {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
        bottomSheetDialog.setContentView(R.layout.bottom_sheat_image_account);
        recyclerView = bottomSheetDialog.findViewById(R.id.recycler_view_image);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        itemImageAdapter = new ItemImageAdapter(listPaths);
        itemImageAdapter.setOnClickImageAccount(new OnClickImageAccount() {
            @Override
            public void setOnClickImageAccount(int position){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Change avater");
                builder.setTitle("Do you want to change avatar?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Glide.with(imageView).load(listPaths.get(position)).into(imageView);
                        InformationEntity informationEntity = bookingCarViewModel.getInformationUser(idUser);
                        informationEntity.avatarInformationUser = listPaths.get(position);
                        bookingCarViewModel.updateInformationUser(informationEntity);
                        bottomSheetDialog.cancel();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        recyclerView.setAdapter(itemImageAdapter);
        bottomSheetDialog.show();
    }
    private void clickButtonQLTK(View view)
    {

    }
}
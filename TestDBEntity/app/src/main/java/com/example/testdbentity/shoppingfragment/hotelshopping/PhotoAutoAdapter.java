package com.example.testdbentity.shoppingfragment.hotelshopping;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.testdbentity.R;

import java.util.List;

public class PhotoAutoAdapter extends PagerAdapter {

    List<PhotoAuto> photoAutoList;

    public PhotoAutoAdapter(List<PhotoAuto> photoAutoList) {
        this.photoAutoList = photoAutoList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo_auto_slide, container, false);
        ImageView imageView = view.findViewById(R.id.img_auto_slide);
        PhotoAuto photoAuto = photoAutoList.get(position);
        imageView.setImageResource(photoAuto.getResourceId());

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return photoAutoList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View)object);

    }
}

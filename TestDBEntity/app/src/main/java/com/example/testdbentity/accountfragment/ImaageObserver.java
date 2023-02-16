package com.example.testdbentity.accountfragment;

import android.database.ContentObservable;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

import androidx.annotation.Nullable;

public class ImaageObserver extends ContentObserver {
    public ImaageObserver(Handler handler) {
        super(handler);
    }

    @Override
    public void onChange(boolean selfChange, @Nullable Uri uri) {
        super.onChange(selfChange, uri);
    }
}

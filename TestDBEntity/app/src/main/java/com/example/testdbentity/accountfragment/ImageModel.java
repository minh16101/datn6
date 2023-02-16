package com.example.testdbentity.accountfragment;

import android.net.Uri;

public class ImageModel {
    private Uri uri;
    private String name;
    private String data;
    private long date;

    public ImageModel(Uri uri, String name, String data, long date) {
        this.uri = uri;
        this.name = name;
        this.data = data;
        this.date = date;
    }
}

package com.example.testdbentity.accountfragment;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class DataImageAsyncTask extends AsyncTask<Void, Void, List<String>> {

    private Context context;
    private OnLoadImageData onLoadImageData;

    private List<String> listPath;
    public DataImageAsyncTask(Context context) {
        listPath = new ArrayList<>();
        this.context = context;
    }

    interface OnLoadImageData{
        public void setOnLoadImageData(List<String> loadImageData);
    }

    public void setData(OnLoadImageData onLoadImageData)
    {
        this.onLoadImageData = onLoadImageData;
    }
    @Override
    protected List<String> doInBackground(Void... voids) {
        Uri collection;
        collection = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = new String[]{
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.DATE_TAKEN
        };
        String sortOrder = MediaStore.Images.Media.DATE_TAKEN + " DESC";
        Cursor curson = context.getContentResolver().query(collection, projection, null, null, sortOrder);

        int idColumn = curson.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
        int nameColumn = curson.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME);
        int dataColumn = curson.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        int dateColumn = curson.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_TAKEN);

        while (curson.moveToNext())
        {
            long id = curson.getLong(idColumn);
            String name = curson.getString(nameColumn);
            String data = curson.getString(dataColumn);
            long date = curson.getLong(dateColumn);
            Uri contentUri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
            ImageModel imageModel = new ImageModel(contentUri, name, data, date);
            listPath.add(data);
        }
        return listPath;
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        super.onPostExecute(strings);
        onLoadImageData.setOnLoadImageData(strings);
    }
}

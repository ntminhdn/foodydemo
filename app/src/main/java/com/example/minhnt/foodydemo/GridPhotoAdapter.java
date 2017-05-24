package com.example.minhnt.foodydemo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minh.nt on 5/23/2017.
 */

public class GridPhotoAdapter extends BaseAdapter {
    private Context context;
    private List<String> objects;

    public GridPhotoAdapter(@NonNull Context context, @NonNull List<String> objects) {
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgView;
        if (convertView == null) {
            imgView = new ImageView(context);
            imgView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imgView = (ImageView) convertView;
        }

        Picasso.with(context).load(objects.get(position)).into(imgView);
        return imgView;
    }

    public void setObjects(List<String> objects) {
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects == null ? 0 : objects.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}

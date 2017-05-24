package com.example.minhnt.foodydemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by minh.nt on 5/22/2017.
 */

public class SlidePagerAdapter extends PagerAdapter {
    private Context context;
    private List<String> urls;
    private LayoutInflater layoutInflater;

    public SlidePagerAdapter(Context context, List<String> urls) {
        this.urls = urls;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return urls == null ? 0 : urls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.item_viewpager, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.ivSlide);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Log.d("sadsdassdasd", urls.get(position));
        Picasso.with(context).load(urls.get(position)).into(imageView);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}

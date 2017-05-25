package com.example.minhnt.foodydemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by minh.nt on 5/25/2017.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{
    private Button btnODau, btnAnGi;
    private ImageView ivLogo, ivAdd;
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView(view);
    }

    private void initView(View view) {
        btnODau = (Button) view.findViewById(R.id.btnODau);
        btnAnGi = (Button) view.findViewById(R.id.btnAnGi);

        btnODau.setOnClickListener(this);
        btnAnGi.setOnClickListener(this);

        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            btnODau.setBackgroundDrawable( getResources().getDrawable(R.drawable.odau_bg_press) );
        } else {
            btnODau.setBackground( getResources().getDrawable(R.drawable.odau_bg_press));
        }

        ivLogo = (ImageView) view.findViewById(R.id.ivLogo);
        ivAdd = (ImageView) view.findViewById(R.id.ivAdd);

        pager = (ViewPager) view.findViewById(R.id.view_pager);
        FragmentManager manager = getFragmentManager();
        pagerAdapter = new PagerAdapter(manager);
        pager.setAdapter(pagerAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        btnODau.setBackgroundDrawable( getResources().getDrawable(R.drawable.odau_bg_press) );
                        btnAnGi.setBackgroundDrawable( getResources().getDrawable(R.drawable.angi_bg) );
                    } else {
                        btnODau.setBackground( getResources().getDrawable(R.drawable.odau_bg_press));
                        btnAnGi.setBackground( getResources().getDrawable(R.drawable.angi_bg));
                    }
                } else {
                    if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        btnAnGi.setBackgroundDrawable( getResources().getDrawable(R.drawable.angi_bg_press) );
                        btnODau.setBackgroundDrawable( getResources().getDrawable(R.drawable.odau_bg) );
                    } else {
                        btnAnGi.setBackground( getResources().getDrawable(R.drawable.angi_bg_press));
                        btnODau.setBackground( getResources().getDrawable(R.drawable.odau_bg));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnODau:
                pager.setCurrentItem(0,true);
                break;
            case R.id.btnAnGi:
                pager.setCurrentItem(1,true);
                break;
        }
    }
}

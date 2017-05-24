package com.example.minhnt.foodydemo;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnODau, btnAnGi;
    private ImageView ivLogo, ivAdd;

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnODau = (Button) findViewById(R.id.btnODau);
        btnAnGi = (Button) findViewById(R.id.btnAnGi);
        btnODau.setOnClickListener(this);
        btnAnGi.setOnClickListener(this);

        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            btnODau.setBackgroundDrawable( getResources().getDrawable(R.drawable.odau_bg_press) );
        } else {
            btnODau.setBackground( getResources().getDrawable(R.drawable.odau_bg_press));
        }

        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        ivAdd = (ImageView) findViewById(R.id.ivAdd);

        pager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager manager = getSupportFragmentManager();
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

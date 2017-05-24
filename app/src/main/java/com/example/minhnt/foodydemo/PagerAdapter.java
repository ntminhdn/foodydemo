package com.example.minhnt.foodydemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

/**
 * Created by minh.nt on 5/23/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ODauFragment();
        } else {
            return new AnGiFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}

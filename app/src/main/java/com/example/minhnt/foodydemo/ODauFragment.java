package com.example.minhnt.foodydemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minh.nt on 5/23/2017.
 */

public class ODauFragment extends Fragment {
    private MainAdapter mainAdapter;
    private List<ModelObject> objects = new ArrayList<>();
    private TabLayout tabLayout;
    private RecyclerView recyclerView;
    private boolean showMain = true;
    private MoiNhatFragment moiNhatFragment;
    private DanhMucFragment danhMucFragment;
    private CityFragment cityFragment;
    private FrameLayout frameLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_frame_odau, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView(view);
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rvMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mainAdapter = new MainAdapter(getContext(), objects, MainAdapter.O_DAU);
        recyclerView.setAdapter(mainAdapter);
        mainAdapter.notifyDataSetChanged();

        tabLayout = (TabLayout) view.findViewById(R.id.tlButtonODau);
        tabLayout.addTab(tabLayout.newTab().setText("Mới nhất"));
        tabLayout.addTab(tabLayout.newTab().setText("Danh mục"));
        tabLayout.addTab(tabLayout.newTab().setText("Đà Nẵng"));
        tabLayout.setSelectedTabIndicatorColor(Color.TRANSPARENT);
        moiNhatFragment = new MoiNhatFragment();
        danhMucFragment = new DanhMucFragment();
        cityFragment = new CityFragment();
        frameLayout = (FrameLayout) view.findViewById(R.id.flTabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                showMain = false;
                frameLayout.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                setCurrentTabFragment(tab.getPosition());
                Log.d("adasdasdad", "onTabSelected");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.d("adasdasdad", "onTabUnselected");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                showMain = !showMain;
                if (showMain) {
                    recyclerView.setVisibility(View.VISIBLE);
                    frameLayout.setVisibility(View.GONE);
                } else {
                    frameLayout.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                    setCurrentTabFragment(tab.getPosition());
                }
                Log.d("adasdasdad", "onTabReselected");
            }
        });
    }

    private void setCurrentTabFragment(int tabPosition) {
        switch (tabPosition) {
            case 0:
                replaceFragment(moiNhatFragment);
                break;
            case 1:
                replaceFragment(danhMucFragment);
                break;
            case 2:
                replaceFragment(cityFragment);
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flTabLayout, fragment).commit();
    }
}

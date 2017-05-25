package com.example.minhnt.foodydemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minh.nt on 5/23/2017.
 */

public class AnGiFragment extends Fragment {
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<ModelObject> list = new ArrayList<>();
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_frame_angi, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView(view);
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rvAnGi);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MainAdapter(getContext(), list, MainAdapter.AN_GI);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        tabLayout = (TabLayout) view.findViewById(R.id.tlButtonAnGi);
        tabLayout.addTab(tabLayout.newTab().setText("Mới nhất"));
        tabLayout.addTab(tabLayout.newTab().setText("Danh mục"));
        tabLayout.addTab(tabLayout.newTab().setText("Đà Nẵng"));
        tabLayout.setSelectedTabIndicatorColor(Color.TRANSPARENT);
    }
}

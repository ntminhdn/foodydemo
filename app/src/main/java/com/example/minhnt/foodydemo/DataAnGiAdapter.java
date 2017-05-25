package com.example.minhnt.foodydemo;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by minh.nt on 5/25/2017.
 */

public class DataAnGiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DataAnGiObject> objects;
    private LayoutInflater layoutInflater;
    private Context context;

    public DataAnGiAdapter(Context context, List<DataAnGiObject> objects) {
        this.context = context;
        this.objects = objects;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new DataAnGiAdapter.DataObjectVH(layoutInflater.inflate(R.layout.item_an_gi_data, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((DataAnGiAdapter.DataObjectVH) holder).setData(objects.get(position));
    }

    @Override
    public int getItemCount() {
        return objects == null ? 0 : objects.size();
    }

    class DataObjectVH extends RecyclerView.ViewHolder {
        private TextView tvFoodName, tvRestName, tvRestAdress, tvUserName, tvDateComment;
        private AppCompatImageView ivFood;
        private CircleImageView ivUserAvatar;

        public DataObjectVH(View itemView) {
            super(itemView);
            tvFoodName = (TextView) itemView.findViewById(R.id.tvFoodName);
            tvRestName = (TextView) itemView.findViewById(R.id.tvRestName);
            tvRestAdress = (TextView) itemView.findViewById(R.id.tvRestAdress);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvDateComment = (TextView) itemView.findViewById(R.id.tvDateComment);
            ivFood = (AppCompatImageView) itemView.findViewById(R.id.ivFood);
            ivUserAvatar = (CircleImageView) itemView.findViewById(R.id.ivUserAvatar);
        }

        public void setData(DataAnGiObject data) {
            Picasso.with(context).load(data.photo).into(ivFood);
            Picasso.with(context).load(data.avatar).into(ivUserAvatar);
            tvFoodName.setText(data.foodName);
            tvRestName.setText(data.restName);
            tvRestAdress.setText(data.address);
            tvUserName.setText(data.username);
            tvDateComment.setText(data.time);
        }
    }

    public void setObjects(List<DataAnGiObject> objects) {
        this.objects = objects;
    }
}

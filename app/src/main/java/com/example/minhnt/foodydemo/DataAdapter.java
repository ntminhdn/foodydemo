package com.example.minhnt.foodydemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by minh.nt on 5/23/2017.
 */

public class DataAdapter extends RecyclerView.Adapter {

    private List<DataObject> objects;
    private LayoutInflater layoutInflater;
    private Context context;

//    public static final int INFO = 0;
//    public static final int PHOTOS = 1;
//    public static final int COMMENT = 2;
//    public static final int STATUS = 3;

    public DataAdapter(Context context, List<DataObject> objects) {
        this.context = context;
        this.objects = objects;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        switch (viewType) {
//            case INFO:
//                return new InfoVH(layoutInflater.inflate(R.layout.item_rv_info, parent, false));
//            case PHOTOS:
//                return new PhotosVH(layoutInflater.inflate(R.layout.item_rv_photos, parent, false));
//            case COMMENT:
//                return new CommentVH(layoutInflater.inflate(R.layout.item_rv_comment, parent, false));
//            case STATUS:
//                return new StatusVH(layoutInflater.inflate(R.layout.item_rv_status, parent, false));
//        }

        return new DataObjectVH(layoutInflater.inflate(R.layout.item_rv_data, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (holder instanceof InfoVH) {
//            ((InfoVH) holder).setData((InfoModel) objects.get(position).object);
//        } else if (holder instanceof PhotosVH) {
//            ((PhotosVH) holder).setData((PhotosModel) objects.get(position).object);
//        } else if (holder instanceof CommentVH) {
//            ((CommentVH) holder).setData((CommentModel) objects.get(position).object);
//        } else if (holder instanceof StatusVH) {
//            ((StatusVH) holder).setData((StatusModel) objects.get(position).object);
//        }

        ((DataObjectVH) holder).setData(objects.get(position));
    }

    @Override
    public int getItemCount() {
        return objects == null ? 0 : objects.size();
    }

    class DataObjectVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTotalRate, tvRestName, tvAddress;
        private Button btnTotalComment, btnTotalPhoto;
        private TextView tvStatus;
        private CircleImageView ivAvatar, ivAvatar2;
        private TextView tvRate, tvRate2, tvName, tvName2, tvComment, tvComment2;
        private ImageView ivPhoto1, ivPhoto2, ivPhoto3, ivPhoto4, ivPhoto5, ivPhoto6, ivPhoto7;
        private ImageView ivStatus;

        public DataObjectVH(View itemView) {
            super(itemView);
            tvTotalRate = (TextView) itemView.findViewById(R.id.tvTotalRate);
            tvRestName = (TextView) itemView.findViewById(R.id.tvRestaurantName);
            tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
            btnTotalComment = (Button) itemView.findViewById(R.id.btnComment);
            btnTotalPhoto = (Button) itemView.findViewById(R.id.btnPhotos);
            tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);
            ivStatus = (ImageView) itemView.findViewById(R.id.ivStatus);

            btnTotalPhoto.setOnClickListener(this);
            btnTotalComment.setOnClickListener(this);

            tvRate = (TextView) itemView.findViewById(R.id.tvRate);
            tvRate2 = (TextView) itemView.findViewById(R.id.tvRate2);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvName2 = (TextView) itemView.findViewById(R.id.tvName2);
            tvComment = (TextView) itemView.findViewById(R.id.tvComment);
            tvComment2 = (TextView) itemView.findViewById(R.id.tvComment2);
            ivAvatar = (CircleImageView) itemView.findViewById(R.id.ivAvatar);
            ivAvatar2 = (CircleImageView) itemView.findViewById(R.id.ivAvatar2);

            ivPhoto1 = (ImageView) itemView.findViewById(R.id.ivPhoto1);
            ivPhoto2 = (ImageView) itemView.findViewById(R.id.ivPhoto2);
            ivPhoto3 = (ImageView) itemView.findViewById(R.id.ivPhoto3);
            ivPhoto4 = (ImageView) itemView.findViewById(R.id.ivPhoto4);
            ivPhoto5 = (ImageView) itemView.findViewById(R.id.ivPhoto5);
            ivPhoto6 = (ImageView) itemView.findViewById(R.id.ivPhoto6);
            ivPhoto7 = (ImageView) itemView.findViewById(R.id.ivPhoto7);
        }

        public void setData(DataObject data) {
            tvAddress.setText(data.infoModel.address);
            tvRestName.setText(data.infoModel.restName);
            tvTotalRate.setText(String.valueOf(data.infoModel.totalRate));

            btnTotalComment.setText(String.valueOf(data.statusModel.totalComment));
            btnTotalPhoto.setText(String.valueOf(data.statusModel.totalPhotos));
            tvStatus.setText(data.statusModel.status ? "Đang mở cửa" : "Chưa mở cửa");
            ivStatus.setImageResource(data.statusModel.status ? R.drawable.circlegreen : R.drawable.circlegray);

            Picasso.with(context).load(data.commentModel.avatar[0]).into(ivAvatar);
            Picasso.with(context).load(data.commentModel.avatar[1]).into(ivAvatar2);
            tvRate.setText(String.valueOf(data.commentModel.userRate[0]));
            tvRate2.setText(String.valueOf(data.commentModel.userRate[1]));
            tvName.setText(String.valueOf(data.commentModel.username[0]));
            tvName2.setText(String.valueOf(data.commentModel.username[1]));
            tvComment.setText(String.valueOf(data.commentModel.comment[0]));
            tvComment2.setText(String.valueOf(data.commentModel.comment[1]));

            Picasso.with(context).load(data.photosModel.photos.get(0)).into(ivPhoto1);
            Picasso.with(context).load(data.photosModel.photos.get(1)).into(ivPhoto2);
            Picasso.with(context).load(data.photosModel.photos.get(2)).into(ivPhoto3);
            Picasso.with(context).load(data.photosModel.photos.get(3)).into(ivPhoto4);
            Picasso.with(context).load(data.photosModel.photos.get(4)).into(ivPhoto5);
            Picasso.with(context).load(data.photosModel.photos.get(5)).into(ivPhoto6);
            Picasso.with(context).load(data.photosModel.photos.get(6)).into(ivPhoto7);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnComment:
                    Toast.makeText(context, "Comment", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnPhotos:
                    Toast.makeText(context, "Photos", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }


//    class InfoVH extends RecyclerView.ViewHolder {
//        private TextView tvTotalRate, tvRestName, tvAddress;
//
//        public InfoVH(View itemView) {
//            super(itemView);
//            tvTotalRate = (TextView) itemView.findViewById(R.id.tvTotalRate);
//            tvRestName = (TextView) itemView.findViewById(R.id.tvRestaurantName);
//            tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
//        }
//
//        public void setData(InfoModel data) {
//            tvAddress.setText(data.address);
//            tvRestName.setText(data.restName);
//            tvTotalRate.setText(String.valueOf(data.totalRate));
//        }
//    }
//
//    class PhotosVH extends RecyclerView.ViewHolder {
//
//        public PhotosVH(View itemView) {
//            super(itemView);
//        }
//
//        public void setData(PhotosModel object) {
//
//        }
//    }
//
//    class CommentVH extends RecyclerView.ViewHolder {
//
//        public CommentVH(View itemView) {
//            super(itemView);
//        }
//
//        public void setData(CommentModel object) {
//
//        }
//    }
//
//    class StatusVH extends RecyclerView.ViewHolder implements View.OnClickListener {
//        private Button btnTotalComment, btnTotalPhoto;
//        private TextView tvStatus;
//
//        public StatusVH(View itemView) {
//            super(itemView);
//            btnTotalComment = (Button) itemView.findViewById(R.id.btnComment);
//            btnTotalPhoto = (Button) itemView.findViewById(R.id.btnPhotos);
//            tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);
//
//            btnTotalPhoto.setOnClickListener(this);
//            btnTotalComment.setOnClickListener(this);
//        }
//
//        public void setData(StatusModel object) {
//            btnTotalComment.setText(String.valueOf(object.totalComment));
//            btnTotalPhoto.setText(String.valueOf(object.totalPhotos));
//            tvStatus.setText(object.status ? "Đang mở cửa" : "Chưa mở cửa");
//        }
//
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.btnComment:
//                    Toast.makeText(context, "Comment", Toast.LENGTH_LONG).show();
//                    break;
//                case R.id.btnPhotos:
//                    Toast.makeText(context, "Photos", Toast.LENGTH_LONG).show();
//                    break;
//            }
//        }
//    }

    public void setObjects(List<DataObject> objects) {
        this.objects = objects;
    }
}

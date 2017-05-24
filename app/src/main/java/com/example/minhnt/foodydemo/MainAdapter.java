package com.example.minhnt.foodydemo;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minh.nt on 5/22/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ModelObject> objects;
    private LayoutInflater layoutInflater;
    private Context context;
    public static final int SLIDE = 0;
    public static final int BUTTON = 1;
    public static final int DATA = 2;


    public MainAdapter(Context context, List<ModelObject> objects) {
        this.objects = objects;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

        addData();
    }

    private void addData() {
        List<String> urls = new ArrayList<>();
        urls.add("https://media.foody.vn/res/g29/284869/prof/s640x400/foody-mobile-c2-jpg-644-636123091081270510.jpg");
        urls.add("https://media.foody.vn/video/s800x450/foody-1-636060124092136779.jpg");
        urls.add("https://media.foody.vn/res/g10/95730/prof/s640x400/foody-mobile-mof-vivo-jpg-597-636165257196846650.jpg");
        urls.add("https://media.foody.vn/res/g28/271029/prof/s640x400/foody-mobile-3034-jpg-279-636087770293510961.jpg");
        urls.add("https://media.foody.vn/res/g27/269739/prof/s480x300/foody-mobile-12-jpg-131-636147129842928083.jpg");
        urls.add("https://media.foody.vn/video/s800x450/foody-800x450%20sasin-636050635818573794.jpg");
        urls.add("https://media.foody.vn/res/g19/187619/prof/s480x300/foody-mobile-boru-jpg-670-636131655639665965.jpg");

        List<String> banners = new ArrayList<>();
        banners.add("http://danangz.vn/wp-content/uploads/2016/07/sl_lon_98.png");
        banners.add("http://foodecstasy.com/img/banner.png");
        objects.add(new ModelObject(MainAdapter.SLIDE, new SlideModel(banners)));
        objects.add(new ModelObject(MainAdapter.BUTTON, ""));

        List<DataObject> data = new ArrayList<>();
        data.add(new DataObject(new InfoModel(7.8, "Nhà hàng Phì Lũ", "112 Lê Độ"), new PhotosModel(urls), new CommentModel(new String[]{"http://images.tapchianhdep.net/15-11tong-hop-hinh-anh-hot-girl-9x-viet-de-thuong-nhat9.jpg", "https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1"}, new String[]{"Minh", "Uyên"}, new String[]{"Nhà hàng nhỏ nhỏ xinh xinh, mình cũng hay ghé đây ăn lắm mà giờ mới review được.", "Đồ ăn ở đây chất lượng thì rất tốt nhưng phục vụ rất tệ."}, new double[]{7.8, 9.3}), new StatusModel(5, 10, true)));
        data.add(new DataObject(new InfoModel(7.8, "Nhà hàng Phì Lũ", "112 Lê Độ"), new PhotosModel(urls), new CommentModel(new String[]{"http://images.tapchianhdep.net/15-11tong-hop-hinh-anh-hot-girl-9x-viet-de-thuong-nhat9.jpg", "https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1"}, new String[]{"Minh", "Uyên"}, new String[]{"Nhà hàng nhỏ nhỏ xinh xinh, mình cũng hay ghé đây ăn lắm mà giờ mới review được.", "Đồ ăn ở đây chất lượng thì rất tốt nhưng phục vụ rất tệ."}, new double[]{7.8, 9.3}), new StatusModel(5, 10, true)));
        data.add(new DataObject(new InfoModel(7.8, "Nhà hàng Phì Lũ", "112 Lê Độ"), new PhotosModel(urls), new CommentModel(new String[]{"http://images.tapchianhdep.net/15-11tong-hop-hinh-anh-hot-girl-9x-viet-de-thuong-nhat9.jpg", "https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1"}, new String[]{"Minh", "Uyên"}, new String[]{"Nhà hàng nhỏ nhỏ xinh xinh, mình cũng hay ghé đây ăn lắm mà giờ mới review được.", "Đồ ăn ở đây chất lượng thì rất tốt nhưng phục vụ rất tệ."}, new double[]{7.8, 9.3}), new StatusModel(5, 10, false)));
        data.add(new DataObject(new InfoModel(7.8, "Nhà hàng Phì Lũ", "112 Lê Độ"), new PhotosModel(urls), new CommentModel(new String[]{"http://images.tapchianhdep.net/15-11tong-hop-hinh-anh-hot-girl-9x-viet-de-thuong-nhat9.jpg", "https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1"}, new String[]{"Minh", "Uyên"}, new String[]{"Nhà hàng nhỏ nhỏ xinh xinh, mình cũng hay ghé đây ăn lắm mà giờ mới review được.", "Đồ ăn ở đây chất lượng thì rất tốt nhưng phục vụ rất tệ."}, new double[]{7.8, 9.3}), new StatusModel(5, 10, false)));
        data.add(new DataObject(new InfoModel(7.8, "Nhà hàng Phì Lũ", "112 Lê Độ"), new PhotosModel(urls), new CommentModel(new String[]{"http://images.tapchianhdep.net/15-11tong-hop-hinh-anh-hot-girl-9x-viet-de-thuong-nhat9.jpg", "https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1"}, new String[]{"Minh", "Uyên"}, new String[]{"Nhà hàng nhỏ nhỏ xinh xinh, mình cũng hay ghé đây ăn lắm mà giờ mới review được.", "Đồ ăn ở đây chất lượng thì rất tốt nhưng phục vụ rất tệ."}, new double[]{7.8, 9.3}), new StatusModel(5, 10, true)));
        data.add(new DataObject(new InfoModel(7.8, "Nhà hàng Phì Lũ", "112 Lê Độ"), new PhotosModel(urls), new CommentModel(new String[]{"http://images.tapchianhdep.net/15-11tong-hop-hinh-anh-hot-girl-9x-viet-de-thuong-nhat9.jpg", "https://www.dropbox.com/s/hdsmnrzpkutbcfa/000%20%28Copy%29-min.jpg?dl=1"}, new String[]{"Minh", "Uyên"}, new String[]{"Nhà hàng nhỏ nhỏ xinh xinh, mình cũng hay ghé đây ăn lắm mà giờ mới review được.", "Đồ ăn ở đây chất lượng thì rất tốt nhưng phục vụ rất tệ."}, new double[]{7.8, 9.3}), new StatusModel(5, 10, true)));
        objects.add(new ModelObject(MainAdapter.DATA, data));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case SLIDE:
                return new SlideVH(layoutInflater.inflate(R.layout.item_slide_show, parent, false));
            case BUTTON:
                return new ButtonVH(layoutInflater.inflate(R.layout.item_list_button, parent, false));
            case DATA:
                return new DataVH(layoutInflater.inflate(R.layout.item_data, parent, false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ModelObject modelObject = objects.get(position);
        switch (modelObject.type) {
            case SLIDE:
                ((SlideVH) holder).setData((SlideModel) modelObject.object);
                break;
            case BUTTON:
                break;
            case DATA:
                ((DataVH) holder).setData((List<DataObject>) modelObject.object);
        }
    }

    @Override
    public int getItemCount() {
        return objects.size() == 0 ? 0 : objects.size();
    }

    @Override
    public int getItemViewType(int position) {
        return objects.get(position).type;
    }

    class SlideVH extends RecyclerView.ViewHolder {
        private ViewPager viewPager;
        private List<String> urls = new ArrayList<>();
        private SlidePagerAdapter pagerAdapter;

        public SlideVH(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.vpSlideShow);
            pagerAdapter = new SlidePagerAdapter(itemView.getContext(), urls);
            viewPager.setAdapter(pagerAdapter);
        }

        public void setData(SlideModel urls) {
            this.urls = urls.urls;
            pagerAdapter.setUrls(this.urls);
            pagerAdapter.notifyDataSetChanged();
        }
    }

    class ButtonVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Button btnGanToi;
        private Button btnCoupon;
        private Button btnDatCho;
        private Button btnDatGiaoHang;

        public ButtonVH(View itemView) {
            super(itemView);
            btnGanToi = (Button) itemView.findViewById(R.id.btnGanToi);
            btnCoupon = (Button) itemView.findViewById(R.id.btnCoupon);
            btnDatCho = (Button) itemView.findViewById(R.id.btnGanChoUuDai);
            btnDatGiaoHang = (Button) itemView.findViewById(R.id.btnDatGiaoHang);

            btnGanToi.setOnClickListener(this);
            btnCoupon.setOnClickListener(this);
            btnDatCho.setOnClickListener(this);
            btnDatGiaoHang.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.btnGanToi:
                    Toast.makeText(context, "Gần tôi", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    class DataVH extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private DataAdapter dataAdapter;
        private List<DataObject> list;

        public DataVH(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rvData);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    super.getItemOffsets(outRect, view, parent, state);
                    outRect.set(10, 10, 10, 10);
                }
            });
            dataAdapter = new DataAdapter(context, list);
            recyclerView.setAdapter(dataAdapter);
        }

        public void setData(List<DataObject> list) {
            this.list = list;
            dataAdapter.setObjects(this.list);
            dataAdapter.notifyDataSetChanged();
        }
    }
}

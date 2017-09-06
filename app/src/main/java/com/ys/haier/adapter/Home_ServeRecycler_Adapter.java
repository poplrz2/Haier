package com.ys.haier.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ys.haier.MyApp;
import com.ys.haier.R;
import com.ys.haier.data.Serve;

import java.util.List;

/**
 * Created by lzc on 2017-08-23.
 */

public class Home_ServeRecycler_Adapter extends RecyclerView.Adapter<Home_ServeRecycler_Adapter.MyViewHolder> {

    private String imgPath = "";
    private List<Serve.RowsBean> serveList;
    private Activity activity;

    /**********************************增加HeaderView和FooterView*******************************************/
    public static final int TYPE_FOOTER = 1;
    public static final int TYPE_NORMAL = 2;
    private View mFooterView;

    public View getmFooterView() {
        return mFooterView;
    }

    public void setmFooterView(View mFooterView) {
        this.mFooterView = mFooterView;
        notifyItemInserted(getItemCount() - 1);
    }

    @Override
    public int getItemViewType(int position) {
        if (mFooterView == null){
            return TYPE_NORMAL;
        }
        if (position == getItemCount() - 1){
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    /**********************************增加HeaderView和FooterView*******************************************/
    public Home_ServeRecycler_Adapter(Activity activity,List<Serve.RowsBean> serveList) {
        this.serveList = serveList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mFooterView != null && viewType == TYPE_FOOTER){
            return new MyViewHolder(mFooterView);
        }

        View view = LayoutInflater.from(activity).inflate(R.layout.home_serve_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    /**
     * Fun : 设置回调接口
     * 2017/08/27
     * LZC
     */
    public interface OnItemClickListener{
        void onitemclicklistenr(View view,int pos);
        void onlongitemclicklistener(View view,int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListenr(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if (getItemViewType(position) == TYPE_NORMAL){
            if (holder instanceof MyViewHolder){
                setData(holder, position);
                setItemListener(holder);
                return;
            }
            return;
        }
        else if (getItemViewType(position) == TYPE_FOOTER){
            setItemListener(holder);
            return;
        }
    }

    /**
     * Fun : 给Item包括FooterView设置点击事件
     * LZC
     * 2017/09/01
     * @param holder
     */
    private void setItemListener(final MyViewHolder holder) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getLayoutPosition();
                onItemClickListener.onitemclicklistenr(view,position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int position = holder.getLayoutPosition();
                onItemClickListener.onlongitemclicklistener(view,position);
                return false;
            }
        });
    }


    /**
     * Fun : 给item设置数据
     * LZC
     * 2017/09/01
     */
    private void setData(MyViewHolder holder, int position) {
        holder.serveTitle.setText(serveList.get(position).getServe_Name());
        holder.serveDes.setText(serveList.get(position).getServe_Describe());
        holder.serveProduct.setText(serveList.get(position).getServe_Product());
        holder.serveHander.setText(serveList.get(position).getHandlers()+"");
        holder.serveScan.setText(serveList.get(position).getNull1());
        imgPath = MyApp.URL_SERVER+serveList.get(position).getImage_Url();
        Uri uri = Uri.parse(imgPath);
        Log.d("imgPath", imgPath);
        Picasso.with(activity)
                .load(imgPath)
                .resize(100,100)
                .centerCrop()
                .error(R.drawable.default_binner_pic)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.serveImg);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView serveImg;
        private TextView serveTitle;
        private TextView serveDes;
        private TextView serveProduct;
        private TextView serveHander;
        private TextView serveScan;
        public MyViewHolder(View itemView) {
            super(itemView);
            serveImg = itemView.findViewById(R.id.serve_content_imge);
            serveTitle = itemView.findViewById(R.id.serve_Title);
            serveDes = itemView.findViewById(R.id.serve_describle);
            serveProduct = itemView.findViewById(R.id.serve_contain_product);
            serveHander = itemView.findViewById(R.id.serve_handlers);
            serveScan = itemView.findViewById(R.id.serve_scan_num1);
        }
    }

    @Override
    public int getItemCount() {
        if (mFooterView == null){
            return serveList.size();
        }else if (mFooterView != null){
                return serveList.size() + 1;
            }
        return serveList.size();
    }
}

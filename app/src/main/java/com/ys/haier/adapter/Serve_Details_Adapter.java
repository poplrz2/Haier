package com.ys.haier.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ys.haier.MyApp;
import com.ys.haier.R;
import com.ys.haier.data.ServeDetail;
import com.ys.haier.util.CircleTransform;

import java.util.List;

/**
 * Created by lzc on 2017-09-01.
 */

public class Serve_Details_Adapter extends RecyclerView.Adapter<Serve_Details_Adapter.MyViewHolder> {

    Activity activity;
    List<ServeDetail.RowsBean> tuijianList;

    /**
     * 给服务详情页的推荐RecyclerView设置监听事件
     * LZC
     * 2017/09/01
     */

    public interface OnItemClickListener{
        void onitemclicklistener(View view, int pos);
        void onlongitemclicklistener(View view,int pos);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * Fun : 给item添加监听事件
     * LZC
     * 2017/09/01
     */
    private void setItemListener(final MyViewHolder holder){
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getLayoutPosition();
                onItemClickListener.onitemclicklistener(view,pos);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int pos = holder.getLayoutPosition();
                onItemClickListener.onlongitemclicklistener(view,pos);
                return false;
            }
        });
    }

    public Serve_Details_Adapter(Activity activity, List<ServeDetail.RowsBean> tuijianList) {
        this.activity = activity;
        this.tuijianList = tuijianList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.doctor_introduce_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            setData(holder, position);
            setItemListener(holder);
        }
    }

    /**
     * Fun : 给item设置数据
     * LZC
     * 2017/09/01
     */
    private void setData(MyViewHolder holder, int position) {
        if (tuijianList != null){
            holder.doc_name.setText(tuijianList.get(position).getDoctor_Name());
            holder.de_name.setText(tuijianList.get(position).getDE_Name());
            holder.jt_name.setText(tuijianList.get(position).getJT_Name());
            holder.doctor_grjs.setText(tuijianList.get(position).getDoctor_GRJS());
            holder.relation_bj.setText(String.valueOf(tuijianList.get(position).getRelation_BJ()));
            Picasso.with(activity).load(MyApp.URL_SERVER + tuijianList.get(position).getImage_Url())
                    .transform(new CircleTransform())
                    .into(holder.doc_img);
        }
    }

    @Override
    public int getItemCount() {
        return tuijianList.size();
    }

    /**
     * Fun ：首页- 服务- （服务详情）推荐RecyclerView的占位符
     * LZC
     * 2017/09/01
     */
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView doc_img;
        private TextView doc_name;
        private TextView de_name;
        private TextView jt_name;
        private TextView doctor_grjs;
        private TextView relation_bj;

        public MyViewHolder(View itemView) {
            super(itemView);
            doc_img = itemView.findViewById(R.id.image_url);
            doc_name = itemView.findViewById(R.id.doctor_name);
            de_name = itemView.findViewById(R.id.de_name);
            jt_name = itemView.findViewById(R.id.jt_name);
            doctor_grjs = itemView.findViewById(R.id.doctor_grjs);
            relation_bj = itemView.findViewById(R.id.relation_BJ);
        }
    }
}

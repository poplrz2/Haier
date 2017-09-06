package com.ys.haier.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;
import com.ys.haier.R;
import com.ys.haier.data.News;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lzc on 2017-08-27.
 */

public class Home_NewsXRecycler_Adapter extends XRecyclerView.Adapter<Home_NewsXRecycler_Adapter.MyViewHolder> {

    /********************************************************************************/
    public static final int TYPE_FOOTER = 1;  //说明是带有Footer的
    public static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的
    private View mFooterView;
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

    /********************************************************************************/

    private List<News.RowsBean> newsList;
    private Activity activity;
    private String imgPath = "";

    public Home_NewsXRecycler_Adapter( Activity activity,List<News.RowsBean> newsList) {
        this.newsList = newsList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (mFooterView != null && viewType == TYPE_FOOTER){
            return new MyViewHolder(mFooterView);
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_item,parent,false);
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
    public void onBindViewHolder(final MyViewHolder holder, int position) {

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
     * Fun ：设置Item中的数据
     * LZC
     * 2017/09/01
     * @param holder
     * @param position
     */
    private void setData(MyViewHolder holder, int position) {
        holder.tv_news_Title.setText(newsList.get(position).getNews_Title());
        holder.tv_news_Handlers.setText(newsList.get(position).getHandlers() + "");
        holder.tv_news_Date.setText(newsList.get(position).getHandle_Time());
        holder.tv_news_Scan_num1.setText(newsList.get(position).getNull1());

        Log.e("Describe", newsList.get(position).getNews_Describe());
        String HtmlSource = newsList.get(position).getNews_Describe();
        String strHtml = HtmlSource.replaceAll("<[^>]*>", "");//获取HTML中的文字部分
        Log.e("html", strHtml);
        holder.tv_news_Content.setText(strHtml);


        Pattern imgpattern = Pattern.compile("<img[^>]*src=['\"]([^'\"]+)[^>]*>");//获取html中的<img <src="url">>中的url
        Matcher m = imgpattern.matcher(HtmlSource);
        while (m.find()) {
            imgPath = m.group(1);
        }
        Log.e("imgpath", imgPath);
        Picasso.with(activity)
                .load(imgPath)
                .error(R.drawable.default_binner_pic)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.iv_news_content_img);
    }

    @Override
    public int getItemCount() {
        if (mFooterView == null){
            return newsList.size();
        }else if (mFooterView != null){
            return newsList.size() + 1;
        }
        return newsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_news_content_img;
        private TextView tv_news_Title;
        private TextView tv_news_Handlers;
        private TextView tv_news_Date;
        private TextView tv_news_Scan_num1;
        private TextView tv_news_Content;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_news_Title = itemView.findViewById(R.id.news_Title);
            iv_news_content_img = itemView.findViewById(R.id.news_content_imge);
            tv_news_Handlers = itemView.findViewById(R.id.news_handlers);
            tv_news_Date = itemView.findViewById(R.id.news_handle_date);
            tv_news_Scan_num1 = itemView.findViewById(R.id.news_scan_num1);
            tv_news_Content = itemView.findViewById(R.id.tv_news_content);
        }
    }
}

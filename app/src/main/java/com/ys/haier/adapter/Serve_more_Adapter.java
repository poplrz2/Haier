package com.ys.haier.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;
import com.ys.haier.MyApp;
import com.ys.haier.R;
import com.ys.haier.data.Serve;

import java.util.List;

/**
 * Created by lzc on 2017-09-04.
 */

public class Serve_more_Adapter extends XRecyclerView.Adapter<Serve_more_Adapter.MyViewHolder>{

    private List<Serve.RowsBean> serveList;
    private Activity activity;

    public Serve_more_Adapter(Activity activity, List<Serve.RowsBean> serveList) {
        this.activity = activity;
        this.serveList = serveList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.home_serve_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.serve_Title.setText(serveList.get(position).getServe_Name());
        holder.serve_Title.setText(serveList.get(position).getServe_Name());
        holder.serve_describle.setText(serveList.get(position).getServe_Describe());
        holder.serve_contain_product.setText(serveList.get(position).getServe_Product());
        holder.serve_handlers.setText(serveList.get(position).getHandlers()+"");
        holder.serve_scan_num1.setText(serveList.get(position).getNull1());
        Picasso.with(activity).load(MyApp.URL_SERVER + serveList.get(position)
                .getImage_Url())
                .into(holder.serve_content_imge);
    }

    @Override
    public int getItemCount() {
        return serveList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView serve_content_imge;
        private TextView serve_Title;
        private TextView serve_describle;
        private TextView serve_contain_product;
        private TextView serve_handlers;
        private TextView serve_scan_num1;

        public MyViewHolder(final View itemView) {
            super(itemView);
            serve_content_imge = itemView.findViewById(R.id.serve_content_imge);

            serve_Title = itemView.findViewById(R.id.serve_Title);
            serve_describle = itemView.findViewById(R.id.serve_describle);
            serve_contain_product = itemView.findViewById(R.id.serve_contain_product);
            serve_handlers = itemView.findViewById(R.id.serve_handlers);
            serve_scan_num1 = itemView.findViewById(R.id.serve_scan_num1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onitemclicklistener.onItemClick(view,getLayoutPosition());
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    private OnItemClickListener onitemclicklistener;

    public void setOnitemclicklistener(OnItemClickListener onitemclicklistener) {
        this.onitemclicklistener = onitemclicklistener;
    }
}

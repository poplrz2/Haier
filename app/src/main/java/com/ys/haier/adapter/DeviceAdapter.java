package com.ys.haier.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ys.haier.R;

import java.util.ArrayList;

/**
 * Created by chen on 2017/9/6.
 */

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.MyViewHolder> {

    private ArrayList<String> list = new ArrayList<>();
    private Context context;

    public DeviceAdapter(Context context){
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position<getItemCount()-1? 0: 1;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if(viewType == 0){
            return new MyViewHolder(inflater.inflate(R.layout.item_device,parent,false));
        }else{
            return new MyViewHolder(inflater.inflate(R.layout.item_footer,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(getItemViewType(position) == 0){
            holder.tv_name.setText("1");
        }else{

        }

    }


    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }

    public class LoadMoreHolder extends RecyclerView.ViewHolder{


        public LoadMoreHolder(View itemView) {
            super(itemView);
        }
    }
}

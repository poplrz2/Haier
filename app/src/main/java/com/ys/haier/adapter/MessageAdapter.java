package com.ys.haier.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ys.haier.R;
import com.ys.haier.util.CircleTransform;

import java.util.ArrayList;

/**
 * Created by chen on 2017/9/6.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

    private ArrayList<String> list = new ArrayList<>();
    private Context context;

    public MessageAdapter(Context context){
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

    public void addData(){
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
    }

    @Override
    public int getItemViewType(int position) {
        return position<getItemCount()-1? 0: 1;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if(viewType == 0){
            return new MyViewHolder(inflater.inflate(R.layout.item_message,parent,false));
        }else{
            return new MyViewHolder(inflater.inflate(R.layout.item_footer,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(getItemViewType(position) == 0){
            Picasso.with(context)
                    .load("http://img4.imgtn.bdimg.com/it/u=3929251423,454148251&fm=27&gp=0.jpg")
                    .transform(new CircleTransform())
                    .error(R.drawable.default_binner_pic)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.iv_head_portrait);
        }else{

        }

    }


    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_head_portrait;
        TextView tv_department;
        TextView tv_abstract;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_head_portrait = itemView.findViewById(R.id.iv_head_portrait);
            tv_department = itemView.findViewById(R.id.tv_department);
            tv_abstract = itemView.findViewById(R.id.tv_abstract);
        }
    }

}

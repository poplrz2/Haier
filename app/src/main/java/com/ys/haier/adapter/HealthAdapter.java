package com.ys.haier.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ys.haier.HealthBreathActivity;
import com.ys.haier.HealthLiveActivity;
import com.ys.haier.HealthPregnantActivity;
import com.ys.haier.HealthSleepActivity;
import com.ys.haier.R;
import com.ys.haier.fragment.HealthFragment;
import com.ys.haier.util.CircleTransform;

import java.util.ArrayList;

/**
 * Created by chen on 2017/9/6.
 */

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.MyViewHolder> {

    private ArrayList<String> list = new ArrayList<>();
    private Context context;
    private int TAG;

    public HealthAdapter(Context context,int TAG){
        this.context = context;
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
        this.TAG = TAG;
    }

    @Override
    public int getItemViewType(int position) {
        return position<getItemCount()-1? TAG: 0;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if(viewType == 0){
            return new MyViewHolder(inflater.inflate(R.layout.item_footer,parent,false));
        }else{
            return new MyViewHolder(inflater.inflate(R.layout.item_health,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if(getItemViewType(position) == 0){

        }else{
            if(getItemViewType(position) == HealthFragment.TAG_SLEEP){//睡眠
                holder.imageView.setImageResource(R.drawable.sleep);
                holder.tv_report.setText("睡眠报告");
                setDrawableLeft(holder,R.drawable.icon_small_sleep,R.drawable.icon_small_sleep2,-1);
                setText(holder,"7.0","轻度",null);
            }else if(getItemViewType(position) == HealthFragment.TAG_BREATH){//呼吸
                holder.imageView.setImageResource(R.drawable.breathing);
                holder.tv_report.setText("呼吸报告");
                setDrawableLeft(holder,R.drawable.icon_small_sleep,R.drawable.icon_small_sleep2,-1);
                setText(holder,"7.0","轻度",null);
            }else if(getItemViewType(position) == HealthFragment.TAG_PREGNANT){//母婴
                holder.imageView.setImageResource(R.drawable.body);
                holder.tv_report.setText("母婴报告");
                setDrawableLeft(holder,R.drawable.icon_small_xinlv,R.drawable.icon_small_xybh,-1);
                setText(holder,"7.0","轻度",null);
            }else if(getItemViewType(position) == HealthFragment.TAG_LIVE){//康居
                holder.imageView.setImageResource(R.drawable.sogdiana);
                holder.tv_report.setText("康居报告");
                setDrawableLeft(holder,R.drawable.icon_small_live,R.drawable.icon_small_live2,R.drawable.icon_small_live3);
                setText(holder,"105/69mmhg","--mmol/l","--mmhl/l");
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = null;
                    if(TAG == HealthFragment.TAG_BREATH){
                        intent = new Intent(context,HealthBreathActivity.class);
                        context.startActivity(intent);
                    }else if(TAG == HealthFragment.TAG_SLEEP){
                        intent = new Intent(context,HealthSleepActivity.class);
                        context.startActivity(intent);
                    }else if(TAG == HealthFragment.TAG_PREGNANT){
                        intent = new Intent(context,HealthPregnantActivity.class);
                        context.startActivity(intent);
                    }else if(TAG == HealthFragment.TAG_LIVE){
                        intent = new Intent(context,HealthLiveActivity.class);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }

    private void setDrawableLeft(MyViewHolder holder,int id,int id2,int id3){
        Drawable drawable = context.getResources().getDrawable(id);
        Drawable drawable2 = context.getResources().getDrawable(id2);
        Drawable drawable3 = id3 == -1? null:context.getResources().getDrawable(id3);
        drawable.setBounds(0, 0, (int)(drawable.getMinimumWidth()*1.3),(int)(drawable.getMinimumHeight()*1.3));
        holder.tv_value.setCompoundDrawablePadding((int)(drawable.getMinimumHeight()*0.5));
        holder.tv_value.setCompoundDrawables(drawable,null,null,null);
        drawable2.setBounds(0, 0, (int)(drawable2.getMinimumWidth()*1.3),(int)(drawable2.getMinimumHeight()*1.3));
        holder.tv_value2.setCompoundDrawablePadding((int)(drawable2.getMinimumHeight()*0.5));
        holder.tv_value2.setCompoundDrawables(drawable2,null,null,null);
        if(drawable3 == null){
            holder.tv_value3.setVisibility(View.GONE);
        }else{
            drawable3.setBounds(0, 0, (int)(drawable3.getMinimumWidth()*1.2),(int)(drawable3.getMinimumHeight()*1.2));
            holder.tv_value3.setCompoundDrawablePadding((int)(drawable3.getMinimumHeight()*0.2));
            holder.tv_value3.setCompoundDrawables(drawable3,null,null,null);
        }
    }

    private void setText(MyViewHolder holder,String str,String str2,String str3){
        holder.tv_value.setText(str);
        holder.tv_value2.setText(str2);
        if(str3 == null){
            holder.tv_value3.setVisibility(View.GONE);
        }else{
            holder.tv_value3.setText(str3);
        }
    }


    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv_value;
        TextView tv_value2;
        TextView tv_value3;
        TextView tv_report;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tv_value = itemView.findViewById(R.id.tv_value);
            tv_value2 = itemView.findViewById(R.id.tv_value2);
            tv_value3 = itemView.findViewById(R.id.tv_value3);
            tv_report = itemView.findViewById(R.id.tv_report);
        }
    }

}

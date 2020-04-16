package com.luo.gridview01.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.luo.gridview01.R;
import com.luo.gridview01.bean.AppBean;

import java.util.List;

/**
 * Created by luo on 2020/4/16.
 * app的适配器
 */

public class AppAdapter extends BaseAdapter {

    private static final String TAG = "AppAdapter";

    private Context mContext;
    private List<AppBean> appList;
    private LayoutInflater mLayoutInflater;
    private int selectid = -1;

    public AppAdapter(Context mContext, List<AppBean> appList) {
        mLayoutInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.appList = appList;
    }

    @Override
    public int getCount() {
        return appList.size();
    }

    @Override
    public Object getItem(int position) {
        return appList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //用于setOnItemSelectedListener中调用，赋值当前选择的item的position
    public void notifyDataSetChanged(int id) {
        selectid = id;
        super.notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mLayoutInflater.inflate(R.layout.item_layout, null);
        TextView appName = (TextView) convertView.findViewById(R.id.item_app_name);
        ImageView appIcon = (ImageView) convertView.findViewById(R.id.item_app_icon);
        LinearLayout appLayout = (LinearLayout) convertView.findViewById(R.id.item_app_layout);
        AppBean appBean = appList.get(position);
        appName.setText(appBean.getName());
        appIcon.setImageResource(appBean.getIcon());
        appLayout.setBackground(null);
        if (selectid == position) {
            // 开启动画
            Log.d(TAG, "selectid = " + selectid);
            Animation testAnim = AnimationUtils.loadAnimation(mContext, R.anim.app_scale);
            appLayout.setBackgroundResource(R.drawable.app_item_bg);
            convertView.startAnimation(testAnim);
        }
        return convertView;
    }
}

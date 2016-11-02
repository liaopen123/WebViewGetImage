package com.example.liaopenghui.webviewgetimage;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import static android.R.id.list;


/**
 * Created by liaopenghui on 2016/11/2.
 */

public class MyPagerAdapter extends PagerAdapter {
    private final Context context;
    private final ArrayList<View> list;

    public MyPagerAdapter(Context context, ArrayList<View> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        Log.i("size",list.size()+"");
        return list.size();
    }




    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(list.get(position));
    }

    /**
     * 预加载
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ((ViewPager) container).addView(list.get(position));
        return list.get(position);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}

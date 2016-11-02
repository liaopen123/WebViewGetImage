package com.example.liaopenghui.webviewgetimage;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ShowImageActivity extends Activity {

    private static final String TAG = "ShowImageActivity";
public ArrayList<View> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        Bundle b=this.getIntent().getExtras();
        ArrayList<String> array = b.getStringArrayList("array");
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_images);

        for(int i=0; i<array.size();i++){
            View view = LayoutInflater.from(this).inflate(R.layout.item_image, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
//            ImageView imageView = new ImageView(this);
//            imageView.setPadding(5, 5, 5, 5);
//            imageView.setBackgroundColor(Color.RED);
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(200,200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Log.i(TAG,"array.get(i)"+array.get(i));
            Glide.with(this).load(array.get(i)).placeholder(getResources().getDrawable(R.mipmap.ic_launcher)).into(imageView);
            views.add(view);
        }
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this, views);

        viewPager.setAdapter(myPagerAdapter);
        myPagerAdapter.notifyDataSetChanged();
    }
}

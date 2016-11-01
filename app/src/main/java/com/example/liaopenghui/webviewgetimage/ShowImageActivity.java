package com.example.liaopenghui.webviewgetimage;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ShowImageActivity extends Activity {

    private static final String TAG = "ShowImageActivity";
    private String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        this.imagePath = getIntent().getStringExtra("img");
        ImageView imageView = (ImageView) findViewById(R.id.iv_show);
        Log.e(TAG,"imagePath:"+imagePath);
        Glide.with(this).load(imagePath).into(imageView);

    }
}

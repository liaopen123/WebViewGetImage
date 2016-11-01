package com.example.liaopenghui.webviewgetimage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by liaopenghui on 2016/11/1.
 */

public class JavascriptInterface {
    private final Context context;
    private String TAG = "JavascriptInterface";

    public JavascriptInterface(Context context) {
        this.context = context;
    }
    @android.webkit.JavascriptInterface
    public void openImage(String image){
        Log.i(TAG,"openImage"+image);
        Intent intent = new Intent(context,ShowImageActivity.class);
        intent.putExtra("img",image);
        context.startActivity(intent);
    }
}

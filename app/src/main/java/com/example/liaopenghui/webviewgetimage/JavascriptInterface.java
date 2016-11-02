package com.example.liaopenghui.webviewgetimage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liaopenghui on 2016/11/1.
 */

public class JavascriptInterface {

    private final Context context;
    private final OnGetImageListListner listner;
    private String TAG = "JavascriptInterface";
    private ArrayList<String> imageSrc;

    public JavascriptInterface(Context context,OnGetImageListListner listner) {
        this.context = context;
        this.listner = listner;

    }
    @android.webkit.JavascriptInterface
    public void openImage(String image){
        Log.i(TAG,"openImage"+image);
        Intent intent = new Intent(context,ShowImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("array",imageSrc);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @android.webkit.JavascriptInterface
    public void showSource(String html){
        Log.i(TAG,"html"+html);

       imageSrc = GetImageUtils.getImageSrc(GetImageUtils.getImageUrl(html));
        if(null!=listner){
            listner.getImageList(imageSrc);
        }
        for(String s :imageSrc){
            Log.i(TAG,s);
        }

    }
}

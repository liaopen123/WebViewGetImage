package com.example.liaopenghui.webviewgetimage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private WebView webView;

    @SuppressLint("JavascriptInterface")
    @android.webkit.JavascriptInterface
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         webView = (WebView) findViewById(R.id.web_view);
        //打开JS交互
        webView.getSettings().setJavaScriptEnabled(true);
        //
        webView.loadUrl("http://blog.csdn.net/wangtingshuai/article/details/8635787");
        //添加JS交互接口类，并起名imagelistener
        webView.addJavascriptInterface(new JavascriptInterface(this),"imagelistner");
        webView.setWebViewClient(new MyWebViewClient(new onPagerFinishListner() {
            @Override
            public void onPagerFinish() {
                addImageClickListner();
            }
        }));
    }


    // 注入js函数监听

    private void addImageClickListner() {
        // 这段js函数的功能就是，遍历所有的img几点，并添加onclick函数，函数的功能是在图片点击的时候调用本地java接口并传递url过去
        Log.d(TAG,"JS注入");
        webView.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName(\"img\"); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "    objs[i].onclick=function()  " +
                "    {  "
                + "        window.imagelistner.openImage(this.src);  " +
                "    }  " +
                "}" +
                "})()");
    }



}

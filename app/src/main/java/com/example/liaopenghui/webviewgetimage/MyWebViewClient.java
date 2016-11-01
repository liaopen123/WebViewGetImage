package com.example.liaopenghui.webviewgetimage;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by liaopenghui on 2016/11/1.
 */

public class MyWebViewClient extends WebViewClient {
    private onPagerFinishListner onPagerFinishListner;

    public MyWebViewClient(onPagerFinishListner onPagerFinishListner) {
        this.onPagerFinishListner = onPagerFinishListner;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return super.shouldOverrideUrlLoading(view, url);

    }

    @Override
    public void onPageFinished(WebView view, String url) {

        view.getSettings().setJavaScriptEnabled(true);

        super.onPageFinished(view, url);
        // html加载完成之后，添加监听图片的点击js函数
        if(onPagerFinishListner!=null)
            onPagerFinishListner.onPagerFinish();

    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
      //  view.getSettings().setJavaScriptEnabled(true);

    }
}

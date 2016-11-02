package com.example.liaopenghui.webviewgetimage;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liaopenghui on 2016/11/2.
 */

public class GetImageUtils {

    // 地址
    private static final String URL = "http://www.csdn.net";
    // 编码
    private static final String ECODING = "UTF-8";
    // 获取img标签正则
    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
    // 获取src路径的正则
    private static final String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)";
    private static final String TAG = "GetImageUtils";

    /***
     * 获取ImageUrl的标签
     *
     * @param HTML
     * @return
     */
    public static List<String> getImageUrl(String HTML) {
        Matcher matcher = Pattern.compile(IMGURL_REG).matcher(HTML);
        List<String> listImgUrl = new ArrayList<String>();
        while (matcher.find()) {
            Log.i(TAG,matcher.group());
            listImgUrl.add(matcher.group());
        }
        return listImgUrl;
    }


    /***
     * 获取ImageSrc地址
     *
     * @param listImageUrl
     * @return
     */
    public static ArrayList<String> getImageSrc(List<String> listImageUrl) {
        ArrayList<String> listImgSrc = new ArrayList<String>();
        for (String image : listImageUrl) {
            Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(image);
            while (matcher.find()) {
                listImgSrc.add(matcher.group().substring(0, matcher.group().length() - 1));
            }
        }
        return listImgSrc;
    }

}
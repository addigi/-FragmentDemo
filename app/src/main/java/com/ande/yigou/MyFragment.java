package com.ande.yigou;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.*;


/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment extends Fragment {

    private String url=null;
    private Activity pm=null;
    public MyFragment(){}

    public MyFragment(Activity pm,String url)
    {
        this.url = url;
        this.pm=pm;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        WebView webView = (WebView) view.findViewById(R.id.html_content);

        TaobaoWebViewClient taobao=new TaobaoWebViewClient(pm);
        webView.setWebViewClient(taobao);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        webView.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        webView.getSettings().setSupportZoom(true);//是否可以缩放，默认true
        webView.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        webView.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        webView.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        webView.getSettings().setAppCacheEnabled(true);//是否使用缓存
        webView.getSettings().setDomStorageEnabled(true);//DOM Storage
        webView.loadUrl(url);          //调用loadUrl方法为WebView加入链接
        //setContentView(webView);
        return view;
    }
}

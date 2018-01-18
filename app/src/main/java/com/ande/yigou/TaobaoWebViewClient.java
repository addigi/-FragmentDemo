package com.ande.yigou;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class TaobaoWebViewClient extends WebViewClient {

    private Activity activity;
    public  TaobaoWebViewClient(Activity activity)
    {
        this.activity = activity;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        return openApp(url);
    }

    //判断app是否安装
    private boolean isInstall(Intent intent) {
        // 用于管理安装的apk和未安装的apk
        //return activity.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).size() > 0;
        return  false;
    }
    //打开app
    private boolean openApp(String url) {
        if (url.isEmpty()) return false;
        try {
            if (!url.startsWith("http") && !url.startsWith("https") && !url.startsWith("ftp"))
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                if (isInstall(intent))
                {
                    activity.startActivity(intent);
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}

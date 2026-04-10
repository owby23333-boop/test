package com.amgcyo.cuttadon.view.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: compiled from: MkWebTools.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static boolean a(Activity activity, String str) {
        boolean z2 = false;
        if (str.startsWith("http")) {
            if (!str.contains(com.anythink.china.common.a.a.f6395g)) {
                return false;
            }
            startActivity(activity, str);
            return true;
        }
        if (!str.startsWith("tbopen:") && !str.startsWith("zhihu:") && !str.startsWith("vipshop:") && !str.startsWith("youku:") && !str.startsWith("uclink:") && !str.startsWith("ucbrowser:") && !str.startsWith("newsapp:") && !str.startsWith("sinaweibo:") && !str.startsWith("suning:") && !str.startsWith("pinduoduo:") && !str.startsWith("baiduboxapp:") && !str.startsWith("qtt:")) {
            z2 = true;
        }
        if (z2) {
            startActivity(activity, str);
        }
        return z2;
    }

    public static void startActivity(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Toast.makeText(context, "正在使用系统浏览器打开", 0).show();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Bitmap a(WebView webView) {
        if (webView == null) {
            return null;
        }
        int measuredWidth = webView.getMeasuredWidth();
        int measuredHeight = webView.getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            try {
                webView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                webView.layout(0, 0, measuredWidth, measuredHeight);
                webView.setDrawingCacheEnabled(true);
                webView.buildDrawingCache();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawBitmap(bitmapCreateBitmap, 0.0f, measuredHeight, new Paint());
                webView.draw(canvas);
                return bitmapCreateBitmap;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void a(Context context, String str) {
        startActivity(context, str);
    }
}

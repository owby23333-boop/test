package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.ImageView;
import java.util.HashSet;

/* JADX INFO: loaded from: classes10.dex */
public class j {
    private static final boolean bf;
    private static int d;
    private static final boolean e;
    private static int ga;
    private static final HashSet<String> p;
    private static int tg;
    private static final HashSet<String> v;
    private static Handler vn;

    static {
        e = com.bytedance.sdk.openadsdk.core.a.f.ga();
        bf = e();
        d = -1;
        tg = -1;
        ga = -1;
        vn = null;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        p = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        v = hashSet2;
    }

    public static void e(Context context, WebView webView) {
        if (context == null || webView == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            try {
                webView.loadUrl("about:blank");
                if (ga > 0) {
                    View rootView = webView.getRootView();
                    if (rootView instanceof ViewGroup) {
                        View childAt = ((ViewGroup) rootView).getChildAt(0);
                        childAt.setDrawingCacheEnabled(true);
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                        childAt.setDrawingCacheEnabled(false);
                        ImageView imageView = new ImageView(activity);
                        imageView.setImageBitmap(bitmapCreateBitmap);
                        imageView.setVisibility(0);
                        ((ViewGroup) rootView).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static boolean e() {
        return e;
    }

    public static void e(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.setWebChromeClient(null);
        webView.setWebViewClient(null);
        ViewParent parent = webView.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(webView);
        }
        webView.removeAllViews();
        try {
            webView.destroy();
        } catch (Throwable unused) {
        }
    }
}

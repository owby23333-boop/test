package com.anythink.expressad.atsignalcommon.base;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BaseWebView extends WebView {
    private View.OnTouchListener a;
    private View.OnTouchListener b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Context f8262e;
    public long lastTouchTime;
    public b mWebViewClient;

    public BaseWebView(Context context) {
        super(context);
        this.lastTouchTime = 0L;
        this.a = new View.OnTouchListener() { // from class: com.anythink.expressad.atsignalcommon.base.BaseWebView.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    BaseWebView.this.lastTouchTime = System.currentTimeMillis();
                }
                if (BaseWebView.this.b != null) {
                    return BaseWebView.this.b.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.f8262e = context;
        a();
    }

    public b getBaseWebViewClient() {
        return this.mWebViewClient;
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(@Nullable String str, String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        super.loadDataWithBaseURL(a(str), str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(a(str));
    }

    @Override // android.webkit.WebView
    public void reload() {
        super.reload();
    }

    public void setFilter(a aVar) {
        b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.b = onTouchListener;
    }

    public void setTransparent() {
        setLayerType(1, null);
        setBackgroundColor(0);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof b) {
            this.mWebViewClient = (b) webViewClient;
        }
    }

    protected void a() {
        if (this.mWebViewClient == null) {
            this.mWebViewClient = new b();
            setWebViewClient(this.mWebViewClient);
        }
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        requestFocus();
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                settings.setSafeBrowsingEnabled(false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                settings.setAllowUniversalAccessFromFileURLs(true);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        settings.setDatabaseEnabled(true);
        String path = this.f8262e.getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        try {
            Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, Boolean.FALSE);
        } catch (Exception unused) {
        }
        super.setOnTouchListener(this.a);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(a(str), map);
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastTouchTime = 0L;
        this.a = new View.OnTouchListener() { // from class: com.anythink.expressad.atsignalcommon.base.BaseWebView.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    BaseWebView.this.lastTouchTime = System.currentTimeMillis();
                }
                if (BaseWebView.this.b != null) {
                    return BaseWebView.this.b.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.f8262e = context;
        a();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.lastTouchTime = 0L;
        this.a = new View.OnTouchListener() { // from class: com.anythink.expressad.atsignalcommon.base.BaseWebView.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    BaseWebView.this.lastTouchTime = System.currentTimeMillis();
                }
                if (BaseWebView.this.b != null) {
                    return BaseWebView.this.b.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.f8262e = context;
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L33
            java.lang.String r0 = "../"
            boolean r0 = r5.contains(r0)
            r2 = 1
            if (r0 == 0) goto L12
        L10:
            r1 = 1
            goto L33
        L12:
            java.lang.String r0 = "file"
            boolean r0 = r5.startsWith(r0)
            if (r0 == 0) goto L33
            android.net.Uri r0 = android.net.Uri.parse(r5)
            java.lang.String r0 = r0.getPath()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L10
            java.lang.String r3 = com.anythink.expressad.foundation.h.r.a()
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto L33
            goto L10
        L33:
            if (r1 == 0) goto L40
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r0 = "illegal URL: "
            r0.concat(r5)
            java.lang.String r5 = "about:blank"
        L40:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.atsignalcommon.base.BaseWebView.a(java.lang.String):java.lang.String");
    }
}

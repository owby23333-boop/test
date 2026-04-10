package com.tencent.smtt.sdk;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class WebView extends FrameLayout implements View.OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    volatile int a;
    private final String b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IX5WebViewBase f18968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f18969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WebSettings f18970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f18971i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f18972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f18973l;
    public WebViewCallbackClient mWebViewCallbackClient;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private WebViewClient f18974n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private WebChromeClient f18975o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f18976q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f18977r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f18978s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f18979t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f18980u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Object f18981x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View.OnLongClickListener f18982y;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lock f18960c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static OutputStream f18961d = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Context f18962j = null;
    public static boolean mWebViewCreated = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Method f18963m = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f18964p = null;
    public static boolean mSysWebviewCreated = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static Paint f18965v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static boolean f18966w = true;
    public static int NIGHT_MODE_ALPHA = TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED;

    public static class HitTestResult {

        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;

        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private IX5WebViewBase.HitTestResult a;
        private WebView.HitTestResult b;

        public HitTestResult() {
            this.b = null;
            this.a = null;
            this.b = null;
        }

        public HitTestResult(WebView.HitTestResult hitTestResult) {
            this.b = null;
            this.a = null;
            this.b = hitTestResult;
        }

        public HitTestResult(IX5WebViewBase.HitTestResult hitTestResult) {
            this.b = null;
            this.a = hitTestResult;
            this.b = null;
        }

        public String getExtra() {
            IX5WebViewBase.HitTestResult hitTestResult = this.a;
            if (hitTestResult != null) {
                return hitTestResult.getExtra();
            }
            WebView.HitTestResult hitTestResult2 = this.b;
            return hitTestResult2 != null ? hitTestResult2.getExtra() : "";
        }

        public int getType() {
            IX5WebViewBase.HitTestResult hitTestResult = this.a;
            if (hitTestResult != null) {
                return hitTestResult.getType();
            }
            WebView.HitTestResult hitTestResult2 = this.b;
            if (hitTestResult2 != null) {
                return hitTestResult2.getType();
            }
            return 0;
        }
    }

    @Deprecated
    public interface PictureListener {
        @Deprecated
        void onNewPicture(WebView webView, Picture picture);
    }

    public class WebViewTransport {
        private WebView b;

        public WebViewTransport() {
        }

        public synchronized WebView getWebView() {
            return this.b;
        }

        public synchronized void setWebView(WebView webView) {
            this.b = webView;
        }
    }

    private class a extends android.webkit.WebView {
        public a(WebView webView, Context context) {
            this(context, null);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(WebView.this.d(context), attributeSet);
            if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
                return;
            }
            CookieSyncManager.createInstance(WebView.this.f18971i).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new h());
                WebView.mSysWebviewCreated = true;
            } catch (Exception unused) {
            }
        }

        public void a() {
            super.computeScroll();
        }

        public void a(int i2, int i3, int i4, int i5) {
            super.onScrollChanged(i2, i3, i4, i5);
        }

        @TargetApi(9)
        public void a(int i2, int i3, boolean z2, boolean z3) {
            if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i2, i3, z2, z3);
            }
        }

        @TargetApi(9)
        public boolean a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
            if (Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z2);
            }
            return false;
        }

        public boolean a(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public boolean b(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean c(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        public void computeScroll() {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.computeScroll(this);
            } else {
                super.computeScroll();
            }
        }

        @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (WebView.f18966w || WebView.f18965v == null) {
                    return;
                }
                canvas.save();
                canvas.drawPaint(WebView.f18965v);
                canvas.restore();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            return webViewCallbackClient != null ? webViewCallbackClient.dispatchTouchEvent(motionEvent, this) : super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView
        public android.webkit.WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.invalidate();
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            return webViewCallbackClient != null ? webViewCallbackClient.onInterceptTouchEvent(motionEvent, this) : super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        @TargetApi(9)
        public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onOverScrolled(i2, i3, z2, z3, this);
            } else if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i2, i3, z2, z3);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        protected void onScrollChanged(int i2, int i3, int i4, int i5) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onScrollChanged(i2, i3, i4, i5, this);
            } else {
                super.onScrollChanged(i2, i3, i4, i5);
                WebView.this.onScrollChanged(i2, i3, i4, i5);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.onTouchEvent(motionEvent, this);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }

        @Override // android.view.View
        @TargetApi(9)
        public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z2, this);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z2);
            }
            return false;
        }

        @Override // android.webkit.WebView, android.view.View
        public void setOverScrollMode(int i2) {
            try {
                super.setOverScrollMode(i2);
            } catch (Exception unused) {
            }
        }
    }

    public WebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, false);
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i2, Map<String, Object> map, boolean z2) {
        super(context, attributeSet, i2);
        this.b = "WebView";
        this.f18967e = false;
        this.f18970h = null;
        this.f18971i = null;
        this.a = 0;
        this.f18972k = false;
        this.f18973l = false;
        this.f18974n = null;
        this.f18975o = null;
        this.f18976q = 1;
        this.f18977r = 2;
        this.f18978s = 3;
        this.f18979t = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.f18980u = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.f18981x = null;
        this.f18982y = null;
        mWebViewCreated = true;
        com.tencent.smtt.utils.s.a("0");
        if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
            this.f18971i = context;
            this.f18968f = null;
            this.f18967e = false;
            QbSdk.a(context, "failed to createTBSWebview!");
            this.f18969g = new a(context, attributeSet);
            CookieSyncManager.createInstance(this.f18971i).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new h());
                mSysWebviewCreated = true;
            } catch (Exception unused) {
            }
            CookieManager.getInstance().a();
            this.f18969g.setFocusableInTouchMode(true);
            addView(this.f18969g, new FrameLayout.LayoutParams(-1, -1));
            TbsLog.i("WebView", "SystemWebView Created Success! #3, SysWebViewForcedByOuter.");
            TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
            return;
        }
        if (TbsShareManager.isThirdPartyApp(context)) {
            TbsLog.setWriteLogJIT(true);
            TbsLog.i("webview", "new WebView, thread is " + Thread.currentThread() + "stack: " + Log.getStackTraceString(new Throwable("new WebView Detect")));
        } else {
            TbsLog.setWriteLogJIT(false);
        }
        TbsLog.initIfNeed(context);
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        c(context);
        this.f18971i = context;
        if (context != null) {
            f18962j = context.getApplicationContext();
        }
        if (!this.f18967e || QbSdk.a) {
            this.f18968f = null;
            if (TbsShareManager.isThirdPartyApp(this.f18971i)) {
                this.f18969g = new a(context, attributeSet);
            } else {
                this.f18969g = new a(this, context);
            }
            TbsLog.i("WebView", "SystemWebView Created Success! #2");
            CookieManager.getInstance().a();
            this.f18969g.setFocusableInTouchMode(true);
            addView(this.f18969g, new FrameLayout.LayoutParams(-1, -1));
            setDownloadListener(null);
            TbsLog.writeLogToDisk();
            o.a(context);
        } else {
            this.f18968f = w.a().a(true).a(context);
            IX5WebViewBase iX5WebViewBase = this.f18968f;
            if (iX5WebViewBase == null || iX5WebViewBase.getView() == null) {
                TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
                this.f18968f = null;
                this.f18967e = false;
                QbSdk.a(context, "failed to createTBSWebview!");
                c(context);
                if (TbsShareManager.isThirdPartyApp(this.f18971i)) {
                    this.f18969g = new a(context, attributeSet);
                } else {
                    this.f18969g = new a(this, context);
                }
                TbsLog.i("WebView", "SystemWebView Created Success! #1");
                CookieManager.getInstance().a();
                this.f18969g.setFocusableInTouchMode(true);
                addView(this.f18969g, new FrameLayout.LayoutParams(-1, -1));
                try {
                    if (Build.VERSION.SDK_INT >= 11) {
                        removeJavascriptInterface("searchBoxJavaBridge_");
                        removeJavascriptInterface("accessibility");
                        removeJavascriptInterface("accessibilityTraversal");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                TbsLog.writeLogToDisk();
                o.a(context);
                return;
            }
            TbsLog.i("WebView", "X5 WebView Created Success!!");
            this.f18968f.getView().setFocusableInTouchMode(true);
            a(attributeSet);
            addView(this.f18968f.getView(), new FrameLayout.LayoutParams(-1, -1));
            this.f18968f.setDownloadListener(new b(this, null, this.f18967e));
            this.f18968f.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(w.a().a(true).k()) { // from class: com.tencent.smtt.sdk.WebView.1
                @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                public void invalidate() {
                }

                @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                public void onScrollChanged(int i3, int i4, int i5, int i6) {
                    super.onScrollChanged(i3, i4, i5, i6);
                    WebView.this.onScrollChanged(i5, i6, i3, i4);
                }
            });
        }
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if ((TbsConfig.APP_QQ.equals(this.f18971i.getApplicationInfo().packageName) || "com.tencent.mm".equals(this.f18971i.getApplicationInfo().packageName)) && g.a(true).i() && Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        if (this.f18968f != null) {
            TbsLog.writeLogToDisk();
        }
    }

    @Deprecated
    public WebView(Context context, AttributeSet attributeSet, int i2, boolean z2) {
        this(context, attributeSet, i2, null, z2);
    }

    public WebView(Context context, boolean z2) {
        super(context);
        this.b = "WebView";
        this.f18967e = false;
        this.f18970h = null;
        this.f18971i = null;
        this.a = 0;
        this.f18972k = false;
        this.f18973l = false;
        this.f18974n = null;
        this.f18975o = null;
        this.f18976q = 1;
        this.f18977r = 2;
        this.f18978s = 3;
        this.f18979t = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.f18980u = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.f18981x = null;
        this.f18982y = null;
    }

    private void a(AttributeSet attributeSet) {
        View view;
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    if (attributeSet.getAttributeName(i2).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(R.attr.scrollbars);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i2, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f18968f.getView().setVerticalScrollBarEnabled(false);
                            view = this.f18968f.getView();
                        } else if (attributeIntValue == intArray[2]) {
                            this.f18968f.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            view = this.f18968f.getView();
                        }
                        view.setHorizontalScrollBarEnabled(false);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) throws Throwable {
        boolean zIsX5CoreSandboxMode;
        com.tencent.smtt.utils.s.b("old03");
        if (!this.f18972k && this.a != 0) {
            com.tencent.smtt.utils.s.b("old04");
            this.f18972k = true;
            String string = "";
            String string2 = "";
            String string3 = "";
            if (this.f18967e) {
                com.tencent.smtt.utils.s.b("old05");
                Bundle sdkQBStatisticsInfo = this.f18968f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    string = sdkQBStatisticsInfo.getString("guid");
                    string2 = sdkQBStatisticsInfo.getString("qua2");
                    string3 = sdkQBStatisticsInfo.getString("lc");
                }
                com.tencent.smtt.utils.s.b("old06");
            }
            String str = string;
            String str2 = string2;
            String str3 = string3;
            if (TbsConfig.APP_QZONE.equals(this.f18971i.getApplicationInfo().packageName)) {
                int iE = e(this.f18971i);
                if (iE == -1) {
                    iE = this.a;
                }
                this.a = iE;
                f(this.f18971i);
            }
            try {
                com.tencent.smtt.utils.s.b("old07");
                zIsX5CoreSandboxMode = this.f18968f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (Throwable th) {
                TbsLog.w("tbsWebviewDestroy", "exception: " + th);
                zIsX5CoreSandboxMode = false;
            }
            com.tencent.smtt.utils.s.b("old08");
            com.tencent.smtt.sdk.stat.b.a(this.f18971i, str, str2, str3, this.a, this.f18967e, i(), zIsX5CoreSandboxMode);
            com.tencent.smtt.utils.s.b("old09");
            this.a = 0;
            this.f18972k = false;
        }
        com.tencent.smtt.utils.s.b("old10");
        if (this.f18967e) {
            com.tencent.smtt.utils.s.b("old18");
            if (z2) {
                this.f18968f.destroy();
            }
            com.tencent.smtt.utils.s.b("old19");
        } else {
            try {
                com.tencent.smtt.utils.s.b("old11");
                Class<?> cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", android.webkit.WebView.class);
                method.setAccessible(true);
                Object objInvoke = method.invoke(null, this.f18969g);
                if (objInvoke != null) {
                    com.tencent.smtt.utils.s.b("old12");
                    Field declaredField = cls.getDeclaredField("mListBoxDialog");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(objInvoke);
                    if (obj != null) {
                        com.tencent.smtt.utils.s.b("old13");
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class<?> cls2 = Class.forName("android.app.Dialog");
                        Field declaredField2 = cls2.getDeclaredField("CANCEL");
                        declaredField2.setAccessible(true);
                        int iIntValue = ((Integer) declaredField2.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(iIntValue);
                    }
                }
            } catch (Exception unused) {
            }
            com.tencent.smtt.utils.s.b("old14");
            if (z2) {
                this.f18969g.destroy();
            }
            try {
                com.tencent.smtt.utils.s.b("old15");
                TbsLog.i("sdkreport", "webview.tbsWebviewDestroy mQQMusicCrashFix is " + this.f18973l);
                if (this.f18973l) {
                    return;
                }
                Field declaredField4 = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField4.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField4.get(null);
                if (componentCallbacks != null) {
                    com.tencent.smtt.utils.s.b("old16");
                    declaredField4.set(null, null);
                    Field declaredField5 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField5.setAccessible(true);
                    Object obj2 = declaredField5.get(null);
                    if (obj2 != null) {
                        List list = (List) obj2;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
                com.tencent.smtt.utils.s.b("old17");
            } catch (Exception unused2) {
            }
        }
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.b());
    }

    private boolean a(View view) {
        Object objA;
        Context context = this.f18971i;
        if ((context == null || getTbsCoreVersion(context) <= 36200) && (objA = com.tencent.smtt.utils.j.a(this.f18981x, "onLongClick", (Class<?>[]) new Class[]{View.class}, view)) != null) {
            return ((Boolean) objA).booleanValue();
        }
        return false;
    }

    private boolean a(WebChromeClient webChromeClient) {
        if (webChromeClient == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (Class<?> superclass = webChromeClient.getClass(); superclass != WebChromeClient.class && (!z2 || !z3); superclass = superclass.getSuperclass()) {
            if (!z2) {
                try {
                    superclass.getDeclaredMethod("onShowCustomView", View.class, IX5WebChromeClient.CustomViewCallback.class);
                    z2 = true;
                } catch (NoSuchMethodException unused) {
                }
            }
            if (!z3) {
                try {
                    superclass.getDeclaredMethod("onHideCustomView", new Class[0]);
                    z3 = true;
                } catch (NoSuchMethodException unused2) {
                }
            }
        }
        return z2 && z3;
    }

    private boolean b(Context context) {
        try {
            return context.getPackageName().indexOf(TbsConfig.APP_QQ) >= 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    static void c() {
        try {
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.WebView.8
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    if (WebView.f18962j == null) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
                        return;
                    }
                    g gVarA = g.a(true);
                    if (g.b) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
                        return;
                    }
                    m mVarA = m.a(WebView.f18962j);
                    int iC = mVarA.c();
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + iC);
                    if (iC == 2) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
                        gVarA.a(String.valueOf(mVarA.b()));
                        gVarA.b(true);
                        return;
                    }
                    int iB = mVarA.b("copy_status");
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + iB);
                    if (iB == 1) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
                        gVarA.a(String.valueOf(mVarA.c("copy_core_ver")));
                        gVarA.b(true);
                    } else {
                        if (w.a().b()) {
                            return;
                        }
                        if (iC == 3 || iB == 3) {
                            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                            gVarA.a(String.valueOf(g.d()));
                            gVarA.b(true);
                        }
                    }
                }
            }).start();
        } catch (Throwable th) {
            TbsLog.e("webview", "updateRebootStatus excpetion: " + th);
        }
    }

    private void c(Context context) {
        if (QbSdk.f18844i && TbsShareManager.isThirdPartyApp(context)) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
        }
        w wVarA = w.a();
        wVarA.a(context);
        this.f18967e = wVarA.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context d(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 21 || i2 > 22) ? context : context.createConfigurationContext(new Configuration());
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (w.a().b()) {
            return;
        }
        com.tencent.smtt.utils.j.a("android.webkit.WebView", "disablePlatformNotifications");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.FileInputStream] */
    public int e(Context context) throws Throwable {
        FileLock fileLockA;
        StringBuilder sb;
        File file;
        FileOutputStream fileOutputStreamB = FileUtil.b(context, true, "tbslock.txt");
        if (fileOutputStreamB == null || (fileLockA = FileUtil.a(context, fileOutputStreamB)) == null) {
            return -1;
        }
        if (!f18960c.tryLock()) {
            FileUtil.a(fileLockA, fileOutputStreamB);
            return -1;
        }
        ?? r5 = 0;
        r5 = 0;
        FileInputStream fileInputStream = null;
        try {
            try {
                file = new File(QbSdk.getTbsFolderDir(context) + File.separator + "core_private", "pv.db");
            } catch (Exception e2) {
                e = e2;
            }
            if (file.exists()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                    String str = "PV";
                    String property = properties.getProperty("PV");
                    if (property != null) {
                        int i2 = Integer.parseInt(property);
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e3.toString());
                        }
                        f18960c.unlock();
                        FileUtil.a(fileLockA, fileOutputStreamB);
                        return i2;
                    }
                    try {
                        fileInputStream2.close();
                        r5 = str;
                    } catch (IOException e4) {
                        e = e4;
                        sb = new StringBuilder();
                        sb.append("TbsInstaller--getTbsCorePV IOException=");
                        sb.append(e.toString());
                        TbsLog.e("getTbsCorePV", sb.toString());
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileInputStream = fileInputStream2;
                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                    r5 = fileInputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            r5 = fileInputStream;
                        } catch (IOException e6) {
                            e = e6;
                            sb = new StringBuilder();
                            sb.append("TbsInstaller--getTbsCorePV IOException=");
                            sb.append(e.toString());
                            TbsLog.e("getTbsCorePV", sb.toString());
                        }
                    }
                    f18960c.unlock();
                    FileUtil.a(fileLockA, fileOutputStreamB);
                    return -1;
                } catch (Throwable th) {
                    th = th;
                    r5 = fileInputStream2;
                    if (r5 != 0) {
                        try {
                            r5.close();
                        } catch (IOException e7) {
                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e7.toString());
                        }
                    }
                    f18960c.unlock();
                    FileUtil.a(fileLockA, fileOutputStreamB);
                    throw th;
                }
                sb.append("TbsInstaller--getTbsCorePV IOException=");
                sb.append(e.toString());
                TbsLog.e("getTbsCorePV", sb.toString());
                f18960c.unlock();
                FileUtil.a(fileLockA, fileOutputStreamB);
                return -1;
            }
            f18960c.unlock();
            FileUtil.a(fileLockA, fileOutputStreamB);
            return -1;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (w.a().b()) {
            return;
        }
        com.tencent.smtt.utils.j.a("android.webkit.WebView", "enablePlatformNotifications");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context) {
        try {
            File file = new File(QbSdk.getTbsFolderDir(context) + File.separator + "core_private", "pv.db");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e2.toString());
        }
    }

    @Deprecated
    public static String findAddress(String str) {
        if (w.a().b()) {
            return null;
        }
        return android.webkit.WebView.findAddress(str);
    }

    private void g() {
        String str;
        synchronized (WebView.class) {
            com.tencent.smtt.utils.s.b("new01");
            if (!this.f18972k && this.a != 0) {
                j();
            }
            com.tencent.smtt.utils.s.b("new02");
        }
        if (this.f18967e) {
            com.tencent.smtt.utils.s.b("new08");
            this.f18968f.destroy();
            str = "new09";
        } else {
            com.tencent.smtt.utils.s.b("new03");
            this.f18969g.destroy();
            com.tencent.smtt.utils.s.b("new04");
            try {
                TbsLog.i("sdkreport", "webview.destroyImplNow mQQMusicCrashFix is " + this.f18973l);
                if (this.f18973l) {
                    return;
                }
                Field declaredField = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField.get(null);
                com.tencent.smtt.utils.s.b("new05");
                if (componentCallbacks != null) {
                    declaredField.set(null, null);
                    Field declaredField2 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField2.setAccessible(true);
                    Object obj = declaredField2.get(null);
                    if (obj != null) {
                        List list = (List) obj;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
                com.tencent.smtt.utils.s.b("new06");
                return;
            } catch (Exception unused) {
                str = "new07";
            }
        }
        com.tencent.smtt.utils.s.b(str);
    }

    public static String getCrashExtraCacheInfo(Context context) {
        Map<String, Object> map;
        if (context == null) {
            return "";
        }
        String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:44226;";
        StringBuilder sb = new StringBuilder();
        sb.append(g.a(true).f());
        sb.append("\n");
        sb.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && (map = QbSdk.f18850o) != null && map.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.f18850o.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            String str2 = "weapp_id:" + QbSdk.f18850o.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";" + TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY + ":" + QbSdk.f18850o.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            sb.append("\n");
            sb.append(str2);
        }
        return sb.length() > 8192 ? sb.substring(sb.length() - 8192) : sb.toString();
    }

    public static String getCrashExtraMessage(Context context) {
        Map<String, Object> map;
        if (context == null) {
            return "";
        }
        String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:44226;";
        StringBuilder sb = new StringBuilder();
        sb.append(g.a(true).e());
        sb.append("\n");
        sb.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && (map = QbSdk.f18850o) != null && map.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.f18850o.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            String str2 = "weapp_id:" + QbSdk.f18850o.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";" + TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY + ":" + QbSdk.f18850o.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            sb.append("\n");
            sb.append(str2);
        }
        return sb.length() > 8192 ? sb.substring(sb.length() - 8192) : sb.toString();
    }

    public static PackageInfo getCurrentWebViewPackage() {
        if (w.a().b() || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return (PackageInfo) com.tencent.smtt.utils.j.a("android.webkit.WebView", "getCurrentWebViewPackage");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        if (w.a().b()) {
            return null;
        }
        return com.tencent.smtt.utils.j.a("android.webkit.WebView", "getPluginList");
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        c();
        return g.a(true).g();
    }

    public static int getTbsSDKVersion(Context context) {
        return 44226;
    }

    private void h() throws Throwable {
        try {
            com.tencent.smtt.utils.s.b("old01");
            if ("com.xunmeng.pinduoduo".equals(this.f18971i.getApplicationInfo().packageName)) {
                new Thread("WebviewDestroy") { // from class: com.tencent.smtt.sdk.WebView.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() throws Throwable {
                        WebView.this.a(false);
                    }
                }.start();
                if (this.f18967e) {
                    this.f18968f.destroy();
                } else {
                    this.f18969g.destroy();
                }
            } else {
                com.tencent.smtt.utils.s.b("old02");
                a(true);
            }
        } catch (Throwable unused) {
            com.tencent.smtt.utils.s.b("old30");
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long i() {
        long j2;
        synchronized (QbSdk.f18843h) {
            if (QbSdk.f18840e) {
                QbSdk.f18842g += System.currentTimeMillis() - QbSdk.f18841f;
                TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.f18842g);
            }
            j2 = QbSdk.f18842g / 1000;
            QbSdk.f18842g = 0L;
            QbSdk.f18841f = System.currentTimeMillis();
        }
        return j2;
    }

    private void j() {
        new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.WebView.7
            @Override // java.lang.Runnable
            public void run() {
                boolean zIsX5CoreSandboxMode;
                Bundle sdkQBStatisticsInfo;
                if (WebView.this.f18972k || WebView.this.a == 0) {
                    return;
                }
                synchronized (WebView.class) {
                    if (!WebView.this.f18972k && WebView.this.a != 0) {
                        WebView.this.f18972k = true;
                        String string = "";
                        String string2 = "";
                        String string3 = "";
                        if (WebView.this.f18967e && (sdkQBStatisticsInfo = WebView.this.f18968f.getX5WebViewExtension().getSdkQBStatisticsInfo()) != null) {
                            string = sdkQBStatisticsInfo.getString("guid");
                            string2 = sdkQBStatisticsInfo.getString("qua2");
                            string3 = sdkQBStatisticsInfo.getString("lc");
                        }
                        String str = string2;
                        String str2 = string3;
                        String str3 = string;
                        if (TbsConfig.APP_QZONE.equals(WebView.this.f18971i.getApplicationInfo().packageName)) {
                            int iE = WebView.this.e(WebView.this.f18971i);
                            WebView webView = WebView.this;
                            if (iE == -1) {
                                iE = WebView.this.a;
                            }
                            webView.a = iE;
                            WebView.this.f(WebView.this.f18971i);
                        }
                        try {
                            zIsX5CoreSandboxMode = WebView.this.f18968f.getX5WebViewExtension().isX5CoreSandboxMode();
                        } catch (Throwable th) {
                            TbsLog.w("onVisibilityChanged", "exception: " + th);
                            zIsX5CoreSandboxMode = false;
                        }
                        com.tencent.smtt.sdk.stat.b.a(WebView.this.f18971i, str3, str, str2, WebView.this.a, WebView.this.f18967e, WebView.this.i(), zIsX5CoreSandboxMode);
                        WebView.this.a = 0;
                        WebView.this.f18972k = false;
                    }
                }
            }
        }).start();
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                com.tencent.smtt.utils.j.a(Class.forName("android.webkit.WebView"), "setDataDirectorySuffix", (Class<?>[]) new Class[]{String.class}, str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        HashMap map = new HashMap();
        map.put("data_directory_suffix", str);
        QbSdk.initTbsSettings(map);
    }

    public static synchronized void setSysDayOrNight(boolean z2) {
        int i2;
        Paint paint;
        if (z2 == f18966w) {
            return;
        }
        f18966w = z2;
        if (f18965v == null) {
            f18965v = new Paint();
            f18965v.setColor(-16777216);
        }
        if (z2) {
            i2 = 255;
            if (f18965v.getAlpha() != 255) {
                paint = f18965v;
                paint.setAlpha(i2);
            }
        }
        if (f18965v.getAlpha() != NIGHT_MODE_ALPHA) {
            paint = f18965v;
            i2 = NIGHT_MODE_ALPHA;
            paint.setAlpha(i2);
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z2) {
        w wVarA = w.a();
        if (wVarA != null && wVarA.b()) {
            wVarA.c().a(z2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                f18963m = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", Boolean.TYPE);
                if (f18963m != null) {
                    f18963m.setAccessible(true);
                    f18963m.invoke(null, Boolean.valueOf(z2));
                }
            } catch (Exception e2) {
                TbsLog.e("QbSdk", "Exception:" + e2.getStackTrace());
                e2.printStackTrace();
            }
        }
    }

    android.webkit.WebView a() {
        if (this.f18967e) {
            return null;
        }
        return this.f18969g;
    }

    /* JADX WARN: Finally extract failed */
    void a(Context context) throws Throwable {
        String str;
        int iE = e(context);
        if (iE != -1) {
            str = "PV=" + String.valueOf(iE + 1);
        } else {
            str = "PV=1";
        }
        File file = new File(QbSdk.getTbsFolderDir(context) + File.separator + "core_private", "pv.db");
        try {
            try {
                file.getParentFile().mkdirs();
                if (!file.isFile() || !file.exists()) {
                    file.createNewFile();
                }
                f18961d = new FileOutputStream(file, false);
                f18961d.write(str.getBytes());
                if (f18961d != null) {
                    f18961d.flush();
                }
            } catch (Throwable th) {
                if (f18961d != null) {
                    f18961d.flush();
                }
                throw th;
            }
        } catch (Throwable unused) {
        }
    }

    void a(android.webkit.WebView webView) {
    }

    void a(IX5WebViewBase iX5WebViewBase) {
        this.f18968f = iX5WebViewBase;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.f18967e) {
            this.f18968f.addJavascriptInterface(obj, str);
        } else {
            this.f18969g.addJavascriptInterface(obj, str);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (!this.f18967e) {
            this.f18969g.addView(view);
            return;
        }
        View view2 = this.f18968f.getView();
        try {
            Method methodA = com.tencent.smtt.utils.j.a(view2, "addView", View.class);
            methodA.setAccessible(true);
            methodA.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    IX5WebViewBase b() {
        return this.f18968f;
    }

    public boolean canGoBack() {
        return !this.f18967e ? this.f18969g.canGoBack() : this.f18968f.canGoBack();
    }

    public boolean canGoBackOrForward(int i2) {
        return !this.f18967e ? this.f18969g.canGoBackOrForward(i2) : this.f18968f.canGoBackOrForward(i2);
    }

    public boolean canGoForward() {
        return !this.f18967e ? this.f18969g.canGoForward() : this.f18968f.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        Object objA;
        if (this.f18967e) {
            return this.f18968f.canZoomIn();
        }
        if (Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.j.a(this.f18969g, "canZoomIn")) == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    @Deprecated
    public boolean canZoomOut() {
        Object objA;
        if (this.f18967e) {
            return this.f18968f.canZoomOut();
        }
        if (Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.j.a(this.f18969g, "canZoomOut")) == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    @Deprecated
    public Picture capturePicture() {
        if (this.f18967e) {
            return this.f18968f.capturePicture();
        }
        Object objA = com.tencent.smtt.utils.j.a(this.f18969g, "capturePicture");
        if (objA == null) {
            return null;
        }
        return (Picture) objA;
    }

    public void clearCache(boolean z2) {
        if (this.f18967e) {
            this.f18968f.clearCache(z2);
        } else {
            this.f18969g.clearCache(z2);
        }
    }

    public void clearFormData() {
        if (this.f18967e) {
            this.f18968f.clearFormData();
        } else {
            this.f18969g.clearFormData();
        }
    }

    public void clearHistory() {
        if (this.f18967e) {
            this.f18968f.clearHistory();
        } else {
            this.f18969g.clearHistory();
        }
    }

    @TargetApi(3)
    public void clearMatches() {
        if (this.f18967e) {
            this.f18968f.clearMatches();
        } else {
            this.f18969g.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (this.f18967e) {
            this.f18968f.clearSslPreferences();
        } else {
            this.f18969g.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        if (this.f18967e) {
            this.f18968f.clearView();
        } else {
            com.tencent.smtt.utils.j.a(this.f18969g, "clearView");
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        try {
            if (this.f18967e) {
                Method methodA = com.tencent.smtt.utils.j.a(this.f18968f.getView(), "computeHorizontalScrollExtent", new Class[0]);
                methodA.setAccessible(true);
                return ((Integer) methodA.invoke(this.f18968f.getView(), new Object[0])).intValue();
            }
            Method methodA2 = com.tencent.smtt.utils.j.a(this.f18969g, "computeHorizontalScrollExtent", new Class[0]);
            methodA2.setAccessible(true);
            return ((Integer) methodA2.invoke(this.f18969g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        try {
            if (this.f18967e) {
                Method methodA = com.tencent.smtt.utils.j.a(this.f18968f.getView(), "computeHorizontalScrollOffset", new Class[0]);
                methodA.setAccessible(true);
                return ((Integer) methodA.invoke(this.f18968f.getView(), new Object[0])).intValue();
            }
            Method methodA2 = com.tencent.smtt.utils.j.a(this.f18969g, "computeHorizontalScrollOffset", new Class[0]);
            methodA2.setAccessible(true);
            return ((Integer) methodA2.invoke(this.f18969g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        try {
            if (this.f18967e) {
                return ((Integer) com.tencent.smtt.utils.j.a(this.f18968f.getView(), "computeHorizontalScrollRange", (Class<?>[]) new Class[0], new Object[0])).intValue();
            }
            Method methodA = com.tencent.smtt.utils.j.a(this.f18969g, "computeHorizontalScrollRange", new Class[0]);
            methodA.setAccessible(true);
            return ((Integer) methodA.invoke(this.f18969g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f18967e) {
            this.f18968f.computeScroll();
        } else {
            this.f18969g.computeScroll();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        try {
            if (this.f18967e) {
                Method methodA = com.tencent.smtt.utils.j.a(this.f18968f.getView(), "computeVerticalScrollExtent", new Class[0]);
                methodA.setAccessible(true);
                return ((Integer) methodA.invoke(this.f18968f.getView(), new Object[0])).intValue();
            }
            Method methodA2 = com.tencent.smtt.utils.j.a(this.f18969g, "computeVerticalScrollExtent", new Class[0]);
            methodA2.setAccessible(true);
            return ((Integer) methodA2.invoke(this.f18969g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        try {
            if (this.f18967e) {
                Method methodA = com.tencent.smtt.utils.j.a(this.f18968f.getView(), "computeVerticalScrollOffset", new Class[0]);
                methodA.setAccessible(true);
                return ((Integer) methodA.invoke(this.f18968f.getView(), new Object[0])).intValue();
            }
            Method methodA2 = com.tencent.smtt.utils.j.a(this.f18969g, "computeVerticalScrollOffset", new Class[0]);
            methodA2.setAccessible(true);
            return ((Integer) methodA2.invoke(this.f18969g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        try {
            if (this.f18967e) {
                return ((Integer) com.tencent.smtt.utils.j.a(this.f18968f.getView(), "computeVerticalScrollRange", (Class<?>[]) new Class[0], new Object[0])).intValue();
            }
            Method methodA = com.tencent.smtt.utils.j.a(this.f18969g, "computeVerticalScrollRange", new Class[0]);
            methodA.setAccessible(true);
            return ((Integer) methodA.invoke(this.f18969g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        return this.f18967e ? WebBackForwardList.a(this.f18968f.copyBackForwardList()) : WebBackForwardList.a(this.f18969g.copyBackForwardList());
    }

    public Object createPrintDocumentAdapter(String str) {
        if (!this.f18967e) {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return com.tencent.smtt.utils.j.a(this.f18969g, "createPrintDocumentAdapter", (Class<?>[]) new Class[]{String.class}, str);
        }
        try {
            return this.f18968f.createPrintDocumentAdapter(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void customDiskCachePathEnabled(boolean z2, String str) {
        if (!this.f18967e || getX5WebViewExtension() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("enabled", z2);
        bundle.putString("path", str);
        getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
    }

    public void destroy() {
        boolean z2 = false;
        this.f18973l = false;
        try {
            if (this.f18971i.getApplicationInfo().packageName.contains("com.tencent.qqmusic") && (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22)) {
                this.f18973l = true;
                if (!com.tencent.smtt.utils.s.e(this.f18971i)) {
                    z2 = true;
                }
            }
        } catch (Throwable th) {
            TbsLog.i("webview", "stack is " + Log.getStackTraceString(th));
        }
        TbsLog.i("webview", "destroy forceDestoyOld is " + z2);
        if (z2) {
            h();
        } else {
            g();
        }
    }

    public void documentHasImages(Message message) {
        if (this.f18967e) {
            this.f18968f.documentHasImages(message);
        } else {
            this.f18969g.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i2) {
        if (this.f18967e) {
            this.f18968f.dumpViewHierarchyWithProperties(bufferedWriter, i2);
        } else {
            com.tencent.smtt.utils.j.a(this.f18969g, "dumpViewHierarchyWithProperties", (Class<?>[]) new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i2));
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.f18967e) {
            try {
                Method methodA = com.tencent.smtt.utils.j.a(this.f18968f.getView(), "evaluateJavascript", String.class, android.webkit.ValueCallback.class);
                methodA.setAccessible(true);
                methodA.invoke(this.f18968f.getView(), str, valueCallback);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                loadUrl(str);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", String.class, android.webkit.ValueCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.f18969g, str, valueCallback);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (this.f18967e) {
            return this.f18968f.findAll(str);
        }
        Object objA = com.tencent.smtt.utils.j.a(this.f18969g, "findAll", (Class<?>[]) new Class[]{String.class}, str);
        if (objA == null) {
            return 0;
        }
        return ((Integer) objA).intValue();
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (this.f18967e) {
            this.f18968f.findAllAsync(str);
        } else if (Build.VERSION.SDK_INT >= 16) {
            com.tencent.smtt.utils.j.a(this.f18969g, "findAllAsync", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    public View findHierarchyView(String str, int i2) {
        return !this.f18967e ? (View) com.tencent.smtt.utils.j.a(this.f18969g, "findHierarchyView", (Class<?>[]) new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i2)) : this.f18968f.findHierarchyView(str, i2);
    }

    @TargetApi(3)
    public void findNext(boolean z2) {
        if (this.f18967e) {
            this.f18968f.findNext(z2);
        } else {
            this.f18969g.findNext(z2);
        }
    }

    public void flingScroll(int i2, int i3) {
        if (this.f18967e) {
            this.f18968f.flingScroll(i2, i3);
        } else {
            this.f18969g.flingScroll(i2, i3);
        }
    }

    @Deprecated
    public void freeMemory() {
        if (this.f18967e) {
            this.f18968f.freeMemory();
        } else {
            com.tencent.smtt.utils.j.a(this.f18969g, "freeMemory");
        }
    }

    public SslCertificate getCertificate() {
        return !this.f18967e ? this.f18969g.getCertificate() : this.f18968f.getCertificate();
    }

    public int getContentHeight() {
        return !this.f18967e ? this.f18969g.getContentHeight() : this.f18968f.getContentHeight();
    }

    public int getContentWidth() {
        if (this.f18967e) {
            return this.f18968f.getContentWidth();
        }
        Object objA = com.tencent.smtt.utils.j.a(this.f18969g, "getContentWidth");
        if (objA == null) {
            return 0;
        }
        return ((Integer) objA).intValue();
    }

    public Bitmap getFavicon() {
        return !this.f18967e ? this.f18969g.getFavicon() : this.f18968f.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        return !this.f18967e ? new HitTestResult(this.f18969g.getHitTestResult()) : new HitTestResult(this.f18968f.getHitTestResult());
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return !this.f18967e ? this.f18969g.getHttpAuthUsernamePassword(str, str2) : this.f18968f.getHttpAuthUsernamePassword(str, str2);
    }

    public boolean getIsX5Core() {
        return this.f18967e;
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        return !this.f18967e ? this.f18969g.getOriginalUrl() : this.f18968f.getOriginalUrl();
    }

    public int getProgress() {
        return !this.f18967e ? this.f18969g.getProgress() : this.f18968f.getProgress();
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        Object objA;
        try {
            if (!this.f18967e && Build.VERSION.SDK_INT >= 26 && (objA = com.tencent.smtt.utils.j.a(this.f18969g, "getRendererPriorityWaivedWhenNotVisible")) != null) {
                return ((Boolean) objA).booleanValue();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public int getRendererRequestedPriority() {
        Object objA;
        try {
            if (!this.f18967e && Build.VERSION.SDK_INT >= 26 && (objA = com.tencent.smtt.utils.j.a(this.f18969g, "getRendererRequestedPriority")) != null) {
                return ((Integer) objA).intValue();
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Deprecated
    public float getScale() {
        if (this.f18967e) {
            return this.f18968f.getScale();
        }
        Object objA = com.tencent.smtt.utils.j.a(this.f18969g, "getScale");
        if (objA == null) {
            return 0.0f;
        }
        return ((Float) objA).floatValue();
    }

    @Override // android.view.View
    public int getScrollBarDefaultDelayBeforeFade() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarDefaultDelayBeforeFade();
    }

    @Override // android.view.View
    public int getScrollBarFadeDuration() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarFadeDuration();
    }

    @Override // android.view.View
    public int getScrollBarSize() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarSize();
    }

    @Override // android.view.View
    public int getScrollBarStyle() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarStyle();
    }

    public WebSettings getSettings() {
        WebSettings webSettings = this.f18970h;
        if (webSettings != null) {
            return webSettings;
        }
        WebSettings webSettings2 = this.f18967e ? new WebSettings(this.f18968f.getSettings()) : new WebSettings(this.f18969g.getSettings());
        this.f18970h = webSettings2;
        return webSettings2;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        if (this.f18967e) {
            return this.f18968f.getX5WebViewExtension().getSettingsExtension();
        }
        return null;
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        return !this.f18967e ? this.f18969g.getTitle() : this.f18968f.getTitle();
    }

    public String getUrl() {
        return !this.f18967e ? this.f18969g.getUrl() : this.f18968f.getUrl();
    }

    public View getView() {
        return !this.f18967e ? this.f18969g : this.f18968f.getView();
    }

    public int getVisibleTitleHeight() {
        if (this.f18967e) {
            return this.f18968f.getVisibleTitleHeight();
        }
        Object objA = com.tencent.smtt.utils.j.a(this.f18969g, "getVisibleTitleHeight");
        if (objA == null) {
            return 0;
        }
        return ((Integer) objA).intValue();
    }

    public WebChromeClient getWebChromeClient() {
        return this.f18975o;
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        if (this.f18967e) {
            return this.f18968f.getX5WebViewExtension().getWebChromeClientExtension();
        }
        return null;
    }

    public int getWebScrollX() {
        return this.f18967e ? this.f18968f.getView().getScrollX() : this.f18969g.getScrollX();
    }

    public int getWebScrollY() {
        return this.f18967e ? this.f18968f.getView().getScrollY() : this.f18969g.getScrollY();
    }

    public WebViewClient getWebViewClient() {
        return this.f18974n;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        if (this.f18967e) {
            return this.f18968f.getX5WebViewExtension().getWebViewClientExtension();
        }
        return null;
    }

    public IX5WebViewBase.HitTestResult getX5HitTestResult() {
        if (this.f18967e) {
            return this.f18968f.getHitTestResult();
        }
        return null;
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        if (this.f18967e) {
            return this.f18968f.getX5WebViewExtension();
        }
        return null;
    }

    @Deprecated
    public View getZoomControls() {
        return !this.f18967e ? (View) com.tencent.smtt.utils.j.a(this.f18969g, "getZoomControls") : this.f18968f.getZoomControls();
    }

    public void goBack() {
        if (this.f18967e) {
            this.f18968f.goBack();
        } else {
            this.f18969g.goBack();
        }
    }

    public void goBackOrForward(int i2) {
        if (this.f18967e) {
            this.f18968f.goBackOrForward(i2);
        } else {
            this.f18969g.goBackOrForward(i2);
        }
    }

    public void goForward() {
        if (this.f18967e) {
            this.f18968f.goForward();
        } else {
            this.f18969g.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (this.f18967e) {
            this.f18968f.invokeZoomPicker();
        } else {
            this.f18969g.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return f18966w;
    }

    public boolean isPrivateBrowsingEnabled() {
        Object objA;
        if (this.f18967e) {
            return this.f18968f.isPrivateBrowsingEnable();
        }
        if (Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.j.a(this.f18969g, "isPrivateBrowsingEnabled")) == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    public void loadData(String str, String str2, String str3) {
        if (this.f18967e) {
            this.f18968f.loadData(str, str2, str3);
        } else {
            this.f18969g.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.f18967e) {
            this.f18968f.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.f18969g.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        if (str == null || showDebugView(str)) {
            return;
        }
        if (this.f18967e) {
            this.f18968f.loadUrl(str);
        } else {
            this.f18969g.loadUrl(str);
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (str == null || showDebugView(str)) {
            return;
        }
        if (this.f18967e) {
            this.f18968f.loadUrl(str, map);
        } else if (Build.VERSION.SDK_INT >= 8) {
            this.f18969g.loadUrl(str, map);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f18972k || this.a == 0) {
            return;
        }
        j();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        View.OnLongClickListener onLongClickListener = this.f18982y;
        if (onLongClickListener == null || !onLongClickListener.onLongClick(view)) {
            return a(view);
        }
        return true;
    }

    public void onPause() {
        if (this.f18967e) {
            this.f18968f.onPause();
        } else {
            com.tencent.smtt.utils.j.a(this.f18969g, "onPause");
        }
    }

    public void onResume() {
        if (this.f18967e) {
            this.f18968f.onResume();
        } else {
            com.tencent.smtt.utils.j.a(this.f18969g, "onResume");
        }
    }

    @Override // android.view.View
    @TargetApi(11)
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT < 21 || !b(this.f18971i) || !isHardwareAccelerated() || i2 <= 0 || i3 <= 0) {
            return;
        }
        getLayerType();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        Context context = this.f18971i;
        if (context == null) {
            super.onVisibilityChanged(view, i2);
            return;
        }
        if (f18964p == null) {
            f18964p = context.getApplicationInfo().packageName;
        }
        String str = f18964p;
        if (str != null && (str.equals("com.tencent.mm") || f18964p.equals(TbsConfig.APP_QQ))) {
            super.onVisibilityChanged(view, i2);
            return;
        }
        if (i2 != 0 && !this.f18972k && this.a != 0) {
            j();
        }
        super.onVisibilityChanged(view, i2);
    }

    public boolean overlayHorizontalScrollbar() {
        return !this.f18967e ? this.f18969g.overlayHorizontalScrollbar() : this.f18968f.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.f18967e ? this.f18968f.overlayVerticalScrollbar() : this.f18969g.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z2) {
        return !this.f18967e ? this.f18969g.pageDown(z2) : this.f18968f.pageDown(z2, -1);
    }

    public boolean pageUp(boolean z2) {
        return !this.f18967e ? this.f18969g.pageUp(z2) : this.f18968f.pageUp(z2, -1);
    }

    public void pauseTimers() {
        if (this.f18967e) {
            this.f18968f.pauseTimers();
        } else {
            this.f18969g.pauseTimers();
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (this.f18967e) {
            this.f18968f.postUrl(str, bArr);
        } else {
            this.f18969g.postUrl(str, bArr);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z2) {
        if (this.f18967e) {
            this.f18968f.refreshPlugins(z2);
        } else {
            com.tencent.smtt.utils.j.a(this.f18969g, "refreshPlugins", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    public void reload() {
        if (this.f18967e) {
            this.f18968f.reload();
        } else {
            this.f18969g.reload();
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (this.f18967e) {
            this.f18968f.removeJavascriptInterface(str);
        } else if (Build.VERSION.SDK_INT >= 11) {
            com.tencent.smtt.utils.j.a(this.f18969g, "removeJavascriptInterface", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (!this.f18967e) {
            this.f18969g.removeView(view);
            return;
        }
        View view2 = this.f18968f.getView();
        try {
            Method methodA = com.tencent.smtt.utils.j.a(view2, "removeView", View.class);
            methodA.setAccessible(true);
            methodA.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    public JSONObject reportInitPerformance(long j2, int i2, long j3, long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("IS_X5", this.f18967e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        if (!this.f18967e) {
            a aVar = this.f18969g;
            View view2 = view;
            if (view == this) {
                view2 = aVar;
            }
            return aVar.requestChildRectangleOnScreen(view2, rect, z2);
        }
        View view3 = this.f18968f.getView();
        if (!(view3 instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view3;
        View view4 = view;
        if (view == this) {
            view4 = view3;
        }
        return viewGroup.requestChildRectangleOnScreen(view4, rect, z2);
    }

    public void requestFocusNodeHref(Message message) {
        if (this.f18967e) {
            this.f18968f.requestFocusNodeHref(message);
        } else {
            this.f18969g.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (this.f18967e) {
            this.f18968f.requestImageRef(message);
        } else {
            this.f18969g.requestImageRef(message);
        }
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (this.f18967e) {
            return this.f18968f.restorePicture(bundle, file);
        }
        Object objA = com.tencent.smtt.utils.j.a(this.f18969g, "restorePicture", (Class<?>[]) new Class[]{Bundle.class, File.class}, bundle, file);
        if (objA == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        return !this.f18967e ? WebBackForwardList.a(this.f18969g.restoreState(bundle)) : WebBackForwardList.a(this.f18968f.restoreState(bundle));
    }

    public void resumeTimers() {
        if (this.f18967e) {
            this.f18968f.resumeTimers();
        } else {
            this.f18969g.resumeTimers();
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (this.f18967e) {
            this.f18968f.savePassword(str, str2, str3);
        } else {
            com.tencent.smtt.utils.j.a(this.f18969g, "savePassword", (Class<?>[]) new Class[]{String.class, String.class, String.class}, str, str2, str3);
        }
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (this.f18967e) {
            return this.f18968f.savePicture(bundle, file);
        }
        Object objA = com.tencent.smtt.utils.j.a(this.f18969g, "savePicture", (Class<?>[]) new Class[]{Bundle.class, File.class}, bundle, file);
        if (objA == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return !this.f18967e ? WebBackForwardList.a(this.f18969g.saveState(bundle)) : WebBackForwardList.a(this.f18968f.saveState(bundle));
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (this.f18967e) {
            this.f18968f.saveWebArchive(str);
        } else if (Build.VERSION.SDK_INT >= 11) {
            com.tencent.smtt.utils.j.a(this.f18969g, "saveWebArchive", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z2, ValueCallback<String> valueCallback) {
        if (this.f18967e) {
            this.f18968f.saveWebArchive(str, z2, valueCallback);
        } else if (Build.VERSION.SDK_INT >= 11) {
            com.tencent.smtt.utils.j.a(this.f18969g, "saveWebArchive", (Class<?>[]) new Class[]{String.class, Boolean.TYPE, android.webkit.ValueCallback.class}, str, Boolean.valueOf(z2), valueCallback);
        }
    }

    public void setARModeEnable(boolean z2) {
        try {
            if (this.f18967e) {
                getSettingsExtension().setARModeEnable(z2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (this.f18967e) {
            this.f18968f.setBackgroundColor(i2);
        } else {
            this.f18969g.setBackgroundColor(i2);
        }
        super.setBackgroundColor(i2);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (this.f18967e) {
            this.f18968f.setCertificate(sslCertificate);
        } else {
            this.f18969g.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z2) {
        try {
            if (this.f18967e) {
                getSettingsExtension().setDayOrNight(z2);
            }
            setSysDayOrNight(z2);
            getView().postInvalidate();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDownloadListener(final DownloadListener downloadListener) {
        boolean z2 = this.f18967e;
        if (z2) {
            this.f18968f.setDownloadListener(new b(this, downloadListener, z2));
        } else {
            this.f18969g.setDownloadListener(new android.webkit.DownloadListener() { // from class: com.tencent.smtt.sdk.WebView.4
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 != null) {
                        downloadListener2.onDownloadStart(str, str2, str3, str4, j2);
                        return;
                    }
                    ApplicationInfo applicationInfo = WebView.this.f18971i == null ? null : WebView.this.f18971i.getApplicationInfo();
                    if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                        MttLoader.loadUrl(WebView.this.f18971i, str, null, null);
                    }
                }
            });
        }
    }

    @TargetApi(16)
    public void setFindListener(final IX5WebViewBase.FindListener findListener) {
        if (this.f18967e) {
            this.f18968f.setFindListener(findListener);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f18969g.setFindListener(new WebView.FindListener() { // from class: com.tencent.smtt.sdk.WebView.3
                @Override // android.webkit.WebView.FindListener
                public void onFindResultReceived(int i2, int i3, boolean z2) {
                    findListener.onFindResultReceived(i2, i3, z2);
                }
            });
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z2) {
        if (this.f18967e) {
            this.f18968f.setHorizontalScrollbarOverlay(z2);
        } else {
            this.f18969g.setHorizontalScrollbarOverlay(z2);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (this.f18967e) {
            this.f18968f.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.f18969g.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i2) {
        if (this.f18967e) {
            this.f18968f.setInitialScale(i2);
        } else {
            this.f18969g.setInitialScale(i2);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z2) {
        if (this.f18967e) {
            this.f18968f.setMapTrackballToArrowKeys(z2);
        } else {
            com.tencent.smtt.utils.j.a(this.f18969g, "setMapTrackballToArrowKeys", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    public void setNetworkAvailable(boolean z2) {
        if (this.f18967e) {
            this.f18968f.setNetworkAvailable(z2);
        } else if (Build.VERSION.SDK_INT >= 3) {
            this.f18969g.setNetworkAvailable(z2);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (!this.f18967e) {
            this.f18969g.setOnLongClickListener(onLongClickListener);
            return;
        }
        View view = this.f18968f.getView();
        try {
            if (this.f18981x == null) {
                Method methodA = com.tencent.smtt.utils.j.a(view, "getListenerInfo", new Class[0]);
                methodA.setAccessible(true);
                Object objInvoke = methodA.invoke(view, null);
                Field declaredField = objInvoke.getClass().getDeclaredField("mOnLongClickListener");
                declaredField.setAccessible(true);
                this.f18981x = declaredField.get(objInvoke);
            }
            this.f18982y = onLongClickListener;
            getView().setOnLongClickListener(this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    @Deprecated
    public void setPictureListener(final PictureListener pictureListener) {
        if (this.f18967e) {
            if (pictureListener == null) {
                this.f18968f.setPictureListener(null);
                return;
            } else {
                this.f18968f.setPictureListener(new IX5WebViewBase.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.6
                    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                    public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z2) {
                        WebView.this.a(iX5WebViewBase);
                        pictureListener.onNewPicture(WebView.this, picture);
                    }

                    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                    public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
                    }
                });
                return;
            }
        }
        if (pictureListener == null) {
            this.f18969g.setPictureListener(null);
        } else {
            this.f18969g.setPictureListener(new WebView.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.5
                @Override // android.webkit.WebView.PictureListener
                public void onNewPicture(android.webkit.WebView webView, Picture picture) {
                    WebView.this.a(webView);
                    pictureListener.onNewPicture(WebView.this, picture);
                }
            });
        }
    }

    public void setRendererPriorityPolicy(int i2, boolean z2) {
        try {
            if (this.f18967e || Build.VERSION.SDK_INT < 26) {
                return;
            }
            com.tencent.smtt.utils.j.a(this.f18969g, "setRendererPriorityPolicy", (Class<?>[]) new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i2), Boolean.valueOf(z2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i2) {
        if (this.f18967e) {
            this.f18968f.getView().setScrollBarStyle(i2);
        } else {
            this.f18969g.setScrollBarStyle(i2);
        }
    }

    public void setSysNightModeAlpha(int i2) {
        NIGHT_MODE_ALPHA = i2;
    }

    public void setVerticalScrollbarOverlay(boolean z2) {
        if (this.f18967e) {
            this.f18968f.setVerticalScrollbarOverlay(z2);
        } else {
            this.f18969g.setVerticalScrollbarOverlay(z2);
        }
    }

    public boolean setVideoFullScreen(Context context, boolean z2) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f18968f == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z2) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f18968f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (getView() == null) {
            return;
        }
        getView().setVisibility(i2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        a aVar;
        android.webkit.WebChromeClient systemWebChromeClient = null;
        if (this.f18967e) {
            this.f18968f.setWebChromeClient(webChromeClient != null ? new i(w.a().a(true).i(), this, webChromeClient) : null);
        } else {
            if (webChromeClient == null) {
                aVar = this.f18969g;
            } else if (a(webChromeClient)) {
                aVar = this.f18969g;
                systemWebChromeClient = new e(this, webChromeClient);
            } else {
                aVar = this.f18969g;
                systemWebChromeClient = new SystemWebChromeClient(this, webChromeClient);
            }
            aVar.setWebChromeClient(systemWebChromeClient);
        }
        this.f18975o = webChromeClient;
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.f18967e) {
            this.f18968f.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (!this.f18967e || getX5WebViewExtension() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(AgooConstants.MESSAGE_FLAG, true);
        getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setWebViewClient(WebViewClient webViewClient) {
        if (this.f18967e) {
            this.f18968f.setWebViewClient(webViewClient != null ? new j(w.a().a(true).j(), this, webViewClient) : null);
        } else {
            this.f18969g.setWebViewClient(webViewClient != null ? new SystemWebViewClient(this, webViewClient) : null);
        }
        this.f18974n = webViewClient;
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.f18967e) {
            this.f18968f.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("https://debugtbs.qq.com")) {
            getView().setVisibility(4);
            com.tencent.smtt.utils.d.a(this.f18971i).a(lowerCase, this, this.f18971i, n.a().getLooper());
            return true;
        }
        if (!lowerCase.startsWith("https://debugx5.qq.com") || this.f18967e) {
            return false;
        }
        loadDataWithBaseURL(null, "<!DOCTYPE html><html><body><head><title>无法打开debugx5</title><meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" /></head><br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />尝试<a href=\"https://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a></body></html>", "text/html", com.anythink.expressad.foundation.g.a.bN, null);
        return true;
    }

    public boolean showFindDialog(String str, boolean z2) {
        return false;
    }

    public void stopLoading() {
        if (this.f18967e) {
            this.f18968f.stopLoading();
        } else {
            this.f18969g.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (!this.f18967e) {
            this.f18969g.a();
            return;
        }
        try {
            com.tencent.smtt.utils.j.a(this.f18968f.getView(), "super_computeScroll");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f18967e) {
            return this.f18969g.b(motionEvent);
        }
        try {
            Object objA = com.tencent.smtt.utils.j.a(this.f18968f.getView(), "super_dispatchTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (objA == null) {
                return false;
            }
            return ((Boolean) objA).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f18967e) {
            return this.f18969g.c(motionEvent);
        }
        try {
            Object objA = com.tencent.smtt.utils.j.a(this.f18968f.getView(), "super_onInterceptTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (objA == null) {
                return false;
            }
            return ((Boolean) objA).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void super_onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        if (!this.f18967e) {
            this.f18969g.a(i2, i3, z2, z3);
            return;
        }
        try {
            com.tencent.smtt.utils.j.a(this.f18968f.getView(), "super_onOverScrolled", (Class<?>[]) new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z3));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void super_onScrollChanged(int i2, int i3, int i4, int i5) {
        if (!this.f18967e) {
            this.f18969g.a(i2, i3, i4, i5);
            return;
        }
        try {
            com.tencent.smtt.utils.j.a(this.f18968f.getView(), "super_onScrollChanged", (Class<?>[]) new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.f18967e) {
            return this.f18969g.a(motionEvent);
        }
        try {
            Object objA = com.tencent.smtt.utils.j.a(this.f18968f.getView(), "super_onTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (objA == null) {
                return false;
            }
            return ((Boolean) objA).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
        if (!this.f18967e) {
            return this.f18969g.a(i2, i3, i4, i5, i6, i7, i8, i9, z2);
        }
        try {
            Object objA = com.tencent.smtt.utils.j.a(this.f18968f.getView(), "super_overScrollBy", (Class<?>[]) new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Boolean.valueOf(z2));
            if (objA == null) {
                return false;
            }
            return ((Boolean) objA).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void switchNightMode(boolean z2) {
        String str;
        if (z2 == f18966w) {
            return;
        }
        f18966w = z2;
        if (f18966w) {
            TbsLog.e("QB_SDK", "deleteNightMode");
            str = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        } else {
            TbsLog.e("QB_SDK", "nightMode");
            str = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        }
        loadUrl(str);
    }

    public void switchToNightMode() {
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (f18966w) {
            return;
        }
        TbsLog.e("QB_SDK", "switchToNightMode");
        loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }

    public boolean zoomIn() {
        return !this.f18967e ? this.f18969g.zoomIn() : this.f18968f.zoomIn();
    }

    public boolean zoomOut() {
        return !this.f18967e ? this.f18969g.zoomOut() : this.f18968f.zoomOut();
    }
}

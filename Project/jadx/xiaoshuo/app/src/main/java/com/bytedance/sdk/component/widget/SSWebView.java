package com.bytedance.sdk.component.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.component.utils.pe;
import com.yuewen.xa3;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SSWebView extends FrameLayout {
    private String bf;
    private float bh;
    private AtomicInteger cv;
    private JSONObject d;
    private Context dt;
    private com.bytedance.sdk.component.widget.bf.e e;
    private pe f;
    private float ga;
    private AttributeSet k;
    private bf l;
    private boolean m;
    private long p;
    private AtomicBoolean pe;
    private int s;
    private float t;
    private boolean tg;
    private long v;
    private float vn;
    private int w;
    private d wl;
    private WebView wu;
    private float xu;
    private AtomicBoolean y;
    private long zk;

    public interface bf {
        void e(int i);
    }

    public interface d {
        void e(boolean z);
    }

    public static class e extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView == null) {
                return true;
            }
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
            return true;
        }
    }

    public SSWebView(Context context) {
        super(e(context));
        this.ga = 0.0f;
        this.vn = 0.0f;
        this.p = 0L;
        this.v = 0L;
        this.zk = 0L;
        this.m = false;
        this.xu = 20.0f;
        this.t = 50.0f;
        this.pe = new AtomicBoolean();
        this.y = new AtomicBoolean();
        this.cv = new AtomicInteger();
        try {
            this.wu = new WebView(e(context));
            bf();
        } catch (Throwable unused) {
        }
        bf(e(context));
    }

    private static void d(Context context) {
    }

    private static Context e(Context context) {
        return context;
    }

    private void s() {
        try {
            WebSettings settings = this.wu.getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    public static void setDataDirectorySuffix(String str) {
        WebView.setDataDirectorySuffix(str);
    }

    private void t() {
        try {
            this.wu.removeJavascriptInterface("searchBoxJavaBridge_");
            this.wu.removeJavascriptInterface("accessibility");
            this.wu.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    public void bf() {
        if (this.wu != null) {
            removeAllViews();
            setBackground(null);
            try {
                this.wu.setId(dt.ga(getContext(), "tt_id_root_web_view"));
            } catch (Throwable unused) {
            }
            addView(this.wu, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void bh() {
        this.y.set(false);
        pe peVar = this.f;
        if (peVar != null) {
            peVar.bf();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        try {
            this.wu.computeScroll();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        d dVar = this.wl;
        if (dVar != null) {
            dVar.e(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean ga() {
        try {
            return this.wu.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    public int getContentHeight() {
        try {
            return this.wu.getContentHeight();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public com.bytedance.sdk.component.widget.bf.e getMaterialMeta() {
        return this.e;
    }

    public String getOriginalUrl() {
        String url;
        try {
            String originalUrl = this.wu.getOriginalUrl();
            return (originalUrl == null || !originalUrl.startsWith("data:text/html") || (url = this.wu.getUrl()) == null) ? originalUrl : url.startsWith("file://") ? url : originalUrl;
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getProgress() {
        try {
            return this.wu.getProgress();
        } catch (Throwable unused) {
            return 100;
        }
    }

    public String getUrl() {
        try {
            return this.wu.getUrl();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getUserAgentString() {
        try {
            return this.wu.getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public WebView getWebView() {
        return this.wu;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void m() {
        try {
            this.wu.destroy();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.pe.set(true);
        if (this.y.get()) {
            d(this.cv.get());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.pe.set(false);
        pe peVar = this.f;
        if (peVar != null) {
            peVar.bf();
        }
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentE;
        try {
            e(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.m && (viewParentE = e(this)) != null) {
                viewParentE.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        pe peVar = this.f;
        if (peVar != null) {
            if (z) {
                peVar.e();
            } else {
                peVar.bf();
            }
        }
    }

    public void p() {
        WebView webView = this.wu;
        if (webView != null) {
            webView.onResume();
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        try {
            this.wu.removeAllViews();
        } catch (Throwable unused) {
        }
    }

    public void setAllowFileAccess(boolean z) {
        try {
            this.wu.getSettings().setAllowFileAccess(z);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        try {
            super.setAlpha(f);
            this.wu.setAlpha(f);
        } catch (Throwable unused) {
        }
    }

    public void setAppCacheEnabled(boolean z) {
        try {
            this.wu.getSettings().setAppCacheEnabled(z);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        try {
            this.wu.setBackgroundColor(i);
        } catch (Throwable unused) {
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        try {
            this.wu.getSettings().setBuiltInZoomControls(z);
        } catch (Throwable unused) {
        }
    }

    public void setCacheMode(int i) {
        try {
            this.wu.getSettings().setCacheMode(i);
        } catch (Throwable unused) {
        }
    }

    public void setCalculationMethod(int i) {
        this.s = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.w = i;
    }

    public void setDatabaseEnabled(boolean z) {
        try {
            this.wu.getSettings().setDatabaseEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setDeepShakeValue(float f) {
        this.bh = f;
    }

    public void setDefaultFontSize(int i) {
        try {
            this.wu.getSettings().setDefaultFontSize(i);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultTextEncodingName(String str) {
        try {
            this.wu.getSettings().setDefaultTextEncodingName(str);
        } catch (Throwable unused) {
        }
    }

    public void setDisplayZoomControls(boolean z) {
        try {
            this.wu.getSettings().setDisplayZoomControls(z);
        } catch (Throwable unused) {
        }
    }

    public void setDomStorageEnabled(boolean z) {
        try {
            this.wu.getSettings().setDomStorageEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            this.wu.setDownloadListener(downloadListener);
        } catch (Throwable unused) {
        }
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.m = z;
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        try {
            this.wu.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptEnabled(boolean z) {
        try {
            this.wu.getSettings().setJavaScriptEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setLandingPage(boolean z) {
        this.tg = z;
    }

    @Override // android.view.View
    public void setLayerType(int i, Paint paint) {
        try {
            this.wu.setLayerType(i, paint);
        } catch (Throwable unused) {
        }
    }

    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        try {
            this.wu.getSettings().setLayoutAlgorithm(layoutAlgorithm);
        } catch (Throwable unused) {
        }
    }

    public void setLoadWithOverviewMode(boolean z) {
        try {
            this.wu.getSettings().setLoadWithOverviewMode(z);
        } catch (Throwable unused) {
        }
    }

    public void setMaterialMeta(com.bytedance.sdk.component.widget.bf.e eVar) {
        this.e = eVar;
    }

    public void setMixedContentMode(int i) {
        try {
            this.wu.getSettings().setMixedContentMode(i);
        } catch (Throwable unused) {
        }
    }

    public void setNetworkAvailable(boolean z) {
        try {
            this.wu.setNetworkAvailable(z);
        } catch (Throwable unused) {
        }
    }

    public void setOnShakeListener(bf bfVar) {
        this.l = bfVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        try {
            this.wu.setOverScrollMode(i);
            super.setOverScrollMode(i);
        } catch (Throwable unused) {
        }
    }

    public void setShakeValue(float f) {
        this.xu = f;
    }

    public void setSupportZoom(boolean z) {
        try {
            this.wu.getSettings().setSupportZoom(z);
        } catch (Throwable unused) {
        }
    }

    public void setTag(String str) {
        this.bf = str;
    }

    public void setTouchStateListener(d dVar) {
        this.wl = dVar;
    }

    public void setUseWideViewPort(boolean z) {
        try {
            this.wu.getSettings().setUseWideViewPort(z);
        } catch (Throwable unused) {
        }
    }

    public void setUserAgentString(String str) {
        try {
            this.wu.getSettings().setUserAgentString(str);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        try {
            super.setVisibility(i);
            this.wu.setVisibility(i);
        } catch (Throwable unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            this.wu.setWebChromeClient(webChromeClient);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            if (webViewClient instanceof d) {
                setTouchStateListener((d) webViewClient);
            } else {
                setTouchStateListener(null);
            }
            if (webViewClient == 0) {
                webViewClient = new e();
            }
            this.wu.setWebViewClient(webViewClient);
        } catch (Throwable unused) {
        }
    }

    public void setWriggleValue(float f) {
        this.t = f;
    }

    public void tg() {
        try {
            this.wu.stopLoading();
        } catch (Throwable unused) {
        }
    }

    public void v() {
        try {
            this.wu.clearHistory();
        } catch (Throwable unused) {
        }
    }

    public void vn() {
        try {
            this.wu.goBack();
        } catch (Throwable unused) {
        }
    }

    public void wu() {
        try {
            this.wu.clearView();
        } catch (Throwable unused) {
        }
    }

    public void xu() {
        try {
            this.wu.pauseTimers();
        } catch (Throwable unused) {
        }
    }

    public void zk() {
        try {
            this.wu.onPause();
            d dVar = this.wl;
            if (dVar != null) {
                dVar.e(false);
            }
        } catch (Throwable unused) {
        }
    }

    private void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (TextUtils.isEmpty(str) || (settings = this.wu.getSettings()) == null) {
                return;
            }
            if (Uri.parse(str).getScheme().equals(xa3.f19839a)) {
                settings.setJavaScriptEnabled(false);
            } else {
                settings.setJavaScriptEnabled(true);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean d() {
        pe peVar = this.f;
        if (peVar == null) {
            return false;
        }
        return peVar.d();
    }

    public void e() {
        try {
            if (this.k == null) {
                this.wu = new WebView(e(this.dt));
            } else {
                this.wu = new WebView(e(this.dt), this.k);
            }
            bf();
            bf(e(this.dt));
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public String getTag() {
        return this.bf;
    }

    private static boolean d(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    private void bf(Context context) {
        d(context);
        s();
        t();
    }

    public void e(String str) {
        try {
            setJavaScriptEnabled(str);
            this.wu.loadUrl(str);
        } catch (Throwable unused) {
        }
    }

    private static boolean bf(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public void e(boolean z) {
        try {
            this.wu.clearCache(z);
        } catch (Throwable unused) {
        }
    }

    private void d(int i) {
        if (this.f == null) {
            this.f = new pe(getContext(), i);
        }
        this.f.e(this.xu);
        this.f.d(this.bh);
        this.f.bf(this.t);
        this.f.e(this.s);
        this.f.bf(this.w);
        this.f.e(new pe.e() { // from class: com.bytedance.sdk.component.widget.SSWebView.1
            @Override // com.bytedance.sdk.component.utils.pe.e
            public void e(int i2) {
                if (i2 == 1) {
                    SSWebView.this.bf(1);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    SSWebView.this.bf(2);
                }
            }
        });
        this.f.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewParent e(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (bf(view2) || d(view2)) ? parent : e(view2);
    }

    public void bf(String str) {
        try {
            this.wu.removeJavascriptInterface(str);
        } catch (Throwable unused) {
        }
    }

    public SSWebView(Context context, AttributeSet attributeSet) {
        super(e(context), attributeSet);
        this.ga = 0.0f;
        this.vn = 0.0f;
        this.p = 0L;
        this.v = 0L;
        this.zk = 0L;
        boolean z = false;
        this.m = false;
        this.xu = 20.0f;
        this.t = 50.0f;
        this.pe = new AtomicBoolean();
        this.y = new AtomicBoolean();
        this.cv = new AtomicInteger();
        try {
            if (com.bytedance.sdk.component.widget.e.e.e().bf() != null && com.bytedance.sdk.component.widget.e.e.e().bf().e()) {
                int iV = dt.v(context, "tt_delay_init");
                boolean attributeBooleanValue = false;
                for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
                    try {
                        if (attributeSet.getAttributeNameResource(i) == iV) {
                            attributeBooleanValue = attributeSet.getAttributeBooleanValue(i, false);
                        }
                    } catch (Throwable unused) {
                    }
                }
                z = attributeBooleanValue;
            }
        } catch (Throwable unused2) {
        }
        this.dt = context;
        if (z) {
            return;
        }
        this.k = attributeSet;
        e();
    }

    public void bf(int i) {
        bf bfVar = this.l;
        if (bfVar != null) {
            bfVar.e(i);
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void e(Object obj, String str) {
        try {
            this.wu.addJavascriptInterface(obj, str);
        } catch (Throwable unused) {
        }
    }

    public void e(int i) {
        this.y.set(true);
        this.cv.set(i);
        if (this.pe.get()) {
            d(i);
        }
    }

    private void e(MotionEvent motionEvent) {
        if (!this.tg || this.e == null) {
            return;
        }
        if ((this.bf == null && this.d == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.ga = motionEvent.getRawX();
                this.vn = motionEvent.getRawY();
                this.p = System.currentTimeMillis();
                this.d = new JSONObject();
                WebView webView = this.wu;
                if (webView != null) {
                    webView.setTag(dt.ga(getContext(), "tt_id_click_begin"), Long.valueOf(this.p));
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.d.put("start_x", String.valueOf(this.ga));
                this.d.put("start_y", String.valueOf(this.vn));
                this.d.put("offset_x", String.valueOf(motionEvent.getRawX() - this.ga));
                this.d.put("offset_y", String.valueOf(motionEvent.getRawY() - this.vn));
                this.d.put("url", String.valueOf(getUrl()));
                this.d.put("tag", "");
                this.v = System.currentTimeMillis();
                WebView webView2 = this.wu;
                if (webView2 != null) {
                    webView2.setTag(dt.ga(getContext(), "tt_id_click_end"), Long.valueOf(this.v));
                }
                this.d.put("down_time", this.p);
                this.d.put("up_time", this.v);
                if (com.bytedance.sdk.component.widget.e.e.e().bf() != null) {
                    long j = this.zk;
                    long j2 = this.p;
                    if (j != j2) {
                        this.zk = j2;
                        com.bytedance.sdk.component.widget.e.e.e().bf().e(this.e, this.bf, "in_web_click", this.d, this.v - this.p);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public SSWebView(Context context, AttributeSet attributeSet, int i) {
        super(e(context), attributeSet, i);
        this.ga = 0.0f;
        this.vn = 0.0f;
        this.p = 0L;
        this.v = 0L;
        this.zk = 0L;
        this.m = false;
        this.xu = 20.0f;
        this.t = 50.0f;
        this.pe = new AtomicBoolean();
        this.y = new AtomicBoolean();
        this.cv = new AtomicInteger();
        try {
            this.wu = new WebView(e(context), attributeSet, i);
            bf();
        } catch (Throwable unused) {
        }
        bf(e(context));
    }
}

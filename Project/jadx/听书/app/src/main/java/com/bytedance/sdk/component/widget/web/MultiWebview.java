package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.i.dl;
import com.bytedance.sdk.component.i.g;
import com.bytedance.sdk.component.i.z;
import com.bytedance.sdk.component.utils.gz;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class MultiWebview extends FrameLayout implements com.bytedance.sdk.component.i.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.sdk.component.widget.z f847a = null;
    private static int gc = 1;
    protected WebViewImpl dl;
    private z.InterfaceC0137z e;
    private Map<dl, Set<String>> fo;
    protected volatile dl g;
    private Deque<dl> gz;
    private long m;
    protected final AtomicInteger z;

    public static void setMaxWebViewCount(int i) {
        gc = i + 1;
    }

    public static void setExceptionReport(com.bytedance.sdk.component.widget.z zVar) {
        f847a = zVar;
    }

    public MultiWebview(Context context) {
        this(context, null);
    }

    public MultiWebview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiWebview(final Context context, final AttributeSet attributeSet, final int i) {
        super(context, attributeSet, i);
        AtomicInteger atomicInteger = new AtomicInteger();
        this.z = atomicInteger;
        this.gz = new LinkedList();
        this.fo = new ConcurrentHashMap();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        atomicInteger.set(1);
        if (gc()) {
            this.dl = z(context, attributeSet, i);
            a();
            this.m = System.currentTimeMillis() - jCurrentTimeMillis;
            return;
        }
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.1
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview multiWebview = MultiWebview.this;
                multiWebview.dl = multiWebview.z(context, attributeSet, i);
                MultiWebview.this.a();
                MultiWebview.this.m = System.currentTimeMillis() - jCurrentTimeMillis;
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewImpl z(Context context, AttributeSet attributeSet, int i) {
        WebViewImpl webViewImpl;
        try {
            this.z.set(2);
            if (i == 0) {
                webViewImpl = new WebViewImpl(this, context, attributeSet);
            } else {
                webViewImpl = new WebViewImpl(this, context, attributeSet, i);
            }
            this.z.set(3);
            return webViewImpl;
        } catch (Throwable th) {
            this.z.set(4);
            if (f847a == null) {
                return null;
            }
            f847a.z(Thread.currentThread().getName(), th);
            return null;
        }
    }

    private dl dl() {
        String name = Thread.currentThread().getName();
        try {
            return new WebViewImpl(this, getContext());
        } catch (Throwable th) {
            com.bytedance.sdk.component.widget.z zVar = f847a;
            if (zVar == null) {
                return null;
            }
            zVar.z(name, th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.dl == null) {
            return;
        }
        removeAllViews();
        setBackground(null);
        try {
            this.dl.getView().setId(2064056317);
        } catch (Throwable unused) {
        }
        addView(this.dl.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.gz.add(this.dl);
        this.g = this.dl;
    }

    public void G_() {
        this.fo.clear();
        this.e = null;
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.2
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.m();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        while (true) {
            dl dlVarZ = z();
            if (dlVarZ == null) {
                break;
            } else {
                removeView(dlVarZ.getView());
            }
        }
        WebViewImpl webViewImpl = this.dl;
        if (webViewImpl != null) {
            webViewImpl.g();
        }
    }

    @Override // com.bytedance.sdk.component.i.z
    public int z(final String str) {
        dl dlVarG;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (gc == 1) {
            return 2;
        }
        if (getWebViewCount() >= gc) {
            return 1;
        }
        if (gc()) {
            dlVarG = g(str);
        } else {
            final dl[] dlVarArr = new dl[1];
            final Object obj = new Object();
            z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.3
                @Override // java.lang.Runnable
                public void run() {
                    dlVarArr[0] = MultiWebview.this.g(str);
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            try {
                if (dlVarArr[0] == null) {
                    synchronized (obj) {
                        obj.wait(2500L);
                    }
                }
            } catch (InterruptedException unused) {
            }
            dlVarG = dlVarArr[0];
        }
        return dlVarG != null ? 0 : -999;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public dl g(String str) {
        dl dlVarDl = dl();
        if (dlVarDl != null) {
            dl dlVar = this.g;
            this.gz.add(dlVarDl);
            this.g = dlVarDl;
            addView(dlVarDl.getView(), new FrameLayout.LayoutParams(-1, -1));
            z(dlVarDl);
            dlVarDl.loadUrl(str);
            if (dlVar != null) {
                dlVar.onPause();
                dlVar.setVisibility(8);
            }
        }
        return dlVarDl;
    }

    private void z(dl dlVar) {
        z zVar;
        Object objZ;
        WebViewImpl webViewImpl = this.dl;
        if (webViewImpl == null || dlVar == null) {
            return;
        }
        Integer backgroundColor = webViewImpl.getBackgroundColor();
        if (backgroundColor != null) {
            dlVar.setBackgroundColor(backgroundColor.intValue());
        }
        Boolean allowFileAccess = webViewImpl.getAllowFileAccess();
        if (allowFileAccess != null) {
            dlVar.setAllowFileAccess(allowFileAccess.booleanValue());
        }
        Boolean databaseEnabled = webViewImpl.getDatabaseEnabled();
        if (databaseEnabled != null) {
            dlVar.setDatabaseEnabled(databaseEnabled.booleanValue());
        }
        Boolean appCacheEnabled = webViewImpl.getAppCacheEnabled();
        if (appCacheEnabled != null) {
            dlVar.setAppCacheEnabled(appCacheEnabled.booleanValue());
        }
        Boolean domStorageEnabled = webViewImpl.getDomStorageEnabled();
        if (domStorageEnabled != null) {
            dlVar.setDomStorageEnabled(domStorageEnabled.booleanValue());
        }
        Boolean supportZoom = webViewImpl.getSupportZoom();
        if (supportZoom != null) {
            dlVar.setSupportZoom(supportZoom.booleanValue());
        }
        Boolean builtInZoomControls = webViewImpl.getBuiltInZoomControls();
        if (builtInZoomControls != null) {
            dlVar.setBuiltInZoomControls(builtInZoomControls.booleanValue());
        }
        Boolean useWideViewPort = webViewImpl.getUseWideViewPort();
        if (useWideViewPort != null) {
            dlVar.setUseWideViewPort(useWideViewPort.booleanValue());
        }
        WebSettings.LayoutAlgorithm layoutAlgorithm = webViewImpl.getLayoutAlgorithm();
        if (layoutAlgorithm != null) {
            dlVar.setLayoutAlgorithm(layoutAlgorithm);
        }
        Boolean javaScriptEnabled = webViewImpl.getJavaScriptEnabled();
        if (javaScriptEnabled != null) {
            dlVar.setJavaScriptEnabled(javaScriptEnabled.booleanValue());
        }
        Boolean javaScriptCanOpenWindowsAutomatically = webViewImpl.getJavaScriptCanOpenWindowsAutomatically();
        if (javaScriptCanOpenWindowsAutomatically != null) {
            dlVar.setJavaScriptCanOpenWindowsAutomatically(javaScriptCanOpenWindowsAutomatically.booleanValue());
        }
        View.OnScrollChangeListener onScrollChangeListener = webViewImpl.getOnScrollChangeListener();
        if (onScrollChangeListener != null) {
            dlVar.setOnScrollChangeListener(onScrollChangeListener);
        }
        Boolean mediaPlaybackRequiresUserGesture = webViewImpl.getMediaPlaybackRequiresUserGesture();
        if (mediaPlaybackRequiresUserGesture != null) {
            dlVar.setMediaPlaybackRequiresUserGesture(mediaPlaybackRequiresUserGesture.booleanValue());
        }
        Boolean savePassword = webViewImpl.getSavePassword();
        if (savePassword != null) {
            dlVar.setSavePassword(savePassword.booleanValue());
        }
        Boolean allowFileAccessFromFileURLs = webViewImpl.getAllowFileAccessFromFileURLs();
        if (allowFileAccessFromFileURLs != null) {
            dlVar.setAllowFileAccessFromFileURLs(allowFileAccessFromFileURLs.booleanValue());
        }
        Boolean allowUniversalAccessFromFileURLs = webViewImpl.getAllowUniversalAccessFromFileURLs();
        if (allowUniversalAccessFromFileURLs != null) {
            dlVar.setAllowUniversalAccessFromFileURLs(allowUniversalAccessFromFileURLs.booleanValue());
        }
        Boolean blockNetworkImage = webViewImpl.getBlockNetworkImage();
        if (blockNetworkImage != null) {
            dlVar.setBlockNetworkImage(blockNetworkImage.booleanValue());
        }
        Integer defaultFontSize = webViewImpl.getDefaultFontSize();
        if (defaultFontSize != null) {
            dlVar.setDefaultFontSize(defaultFontSize.intValue());
        }
        String defaultTextEncodingName = webViewImpl.getDefaultTextEncodingName();
        if (defaultTextEncodingName != null) {
            dlVar.setDefaultTextEncodingName(defaultTextEncodingName);
        }
        Integer cacheMode = webViewImpl.getCacheMode();
        if (cacheMode != null) {
            dlVar.setCacheMode(cacheMode.intValue());
        }
        Boolean displayZoomControls = webViewImpl.getDisplayZoomControls();
        if (displayZoomControls != null) {
            dlVar.setDisplayZoomControls(displayZoomControls.booleanValue());
        }
        Boolean loadWithOverviewMod = webViewImpl.getLoadWithOverviewMod();
        if (loadWithOverviewMod != null) {
            dlVar.setLoadWithOverviewMode(loadWithOverviewMod.booleanValue());
        }
        String userAgentString = webViewImpl.getUserAgentString();
        if (userAgentString != null) {
            dlVar.setUserAgentString(userAgentString);
        }
        g.z onTouchEventListener = webViewImpl.getOnTouchEventListener();
        if (onTouchEventListener != null) {
            dlVar.setTouchEventListener(onTouchEventListener);
        }
        DownloadListener downloadListener = webViewImpl.getDownloadListener();
        if (downloadListener != null) {
            dlVar.setDownloadListener(downloadListener);
        }
        WebChromeClient chromeClient = webViewImpl.getChromeClient();
        if (chromeClient != null) {
            dlVar.setWebChromeClient(chromeClient);
        }
        com.bytedance.sdk.component.widget.g client = webViewImpl.getClient();
        if (client != null) {
            dlVar.setWebViewClient(client.z());
        }
        Map<String, z> javascriptInterfaces = webViewImpl.getJavascriptInterfaces();
        if (javascriptInterfaces != null) {
            for (String str : javascriptInterfaces.keySet()) {
                if (str != null && (zVar = javascriptInterfaces.get(str)) != null && (objZ = zVar.z()) != null) {
                    dlVar.addJavascriptInterface(objZ, str);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.i.z
    public dl z() {
        if (gc()) {
            return e();
        }
        final dl[] dlVarArr = new dl[1];
        final Object obj = new Object();
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.4
            @Override // java.lang.Runnable
            public void run() {
                dlVarArr[0] = MultiWebview.this.e();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (dlVarArr[0] == null) {
                synchronized (obj) {
                    obj.wait(2500L);
                }
            }
        } catch (InterruptedException unused) {
        }
        return dlVarArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public dl e() {
        if (this.gz.size() < 2) {
            this.g = this.dl;
            return null;
        }
        dl dlVarPollLast = this.gz.pollLast();
        if (dlVarPollLast != null) {
            removeView(dlVarPollLast.getView());
            dlVarPollLast.destroy();
            this.fo.remove(dlVarPollLast);
        }
        dl last = this.gz.getLast();
        if (last != null) {
            last.setVisibility(0);
            last.onResume();
            this.g = last;
        }
        return dlVarPollLast;
    }

    public void destroy() {
        while (true) {
            dl dlVarPollLast = this.gz.pollLast();
            if (dlVarPollLast != null) {
                dlVarPollLast.destroy();
            } else {
                this.dl = null;
                this.g = null;
                this.fo.clear();
                this.e = null;
                return;
            }
        }
    }

    public dl getCurrentWebView() {
        return this.g;
    }

    public int getWebViewCount() {
        return this.gz.size();
    }

    @Override // com.bytedance.sdk.component.i.z
    public void z(dl dlVar, String str, String str2, Object obj) {
        if (str2 == null || dlVar == null) {
            return;
        }
        for (dl dlVar2 : this.fo.keySet()) {
            if (dlVar2 != null && dlVar != dlVar2) {
                Set<String> set = this.fo.get(dlVar2);
                if (set == null) {
                    return;
                }
                if (set.contains(str2)) {
                    dlVar2.z(str, str2, obj);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.i.z
    public void z(dl dlVar, String str) {
        if (dlVar == null || str == null) {
            return;
        }
        Set<String> hashSet = this.fo.get(dlVar);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.fo.put(dlVar, hashSet);
        }
        hashSet.add(str);
    }

    @Override // com.bytedance.sdk.component.i.z
    public void g(dl dlVar, String str) {
        Set<String> set;
        if (dlVar == null || str == null || (set = this.fo.get(dlVar)) == null) {
            return;
        }
        set.remove(str);
    }

    public long getCreateDuration() {
        return this.m;
    }

    protected void z(Runnable runnable) {
        z(runnable, false);
    }

    protected void z(final Runnable runnable, boolean z) {
        if (gc()) {
            runnable.run();
        } else if (z) {
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.5
                @Override // java.lang.Runnable
                public void run() {
                    if (MultiWebview.this.gc()) {
                        runnable.run();
                    } else {
                        gz.g().post(runnable);
                    }
                }
            });
        } else {
            gz.g().post(runnable);
        }
    }

    protected boolean gc() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}

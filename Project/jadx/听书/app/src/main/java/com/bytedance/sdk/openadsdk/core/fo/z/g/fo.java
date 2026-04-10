package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.q;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class fo implements com.bytedance.sdk.component.kb.z.z.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected mc f1045a;
    protected com.bytedance.sdk.openadsdk.core.widget.z.a e;
    private boolean eo;

    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    private na fv;
    protected com.bytedance.sdk.openadsdk.core.i.fo gc;
    com.bytedance.sdk.openadsdk.core.i.gc gz;

    @com.bytedance.sdk.component.kb.g.z(z = "action_type")
    private int h;

    @com.bytedance.sdk.component.kb.g.z(z = "end_card_width")
    private int hh;

    @com.bytedance.sdk.component.kb.g.z(z = "show_type")
    private int io;

    @com.bytedance.sdk.component.kb.g.z(z = "close_button")
    private View iq;

    @com.bytedance.sdk.component.kb.g.z(z = "event_tag")
    private String js;

    @com.bytedance.sdk.component.kb.g.z(z = "end_card_height")
    private int l;
    private double lq;
    protected String m;
    private double mc;

    @com.bytedance.sdk.component.kb.g.z(z = "web_view")
    private WeakReference<SSWebView> p;

    @com.bytedance.sdk.component.kb.g.z(z = "extra_map")
    private Map<String, Object> q;

    @com.bytedance.sdk.component.kb.g.z(z = "orientation")
    private int sy;

    @com.bytedance.sdk.component.kb.g.z(z = "is_reward")
    private boolean tb;
    private String ti;

    @com.bytedance.sdk.component.kb.g.z(z = "end_card_param")
    private com.bytedance.sdk.openadsdk.core.fo.z.dl.z uf;
    private double un;
    private double x;

    @com.bytedance.sdk.component.kb.g.z(z = TTDownloadField.TT_ACTIVITY)
    protected TTBaseVideoActivity z;

    @com.bytedance.sdk.component.kb.g.z(z = "download_listener")
    private DownloadListener zw;
    private final Map<String, Bitmap> gk = new HashMap();
    int g = 0;
    int dl = 0;
    int fo = 0;
    String uy = "";
    protected boolean kb = false;
    protected boolean wp = false;
    protected final AtomicBoolean i = new AtomicBoolean(true);
    private Handler oq = new Handler(Looper.myLooper()) { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    fo.this.i();
                    break;
                case 2:
                    fo.this.gc();
                    break;
                case 3:
                    fo.this.e();
                    break;
                case 4:
                    fo.this.gz();
                    break;
                case 5:
                    fo.this.fo();
                    break;
                case 6:
                    fo.this.uy();
                    break;
                case 7:
                    fo.this.kb();
                    break;
                case 8:
                    fo.this.wp();
                    break;
                case 9:
                    fo.this.v();
                    break;
                case 10:
                    fo.this.pf();
                    break;
                case 11:
                    fo.this.ls();
                    break;
                case 12:
                    fo.this.p();
                    break;
                case 13:
                    fo.this.fv();
                    break;
                case 14:
                    fo.this.js();
                    break;
            }
        }
    };
    protected AtomicBoolean v = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.js.z pf = new com.bytedance.sdk.openadsdk.core.js.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.6
        @Override // com.bytedance.sdk.openadsdk.core.js.z
        public int z() {
            SSWebView sSWebView = fo.this.p != null ? (SSWebView) fo.this.p.get() : null;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? oq.gc((Context) fo.this.z) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.core.js.z
        public int g() {
            SSWebView sSWebView = fo.this.p != null ? (SSWebView) fo.this.p.get() : null;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? oq.a((Context) fo.this.z) : measuredWidth;
        }
    };
    protected com.bytedance.sdk.openadsdk.core.js.m ls = new com.bytedance.sdk.openadsdk.core.js.m() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.7
        @Override // com.bytedance.sdk.openadsdk.core.js.m
        public void z() {
            SSWebView sSWebView = fo.this.p != null ? (SSWebView) fo.this.p.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }

        @Override // com.bytedance.sdk.openadsdk.core.js.m
        public void g() {
            SSWebView sSWebView = fo.this.p != null ? (SSWebView) fo.this.p.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }
    };
    private final com.bytedance.sdk.openadsdk.core.js.g wj = new com.bytedance.sdk.openadsdk.core.js.g() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.8
        @Override // com.bytedance.sdk.openadsdk.core.js.g
        public void z(boolean z, int i, String str) {
            if (z) {
                fo.this.wp = true;
                if (fo.this.eo) {
                    fo foVar = fo.this;
                    foVar.z(foVar.x, fo.this.lq, fo.this.mc, fo.this.un, fo.this.ti);
                    fo.this.eo = false;
                }
            }
            if (tf.uy(fo.this.fv)) {
                fo.this.z(z, i, str);
            }
        }
    };
    private final com.bytedance.sdk.openadsdk.uy.z na = new com.bytedance.sdk.openadsdk.uy.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.9
        @Override // com.bytedance.sdk.openadsdk.uy.z
        public void z() {
            fo.this.z.gz(1);
        }
    };

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        if (this.h != 0) {
            m();
            return true;
        }
        z();
        g();
        dl();
        tb();
        return true;
    }

    private void tb() {
        com.bytedance.sdk.openadsdk.core.fo.z.dl.z zVar = this.uf;
        if (zVar == null) {
            return;
        }
        zVar.z(new com.bytedance.sdk.openadsdk.core.fo.z.dl.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.10
        });
    }

    public void z(boolean z, int i, String str) {
        com.bytedance.sdk.openadsdk.core.i.fo foVar = this.gc;
        if (foVar == null) {
            return;
        }
        if (z) {
            foVar.g();
        } else {
            foVar.z(i, str);
        }
    }

    protected void z() {
        final SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.p;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SSWebView sSWebView2 = sSWebView;
                if (sSWebView2 == null || sSWebView2.getViewTreeObserver() == null) {
                    return;
                }
                sSWebView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int measuredWidth = sSWebView.getMeasuredWidth();
                int measuredHeight = sSWebView.getMeasuredHeight();
                if (sSWebView.getVisibility() == 0) {
                    fo.this.z(measuredWidth, measuredHeight);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, int i2) {
        if (this.f1045a == null || this.z.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediaFormat.KEY_WIDTH, i);
            jSONObject.put(MediaFormat.KEY_HEIGHT, i2);
            this.f1045a.z("resize", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public void g() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.p;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.i.fo foVar = new com.bytedance.sdk.openadsdk.core.i.fo(this.js, this.fv, jSONObject);
        this.gc = foVar;
        foVar.z(jSONObject, "webview_source", (Object) 2);
        com.bytedance.sdk.openadsdk.core.i.gc gcVarG = new com.bytedance.sdk.openadsdk.core.i.gc(this.fv, sSWebView).g(true);
        this.gz = gcVarG;
        gcVarG.z(true);
        q();
        this.gz.z(a() ? "landingpage_endcard" : this.tb ? "reward_endcard" : "fullscreen_endcard");
        mc mcVar = new mc(this.z) { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.12
        };
        this.f1045a = mcVar;
        mcVar.g(sSWebView).z(this.fv).g(this.fv.mj()).a(this.fv.vk()).dl(this.tb ? 7 : 5).z(this.pf).gc(eo.ls(this.fv)).z(sSWebView).g(com.bytedance.sdk.openadsdk.core.kb.dl.uy.z(this.fv)).z(this.gc).z(this.js).z(this.q).z(this.ls).z(this.iq).z(this.na);
        this.f1045a.z(this.wj);
    }

    private void q() {
        this.m = tf.gz(this.fv);
        float fTk = this.fv.tk();
        if (TextUtils.isEmpty(this.m)) {
            return;
        }
        if (this.sy == 1) {
            if (this.m.contains("?")) {
                this.m += "&orientation=portrait";
            } else {
                this.m += "?orientation=portrait";
            }
        }
        if (this.m.contains("?")) {
            this.m += "&height=" + this.l + "&width=" + this.hh + "&aspect_ratio=" + fTk;
        } else {
            this.m += "?height=" + this.l + "&width=" + this.hh + "&aspect_ratio=" + fTk;
        }
        this.m = com.bytedance.sdk.openadsdk.core.component.reward.gc.z.z(this.m);
    }

    public void dl() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.p;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.z.a aVar = new com.bytedance.sdk.openadsdk.core.widget.z.a(this.z, this.f1045a, this.fv.mj(), this.gz) { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.13
            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse webResourceResponseZ = fo.this.z(str);
                return webResourceResponseZ != null ? webResourceResponseZ : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (fo.this.fv != null) {
                        WebResourceResponse webResourceResponseZ = fo.this.z(string);
                        if (webResourceResponseZ != null) {
                            return webResourceResponseZ;
                        }
                        if (TextUtils.isEmpty(fo.this.fv.pd())) {
                            return super.shouldInterceptRequest(webView, string);
                        }
                        fo.this.g++;
                        return super.shouldInterceptRequest(webView, string);
                    }
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                fo.this.i.set(false);
                fo.this.fo = i;
                fo.this.uy = str;
                if (fo.this.gc != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i);
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                        fo.this.gc.g(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    fo.this.i.set(false);
                }
                if (fo.this.gc != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceError.getErrorCode());
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                        fo.this.gc.g(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                fo.this.fo = webResourceError.getErrorCode();
                fo.this.uy = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (fo.this.gc != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        fo.this.gc.g(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (fo.this.m.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        fo.this.i.set(false);
                    }
                    if (webResourceResponse != null) {
                        fo.this.fo = webResourceResponse.getStatusCode();
                        fo.this.uy = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (fo.this.gc != null) {
                    fo.this.gc.e();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (fo.this.gc != null) {
                    fo.this.gc.m();
                }
                super.onPageStarted(webView, str, bitmap);
            }
        };
        this.e = aVar;
        sSWebView.setWebViewClient(aVar);
        z(sSWebView);
        sSWebView.setBackgroundColor(-1);
        sSWebView.setDisplayZoomControls(false);
        sSWebView.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.z.dl(this.f1045a, this.gz) { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.z.dl, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        sSWebView.setDownloadListener(this.zw);
    }

    protected void z(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.z.g.z(this.z).z(false).g(false).z(sSWebView);
        q.z(sSWebView, gk.dl, na.a(this.fv));
        oq.z((com.bytedance.sdk.component.i.dl) sSWebView);
        sSWebView.setMixedContentMode(0);
    }

    protected boolean a() {
        String str = this.m;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void gc() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.p;
        if (weakReference == null || (sSWebView = weakReference.get()) == null || this.kb) {
            return;
        }
        sSWebView.loadUrl(this.m);
        this.kb = true;
    }

    public void m() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.p;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        oq.z((View) sSWebView, 0);
        if (this.io == 1) {
            oq.z((View) sSWebView, 0.0f);
        }
        if (this.io == 2) {
            iq();
        }
        mc mcVar = this.f1045a;
        if (mcVar != null) {
            mcVar.z(eo.ls(this.fv), false);
        }
        z(true);
        g(true);
        z(false, true);
    }

    public void z(boolean z) {
        if (this.f1045a == null || this.z.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.f1045a.z("viewableChange", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public void z(boolean z, boolean z2) {
        if (this.f1045a == null || this.z.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.f1045a.z("endcard_control_event", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public void g(boolean z) {
        if (this.f1045a == null || this.z.isFinishing()) {
            return;
        }
        try {
            this.f1045a.m(z);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    private void iq() {
        WeakReference<SSWebView> weakReference;
        if (this.v.getAndSet(true) || (weakReference = this.p) == null) {
            return;
        }
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(weakReference.get(), "translationY", oq.gc((Context) this.z), 0.0f);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    fo.this.v.set(false);
                }
            });
            objectAnimatorOfFloat.start();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public void z(double d, double d2, double d3, double d4, String str) {
        if (this.f1045a == null || this.z.isFinishing()) {
            return;
        }
        if (!this.wp) {
            this.x = d;
            this.lq = d2;
            this.un = d4;
            this.mc = d3;
            this.ti = str;
            this.eo = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put(MediaFormat.KEY_WIDTH, d3);
            jSONObject.put(MediaFormat.KEY_HEIGHT, d4);
            jSONObject.put("videoFrameKey", str);
            this.f1045a.z("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse z(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.gk.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    public void e() {
        com.bytedance.sdk.openadsdk.core.i.gc gcVar = this.gz;
        if (gcVar != null) {
            gcVar.z(System.currentTimeMillis());
        }
    }

    public void gz() {
        if (this.z.gb() instanceof com.bytedance.sdk.openadsdk.core.component.reward.a.fo) {
            zw();
            return;
        }
        WeakReference<SSWebView> weakReference = this.p;
        if (weakReference == null) {
            return;
        }
        oq.z((View) weakReference.get(), 8);
    }

    private void zw() {
        WeakReference<SSWebView> weakReference;
        final SSWebView sSWebView;
        if (this.v.getAndSet(true) || (weakReference = this.p) == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(sSWebView, "translationY", 0.0f, oq.gc((Context) this.z));
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                oq.z((View) sSWebView, 8);
                fo.this.v.set(false);
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void fo() {
        this.gc = null;
    }

    public void uy() {
        WeakReference<SSWebView> weakReference = this.p;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        mc mcVar = this.f1045a;
        if (mcVar != null) {
            mcVar.hh();
            if (sSWebView != null) {
                if (sSWebView.getVisibility() == 0) {
                    this.f1045a.m(true);
                    z(true);
                    z(false, true);
                } else {
                    this.f1045a.m(false);
                    z(false);
                    z(true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.i.gc gcVar = this.gz;
        if (gcVar != null) {
            gcVar.a();
        }
        com.bytedance.sdk.openadsdk.core.widget.z.a aVar = this.e;
        if (aVar != null) {
            aVar.g(false);
        }
    }

    public void kb() {
        WeakReference<SSWebView> weakReference = this.p;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        mc mcVar = this.f1045a;
        if (mcVar != null) {
            mcVar.l();
            this.f1045a.m(false);
            z(false);
            z(true, false);
        }
        com.bytedance.sdk.openadsdk.core.widget.z.a aVar = this.e;
        if (aVar != null) {
            aVar.dl();
        }
    }

    public void wp() {
        com.bytedance.sdk.openadsdk.core.i.gc gcVar = this.gz;
        if (gcVar != null) {
            gcVar.gc();
        }
    }

    public void i() {
        WeakReference<SSWebView> weakReference = this.p;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.oq.z(this.z, sSWebView);
            com.bytedance.sdk.openadsdk.core.oq.z(sSWebView);
            sSWebView.destroy();
        }
        WeakReference<SSWebView> weakReference2 = this.p;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        mc mcVar = this.f1045a;
        if (mcVar != null) {
            mcVar.h();
        }
        com.bytedance.sdk.openadsdk.core.i.fo foVar = this.gc;
        if (foVar != null) {
            foVar.z(true);
            this.gc.ls();
        }
        com.bytedance.sdk.openadsdk.core.i.gc gcVar = this.gz;
        if (gcVar != null) {
            gcVar.m();
        }
        this.gk.clear();
    }

    public void v() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.p;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.onResume();
        sSWebView.resumeTimers();
        oq.z((View) sSWebView, 1.0f);
        io();
    }

    private void io() {
        mc mcVar = this.f1045a;
        if (mcVar == null) {
            return;
        }
        mcVar.z(new SSWebView.g() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.fo.5
            @Override // com.bytedance.sdk.component.widget.SSWebView.g
            public void z(int i) {
                if (fo.this.f1045a != null) {
                    fo.this.f1045a.z(i);
                }
            }
        });
    }

    public void pf() {
        com.bytedance.sdk.openadsdk.core.i.fo foVar = this.gc;
        if (foVar != null) {
            foVar.fo();
        }
    }

    public void ls() {
        com.bytedance.sdk.openadsdk.core.i.fo foVar = this.gc;
        if (foVar != null) {
            foVar.kb();
        }
    }

    public void p() {
        com.bytedance.sdk.openadsdk.core.i.fo foVar = this.gc;
        if (foVar != null) {
            foVar.wp();
        }
    }

    public void fv() {
        com.bytedance.sdk.openadsdk.core.i.fo foVar = this.gc;
        if (foVar != null) {
            foVar.dl();
            this.gc.a();
        }
    }

    public void js() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.p;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.loadUrl("about:blank");
    }
}

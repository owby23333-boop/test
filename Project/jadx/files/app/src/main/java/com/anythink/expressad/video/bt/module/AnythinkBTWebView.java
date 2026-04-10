package com.anythink.expressad.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.anythink.expressad.atsignalcommon.a.a;
import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.signal.a.j;
import com.anythink.expressad.videocommon.e.d;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkBTWebView extends BTBaseView implements IMraidJSBridge {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f11535s = "portrait";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f11536t = "landscape";
    private j A;
    private WebView B;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f11537p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f11538q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f11539r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f11540u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f11541v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f11542w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private d f11543x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List<c> f11544y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private WindVaneWebView f11545z;

    public AnythinkBTWebView(Context context) {
        super(context);
        this.f11540u = false;
        this.f11542w = false;
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.f11545z != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", BTBaseView.f11546n);
                jSONObject2.put("id", this.f11550d);
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.f11545z, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a((WebView) this.f11545z, "broadcast", this.f11550d);
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void close() {
        WebView webView = this.B;
        if (webView != null) {
            BTBaseView.a(webView, "onPlayerCloseBtnClicked", this.f11550d);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void expand(String str, boolean z2) {
    }

    public List<c> getCampaigns() {
        return this.f11544y;
    }

    public String getFilePath() {
        return this.f11538q;
    }

    public String getFileURL() {
        return this.f11537p;
    }

    public String getHtml() {
        return this.f11539r;
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public c getMraidCampaign() {
        return this.b;
    }

    public d getRewardUnitSetting() {
        return this.f11543x;
    }

    public WindVaneWebView getWebView() {
        return this.f11545z;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void init(Context context) {
        this.f11545z = new WindVaneWebView(context);
        this.f11545z.setBackgroundColor(0);
        this.f11545z.setVisibility(0);
        this.A = new j(null, this.b, this.f11544y);
        this.A.a(this.f11549c);
        this.f11545z.setObject(this.A);
        this.f11545z.setMraidObject(this);
        this.f11545z.setWebViewListener(new a() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTWebView.1
            @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
            public final void a(Object obj) {
                super.a(obj);
                try {
                    String strEncodeToString = "";
                    String strI = AnythinkBTWebView.this.A != null ? AnythinkBTWebView.this.A.i() : "";
                    if (TextUtils.isEmpty(strI)) {
                        o.a("RVWindVaneWebView", "getEndScreenInfo failed");
                    } else {
                        strEncodeToString = Base64.encodeToString(strI.getBytes(), 2);
                        o.a("RVWindVaneWebView", "getEndScreenInfo success");
                    }
                    com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, strEncodeToString);
                } catch (Throwable th) {
                    o.a("RVWindVaneWebView", th.getMessage());
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (AnythinkBTWebView.this.B != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", AnythinkBTWebView.this.f11550d);
                        jSONObject.put("code", BTBaseView.f11546n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", AnythinkBTWebView.this.f11550d);
                        jSONObject2.put("result", 1);
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTWebView.this.B, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e2) {
                        com.anythink.expressad.video.bt.a.c.a();
                        com.anythink.expressad.video.bt.a.c.a(AnythinkBTWebView.this.B, e2.getMessage());
                        o.a("RVWindVaneWebView", e2.getMessage());
                    }
                }
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTWebView.this.f11545z);
            }

            @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                if (AnythinkBTWebView.this.B != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", AnythinkBTWebView.this.f11550d);
                        jSONObject.put("code", BTBaseView.f11546n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", AnythinkBTWebView.this.f11550d);
                        jSONObject2.put("result", 2);
                        jSONObject2.put("error", str);
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTWebView.this.B, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e2) {
                        com.anythink.expressad.video.bt.a.c.a();
                        com.anythink.expressad.video.bt.a.c.a(AnythinkBTWebView.this.B, e2.getMessage());
                        o.a("RVWindVaneWebView", e2.getMessage());
                    }
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                if (AnythinkBTWebView.this.B != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", AnythinkBTWebView.this.f11550d);
                        jSONObject.put("code", BTBaseView.f11546n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", AnythinkBTWebView.this.f11550d);
                        jSONObject2.put("result", 2);
                        jSONObject2.put("error", sslError.toString());
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTWebView.this.B, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e2) {
                        com.anythink.expressad.video.bt.a.c.a();
                        com.anythink.expressad.video.bt.a.c.a(AnythinkBTWebView.this.B, e2.getMessage());
                        o.a("RVWindVaneWebView", e2.getMessage());
                    }
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
            public final void readyState(WebView webView, int i2) {
                super.readyState(webView, i2);
            }
        });
        addView(this.f11545z, new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTWebView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (AnythinkBTWebView.this.B != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.f11546n);
                        jSONObject.put("id", AnythinkBTWebView.this.f11550d);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", String.valueOf(view.getX()));
                        jSONObject2.put("y", String.valueOf(view.getY()));
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTWebView.this.B, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception unused) {
                        com.anythink.expressad.video.bt.a.c.a();
                        com.anythink.expressad.video.bt.a.c.a(AnythinkBTWebView.this.B, "onClicked", AnythinkBTWebView.this.f11550d);
                    }
                }
            }
        });
        try {
            this.f11541v = new ImageView(getContext());
            this.f11541v.setImageResource(findDrawable("anythink_reward_close"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
            layoutParams.gravity = 8388661;
            layoutParams.setMargins(30, 30, 30, 30);
            this.f11541v.setLayoutParams(layoutParams);
            this.f11541v.setVisibility(this.f11540u ? 4 : 8);
            if (this.b != null && this.b.H()) {
                this.f11541v.setVisibility(4);
            }
            this.f11541v.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTWebView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnythinkBTWebView.this.close();
                }
            });
            addView(this.f11541v);
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void notifyEvent(String str) {
        WindVaneWebView windVaneWebView = this.f11545z;
        if (windVaneWebView != null) {
            BTBaseView.a(windVaneWebView, str, this.f11550d);
        }
    }

    public void onBackPressed() {
        if (this.f11545z != null) {
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a((WebView) this.f11545z, "onSystemBackPressed", this.f11550d);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f11545z != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (configuration.orientation == 2) {
                    jSONObject.put("orientation", f11536t);
                } else {
                    jSONObject.put("orientation", f11535s);
                }
                jSONObject.put("instanceId", this.f11550d);
                String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.f11545z, "orientation", strEncodeToString);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onDestory() {
        if (this.f11542w) {
            return;
        }
        this.f11542w = true;
        try {
            if (this.f11545z != null) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a((WebView) this.f11545z, "onSystemDestory", this.f11550d);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTWebView.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (AnythinkBTWebView.this.f11545z != null) {
                            AnythinkBTWebView.this.f11545z.clearWebView();
                            AnythinkBTWebView.this.f11545z.release();
                        }
                        AnythinkBTWebView.this.f11537p = null;
                        AnythinkBTWebView.this.f11538q = null;
                        AnythinkBTWebView.this.f11539r = null;
                        if (AnythinkBTWebView.this.B != null) {
                            AnythinkBTWebView.this.B = null;
                        }
                    } catch (Throwable th) {
                        o.a(BTBaseView.TAG, th.getMessage());
                    }
                }
            }, 500L);
            setOnClickListener(null);
            removeAllViews();
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void open(String str) {
        try {
            String strAd = this.b.ad();
            if (!TextUtils.isEmpty(str)) {
                this.b.p(str);
                try {
                    getMraidCampaign();
                } catch (Throwable th) {
                    o.a(BTBaseView.TAG, th.getMessage());
                }
            }
            new com.anythink.expressad.a.a(getContext(), this.f11549c);
            this.b.p(strAd);
        } catch (Throwable th2) {
            o.d(BTBaseView.TAG, th2.getMessage());
        }
    }

    public void preload() {
        if (!TextUtils.isEmpty(this.f11537p)) {
            this.f11545z.loadUrl(this.f11537p);
        } else if (!TextUtils.isEmpty(this.f11538q)) {
            this.f11545z.loadUrl(this.f11538q);
        } else {
            if (TextUtils.isEmpty(this.f11539r)) {
                return;
            }
            this.f11545z.loadDataWithBaseURL("", this.f11539r, "text/html", "UTF-8", null);
        }
    }

    public void setCampaigns(List<c> list) {
        this.f11544y = list;
    }

    public void setCreateWebView(WebView webView) {
        this.B = webView;
    }

    public void setFilePath(String str) {
        this.f11538q = str;
    }

    public void setFileURL(String str) {
        this.f11537p = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean zContains = str.contains("play.google.com");
        setWebviewClickable(!zContains);
        if (zContains) {
            com.anythink.expressad.atsignalcommon.base.c cVar = new com.anythink.expressad.atsignalcommon.base.c();
            WindVaneWebView windVaneWebView = this.f11545z;
            if (windVaneWebView != null) {
                windVaneWebView.setFilter(cVar);
            }
        }
    }

    public void setHtml(String str) {
        this.f11539r = str;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void setRewardUnitSetting(d dVar) {
        this.f11543x = dVar;
    }

    public void setWebViewRid(String str) {
        WindVaneWebView windVaneWebView = this.f11545z;
        if (windVaneWebView != null) {
            windVaneWebView.setRid(str);
        }
    }

    public void setWebviewClickable(boolean z2) {
        WindVaneWebView windVaneWebView = this.f11545z;
        if (windVaneWebView != null) {
            windVaneWebView.setClickable(z2);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void unload() {
        close();
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void useCustomClose(boolean z2) {
        try {
            this.f11541v.setVisibility(z2 ? 4 : 0);
        } catch (Throwable th) {
            o.d(BTBaseView.TAG, th.getMessage());
        }
    }

    public boolean webviewGoBack() {
        WindVaneWebView windVaneWebView = this.f11545z;
        if (windVaneWebView == null || !windVaneWebView.canGoBack()) {
            return false;
        }
        this.f11545z.goBack();
        return true;
    }

    public boolean webviewGoForward() {
        WindVaneWebView windVaneWebView = this.f11545z;
        if (windVaneWebView == null || !windVaneWebView.canGoForward()) {
            return false;
        }
        this.f11545z.goForward();
        return true;
    }

    public void webviewLoad(int i2) {
        if (this.A == null) {
            this.A = new j(null, this.b, this.f11544y);
        }
        c cVar = this.b;
        if (cVar != null) {
            this.A.a(cVar);
        } else {
            List<c> list = this.f11544y;
            if (list != null && list.size() > 0) {
                this.A.a(this.f11544y);
                if (this.f11544y.size() == 1) {
                    this.A.a(this.f11544y.get(0));
                }
            }
        }
        d dVar = this.f11543x;
        if (dVar != null) {
            this.A.a(dVar);
        }
        this.A.a(this.f11549c);
        this.A.c(this.f11550d);
        if (i2 == 1) {
            this.A.q();
        }
        WindVaneWebView windVaneWebView = this.f11545z;
        if (windVaneWebView != null) {
            windVaneWebView.setObject(this.A);
        }
        c cVar2 = this.b;
        if (cVar2 != null && cVar2.H()) {
            this.f11541v.setVisibility(4);
        }
        preload();
    }

    public boolean webviewReload() {
        WindVaneWebView windVaneWebView = this.f11545z;
        if (windVaneWebView == null) {
            return false;
        }
        windVaneWebView.reload();
        return true;
    }

    private void b() {
        try {
            getMraidCampaign();
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public AnythinkBTWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11540u = false;
        this.f11542w = false;
    }

    private void a(com.anythink.expressad.atsignalcommon.base.c cVar) {
        WindVaneWebView windVaneWebView = this.f11545z;
        if (windVaneWebView != null) {
            windVaneWebView.setFilter(cVar);
        }
    }
}

package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.openvk.component.video.z.gc.g;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.i.fo;
import com.bytedance.sdk.openadsdk.core.i.gc;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.kb.dl.uy;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.un.eo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    private double gk;
    private double h;
    private final com.bytedance.sdk.openadsdk.core.js.g hh;
    private double l;
    private String lq;
    private boolean mc;
    private final com.bytedance.sdk.openadsdk.uy.z sy;
    private final Map<String, Bitmap> uf;
    private double x;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public String io() {
        return "endcard";
    }

    public g(TTBaseVideoActivity tTBaseVideoActivity, na naVar, String str, int i, int i2, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, naVar, str, i, i2, z);
        this.uf = new HashMap();
        this.sy = new com.bytedance.sdk.openadsdk.uy.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.g.1
            @Override // com.bytedance.sdk.openadsdk.uy.z
            public void z() {
                g.this.z.gz(1);
            }
        };
        this.hh = new com.bytedance.sdk.openadsdk.core.js.g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.g.2
            @Override // com.bytedance.sdk.openadsdk.core.js.g
            public void z(boolean z2, int i3, String str2) {
                if (z2) {
                    g.this.ls = true;
                    if (g.this.mc) {
                        g gVar = g.this;
                        gVar.z(gVar.l, g.this.h, g.this.gk, g.this.x, g.this.lq);
                        g.this.mc = false;
                    }
                }
                if (tf.uy(g.this.g)) {
                    g.this.z(z2, i3, str2);
                }
            }
        };
        this.e = abstractEndCardFrameLayout.getEndCardWebView();
        z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void z(boolean z, Map<String, Object> map, View view) {
        if (this.e == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        this.fo = new fo(this.dl, this.g, jSONObject);
        this.fo.z(jSONObject, "webview_source", (Object) 2);
        this.wp = new gc(this.g, this.e).g(true);
        this.wp.z(true);
        h();
        this.wp.z(hh() ? "landingpage_endcard" : z ? "reward_endcard" : "fullscreen_endcard");
        this.gz = new mc(this.z);
        this.gz.g(this.e).z(this.g).g(this.g.mj()).a(this.g.vk()).dl(z ? 7 : 5).z(this.zw).gc(eo.ls(this.g)).z(this.e).g(uy.z(this.g)).z(this.fo).z(this.dl).z(map).z(this.io).z(view).dl(this.z.z()).z(this.sy);
        this.gz.z(this.hh);
    }

    private void h() {
        this.uy = tf.gz(this.g);
        float fTk = this.g.tk();
        if (TextUtils.isEmpty(this.uy)) {
            return;
        }
        if (this.js == 1) {
            if (this.uy.contains("?")) {
                this.uy += "&orientation=portrait";
            } else {
                this.uy += "?orientation=portrait";
            }
        }
        if (this.uy.contains("?")) {
            this.uy += "&height=" + this.q + "&width=" + this.tb + "&aspect_ratio=" + fTk;
        } else {
            this.uy += "?height=" + this.q + "&width=" + this.tb + "&aspect_ratio=" + fTk;
        }
        this.uy = com.bytedance.sdk.openadsdk.core.component.reward.gc.z.z(this.uy);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void z(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.g.g gVar) {
        if (this.e == null) {
            return;
        }
        this.kb = new com.bytedance.sdk.openadsdk.core.widget.z.a(this.z, this.gz, this.g.mj(), this.wp) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.g.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse webResourceResponseZ = g.this.z(str);
                return webResourceResponseZ != null ? webResourceResponseZ : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (g.this.g != null) {
                        WebResourceResponse webResourceResponseZ = g.this.z(string);
                        if (webResourceResponseZ != null) {
                            return webResourceResponseZ;
                        }
                        if (TextUtils.isEmpty(g.this.g.pd())) {
                            return super.shouldInterceptRequest(webView, string);
                        }
                        g.this.gc++;
                        return super.shouldInterceptRequest(webView, string);
                    }
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    wp.dl("CommonEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                g.this.p.set(false);
                g.this.fv = this.gz;
                g.this.i = i;
                g.this.v = str;
                if (g.this.fo != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i);
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                        g.this.fo.g(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    g.this.p.set(false);
                    g.this.fv = this.gz;
                }
                if (g.this.fo != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceError.getErrorCode());
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                        g.this.fo.g(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                g.this.i = webResourceError.getErrorCode();
                g.this.v = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (g.this.fo != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        g.this.fo.g(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (g.this.uy.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        g.this.p.set(false);
                        g.this.fv = this.gz;
                    }
                    if (webResourceResponse != null) {
                        g.this.i = webResourceResponse.getStatusCode();
                        g.this.v = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (g.this.fo != null) {
                    g.this.fo.e();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (g.this.fo != null) {
                    g.this.fo.m();
                }
                super.onPageStarted(webView, str, bitmap);
            }
        };
        this.e.setWebViewClient(this.kb);
        z(this.e);
        this.e.setBackgroundColor(-1);
        this.e.setDisplayZoomControls(false);
        this.e.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.z.dl(this.gz, this.wp) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.g.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.z.dl, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        this.e.setDownloadListener(downloadListener);
    }

    protected boolean hh() {
        if (this.uy == null) {
            return false;
        }
        try {
            return Uri.parse(this.uy).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void l() {
        if (this.pf || this.e == null || this.e.getWebView() == null) {
            return;
        }
        this.e.loadUrl(this.uy);
        this.pf = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void z(int i) {
        super.z(i);
        z(true);
        dl(true);
        z(false, true);
    }

    public void z(double d, double d2, double d3, double d4, String str) {
        if (this.gz == null || this.z.isFinishing()) {
            return;
        }
        if (!this.ls) {
            this.l = d;
            this.h = d2;
            this.x = d4;
            this.gk = d3;
            this.lq = str;
            this.mc = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put(MediaFormat.KEY_WIDTH, d3);
            jSONObject.put(MediaFormat.KEY_HEIGHT, d4);
            jSONObject.put("videoFrameKey", str);
            this.gz.z("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void z(v vVar) {
        double dGz;
        double dFo;
        double d;
        double dE;
        if (gb.io(this.g)) {
            double d2 = this.tb;
            double d3 = this.q;
            if (vVar == null || !this.z.gb().e() || (vVar.gz() == 0.0d && vVar.fo() == 0.0d)) {
                dGz = d2;
                dFo = d3;
                d = 0.0d;
                dE = 0.0d;
            } else {
                double dM = vVar.m();
                d = dM;
                dE = vVar.e();
                dGz = vVar.gz();
                dFo = vVar.fo();
            }
            z(d, dE, dGz, dFo, null);
            if (this.z.gb() instanceof com.bytedance.sdk.openadsdk.core.component.reward.a.gc) {
                return;
            }
            final double d4 = d;
            final double d5 = dE;
            final double d6 = dGz;
            final double d7 = dFo;
            com.bykv.vk.openvk.component.video.z.gc.g.z(2147483647L, tf.z(this.g), new g.InterfaceC0035g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.g.5
                @Override // com.bykv.vk.openvk.component.video.z.gc.g.InterfaceC0035g
                public void z(Bitmap bitmap) {
                    if (bitmap != null) {
                        String strValueOf = String.valueOf(bitmap.hashCode());
                        g.this.uf.put(strValueOf, bitmap);
                        g.this.z(d4, d5, d6, d7, strValueOf);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse z(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.uf.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void pf() {
        super.pf();
        this.uf.clear();
    }
}

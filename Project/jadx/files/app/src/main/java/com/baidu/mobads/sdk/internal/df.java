package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.BaiduHybridAdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXHybridAdRenderer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class df extends bf {
    private WebView a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BaiduHybridAdViewListener f13096q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private IXHybridAdRenderer f13097r;

    public df(WebView webView) {
        super(webView.getContext());
        this.a = webView;
        this.a.removeJavascriptInterface("searchBoxJavaBridge_");
        this.a.removeJavascriptInterface("accessibility");
        this.a.removeJavascriptInterface("accessibilityTraversal");
        this.a.getSettings().setAllowContentAccess(false);
        this.a.getSettings().setSavePassword(false);
        this.a.getSettings().setAllowFileAccess(false);
    }

    public void a(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.f13096q = baiduHybridAdViewListener;
    }

    public boolean b(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f13097r;
        if (iXHybridAdRenderer == null) {
            return false;
        }
        return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        super.h(iOAdEvent);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f13096q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdClick(0, null);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void i() {
        this.f13097r = (IXHybridAdRenderer) ar.a(w.f13185j, bp.a(this.f12895h), (Class<?>[]) new Class[]{Context.class}, this.f12895h);
        this.f12898k = this.f13097r;
        if (this.f12899l) {
            return;
        }
        a();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void q() {
        super.q();
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f13096q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdShow(0, null);
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f13097r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        super.b(str, i2);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f13096q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdFailed(0, "", str);
        }
    }

    public void a(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f13097r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageFinished(webView, str);
        }
    }

    public void a(WebView webView, int i2, String str, String str2) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f13097r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedError(webView, i2, str, str2);
        }
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f13097r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.f13097r == null) {
            this.f12899l = false;
            return;
        }
        this.f12899l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            this.f13097r.createProdHandler(jSONObject3);
            n();
            if (!TextUtils.isEmpty(this.f12902o)) {
                jSONObject.put("appid", this.f12902o);
            }
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            jSONObject2.put("timeout", 10000);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f13097r.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        this.f13097r.setCustomerWebView(this.a);
    }
}

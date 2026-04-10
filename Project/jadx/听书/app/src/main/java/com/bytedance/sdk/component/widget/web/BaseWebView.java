package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.i.g;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.wp;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BaseWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected DownloadListener f846a;
    protected WebChromeClient dl;
    protected Boolean e;
    protected Boolean fo;
    protected WebSettings.LayoutAlgorithm fv;
    protected com.bytedance.sdk.component.widget.g g;
    protected Integer gc;
    protected Boolean gz;
    protected g.z h;
    protected Boolean hh;
    protected Boolean i;
    protected Boolean io;
    protected Boolean iq;
    protected Boolean js;
    protected Boolean kb;
    protected Boolean l;
    protected String ls;
    protected View.OnScrollChangeListener m;
    protected Boolean p;
    protected Integer pf;
    protected Boolean q;
    protected Boolean sy;
    protected Boolean tb;
    protected Integer uf;
    protected Boolean uy;
    protected Integer v;
    protected Boolean wp;
    protected Map<String, z> z;
    protected Boolean zw;

    public g.z getOnTouchEventListener() {
        return this.h;
    }

    public Map<String, z> getJavascriptInterfaces() {
        return this.z;
    }

    public com.bytedance.sdk.component.widget.g getClient() {
        return this.g;
    }

    public WebChromeClient getChromeClient() {
        return this.dl;
    }

    public View.OnScrollChangeListener getOnScrollChangeListener() {
        return this.m;
    }

    public Boolean getMediaPlaybackRequiresUserGesture() {
        return this.e;
    }

    public Boolean getSavePassword() {
        return this.gz;
    }

    public Boolean getAllowUniversalAccessFromFileURLs() {
        return this.fo;
    }

    public Boolean getAllowFileAccessFromFileURLs() {
        return this.uy;
    }

    public Boolean getBlockNetworkImage() {
        return this.kb;
    }

    public Boolean getAllowFileAccess() {
        return this.wp;
    }

    public Boolean getDatabaseEnabled() {
        return this.i;
    }

    public Integer getMixedContentMode() {
        return this.v;
    }

    public Integer getDefaultFontSize() {
        return this.pf;
    }

    public String getDefaultTextEncodingName() {
        return this.ls;
    }

    public Boolean getLoadWithOverviewMod() {
        return this.p;
    }

    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.fv;
    }

    public Boolean getBuiltInZoomControls() {
        return this.js;
    }

    public Boolean getDomStorageEnabled() {
        return this.tb;
    }

    public Boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.q;
    }

    public Boolean getSupportZoom() {
        return this.iq;
    }

    public Boolean getUseWideViewPort() {
        return this.zw;
    }

    public Boolean getAppCacheEnabled() {
        return this.io;
    }

    public Integer getCacheMode() {
        return this.uf;
    }

    public Boolean getDisplayZoomControls() {
        return this.sy;
    }

    public Boolean getJavaScriptEnabled() {
        return this.hh;
    }

    public Boolean getNetworkAvailable() {
        return this.l;
    }

    public BaseWebView(Context context) {
        super(context);
        this.m = null;
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = null;
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = null;
    }

    protected void z(Runnable runnable) {
        if (z()) {
            runnable.run();
        } else {
            gz.g().post(runnable);
        }
    }

    protected boolean z() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public DownloadListener getDownloadListener() {
        return this.f846a;
    }

    public Integer getBackgroundColor() {
        return this.gc;
    }

    public void g() {
        this.z = null;
        this.g = null;
        this.dl = null;
        this.f846a = null;
        this.m = null;
        this.gc = null;
        this.e = null;
        this.gz = null;
        this.fo = null;
        this.uy = null;
        this.kb = null;
        this.wp = null;
        this.i = null;
        this.v = null;
        this.pf = null;
        this.ls = null;
        this.p = null;
        this.fv = null;
        this.js = null;
        this.tb = null;
        this.q = null;
        this.iq = null;
        this.zw = null;
        this.io = null;
        this.uf = null;
        this.sy = null;
        this.hh = null;
        this.l = null;
        this.h = null;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        g();
        super.destroy();
    }

    public void z(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", "callback");
            jSONObject2.putOpt("__callback_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            z(str, jSONObject2);
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public void g(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", NotificationCompat.CATEGORY_EVENT);
            jSONObject2.putOpt("__event_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            z(str, jSONObject2);
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void z(String str, JSONObject jSONObject) {
        evaluateJavascript("javascript:" + str + "._handleMessageFromToutiao(" + jSONObject + ")", null);
    }
}

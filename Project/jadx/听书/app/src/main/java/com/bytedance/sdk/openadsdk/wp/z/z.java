package com.bytedance.sdk.openadsdk.wp.z;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.component.g.z.uy;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.umcrash.UMCrash;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    protected String dl;
    protected String e;
    protected String g;
    protected JSONObject m;
    public com.bytedance.sdk.openadsdk.wp.z z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f1500a = new AtomicBoolean(false);
    public AtomicBoolean gc = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.wp.z.z$z, reason: collision with other inner class name */
    public interface InterfaceC0227z {
        void z(boolean z, Map<String, Object> map);
    }

    public abstract void dl();

    public abstract void g(Context context, String str, com.bytedance.sdk.openadsdk.wp.g gVar, WebResourceResponse webResourceResponse, uy uyVar, Map<String, Object> map);

    public abstract void z();

    public abstract void z(Context context, String str, com.bytedance.sdk.openadsdk.wp.g gVar, WebResourceResponse webResourceResponse, uy uyVar, Map<String, Object> map);

    public abstract void z(com.bytedance.sdk.openadsdk.wp.g gVar, WebResourceResponse webResourceResponse, uy uyVar, InterfaceC0227z interfaceC0227z);

    public abstract void z(String str);

    public abstract void z(String str, String str2);

    protected abstract void z(JSONObject jSONObject, String str, uy uyVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2);

    public abstract boolean z(WebView webView);

    public abstract boolean z(uy uyVar);

    public void g() {
        z();
    }

    public z(com.bytedance.sdk.openadsdk.wp.z zVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        this.z = zVar;
        this.g = str;
        this.e = str4;
        this.dl = str2;
        JSONObject jSONObject2 = new JSONObject();
        this.m = jSONObject2;
        try {
            if (this instanceof g) {
                jSONObject2.putOpt(MediationConstant.EXTRA_LOG_EXTRA, str3);
                this.m.putOpt("resource_type", "union");
                this.m.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
            } else if (this instanceof dl) {
                jSONObject2.putOpt(UMCrash.SP_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis() / 1000));
                this.m.putOpt(MediationConstant.EXTRA_ADID, jSONObject.optString(MediationConstant.EXTRA_ADID));
                this.m.putOpt("customer_id", jSONObject.optString("customer_id"));
            }
            this.m.putOpt(CmcdConfiguration.KEY_CONTENT_ID, str);
            this.m.putOpt("ac", Integer.valueOf(v.dl(zw.getContext())));
            this.m.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, com.bytedance.sdk.openadsdk.core.uy.ls().iq());
            this.m.putOpt(PluginConstants.KEY_APP_ID, com.bytedance.sdk.openadsdk.core.uy.ls().q());
            this.m.putOpt("app_version", com.bytedance.sdk.openadsdk.core.gz.z.a());
            this.m.putOpt("sdk_version", gk.f1105a);
            this.m.putOpt(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
            this.m.putOpt("platform", "Android");
            this.m.putOpt("device_id", tb.dl());
            this.m.putOpt("web_url", str4);
        } catch (JSONException e) {
            wp.z(e);
        }
        z(str, str2);
    }
}

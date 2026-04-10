package com.bytedance.sdk.openadsdk.core.q.z;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.q.z.g;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.qq.e.comm.pi.ACTD;
import com.umeng.analytics.pro.an;
import com.umeng.umcrash.UMCrash;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g<T extends g> implements z {
    private String dl;
    private String g;
    private String gc;
    private String gz;
    private String i;
    private String kb;
    private String pf;
    private String uy;
    private String v;
    private String wp;
    private String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1322a = gk.f1105a;
    private long m = System.currentTimeMillis() / 1000;
    private int e = 0;
    private int fo = 0;

    private T fv() {
        return this;
    }

    public static g<g> g() {
        return new g<>();
    }

    @Override // com.bytedance.sdk.openadsdk.core.q.z.z
    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getType())) {
                jSONObject.put("type", getType());
            }
            if (!TextUtils.isEmpty(a())) {
                jSONObject.put("rit", a());
            }
            if (!TextUtils.isEmpty(gc())) {
                jSONObject.put("creative_id", gc());
            }
            if (!TextUtils.isEmpty(m())) {
                jSONObject.put("ad_sdk_version", m());
            }
            if (!TextUtils.isEmpty(gz())) {
                jSONObject.put("app_version", gz());
            } else {
                jSONObject.put("app_version", eo.kb());
            }
            if (fo() > 0) {
                jSONObject.put(UMCrash.SP_KEY_TIMESTAMP, fo());
            }
            if (uy() > 0) {
                jSONObject.put("adtype", uy());
            }
            if (!TextUtils.isEmpty(kb())) {
                jSONObject.put("req_id", kb());
            }
            jSONObject.put("error_code", wp());
            if (!TextUtils.isEmpty(i())) {
                jSONObject.put("error_msg", i());
            }
            if (!TextUtils.isEmpty(v())) {
                jSONObject.put("extra", v());
            }
            if (!TextUtils.isEmpty(pf())) {
                jSONObject.put("image_url", pf());
            }
            if (!TextUtils.isEmpty(dl())) {
                jSONObject.put("event_extra", dl());
            }
            if (!TextUtils.isEmpty(e())) {
                jSONObject.put("duration", e());
            }
            if (!TextUtils.isEmpty(uy.ls().q())) {
                jSONObject.put(ACTD.APPID_KEY, uy.ls().q());
            }
            if (!TextUtils.isEmpty(ls())) {
                jSONObject.put("ad_info", ls());
            }
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
            jSONObject.put("is_plugin", gk.z());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("conn_type", v.g(zw.getContext()));
        } catch (Exception e) {
            wp.z(e);
        }
        try {
            jSONObject.put("device_info", p());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(an.x, 1);
            com.bytedance.sdk.openadsdk.pf.g.g(zw.getContext(), jSONObject);
            jSONObject.put("oaid", com.bytedance.sdk.openadsdk.core.un.uy.dl(false));
            jSONObject.put("model", com.bytedance.sdk.openadsdk.core.un.uy.g());
            jSONObject.put("android_id", com.bytedance.sdk.openadsdk.core.un.uy.z());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(an.o, eo.fo());
            jSONObject.put(com.umeng.analytics.pro.z.d, com.bytedance.sdk.openadsdk.core.un.uy.i());
            jSONObject.put("applog_did", com.bytedance.sdk.openadsdk.core.un.uy.p());
            jSONObject.put("ip", com.bytedance.sdk.openadsdk.core.un.uy.v());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String getType() {
        return this.z;
    }

    public T z(String str) {
        this.z = str;
        return (T) fv();
    }

    public String dl() {
        return this.i;
    }

    public T g(String str) {
        this.i = str;
        return (T) fv();
    }

    public String a() {
        return this.g;
    }

    public T dl(String str) {
        this.g = str;
        return (T) fv();
    }

    public String gc() {
        return this.dl;
    }

    public T a(String str) {
        this.dl = str;
        return (T) fv();
    }

    public String m() {
        return this.f1322a;
    }

    public String e() {
        return this.v;
    }

    public T gc(String str) {
        this.v = str;
        return (T) fv();
    }

    public String gz() {
        return this.gc;
    }

    public long fo() {
        return this.m;
    }

    public T z(long j) {
        this.m = j;
        return (T) fv();
    }

    public int uy() {
        return this.e;
    }

    public T z(int i) {
        this.e = i;
        return (T) fv();
    }

    public String kb() {
        return this.gz;
    }

    public T m(String str) {
        this.gz = str;
        return (T) fv();
    }

    public int wp() {
        return this.fo;
    }

    public T g(int i) {
        this.fo = i;
        return (T) fv();
    }

    public String i() {
        return this.uy;
    }

    public T e(String str) {
        this.uy = str;
        return (T) fv();
    }

    public String v() {
        return this.kb;
    }

    public T gz(String str) {
        this.kb = str;
        return (T) fv();
    }

    public String pf() {
        return this.wp;
    }

    public String ls() {
        return this.pf;
    }

    public T fo(String str) {
        this.pf = str;
        return (T) fv();
    }
}

package com.bytedance.sdk.openadsdk.core.iq;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1162a;
    private String dl;
    private String e;
    private String g;
    private int gc;
    private int m;
    private String z;

    public String z() {
        return this.e;
    }

    public void z(String str) {
        this.e = str;
    }

    public String g() {
        return this.z;
    }

    public void g(String str) {
        this.z = str;
    }

    public String dl() {
        return this.g;
    }

    public void dl(String str) {
        this.g = str;
    }

    public String a() {
        return this.dl;
    }

    public void a(String str) {
        this.dl = str;
    }

    public int gc() {
        return this.f1162a;
    }

    public void z(int i) {
        this.f1162a = i;
    }

    public int m() {
        return this.gc;
    }

    public void g(int i) {
        this.gc = i;
    }

    public int e() {
        return this.m;
    }

    public void dl(int i) {
        this.m = i;
    }

    public JSONObject gz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, dl());
            jSONObject.put("app_size", e());
            jSONObject.put("comment_num", m());
            jSONObject.put("download_url", g());
            jSONObject.put(an.o, a());
            jSONObject.put("score", gc());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.dl(e.toString());
        }
        return jSONObject;
    }
}

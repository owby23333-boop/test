package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ls {
    private static volatile String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1181a;
    private String dl;
    private String e;
    private boolean fo;
    private String g;
    private JSONObject gc;
    private String gz;
    private int m;

    public static void z(String str) {
        z = str;
    }

    public ls() {
        this.e = "";
        this.gz = "";
    }

    public ls(JSONObject jSONObject) {
        this.e = "";
        this.gz = "";
        if (jSONObject == null) {
            return;
        }
        g(jSONObject.optString("deeplink_url"));
        dl(jSONObject.optString("fallback_url"));
        z(jSONObject.optInt("fallback_type"));
        this.gc = jSONObject.optJSONObject("addon_params");
        this.m = jSONObject.optInt("fallback_landing");
        this.e = jSONObject.optString("fallback_landing_ugen_url");
        this.gz = jSONObject.optString("fallback_landing_ugen_md5");
    }

    public void z(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("deeplink_url", g());
            jSONObject2.put("fallback_url", a());
            jSONObject2.put("fallback_type", gc());
            jSONObject2.put("addon_params", this.gc);
            jSONObject2.put("fallback_landing", this.m);
            jSONObject2.put("fallback_landing_ugen_url", this.e);
            jSONObject2.put("fallback_landing_ugen_md5", this.gz);
            jSONObject.put("deep_link", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public boolean z() {
        return this.fo;
    }

    public void z(boolean z2) {
        this.fo = z2;
    }

    public String g() {
        return a(z);
    }

    public int dl() {
        return this.m;
    }

    private String a(String str) {
        if (this.gc != null && !TextUtils.isEmpty(str) && this.g != null) {
            String strOptString = this.gc.optString(str);
            if (!TextUtils.isEmpty(strOptString)) {
                return this.g + (this.g.contains("?") ? "&" : "?") + strOptString;
            }
        }
        return this.g;
    }

    public void g(String str) {
        this.g = str;
    }

    public String a() {
        return this.dl;
    }

    public void dl(String str) {
        this.dl = str;
    }

    public int gc() {
        return this.f1181a;
    }

    public void z(int i) {
        this.f1181a = i;
    }

    public String m() {
        return this.e;
    }

    public String e() {
        return this.gz;
    }

    public void z(ls lsVar) {
        if (lsVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(lsVar.g())) {
            g(lsVar.g());
        }
        if (!TextUtils.isEmpty(lsVar.a())) {
            dl(lsVar.a());
        }
        if (lsVar.gc() != 0) {
            z(lsVar.gc());
        }
    }
}

package com.bytedance.sdk.openadsdk.core.f;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class vn {
    private static String bh = "timeout";
    private static String m = "keywords0_url";
    private static String s = "keywords0_url_md5";
    private static String t = "custom_url_md5";
    private static String w = "keywords1_url_md5";
    private static String wu = "keywords1_url";
    private static String xu = "key_words";
    private static String zk = "custom_url";
    private String bf;
    private String d;
    private String e;
    private long ga;
    private String p;
    private String tg;
    private String v;
    private String vn;

    private vn() {
    }

    public static vn e(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("kws")) == null) {
            return null;
        }
        String strOptString = jSONObjectOptJSONObject.optString(zk, null);
        String strOptString2 = jSONObjectOptJSONObject.optString(m, null);
        String strOptString3 = jSONObjectOptJSONObject.optString(wu, null);
        String strOptString4 = jSONObjectOptJSONObject.optString(xu, null);
        long jOptLong = jSONObjectOptJSONObject.optLong(bh, 5000L);
        String strOptString5 = jSONObjectOptJSONObject.optString(t, null);
        String strOptString6 = jSONObjectOptJSONObject.optString(s, null);
        String strOptString7 = jSONObjectOptJSONObject.optString(w, null);
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString4) || TextUtils.isEmpty(strOptString5) || TextUtils.isEmpty(strOptString6) || TextUtils.isEmpty(strOptString7)) {
            return null;
        }
        vn vnVar = new vn();
        vnVar.e(strOptString);
        vnVar.tg(strOptString4);
        vnVar.e(jOptLong);
        vnVar.bf(strOptString2);
        vnVar.d(strOptString3);
        vnVar.p(strOptString5);
        vnVar.vn(strOptString6);
        vnVar.ga(strOptString7);
        return vnVar;
    }

    public String bf() {
        return this.e;
    }

    public String d() {
        return this.bf;
    }

    public String ga() {
        return this.vn;
    }

    public String p() {
        return this.v;
    }

    public String tg() {
        return this.d;
    }

    public String vn() {
        return this.p;
    }

    public void bf(String str) {
        this.bf = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void ga(String str) {
        this.vn = str;
    }

    public void p(String str) {
        this.v = str;
    }

    public void tg(String str) {
        this.tg = str;
    }

    public void vn(String str) {
        this.p = str;
    }

    public JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(zk, this.e);
            jSONObject.put(m, this.bf);
            jSONObject.put(wu, this.d);
            jSONObject.put(xu, this.tg);
            jSONObject.put(bh, this.ga);
            jSONObject.put(t, this.v);
            jSONObject.put(s, this.p);
            jSONObject.put(w, this.vn);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void e(String str) {
        this.e = str;
    }

    public void e(long j) {
        this.ga = j;
    }
}

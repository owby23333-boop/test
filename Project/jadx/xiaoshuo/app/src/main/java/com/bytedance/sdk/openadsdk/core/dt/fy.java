package com.bytedance.sdk.openadsdk.core.dt;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class fy {
    private int bf;
    private String d;
    private boolean e;
    private String ga;
    private String[] p;
    private String tg;
    private String vn;

    public long bf() {
        return this.bf;
    }

    public String d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public String ga() {
        return this.vn;
    }

    public String p() {
        String[] strArr = this.p;
        if (strArr == null || strArr.length <= 1) {
            return null;
        }
        return strArr[0];
    }

    public String tg() {
        return this.tg;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gecko_channel", d());
            jSONObject.put("lynx_enable", e());
            jSONObject.put("render_timeout_ctrl", bf());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String v() {
        String[] strArr = this.p;
        if (strArr == null || strArr.length <= 2) {
            return null;
        }
        return strArr[1];
    }

    public String vn() {
        return this.ga;
    }

    public static fy bf(String str) {
        try {
            return e(new JSONObject(str));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wu.tg("LynxConfig", "parse failed:" + e);
            return new fy();
        }
    }

    public void d(String str) {
        this.tg = str;
    }

    public void e(boolean z) {
        this.e = z;
    }

    public void ga(String str) {
        this.ga = str;
    }

    public void tg(String str) {
        this.vn = str;
    }

    public void e(int i) {
        this.bf = i;
    }

    public void e(String str) {
        this.d = str;
    }

    public static fy e(JSONObject jSONObject) {
        fy fyVar = new fy();
        fyVar.e(jSONObject.optString("gecko_channel"));
        fyVar.e(jSONObject.optBoolean("lynx_enable"));
        fyVar.e(jSONObject.optInt("render_timeout_ctrl"));
        return fyVar;
    }

    public void e(String[] strArr) {
        this.p = strArr;
    }
}

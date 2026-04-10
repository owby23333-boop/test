package com.bytedance.sdk.openadsdk.core.iq;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.umeng.analytics.pro.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1170a;
    private String dl;
    private int e;
    private String fo;
    private String fv;
    private String g;
    private boolean gc;
    private long gz;
    private long i;
    private long kb;
    private String ls;
    private int m;
    private String p;
    private String pf;
    private long uy;
    private String v;
    private int wp;
    private long z;

    public static i z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        i iVar = new i();
        iVar.z = jSONObject.optLong("user_id");
        iVar.g = jSONObject.optString("coupon_meta_id");
        iVar.dl = jSONObject.optString("unique_id");
        iVar.f1170a = jSONObject.optLong("device_id");
        iVar.gc = jSONObject.optBoolean("has_coupon");
        iVar.m = jSONObject.optInt("coupon_scene");
        iVar.e = jSONObject.optInt("type");
        iVar.gz = jSONObject.optLong("threshold");
        iVar.fo = jSONObject.optString("scene_key");
        iVar.uy = jSONObject.optLong(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID);
        iVar.kb = jSONObject.optLong("amount");
        iVar.wp = jSONObject.optInt("action");
        iVar.i = jSONObject.optLong(TtmlNode.TAG_STYLE);
        iVar.v = jSONObject.optString(d.p);
        iVar.pf = jSONObject.optString("expire_time");
        iVar.ls = jSONObject.optString("button_text");
        iVar.p = jSONObject.optString("extra");
        iVar.fv = jSONObject.optString("toast");
        return iVar;
    }

    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.z);
            jSONObject.put("coupon_meta_id", this.g);
            jSONObject.put("unique_id", this.dl);
            jSONObject.put("device_id", this.f1170a);
            jSONObject.put("has_coupon", this.gc);
            jSONObject.put("coupon_scene", this.m);
            jSONObject.put("type", this.e);
            jSONObject.put("threshold", this.gz);
            jSONObject.put("scene_key", this.fo);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.uy);
            jSONObject.put("amount", this.kb);
            jSONObject.put("action", this.wp);
            jSONObject.put(TtmlNode.TAG_STYLE, this.i);
            jSONObject.put(d.p, this.v);
            jSONObject.put("expire_time", this.pf);
            jSONObject.put("button_text", this.ls);
            jSONObject.put("extra", this.p);
            jSONObject.put("toast", this.fv);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.z);
            jSONObject.put("coupon_meta_id", this.g);
            jSONObject.put("unique_id", this.dl);
            jSONObject.put("device_id", this.f1170a);
            jSONObject.put("type", this.e);
            jSONObject.put("scene_key", this.fo);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.uy);
            jSONObject.put("value", this.kb);
            jSONObject.put("threshold", this.gz);
            jSONObject.put("extra", this.p);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject;
    }

    public int dl() {
        return this.m;
    }

    public int getType() {
        return this.e;
    }

    public String a() {
        return this.fv;
    }

    public boolean z(boolean z) {
        int i;
        boolean z2 = this.gc && this.kb > 0;
        if (z) {
            if (z2 && ((i = this.m) == 0 || i == 5)) {
                return true;
            }
        } else if (z2 && this.m == 5) {
            return true;
        }
        return false;
    }
}

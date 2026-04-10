package com.bytedance.sdk.openadsdk.core.dt;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.iflytek.aikit.media.param.MscKeys;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.xiaomi.verificationsdk.internal.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class bh {
    private String bf;
    private long bh;
    private String d;
    private long e;
    private String f;
    private boolean ga;
    private String l;
    private long m;
    private int p;
    private String s;
    private String t;
    private long tg;
    private long v;
    private int vn;
    private String w;
    private long wu;
    private int xu;
    private String zk;

    public static bh e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bh bhVar = new bh();
        bhVar.e = jSONObject.optLong("user_id");
        bhVar.bf = jSONObject.optString("coupon_meta_id");
        bhVar.d = jSONObject.optString(MscKeys.UNIQUE_ID);
        bhVar.tg = jSONObject.optLong(Constants.DEVICE_ID);
        bhVar.ga = jSONObject.optBoolean("has_coupon");
        bhVar.vn = jSONObject.optInt("coupon_scene");
        bhVar.p = jSONObject.optInt("type");
        bhVar.v = jSONObject.optLong("threshold");
        bhVar.zk = jSONObject.optString("scene_key");
        bhVar.m = jSONObject.optLong(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID);
        bhVar.wu = jSONObject.optLong("amount");
        bhVar.xu = jSONObject.optInt("action");
        bhVar.bh = jSONObject.optLong(TtmlNode.TAG_STYLE);
        bhVar.t = jSONObject.optString("start_time");
        bhVar.s = jSONObject.optString("expire_time");
        bhVar.w = jSONObject.optString("button_text");
        bhVar.l = jSONObject.optString("extra");
        bhVar.f = jSONObject.optString("toast");
        return bhVar;
    }

    public JSONObject bf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.e);
            jSONObject.put("coupon_meta_id", this.bf);
            jSONObject.put(MscKeys.UNIQUE_ID, this.d);
            jSONObject.put(Constants.DEVICE_ID, this.tg);
            jSONObject.put("type", this.p);
            jSONObject.put("scene_key", this.zk);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.m);
            jSONObject.put("value", this.wu);
            jSONObject.put("threshold", this.v);
            jSONObject.put("extra", this.l);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public int d() {
        return this.vn;
    }

    public boolean ga() {
        return this.ga && this.wu > 0;
    }

    public int getType() {
        return this.p;
    }

    public String tg() {
        return this.f;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.e);
            jSONObject.put("coupon_meta_id", this.bf);
            jSONObject.put(MscKeys.UNIQUE_ID, this.d);
            jSONObject.put(Constants.DEVICE_ID, this.tg);
            jSONObject.put("has_coupon", this.ga);
            jSONObject.put("coupon_scene", this.vn);
            jSONObject.put("type", this.p);
            jSONObject.put("threshold", this.v);
            jSONObject.put("scene_key", this.zk);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.m);
            jSONObject.put("amount", this.wu);
            jSONObject.put("action", this.xu);
            jSONObject.put(TtmlNode.TAG_STYLE, this.bh);
            jSONObject.put("start_time", this.t);
            jSONObject.put("expire_time", this.s);
            jSONObject.put("button_text", this.w);
            jSONObject.put("extra", this.l);
            jSONObject.put("toast", this.f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

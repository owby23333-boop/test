package com.bytedance.sdk.openadsdk.core.component.reward.dl;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.umeng.analytics.pro.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends z {
    private int fv;
    private String js;
    private int p;
    private String tb;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public int e() {
        return 6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    protected float gz() {
        return 0.55f;
    }

    a(Activity activity, na naVar, bm bmVar) {
        JSONObject jSONObjectOptJSONObject;
        super(activity, naVar, bmVar);
        JSONObject jSONObjectG = bmVar.g();
        if (jSONObjectG == null || (jSONObjectOptJSONObject = jSONObjectG.optJSONObject("coupon")) == null) {
            return;
        }
        this.p = jSONObjectOptJSONObject.optInt("amount");
        this.fv = jSONObjectOptJSONObject.optInt("threshold");
        this.js = jSONObjectOptJSONObject.optString(d.p);
        this.tb = jSONObjectOptJSONObject.optString("expire_time");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public boolean m() {
        return (this.p == 0 || this.fv == 0) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z g(uy uyVar) {
        return dl(uyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public String z() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("amount", this.p);
            jSONObject.put("threshold", "满" + this.fv + "元可用");
            if (TextUtils.isEmpty(this.js)) {
                str = TextUtils.isEmpty(this.tb) ? "领取当日起30分钟内有效" : "有效期至" + this.tb;
            } else if (TextUtils.isEmpty(this.tb)) {
                str = "有效期至" + this.js;
            } else {
                str = "有效期" + this.js + "至" + this.tb;
            }
            jSONObject.put(d.p, this.js);
            jSONObject.put("expire_text", str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject.toString();
    }
}

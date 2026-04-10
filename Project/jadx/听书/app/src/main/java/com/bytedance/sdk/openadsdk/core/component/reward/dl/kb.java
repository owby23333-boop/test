package com.bytedance.sdk.openadsdk.core.component.reward.dl;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kb extends z {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public int e() {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    protected float gz() {
        return 0.75f;
    }

    kb(Activity activity, na naVar, bm bmVar) {
        super(activity, naVar, bmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public boolean m() {
        if (gb.dl(this.e)) {
            return (Integer.parseInt(this.wp) == 0 || TextUtils.isEmpty(this.wp) || TextUtils.isEmpty(this.kb)) ? false : true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z g(uy uyVar) {
        return dl(uyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public String z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "继续观看 " + this.z + "s 可获得奖励");
            jSONObject.put("number", this.wp);
            jSONObject.put("number_unit", this.kb);
            jSONObject.put("remain_time", this.z);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject.toString();
    }
}

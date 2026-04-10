package com.bytedance.sdk.openadsdk.core.component.reward.dl;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.na;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends z {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public int e() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    protected float gz() {
        return 0.75f;
    }

    wp(Activity activity, na naVar, bm bmVar) {
        super(activity, naVar, bmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z g(uy uyVar) {
        return dl(uyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public String z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "距离领取奖励还剩");
            jSONObject.put("number", this.z);
            jSONObject.put("number_unit", "秒");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject.toString();
    }
}

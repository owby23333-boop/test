package com.bytedance.sdk.openadsdk.core.component.reward.business.g.z;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.uy;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public int e() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    protected float gz() {
        return 0.75f;
    }

    public dl(Activity activity, na naVar, bm bmVar) {
        super(activity, naVar, bmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public boolean m() {
        return (TextUtils.isEmpty(this.kb) || TextUtils.isEmpty(this.wp)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z z(uy uyVar) {
        return dl(uyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public String z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.REWARD_NAME, this.kb);
            jSONObject.put(MediationConstant.REWARD_AMOUNT, this.wp);
            jSONObject.put("extra_info", this.z);
        } catch (JSONException e) {
            wp.z(e);
        }
        return jSONObject.toString();
    }
}

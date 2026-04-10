package com.bytedance.sdk.openadsdk.core.component.reward.dl;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.uf;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends z {
    private String p;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public int e() {
        return 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    protected float gz() {
        return 0.6f;
    }

    fo(Activity activity, na naVar, bm bmVar) {
        super(activity, naVar, bmVar);
        uf ufVarKs = this.e.ks();
        if (ufVarKs != null) {
            this.p = ufVarKs.z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public boolean m() {
        String str = this.p;
        return (str == null || str.equals("0") || TextUtils.isEmpty(this.p)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z g(uy uyVar) {
        return dl(uyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public String z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("red_pack_amount", this.p);
            boolean z = false;
            try {
                if (Double.parseDouble(this.p) != 0.0d) {
                    z = true;
                }
            } catch (NumberFormatException unused) {
            }
            jSONObject.put("is_display_unit", z);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject.toString();
    }
}

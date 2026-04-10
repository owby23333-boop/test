package com.bytedance.sdk.openadsdk.core.component.reward.dl;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.na;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m extends z {
    private int fv;
    private int p;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public int e() {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    protected float gz() {
        return 0.75f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    protected void z(com.bytedance.sdk.openadsdk.core.widget.m mVar) {
    }

    m(Activity activity, na naVar, bm bmVar) {
        JSONObject jSONObjectG;
        super(activity, naVar, bmVar);
        if (this.fo == null || (jSONObjectG = this.fo.g()) == null) {
            return;
        }
        this.p = jSONObjectG.optInt("reduce_time");
        this.fv = jSONObjectG.optInt("reduce_duration");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public boolean m() {
        return (this.fo == null || !this.fo.m()) && this.p > 0 && this.fv > 0 && this.g < this.fv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z g(uy uyVar) {
        return dl(uyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    protected void a(uy uyVar) {
        if (uyVar != null) {
            uyVar.z(this.p);
        }
        this.fo.z(true);
        if (uyVar != null) {
            uyVar.z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public String z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "恭喜获得加速特权");
            jSONObject.put("reduce_time", this.p + "s");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject.toString();
    }
}

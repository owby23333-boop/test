package com.bytedance.sdk.openadsdk.core.ugeno.component.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.widget.frame.UGFrameLayout;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class z extends com.bytedance.adsdk.ugeno.widget.dl.z {
    public z(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: jq, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout z() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.g);
        uGFrameLayout.z(this);
        return uGFrameLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.widget.dl.z, com.bytedance.adsdk.ugeno.g.z, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
    }

    public void z(long j, long j2) {
        ls lsVar;
        JSONObject jSONObjectDl;
        if (!z(12) || (lsVar = this.s.get(12)) == null || (jSONObjectDl = lsVar.dl()) == null) {
            return;
        }
        jSONObjectDl.optString("type");
        JSONArray jSONArrayOptJSONArray = jSONObjectDl.optJSONArray("actions");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("type");
                int iOptInt = jSONObjectOptJSONObject.optInt("progress") * 1000;
                if (iOptInt > j2) {
                    iOptInt = (int) j2;
                }
                if (j == iOptInt && TextUtils.equals(strOptString, "onShow")) {
                    dl dlVarG = g(this);
                    String strOptString2 = jSONObjectOptJSONObject.optString("nodeId");
                    if (dlVarG != null) {
                        dlVarG.a(strOptString2).g(0);
                    }
                }
            }
        }
    }
}

package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class xl extends gp {
    private final Context gc;
    private final bv m;

    xl(Context context, bv bvVar) {
        super(true, false);
        this.gc = context;
        this.m = bvVar;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        if (!TextUtils.isEmpty(this.m.ti())) {
            jSONObject.put("ab_client", this.m.ti());
        }
        if (!TextUtils.isEmpty(this.m.tb())) {
            if (cb.g) {
                cb.z("init config has abversion:" + this.m.tb(), null);
            }
            jSONObject.put("ab_version", this.m.tb());
        }
        if (!TextUtils.isEmpty(this.m.eo())) {
            jSONObject.put("ab_group", this.m.eo());
        }
        if (TextUtils.isEmpty(this.m.oq())) {
            return true;
        }
        jSONObject.put("ab_feature", this.m.oq());
        return true;
    }
}

package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class vm extends gp {
    private final bv gc;

    vm(Context context, bv bvVar) {
        super(true, false);
        this.gc = bvVar;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        String strZ = dh.z(this.gc.gc());
        if (TextUtils.isEmpty(strZ)) {
            return false;
        }
        jSONObject.put("cdid", strZ);
        return true;
    }
}

package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class f extends gp {
    private final Context gc;
    private final bv m;

    f(Context context, bv bvVar) {
        super(true, false);
        this.gc = context;
        this.m = bvVar;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        String strZ = z.i() != null ? z.i().lq().z() : "";
        if (TextUtils.isEmpty(strZ)) {
            return true;
        }
        jSONObject.put(an.A, strZ);
        return true;
    }
}

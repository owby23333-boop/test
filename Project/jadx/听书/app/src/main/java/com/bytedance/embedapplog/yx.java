package com.bytedance.embedapplog;

import android.content.Context;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class yx extends gp {
    private final Context gc;

    yx(Context context) {
        super(true, true);
        this.gc = context;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        gb.z(jSONObject, an.Q, ly.z(this.gc));
        return true;
    }
}

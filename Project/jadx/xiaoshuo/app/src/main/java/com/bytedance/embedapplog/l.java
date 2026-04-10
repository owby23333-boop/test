package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class l extends k {
    private final Context ga;
    private final wl vn;

    public l(Context context, wl wlVar) {
        super(true, false);
        this.ga = context;
        this.vn = wlVar;
    }

    @Override // com.bytedance.embedapplog.k
    public boolean e(JSONObject jSONObject) throws JSONException {
        if (!TextUtils.isEmpty(this.vn.bm())) {
            jSONObject.put("ab_client", this.vn.bm());
        }
        if (!TextUtils.isEmpty(this.vn.k())) {
            if (tx.bf) {
                tx.e("init config has abversion:" + this.vn.k(), null);
            }
            jSONObject.put("ab_version", this.vn.k());
        }
        if (!TextUtils.isEmpty(this.vn.b())) {
            jSONObject.put("ab_group", this.vn.b());
        }
        if (TextUtils.isEmpty(this.vn.r())) {
            return true;
        }
        jSONObject.put("ab_feature", this.vn.r());
        return true;
    }
}

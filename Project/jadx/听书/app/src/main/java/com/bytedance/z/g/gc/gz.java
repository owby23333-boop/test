package com.bytedance.z.g.gc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class gz {
    private SharedPreferences z;

    public gz(Context context) {
        this.z = com.bytedance.sdk.openadsdk.api.plugin.g.g(context, "npth", 0);
    }

    public void z(String str) {
        this.z.edit().putString("device_id", str).apply();
    }

    public String z() {
        String strGc = com.bytedance.z.g.gz.z().gc();
        return (TextUtils.isEmpty(strGc) || "0".equals(strGc)) ? this.z.getString("device_id", "0") : strGc;
    }
}

package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
final class oz {
    private final SharedPreferences z;

    oz(Context context) {
        this.z = com.bytedance.sdk.openadsdk.api.plugin.g.g(context, "device_register_oaid_refine", 0);
    }

    void z(jz jzVar) {
        if (jzVar == null) {
            return;
        }
        this.z.edit().putString("oaid", jzVar.g().toString()).apply();
    }

    jz z() {
        return jz.z(this.z.getString("oaid", ""));
    }
}

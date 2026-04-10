package com.bytedance.e.e.ga;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.verificationsdk.internal.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    private SharedPreferences e;

    public m(Context context) {
        this.e = context.getSharedPreferences("npth", 0);
    }

    public void e(String str) {
        this.e.edit().putString(Constants.DEVICE_ID, str).apply();
    }

    public String e() {
        String strGa = com.bytedance.e.e.zk.e().ga();
        return (TextUtils.isEmpty(strGa) || "0".equals(strGa)) ? this.e.getString(Constants.DEVICE_ID, "0") : strGa;
    }
}

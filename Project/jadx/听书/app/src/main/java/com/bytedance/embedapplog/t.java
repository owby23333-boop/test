package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class t extends gp {
    private final Context gc;
    private final bv m;

    t(Context context, bv bvVar) {
        super(true, false);
        this.gc = context;
        this.m = bvVar;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        jSONObject.put(an.x, "Android");
        jSONObject.put(an.y, Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", o.dl());
        jSONObject.put(an.F, Build.BRAND);
        jSONObject.put(an.H, Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.m.j() ? z(this.gc) : this.m.xl());
        return true;
    }

    private static String z(Context context) {
        String serial = null;
        if (context == null) {
            return null;
        }
        if (context.getApplicationInfo().targetSdkVersion >= 26) {
            try {
                serial = Build.getSerial();
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(serial) || TextUtils.equals(serial, "unknown")) {
            serial = Build.SERIAL;
        }
        return (TextUtils.isEmpty(serial) || TextUtils.equals(serial, "unknown")) ? "" : serial;
    }
}

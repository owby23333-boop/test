package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class b extends gp {
    private final Context gc;
    private final bv m;

    b(Context context, bv bvVar) {
        super(false, false);
        this.gc = context;
        this.m = bvVar;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        int i;
        int i2;
        String packageName = this.gc.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.m.y())) {
            jSONObject.put("package", packageName);
        } else {
            if (cb.g) {
                cb.z("has zijie pkg", null);
            }
            jSONObject.put("package", this.m.y());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.gc.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th) {
                cb.g(th);
                return false;
            }
        } else {
            i = 0;
        }
        if (!TextUtils.isEmpty(this.m.mc())) {
            jSONObject.put("app_version", this.m.mc());
        } else {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        }
        if (!TextUtils.isEmpty(this.m.wj())) {
            jSONObject.put("app_version_minor", this.m.wj());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.m.gk() != 0) {
            jSONObject.put("version_code", this.m.gk());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.m.x() != 0) {
            jSONObject.put("update_version_code", this.m.x());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.m.lq() != 0) {
            jSONObject.put("manifest_version_code", this.m.lq());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.m.h())) {
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, this.m.h());
        }
        if (!TextUtils.isEmpty(this.m.un())) {
            jSONObject.put("tweaked_channel", this.m.un());
        }
        if (packageInfo == null || packageInfo.applicationInfo == null || (i2 = packageInfo.applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put(an.s, this.gc.getString(i2));
        return true;
    }
}

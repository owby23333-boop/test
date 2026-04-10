package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.market.sdk.utils.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class bx extends k {
    private final Context ga;
    private final wl vn;

    public bx(Context context, wl wlVar) {
        super(false, false);
        this.ga = context;
        this.vn = wlVar;
    }

    @Override // com.bytedance.embedapplog.k
    public boolean e(JSONObject jSONObject) throws JSONException {
        int i;
        ApplicationInfo applicationInfo;
        int i2;
        String packageName = this.ga.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.vn.ot())) {
            jSONObject.put("package", packageName);
        } else {
            if (tx.bf) {
                tx.e("has zijie pkg", null);
            }
            jSONObject.put("package", this.vn.ot());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.ga.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th) {
                tx.bf(th);
                return false;
            }
        } else {
            i = 0;
        }
        if (TextUtils.isEmpty(this.vn.hb())) {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        } else {
            jSONObject.put("app_version", this.vn.hb());
        }
        if (TextUtils.isEmpty(this.vn.rm())) {
            jSONObject.put("app_version_minor", "");
        } else {
            jSONObject.put("app_version_minor", this.vn.rm());
        }
        if (this.vn.fy() != 0) {
            jSONObject.put(Constants.Update.VERSION_CODE, this.vn.fy());
        } else {
            jSONObject.put(Constants.Update.VERSION_CODE, i);
        }
        if (this.vn.h() != 0) {
            jSONObject.put("update_version_code", this.vn.h());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.vn.x() != 0) {
            jSONObject.put("manifest_version_code", this.vn.x());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.vn.uk())) {
            jSONObject.put(com.xiaomi.verificationsdk.internal.Constants.APP_NAME, this.vn.uk());
        }
        if (!TextUtils.isEmpty(this.vn.bx())) {
            jSONObject.put("tweaked_channel", this.vn.bx());
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (i2 = applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put("display_name", this.ga.getString(i2));
        return true;
    }
}

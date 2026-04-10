package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.downloadlib.constants.EventConstants;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.am;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class m extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j2 f733f;

    m(Context context, j2 j2Var) {
        super(false, false);
        this.f732e = context;
        this.f733f = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        int iF;
        int i2;
        String packageName = this.f732e.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.f733f.q())) {
            jSONObject.put(Constants.KEY_PACKAGE, packageName);
        } else {
            if (l0.a) {
                l0.a("has zijie pkg", null);
            }
            jSONObject.put(Constants.KEY_PACKAGE, this.f733f.q());
            jSONObject.put(EventConstants.ExtraJson.REAL_PACKAGE_NAME, packageName);
        }
        try {
            packageInfo = this.f732e.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                iF = packageInfo.versionCode;
            } catch (Throwable th) {
                l0.a(th);
                return false;
            }
        } else {
            iF = 0;
        }
        jSONObject.put("app_version", !TextUtils.isEmpty(this.f733f.g()) ? this.f733f.g() : packageInfo != null ? packageInfo.versionName : "");
        if (TextUtils.isEmpty(this.f733f.l())) {
            jSONObject.put("app_version_minor", "");
        } else {
            jSONObject.put("app_version_minor", this.f733f.l());
        }
        if (this.f733f.d() != 0) {
            jSONObject.put("version_code", this.f733f.d());
        } else {
            jSONObject.put("version_code", iF);
        }
        if (this.f733f.e() != 0) {
            jSONObject.put("update_version_code", this.f733f.e());
        } else {
            jSONObject.put("update_version_code", iF);
        }
        if (this.f733f.f() != 0) {
            iF = this.f733f.f();
        }
        jSONObject.put("manifest_version_code", iF);
        if (!TextUtils.isEmpty(this.f733f.c())) {
            jSONObject.put("app_name", this.f733f.c());
        }
        if (!TextUtils.isEmpty(this.f733f.h())) {
            jSONObject.put("tweaked_channel", this.f733f.h());
        }
        if (packageInfo != null && packageInfo.applicationInfo != null && (i2 = packageInfo.applicationInfo.labelRes) > 0) {
            jSONObject.put(am.f19459s, this.f732e.getString(i2));
        }
        return true;
    }
}

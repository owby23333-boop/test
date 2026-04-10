package bykvm_19do.bykvm_19do.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.am;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class f2 extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j2 f677f;

    f2(Context context, j2 j2Var) {
        super(true, false);
        this.f676e = context;
        this.f677f = j2Var;
    }

    private static String a(Context context) {
        String serial = null;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
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

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    @SuppressLint({"MissingPermission"})
    protected boolean a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put(am.H, Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.f677f.o() ? a(this.f676e) : this.f677f.n());
        return true;
    }
}

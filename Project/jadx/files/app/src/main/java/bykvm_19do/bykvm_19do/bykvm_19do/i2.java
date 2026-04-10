package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class i2 extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j2 f705f;

    i2(Context context, j2 j2Var) {
        super(false, false);
        this.f704e = context;
        this.f705f = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", 336);
        jSONObject.put("sdk_version_name", "3.6.0-rc.10-embed");
        jSONObject.put("channel", this.f705f.C());
        k2.a(jSONObject, "aid", this.f705f.B());
        k2.a(jSONObject, "release_build", this.f705f.S());
        k2.a(jSONObject, "app_region", this.f705f.F());
        k2.a(jSONObject, "app_language", this.f705f.E());
        k2.a(jSONObject, "user_agent", this.f705f.a());
        k2.a(jSONObject, "ab_sdk_version", this.f705f.H());
        k2.a(jSONObject, "ab_version", this.f705f.L());
        k2.a(jSONObject, "aliyun_uuid", this.f705f.t());
        String strD = this.f705f.D();
        if (TextUtils.isEmpty(strD)) {
            strD = g0.a(this.f704e, this.f705f);
        }
        if (!TextUtils.isEmpty(strD)) {
            k2.a(jSONObject, "google_aid", strD);
        }
        String strR = this.f705f.R();
        if (!TextUtils.isEmpty(strR)) {
            try {
                jSONObject.put("app_track", new JSONObject(strR));
            } catch (Throwable th) {
                l0.a(th);
            }
        }
        String strG = this.f705f.G();
        if (strG != null && strG.length() > 0) {
            jSONObject.put("custom", new JSONObject(strG));
        }
        k2.a(jSONObject, "user_unique_id", this.f705f.I());
        return true;
    }
}

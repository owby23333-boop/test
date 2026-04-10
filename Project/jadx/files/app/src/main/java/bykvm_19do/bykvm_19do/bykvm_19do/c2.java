package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class c2 extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j2 f670e;

    c2(Context context, j2 j2Var) {
        super(true, false);
        this.f670e = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        if (!TextUtils.isEmpty(this.f670e.i())) {
            jSONObject.put("ab_client", this.f670e.i());
        }
        if (!TextUtils.isEmpty(this.f670e.L())) {
            if (l0.a) {
                l0.a("init config has abversion:" + this.f670e.L(), null);
            }
            jSONObject.put("ab_version", this.f670e.L());
        }
        if (!TextUtils.isEmpty(this.f670e.j())) {
            jSONObject.put("ab_group", this.f670e.j());
        }
        if (TextUtils.isEmpty(this.f670e.k())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f670e.k());
        return true;
    }
}

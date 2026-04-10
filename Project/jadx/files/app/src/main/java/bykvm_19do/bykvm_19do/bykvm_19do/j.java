package bykvm_19do.bykvm_19do.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class j extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f706e;

    j(Context context) {
        super(true, true);
        this.f706e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    @SuppressLint({"MissingPermission"})
    protected boolean a(JSONObject jSONObject) throws JSONException {
        k2.a(jSONObject, "access", h0.b(this.f706e));
        return true;
    }
}

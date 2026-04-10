package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class g2 extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j2 f678e;

    g2(Context context, j2 j2Var) {
        super(true, false);
        this.f678e = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        String strA = s0.a(this.f678e.w());
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        jSONObject.put("cdid", strA);
        return true;
    }
}

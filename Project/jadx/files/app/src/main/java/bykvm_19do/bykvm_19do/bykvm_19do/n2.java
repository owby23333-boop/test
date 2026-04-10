package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class n2 extends e2 {
    n2(Context context, j2 j2Var) {
        super(true, false);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        String strA = a.k() != null ? a.k().s().a() : "";
        if (TextUtils.isEmpty(strA)) {
            return true;
        }
        jSONObject.put("mc", strA);
        return true;
    }
}

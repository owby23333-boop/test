package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class k extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j2 f722f;

    k(Context context, j2 j2Var) {
        super(true, false);
        this.f721e = context;
        this.f722f = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        Map<String, String> mapA = s0.a(this.f721e, this.f722f.w());
        if (mapA == null) {
            return false;
        }
        jSONObject.put("oaid", new JSONObject(mapA));
        return true;
    }
}

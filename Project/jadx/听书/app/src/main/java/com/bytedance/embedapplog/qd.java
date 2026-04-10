package com.bytedance.embedapplog;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class qd extends gp {
    private final Context gc;
    private final bv m;

    qd(Context context, bv bvVar) {
        super(true, false);
        this.gc = context;
        this.m = bvVar;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) {
        Map<String, String> mapZ = dh.z(this.gc, this.m.gc());
        if (mapZ == null) {
            return !z.g;
        }
        jSONObject.put("oaid", new JSONObject(mapZ));
        return true;
    }
}

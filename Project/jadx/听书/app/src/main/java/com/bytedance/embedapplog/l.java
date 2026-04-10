package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    private final uf z;

    public l(Context context) {
        hh hhVar = new hh(context);
        this.z = new uf(context, new q(context, hhVar), hhVar);
    }

    public void z(JSONObject jSONObject, String str) {
        this.z.z(jSONObject, str);
    }
}

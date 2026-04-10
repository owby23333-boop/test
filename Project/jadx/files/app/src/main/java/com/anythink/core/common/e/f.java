package com.anythink.core.common.e;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends q {
    public int a;
    public ah b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f7253c;

    @Override // com.anythink.core.common.e.q
    public final JSONObject a() {
        JSONObject jSONObjectA = this.b.A(this.a);
        if (jSONObjectA != null) {
            try {
                jSONObjectA.put("sdk_time", this.f7253c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONObjectA;
    }
}

package com.bytedance.sdk.openadsdk.core.l.z;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    protected boolean dl(int i) {
        return i == 2 || i == 3;
    }

    protected boolean g(int i) {
        return i == 0 || i == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int z(int r4) {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.core.gk.uy r0 = com.bytedance.sdk.openadsdk.core.zw.g()
            org.json.JSONObject r0 = r0.sd()
            if (r0 == 0) goto L25
            boolean r1 = r3.g(r4)
            r2 = 0
            if (r1 == 0) goto L18
            java.lang.String r4 = "explicit_interval"
            int r4 = r0.optInt(r4, r2)
            goto L26
        L18:
            boolean r4 = r3.dl(r4)
            if (r4 == 0) goto L25
            java.lang.String r4 = "ambiguous_interval"
            int r4 = r0.optInt(r4, r2)
            goto L26
        L25:
            r4 = -1
        L26:
            r0 = 86400000(0x5265c00, float:7.82218E-36)
            if (r4 <= r0) goto L2c
            r4 = r0
        L2c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.z.z.z(int):int");
    }

    protected void z(int i, long j, long j2) {
        com.bytedance.sdk.openadsdk.core.l.z zVarZ = com.bytedance.sdk.openadsdk.core.l.z.z();
        zVarZ.z(i);
        zVarZ.z(j, j2);
    }

    protected int z(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("delay", 200);
        }
        return 200;
    }
}

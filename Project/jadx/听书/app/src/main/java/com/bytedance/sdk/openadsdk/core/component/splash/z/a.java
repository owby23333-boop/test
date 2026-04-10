package com.bytedance.sdk.openadsdk.core.component.splash.z;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo;
import com.bytedance.sdk.openadsdk.core.component.splash.e;
import com.bytedance.sdk.openadsdk.core.hh;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.yx;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.x;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.openadsdk.core.component.splash.z.z {
    private g e;
    private volatile com.bytedance.sdk.component.a.g.dl gz = null;
    private com.bytedance.sdk.component.a.g.dl fo = x.z("tt_materialMeta");

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void g() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void z(String str, String str2, boolean z2, boolean z3, Object obj) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void z(yx yxVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, boolean z2) {
        int iZ;
        if (yxVar != null && (iZ = e.z(yxVar)) > 0) {
            z(iZ, yxVar.z().bp());
            z(yxVar);
        }
    }

    private void z(yx yxVar) {
        g gVar = this.e;
        if (gVar == null) {
            this.e = new g(yxVar);
        } else {
            gVar.z(yxVar);
        }
        com.bytedance.sdk.component.uy.e.z(this.e, 10);
    }

    private com.bytedance.sdk.component.a.g.dl gc() {
        if (this.gz == null) {
            this.gz = x.z("tt_splash");
        }
        return this.gz;
    }

    private void z(int i, long j) {
        com.bytedance.sdk.component.a.g.dl dlVarGc = gc();
        dlVarGc.put("expiration" + i, j);
        dlVarGc.put("update" + i, System.currentTimeMillis() / 1000);
        dlVarGc.put("has_ad_cache" + i, true);
    }

    private boolean z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar, String str) {
        if (z(str)) {
            return true;
        }
        if (eVar != null) {
            eVar.a(0);
            eVar.g(1);
            eVar.z("no cache");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e r3, java.lang.String r4, com.bytedance.sdk.openadsdk.core.component.splash.z.z.InterfaceC0167z r5, com.bytedance.sdk.openadsdk.core.component.splash.z.gc r6) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L65
            if (r5 != 0) goto L9
            goto L65
        L9:
            r2.m = r6
            boolean r3 = r2.z(r3, r4)
            if (r3 != 0) goto L15
            r5.z()
            return
        L15:
            r3 = 0
            com.bytedance.sdk.openadsdk.core.iq.z r6 = r2.gc(r4)     // Catch: java.lang.Throwable -> L55
            com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m r0 = new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m     // Catch: java.lang.Throwable -> L55
            r1 = 1
            r0.<init>(r6, r1)     // Catch: java.lang.Throwable -> L55
            if (r6 == 0) goto L3e
            java.util.List r1 = r6.g()     // Catch: java.lang.Throwable -> L54
            if (r1 == 0) goto L3e
            java.util.List r1 = r6.g()     // Catch: java.lang.Throwable -> L54
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L54
            if (r1 != 0) goto L3e
            java.util.List r6 = r6.g()     // Catch: java.lang.Throwable -> L54
            r1 = 0
            java.lang.Object r6 = r6.get(r1)     // Catch: java.lang.Throwable -> L54
            com.bytedance.sdk.openadsdk.core.iq.na r6 = (com.bytedance.sdk.openadsdk.core.iq.na) r6     // Catch: java.lang.Throwable -> L54
            goto L3f
        L3e:
            r6 = r3
        L3f:
            if (r6 == 0) goto L44
            r0.z(r6)     // Catch: java.lang.Throwable -> L54
        L44:
            com.bytedance.sdk.openadsdk.core.live.g r1 = com.bytedance.sdk.openadsdk.core.live.g.z()     // Catch: java.lang.Throwable -> L54
            int r6 = r1.dl(r6)     // Catch: java.lang.Throwable -> L54
            r1 = 3
            if (r6 == r1) goto L50
            goto L54
        L50:
            r0.z(r3)     // Catch: java.lang.Throwable -> L54
            goto L55
        L54:
            r3 = r0
        L55:
            r5.z(r3)
            com.bytedance.sdk.openadsdk.core.dl.gc r3 = com.bytedance.sdk.openadsdk.core.dl.gc.z()
            boolean r3 = r3.uy()
            if (r3 != 0) goto L65
            r2.a(r4)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.splash.z.a.z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e, java.lang.String, com.bytedance.sdk.openadsdk.core.component.splash.z.z$z, com.bytedance.sdk.openadsdk.core.component.splash.z.gc):void");
    }

    public boolean z(String str) {
        return (TextUtils.isEmpty(str) || !gc().get(new StringBuilder("has_ad_cache").append(str).toString(), false) || dl(str)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a<fo, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e> aVar, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, boolean z2) {
        if (naVar == null) {
            return;
        }
        if (z2) {
            this.fo.put("net_ad_already_shown", naVar.aq());
        }
        if (this.gc.get()) {
            return;
        }
        String str = this.fo.get("net_ad_save_success" + eo.fo(naVar), "");
        if (TextUtils.isEmpty(str) || !str.equals(naVar.aq())) {
            return;
        }
        this.gc.set(true);
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "计划清除缓存 reqId:  " + str);
        a(gVar != null ? gVar.a() : null);
        if (aVar != null) {
            aVar.z();
        }
    }

    private z g(String str) {
        z zVar = new z();
        if (TextUtils.isEmpty(str)) {
            return zVar;
        }
        com.bytedance.sdk.component.a.g.dl dlVarGc = gc();
        long j = dlVarGc.get("expiration" + str, 0L);
        long j2 = dlVarGc.get("update" + str, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        zVar.z = jCurrentTimeMillis < j2 || jCurrentTimeMillis >= j;
        zVar.g = j2;
        zVar.dl = j;
        zVar.f1018a = jCurrentTimeMillis;
        return zVar;
    }

    static class z {
        boolean z = true;
        long g = 0;
        long dl = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f1018a = 0;

        z() {
        }
    }

    private boolean dl(final String str) {
        final z zVarG = g(str);
        if (zVarG.z) {
            v.z().e(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.z.a.1
                @Override // com.bytedance.sdk.openadsdk.kb.z.z
                public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                    long j = zVarG.f1018a - zVarG.g;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("available_type", 0);
                    jSONObject.putOpt("creative_timeout_duration", Long.valueOf(j / 3600));
                    return com.bytedance.sdk.openadsdk.core.q.z.g.g().z(4).dl(str).g(jSONObject.toString());
                }
            });
        }
        long j = this.m == null ? 0L : this.m.z;
        if (j <= 0 || zVarG.g * 1000 >= j) {
            return zVarG.z;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void z(String str, na naVar) {
        a(str);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.a.g.dl dlVarGc = gc();
        this.fo.remove("materialMeta" + str);
        if (dlVarGc != null) {
            dlVarGc.remove("has_ad_cache" + str);
            dlVarGc.remove("expiration" + str);
        }
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "清除成功： rit: " + str);
    }

    private class g extends com.bytedance.sdk.component.uy.fo {
        private yx g;

        public g(yx yxVar) {
            super("WriteCacheTask");
            this.g = yxVar;
        }

        public void z(yx yxVar) {
            this.g = yxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            z();
        }

        private void z() {
            try {
                int iZ = e.z(this.g);
                if (iZ <= 0) {
                    return;
                }
                String str = a.this.fo.get("net_ad_already_shown", "");
                if (!TextUtils.isEmpty(str) && str.equals(this.g.z().aq())) {
                    com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "该缓存已show-则不再save： rit: " + iZ + "   reqId: " + this.g.z().aq());
                    return;
                }
                JSONObject jSONObjectDl = this.g.g().dl();
                if (jSONObjectDl != null) {
                    a.this.fo.put("materialMeta".concat(String.valueOf(iZ)), jSONObjectDl.toString());
                }
                a.this.fo.put("net_ad_save_success".concat(String.valueOf(iZ)), this.g.z().aq());
                com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "缓存成功： rit: " + iZ + "   reqId: " + this.g.z().aq());
            } catch (Throwable unused) {
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.iq.z gc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.fo.get("materialMeta" + str, (String) null);
        if (!TextUtils.isEmpty(str2)) {
            try {
                hh.z zVarZ = hh.z.z(new JSONObject(str2));
                if (zVarZ != null && zVarZ.gz != null) {
                    return zVarZ.gz;
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static void a() {
        zw.g().gw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void dl() {
        try {
            x.z("tt_materialMeta").clear();
            x.z("tt_splash").clear();
        } catch (Throwable unused) {
        }
    }
}

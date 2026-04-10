package com.bytedance.sdk.openadsdk.core.gc.dl;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.iq.gz;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.hh.e;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bytedance.sdk.openadsdk.core.gc.dl.z {
    static ReferenceQueue<Object> g = new ReferenceQueue<>();
    private final int dl;
    Map<Object, z> z = new ConcurrentHashMap();

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public boolean z(String str) {
        return true;
    }

    public a(int i) {
        this.dl = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final na naVar) {
        if (TextUtils.isEmpty(gVar.q())) {
            if (naVar.bp() <= 0) {
                naVar.gc((System.currentTimeMillis() + 10500000) / 1000);
            }
            e.a(new fo("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.gc.dl.a.1
                @Override // java.lang.Runnable
                public void run() {
                    System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.gc.a.gc.z(a.this.dl).z(gVar, naVar, false);
                    int unused = a.this.dl;
                    gVar.a();
                    System.currentTimeMillis();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final List<na> list) {
        if (TextUtils.isEmpty(gVar.q())) {
            gz.g gVarZ = gz.z(this.dl);
            if (((gVarZ != null ? gVarZ.fo() : 0) & 1) == 1) {
                e.a(new fo("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.gc.dl.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        for (na naVar : list) {
                            if (naVar.bp() <= 0) {
                                naVar.gc((10500000 + jCurrentTimeMillis) / 1000);
                            }
                            com.bytedance.sdk.openadsdk.core.gc.a.gc.z(a.this.dl).z(gVar, naVar, false);
                            int unused = a.this.dl;
                            gVar.a();
                            System.currentTimeMillis();
                        }
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void g(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final List<na> list) {
        if (TextUtils.isEmpty(gVar.q())) {
            e.a(new fo("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.gc.dl.a.3
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    for (na naVar : list) {
                        if (naVar.bp() <= 0) {
                            naVar.gc((10500000 + jCurrentTimeMillis) / 1000);
                        }
                        com.bytedance.sdk.openadsdk.core.gc.a.gc.z(a.this.dl).z(gVar.a(), naVar.jt(), false);
                        int unused = a.this.dl;
                        gVar.a();
                        System.currentTimeMillis();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void g(String str) {
        System.currentTimeMillis();
        for (Reference<? extends Object> referencePoll = g.poll(); referencePoll != null; referencePoll = g.poll()) {
            z zVar = this.z.get(referencePoll);
            if (zVar != null) {
                com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.dl).z(zVar.z, zVar.g, false);
            }
        }
        com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.dl).g(str);
        System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.dl).dl(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public na z(String str, long j) {
        gz.g gVarZ = gz.z(this.dl);
        System.currentTimeMillis();
        na naVarZ = com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.dl).z(str, true, j);
        if (naVarZ != null && gVarZ != null) {
            try {
                if (gVarZ.z(naVarZ) || gVarZ.z("delete_on_load", null, naVarZ)) {
                    com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.dl).z(str, naVarZ.jt());
                }
            } catch (Exception unused) {
                wp.g("PreloadStrategyRecovery", "deleteCacheMeta error");
            }
        }
        System.currentTimeMillis();
        return naVarZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public List<na> z(String str, long j, int i) {
        gz.g gVarZ = gz.z(this.dl);
        System.currentTimeMillis();
        List<na> listZ = com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.dl).z(str, true, j, i);
        for (na naVar : listZ) {
            if (naVar != null && gVarZ != null) {
                try {
                    if (gVarZ.z(naVar) || gVarZ.z("delete_on_load", null, naVar)) {
                        com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.dl).z(str, naVar.jt());
                    }
                } catch (Exception unused) {
                    wp.g("PreloadStrategyRecovery", "deleteCacheMeta error");
                }
            }
        }
        listZ.size();
        System.currentTimeMillis();
        return listZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final na naVar, final Object obj, final boolean z2) {
        final String strA = gVar.a();
        e.a(new fo("PreloadStrategyRecovery-onLoad") { // from class: com.bytedance.sdk.openadsdk.core.gc.dl.a.4
            @Override // java.lang.Runnable
            public void run() {
                gz.g gVarZ = gz.z(a.this.dl);
                if (gVarZ != null) {
                    try {
                        if (gVarZ.z(naVar)) {
                            return;
                        }
                        if (gVarZ.z("disable_trans_cache", null, naVar)) {
                            return;
                        }
                    } catch (Exception unused) {
                        wp.g("PreloadStrategyRecovery", "isDisableSdkBidding error");
                    }
                }
                System.currentTimeMillis();
                if (naVar.re() != 0) {
                    a.this.z.put(new PhantomReference(obj, a.g), new z(strA, naVar.jt()));
                }
                if (z2) {
                    return;
                }
                if (((gVarZ != null ? gVarZ.fo() : 0) & 2) == 2) {
                    com.bytedance.sdk.openadsdk.core.gc.a.gc.z(a.this.dl).z(gVar, naVar, true);
                    System.currentTimeMillis();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(final na naVar) {
        final int iFo = eo.fo(naVar);
        e.a(new fo("PreloadStrategyRecovery-onShow") { // from class: com.bytedance.sdk.openadsdk.core.gc.dl.a.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.core.gc.a.gc.z(a.this.dl).z(new StringBuilder().append(iFo).toString(), naVar.jt());
                System.currentTimeMillis();
            }
        });
        gz.g gVarZ = gz.z(this.dl);
        if (gVarZ != null) {
            com.bytedance.sdk.openadsdk.core.gc.gc.z(new StringBuilder().append(iFo).toString(), gVarZ.uy()).g(gVarZ.uy());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(String str, na naVar) {
        com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.dl).z(str, naVar.jt());
    }

    private static class z {
        String g;
        String z;

        public z(String str, String str2) {
            this.z = str;
            this.g = str2;
        }
    }
}

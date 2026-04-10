package com.kwad.sdk.core.adlog.a;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private final c axv;
    private final List<com.kwad.sdk.core.adlog.a.a> axw;

    /* synthetic */ b(byte b) {
        this();
    }

    static final class a {
        private static final b axy = new b(0);
    }

    private b() {
        this.axw = new CopyOnWriteArrayList();
        this.axv = (c) aa.b(((h) ServiceProvider.get(h.class)).BW(), new com.kwad.sdk.core.c<c>() { // from class: com.kwad.sdk.core.adlog.a.b.1
            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ com.kwad.sdk.core.b Ef() {
                return EG();
            }

            private static c EG() {
                return new c();
            }
        });
    }

    public static b EA() {
        return a.axy;
    }

    public final void a(com.kwad.sdk.core.adlog.a.a aVar, String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar2, int i, String str2) {
        try {
            if (EE()) {
                return;
            }
            if (!EF() || d(aVar2)) {
                if (aVar == null) {
                    if (aVar2 != null) {
                        a.C0392a c0392a = aVar2.EL() == null ? new a.C0392a() : aVar2.EL();
                        c0392a.awU = 1;
                        aVar2.a(c0392a);
                        aa.putValue(jSONObject, "clientExtData", aVar2.Pk.toJson().toString());
                    }
                    aVar = com.kwad.sdk.core.adlog.a.a.Ez().dm(str).i(jSONObject).c(aVar2).as(System.currentTimeMillis());
                }
                aVar.cK(i).dn(str2);
                com.kwad.sdk.core.adlog.b.a.a(aVar, this.axv, this.axw.size());
                if (aVar.retryCount >= this.axv.axA) {
                    com.kwad.sdk.core.adlog.b.a.c(aVar, this.axv, this.axw.size());
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache fail limit retryCount: " + aVar.retryCount + ", log: " + aVar);
                    return;
                }
                if (this.axw.size() >= this.axv.axC) {
                    com.kwad.sdk.core.adlog.a.a aVarEC = EC();
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache limit size: " + this.axw.size() + ", remove log：" + aVarEC);
                    com.kwad.sdk.core.adlog.b.a.e(aVarEC, this.axv, this.axw.size());
                }
                a(aVar);
                com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache success size: " + this.axw.size() + ", log: " + aVar);
                com.kwad.sdk.core.adlog.b.a.b(aVar, this.axv, this.axw.size());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void EB() {
        try {
            if (EE() || ap.L(this.axw)) {
                return;
            }
            bw.runOnUiThread(new bg() { // from class: com.kwad.sdk.core.adlog.a.b.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.sdk.core.adlog.b.Ex();
                }
            });
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private synchronized void a(com.kwad.sdk.core.adlog.a.a aVar) {
        this.axw.add(aVar);
    }

    private synchronized com.kwad.sdk.core.adlog.a.a EC() {
        if (ap.L(this.axw)) {
            return null;
        }
        return this.axw.remove(0);
    }

    public final com.kwad.sdk.core.adlog.a.a ED() {
        com.kwad.sdk.core.adlog.a.a aVarEC = EC();
        if (aVarEC == null) {
            return null;
        }
        com.kwad.sdk.core.adlog.b.a.d(aVarEC, this.axv, this.axw.size());
        long jCurrentTimeMillis = System.currentTimeMillis() - aVarEC.axs;
        if (jCurrentTimeMillis > this.axv.axB * 1000) {
            com.kwad.sdk.core.adlog.b.a.b(aVarEC, this.axv, this.axw.size(), jCurrentTimeMillis);
            com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache fail expired cacheTime: " + jCurrentTimeMillis + ", adLogCache：" + aVarEC);
            return null;
        }
        aVarEC.retryCount++;
        com.kwad.sdk.core.adlog.b.a.a(aVarEC, this.axv, this.axw.size(), jCurrentTimeMillis);
        com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache success：" + aVarEC);
        return aVarEC;
    }

    private boolean EE() {
        c cVar = this.axv;
        return cVar == null || !cVar.axz;
    }

    private boolean EF() {
        c cVar = this.axv;
        return cVar != null && cVar.axD;
    }

    private static boolean d(com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        return aVar.awx == 1 || aVar.awx == 2;
    }
}

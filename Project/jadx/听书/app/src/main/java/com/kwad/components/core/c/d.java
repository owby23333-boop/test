package com.kwad.components.core.c;

import android.util.SparseArray;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static boolean NB = true;
    private static volatile d Nz;
    private final SparseArray<c> Ny;

    static /* synthetic */ boolean a(d dVar) {
        return oe();
    }

    public static d od() {
        if (Nz == null) {
            synchronized (d.class) {
                if (Nz == null) {
                    Nz = new d();
                }
            }
        }
        return Nz;
    }

    private d() {
        SparseArray<c> sparseArray = new SparseArray<>();
        this.Ny = sparseArray;
        sparseArray.append(0, new n());
        sparseArray.append(1, new m());
        sparseArray.append(2, new l());
    }

    public final void d(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Ju().submit(new bg() { // from class: com.kwad.components.core.c.d.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                final e eVarX = e.x(aVar.getPosId());
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.c.d.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        b.b(eVarX);
                    }
                });
                c cVar = (d.a(d.this) || !(eVarX.isDefault() || eVarX.isEnable())) ? (c) d.this.Ny.get(0) : (c) d.this.Ny.get(eVarX.oh());
                if (cVar == null) {
                    cVar = (c) d.this.Ny.get(1);
                }
                com.kwad.components.core.request.j jVarSu = aVar.su();
                if (jVarSu != null) {
                    cVar.getName();
                    jVarSu.ah();
                }
                d dVar = d.this;
                d.a(aVar, cVar);
                com.kwad.sdk.commercial.d.d.c(aVar.Rw.adScene, aVar.sv());
                cVar.d(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.kwad.components.core.request.model.a aVar, c cVar) {
        String name = cVar.getName();
        name.hashCode();
        if (name.equals("StrategyNetworkFirst")) {
            aVar.aE("network_first");
        } else if (name.equals("StrategyLocalCacheFirst")) {
            aVar.aE("cache_first");
        } else {
            aVar.aE("network_only");
        }
    }

    private static boolean oe() {
        if (!NB) {
            return false;
        }
        try {
            if (com.kwad.sdk.components.g.df("KEY_ENABLE_FORCE_ENABLE_AD_CACHE")) {
                return false;
            }
            Class.forName("com.kwad.devTools.PosConfigFetcher");
            NB = true;
        } catch (ClassNotFoundException unused) {
            NB = false;
        }
        return NB;
    }
}

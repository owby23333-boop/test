package com.kwad.components.ad.g;

import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.internal.api.SceneImpl;

/* JADX INFO: loaded from: classes2.dex */
public class b implements i.a {
    private static volatile b Gv;

    private b() {
    }

    public static b lZ() {
        if (Gv == null) {
            synchronized (b.class) {
                if (Gv == null) {
                    Gv = new b();
                }
            }
        }
        return Gv;
    }

    @Override // com.kwad.sdk.core.network.i.a
    public final void a(g gVar, int i2) {
        if ((gVar instanceof com.kwad.components.core.n.a) && i2 != f.afS.errorCode) {
            int i3 = 21004;
            SceneImpl scene = gVar.getScene();
            if (scene != null) {
                long posId = scene.getPosId();
                if (i2 == f.afN.errorCode) {
                    i3 = 21001;
                } else if (i2 == f.afR.errorCode) {
                    i3 = 21003;
                } else if (i2 > 0 && i2 < 1000) {
                    i3 = 21002;
                }
                com.kwad.components.core.m.a.pr().a(posId, i3);
            }
        }
    }

    public final void init() {
        i.wr().a(this);
    }
}

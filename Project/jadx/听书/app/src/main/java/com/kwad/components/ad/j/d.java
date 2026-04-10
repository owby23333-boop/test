package com.kwad.components.ad.j;

import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.h;
import com.kwad.sdk.internal.api.SceneImpl;

/* JADX INFO: loaded from: classes3.dex */
public class d implements h.a {
    private static volatile d LT;

    public static d nG() {
        if (LT == null) {
            synchronized (d.class) {
                if (LT == null) {
                    LT = new d();
                }
            }
        }
        return LT;
    }

    private d() {
    }

    public final void init() {
        h.Hy().a(this);
    }

    @Override // com.kwad.sdk.core.network.h.a
    public final void a(f fVar, int i) {
        SceneImpl scene;
        int i2;
        if (!(fVar instanceof com.kwad.components.core.request.a) || i == e.aEq.errorCode || (scene = fVar.getScene()) == null) {
            return;
        }
        long posId = scene.getPosId();
        if (i == e.aEl.errorCode) {
            i2 = 21001;
        } else {
            i2 = i == e.aEp.errorCode ? 21003 : (i <= 0 || i >= 1000) ? 21004 : 21002;
        }
        com.kwad.components.core.p.a.se().c(posId, i2);
    }
}

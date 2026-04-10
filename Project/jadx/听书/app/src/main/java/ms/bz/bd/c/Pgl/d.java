package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class d extends pbly.pgla {
    d() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        Context contextG = pblv.z().g();
        return contextG != null ? contextG.getPackageName() : "";
    }
}

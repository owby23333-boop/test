package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class z extends pbly.pgla {
    z() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object z(long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        try {
            Context contextG = pblv.z().g();
            if (contextG != null) {
                return Boolean.valueOf((contextG.getApplicationInfo() == null || (contextG.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
            return bool;
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}

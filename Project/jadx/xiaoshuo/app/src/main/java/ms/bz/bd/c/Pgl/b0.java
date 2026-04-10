package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class b0 extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        try {
            Context contextBf = pgla.e().bf();
            if (contextBf != null) {
                return Boolean.valueOf((contextBf.getApplicationInfo() == null || (contextBf.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
            return bool;
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}

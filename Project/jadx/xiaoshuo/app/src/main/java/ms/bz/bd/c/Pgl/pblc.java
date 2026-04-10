package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class pblc extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        try {
            Context contextBf = pgla.e().bf();
            return contextBf.getPackageManager().getPackageInfo(contextBf.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "";
        }
    }
}

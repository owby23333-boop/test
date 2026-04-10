package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class d extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        Context contextBf = pgla.e().bf();
        try {
            return contextBf.getPackageManager().getPackageInfo(contextBf.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "";
        }
    }
}

package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class c extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        int i2;
        Context contextBf = pgla.e().bf();
        try {
            i2 = contextBf.getPackageManager().getPackageInfo(contextBf.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
            i2 = -1;
        }
        return String.valueOf(i2);
    }
}

package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class w extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        Context contextBf = pgla.e().bf();
        ApplicationInfo applicationInfo = contextBf.getPackageManager().getApplicationInfo(contextBf.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        return str2 != null ? str2 : applicationInfo.publicSourceDir;
    }
}

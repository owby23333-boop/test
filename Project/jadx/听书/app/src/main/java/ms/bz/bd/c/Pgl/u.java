package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class u extends pbly.pgla {
    u() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        Context contextG = pblv.z().g();
        ApplicationInfo applicationInfo = contextG.getPackageManager().getApplicationInfo(contextG.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        return str2 == null ? applicationInfo.publicSourceDir : str2;
    }
}

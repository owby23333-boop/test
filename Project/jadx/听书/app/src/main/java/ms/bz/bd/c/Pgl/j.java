package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.Signature;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class j extends pbly.pgla {
    j() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        Context contextG = pblv.z().g();
        Signature[] signatureArr = contextG.getPackageManager().getPackageInfo(contextG.getPackageName(), 64).signatures;
        if (signatureArr == null || signatureArr.length <= 0) {
            return null;
        }
        return signatureArr[0].toByteArray();
    }
}

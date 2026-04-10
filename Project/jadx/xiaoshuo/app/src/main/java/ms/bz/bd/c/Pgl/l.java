package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.Signature;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class l extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        Context contextBf = pgla.e().bf();
        Signature[] signatureArr = contextBf.getPackageManager().getPackageInfo(contextBf.getPackageName(), 64).signatures;
        if (signatureArr == null || signatureArr.length <= 0) {
            return null;
        }
        return signatureArr[0].toByteArray();
    }
}

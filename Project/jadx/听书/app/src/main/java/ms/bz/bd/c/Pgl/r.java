package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class r extends pbly.pgla {
    r() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        Context contextG = pblv.z().g();
        String[] strArr = (String[]) obj;
        if (contextG == null || str == null || strArr == null || strArr.length % 2 != 0) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.setPackage(contextG.getPackageName());
        for (int i = 0; i < strArr.length; i += 2) {
            intent.putExtra(strArr[i], strArr[i + 1]);
        }
        contextG.sendBroadcast(intent);
        return null;
    }
}

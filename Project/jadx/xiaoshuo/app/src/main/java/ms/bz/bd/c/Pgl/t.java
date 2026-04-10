package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class t extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        Context contextBf = pgla.e().bf();
        String[] strArr = (String[]) obj;
        if (contextBf == null || str == null || strArr == null || strArr.length % 2 != 0) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.setPackage(contextBf.getPackageName());
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            intent.putExtra(strArr[i2], strArr[i2 + 1]);
        }
        contextBf.sendBroadcast(intent);
        return null;
    }
}

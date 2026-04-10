package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: classes4.dex */
public final class d1 {
    public static boolean z(String... strArr) {
        try {
            Context contextG = pblv.z().g();
            for (String str : strArr) {
                if (contextG.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}

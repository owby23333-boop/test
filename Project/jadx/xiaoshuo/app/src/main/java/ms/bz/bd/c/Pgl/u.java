package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pblb;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
final class u extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        Context contextBf = pgla.e().bf();
        if (contextBf != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) contextBf.getSystemService((String) pblk.a(16777217, 0, 0L, "12e8cf", new byte[]{35, Utf8.REPLACEMENT_BYTE, Ascii.CAN, 66, 89, 114, 38, Ascii.SUB, 34, 97, 52, 41}));
                Method declaredMethod = connectivityManager.getClass().getDeclaredMethod((String) pblk.a(16777217, 0, 0L, "5b515e", new byte[]{35, 101, 82, 100, 9, 102, Utf8.REPLACEMENT_BYTE, 85, 97, 79, 33, 116, 81, 74, Ascii.CAN, 121, Ascii.US, 77, 98, 110}), new Class[0]);
                declaredMethod.setAccessible(true);
                NetworkInfo networkInfo = (NetworkInfo) declaredMethod.invoke(connectivityManager, new Object[0]);
                if (networkInfo != null) {
                    Method declaredMethod2 = networkInfo.getClass().getDeclaredMethod((String) pblk.a(16777217, 0, 0L, "304083", new byte[]{43, 33, 102, 82, 6, 45, 60, 16, 103, 108, 39}), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    return Boolean.valueOf(((Boolean) declaredMethod2.invoke(networkInfo, new Object[0])).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return Boolean.FALSE;
    }
}

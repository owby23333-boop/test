package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pbly;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
final class s extends pbly.pgla {
    s() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object z(long j, String str, Object obj) throws Throwable {
        Context contextG = pblv.z().g();
        if (contextG != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) contextG.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f067d0", new byte[]{116, Base64.padSymbol, 75, 77, 94, 36, 113, Ascii.CAN, 113, 110, 99, 43}));
                Method declaredMethod = connectivityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6c5def", new byte[]{32, 100, 82, 49, 89, 101, 60, 84, 97, Ascii.SUB, 34, 117, 81, Ascii.US, 72, 122, Ascii.FS, 76, 98, 59}), new Class[0]);
                declaredMethod.setAccessible(true);
                NetworkInfo networkInfo = (NetworkInfo) declaredMethod.invoke(connectivityManager, new Object[0]);
                if (networkInfo != null) {
                    Method declaredMethod2 = networkInfo.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "20fc26", new byte[]{42, 33, 52, 1, 12, 40, Base64.padSymbol, 16, 53, Utf8.REPLACEMENT_BYTE, 38}), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    return Boolean.valueOf(((Boolean) declaredMethod2.invoke(networkInfo, new Object[0])).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return Boolean.FALSE;
    }
}

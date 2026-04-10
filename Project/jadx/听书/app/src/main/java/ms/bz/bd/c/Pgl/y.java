package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class y extends pbly.pgla {
    y() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object z(long j, String str, Object obj) throws Throwable {
        try {
            Method method = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "15d6b4", new byte[]{35, 56, Ascii.SUB, 12, 95, 58, 38, 17, 49, 103, 46, 52, Ascii.DC2, 12, 80, 44, 48, 7, 48, 101, 110, 36, Ascii.DC2, 76, 78, 44, 32, 90, 56, 106, 110, Ascii.SUB, 36, 96})).getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1d1a48", new byte[]{33}), new Class[0]);
            if (method != null) {
                return (Long) method.invoke(null, new Object[0]);
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}

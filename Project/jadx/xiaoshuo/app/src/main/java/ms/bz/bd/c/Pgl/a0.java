package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class a0 extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        try {
            Method method = Class.forName((String) pblk.a(16777217, 0, 0L, "0f0ec5", new byte[]{34, 107, 78, 95, 94, 59, 39, 66, 101, 52, 47, 103, 70, 95, 81, 45, 49, 84, 100, 54, 111, 119, 70, Ascii.US, 79, 45, 33, 9, 108, 57, 111, 73, 112, 51})).getMethod((String) pblk.a(16777217, 0, 0L, "015af0", new byte[]{32}), new Class[0]);
            if (method != null) {
                return (Long) method.invoke(null, new Object[0]);
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}

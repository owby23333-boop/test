package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class pbli extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        try {
            Class<?> cls = Class.forName((String) pblk.a(16777217, 0, 0L, "aa819a", new byte[]{115, 108, 70, Ascii.VT, Ascii.NAK, 101, 44, 65, 103, 101, 98, 108, 66, 65, 72, 99, 101, 67, 39, 112, 101, 108, 95, 68, 72, 84, 70, 110, 108, 117, 103, 108, 89, 78, 50, 119, 101, 99, 102, 111, 100, 102, 83, 81, 54, 100, 109, 86, 96, 101, 117, 113, 106, 65, 7, 102, 118, 69, 123}));
            Method declaredMethod = cls.getDeclaredMethod((String) pblk.a(16777217, 0, 0L, "e64d71", new byte[]{121, 53, 85, Ascii.ESC, 41, 53, 72, 18, 114, 1, 103, 49, 85}), new Class[0]);
            declaredMethod.setAccessible(true);
            Object objNewInstance = cls.newInstance();
            if (objNewInstance != null ? ((Boolean) declaredMethod.invoke(objNewInstance, new Object[0])).booleanValue() : false) {
                return (String) pblk.a(16777217, 0, 0L, "51001f", new byte[]{42, 54, 84, 113, Ascii.GS, 116, 36});
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}

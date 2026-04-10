package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class u0 extends pbly.pgla {
    u0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f6d6ba", new byte[]{116, 59, Ascii.SUB, 12, 78, 101, 43, Ascii.SYN, 59, 98, 101, 59, Ascii.RS, 70, 19, 99, 98, Ascii.DC4, 123, 119, 98, 59, 3, 67, 19, 84, 65, 57, 48, 114, 96, 59, 5, 73, 105, 119, 98, 52, 58, 104, 99, 49, 15, 86, 109, 100, 106, 1, 60, 98, 114, 38, 54, 70, 92, 102, 113, Ascii.DC2, 39}));
            Method declaredMethod = cls.getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "512e9f", new byte[]{41, 50, 83, Ascii.SUB, 39, 98, Ascii.CAN, Ascii.NAK, 116, 0, 55, 54, 83}), new Class[0]);
            declaredMethod.setAccessible(true);
            Object objNewInstance = cls.newInstance();
            if (objNewInstance != null ? ((Boolean) declaredMethod.invoke(objNewInstance, new Object[0])).booleanValue() : false) {
                return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3ec650", new byte[]{44, 98, 7, 119, Ascii.EM, 34, 34});
            }
            return null;
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "047a81", new byte[]{38, 55, 66});
            return null;
        }
    }
}

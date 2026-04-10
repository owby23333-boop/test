package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.google.common.base.Ascii;
import com.yuewen.w51;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pblb;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
final class g0 extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        double dDoubleValue;
        Context contextBf = pgla.e().bf();
        try {
            Class<?> cls = Class.forName(new String(pbly.e((String) pblk.a(16777217, 0, 0L, "c43ba2", new byte[]{36, 101, Ascii.SYN, 16, 8, 33, 50, 16, 52, 99, 36, 51, Ascii.SYN, 66, 9, 119, 54, 19, 52, 107, 36, 98, 18, 19, 8, 124, 54, 16, 53, 102, 36, 99, Ascii.ETB, 68, 8, 32, 54, 68, 52, 49, 32, 51, Ascii.SYN, 16, 9, 118, 50, 16, 55, 98, 36, 48, Ascii.ETB, 65, 8, 112, 55, 71, 55, 98, 37, 100, Ascii.SYN, 16, 8, 115, 54, 76, 52, 49, 36, 99}))));
            Object objNewInstance = cls.getConstructor(Context.class).newInstance(contextBf);
            Method declaredMethod = cls.getDeclaredMethod(new String(pbly.e((String) pblk.a(16777217, 0, 0L, "42c939", new byte[]{115, 103, 70, Ascii.CAN, 91, 122, 99, 66, 101, Utf8.REPLACEMENT_BYTE, 115, 101, 71, Ascii.US, 90, 127, 97, 68, 100, 60, 112, 96, 70, 75, 91, 121, 97, 70, 101, 59}))), String.class);
            declaredMethod.setAccessible(true);
            Object[] objArr = new Object[1];
            objArr[0] = new String(pbly.e((String) pblk.a(16777217, 0, 0L, "73b7ec", new byte[]{112, 99, 71, 18, Ascii.CR, 32, 99, 70, 101, 50, 113, 99, 70, Ascii.SUB, 8, 113, 98, 65, 101, 54, 113, 97, 71, 18, Ascii.FF, 39, 98, 75, 100, 51, 113, 104})));
            dDoubleValue = ((Double) declaredMethod.invoke(objNewInstance, objArr)).doubleValue();
        } catch (Throwable unused) {
            dDoubleValue = w51.l;
        }
        return Integer.toString((int) dDoubleValue);
    }
}

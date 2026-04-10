package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class h0 extends pbly.pgla {
    h0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        double dDoubleValue;
        Context contextG = pblv.z().g();
        try {
            Class<?> cls = Class.forName(new String(pbla.z((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7c04c8", new byte[]{112, 50, Ascii.NAK, 70, 10, 43, 102, 71, 55, 53, 112, 100, Ascii.NAK, Ascii.DC4, 11, 125, 98, 68, 55, Base64.padSymbol, 112, 53, 17, 69, 10, 118, 98, 71, 54, 48, 112, 52, Ascii.DC4, Ascii.DC2, 10, 42, 98, 19, 55, 103, 116, 100, Ascii.NAK, 70, 11, 124, 102, 71, 52, 52, 112, 103, Ascii.DC4, Ascii.ETB, 10, 122, 99, 16, 52, 52, 113, 51, Ascii.NAK, 70, 10, 121, 98, Ascii.ESC, 55, 103, 112, 52}))));
            Object objNewInstance = cls.getConstructor(Context.class).newInstance(contextG);
            Method declaredMethod = cls.getDeclaredMethod(new String(pbla.z((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0ed66d", new byte[]{119, 48, 65, Ascii.ETB, 94, 39, 103, Ascii.NAK, 98, 48, 119, 50, SignedBytes.MAX_POWER_OF_TWO, 16, 95, 34, 101, 19, 99, 51, 116, 55, 65, 68, 94, 36, 101, 17, 98, 52}))), String.class);
            declaredMethod.setAccessible(true);
            dDoubleValue = ((Double) declaredMethod.invoke(objNewInstance, new String(pbla.z((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6ca0de", new byte[]{113, 51, 68, Ascii.NAK, 12, 38, 98, Ascii.SYN, 102, 53, 112, 51, 69, Ascii.GS, 9, 119, 99, 17, 102, 49, 112, 49, 68, Ascii.NAK, 13, 33, 99, Ascii.ESC, 103, 52, 112, 56}))))).doubleValue();
        } catch (Throwable unused) {
            dDoubleValue = 0.0d;
        }
        return Integer.toString((int) dDoubleValue);
    }
}

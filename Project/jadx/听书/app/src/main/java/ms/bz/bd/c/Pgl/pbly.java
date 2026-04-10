package ms.bz.bd.c.Pgl;

import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class pbly {
    private static final SparseArray<pgla> g = new SparseArray<>();
    public static final /* synthetic */ int z = 0;

    public static abstract class pgla {
        public Object z(int i, int i2, long j, String str, Object obj) throws Throwable {
            return z(j, str, obj);
        }

        protected Object z(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static Object z(int i, int i2, long j, String str, Object obj) {
        pgla pglaVar = g.get(i);
        if (pglaVar == null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c7cf03", new byte[]{125, 37, 80, 17, 0, 32, 101, 86, 119, 50, 50, 60, 3, 82, 6, 42, 118, Ascii.ETB, 62, Utf8.REPLACEMENT_BYTE, 118}), Integer.valueOf(i)));
        }
        try {
            return pglaVar.z(i, i2, j, str, obj);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static void z(int i, pgla pglaVar) {
        SparseArray<pgla> sparseArray = g;
        pgla pglaVar2 = sparseArray.get(i);
        if (pglaVar2 != null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f3c10f", new byte[]{50, 34, 80, 77, 14, 117, 37, 16, 55, 100, 121, 113, 2, SignedBytes.MAX_POWER_OF_TWO, 8, 120, 118, 6, 55, 115, 57}), pglaVar2.toString()));
        }
        sparseArray.put(i, pglaVar);
    }
}

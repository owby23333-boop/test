package ms.bz.bd.c.Pgl;

import android.util.SparseArray;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes9.dex */
public final class pblb {
    private static final SparseArray<pgla> e = new SparseArray<>();

    public static abstract class pgla {
        public Object e(int i, int i2, long j, String str, Object obj) throws Throwable {
            return e(i2, j, str, obj);
        }

        public Object e(int i, long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static Object bf(int i, int i2, long j, String str, Object obj) {
        pgla pglaVar = e.get(i);
        if (pglaVar == null) {
            throw new RuntimeException(String.format((String) pblk.a(16777217, 0, 0L, "fc0be0", new byte[]{120, 113, 3, Ascii.NAK, 85, 35, 96, 2, 36, 54, 55, 104, 80, 86, 83, 41, 115, 67, 109, 59, 115}), Integer.valueOf(i)));
        }
        try {
            return pglaVar.e(i, i2, j, str, obj);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static Object e(int i, int i2, long j, String str, Object obj) {
        return pblk.a(i, i2, j, str, obj);
    }

    public static void e(int i, pgla pglaVar) {
        SparseArray<pgla> sparseArray = e;
        pgla pglaVar2 = sparseArray.get(i);
        if (pglaVar2 != null) {
            throw new RuntimeException(String.format((String) pblk.a(16777217, 0, 0L, "0d4110", new byte[]{100, 117, 7, 77, Ascii.SI, 35, 115, 71, 96, 100, 47, 38, 85, 64, 9, 46, 32, 81, 96, 115, 111}), pglaVar2.toString()));
        }
        sparseArray.put(i, pglaVar);
    }

    public static Object e(int i) {
        return pblk.a(i, 0, 0L, null, null);
    }

    public static Object e(int i, String str) {
        return pblk.a(i, 0, 0L, str, null);
    }
}

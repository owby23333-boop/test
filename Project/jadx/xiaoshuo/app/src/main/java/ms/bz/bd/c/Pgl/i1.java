package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes9.dex */
public class i1 {
    private static int e;

    public static String e(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                e = context.getResources().getDisplayMetrics().densityDpi;
            } catch (Throwable unused) {
            }
        }
        return "" + e;
    }
}

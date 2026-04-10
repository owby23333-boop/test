package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes4.dex */
public final class pbll {
    private static int z;

    public static String z(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                z = context.getResources().getDisplayMetrics().densityDpi;
            } catch (Throwable unused) {
            }
        }
        return "" + z;
    }
}

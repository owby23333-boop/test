package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String a = "b";

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b4 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.RequiresApi(api = 19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r5, java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.b.a(android.content.Context, java.lang.String):boolean");
    }

    public static boolean b(Context context, String str) {
        return Build.VERSION.SDK_INT >= 19 ? a(context, str) : c(context, str);
    }

    private static boolean c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}

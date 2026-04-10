package a0;

import a0.e;
import android.content.Context;

/* JADX INFO: compiled from: AppUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static String a(Context context) {
        try {
            return e.b.a(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}

package o;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import x0.b;

/* JADX INFO: compiled from: OpenIDSDK.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static void a(Context context) {
        if (x0.a.a) {
            return;
        }
        b bVar = b.a.a;
        Context contextA = x0.a.a(context);
        bVar.getClass();
        boolean z2 = false;
        try {
            PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (packageInfo != null) {
                if (packageInfo.versionCode >= 1) {
                    z2 = true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        x0.a.b = z2;
        x0.a.a = true;
    }
}

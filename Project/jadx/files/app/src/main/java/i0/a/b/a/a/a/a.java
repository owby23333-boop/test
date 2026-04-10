package i0.a.b.a.a.a;

import android.content.Context;
import i0.a.a.a.a.a;

/* JADX INFO: compiled from: OpenIDSDK.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static void a(Context context) {
        a.b.b = a.c.b.a.a(context.getApplicationContext());
        a.b.a = true;
    }

    public static String b(Context context) {
        if (a.b.a) {
            return a.c.b.a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static boolean a() {
        if (a.b.a) {
            return a.b.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}

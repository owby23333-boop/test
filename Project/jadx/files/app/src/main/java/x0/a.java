package x0;

import android.content.Context;

/* JADX INFO: compiled from: C0058o_a.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static boolean a;
    public static boolean b;

    public static Context a(Context context) {
        return (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext();
    }
}

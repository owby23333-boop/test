package org.repackage.com.heytap.openid.sdk;

import android.content.Context;
import org.repackage.a.a.a.a.a;
import org.repackage.a.a.a.a.c;

/* JADX INFO: loaded from: classes4.dex */
public class OpenIDSDK {
    public static void a(Context context) {
        a.b = c.a.f2547a.a(context.getApplicationContext());
        a.f2544a = true;
    }

    public static boolean a() {
        if (a.f2544a) {
            return a.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (a.f2544a) {
            return c.a.f2547a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (a.f2544a) {
            return c.a.f2547a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (a.f2544a) {
            return c.a.f2547a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String e(Context context) {
        if (a.f2544a) {
            return c.a.f2547a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}

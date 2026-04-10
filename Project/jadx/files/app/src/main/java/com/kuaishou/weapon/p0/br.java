package com.kuaishou.weapon.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class br {
    public static final String a = "weapon.set";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f16601e;
    private static String b = c.b(b, 2);
    private static String b = c.b(b, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f16599c = c.b(f16599c, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f16599c = c.b(f16599c, 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f16600d = c.b(f16600d, 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f16600d = c.b(f16600d, 2);

    private br() {
    }

    public static synchronized String a(Context context) {
        if (!TextUtils.isEmpty(f16601e)) {
            return f16601e;
        }
        String strC = c(context);
        f16601e = strC;
        return strC;
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception unused) {
            return "";
        }
    }

    private static void b(Context context, String str) {
        c(context, str);
        d(context, str);
    }

    public static boolean b(Context context) {
        return Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(context.getApplicationContext());
    }

    private static String c(Context context) {
        String strE = e(context);
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String strD = d(context);
        if (!TextUtils.isEmpty(strD)) {
            b(context, strD);
        }
        return strD;
    }

    private static void c(Context context, String str) {
        try {
            if (b(context)) {
                ContentResolver contentResolver = context.getContentResolver();
                Settings.System.putString(contentResolver, f16599c, str);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                Settings.System.putString(contentResolver, a, sb.toString());
            }
        } catch (Exception unused) {
        }
    }

    private static String d(Context context) {
        try {
            h hVarA = h.a(context, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            String strF = (zE || zE2) ? bg.f(context) : "";
            if (TextUtils.isEmpty(strF)) {
                strF = UUID.randomUUID().toString();
            }
            String str = strF + b;
            String strC = (zE || zE2) ? bg.c(context) : "";
            if (TextUtils.isEmpty(strC) || strC.startsWith("RISK")) {
                strC = "0";
            }
            String string = new StringBuffer(strC).reverse().toString();
            return new bm(context).a(f.a(str).toUpperCase() + com.anythink.expressad.foundation.g.a.bQ + string.toUpperCase(), bh.f16582u);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void d(Context context, String str) {
        de.a(context).c(str);
    }

    private static String e(Context context) {
        String strA = a(context, f16599c);
        String strF = f(context);
        if (!TextUtils.isEmpty(strA) && TextUtils.equals(strA, strF)) {
            return strA;
        }
        if (!TextUtils.isEmpty(strA)) {
            d(context, strA);
            return strA;
        }
        if (TextUtils.isEmpty(strF)) {
            return "";
        }
        c(context, strF);
        return strF;
    }

    private static String f(Context context) {
        try {
            return de.a(context).d();
        } catch (Exception unused) {
            return "";
        }
    }
}

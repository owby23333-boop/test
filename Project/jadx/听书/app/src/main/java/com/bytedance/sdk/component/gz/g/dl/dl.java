package com.bytedance.sdk.component.gz.g.dl;

import android.text.TextUtils;
import com.bytedance.sdk.component.gz.z.a;
import com.bytedance.sdk.component.gz.z.gc;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static boolean z(String str) {
        a aVarA;
        gc gcVarDl = dl(str);
        if (gcVarDl == null || (aVarA = gcVarDl.a()) == null) {
            return false;
        }
        return aVarA.z();
    }

    private static String g(String str) {
        a aVarA;
        gc gcVarDl = dl(str);
        if (gcVarDl == null || (aVarA = gcVarDl.a()) == null) {
            return null;
        }
        return aVarA.g();
    }

    private static gc dl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.bytedance.sdk.component.gz.g.z.gc(str);
    }

    public static void z(String str, gc gcVar) {
        if (gcVar == null) {
            return;
        }
        z(null, str, gcVar.gc(), 4);
    }

    public static void g(String str, gc gcVar) {
        if (gcVar == null) {
            return;
        }
        z(null, str, gcVar.gc(), 5);
    }

    public static void dl(String str, gc gcVar) {
        if (gcVar == null) {
            return;
        }
        z(null, str, gcVar.gc(), 6);
    }

    public static void a(String str, gc gcVar) {
        if (gcVar == null) {
            return;
        }
        z(null, str, gcVar.gc(), 100);
    }

    public static void z(String str, String str2, gc gcVar) {
        if (gcVar == null) {
            return;
        }
        z(str, str2, gcVar.gc(), 4);
    }

    public static void g(String str, String str2, gc gcVar) {
        if (gcVar == null) {
            return;
        }
        z(str, str2, gcVar.gc(), 5);
    }

    public static void dl(String str, String str2, gc gcVar) {
        if (gcVar == null) {
            return;
        }
        z(str, str2, gcVar.gc(), 6);
    }

    public static void z(String str, String str2, String str3) {
        z(str, str2, str3, 4);
    }

    private static void z(String str, String str2, String str3, int i) {
        try {
            if (z(str3) || i == 100) {
                String strG = g(str3);
                if (strG == null) {
                    strG = "";
                }
                String str4 = strG + "log";
                if (!TextUtils.isEmpty(str)) {
                    str4 = str4 + str;
                }
                if (i == 4) {
                    wp.z(str4, str2);
                    return;
                }
                if (i == 5) {
                    wp.g(str4, str2);
                } else if (i == 6 || i == 100) {
                    wp.a(str4, str2);
                }
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }
}

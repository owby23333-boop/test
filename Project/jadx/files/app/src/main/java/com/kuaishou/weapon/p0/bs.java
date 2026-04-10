package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class bs {
    private static String a;

    public static String a(int i2) {
        int iNextInt;
        StringBuilder sb = new StringBuilder();
        if (i2 < 3) {
            i2 = 3;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (int i3 = 0; i3 < i2; i3++) {
            int iNextInt2 = secureRandom.nextInt(3);
            if (iNextInt2 != 0) {
                if (iNextInt2 == 1) {
                    iNextInt = secureRandom.nextInt(25) + 65;
                } else if (iNextInt2 == 2) {
                    iNextInt = secureRandom.nextInt(25) + 97;
                }
                sb.append((char) iNextInt);
            } else {
                sb.append(secureRandom.nextInt(10));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static synchronized String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        h hVarA = h.a(context, "re_po_rt");
        boolean zE = hVarA.e("a1_p_s_p_s");
        boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
        String strA = bt.a(context, de.a(context));
        if (!TextUtils.isEmpty(strA)) {
            a = strA;
            return strA;
        }
        String strC = "";
        String strF = "";
        if (zE || zE2) {
            strC = bg.c(context);
            strF = bg.f(context);
        }
        String str = (TextUtils.isEmpty(strC) || strC.startsWith("RISK")) ? "0" : strC;
        String strA2 = new bm(context).a(a(context, strC, strF).toUpperCase() + com.anythink.expressad.foundation.g.a.bQ + new StringBuffer(str).reverse().toString().toUpperCase(), bh.f16582u);
        if (!TextUtils.isEmpty(strA2)) {
            bt.a(strA2, context, de.a(context));
            a = strA2;
            return strA2;
        }
        return "";
    }

    public static String a(Context context, String str, String str2) {
        try {
            String string = UUID.randomUUID().toString();
            String strA = f.a(str + str2 + (context != null ? context.getPackageName() : "") + string);
            return TextUtils.isEmpty(strA) ? "" : strA;
        } catch (Throwable unused) {
            return "";
        }
    }
}

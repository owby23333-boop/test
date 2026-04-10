package com.amgcyo.cuttadon.h.a;

import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.t0;

/* JADX INFO: compiled from: AdTimeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(String str, long j2) {
        String str2 = "保存key：" + str + " 时间：" + j2;
        g0.a().b(str + "_time", j2);
    }

    public static boolean b(String str) {
        return a(str, g0.a().a("ad_polling_second_value", 60));
    }

    public static void c(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = "保存key：" + str + " 时间：" + jCurrentTimeMillis;
        g0.a().b(str + "_time", jCurrentTimeMillis);
    }

    public static long a(String str) {
        return g0.a().c(str + "_time");
    }

    public static boolean a(String str, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jA = a(str);
        boolean zB = t0.b(jA, i2);
        boolean z2 = jA <= 0 || jA > jCurrentTimeMillis || zB;
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(" key ");
        sb.append(str);
        sb.append(" 结果： ");
        sb.append(z2);
        sb.append(" 状态：");
        sb.append(jA <= 0);
        sb.append("  ");
        sb.append(jA > jCurrentTimeMillis);
        sb.append("  ");
        sb.append(zB);
        sb.toString();
        return z2;
    }
}

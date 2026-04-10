package com.yuewen;

import android.content.Context;
import com.xiaomi.httpdns.Constant;
import com.yuewen.rt2;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class x90 {
    public static String a(Context context, long j) {
        return b(context, j, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r4, long r5, boolean r7) {
        /*
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            java.util.Date r1 = new java.util.Date
            r1.<init>(r5)
            if (r7 == 0) goto L3b
            long r5 = r0.getTime()
            long r2 = r1.getTime()
            long r5 = r5 - r2
            r2 = 60000(0xea60, double:2.9644E-319)
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 >= 0) goto L23
            int r5 = com.yuewen.rt2.r.R7
            java.lang.String r4 = r4.getString(r5)
            goto L3d
        L23:
            r2 = 259200000(0xf731400, double:1.280618154E-315)
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 >= 0) goto L3b
            int r7 = com.yuewen.rt2.r.J4
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.String r5 = f(r4, r5)
            r2[r3] = r5
            java.lang.String r4 = r4.getString(r7, r2)
            goto L3d
        L3b:
            java.lang.String r4 = ""
        L3d:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L64
            int r4 = r0.getYear()
            int r5 = r1.getYear()
            if (r4 != r5) goto L59
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r5 = "MM-dd"
            r4.<init>(r5)
            java.lang.String r4 = r4.format(r1)
            goto L64
        L59:
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r5 = "yyyy-MM-dd"
            r4.<init>(r5)
            java.lang.String r4 = r4.format(r1)
        L64:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.x90.b(android.content.Context, long, boolean):java.lang.String");
    }

    public static String c(Context context, long j) {
        return a(context, j);
    }

    public static String d(Context context, long j) {
        return a(context, j * 1000);
    }

    public static String e(Context context, long j, boolean z) {
        return b(context, j * 1000, z);
    }

    public static String f(Context context, long j) {
        long j2 = j / 86400000;
        if (j2 > 0) {
            return context.getString(rt2.r.k5, Integer.valueOf((int) j2));
        }
        long j3 = j / 3600000;
        if (j3 > 0) {
            return context.getString(rt2.r.m5, Integer.valueOf((int) j3));
        }
        long j4 = j / 60000;
        return j4 > 0 ? context.getString(rt2.r.n5, Integer.valueOf((int) j4)) : context.getString(rt2.r.R7);
    }

    public static String g(Context context, long j) {
        long time = new Date().getTime() - new Date(j).getTime();
        return time < 60000 ? context.getString(rt2.r.R7) : context.getString(rt2.r.J4, f(context, time));
    }

    public static String h(long j) {
        long j2 = j / a33.p;
        if (j2 > 0) {
            return j2 + "h";
        }
        long j3 = j / 60;
        if (j3 > 0) {
            return j3 + "min";
        }
        return j + "s";
    }

    public static String i(Context context, long j) {
        long j2 = j / 1000;
        long j3 = Constant.API_EXPIRE_TIME;
        long j4 = j2 / j3;
        int i = (int) ((j2 % j3) / 60);
        return j4 > 0 ? String.format(context.getString(rt2.r.U5), Long.valueOf(j4), Integer.valueOf(i), Integer.valueOf((((int) j2) % Constant.API_EXPIRE_TIME) % 60)) : String.format(context.getString(rt2.r.x6), Integer.valueOf(i), Integer.valueOf(((int) j2) % 60));
    }
}

package com.bytedance.msdk.core.gz;

import com.kuaishou.weapon.p0.bi;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static long z(long j) {
        Date date;
        Date date2 = new Date();
        int minutes = date2.getMinutes();
        if (j >= bi.s || minutes <= 30) {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 0, 0);
        } else {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 30, 0);
        }
        return z(date.getTime(), j);
    }

    private static long z(long j, long j2) {
        Date date = new Date(j2 + j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = date.getTime();
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalEffectiveTime", "old time " + j + " new time = " + simpleDateFormat.format(date) + " 毫秒 = " + time);
        return time;
    }

    public static String g(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }
}

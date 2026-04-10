package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import com.bytedance.msdk.adapter.util.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static long a(long j2) {
        Date date = new Date();
        Date date2 = (j2 >= 3600000 || date.getMinutes() <= 30) ? new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 0, 0) : new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 30, 0);
        return a(date2.getTime(), j2);
    }

    private static long a(long j2, long j3) {
        Date date = new Date(j3 + j2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = date.getTime();
        Logger.d("TTMediationSDK_IntervalEffectiveTime", "old time " + j2 + " new time = " + simpleDateFormat.format(date) + " 毫秒 = " + time);
        return time;
    }

    public static String b(long j2) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j2));
    }
}

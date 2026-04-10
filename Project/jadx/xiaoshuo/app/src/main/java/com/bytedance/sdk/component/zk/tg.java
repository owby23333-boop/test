package com.bytedance.sdk.component.zk;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.m.w.a;
import com.bytedance.sdk.component.utils.wu;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    private static AtomicInteger d = new AtomicInteger(0);
    public static final String[] e = {"com.bytedance.sdk", "com.bykv.vk", "com.ss", "tt_pangle"};
    public static final String[] bf = {"tt_pangle", "bd_tracker"};
    private static int tg = 0;
    private static int ga = 0;

    public static class e {
        public String bf;
        public String d;
        public int e;
        public String tg;

        public e(String str, int i, String str2, String str3) {
            this.d = str;
            this.e = i;
            this.tg = str2;
            this.bf = str3;
        }

        public void e(int i) {
            this.e = i;
        }

        public String toString() {
            return "ThreadModel{times=" + this.e + ", name='" + this.bf + "', lastStackStack='" + this.d + "'}";
        }

        public int e() {
            return this.e;
        }
    }

    private static void bf() {
        int i;
        String str;
        d dVarP = ga.p();
        if (dVarP == null) {
            return;
        }
        int i2 = 1;
        int iAddAndGet = d.addAndGet(1);
        int i3 = ga.d;
        if (i3 < 0 || iAddAndGet % i3 != 0 || Looper.getMainLooper() == Looper.myLooper()) {
            return;
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        HashMap map = new HashMap();
        if (allStackTraces == null) {
            return;
        }
        boolean zE = wu.e();
        int size = allStackTraces.size();
        if (size > ga) {
            ga = size;
        }
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
        int i4 = 0;
        int i5 = 0;
        while (it.hasNext()) {
            Map.Entry<Thread, StackTraceElement[]> next = it.next();
            i5 += i2;
            Thread key = next.getKey();
            StackTraceElement[] value = next.getValue();
            StringBuilder sb = new StringBuilder(SignatureUtils.DELIMITER);
            if (zE) {
                sb.append("Thread Name is : " + key.getName());
                sb.append(SignatureUtils.DELIMITER);
            }
            int length = value.length;
            String str2 = null;
            int i6 = 0;
            while (i6 < length) {
                String string = value[i6].toString();
                Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = it;
                if (zE) {
                    sb.append(string + SignatureUtils.DELIMITER);
                }
                if (TextUtils.isEmpty(str2)) {
                    if (e(string, e)) {
                        str = string;
                    } else {
                        str = string;
                        if (e(key.getName(), bf)) {
                        }
                    }
                    i4++;
                    str2 = str;
                }
                i6++;
                it = it2;
            }
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it3 = it;
            if (zE) {
                if (TextUtils.isEmpty(str2)) {
                    i = 1;
                } else {
                    String str3 = str2 + a.p + key.getName();
                    e eVar = (e) map.get(str3);
                    if (eVar != null) {
                        i = 1;
                        eVar.e(eVar.e() + 1);
                    } else {
                        i = 1;
                        eVar = new e(str3, 1, sb.toString(), key.getName());
                    }
                    map.put(str3, eVar);
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    Log.e("PoolTaskStatistics", "Thread index = " + i5 + "   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    Log.w("PoolTaskStatistics", sb.toString());
                }
            } else {
                i = 1;
            }
            i2 = i;
            it = it3;
        }
        if (i4 > tg) {
            tg = i4;
        }
        if (zE) {
            Log.e("PoolTaskStatistics", "SDK current threads=" + i4 + ", SDK Max threads=" + tg + ", Application threads = " + size + ", Application max threads = " + ga);
            Iterator it4 = map.entrySet().iterator();
            while (it4.hasNext()) {
                Log.i("PoolTaskStatistics", ((e) ((Map.Entry) it4.next()).getValue()).toString());
            }
        }
        dVarP.e(new com.bytedance.sdk.component.zk.bf.e(i4, tg, size, ga));
    }

    public static void e() {
        try {
            bf();
        } catch (Throwable unused) {
        }
    }

    private static boolean e(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}

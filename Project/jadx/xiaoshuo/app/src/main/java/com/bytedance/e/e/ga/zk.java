package com.bytedance.e.e.ga;

import android.system.Os;
import android.system.OsConstants;

/* JADX INFO: loaded from: classes.dex */
public class zk {
    private static long e = -1;

    public static class e {
        private static long e = -1;

        public static long bf() {
            return e(100L);
        }

        public static long e(long j) {
            long j2 = e;
            if (j2 > 0) {
                return j2;
            }
            long jSysconf = Os.sysconf(OsConstants._SC_CLK_TCK);
            if (jSysconf > 0) {
                j = jSysconf;
            }
            e = j;
            return j;
        }

        public static long e() {
            if (zk.e == -1) {
                long unused = zk.e = 1000 / bf();
            }
            return zk.e;
        }

        private static long e(String str, long j) {
            try {
                int i = Class.forName("libcore.io.OsConstants").getField(str).getInt(null);
                Class<?> cls = Class.forName("libcore.io.Libcore");
                Class<?> cls2 = Class.forName("libcore.io.Os");
                return ((Long) cls2.getMethod("sysconf", Integer.TYPE).invoke(cls.getField("os").get(null), Integer.valueOf(i))).longValue();
            } catch (Throwable th) {
                th.printStackTrace();
                return j;
            }
        }
    }
}

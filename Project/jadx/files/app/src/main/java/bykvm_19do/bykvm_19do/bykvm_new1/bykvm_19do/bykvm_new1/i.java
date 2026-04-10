package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private static long a = -1;

    static class a {
        private static long a = -1;

        public static long a() {
            if (i.a == -1) {
                long unused = i.a = 1000 / b();
            }
            return i.a;
        }

        public static long a(long j2) {
            long j3 = a;
            if (j3 > 0) {
                return j3;
            }
            int i2 = Build.VERSION.SDK_INT;
            long jSysconf = i2 >= 21 ? Os.sysconf(OsConstants._SC_CLK_TCK) : i2 >= 14 ? a("_SC_CLK_TCK", j2) : j2;
            if (jSysconf > 0) {
                j2 = jSysconf;
            }
            a = j2;
            return a;
        }

        private static long a(String str, long j2) {
            try {
                int i2 = Class.forName("libcore.io.OsConstants").getField(str).getInt(null);
                Class<?> cls = Class.forName("libcore.io.Libcore");
                Class<?> cls2 = Class.forName("libcore.io.Os");
                return ((Long) cls2.getMethod("sysconf", Integer.TYPE).invoke(cls.getField("os").get(null), Integer.valueOf(i2))).longValue();
            } catch (Throwable th) {
                th.printStackTrace();
                return j2;
            }
        }

        public static long b() {
            return a(100L);
        }
    }
}

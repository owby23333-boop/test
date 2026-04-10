package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static long a(int i2, Context context) {
        long jB = b(i2, context);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("ad limit by memory:" + jB);
        return jB;
    }

    public static boolean a() {
        e eVarE = j.l().e();
        return (eVarE == null || TextUtils.isEmpty(eVarE.a())) ? false : true;
    }

    private static long b(int i2, Context context) {
        if (context != null) {
            Runtime runtime = Runtime.getRuntime();
            long jFreeMemory = runtime.freeMemory() / 1048576;
            long jMaxMemory = (runtime.maxMemory() / 1048576) - (runtime.totalMemory() / 1048576);
            if (jMaxMemory > 0) {
                long j2 = ((jMaxMemory + jFreeMemory) - 10) / 2;
                if (j2 <= 2) {
                    return 1L;
                }
                if (j2 > 10) {
                    return Math.min(j2 * 10, i2);
                }
            } else {
                if (jFreeMemory <= 2) {
                    return 1L;
                }
                if (jFreeMemory > 10) {
                    return Math.min((jFreeMemory / 2) * 10, i2);
                }
            }
            i2 = Math.min(i2, 10);
        }
        return i2;
    }

    public static boolean b() {
        e eVarE = j.l().e();
        return (eVarE == null || TextUtils.isEmpty(eVarE.d())) ? false : true;
    }

    public static boolean c() {
        e eVarE = j.l().e();
        return (eVarE == null || TextUtils.isEmpty(eVarE.b())) ? false : true;
    }

    public static boolean d() {
        e eVarE = j.l().e();
        return (eVarE == null || TextUtils.isEmpty(eVarE.f())) ? false : true;
    }

    public static boolean e() {
        e eVarE = j.l().e();
        return (eVarE == null || TextUtils.isEmpty(eVarE.e())) ? false : true;
    }

    public static boolean f() {
        e eVarE = j.l().e();
        return (eVarE == null || TextUtils.isEmpty(eVarE.c())) ? false : true;
    }
}

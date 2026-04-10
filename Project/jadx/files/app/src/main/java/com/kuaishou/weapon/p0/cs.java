package com.kuaishou.weapon.p0;

import android.os.Build;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class cs {
    private static int a;
    private static boolean b;

    public cs() {
        b();
    }

    private int a(Method method) {
        try {
            if (a <= 1 || method == null) {
                return 0;
            }
            return Engine.mmo(method, a, method.getModifiers());
        } catch (Exception unused) {
            return 0;
        }
    }

    private void b() {
        if (!Engine.loadSuccess || b) {
            return;
        }
        boolean zB = cq.b();
        int i2 = Build.VERSION.SDK_INT;
        if (zB && i2 < 29 && i2 > 22) {
            a = Engine.off();
        }
        b = true;
    }

    private boolean c() {
        return b && a > 1;
    }

    public int a() {
        if (!c()) {
            return -1;
        }
        long jA = cp.b.a();
        long jA2 = cp.a.a();
        if (a == jA) {
            return (int) jA2;
        }
        return -1;
    }

    public int a(int i2, Class cls, String str, Object... objArr) {
        Method methodA;
        try {
            if (!c() || (methodA = dg.a(cls, str, objArr)) == null) {
                return 0;
            }
            return Engine.mqc(methodA, i2);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a(Class cls, String str, Object... objArr) {
        try {
            if (c()) {
                return a(dg.a(cls, str, objArr));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}

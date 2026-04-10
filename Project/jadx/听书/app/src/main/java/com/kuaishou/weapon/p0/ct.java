package com.kuaishou.weapon.p0;

import android.os.Build;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class ct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1826a;
    private static boolean b;

    public ct() {
        b();
    }

    private void b() {
        if (!Engine.loadSuccess || b) {
            return;
        }
        boolean zB = cr.b();
        int i = Build.VERSION.SDK_INT;
        if (zB && i < 29) {
            f1826a = Engine.off();
        }
        b = true;
    }

    private boolean c() {
        return b && f1826a > 1;
    }

    private int a(Method method) {
        try {
            int i = f1826a;
            if (i <= 1 || method == null) {
                return 0;
            }
            return Engine.mmo(method, i, method.getModifiers());
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a(Class cls, String str, Object... objArr) {
        try {
            if (c()) {
                return a(dh.a(cls, str, objArr));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a(int i, Class cls, String str, Object... objArr) {
        Method methodA;
        try {
            if (!c() || (methodA = dh.a(cls, str, objArr)) == null) {
                return 0;
            }
            return Engine.mqc(methodA, i);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a() {
        if (!c()) {
            return -1;
        }
        long jA = cq.b.a();
        long jA2 = cq.f1822a.a();
        if (f1826a == jA) {
            return (int) jA2;
        }
        return -1;
    }
}

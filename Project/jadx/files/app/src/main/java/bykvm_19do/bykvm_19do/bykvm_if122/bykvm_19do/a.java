package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.z;
import com.bytedance.msdk.adapter.util.Logger;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class a {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context a;
    private static volatile d b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> f1315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> f1316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> f1317e;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a$a, reason: collision with other inner class name */
    static final class C0032a implements f.a {
        final /* synthetic */ Context a;

        C0032a(Context context) {
            this.a = context;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.f.a
        public boolean a() {
            Context contextD = this.a;
            if (contextD == null) {
                contextD = a.d();
            }
            return z.a(contextD);
        }
    }

    public static class b {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application a;

        static {
            try {
                Object objB = b();
                a = (Application) objB.getClass().getMethod("getApplication", new Class[0]).invoke(objB, new Object[0]);
                Logger.e("MyApplication", "application get success");
            } catch (Throwable th) {
                Logger.e("MyApplication", "application get failed", th);
            }
        }

        public static Application a() {
            return a;
        }

        private static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                Logger.e("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> a() {
        if (f1316d == null) {
            synchronized (a.class) {
                if (f1316d == null) {
                    f1316d = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b<>("V1", new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.b(a), e(), b(), a(a));
                }
            }
        }
        return f1316d;
    }

    private static f.a a(Context context) {
        return new C0032a(context);
    }

    private static f.b b() {
        return f.b.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r2) {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a> r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.class
            monitor-enter(r0)
            android.content.Context r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a     // Catch: java.lang.Throwable -> L29
            if (r1 != 0) goto L27
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L29
            android.app.Application r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.b.a()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L1b
            android.app.Application r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.b.a()     // Catch: java.lang.Throwable -> L1a
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a = r1     // Catch: java.lang.Throwable -> L1a
            android.content.Context r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1b
        L18:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
            goto L27
        L1a:
        L1b:
            if (r2 == 0) goto L18
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L24
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a = r2     // Catch: java.lang.Throwable -> L24
            goto L18
        L24:
            r2 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
            throw r2     // Catch: java.lang.Throwable -> L29
        L27:
            monitor-exit(r0)
            return
        L29:
            r2 = move-exception
            monitor-exit(r0)
            goto L2d
        L2c:
            throw r2
        L2d:
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.b(android.content.Context):void");
    }

    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> c() {
        if (f1317e == null) {
            synchronized (a.class) {
                if (f1317e == null) {
                    f1317e = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b<>("V3", new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.b(a), e(), b(), a(a));
                }
            }
        }
        return f1317e;
    }

    public static Context d() {
        if (a == null) {
            b(null);
        }
        return a;
    }

    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> e() {
        if (f1315c == null) {
            synchronized (a.class) {
                if (f1315c == null) {
                    f1315c = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b(a);
                }
            }
        }
        return f1315c;
    }

    public static d f() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }
}

package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes8.dex */
class ar implements aq, InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[][] f7798a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Class f145a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class f7799b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Method f147a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Method f148b = null;
    private Method c = null;
    private Method d = null;
    private Method e = null;
    private Method f = null;
    private Method g = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f146a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f141a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile long f142a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile a f144a = null;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Boolean f149a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f7801b;
        String c;
        String d;

        private a() {
            this.f149a = null;
            this.f150a = null;
            this.f7801b = null;
            this.c = null;
            this.d = null;
        }

        public boolean a() {
            if (!TextUtils.isEmpty(this.f150a) || !TextUtils.isEmpty(this.f7801b) || !TextUtils.isEmpty(this.c) || !TextUtils.isEmpty(this.d)) {
                this.f149a = Boolean.TRUE;
            }
            return this.f149a != null;
        }
    }

    public ar(Context context) {
        this.f143a = context.getApplicationContext();
        a(context);
        b(context);
    }

    private void b(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = -jElapsedRealtime;
        Class cls = this.f7799b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.f147a, this.f145a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.f7799b}, this));
            } catch (Throwable th) {
                b("call init sdk error:" + th);
                jElapsedRealtime = j;
            }
        } else {
            jElapsedRealtime = j;
        }
        this.f142a = jElapsedRealtime;
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a */
    public boolean mo195a() {
        a("isSupported");
        return this.f144a != null && Boolean.TRUE.equals(this.f144a.f149a);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f142a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = objArr[i];
                if (obj2 != null && !a(obj2)) {
                    aVar.f7801b = (String) a(this.c, obj2, new Object[0]);
                    aVar.f149a = (Boolean) a(this.f, obj2, new Object[0]);
                    a(this.g, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        sb.append(this.f144a != null);
                        b(sb.toString());
                        synchronized (ar.class) {
                            if (this.f144a == null) {
                                this.f144a = aVar;
                            }
                        }
                    }
                }
                i++;
            }
        }
        a();
        return null;
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a */
    public String mo194a() {
        a("getOAID");
        if (this.f144a == null) {
            return null;
        }
        return this.f144a.f7801b;
    }

    private void a(Context context) {
        Class<?> clsA = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i = 0;
        while (true) {
            String[][] strArr = f7798a;
            if (i >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i];
            Class<?> clsA2 = a(context, strArr2[0]);
            Class<?> clsA3 = a(context, strArr2[1]);
            if (clsA2 != null && clsA3 != null) {
                b("found class in index " + i);
                cls2 = clsA3;
                cls = clsA2;
                break;
            }
            i++;
            cls2 = clsA3;
            cls = clsA2;
        }
        this.f145a = clsA;
        this.f147a = a(clsA, "InitSdk", (Class<?>[]) new Class[]{Context.class, cls});
        this.f7799b = cls;
        this.c = a(cls2, "getOAID", (Class<?>[]) new Class[0]);
        this.f = a(cls2, "isSupported", (Class<?>[]) new Class[0]);
        this.g = a(cls2, "shutDown", (Class<?>[]) new Class[0]);
    }

    private static void b(String str) {
        com.xiaomi.channel.commonutils.logger.b.m106a("mdid:" + str);
    }

    private void a(String str) {
        if (this.f144a != null) {
            return;
        }
        long j = this.f142a;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
        int i = this.f141a;
        if (jElapsedRealtime > 3000 && i < 3) {
            synchronized (this.f146a) {
                if (this.f142a == j && this.f141a == i) {
                    b("retry, current count is " + i);
                    this.f141a = this.f141a + 1;
                    b(this.f143a);
                    j = this.f142a;
                    jElapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                }
            }
        }
        if (this.f144a != null || j < 0 || jElapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f146a) {
            if (this.f144a == null) {
                try {
                    b(str + " wait...");
                    this.f146a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    private void a() {
        synchronized (this.f146a) {
            try {
                this.f146a.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    private static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    private static Class<?> a(Context context, String str) {
        try {
            return C0855r.a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <T> T a(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T t = (T) method.invoke(obj, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}

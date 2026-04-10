package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f7314a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Context f38a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f44a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static boolean f45b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f41a = "XMPush-" + Process.myPid();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static LoggerInterface f39a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final HashMap<Integer, Long> f42a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<Integer, String> f7315b = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Integer f40a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static AtomicInteger f43a = new AtomicInteger(1);

    public static class a implements LoggerInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7316a = b.f41a;

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.f7316a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.f7316a = str;
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.f7316a, str, th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m110a() {
        return false;
    }

    public static void b(String str) {
        if (m111a(0)) {
            a(0, m105a(str));
        }
    }

    public static void c(String str) {
        if (m111a(0)) {
            a(1, m105a(str));
        }
    }

    public static void d(String str) {
        if (m111a(4)) {
            a(4, m105a(str));
        }
    }

    public static void e(String str) {
        if (f44a) {
            m106a(str);
            return;
        }
        Log.w(f41a, m105a(str));
        if (f45b) {
            return;
        }
        m106a(str);
    }

    public static void a(LoggerInterface loggerInterface) {
        f39a = loggerInterface;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static void m112b(String str, String str2) {
        if (m111a(1)) {
            a(1, b(str, str2));
        }
    }

    public static void c(String str, String str2) {
        if (f44a) {
            m107a(str, str2);
            return;
        }
        Log.w(f41a, b(str, str2));
        if (f45b) {
            return;
        }
        m107a(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m111a(int i) {
        return i >= f7314a || m110a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m106a(String str) {
        if (m111a(2)) {
            a(2, m105a(str));
        }
    }

    public static void b(String str, Object... objArr) {
        if (m111a(1)) {
            a(1, a(str, objArr));
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m107a(String str, String str2) {
        if (m111a(2)) {
            a(2, b(str, str2));
        }
    }

    private static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m108a(String str, Object... objArr) {
        if (m111a(2)) {
            a(2, a(str, objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (m111a(4)) {
            a(4, m105a(str), th);
        }
    }

    public static void a(Throwable th) {
        if (m111a(4)) {
            a(4, th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m109a(Object... objArr) {
        if (m111a(4)) {
            a(4, a(objArr));
        }
    }

    public static Integer a(String str) {
        if (f7314a <= 1) {
            Integer numValueOf = Integer.valueOf(f43a.incrementAndGet());
            f42a.put(numValueOf, Long.valueOf(System.currentTimeMillis()));
            f7315b.put(numValueOf, str);
            f39a.log(str + " starts");
            return numValueOf;
        }
        return f40a;
    }

    public static void a(Integer num) {
        if (f7314a <= 1) {
            HashMap<Integer, Long> map = f42a;
            if (map.containsKey(num)) {
                long jLongValue = map.remove(num).longValue();
                String strRemove = f7315b.remove(num);
                long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                f39a.log(strRemove + " ends in " + jCurrentTimeMillis + " ms");
            }
        }
    }

    public static void a(int i, String str) {
        if (i >= f7314a) {
            f39a.log(str);
            return;
        }
        if (m110a()) {
            Log.d("MyLog", "-->log(" + i + "): " + str);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= f7314a) {
            f39a.log("", th);
            return;
        }
        if (m110a()) {
            Log.w("MyLog", "-->log(" + i + "): ", th);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= f7314a) {
            f39a.log(str, th);
            return;
        }
        if (m110a()) {
            Log.w("MyLog", "-->log(" + i + "): " + str, th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String m105a(String str) {
        return b() + str;
    }

    private static String a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Tid:");
        sb.append(Thread.currentThread().getId());
        sb.append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    private static String a(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Tid:");
        sb.append(Thread.currentThread().getId());
        sb.append("] ");
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        f7314a = i;
    }

    public static int a() {
        return f7314a;
    }

    public static void a(Context context) {
        f38a = context;
        if (j.m612a(context)) {
            f44a = true;
        }
        if (j.m611a()) {
            f45b = true;
        }
    }
}

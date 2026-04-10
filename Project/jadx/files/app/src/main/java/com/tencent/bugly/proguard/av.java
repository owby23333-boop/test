package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.lang.Thread;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class av implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f18616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f18617i = new Object();
    protected final Context a;
    protected final as b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final ac f18618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final aa f18619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f18620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f18621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f18622g = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18623j;

    public av(Context context, as asVar, ac acVar, aa aaVar) {
        this.a = context;
        this.b = asVar;
        this.f18618c = acVar;
        this.f18619d = aaVar;
    }

    private static void c() {
        al.e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public final synchronized void a() {
        if (this.f18623j >= 10) {
            al.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f18622g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                al.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f18621f = defaultUncaughtExceptionHandler;
                this.f18620e = defaultUncaughtExceptionHandler;
            } else {
                al.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f18620e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f18623j++;
        al.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.f18622g = false;
        al.a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            al.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f18620e);
            this.f18623j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f18617i) {
            a(thread, th, true, null, null, this.f18619d.Q);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tencent.bugly.crashreport.crash.CrashDetailBean b(java.lang.Thread r6, java.lang.Throwable r7, boolean r8, java.lang.String r9, byte[] r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.av.b(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[], boolean):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    private static void a(CrashDetailBean crashDetailBean, Throwable th, boolean z2) {
        String strA;
        String name = th.getClass().getName();
        String strA2 = a(th);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(th.getStackTrace().length);
        objArr[1] = Boolean.valueOf(th.getCause() != null);
        al.e("stack frame :%d, has cause %b", objArr);
        String str = "";
        String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable cause = th;
        while (cause != null && cause.getCause() != null) {
            cause = cause.getCause();
        }
        if (cause != null && cause != th) {
            crashDetailBean.f18440n = cause.getClass().getName();
            crashDetailBean.f18441o = a(cause);
            if (cause.getStackTrace().length > 0) {
                crashDetailBean.f18442p = cause.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(strA2);
            sb.append("\n");
            sb.append(string);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.f18440n);
            sb.append(":");
            sb.append(crashDetailBean.f18441o);
            sb.append("\n");
            strA = a(cause, at.f18583h);
            sb.append(strA);
            crashDetailBean.f18443q = sb.toString();
        } else {
            crashDetailBean.f18440n = name;
            if (at.a().i() && z2) {
                al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.f18441o = strA2 + str;
            crashDetailBean.f18442p = string;
            strA = a(th, at.f18583h);
            crashDetailBean.f18443q = strA;
        }
        crashDetailBean.f18447u = ap.c(crashDetailBean.f18443q.getBytes());
        crashDetailBean.f18452z.put(crashDetailBean.B, strA);
    }

    private static boolean a(Thread thread) {
        synchronized (f18617i) {
            if (f18616h != null && thread.getName().equals(f18616h)) {
                return true;
            }
            f18616h = thread.getName();
            return false;
        }
    }

    public final void a(Thread thread, Throwable th, boolean z2, String str, byte[] bArr, boolean z3) {
        if (z2) {
            al.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                al.a("this class has handled this exception", new Object[0]);
                if (this.f18621f != null) {
                    al.a("call system handler", new Object[0]);
                    this.f18621f.uncaughtException(thread, th);
                } else {
                    c();
                }
            }
        } else {
            al.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f18622g) {
                al.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z2) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f18620e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f18620e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f18621f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f18621f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f18618c.b()) {
                al.d("no remote but still store!", new Object[0]);
            }
            if (!this.f18618c.c().f18411f && this.f18618c.b()) {
                al.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                as.a(z2 ? "JAVA_CRASH" : "JAVA_CATCH", ap.a(), this.f18619d.f18472d, thread.getName(), ap.a(th), null);
                if (z2) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f18620e;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f18620e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f18621f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f18621f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean crashDetailBeanB = b(thread, th, z2, str, bArr, z3);
            if (crashDetailBeanB == null) {
                al.e("pkg crash datas fail!", new Object[0]);
                if (z2) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f18620e;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f18620e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f18621f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f18621f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            as.a(z2 ? "JAVA_CRASH" : "JAVA_CATCH", ap.a(), this.f18619d.f18472d, thread.getName(), ap.a(th), crashDetailBeanB);
            if (!this.b.a(crashDetailBeanB, z2)) {
                this.b.b(crashDetailBeanB, z2);
            }
            if (z2) {
                this.b.a(crashDetailBeanB);
            }
            if (z2) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f18620e;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    al.e("sys default last handle start!", new Object[0]);
                    this.f18620e.uncaughtException(thread, th);
                    al.e("sys default last handle end!", new Object[0]);
                } else if (this.f18621f != null) {
                    al.e("system handle start!", new Object[0]);
                    this.f18621f.uncaughtException(thread, th);
                    al.e("system handle end!", new Object[0]);
                } else {
                    al.e("crashreport last handle start!", new Object[0]);
                    c();
                    al.e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!al.a(th2)) {
                    th2.printStackTrace();
                }
                if (z2) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f18620e;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f18620e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f18621f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f18621f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z2) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f18620e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f18620e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f18621f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f18621f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f18411f != this.f18622g) {
                al.a("java changed to %b", Boolean.valueOf(strategyBean.f18411f));
                if (strategyBean.f18411f) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    private static String a(Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i2 > 0 && sb.length() >= i2) {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            al.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private static String a(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}

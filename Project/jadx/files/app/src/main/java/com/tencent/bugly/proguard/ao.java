package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class ao {
    public static boolean a = true;
    public static boolean b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SimpleDateFormat f18540c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f18541d = 30720;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static StringBuilder f18542e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static StringBuilder f18543f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f18544g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static a f18545h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f18546i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f18547j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Context f18548k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f18549l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f18550m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f18551n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static ExecutorService f18552o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f18553p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Object f18554q = new Object();

    static {
        try {
            f18540c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            al.b(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        if (f18550m || context == null || !b) {
            return;
        }
        try {
            f18552o = Executors.newSingleThreadExecutor();
            f18543f = new StringBuilder(0);
            f18542e = new StringBuilder(0);
            f18548k = context;
            aa aaVarA = aa.a(context);
            f18546i = aaVarA.f18472d;
            aaVarA.getClass();
            f18547j = "";
            f18549l = f18548k.getFilesDir().getPath() + "/buglylog_" + f18546i + "_" + f18547j + ".txt";
            f18553p = Process.myPid();
        } catch (Throwable unused) {
        }
        f18550m = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str, String str2, String str3) {
        try {
            aa aaVarB = aa.b();
            if (aaVarB == null || aaVarB.N == null) {
                return false;
            }
            return aaVarB.N.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void e(String str, String str2, String str3) {
        if (a) {
            f(str, str2, str3);
        } else {
            g(str, str2, str3);
        }
    }

    private static synchronized void f(String str, String str2, String str3) {
        String strA = a(str, str2, str3, Process.myTid());
        synchronized (f18554q) {
            try {
                f18543f.append(strA);
                if (f18543f.length() >= f18541d) {
                    f18543f = f18543f.delete(0, f18543f.indexOf("\u0001\r\n") + 1);
                }
            } finally {
            }
        }
    }

    private static synchronized void g(String str, String str2, String str3) {
        String strA = a(str, str2, str3, Process.myTid());
        synchronized (f18554q) {
            try {
                f18543f.append(strA);
                if (f18543f.length() <= f18541d) {
                    return;
                }
                if (f18544g) {
                    return;
                }
                f18544g = true;
                if (f18545h == null) {
                    f18545h = new a(f18549l);
                } else if (f18545h.b == null || f18545h.b.length() + ((long) f18543f.length()) > f18545h.f18557c) {
                    f18545h.a();
                }
                if (f18545h.a(f18543f.toString())) {
                    f18543f.setLength(0);
                    f18544g = false;
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String b() {
        try {
            aa aaVarB = aa.b();
            if (aaVarB == null || aaVarB.N == null) {
                return null;
            }
            return aaVarB.N.getLogFromNative();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] c() {
        if (!b) {
            return null;
        }
        if (f18551n) {
            al.a("[LogUtil] Get user log from native.", new Object[0]);
            String strB = b();
            if (strB != null) {
                al.a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(strB.length()));
                return ap.a(strB, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (f18554q) {
            if (f18545h != null && f18545h.a && f18545h.b != null && f18545h.b.length() > 0) {
                sb.append(ap.a(f18545h.b, 30720, true));
            }
            if (f18543f != null && f18543f.length() > 0) {
                sb.append(f18543f.toString());
            }
        }
        return ap.a(sb.toString(), "BuglyLog.txt");
    }

    /* JADX INFO: compiled from: BUGLY */
    public static class a {
        boolean a;
        File b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f18557c = 30720;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f18558d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f18559e;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f18558d = str;
            this.a = a();
        }

        final boolean a() {
            try {
                this.b = new File(this.f18558d);
                if (this.b.exists() && !this.b.delete()) {
                    this.a = false;
                    return false;
                }
                if (this.b.createNewFile()) {
                    return true;
                }
                this.a = false;
                return false;
            } catch (Throwable th) {
                al.a(th);
                this.a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (!this.a) {
                return false;
            }
            try {
                fileOutputStream = new FileOutputStream(this.b, true);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                byte[] bytes = str.getBytes("UTF-8");
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
                fileOutputStream.close();
                this.f18559e += (long) bytes.length;
                this.a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                try {
                    al.a(th);
                    this.a = false;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    public static void a(int i2) {
        synchronized (f18554q) {
            f18541d = i2;
            if (i2 < 0) {
                f18541d = 0;
            } else if (i2 > 30720) {
                f18541d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + ap.b(th));
    }

    public static synchronized void a(final String str, final String str2, final String str3) {
        if (f18550m && b) {
            try {
                if (f18551n) {
                    f18552o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ao.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (ao.d(str, str2, str3)) {
                            }
                        }
                    });
                } else {
                    f18552o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ao.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            ao.e(str, str2, str3);
                        }
                    });
                }
            } catch (Exception e2) {
                al.b(e2);
            }
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        String string;
        f18542e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = f18540c;
        if (simpleDateFormat != null) {
            string = simpleDateFormat.format(date);
        } else {
            string = date.toString();
        }
        StringBuilder sb = f18542e;
        sb.append(string);
        sb.append(" ");
        sb.append(f18553p);
        sb.append(" ");
        sb.append(j2);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f18542e.toString();
    }

    public static byte[] a() {
        if (a) {
            if (b) {
                return ap.a(f18543f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return c();
    }
}

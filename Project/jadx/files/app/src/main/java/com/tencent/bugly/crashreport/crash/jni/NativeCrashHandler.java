package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.q;
import com.tencent.smtt.utils.TbsLog;
import com.umeng.message.common.inter.ITagManager;
import java.io.File;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public class NativeCrashHandler implements q {
    private static NativeCrashHandler a = null;
    private static int b = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f18459g = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f18460n = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f18461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final aa f18462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ak f18463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private NativeExceptionHandler f18464f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f18465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18466i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f18467j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f18468k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f18469l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private as f18470m;

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, aa aaVar, as asVar, ak akVar, boolean z2, String str) {
        this.f18461c = ap.a(context);
        if (ap.a(f18459g)) {
            try {
                if (ap.a(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = "/data/data/" + aa.a(context).f18471c + "/app_bugly";
            }
            f18459g = str;
        }
        this.f18470m = asVar;
        this.f18462d = aaVar;
        this.f18463e = akVar;
        this.f18465h = z2;
        this.f18464f = new bd(context, aaVar, asVar, ac.a());
    }

    private synchronized void d() {
        if (!this.f18468k) {
            al.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
        } catch (Throwable unused) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        if (unregist() != null) {
            al.a("[Native] Successfully closed native crash report.", new Object[0]);
            this.f18468k = false;
            return;
        }
        try {
            ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f18468k = false;
            al.a("[Native] Successfully closed native crash report.", new Object[0]);
            return;
        } catch (Throwable unused2) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
            this.f18467j = false;
            this.f18466i = false;
            return;
        }
    }

    public static synchronized String getDumpFilePath() {
        return f18459g;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, aa aaVar, as asVar, ac acVar, ak akVar, boolean z2, String str) {
        if (a == null) {
            a = new NativeCrashHandler(context, aaVar, asVar, akVar, z2, str);
        }
        return a;
    }

    private native String getSoCpuAbi();

    public static boolean isShouldHandleInJava() {
        return f18460n;
    }

    public static synchronized void setDumpFilePath(String str) {
        f18459g = str;
    }

    public static void setShouldHandleInJava(boolean z2) {
        f18460n = z2;
        NativeCrashHandler nativeCrashHandler = a;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, String.valueOf(z2));
        }
    }

    @Override // com.tencent.bugly.proguard.q
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f18466i || this.f18467j) && str != null && str2 != null && str3 != null) {
            try {
                if (this.f18467j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f18463e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                if (!ap.b(NativeCrashHandler.this.f18461c, "native_record_lock")) {
                    al.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.f18460n) {
                    NativeCrashHandler.a(NativeCrashHandler.this, ITagManager.STATUS_FALSE);
                }
                CrashDetailBean crashDetailBeanA = be.a(NativeCrashHandler.this.f18461c, NativeCrashHandler.f18459g, NativeCrashHandler.this.f18464f);
                if (crashDetailBeanA != null) {
                    al.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.f18470m.a(crashDetailBeanA, true)) {
                        NativeCrashHandler.this.f18470m.b(crashDetailBeanA, false);
                    }
                    be.a(false, NativeCrashHandler.f18459g);
                }
                NativeCrashHandler.a();
                ap.c(NativeCrashHandler.this.f18461c, "native_record_lock");
            }
        });
    }

    public void disableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 19) {
            b = 1;
        }
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 19) {
            b |= 2;
        }
    }

    public boolean filterSigabrtSysLog() {
        return a(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, ITagManager.STATUS_TRUE);
    }

    @Override // com.tencent.bugly.proguard.q
    public String getLogFromNative() {
        if (!this.f18466i && !this.f18467j) {
            return null;
        }
        try {
            return this.f18467j ? getNativeLog() : (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f18464f;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            al.d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public boolean isEnableCatchAnrTrace() {
        return (b & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.f18469l;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000b, B:8:0x001a, B:10:0x0026, B:14:0x002d, B:16:0x0031), top: B:22:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void onStrategyChanged(com.tencent.bugly.crashreport.common.strategy.StrategyBean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L1a
            boolean r2 = r5.f18411f     // Catch: java.lang.Throwable -> L43
            boolean r3 = r4.f18468k     // Catch: java.lang.Throwable -> L43
            if (r2 == r3) goto L1a
            java.lang.String r2 = "server native changed to %b"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L43
            boolean r5 = r5.f18411f     // Catch: java.lang.Throwable -> L43
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L43
            r3[r1] = r5     // Catch: java.lang.Throwable -> L43
            com.tencent.bugly.proguard.al.d(r2, r3)     // Catch: java.lang.Throwable -> L43
        L1a:
            com.tencent.bugly.proguard.ac r5 = com.tencent.bugly.proguard.ac.a()     // Catch: java.lang.Throwable -> L43
            com.tencent.bugly.crashreport.common.strategy.StrategyBean r5 = r5.c()     // Catch: java.lang.Throwable -> L43
            boolean r5 = r5.f18411f     // Catch: java.lang.Throwable -> L43
            if (r5 == 0) goto L2c
            boolean r5 = r4.f18469l     // Catch: java.lang.Throwable -> L43
            if (r5 == 0) goto L2c
            r5 = 1
            goto L2d
        L2c:
            r5 = 0
        L2d:
            boolean r2 = r4.f18468k     // Catch: java.lang.Throwable -> L43
            if (r5 == r2) goto L41
            java.lang.String r2 = "native changed to %b"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L43
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L43
            r0[r1] = r3     // Catch: java.lang.Throwable -> L43
            com.tencent.bugly.proguard.al.a(r2, r0)     // Catch: java.lang.Throwable -> L43
            r4.b(r5)     // Catch: java.lang.Throwable -> L43
        L41:
            monitor-exit(r4)
            return
        L43:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.onStrategyChanged(com.tencent.bugly.crashreport.common.strategy.StrategyBean):void");
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f18466i || this.f18467j) && str != null && str2 != null) {
            try {
                if (this.f18467j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z2, int i2);

    public void removeEmptyNativeRecordFiles() {
        be.c(f18459g);
    }

    protected native String removeNativeKeyValue(String str);

    public void resendSigquit() {
        a(20, "");
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    protected native void setNativeInfo(int i2, String str);

    @Override // com.tencent.bugly.proguard.q
    public boolean setNativeIsAppForeground(boolean z2) {
        return a(14, z2 ? ITagManager.STATUS_TRUE : ITagManager.STATUS_FALSE);
    }

    public boolean setNativeLaunchTime(long j2) {
        try {
            return a(15, String.valueOf(j2));
        } catch (NumberFormatException e2) {
            if (al.a(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z2) {
        c(z2);
        boolean zIsUserOpened = isUserOpened();
        ac acVarA = ac.a();
        if (acVarA != null) {
            zIsUserOpened = zIsUserOpened && acVarA.c().f18411f;
        }
        if (zIsUserOpened != this.f18468k) {
            al.a("native changed to %b", Boolean.valueOf(zIsUserOpened));
            b(zIsUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.f18467j && !this.f18466i) {
            boolean z2 = !ap.a(this.f18462d.f18488t);
            if (at.b) {
                this.f18467j = a(z2 ? this.f18462d.f18488t : "Bugly_Native", z2);
                if (!this.f18467j && !z2) {
                    this.f18466i = a("NativeRQD", false);
                }
            } else {
                String str = "Bugly_Native";
                String str2 = this.f18462d.f18488t;
                if (z2) {
                    str = str2;
                } else {
                    this.f18462d.getClass();
                }
                this.f18467j = a(str, z2);
            }
            if (this.f18467j || this.f18466i) {
                a(this.f18465h);
                setNativeAppVersion(this.f18462d.f18483o);
                setNativeAppChannel(this.f18462d.f18487s);
                setNativeAppPackage(this.f18462d.f18471c);
                setNativeUserId(this.f18462d.f());
                setNativeIsAppForeground(this.f18462d.a());
                setNativeLaunchTime(this.f18462d.a);
                return;
            }
            return;
        }
        a(this.f18465h);
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (this.f18467j) {
            testCrash();
        } else {
            al.d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    public void unBlockSigquit(boolean z2) {
        if (z2) {
            a(21, ITagManager.STATUS_TRUE);
        } else {
            a(21, ITagManager.STATUS_FALSE);
        }
    }

    protected native String unregist();

    static /* synthetic */ boolean a(NativeCrashHandler nativeCrashHandler, String str) {
        return nativeCrashHandler.a(999, str);
    }

    private synchronized void a(boolean z2) {
        if (this.f18468k) {
            al.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f18467j) {
            try {
                String strRegist = regist(f18459g, z2, b);
                if (strRegist != null) {
                    al.a("[Native] Native Crash Report enable.", new Object[0]);
                    this.f18462d.f18489u = strRegist;
                    String strConcat = "-".concat(this.f18462d.f18489u);
                    if (!at.b && !this.f18462d.f18476h.contains(strConcat)) {
                        this.f18462d.f18476h = this.f18462d.f18476h.concat("-").concat(this.f18462d.f18489u);
                    }
                    al.a("comInfo.sdkVersion %s", this.f18462d.f18476h);
                    this.f18468k = true;
                    String runningCpuAbi = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi)) {
                        this.f18462d.e(runningCpuAbi);
                    }
                    return;
                }
            } catch (Throwable unused) {
                al.c("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.f18466i) {
            try {
                Class[] clsArr = {String.class, String.class, Integer.TYPE, Integer.TYPE};
                Object[] objArr = new Object[4];
                objArr[0] = f18459g;
                objArr[1] = ab.d();
                objArr[2] = Integer.valueOf(z2 ? 1 : 5);
                objArr[3] = 1;
                String str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", clsArr, objArr);
                if (str == null) {
                    Class[] clsArr2 = {String.class, String.class, Integer.TYPE};
                    aa.b();
                    str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", clsArr2, new Object[]{f18459g, ab.d(), Integer.valueOf(aa.B())});
                }
                if (str != null) {
                    this.f18468k = true;
                    this.f18462d.f18489u = str;
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(z2 ? 1 : 5)});
                    String runningCpuAbi2 = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi2)) {
                        this.f18462d.e(runningCpuAbi2);
                    }
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.f18467j = false;
        this.f18466i = false;
    }

    private synchronized void b(boolean z2) {
        if (z2) {
            startNativeMonitor();
        } else {
            d();
        }
    }

    private synchronized void c(boolean z2) {
        if (this.f18469l != z2) {
            al.a("user change native %b", Boolean.valueOf(z2));
            this.f18469l = z2;
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        return a;
    }

    public void testNativeCrash(boolean z2, boolean z3, boolean z4) {
        a(16, String.valueOf(z2));
        a(17, String.valueOf(z3));
        a(18, String.valueOf(z4));
        testNativeCrash();
    }

    private static boolean a(String str, boolean z2) {
        boolean z3;
        try {
            al.a("[Native] Trying to load so: %s", str);
            if (z2) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                al.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z3 = true;
                al.d(th.getMessage(), new Object[0]);
                al.d("[Native] Failed to load so: %s", str);
                return z3;
            }
        } catch (Throwable th2) {
            th = th2;
            z3 = false;
        }
    }

    protected static void a() {
        long jB = ap.b() - at.f18584i;
        long jB2 = ap.b() + 86400000;
        File file = new File(f18459g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : fileArrListFiles) {
                        long jLastModified = file2.lastModified();
                        if (jLastModified < jB || jLastModified >= jB2) {
                            al.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i2++;
                            if (file2.delete()) {
                                i3++;
                            }
                        }
                    }
                    al.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable th) {
                al.a(th);
            }
        }
    }

    private boolean a(int i2, String str) {
        if (!this.f18467j) {
            return false;
        }
        try {
            setNativeInfo(i2, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }
}

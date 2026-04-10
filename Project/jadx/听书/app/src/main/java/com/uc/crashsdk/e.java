package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.ExoPlayer;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.bi;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.LogType;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes4.dex */
public class e implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f2140a = true;
    private static long b;
    private static String i;
    private final List<FileInputStream> e = new ArrayList();
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static boolean d = false;
    private static long f = 0;
    private static long g = -1;
    private static boolean h = true;
    private static String j = "";
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static final Object n = new Object();
    private static final ConditionVariable o = new ConditionVariable();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final Object r = new Object();
    private static final ArrayList<String> s = new ArrayList<>();
    private static int t = 0;
    private static String u = null;
    private static boolean v = false;
    private static String w = null;
    private static String x = null;
    private static final Object y = new Object();
    private static final Object z = new Object();
    private static Map<String, Integer> A = null;
    private static String B = null;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static String J = "?";
    private static boolean K = false;
    private static boolean L = false;
    private static int M = 0;
    private static int N = 0;
    private static boolean O = false;
    private static com.uc.crashsdk.a.e P = new com.uc.crashsdk.a.e(405);
    private static c Q = new c(0);
    private static boolean R = false;
    private static final com.uc.crashsdk.a.e S = new com.uc.crashsdk.a.e(TTAdConstant.IMAGE_URL_CODE);
    private static Thread.UncaughtExceptionHandler T = null;
    private static Throwable U = null;
    private static boolean V = false;
    private static boolean W = false;
    private static Runnable X = null;
    private static final Object Y = new Object();
    private static int Z = 101;
    private static Runnable aa = new com.uc.crashsdk.a.e(407);
    private static final Object ab = new Object();
    private static volatile boolean ac = false;
    private static Object ad = new Object();
    private static ParcelFileDescriptor ae = null;
    private static boolean af = false;
    private static boolean ag = false;

    static /* synthetic */ int J() {
        int i2 = M + 1;
        M = i2;
        return i2;
    }

    static /* synthetic */ void K() {
        StringBuilder sbY;
        if (com.uc.crashsdk.b.d && (sbY = Y()) != null) {
            JNIBridge.set(125, sbY.toString());
        }
        L = true;
        Z();
    }

    static /* synthetic */ int L() {
        M = 0;
        return 0;
    }

    public e() {
        try {
            M();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private void M() {
        int I2 = g.I();
        for (int i2 = 0; i2 < I2; i2++) {
            try {
                this.e.add(new FileInputStream("/dev/null"));
            } catch (Exception e) {
                com.uc.crashsdk.a.g.a(e);
                return;
            }
        }
    }

    private void N() {
        Iterator<FileInputStream> it = this.e.iterator();
        while (it.hasNext()) {
            com.uc.crashsdk.a.g.a(it.next());
        }
        this.e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O() {
        if (g.P()) {
            return true;
        }
        return a();
    }

    public static boolean a() {
        if (f == 0) {
            f = 2L;
            if (h(com.uc.crashsdk.b.b("logs")) == 1) {
                f = 1L;
            }
        }
        return f == 1;
    }

    private static long h(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return 0L;
    }

    static long b() {
        if (g == -1) {
            g = h(com.uc.crashsdk.b.b("local"));
        }
        return g;
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f2141a;
        private final OutputStream b;
        private int c = 0;
        private int d = 0;
        private boolean e = false;

        a(long j, OutputStream outputStream) {
            this.f2141a = j;
            this.b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(byte[] r6, int r7, int r8) throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.d
                int r0 = r0 + r8
                r5.d = r0
                boolean r0 = r5.e
                if (r0 == 0) goto Lb
                r6 = 0
                return r6
            Lb:
                int r0 = com.uc.crashsdk.g.A()
                if (r0 <= 0) goto L19
                int r1 = r5.c
                int r2 = r1 + r8
                if (r2 <= r0) goto L19
                int r0 = r0 - r1
                goto L1a
            L19:
                r0 = r8
            L1a:
                int r1 = r5.c
                int r1 = r1 + r0
                r5.c = r1
                long r1 = r5.f2141a
                r3 = 0
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 == 0) goto L30
                java.lang.String r1 = new java.lang.String
                r1.<init>(r6, r7, r0)
                r5.b(r1)
                goto L35
            L30:
                java.io.OutputStream r1 = r5.b
                r1.write(r6, r7, r0)
            L35:
                if (r0 >= r8) goto L3a
                r6 = 1
                r5.e = r6
            L3a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a.a(byte[], int, int):int");
        }

        final void a() {
            try {
                if (this.d - this.c > 0) {
                    a("\n");
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(g.A()), Integer.valueOf(this.d - this.c)));
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        final void a(String str) throws IOException {
            if (e.h && e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.f2141a != 0) {
                b(str);
            } else {
                this.b.write(str.getBytes("UTF-8"));
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
            if (e.h && e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i)));
            }
            if (this.f2141a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i)));
            } else {
                this.b.write(i);
            }
            this.c++;
            this.d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (e.h && e.O()) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                if (i2 != 1 || bArr2[0] != 10) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            if (e.h && e.O() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        private void b(String str) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.nativeClientWriteData(this.f2141a, str);
            }
        }
    }

    private static String i(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String P() {
        return g.e() + "_";
    }

    static void c() {
        i = null;
    }

    static String d() {
        String str = i;
        if (str != null) {
            return str;
        }
        String strJ = j(null);
        i = strJ;
        return strJ;
    }

    private static String j(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", P(), g.T(), g.V(), i(Build.MODEL), i(Build.VERSION.RELEASE), str);
    }

    private static String Q() {
        return com.uc.crashsdk.b.B() ? "fg" : "bg";
    }

    private static byte[] R() {
        byte[] bArr = null;
        int i2 = 1024;
        while (bArr == null && i2 > 0) {
            try {
                bArr = new byte[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    return bArr;
                }
            }
        }
        return bArr;
    }

    private static String k(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", d(), n(), Q(), str);
    }

    public static void a(int i2, Object[] objArr) {
        int i3;
        switch (i2) {
            case 401:
                JNIBridge.nativeCmd(10, com.uc.crashsdk.b.I() == 5 ? 1L : 0L, null, null);
                com.uc.crashsdk.a.c = true;
                com.uc.crashsdk.a.a(false);
                L = true;
                Z();
                y();
                return;
            case 402:
                Object obj = Y;
                synchronized (obj) {
                    if (X == null) {
                        return;
                    }
                    W = true;
                    if (com.uc.crashsdk.b.q()) {
                        return;
                    }
                    if (!com.uc.crashsdk.a.d.e()) {
                        com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                        return;
                    }
                    if (!d(LogType.UNEXP_TYPE)) {
                        com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
                        return;
                    }
                    int iNativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(g.o(), g.p());
                    if (iNativeGenerateUnexpLog != 0) {
                        f.a(11);
                        if ((iNativeGenerateUnexpLog & 4352) != 0) {
                            Z = 105;
                            i3 = 30;
                        } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_EXIT) != 0) {
                            Z = 104;
                            i3 = 31;
                        } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                            Z = 106;
                            i3 = 32;
                        } else {
                            if ((iNativeGenerateUnexpLog & LogType.UNEXP_ANR) != 0) {
                                Z = 103;
                                f.a(10);
                            } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_LOW_MEMORY) != 0) {
                                Z = 107;
                                f.a(29);
                            } else {
                                Z = 102;
                            }
                            a(true);
                        }
                        f.a(i3);
                        a(true);
                    }
                    synchronized (obj) {
                        X = null;
                        break;
                    }
                    return;
                }
            case 403:
                ab();
                return;
            case 404:
            default:
                if (!f2140a) {
                    throw new AssertionError();
                }
                return;
            case 405:
                L = false;
                StringBuilder sbY = Y();
                String strG = com.uc.crashsdk.b.g();
                if (sbY != null) {
                    com.uc.crashsdk.a.g.a(new File(strG), sbY.toString());
                    return;
                }
                return;
            case 406:
                if (!f2140a && objArr == null) {
                    throw new AssertionError();
                }
                a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    com.uc.crashsdk.a.d();
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                synchronized (ab) {
                    if (!ac && g.Q() && com.uc.crashsdk.b.z()) {
                        com.uc.crashsdk.b.s();
                        h.f();
                        f.c();
                        if (com.uc.crashsdk.b.F()) {
                            C();
                        }
                        if (g.Q()) {
                            a(Calendar.getInstance());
                        }
                        ac = true;
                        return;
                    }
                    return;
                }
            case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                d(false);
                return;
            case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                a(false, true);
                return;
            case TTAdConstant.IMAGE_CODE /* 411 */:
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(28, d(LogType.NATIVE_TYPE));
                    JNIBridge.set(29, d(LogType.ANR_TYPE));
                    return;
                }
                return;
            case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                if (!R && com.uc.crashsdk.b.B() && g.M()) {
                    b(com.uc.crashsdk.a.g.a());
                    return;
                }
                if (R) {
                    if (com.uc.crashsdk.b.B() && g.M()) {
                        return;
                    }
                    try {
                        com.uc.crashsdk.a.g.a().unregisterReceiver(Q);
                        R = false;
                        return;
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                        return;
                    }
                }
                return;
            case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                JNIBridge.cmd(8);
                return;
            case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                try {
                    if (d(com.uc.crashsdk.a.g.a())) {
                        return;
                    }
                    int i4 = N + 1;
                    N = i4;
                    if (i4 < 10) {
                        X();
                        return;
                    } else {
                        if (com.uc.crashsdk.b.d) {
                            JNIBridge.set(130, "(get failed)");
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                if (!f2140a && objArr == null) {
                    throw new AssertionError();
                }
                long jLongValue = ((Long) objArr[0]).longValue();
                Calendar calendar = Calendar.getInstance();
                if (calendar.getTimeInMillis() >= jLongValue) {
                    h.g();
                    f.a(100);
                    d(true);
                    f.a(true);
                    h.b();
                } else {
                    h.h();
                    h.i();
                    h.c();
                }
                a(calendar);
                break;
                break;
            case 416:
                break;
        }
        W();
    }

    public static boolean b(int i2, Object[] objArr) {
        if (i2 == 451) {
            if (f2140a || objArr != null) {
                return a((String) objArr[0], (d) objArr[1]);
            }
            throw new AssertionError();
        }
        if (i2 == 452) {
            if (!f2140a && objArr == null) {
                throw new AssertionError();
            }
            String str = (String) objArr[0];
            d dVar = (d) objArr[1];
            return com.uc.crashsdk.a.g.a(new File(str), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.f2142a), Long.valueOf(dVar.b), Integer.valueOf(dVar.c), Integer.valueOf(dVar.d)).getBytes());
        }
        if (f2140a) {
            return false;
        }
        throw new AssertionError();
    }

    private static String S() {
        return (!com.uc.crashsdk.b.F() || d) ? LogType.JAVA_TYPE : "ucebujava";
    }

    static void a(boolean z2) {
        File[] fileArrListFiles;
        try {
            if (com.uc.crashsdk.b.y() && (fileArrListFiles = new File(g.X()).listFiles()) != null) {
                int iL = g.l();
                int iM = g.m();
                if (fileArrListFiles.length < Math.min(iL, iM)) {
                    return;
                }
                byte b2 = 0;
                int i2 = 0;
                int i3 = 0;
                for (File file : fileArrListFiles) {
                    if (b(file)) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                int i4 = (!z2 || i2 < iL) ? 0 : (i2 - iL) + 1;
                int i5 = (z2 || i3 < iM) ? 0 : (i3 - iM) + 1;
                if (i4 == 0 && i5 == 0) {
                    return;
                }
                Arrays.sort(fileArrListFiles, new b(b2 == true ? 1 : 0));
                int i6 = i4;
                int i7 = i5;
                for (File file2 : fileArrListFiles) {
                    boolean zB = b(file2);
                    if (zB && i6 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i6--;
                    } else if (!zB && i7 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                        file2.delete();
                        i7--;
                    }
                    if (i6 == 0 && i7 == 0) {
                        break;
                    }
                }
                f.a(16, i4 + i5);
                if (i4 > 0) {
                    f.a(22, i4);
                }
                if (i5 > 0) {
                    f.a(23, i5);
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class b implements Comparator<File> {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String strS;
        String strNativeGet;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), n()).getBytes("UTF-8"));
            Locale locale = Locale.US;
            Object[] objArr = new Object[3];
            objArr[0] = e();
            if (com.uc.crashsdk.a.g.a(l)) {
                T();
            }
            objArr[1] = l;
            objArr[2] = f();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            Locale locale2 = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = a(new Date(b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = com.uc.crashsdk.a.g.d();
            objArr2[3] = com.uc.crashsdk.b.B() ? "fg" : "bg";
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", g.T(), g.U(), g.V(), Integer.valueOf(com.uc.crashsdk.a.c())).getBytes("UTF-8"));
            String str3 = "0";
            String str4 = "";
            if (com.uc.crashsdk.b.d) {
                String strNativeGet2 = JNIBridge.nativeGet(1, 0L, null);
                strNativeGet = JNIBridge.nativeGet(2, 0L, null);
                str3 = strNativeGet2;
            } else {
                strNativeGet = "";
            }
            outputStream.write(String.format(Locale.US, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.3.2.2", str3, "211215141717", strNativeGet, "release").getBytes("UTF-8"));
            if (str != null) {
                str4 = str;
            }
            outputStream.write(("Report Name: " + str4.substring(str4.lastIndexOf(47) + 1) + "\n").getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            if (ag) {
                strS = s("UUID");
            } else {
                strS = B;
            }
            outputStream.write(String.format("UUID: %s\n", strS).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + "\n").getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String strE = com.uc.crashsdk.b.E();
            if (com.uc.crashsdk.a.g.a(strE)) {
                strE = "(none)";
            }
            outputStream.write(("Activity: " + strE + "\n").getBytes("UTF-8"));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, "UTF-8");
            if (ag) {
                h = false;
                outputStream.write(s("HEADER").getBytes("UTF-8"));
                h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:6|(3:66|7|(4:11|(3:13|(2:15|75)(1:76)|16)|74|17))|18|(8:62|20|64|21|25|(1:27)|28|(1:(1:31)(1:32)))|72|33|(11:35|70|36|44|68|45|(1:49)|50|(1:54)|58|59)(8:40|68|45|(2:47|49)|50|(2:52|54)|58|59)|43|44|68|45|(0)|50|(0)|58|59) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0147, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0148, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc A[Catch: all -> 0x0147, TryCatch #3 {all -> 0x0147, blocks: (B:45:0x00d6, B:47:0x00dc, B:49:0x00e4, B:50:0x010e, B:52:0x0114, B:54:0x011c), top: B:68:0x00d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0114 A[Catch: all -> 0x0147, TryCatch #3 {all -> 0x0147, blocks: (B:45:0x00d6, B:47:0x00dc, B:49:0x00e4, B:50:0x010e, B:52:0x0114, B:54:0x011c), top: B:68:0x00d6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e() {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e():java.lang.String");
    }

    public static String f() {
        if (com.uc.crashsdk.a.g.a(k)) {
            T();
        }
        return k;
    }

    private static void T() {
        String strTrim;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String strTrim2 = "-";
        try {
            strTrim = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            strTrim = "-";
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i2 = 0;
                do {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.startsWith("Hardware")) {
                            strTrim = line.substring(line.indexOf(":") + 1).trim();
                        } else if (line.startsWith("Processor")) {
                            strTrim2 = line.substring(line.indexOf(":") + 1).trim();
                        }
                        i2++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                        } catch (Throwable th4) {
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i2 < 2);
                com.uc.crashsdk.a.g.a(fileReader);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
        }
        com.uc.crashsdk.a.g.a(bufferedReader);
        k = strTrim;
        l = strTrim2;
    }

    static String g() {
        try {
            StringBuilder sb = new StringBuilder("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024).append(" kB\nJavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024).append(" kB\nJavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024).append(" kB\nNativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024).append(" kB\nNativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024).append(" kB\nNativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024).append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.a.g.a().getSystemService(TTDownloadField.TT_ACTIVITY);
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ").append(memoryInfo.availMem / 1024).append(" kB\n");
                    sb.append("threshold:  ").append(memoryInfo.threshold / 1024).append(" kB\n");
                    sb.append("lowMemory:  ").append(memoryInfo.lowMemory).append("\n");
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            return sb.toString();
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return "";
        }
    }

    static String a(String str, String str2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"ps", "-ef"}).getInputStream()));
            boolean zB = com.uc.crashsdk.a.g.b(str);
            boolean zB2 = com.uc.crashsdk.a.g.b(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if ((zB && line.contains(str)) || (zB2 && line.contains(str2)) || (line.indexOf(47) < 0 && line.indexOf(46) > 0)) {
                        byteArrayOutputStream.write(line.getBytes("UTF-8"));
                        byteArrayOutputStream.write("\n".getBytes("UTF-8"));
                    }
                } else {
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "exception exists.";
        }
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i2 = 8192;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i2);
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    return bufferedReader;
                }
            }
        }
        return bufferedReader;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReaderA = null;
        try {
            outputStream.write("logcat:\n".getBytes("UTF-8"));
        } finally {
        }
        try {
            if (g.n() <= 0) {
                try {
                    outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                a(outputStream);
                return;
            }
            int iN = g.n();
            bufferedReaderA = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", com.umeng.analytics.pro.d.ar, "-b", "main", "-v", "threadtime", "-t", String.valueOf(iN)}).getInputStream()));
            if (bufferedReaderA == null) {
                try {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                a(outputStream);
                return;
            }
            h = false;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String line = bufferedReaderA.readLine();
                if (line != null) {
                    i2++;
                    if (i3 < iN && !line.contains(" I auditd ") && !line.contains(" I liblog ")) {
                        outputStream.write(line.getBytes("UTF-8"));
                        outputStream.write("\n".getBytes("UTF-8"));
                        i3++;
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable th3) {
                        a(th3, outputStream);
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes("UTF-8"));
            h = true;
            com.uc.crashsdk.a.g.a(bufferedReaderA);
            a(outputStream);
            return;
            com.uc.crashsdk.a.g.a(bufferedReaderA);
            a(outputStream);
            return;
        } finally {
        }
    }

    private static String a(File file) {
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (Throwable unused) {
            canonicalPath = null;
        }
        return com.uc.crashsdk.a.g.a(canonicalPath) ? file.getPath() : canonicalPath;
    }

    private static long a(StatFs statFs, String str, String str2) {
        try {
            Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(statFs, new Object[0]);
            if (objInvoke != null && (objInvoke instanceof Long)) {
                return ((Long) objInvoke).longValue();
            }
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object objInvoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (objInvoke2 == null || !(objInvoke2 instanceof Integer)) {
                return 0L;
            }
            return ((Integer) objInvoke2).intValue();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    private static void c(OutputStream outputStream) {
        int iJ;
        if (com.uc.crashsdk.b.d) {
            String strO = com.uc.crashsdk.b.o();
            h = false;
            if (1 == JNIBridge.cmd(17, strO)) {
                File file = new File(strO);
                try {
                    byte[] bArrE = com.uc.crashsdk.a.g.e(file);
                    if (bArrE != null) {
                        outputStream.write(bArrE);
                    }
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                h = true;
                a(outputStream);
            }
            h = true;
            return;
        }
        File[] fileArrListFiles = null;
        try {
            iJ = g.J();
        } catch (Throwable th3) {
            th = th3;
            iJ = 900;
        }
        try {
            fileArrListFiles = new File("/proc/self/fd").listFiles();
            if (fileArrListFiles != null) {
                outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArrListFiles.length), Integer.valueOf(iJ)).getBytes("UTF-8"));
            } else {
                outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
            }
        } catch (Throwable th4) {
            th = th4;
            a(th, outputStream);
        }
        if (fileArrListFiles != null) {
            try {
                if (fileArrListFiles.length >= iJ) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (File file2 : fileArrListFiles) {
                            sb.append(file2.getName());
                            sb.append(" -> ");
                            sb.append(file2.getCanonicalPath());
                            sb.append("\n");
                        }
                    } catch (Throwable th5) {
                        a(th5, outputStream);
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
            } catch (Throwable th6) {
                a(th6, outputStream);
            }
        }
        a(outputStream);
    }

    private static void d(OutputStream outputStream) {
        int iK;
        int length;
        File[] fileArrListFiles = null;
        try {
            iK = g.K();
        } catch (Throwable th) {
            th = th;
            iK = 300;
        }
        try {
            fileArrListFiles = new File("/proc/self/task").listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            length = fileArrListFiles.length;
            if (length < iK) {
                return;
            }
        } catch (Throwable th2) {
            th = th2;
            com.uc.crashsdk.a.g.a(th);
            length = 0;
        }
        if (fileArrListFiles == null) {
            return;
        }
        try {
            outputStream.write("threads info:\n".getBytes("UTF-8"));
            outputStream.write(String.format(Locale.US, "threads count: %d, dump limit: %d.\n", Integer.valueOf(length), Integer.valueOf(iK)).getBytes("UTF-8"));
            outputStream.write(" tid     name\n".getBytes("UTF-8"));
            for (File file : fileArrListFiles) {
                outputStream.write(String.format(Locale.US, "%5s %s\n", file.getName(), l(com.uc.crashsdk.a.g.a(new File(file.getPath(), "comm"), 128, false))).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    private static void e(OutputStream outputStream) {
        BufferedReader bufferedReader;
        int iIndexOf;
        if (com.uc.crashsdk.b.d) {
            try {
                outputStream.write("solib build id:\n".getBytes("UTF-8"));
            } catch (Throwable th) {
                a(th, outputStream);
            }
            FileReader fileReader = null;
            try {
                ArrayList arrayList = new ArrayList();
                FileReader fileReader2 = new FileReader(new File("/proc/self/maps"));
                try {
                    bufferedReader = new BufferedReader(fileReader2, 512);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.endsWith(".so") && (iIndexOf = line.indexOf(47)) != -1) {
                                String strSubstring = line.substring(iIndexOf);
                                if ((strSubstring.contains("/data/") || strSubstring.contains(com.uc.crashsdk.a.f2128a)) && !arrayList.contains(strSubstring)) {
                                    arrayList.add(strSubstring);
                                    if (ag) {
                                        try {
                                            outputStream.write((String.format("$^%s`%s^$", "SOBUILDID", strSubstring) + "\n").getBytes("UTF-8"));
                                        } catch (Throwable th2) {
                                            a(th2, outputStream);
                                        }
                                    } else {
                                        outputStream.write(String.format(Locale.US, "%s: %s\n", strSubstring, JNIBridge.nativeGet(3, 0L, strSubstring)).getBytes("UTF-8"));
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileReader = fileReader2;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                a(outputStream);
                            } catch (Throwable th4) {
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                throw th4;
                            }
                        }
                    }
                    com.uc.crashsdk.a.g.a(fileReader2);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
        }
    }

    private static void a(a aVar) {
        try {
            aVar.a(String.format(Locale.US, "log end: %s\n", n()));
        } catch (Throwable th) {
            a(th, aVar);
        }
    }

    private static void b(a aVar) {
        h = false;
        try {
            aVar.write((s("LOG_END") + "\n").getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    static int a(OutputStream outputStream, String str, int i2) {
        int i3 = 0;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String strA = com.uc.crashsdk.a.b.a(str);
            if (strA == null) {
                strA = "file: '" + str + "' not found or decode failed!";
            }
            int length = strA.length();
            if (length <= i2 + 32) {
                i2 = length;
            }
            if (i2 > 0) {
                try {
                    outputStream.write(strA.getBytes("UTF-8"), 0, i2);
                    outputStream.write("\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    i3 = i2;
                    a(th, outputStream);
                    i2 = i3;
                }
            }
            if (i2 < strA.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(strA.length() - i2)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i2;
    }

    static int b(OutputStream outputStream, String str, int i2) {
        int i3;
        DataInputStream dataInputStream;
        int i4;
        DataInputStream dataInputStream2 = null;
        int i5 = 0;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] bArrR = R();
                if (bArrR == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    return 0;
                }
                dataInputStream = new DataInputStream(new FileInputStream(file));
                i4 = 0;
                i3 = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        int i6 = dataInputStream.read(bArrR);
                        if (i6 == -1) {
                            break;
                        }
                        i4 += i6;
                        int i7 = i2 - i3;
                        if (i6 <= i7 + 32) {
                            i7 = i6;
                        }
                        if (i7 > 0 && !z2) {
                            outputStream.write(bArrR, 0, i7);
                            i3 += i7;
                        }
                        if (!z2) {
                            z2 = i7 < i6 || i3 >= i2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        i5 = i3;
                        dataInputStream2 = dataInputStream;
                        try {
                            a(th, outputStream);
                            com.uc.crashsdk.a.g.a(dataInputStream2);
                            i3 = i5;
                        } finally {
                            com.uc.crashsdk.a.g.a(dataInputStream2);
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream = null;
                i4 = 0;
                i3 = 0;
            }
            if (i3 > 0) {
                outputStream.write("\n".getBytes("UTF-8"));
            }
            if (i3 < i4) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i4 - i3)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i3;
    }

    static String a(int i2) {
        try {
            String strA = com.uc.crashsdk.a.g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, false);
            return com.uc.crashsdk.a.g.b(strA) ? l(strA) : "unknown";
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "unknown";
        }
    }

    private static String l(String str) {
        if (!com.uc.crashsdk.a.g.b(str)) {
            return "";
        }
        int iIndexOf = str.indexOf(0);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        return str.trim();
    }

    public static String h() {
        String str = m;
        if (str != null) {
            return str;
        }
        String strA = a(Process.myPid());
        m = strA;
        return strA;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:0|2|306|3|4|(2:292|6)|9|(2:11|12)(1:13)|(2:302|14)|(52:290|15|(1:17)|21|(2:360|23)|366|28|316|32|339|33|(1:35)|39|(1:43)|332|47|352|51|55|370|56|298|61|(2:310|67)|72|337|73|77|308|78|350|82|86|87|368|88|93|(4:95|314|96|100)|328|101|106|348|107|364|112|343|116|(1:118)(2:119|(1:121))|125|362|126|130)|(4:132|312|133|137)(10:358|139|(0)(10:146|320|147|148|(15:150|151|346|152|153|341|154|326|155|156|324|157|158|318|159)|179|304|180|184|(21:186|344|187|209|210|322|211|216|(4:218|356|219|223)|285|224|229|300|230|235|(4:237|330|238|242)|243|354|244|(1:250)|251)(25:296|192|(1:194)|195|(1:197)|198|(4:200|(1:202)(1:204)|203|205)|209|210|322|211|216|(0)|285|224|229|300|230|235|(0)|243|354|244|(0)|251))|266|(1:268)|287|269|(1:271)(1:272)|273|277)|138|179|304|180|184|(0)(0)|266|(0)|287|269|(0)(0)|273|277|(2:(0)|(1:336))) */
    /* JADX WARN: Can't wrap try/catch for region: R(77:0|2|306|3|4|(2:292|6)|9|(2:11|12)(1:13)|302|14|290|15|(1:17)|21|(2:360|23)|366|28|316|32|339|33|(1:35)|39|(1:43)|332|47|352|51|55|370|56|298|61|(2:310|67)|72|337|73|77|308|78|350|82|86|87|368|88|93|(4:95|314|96|100)|328|101|106|348|107|364|112|343|116|(1:118)(2:119|(1:121))|125|362|126|130|(4:132|312|133|137)(10:358|139|(0)(10:146|320|147|148|(15:150|151|346|152|153|341|154|326|155|156|324|157|158|318|159)|179|304|180|184|(21:186|344|187|209|210|322|211|216|(4:218|356|219|223)|285|224|229|300|230|235|(4:237|330|238|242)|243|354|244|(1:250)|251)(25:296|192|(1:194)|195|(1:197)|198|(4:200|(1:202)(1:204)|203|205)|209|210|322|211|216|(0)|285|224|229|300|230|235|(0)|243|354|244|(0)|251))|266|(1:268)|287|269|(1:271)(1:272)|273|277)|138|179|304|180|184|(0)(0)|266|(0)|287|269|(0)(0)|273|277|(2:(0)|(1:336))) */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0370, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0371, code lost:
    
        a(r0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x04e3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x04e4, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0444 A[Catch: all -> 0x04a3, TRY_LEAVE, TryCatch #2 {all -> 0x04a3, blocks: (B:179:0x0363, B:184:0x0374, B:209:0x042b, B:216:0x0440, B:218:0x0444, B:223:0x0459, B:222:0x0456, B:235:0x046f, B:237:0x0473, B:242:0x0488, B:241:0x0485, B:243:0x048b, B:248:0x0497, B:234:0x046c, B:228:0x0462, B:215:0x043d, B:190:0x038e, B:183:0x0371, B:178:0x0360, B:224:0x045c, B:230:0x0466, B:180:0x0366, B:211:0x0437, B:238:0x0476, B:244:0x0491, B:219:0x0447), top: B:289:0x0360, inners: #0, #8, #10, #19, #23, #36, #37 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0473 A[Catch: all -> 0x04a3, TRY_LEAVE, TryCatch #2 {all -> 0x04a3, blocks: (B:179:0x0363, B:184:0x0374, B:209:0x042b, B:216:0x0440, B:218:0x0444, B:223:0x0459, B:222:0x0456, B:235:0x046f, B:237:0x0473, B:242:0x0488, B:241:0x0485, B:243:0x048b, B:248:0x0497, B:234:0x046c, B:228:0x0462, B:215:0x043d, B:190:0x038e, B:183:0x0371, B:178:0x0360, B:224:0x045c, B:230:0x0466, B:180:0x0366, B:211:0x0437, B:238:0x0476, B:244:0x0491, B:219:0x0447), top: B:289:0x0360, inners: #0, #8, #10, #19, #23, #36, #37 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04d2 A[Catch: all -> 0x04e3, TryCatch #1 {all -> 0x04e3, blocks: (B:269:0x04ce, B:271:0x04d2, B:273:0x04dd), top: B:287:0x04ce }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0393 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.Throwable r26, java.lang.String r27, long r28, boolean r30) {
        /*
            Method dump skipped, instruction units count: 1274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Throwable, java.lang.String, long, boolean):java.lang.String");
    }

    private static void f(OutputStream outputStream) {
        String strM;
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (ag) {
                strM = s("LASTVER");
            } else {
                strM = com.uc.crashsdk.a.m();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", strM).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            ArrayList<String> arrayList = s;
            synchronized (arrayList) {
                if (u != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", u).getBytes("UTF-8"));
                }
                if (t > 0 || arrayList.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(t)).getBytes("UTF-8"));
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "dumping all threads: %s\n", Boolean.valueOf(v)).getBytes("UTF-8"));
            if (w != null) {
                outputStream.write(String.format(Locale.US, "dumping threads: %s\n", w).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    private static String m(String str) {
        String strA = com.uc.crashsdk.a.b.a(str, g.w(), g.v());
        if (!str.equals(strA)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return strA;
    }

    static String a(String str) {
        int iLastIndexOf;
        int iIndexOf;
        int i2;
        int iIndexOf2;
        String strD;
        File file;
        byte[] bArrE;
        byte[] bArrB;
        if (!g.x() || (iLastIndexOf = str.lastIndexOf(47)) <= 0 || (iIndexOf = str.indexOf(95, iLastIndexOf)) <= iLastIndexOf || (iIndexOf2 = str.indexOf(95, (i2 = iIndexOf + 1))) <= iIndexOf || (strD = com.uc.crashsdk.a.g.d("CrashSDK" + str.substring(iLastIndexOf + 1, iIndexOf) + str.substring(i2, iIndexOf2))) == null || (bArrE = com.uc.crashsdk.a.g.e((file = new File(str)))) == null || bArrE.length <= 0) {
            return str;
        }
        try {
            bArrB = com.uc.crashsdk.a.c.b(bArrE, strD.substring(0, 16).getBytes());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            bArrB = null;
        }
        if (bArrB == null) {
            return str;
        }
        String str2 = str + ".ec";
        File file2 = new File(str2 + bi.k);
        if (!com.uc.crashsdk.a.g.a(file2, bArrB)) {
            return str;
        }
        if (!file2.renameTo(new File(str2))) {
            file2.delete();
            return str;
        }
        file.delete();
        return str2;
    }

    static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0302 A[Catch: all -> 0x0445, TryCatch #2 {all -> 0x0445, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d1, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b0, B:27:0x00c0, B:31:0x00cf, B:42:0x00fb, B:38:0x00ed, B:62:0x01cd, B:64:0x01e1, B:66:0x01e5, B:67:0x01e7, B:69:0x01ec, B:70:0x01ee, B:71:0x01f3, B:81:0x0217, B:82:0x022e, B:84:0x0234, B:86:0x023d, B:88:0x024c, B:90:0x026b, B:91:0x0279, B:93:0x028b, B:95:0x029b, B:96:0x02ad, B:110:0x02f3, B:113:0x0302, B:116:0x0311, B:119:0x0323, B:121:0x0331, B:123:0x033e, B:126:0x0345, B:130:0x0352, B:132:0x035e, B:134:0x0378, B:135:0x037d, B:137:0x038c, B:139:0x0399, B:145:0x03bd, B:150:0x03e3, B:152:0x03ea, B:154:0x03f1, B:156:0x03f8, B:158:0x03ff, B:160:0x0406, B:166:0x0418, B:168:0x041f, B:170:0x0426, B:172:0x042d, B:164:0x0411, B:138:0x0393, B:140:0x03b1, B:142:0x03b5, B:98:0x02b5, B:100:0x02bb, B:103:0x02c3, B:105:0x02c7, B:107:0x02dc, B:109:0x02e0, B:75:0x01fe, B:77:0x020c, B:79:0x0212, B:61:0x01ca, B:173:0x0435), top: B:193:0x000a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instruction units count: 1118
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, boolean, boolean):void");
    }

    static boolean i() {
        return d;
    }

    public static boolean a(boolean z2, boolean z3) {
        if (!d) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.set(1, true);
            }
            d = true;
        }
        try {
            String strK = k();
            if (com.uc.crashsdk.a.g.a(strK)) {
                com.uc.crashsdk.a.a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            if (com.uc.crashsdk.a.f.a(z2 ? 1 : 0, new com.uc.crashsdk.a.e(406, new Object[]{strK, Boolean.valueOf(z3), Boolean.valueOf(z2)})) && z2) {
                o.close();
                if (!r6.block(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS)) {
                    com.uc.crashsdk.a.a.a("crashsdk", "timeout to wait for uploading");
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    static void b(boolean z2) {
        try {
            boolean zS = g.r() && com.uc.crashsdk.b.F() && !d;
            if (!zS) {
                zS = g.s();
            }
            if (zS) {
                if (z2) {
                    String strK = k();
                    if (com.uc.crashsdk.a.g.a(strK)) {
                        return;
                    }
                    j();
                    a(strK, false, false);
                    return;
                }
                a(true, false);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private static String U() {
        return g.W() + "bytes";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        boolean zA;
        FileChannel channel;
        Exception e;
        synchronized (p) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            ?? r5 = 0;
            fileLockLock = null;
            FileLock fileLockLock = null;
            zA = false;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    channel = new RandomAccessFile(file, "rw").getChannel();
                } catch (Exception e3) {
                    try {
                        com.uc.crashsdk.a.g.a(e3);
                        channel = null;
                    } catch (Exception e4) {
                        channel = null;
                        e = e4;
                        com.uc.crashsdk.a.g.a(e);
                        com.uc.crashsdk.a.g.a(channel);
                        return zA;
                    }
                }
                if (channel != null) {
                    try {
                        fileLockLock = channel.lock();
                    } catch (Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            com.uc.crashsdk.a.g.a(e);
                        }
                    }
                }
                try {
                    zA = eVar.a();
                    com.uc.crashsdk.a.g.a(channel);
                } finally {
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (Exception e7) {
                            com.uc.crashsdk.a.g.a(e7);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r5 = file;
                com.uc.crashsdk.a.g.a((Closeable) r5);
                throw th;
            }
        }
        return zA;
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2142a;
        long b;
        int c;
        int d;
        boolean e;
        boolean f;
        boolean g;

        private d() {
            this.f2142a = 0L;
            this.b = 0L;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = false;
            this.g = false;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    private static boolean a(String str, d dVar) {
        String strA = com.uc.crashsdk.a.g.a(new File(str), 64, false);
        if (strA == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(strA);
            if (matcher.find()) {
                long j2 = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - j2 < 86400000) {
                    dVar.b = Long.parseLong(matcher.group(2));
                    dVar.c = Integer.parseInt(matcher.group(3));
                    dVar.d = Integer.parseInt(matcher.group(4));
                    dVar.f2142a = j2;
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return true;
    }

    private static boolean b(File file) {
        int iIndexOf;
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(95);
        if (iLastIndexOf <= 0 || (iIndexOf = name.indexOf(46, iLastIndexOf)) <= 0) {
            return false;
        }
        String strSubstring = name.substring(iLastIndexOf + 1, iIndexOf);
        return LogType.JAVA_TYPE.equals(strSubstring) || "ucebujava".equals(strSubstring) || LogType.NATIVE_TYPE.equals(strSubstring) || "ucebujni".equals(strSubstring) || LogType.UNEXP_TYPE.equals(strSubstring) || LogType.ANR_TYPE.equals(strSubstring);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean[] n(java.lang.String r7) {
        /*
            boolean r0 = com.uc.crashsdk.g.v()
            boolean r1 = com.uc.crashsdk.g.x()
            r2 = 0
            if (r0 != 0) goto Ld
            if (r1 == 0) goto L6f
        Ld:
            java.lang.String r3 = ".tmp"
            boolean r3 = r7.endsWith(r3)
            if (r3 != 0) goto L6d
            java.lang.String r3 = ".ec"
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L1e
            goto L6d
        L1e:
            char r3 = java.io.File.separatorChar
            int r3 = r7.lastIndexOf(r3)
            if (r3 >= 0) goto L29
            r3 = r2
            r4 = r3
            goto L2a
        L29:
            r4 = r2
        L2a:
            r5 = 95
            int r3 = r7.indexOf(r5, r3)
            if (r3 < 0) goto L36
            int r4 = r4 + 1
            int r3 = r3 + 1
        L36:
            if (r3 >= 0) goto L2a
            r3 = 8
            if (r4 == r3) goto L3d
            goto L6d
        L3d:
            java.lang.String r3 = com.uc.crashsdk.g.w()
            java.lang.String r4 = ".log"
            boolean r6 = r7.endsWith(r4)
            if (r6 != 0) goto L56
            boolean r0 = com.uc.crashsdk.a.g.a(r3)
            if (r0 != 0) goto L6d
            boolean r7 = r7.endsWith(r3)
            if (r7 != 0) goto L5c
            goto L6d
        L56:
            boolean r3 = com.uc.crashsdk.a.g.a(r3)
            if (r3 == 0) goto L5e
        L5c:
            r0 = r2
            goto L6f
        L5e:
            int r3 = r7.lastIndexOf(r5)
            int r3 = r7.indexOf(r4, r3)
            int r7 = r7.lastIndexOf(r4)
            if (r3 == r7) goto L6f
            goto L5c
        L6d:
            r0 = r2
            r1 = r0
        L6f:
            r7 = 2
            boolean[] r7 = new boolean[r7]
            r7[r2] = r0
            r0 = 1
            r7[r0] = r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.n(java.lang.String):boolean[]");
    }

    private static String b(String str, boolean z2, boolean z3) {
        if (z2) {
            try {
                str = m(str);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (!z3) {
            return str;
        }
        try {
            return a(str);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public static boolean a(StringBuffer stringBuffer, String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j3;
        boolean z2;
        boolean zA;
        if (c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z3 = ag || com.uc.crashsdk.b.L();
        if (!z3 && !com.uc.crashsdk.a.d.e()) {
            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        }
        if (!d(str)) {
            com.uc.crashsdk.a.a.d("DEBUG", "custom log sample miss: " + str);
            return false;
        }
        if (aa()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        }
        if (stringBuffer == null || str == null) {
            return false;
        }
        String strA = g.X() + k(str);
        ?? r11 = (j2 & 32) != 0 ? 1 : 0;
        if (z3) {
            long jNativeClientCreateConnection = com.uc.crashsdk.b.d ? JNIBridge.nativeClientCreateConnection(strA, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, str, r11) : 0L;
            if (jNativeClientCreateConnection == 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "skip custom log: " + str);
                return false;
            }
            j3 = jNativeClientCreateConnection;
        } else {
            if (a(h(), str, (boolean) r11)) {
                return false;
            }
            g.a();
            a(false);
            j3 = 0;
        }
        synchronized (q) {
            z2 = r11;
            zA = a(strA, j3, stringBuffer, str, j2, arrayList, arrayList2, arrayList3, str2);
        }
        if (zA && !z3) {
            b(h(), str, z2);
        }
        if (j3 != 0) {
            JNIBridge.nativeClientCloseConnection(j3);
        }
        if (!zA) {
            return false;
        }
        if (!z3) {
            r(strA);
        }
        if (!z3) {
            strA = a(m(strA));
        }
        b(strA, str);
        if (z2 == 0 || z3) {
            return true;
        }
        try {
            a(true, false);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    static boolean a(String str, String str2, boolean z2) {
        if (!o(str2)) {
            return false;
        }
        h.a(str, str2, true, z2);
        com.uc.crashsdk.a.a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
        return true;
    }

    static void b(String str, String str2, boolean z2) {
        h.a(str, str2, false, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static boolean o(String str) {
        boolean z2;
        boolean z3;
        int i2;
        synchronized (r) {
            File file = new File(g.W() + "customlog");
            String strA = com.uc.crashsdk.a.g.a(file, 1024, false);
            long jCurrentTimeMillis = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if (strA != null) {
                stringBuffer.append(strA);
                Matcher matcher = Pattern.compile("([^\\n\\r\\t\\s]+) (\\d+) (\\d+)").matcher(stringBuffer);
                for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
                    if (str.equals(matcher.group(1))) {
                        long j2 = Long.parseLong(matcher.group(2));
                        if (jCurrentTimeMillis - j2 < 86400000) {
                            try {
                                i2 = Integer.parseInt(matcher.group(3));
                            } catch (Exception e) {
                                com.uc.crashsdk.a.g.a(e);
                                i2 = 0;
                            }
                        } else {
                            i2 = 0;
                            j2 = jCurrentTimeMillis;
                        }
                        int iF = g.F();
                        z3 = iF >= 0 && i2 >= iF;
                        stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", str, Long.valueOf(j2), Integer.valueOf(i2 + 1)));
                        z2 = true;
                    }
                }
                z2 = false;
                z3 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            if (!z2) {
                stringBuffer.append(String.format(Locale.US, "%s %d 1\n", str, Long.valueOf(jCurrentTimeMillis)));
            }
            ?? r1 = 0;
            FileWriter fileWriter = null;
            try {
                try {
                    FileWriter fileWriter2 = new FileWriter(file);
                    try {
                        String string = stringBuffer.toString();
                        int length = string.length();
                        fileWriter2.write(string, 0, length);
                        com.uc.crashsdk.a.g.a(fileWriter2);
                        r1 = length;
                    } catch (Exception e2) {
                        e = e2;
                        fileWriter = fileWriter2;
                        com.uc.crashsdk.a.g.a(e);
                        com.uc.crashsdk.a.g.a(fileWriter);
                        r1 = fileWriter;
                    } catch (Throwable th) {
                        th = th;
                        r1 = fileWriter2;
                        com.uc.crashsdk.a.g.a((Closeable) r1);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z3;
    }

    private static void a(a aVar, String str, long j2) {
        String strNativeDumpThreads;
        if (com.uc.crashsdk.b.d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            strNativeDumpThreads = JNIBridge.nativeDumpThreads(str, j2);
            if (ag || strNativeDumpThreads == null || strNativeDumpThreads.length() >= 512 || !strNativeDumpThreads.startsWith("/") || strNativeDumpThreads.indexOf(10) >= 0) {
                str = strNativeDumpThreads;
            } else {
                str = strNativeDumpThreads;
                strNativeDumpThreads = new File(strNativeDumpThreads).exists() ? null : "Can not found " + strNativeDumpThreads;
            }
        } else {
            strNativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (strNativeDumpThreads != null) {
            try {
                aVar.write(strNativeDumpThreads.getBytes("UTF-8"));
                aVar.write("\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            a((OutputStream) aVar);
        } else if (str != null && !ag) {
            b(aVar, str, 1048576);
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0043 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r17, long r18, java.lang.StringBuffer r20, java.lang.String r21, long r22, java.util.ArrayList<java.lang.String> r24, java.util.ArrayList<java.lang.String> r25, java.util.ArrayList<java.lang.String> r26, java.lang.String r27) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, long, java.lang.StringBuffer, java.lang.String, long, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    public static String k() {
        String strA = x;
        if (com.uc.crashsdk.a.g.a(strA)) {
            synchronized (y) {
                strA = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.i(), g.y(), true);
                x = strA;
            }
        }
        return strA;
    }

    public static void b(String str) {
        synchronized (y) {
            x = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.i(), str + "\n");
        }
    }

    public static void l() {
        synchronized (y) {
            x = null;
        }
    }

    public static void c(String str) {
        synchronized (z) {
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.l(), str + "\n");
        }
    }

    static boolean d(String str) {
        if (ag) {
            return true;
        }
        try {
            return p(str);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[Catch: all -> 0x0109, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:38:0x00af, B:50:0x00d5, B:57:0x00f0, B:53:0x00e0, B:64:0x00fd, B:67:0x0107, B:11:0x0033, B:13:0x003b, B:14:0x0044, B:16:0x004c, B:18:0x0054, B:20:0x005c, B:26:0x006b, B:28:0x0075, B:30:0x0082, B:32:0x008c, B:33:0x0097, B:35:0x00a1), top: B:72:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean p(java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.p(java.lang.String):boolean");
    }

    private static Map<String, Integer> q(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("\\|", 30)) {
            String[] strArrSplit = str2.split(":", 3);
            if (strArrSplit.length == 2) {
                String strTrim = strArrSplit[0].trim();
                if (!com.uc.crashsdk.a.g.a(strTrim)) {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(strArrSplit[1].trim(), 10);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    map.put(strTrim, Integer.valueOf(i2));
                }
            }
        }
        return map;
    }

    public static void m() {
        if (ag) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(TTAdConstant.IMAGE_CODE), 1000L);
    }

    static String n() {
        return a(new Date());
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    public static void o() {
        b = System.currentTimeMillis();
    }

    private static void r(String str) {
        if (g.q()) {
            try {
                ab();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                File file = new File(g.Y());
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                com.uc.crashsdk.a.g.a(new File(str), file);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    private static void b(String str, String str2) {
        try {
            com.uc.crashsdk.d.a(str, h(), str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055 A[Catch: all -> 0x006e, TryCatch #2 {all -> 0x006e, blocks: (B:6:0x000a, B:8:0x002d, B:20:0x004f, B:22:0x0055, B:24:0x0066), top: B:34:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void p() {
        /*
            java.lang.String r0 = com.uc.crashsdk.e.B
            boolean r0 = com.uc.crashsdk.a.g.a(r0)
            if (r0 != 0) goto L9
            return
        L9:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L6e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e
            r2.<init>()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r3 = com.uc.crashsdk.g.W()     // Catch: java.lang.Throwable -> L6e
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r3 = "unique"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L6e
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L6e
            if (r2 == 0) goto L4f
            r2 = 48
            r3 = 0
            java.lang.String r2 = com.uc.crashsdk.a.g.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L6e
            if (r2 == 0) goto L4e
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r4 = 36
            if (r3 == r4) goto L3f
            goto L4f
        L3f:
            java.lang.String r0 = "[^0-9a-zA-Z-]"
            java.lang.String r3 = "-"
            java.lang.String r0 = r2.replaceAll(r0, r3)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            goto L4f
        L48:
            r0 = move-exception
            goto L71
        L4a:
            r0 = move-exception
            com.uc.crashsdk.a.g.a(r0)     // Catch: java.lang.Throwable -> L48
        L4e:
            r0 = r2
        L4f:
            boolean r2 = com.uc.crashsdk.a.g.a(r0)     // Catch: java.lang.Throwable -> L6e
            if (r2 == 0) goto L75
            com.uc.crashsdk.b.G()     // Catch: java.lang.Throwable -> L6e
            java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L6e
            boolean r2 = com.uc.crashsdk.a.g.a(r0)     // Catch: java.lang.Throwable -> L6e
            if (r2 != 0) goto L75
            byte[] r2 = r0.getBytes()     // Catch: java.lang.Throwable -> L6e
            com.uc.crashsdk.a.g.a(r1, r2)     // Catch: java.lang.Throwable -> L6e
            goto L75
        L6e:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L71:
            com.uc.crashsdk.a.g.a(r0)
            r0 = r2
        L75:
            com.uc.crashsdk.e.B = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.p():void");
    }

    public static String q() {
        return B;
    }

    private static String s(String str) {
        return String.format("$^%s^$", str);
    }

    static void a(OutputStream outputStream, String str, String str2, int i2, boolean z2, boolean z3) {
        h = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(z2 ? 1 : 0);
            objArr[4] = Integer.valueOf(z3 ? 1 : 0);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
        a(outputStream);
    }

    static void a(OutputStream outputStream, String str, String str2) {
        h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class c extends BroadcastReceiver {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                int unused = e.C = intent.getIntExtra("level", -1);
                int unused2 = e.D = intent.getIntExtra("scale", -1);
                int unused3 = e.E = intent.getIntExtra("voltage", -1);
                int unused4 = e.F = intent.getIntExtra("health", -1);
                int unused5 = e.G = intent.getIntExtra("plugged", -1);
                int unused6 = e.H = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                int unused7 = e.I = intent.getIntExtra("temperature", -1);
                String unused8 = e.J = intent.getStringExtra("technology");
                if (e.J() >= 2) {
                    e.K();
                    e.L();
                    return;
                }
                return;
            }
            if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                boolean unused9 = e.K = "android.intent.action.BATTERY_LOW".equals(action);
                e.K();
            } else if ("android.intent.action.ANR".equals(action)) {
                try {
                    e.d(context);
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                }
            }
        }
    }

    private static boolean V() {
        return Build.VERSION.SDK_INT < 29;
    }

    public static void a(Context context) {
        try {
            if (V()) {
                context.registerReceiver(new c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, com.uc.crashsdk.a.f.a(3));
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        boolean z2 = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int iMyPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == iMyPid) {
                O = true;
                if (O()) {
                    com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(130, next.longMsg);
                }
                z2 = true;
            }
        }
        if (!z2 && com.uc.crashsdk.b.d) {
            W();
        }
        return true;
    }

    private static void W() {
        if (O || com.uc.crashsdk.b.F() || com.uc.crashsdk.b.L()) {
            return;
        }
        JNIBridge.cmd(18);
    }

    static void r() {
        O = false;
        if (!com.uc.crashsdk.b.B()) {
            com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(416), 11000L);
        }
        if (V()) {
            return;
        }
        N = 0;
        X();
    }

    private static void X() {
        com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(TTAdConstant.VIDEO_URL_CODE), 1000L);
    }

    private static StringBuilder Y() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ").append(C).append("\nscale: ");
            sb.append(D).append("\nhealth: ");
            int i2 = F;
            switch (i2) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append(i2).append(str).append("\npluged: ");
            int i3 = G;
            sb.append(i3).append(i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)").append("\nstatus: ");
            int i4 = H;
            sb.append(i4).append(i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)" : " (Unknown)").append("\nvoltage: ");
            sb.append(E).append("\ntemperature: ");
            sb.append(I).append("\ntechnology: ");
            sb.append(J).append("\nbattery low: ");
            sb.append(K).append("\n");
            return sb;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void Z() {
        if (com.uc.crashsdk.b.c && L && com.uc.crashsdk.a.c) {
            L = false;
            if (com.uc.crashsdk.a.f.b(P)) {
                return;
            }
            com.uc.crashsdk.a.f.a(0, P, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    public static void b(Context context) {
        if (g.M()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(Q, intentFilter, null, com.uc.crashsdk.a.f.a(1));
                R = true;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    static void c(boolean z2) {
        boolean z3 = true;
        if (!R ? !z2 || !g.M() : z2 && g.M()) {
            z3 = false;
        }
        if (z3) {
            com.uc.crashsdk.a.e eVar = S;
            if (com.uc.crashsdk.a.f.b(eVar)) {
                com.uc.crashsdk.a.f.a(eVar);
            }
            com.uc.crashsdk.a.f.a(0, eVar, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
    }

    public static void s() {
        T = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    public static void t() {
        Thread.setDefaultUncaughtExceptionHandler(T);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    private static boolean aa() {
        return com.uc.crashsdk.b.d && JNIBridge.nativeIsCrashing();
    }

    static boolean u() {
        return c.get() || aa();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:(21:64|(34:107|(1:109)|110|(1:112)|113|555|114|538|119|534|120|(1:124)|125|126|133|504|(8:563|135|550|136|(1:138)(1:139)|490|146|(14:151|(3:524|153|(1:163)(3:518|156|157))(0)|(1:166)|553|167|536|171|(1:173)|174|(1:178)|179|(1:182)|186|(2:188|189)(1:578))(2:190|(14:192|(3:516|194|(1:204)(3:512|197|198))(0)|(1:207)|546|208|532|212|(1:214)|215|(1:219)|220|(1:223)|227|(2:229|230)(1:579))(1:231)))(5:(1:233)|234|(1:236)(1:238)|239|(15:241|(1:245)|(3:569|247|(1:257)(3:567|250|251))(0)|(1:260)|502|261|494|265|(1:267)|268|(1:272)|273|(1:276)|280|(2:282|283)(1:580))(1:(14:(1:288)|(3:565|290|(1:300)(3:561|293|294))(0)|(1:303)|500|304|484|308|(1:310)|311|(1:315)|316|(1:319)|323|(2:325|326)(1:581))))|327|(6:332|(1:334)|335|548|336|341)|342|(1:346)|(3:551|348|(1:358)(3:544|351|352))(0)|(1:361)|486|362|571|366|(1:368)|369|(1:373)|374|(1:377)|381|(2:383|384)(1:582))(14:68|(3:498|70|(1:80)(3:492|73|74))(0)|(1:83)|514|84|507|88|(1:90)|91|(1:95)|96|(1:99)|103|(2:105|106)(1:577))|391|482|392|(1:394)|395|(1:399)|(3:528|401|(1:411)(3:522|404|405))(0)|(1:414)|559|415|542|419|(1:421)|422|(1:426)|427|(1:430)|434|(2:436|437)(1:583))(17:14|(6:17|530|18|23|(1:574)(1:575)|15)|573|25|(3:496|27|(1:37)(3:488|30|31))(0)|(1:40)|510|41|505|45|(1:47)|48|(1:52)|53|(1:56)|60|(2:62|63)(1:576))|482|392|(0)|395|(2:397|399)|(0)(0)|(1:414)|559|415|542|419|(0)|422|(2:424|426)|427|(1:430)|434|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x0594, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x0595, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x05cd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x05ce, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0550 A[Catch: all -> 0x05e1, TRY_LEAVE, TryCatch #0 {all -> 0x05e1, blocks: (B:392:0x0539, B:394:0x0550), top: B:482:0x0539 }] */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x0608 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0623 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0659 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0572 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:583:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:584:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x0211 -> B:490:0x0219). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:145:0x0216 -> B:490:0x0219). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Thread r20, java.lang.Throwable r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 1633
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Thread, java.lang.Throwable, boolean):void");
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    public static Throwable v() {
        return U;
    }

    public static int w() {
        if (com.uc.crashsdk.b.I() == 5) {
            return Z;
        }
        return 100;
    }

    public static void x() {
        long jO = g.o();
        if (jO < 0) {
            return;
        }
        boolean z2 = com.uc.crashsdk.b.I() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(401));
        if (z2) {
            com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(402);
            X = eVar;
            com.uc.crashsdk.a.f.a(0, eVar, jO);
        }
    }

    static void y() {
        if (com.uc.crashsdk.b.c && com.uc.crashsdk.a.c && !com.uc.crashsdk.a.f.b(aa)) {
            com.uc.crashsdk.a.f.a(0, aa, 1000L);
        }
    }

    public static boolean z() {
        synchronized (Y) {
            Runnable runnable = X;
            if (runnable == null || W) {
                return false;
            }
            com.uc.crashsdk.a.f.a(runnable);
            X = null;
            return true;
        }
    }

    public static boolean e(String str) {
        try {
            if (!com.uc.crashsdk.a.g.b(str) || !str.startsWith("lib") || !str.endsWith(".so")) {
                return false;
            }
            System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static void b(int i2) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(TTAdConstant.IMAGE_LIST_SIZE_CODE), i2 * 1000);
    }

    private static void ab() {
        String strY = g.Y();
        File file = new File(strY);
        if (file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length > 150) {
                    Arrays.sort(fileArrListFiles, new b((byte) 0));
                    int length = fileArrListFiles.length - MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
                    if (length < 0) {
                        length = 0;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (i2 < fileArrListFiles.length) {
                        File file2 = fileArrListFiles[i2];
                        boolean z2 = i2 < length;
                        if (!z2 && jCurrentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        try {
                            file2.delete();
                            i3++;
                            i4 = 0;
                        } catch (Throwable th) {
                            i4++;
                            com.uc.crashsdk.a.g.a(th);
                        }
                        if (i4 >= 3) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i3 + " logs in " + strY);
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    public static void A() {
        if (g.q()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(403), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    public static void B() {
        if (ac || com.uc.crashsdk.b.L()) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(TTAdConstant.INTERACTION_TYPE_CODE), 1000L);
    }

    private static void a(Calendar calendar) {
        if (g.S()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j2 = timeInMillis2 - timeInMillis;
            long j3 = bi.s;
            if (j2 <= bi.s) {
                j3 = 1000 + j2;
            }
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(TTAdConstant.VIDEO_COVER_URL_CODE, new Object[]{Long.valueOf(timeInMillis2)}), j3);
        }
    }

    static void C() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(TTAdConstant.IMAGE_LIST_CODE), 7000L);
    }

    public static void d(boolean z2) {
        f.d(false);
        if (z2) {
            f.a(com.uc.crashsdk.b.c(), false);
            h.i();
        } else {
            f.a();
            h.i();
        }
    }

    public static int e(boolean z2) {
        return f.a(z2);
    }

    public static int f(boolean z2) {
        int iB;
        if (z2) {
            iB = f.a(com.uc.crashsdk.b.c()) ? 1 : 0;
        } else {
            iB = f.b();
        }
        int iB2 = f.b(z2);
        return iB2 > iB ? iB2 : iB;
    }

    static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z2 = str == null;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
                if (!z2 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    i3 = 0;
                    z2 = true;
                }
            }
            i2 = i3;
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    static StringBuilder f(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    public static void D() {
        int iN = g.N();
        boolean z2 = false;
        boolean z3 = true;
        if (iN != 0 && iN != 3 && iN != 4 && iN == 1) {
            z3 = false;
        }
        if (!z3) {
            com.uc.crashsdk.a.a.a("crashsdk", "SIG 3 is disabled by settings");
        }
        boolean zL = com.uc.crashsdk.b.L();
        if (Looper.getMainLooper() == Looper.myLooper() || !z3) {
            z2 = z3;
        } else {
            com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(TTAdConstant.VIDEO_INFO_CODE));
        }
        JNIBridge.nativeCmd(7, zL ? 1L : 0L, null, null);
        if (z2) {
            JNIBridge.cmd(8);
        }
    }

    public static ParcelFileDescriptor E() {
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        synchronized (ad) {
            ParcelFileDescriptor parcelFileDescriptor = ae;
            if (parcelFileDescriptor != null) {
                return parcelFileDescriptor;
            }
            int iCmd = (int) JNIBridge.cmd(14);
            if (iCmd == -1) {
                return null;
            }
            ParcelFileDescriptor parcelFileDescriptorAdoptFd = ParcelFileDescriptor.adoptFd(iCmd);
            ae = parcelFileDescriptorAdoptFd;
            af = true;
            return parcelFileDescriptorAdoptFd;
        }
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (af) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        }
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        }
        if (ae != null) {
            com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
        }
        ae = parcelFileDescriptor;
        int fd = parcelFileDescriptor.getFd();
        int iNativeCmd = (int) JNIBridge.nativeCmd(13, fd, null, null);
        ag = iNativeCmd != -1;
        return fd == -1 || iNativeCmd != -1;
    }

    public static boolean F() {
        return ag;
    }

    public static void G() {
        String strX = g.X();
        File file = new File(strX);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + strX);
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    a(false, false);
                    return;
                }
            }
        }
    }
}

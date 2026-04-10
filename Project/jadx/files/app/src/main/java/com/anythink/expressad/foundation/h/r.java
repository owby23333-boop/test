package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    static boolean a = false;
    static String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static char[] f10698c = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10699d = "common-exception";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10700e = "SameSDCardTool";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f10701f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f10702g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f10703h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f10704i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f10705j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f10706k;

    public static void a(Context context) {
        if (f10701f) {
            return;
        }
        try {
            try {
                b = context.getFilesDir().getAbsolutePath() + File.separator;
                if (context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0) {
                    a = true;
                } else {
                    a = false;
                }
                b(context);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            b = context.getFilesDir().getAbsolutePath() + File.separator;
            b(context);
        }
        f10701f = true;
    }

    private static void b(Context context) {
        String strC = c(context);
        f10706k = strC;
        com.anythink.expressad.foundation.g.c.d.a(new com.anythink.expressad.foundation.g.c.b(strC));
        com.anythink.expressad.foundation.g.c.d.a().b();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(android.content.Context r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 18
            if (r0 < r2) goto L1a
            java.io.File r0 = r7.getExternalFilesDir(r1)     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L1a
            java.io.File r0 = a(r0)     // Catch: java.lang.Throwable -> L12
            goto L1b
        L12:
            r0 = move-exception
            java.lang.String r2 = "common-exception"
            java.lang.String r3 = "hasSDCard is failed"
            com.anythink.expressad.foundation.h.o.b(r2, r3, r0)
        L1a:
            r0 = r1
        L1b:
            boolean r2 = com.anythink.expressad.foundation.h.r.a
            if (r2 == 0) goto L6f
            if (r0 != 0) goto L5e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = r2.getPath()
            r0.append(r2)
            java.lang.String r2 = java.io.File.separator
            r0.append(r2)
            java.lang.String r2 = "Android"
            r0.append(r2)
            java.lang.String r2 = java.io.File.separator
            r0.append(r2)
            java.lang.String r2 = "data"
            r0.append(r2)
            java.lang.String r2 = java.io.File.separator
            r0.append(r2)
            java.lang.String r2 = r7.getPackageName()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            java.io.File r0 = a(r2)
        L5e:
            long r2 = e()
            r4 = 31457280(0x1e00000, double:1.55419614E-316)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L6b
            r2 = 1
            goto L6c
        L6b:
            r2 = 0
        L6c:
            if (r2 != 0) goto L6f
            r0 = r1
        L6f:
            if (r0 == 0) goto L77
            boolean r1 = r0.exists()
            if (r1 != 0) goto L7f
        L77:
            java.io.File r7 = r7.getFilesDir()
            java.io.File r0 = r7.getAbsoluteFile()
        L7f:
            java.lang.String r7 = r0.getAbsolutePath()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.r.c(android.content.Context):java.lang.String");
    }

    private static int d() {
        try {
            Context contextD = com.anythink.expressad.foundation.b.a.b().d();
            long jLongValue = ((Long) v.b(contextD, "freeExternalSize", 0L)).longValue();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jLongValue > 1800000 || f10703h == -1) {
                f10703h = Long.valueOf((e() / 1000) / 1000).intValue();
                v.a(contextD, "freeExternalSize", Long.valueOf(jCurrentTimeMillis));
            }
        } catch (Throwable th) {
            o.b(f10700e, th.getMessage(), th);
        }
        return f10703h;
    }

    private static long e() {
        if (b()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    private static boolean f() {
        return e() > 31457280;
    }

    private static int g() {
        if (f10702g == -1) {
            try {
                f10702g = new Long((h() / 1000) / 1000).intValue();
            } catch (Throwable th) {
                o.b(f10700e, th.getMessage(), th);
            }
        }
        return f10702g;
    }

    private static long h() {
        if (b()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    private static int i() {
        try {
            Context contextD = com.anythink.expressad.foundation.b.a.b().d();
            long jLongValue = ((Long) v.b(contextD, "TotalDataSize", 0L)).longValue();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jLongValue > 1800000 || f10704i == -1) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                f10704i = Long.valueOf(((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000) / 1000).intValue();
                v.a(contextD, "TotalDataSize", Long.valueOf(jCurrentTimeMillis));
            }
        } catch (Throwable th) {
            o.b(f10700e, th.getMessage(), th);
        }
        return f10704i;
    }

    private static int j() {
        try {
            Context contextD = com.anythink.expressad.foundation.b.a.b().d();
            long jLongValue = ((Long) v.b(contextD, "FreeDataSize", 0L)).longValue();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jLongValue > 1800000 || f10705j == -1) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                f10705j = Long.valueOf(((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000) / 1000).intValue();
                v.a(contextD, "FreeDataSize", Long.valueOf(jCurrentTimeMillis));
            }
        } catch (Throwable th) {
            o.b(f10700e, th.getMessage(), th);
        }
        return f10705j;
    }

    private static long k() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    private static long l() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static boolean b() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            o.d("", "hasSDCard is failed");
            return false;
        }
    }

    private static long d(Context context) {
        try {
            String absolutePath = context.getFilesDir().getAbsolutePath();
            StatFs statFs = new StatFs(absolutePath);
            statFs.restat(absolutePath);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String a() {
        return f10706k;
    }

    private static boolean c() {
        return a;
    }

    private static File a(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(UUID.randomUUID());
        File file2 = new File(file, sb.toString());
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.mkdirs()) {
            return null;
        }
        file2.delete();
        return file.getAbsoluteFile();
    }

    public static boolean a(long j2) {
        return e() > j2;
    }
}

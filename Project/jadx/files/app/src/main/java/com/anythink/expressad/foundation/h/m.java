package com.anythink.expressad.foundation.h;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends e {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10671c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10672d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10673e = "/download/.at";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10674f = "/atdownload";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f10675g = "SameFileTool";

    static class a {
        public static final int a = 448;
        public static final int b = 256;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f10676c = 128;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f10677d = 64;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f10678e = 56;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f10679f = 32;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f10680g = 16;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f10681h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f10682i = 7;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f10683j = 4;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f10684k = 2;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f10685l = 1;

        a() {
        }
    }

    private static double a(long j2, int i2) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (i2 == 1) {
            return Double.valueOf(decimalFormat.format(j2)).doubleValue();
        }
        if (i2 == 2) {
            double d2 = j2;
            Double.isNaN(d2);
            return Double.valueOf(decimalFormat.format(d2 / 1024.0d)).doubleValue();
        }
        if (i2 == 3) {
            double d3 = j2;
            Double.isNaN(d3);
            return Double.valueOf(decimalFormat.format(d3 / 1048576.0d)).doubleValue();
        }
        if (i2 != 4) {
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
        double d4 = j2;
        Double.isNaN(d4);
        return Double.valueOf(decimalFormat.format(d4 / 1.073741824E9d)).doubleValue();
    }

    private static double b(String str, int i2) {
        long jD;
        File file = new File(str);
        try {
            jD = file.isDirectory() ? d(file) : c(file);
        } catch (Exception e2) {
            e2.printStackTrace();
            o.d("获取文件大小", "获取失败!");
            jD = 0;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (i2 == 1) {
            return Double.valueOf(decimalFormat.format(jD)).doubleValue();
        }
        if (i2 == 2) {
            double d2 = jD;
            Double.isNaN(d2);
            return Double.valueOf(decimalFormat.format(d2 / 1024.0d)).doubleValue();
        }
        if (i2 == 3) {
            double d3 = jD;
            Double.isNaN(d3);
            return Double.valueOf(decimalFormat.format(d3 / 1048576.0d)).doubleValue();
        }
        if (i2 != 4) {
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
        double d4 = jD;
        Double.isNaN(d4);
        return Double.valueOf(decimalFormat.format(d4 / 1.073741824E9d)).doubleValue();
    }

    private static long c(File file) throws Throwable {
        long jAvailable = 0;
        FileInputStream fileInputStream = null;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        jAvailable = fileInputStream2.available();
                        fileInputStream = fileInputStream2;
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return jAvailable;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    file.createNewFile();
                    o.d("获取文件大小", "文件不存在!");
                }
            } catch (Exception e5) {
                e = e5;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return jAvailable;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static long d(File file) {
        File[] fileArrListFiles = file.listFiles();
        long jD = 0;
        if (fileArrListFiles != null) {
            for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                jD += fileArrListFiles[i2].isDirectory() ? d(fileArrListFiles[i2]) : c(fileArrListFiles[i2]);
            }
        }
        return jD;
    }

    private static String e(String str) {
        long jD;
        File file = new File(str);
        try {
            jD = file.isDirectory() ? d(file) : c(file);
        } catch (Exception e2) {
            e2.printStackTrace();
            o.d("获取文件大小", "获取失败!");
            jD = 0;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (jD == 0) {
            return "0B";
        }
        if (jD < 1024) {
            return decimalFormat.format(jD) + "B";
        }
        if (jD < 1048576) {
            StringBuilder sb = new StringBuilder();
            double d2 = jD;
            Double.isNaN(d2);
            sb.append(decimalFormat.format(d2 / 1024.0d));
            sb.append("KB");
            return sb.toString();
        }
        if (jD < DownloadConstants.GB) {
            StringBuilder sb2 = new StringBuilder();
            double d3 = jD;
            Double.isNaN(d3);
            sb2.append(decimalFormat.format(d3 / 1048576.0d));
            sb2.append("AT");
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        double d4 = jD;
        Double.isNaN(d4);
        sb3.append(decimalFormat.format(d4 / 1.073741824E9d));
        sb3.append("GB");
        return sb3.toString();
    }

    private static void f(String str) {
        try {
            ArrayList<File> arrayListE = e(new File(str));
            Collections.sort(arrayListE, new Comparator<File>() { // from class: com.anythink.expressad.foundation.h.m.4
                private static int a(File file, File file2) {
                    long jLastModified = file.lastModified() - file2.lastModified();
                    if (jLastModified > 0) {
                        return 1;
                    }
                    return jLastModified == 0 ? 0 : -1;
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(File file, File file2) {
                    long jLastModified = file.lastModified() - file2.lastModified();
                    if (jLastModified > 0) {
                        return 1;
                    }
                    return jLastModified == 0 ? 0 : -1;
                }

                @Override // java.util.Comparator
                public final boolean equals(Object obj) {
                    return true;
                }
            });
            int size = (arrayListE.size() - 1) / 2;
            for (int i2 = 0; i2 < size; i2++) {
                File file = arrayListE.get(i2);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
            o.d(f10675g, "del memory failed");
        }
    }

    private static void g(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : b(str)) {
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String d(String str) {
        return !TextUtils.isEmpty(str) ? p.a(x.a(str.trim())) : "";
    }

    /* JADX WARN: Can't wrap try/catch for region: R(2:(3:36|5|(1:7)(0))|38) */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r4) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L39
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L39
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L39
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L39
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            r4.<init>()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
        L10:
            java.lang.String r2 = r1.readLine()     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L4a
            if (r2 == 0) goto L2b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L4a
            r3.<init>()     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L4a
            r3.append(r2)     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L4a
            java.lang.String r2 = "\n"
            r3.append(r2)     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L4a
            java.lang.String r2 = r3.toString()     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L4a
            r4.append(r2)     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L4a
            goto L10
        L2b:
            r1.close()     // Catch: java.io.IOException -> L2f
            goto L42
        L2f:
            goto L42
        L31:
            r2 = move-exception
            goto L3c
        L33:
            r2 = move-exception
            r4 = r0
            goto L3c
        L36:
            r4 = move-exception
            r1 = r0
            goto L4b
        L39:
            r2 = move-exception
            r4 = r0
            r1 = r4
        L3c:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L42
            goto L2b
        L42:
            if (r4 == 0) goto L49
            java.lang.String r4 = r4.toString()
            return r4
        L49:
            return r0
        L4a:
            r4 = move-exception
        L4b:
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.io.IOException -> L50
        L50:
            goto L52
        L51:
            throw r4
        L52:
            goto L51
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.m.a(java.io.File):java.lang.String");
    }

    private static boolean d(String str, int i2) {
        try {
            Class.forName("android.os.FileUtils").getMethod("setPermissions", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, str, Integer.valueOf(i2), -1, -1);
            return true;
        } catch (ClassNotFoundException e2) {
            o.a(f10675g, "error when set permissions:", e2);
            return false;
        } catch (IllegalAccessException e3) {
            o.a(f10675g, "error when set permissions:", e3);
            return false;
        } catch (IllegalArgumentException e4) {
            o.a(f10675g, "error when set permissions:", e4);
            return false;
        } catch (NoSuchMethodException e5) {
            o.a(f10675g, "error when set permissions:", e5);
            return false;
        } catch (InvocationTargetException e6) {
            o.a(f10675g, "error when set permissions:", e6);
            return false;
        }
    }

    public static void c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - 1440000;
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2.lastModified() + jCurrentTimeMillis < jCurrentTimeMillis2) {
                            b(file2);
                            try {
                                File file3 = new File(str + ".zip");
                                if (file3.exists() && file3.isFile()) {
                                    b(file3);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    private static ArrayList<File> e(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        for (File file2 : file.listFiles(new FileFilter() { // from class: com.anythink.expressad.foundation.h.m.3
            @Override // java.io.FileFilter
            public final boolean accept(File file3) {
                return !file3.isHidden() || file3.isDirectory();
            }
        })) {
            if (!file2.isDirectory()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(e(file2));
            }
        }
        return arrayList;
    }

    private static String b(long j2) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j2 == 0) {
            return "0B";
        }
        if (j2 < 1024) {
            return decimalFormat.format(j2) + "B";
        }
        if (j2 < 1048576) {
            StringBuilder sb = new StringBuilder();
            double d2 = j2;
            Double.isNaN(d2);
            sb.append(decimalFormat.format(d2 / 1024.0d));
            sb.append("KB");
            return sb.toString();
        }
        if (j2 < DownloadConstants.GB) {
            StringBuilder sb2 = new StringBuilder();
            double d3 = j2;
            Double.isNaN(d3);
            sb2.append(decimalFormat.format(d3 / 1048576.0d));
            sb2.append("AT");
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        double d4 = j2;
        Double.isNaN(d4);
        sb3.append(decimalFormat.format(d4 / 1.073741824E9d));
        sb3.append("GB");
        return sb3.toString();
    }

    public static boolean a(String str) {
        if (com.anythink.expressad.foundation.g.d.e.a(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public static File[] b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.listFiles();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a() {
        new Thread(new Runnable() { // from class: com.anythink.expressad.foundation.h.m.1
            /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
            /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    r5 = this;
                    com.anythink.expressad.foundation.b.a r0 = com.anythink.expressad.foundation.b.a.b()     // Catch: java.lang.Exception -> L43
                    android.content.Context r0 = r0.d()     // Catch: java.lang.Exception -> L43
                    if (r0 == 0) goto L42
                    com.anythink.expressad.foundation.g.c.a r0 = com.anythink.expressad.foundation.g.c.a.ANYTHINK_VC     // Catch: java.lang.Exception -> L43
                    java.lang.String r0 = com.anythink.expressad.foundation.g.c.d.b(r0)     // Catch: java.lang.Exception -> L43
                    java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L3e
                    r1.<init>(r0)     // Catch: java.lang.Exception -> L3e
                    boolean r2 = r1.exists()     // Catch: java.lang.Exception -> L3e
                    if (r2 == 0) goto L3d
                    boolean r1 = r1.isDirectory()     // Catch: java.lang.Exception -> L3e
                    if (r1 == 0) goto L3d
                    java.io.File[] r0 = com.anythink.expressad.foundation.h.m.b(r0)     // Catch: java.lang.Exception -> L3e
                    int r1 = r0.length     // Catch: java.lang.Exception -> L3e
                    r2 = 0
                L27:
                    if (r2 >= r1) goto L3d
                    r3 = r0[r2]     // Catch: java.lang.Exception -> L3e
                    boolean r4 = r3.exists()     // Catch: java.lang.Exception -> L3e
                    if (r4 == 0) goto L3a
                    boolean r4 = r3.isFile()     // Catch: java.lang.Exception -> L3e
                    if (r4 == 0) goto L3a
                    r3.delete()     // Catch: java.lang.Exception -> L3e
                L3a:
                    int r2 = r2 + 1
                    goto L27
                L3d:
                    return
                L3e:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch: java.lang.Exception -> L43
                L42:
                    return
                L43:
                    r0 = move-exception
                    boolean r1 = com.anythink.expressad.a.a
                    if (r1 == 0) goto L4b
                    r0.printStackTrace()
                L4b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.m.AnonymousClass1.run():void");
            }
        }).start();
    }

    public static void a(long j2) {
        try {
            for (File file : e(new File(com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_RES_MANAGER_DIR)))) {
                if (file.lastModified() < j2 && file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Throwable th) {
            o.b(f10675g, th.getMessage(), th);
        }
    }

    public static void b() {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.expressad.foundation.h.m.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.anythink.expressad.d.b.a();
                    com.anythink.expressad.foundation.b.a.b().e();
                    com.anythink.expressad.d.a aVarB = com.anythink.expressad.d.b.b();
                    if (aVarB == null) {
                        com.anythink.expressad.d.b.a();
                        aVarB = com.anythink.expressad.d.b.c();
                    }
                    m.a(com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_RES_MANAGER_DIR), aVarB.b());
                    m.a(System.currentTimeMillis() - ((long) (aVarB.n() * 1000)));
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.a) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    public static String b(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            }
            if (!file.isDirectory()) {
                return "";
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                for (File file2 : fileArrListFiles) {
                    b(file2);
                }
                file.delete();
                return "";
            }
            file.delete();
            return "";
        } catch (Exception e2) {
            return e2.getMessage();
        }
    }

    private static void c(String str, int i2) {
        try {
            if (d(new File(str)) > i2 * 1048576) {
                f(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable unused) {
            o.d(f10675g, "clean memory failed");
        }
    }

    private static boolean c(String str, String str2) {
        File[] fileArrListFiles;
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str) && str2 != null && !TextUtils.isEmpty(str2)) {
                    File file = new File(str);
                    if (file.isDirectory() && file.listFiles() != null && file.listFiles().length > 0 && (fileArrListFiles = file.listFiles()) != null) {
                        for (File file2 : fileArrListFiles) {
                            if (file2.isFile()) {
                                if (str2.equals(file2.getName())) {
                                    return true;
                                }
                            } else {
                                c(file2.getAbsolutePath(), str2);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    private static boolean a(String str, String str2, String str3) throws Throwable {
        try {
            if (r.b()) {
                String str4 = str + File.separator + str3;
                File file = new File(str4);
                if (file.exists() && file.isFile() && r.a(file.length())) {
                    File file2 = new File(str2);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    int iB = b(str4, str2 + File.separator + str3);
                    if (file.exists() && iB == 0) {
                        file.delete();
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private static int b(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!r.a) {
                return -1;
            }
            fileInputStream = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                }
                File file = new File(str2);
                if (file.exists()) {
                    if (file.isFile()) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return 0;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return -1;
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            fileInputStream = null;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        }
        if (fileOutputStream2 != null) {
            try {
                fileOutputStream2.close();
            } catch (IOException e9) {
                e9.printStackTrace();
            }
        }
        return -1;
    }

    public static boolean a(byte[] bArr, File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (file.getParentFile() != null && !file.exists()) {
                    file.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x0103, code lost:
    
        throw new java.lang.Exception("zipEntry's name is unsafe!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.m.a(java.lang.String, java.lang.String):java.lang.String");
    }

    static /* synthetic */ void a(String str, int i2) {
        try {
            if (d(new File(str)) > i2 * 1048576) {
                f(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable unused) {
            o.d(f10675g, "clean memory failed");
        }
    }
}

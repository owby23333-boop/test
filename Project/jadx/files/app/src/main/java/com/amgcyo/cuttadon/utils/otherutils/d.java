package com.amgcyo.cuttadon.utils.otherutils;

import android.content.Context;
import android.os.Process;
import com.amgcyo.cuttadon.app.MkApplication;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ACache.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static Map<String, d> b = new HashMap();
    private b a;

    /* JADX INFO: compiled from: ACache.java */
    public class b {
        private final AtomicLong a;
        private final AtomicInteger b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f4386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f4387d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Map<File, Long> f4388e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected File f4389f;

        /* JADX INFO: compiled from: ACache.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles = b.this.f4389f.listFiles();
                if (fileArrListFiles != null) {
                    int iA = 0;
                    int i2 = 0;
                    for (File file : fileArrListFiles) {
                        iA = (int) (((long) iA) + b.this.a(file));
                        i2++;
                        b.this.f4388e.put(file, Long.valueOf(file.lastModified()));
                    }
                    b.this.a.set(iA);
                    b.this.b.set(i2);
                }
            }
        }

        private b(d dVar, File file, long j2, int i2) {
            this.f4388e = Collections.synchronizedMap(new HashMap());
            this.f4389f = file;
            this.f4386c = j2;
            this.f4387d = i2;
            this.a = new AtomicLong();
            this.b = new AtomicInteger();
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c(String str) {
            return a(str).delete();
        }

        private void a() {
            new Thread(new a()).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(File file) {
            int iAddAndGet = this.b.get();
            while (iAddAndGet + 1 > this.f4387d) {
                this.a.addAndGet(-b());
                iAddAndGet = this.b.addAndGet(-1);
            }
            this.b.addAndGet(1);
            long jA = a(file);
            long jAddAndGet = this.a.get();
            while (jAddAndGet + jA > this.f4386c) {
                jAddAndGet = this.a.addAndGet(-b());
            }
            this.a.addAndGet(jA);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(lValueOf.longValue());
            this.f4388e.put(file, lValueOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File a(String str) {
            File fileB = b(str);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            fileB.setLastModified(lValueOf.longValue());
            this.f4388e.put(fileB, lValueOf);
            return fileB;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a(File file) {
            return file.length();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File b(String str) {
            return new File(this.f4389f, str.hashCode() + "");
        }

        private long b() {
            File key;
            if (this.f4388e.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> setEntrySet = this.f4388e.entrySet();
            synchronized (this.f4388e) {
                key = null;
                Long value = null;
                for (Map.Entry<File, Long> entry : setEntrySet) {
                    if (key == null) {
                        key = entry.getKey();
                        value = entry.getValue();
                    } else {
                        Long value2 = entry.getValue();
                        if (value2.longValue() < value.longValue()) {
                            key = entry.getKey();
                            value = value2;
                        }
                    }
                }
            }
            long jA = a(key);
            if (key.delete()) {
                this.f4388e.remove(key);
            }
            return jA;
        }
    }

    /* JADX INFO: compiled from: ACache.java */
    private static class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] c(byte[] bArr) {
            return e(bArr) ? a(bArr, a(bArr, ' ') + 1, bArr.length) : bArr;
        }

        private static String[] d(byte[] bArr) {
            if (e(bArr)) {
                return new String[]{new String(a(bArr, 0, 13)), new String(a(bArr, 14, a(bArr, ' ')))};
            }
            return null;
        }

        private static boolean e(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && a(bArr, ' ') > 14;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean f(byte[] bArr) {
            String[] strArrD = d(bArr);
            if (strArrD != null && strArrD.length == 2) {
                String strSubstring = strArrD[0];
                while (strSubstring.startsWith("0")) {
                    strSubstring = strSubstring.substring(1, strSubstring.length());
                }
                if (System.currentTimeMillis() > Long.valueOf(strSubstring).longValue() + (Long.valueOf(strArrD[1]).longValue() * 1000)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] b(int i2, byte[] bArr) {
            byte[] bytes = a(i2).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        private static int a(byte[] bArr, char c2) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] == c2) {
                    return i2;
                }
            }
            return -1;
        }

        private static byte[] a(byte[] bArr, int i2, int i3) {
            int i4 = i3 - i2;
            if (i4 >= 0) {
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i2, bArr2, 0, Math.min(bArr.length - i2, i4));
                return bArr2;
            }
            throw new IllegalArgumentException(i2 + " > " + i3);
        }

        private static String a(int i2) {
            String str = System.currentTimeMillis() + "";
            while (str.length() < 13) {
                str = "0" + str;
            }
            return str + "-" + i2 + ' ';
        }
    }

    private d(File file, long j2, int i2) {
        if (file.exists() || file.mkdirs()) {
            this.a = new b(file, j2, i2);
            return;
        }
        throw new RuntimeException("can't make dirs in " + file.getAbsolutePath());
    }

    public static d a(Context context) {
        return a(context, 100000000L, Integer.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(java.lang.String r5) throws java.lang.Throwable {
        /*
            r4 = this;
            byte[] r5 = r4.a(r5)
            r0 = 0
            if (r5 == 0) goto L64
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            java.lang.Object r0 = r5.readObject()     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L4b
            r1.close()     // Catch: java.io.IOException -> L19
            goto L1d
        L19:
            r1 = move-exception
            r1.printStackTrace()
        L1d:
            r5.close()     // Catch: java.io.IOException -> L21
            goto L25
        L21:
            r5 = move-exception
            r5.printStackTrace()
        L25:
            return r0
        L26:
            r2 = move-exception
            goto L33
        L28:
            r5 = move-exception
            goto L4f
        L2a:
            r2 = move-exception
            r5 = r0
            goto L33
        L2d:
            r5 = move-exception
            r1 = r0
            goto L4f
        L30:
            r2 = move-exception
            r5 = r0
            r1 = r5
        L33:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L40
            r1.close()     // Catch: java.io.IOException -> L3c
            goto L40
        L3c:
            r1 = move-exception
            r1.printStackTrace()
        L40:
            if (r5 == 0) goto L4a
            r5.close()     // Catch: java.io.IOException -> L46
            goto L4a
        L46:
            r5 = move-exception
            r5.printStackTrace()
        L4a:
            return r0
        L4b:
            r0 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
        L4f:
            if (r1 == 0) goto L59
            r1.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r1 = move-exception
            r1.printStackTrace()
        L59:
            if (r0 == 0) goto L63
            r0.close()     // Catch: java.io.IOException -> L5f
            goto L63
        L5f:
            r0 = move-exception
            r0.printStackTrace()
        L63:
            throw r5
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.utils.otherutils.d.b(java.lang.String):java.lang.Object");
    }

    public boolean c(String str) {
        return this.a.c(str);
    }

    public static d a(Context context, long j2, int i2) {
        if (context == null) {
            context = MkApplication.getAppContext();
        }
        File[] fileArr = {new File(context.getCacheDir(), "art_local_cache"), new File(context.getFilesDir(), "art_local_cache"), new File(context.getExternalCacheDir(), "art_local_cache"), new File(context.getExternalFilesDir(null), "art_local_cache")};
        for (File file : fileArr) {
            d dVar = b.get(file.getAbsoluteFile() + a());
            if (dVar != null) {
                return dVar;
            }
        }
        for (File file2 : fileArr) {
            if (file2.exists() || file2.mkdirs()) {
                return a(file2, j2, i2);
            }
        }
        return null;
    }

    public static d a(File file, long j2, int i2) {
        d dVar = b.get(file.getAbsoluteFile() + a());
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(file, j2, i2);
        b.put(file.getAbsolutePath() + a(), dVar2);
        return dVar2;
    }

    private static String a() {
        return "_" + Process.myPid();
    }

    public void a(String str, String str2) {
        File fileB = this.a.b(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(fileB), 1024);
                try {
                    bufferedWriter2.write(str2);
                    try {
                        bufferedWriter2.flush();
                        bufferedWriter2.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    this.a.b(fileB);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        }
        this.a.b(fileB);
    }

    public void a(String str, byte[] bArr) throws Throwable {
        File fileB = this.a.b(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileB);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    this.a.b(fileB);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
        this.a.b(fileB);
    }

    public void a(String str, byte[] bArr, int i2) throws Throwable {
        a(str, c.b(i2, bArr));
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            com.amgcyo.cuttadon.utils.otherutils.d$b r1 = r5.a     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L6d
            java.io.File r1 = com.amgcyo.cuttadon.utils.otherutils.d.b.c(r1, r6)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L6d
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L6d
            if (r2 != 0) goto Le
            return r0
        Le:
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L6d
            java.lang.String r3 = "r"
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L6d
            long r3 = r2.length()     // Catch: java.lang.Exception -> L4e java.lang.OutOfMemoryError -> L50 java.lang.Throwable -> L85
            int r1 = (int) r3     // Catch: java.lang.Exception -> L4e java.lang.OutOfMemoryError -> L50 java.lang.Throwable -> L85
            byte[] r1 = new byte[r1]     // Catch: java.lang.Exception -> L4e java.lang.OutOfMemoryError -> L50 java.lang.Throwable -> L85
            r2.read(r1)     // Catch: java.lang.Exception -> L4e java.lang.OutOfMemoryError -> L50 java.lang.Throwable -> L85
            boolean r3 = com.amgcyo.cuttadon.utils.otherutils.d.c.a(r1)     // Catch: java.lang.Exception -> L4e java.lang.OutOfMemoryError -> L50 java.lang.Throwable -> L85
            if (r3 != 0) goto L3a
            byte[] r6 = com.amgcyo.cuttadon.utils.otherutils.d.c.b(r1)     // Catch: java.lang.Exception -> L4e java.lang.OutOfMemoryError -> L50 java.lang.Throwable -> L85
            r2.close()     // Catch: java.io.IOException -> L2d
            goto L31
        L2d:
            r0 = move-exception
            r0.printStackTrace()
        L31:
            java.lang.System.gc()     // Catch: java.lang.Exception -> L35
            goto L39
        L35:
            r0 = move-exception
            r0.printStackTrace()
        L39:
            return r6
        L3a:
            r2.close()     // Catch: java.io.IOException -> L3e
            goto L42
        L3e:
            r1 = move-exception
            r1.printStackTrace()
        L42:
            java.lang.System.gc()     // Catch: java.lang.Exception -> L46
            goto L4a
        L46:
            r1 = move-exception
            r1.printStackTrace()
        L4a:
            r5.c(r6)
            return r0
        L4e:
            r6 = move-exception
            goto L57
        L50:
            r6 = move-exception
            goto L6f
        L52:
            r6 = move-exception
            r2 = r0
            goto L86
        L55:
            r6 = move-exception
            r2 = r0
        L57:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L85
            if (r2 == 0) goto L6c
            r2.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r6 = move-exception
            r6.printStackTrace()
        L64:
            java.lang.System.gc()     // Catch: java.lang.Exception -> L68
            goto L6c
        L68:
            r6 = move-exception
            r6.printStackTrace()
        L6c:
            return r0
        L6d:
            r6 = move-exception
            r2 = r0
        L6f:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L85
            if (r2 == 0) goto L84
            r2.close()     // Catch: java.io.IOException -> L78
            goto L7c
        L78:
            r6 = move-exception
            r6.printStackTrace()
        L7c:
            java.lang.System.gc()     // Catch: java.lang.Exception -> L80
            goto L84
        L80:
            r6 = move-exception
            r6.printStackTrace()
        L84:
            return r0
        L85:
            r6 = move-exception
        L86:
            if (r2 == 0) goto L98
            r2.close()     // Catch: java.io.IOException -> L8c
            goto L90
        L8c:
            r0 = move-exception
            r0.printStackTrace()
        L90:
            java.lang.System.gc()     // Catch: java.lang.Exception -> L94
            goto L98
        L94:
            r0 = move-exception
            r0.printStackTrace()
        L98:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.utils.otherutils.d.a(java.lang.String):byte[]");
    }

    public void a(String str, Serializable serializable) throws Throwable {
        a(str, serializable, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public void a(String str, Serializable serializable, int i2) throws Throwable {
        ?? r02 = 0;
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream2.writeObject(serializable);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        r02 = -1;
                        if (i2 != -1) {
                            a(str, byteArray, i2);
                        } else {
                            a(str, byteArray);
                        }
                        objectOutputStream2.close();
                    } catch (Exception e2) {
                        e = e2;
                        objectOutputStream = objectOutputStream2;
                        e.printStackTrace();
                        objectOutputStream.close();
                        r02 = objectOutputStream;
                    } catch (Throwable th) {
                        th = th;
                        r02 = objectOutputStream2;
                        try {
                            r02.close();
                        } catch (IOException unused) {
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused2) {
        }
    }
}

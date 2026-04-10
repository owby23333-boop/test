package com.bumptech.glide.k;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements Closeable {
    private Writer A;
    private int C;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final File f13359s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final File f13360t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final File f13361u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final File f13362v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f13363w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f13364x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f13365y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f13366z = 0;
    private final LinkedHashMap<String, d> B = new LinkedHashMap<>(0, 0.75f, true);
    private long D = 0;
    final ThreadPoolExecutor E = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable<Void> F = new CallableC0255a();

    /* JADX INFO: renamed from: com.bumptech.glide.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskLruCache.java */
    class CallableC0255a implements Callable<Void> {
        CallableC0255a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.A == null) {
                    return null;
                }
                a.this.n();
                if (a.this.j()) {
                    a.this.m();
                    a.this.C = 0;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(CallableC0255a callableC0255a) {
            this();
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class c {
        private final d a;
        private final boolean[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13368c;

        /* synthetic */ c(a aVar, d dVar, CallableC0255a callableC0255a) {
            this(dVar);
        }

        public void c() throws IOException {
            a.this.a(this, true);
            this.f13368c = true;
        }

        private c(d dVar) {
            this.a = dVar;
            this.b = dVar.f13372e ? null : new boolean[a.this.f13365y];
        }

        public File a(int i2) throws IOException {
            File fileB;
            synchronized (a.this) {
                if (this.a.f13373f != this) {
                    throw new IllegalStateException();
                }
                if (!this.a.f13372e) {
                    this.b[i2] = true;
                }
                fileB = this.a.b(i2);
                a.this.f13359s.mkdirs();
            }
            return fileB;
        }

        public void b() {
            if (this.f13368c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void a() throws IOException {
            a.this.a(this, false);
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private final class d {
        private final String a;
        private final long[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        File[] f13370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        File[] f13371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f13372e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c f13373f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f13374g;

        /* synthetic */ d(a aVar, String str, CallableC0255a callableC0255a) {
            this(str);
        }

        private d(String str) {
            this.a = str;
            this.b = new long[a.this.f13365y];
            this.f13370c = new File[a.this.f13365y];
            this.f13371d = new File[a.this.f13365y];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.f13365y; i2++) {
                sb.append(i2);
                this.f13370c[i2] = new File(a.this.f13359s, sb.toString());
                sb.append(".tmp");
                this.f13371d[i2] = new File(a.this.f13359s, sb.toString());
                sb.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.f13365y) {
                a(strArr);
                throw null;
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.b[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    a(strArr);
                    throw null;
                }
            }
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        public File b(int i2) {
            return this.f13371d[i2];
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i2) {
            return this.f13370c[i2];
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class e {
        private final File[] a;

        /* synthetic */ e(a aVar, String str, long j2, File[] fileArr, long[] jArr, CallableC0255a callableC0255a) {
            this(aVar, str, j2, fileArr, jArr);
        }

        public File a(int i2) {
            return this.a[i2];
        }

        private e(a aVar, String str, long j2, File[] fileArr, long[] jArr) {
            this.a = fileArr;
        }
    }

    private a(File file, int i2, int i3, long j2) {
        this.f13359s = file;
        this.f13363w = i2;
        this.f13360t = new File(file, "journal");
        this.f13361u = new File(file, "journal.tmp");
        this.f13362v = new File(file, "journal.bkp");
        this.f13365y = i3;
        this.f13364x = j2;
    }

    private void i() {
        if (this.A == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        int i2 = this.C;
        return i2 >= 2000 && i2 >= this.B.size();
    }

    private void k() throws IOException {
        a(this.f13361u);
        Iterator<d> it = this.B.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f13373f == null) {
                while (i2 < this.f13365y) {
                    this.f13366z += next.b[i2];
                    i2++;
                }
            } else {
                next.f13373f = null;
                while (i2 < this.f13365y) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    private void l() throws IOException {
        com.bumptech.glide.k.b bVar = new com.bumptech.glide.k.b(new FileInputStream(this.f13360t), com.bumptech.glide.k.c.a);
        try {
            String strJ = bVar.j();
            String strJ2 = bVar.j();
            String strJ3 = bVar.j();
            String strJ4 = bVar.j();
            String strJ5 = bVar.j();
            if (!"libcore.io.DiskLruCache".equals(strJ) || !"1".equals(strJ2) || !Integer.toString(this.f13363w).equals(strJ3) || !Integer.toString(this.f13365y).equals(strJ4) || !"".equals(strJ5)) {
                throw new IOException("unexpected journal header: [" + strJ + ", " + strJ2 + ", " + strJ4 + ", " + strJ5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    e(bVar.j());
                    i2++;
                } catch (EOFException unused) {
                    this.C = i2 - this.B.size();
                    if (bVar.i()) {
                        m();
                    } else {
                        this.A = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13360t, true), com.bumptech.glide.k.c.a));
                    }
                    com.bumptech.glide.k.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bumptech.glide.k.c.a(bVar);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m() throws IOException {
        if (this.A != null) {
            a(this.A);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13361u), com.bumptech.glide.k.c.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f13363w));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f13365y));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.B.values()) {
                if (dVar.f13373f != null) {
                    bufferedWriter.write("DIRTY " + dVar.a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.a + dVar.a() + '\n');
                }
            }
            a(bufferedWriter);
            if (this.f13360t.exists()) {
                a(this.f13360t, this.f13362v, true);
            }
            a(this.f13361u, this.f13360t, false);
            this.f13362v.delete();
            this.A = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13360t, true), com.bumptech.glide.k.c.a));
        } catch (Throwable th) {
            a(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() throws IOException {
        while (this.f13366z > this.f13364x) {
            d(this.B.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.A == null) {
            return;
        }
        for (d dVar : new ArrayList(this.B.values())) {
            if (dVar.f13373f != null) {
                dVar.f13373f.a();
            }
        }
        n();
        a(this.A);
        this.A = null;
    }

    public void delete() throws IOException {
        close();
        com.bumptech.glide.k.c.a(this.f13359s);
    }

    private void e(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i2 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i2);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i2);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.B.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iIndexOf2);
        }
        d dVar = this.B.get(strSubstring);
        CallableC0255a callableC0255a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0255a);
            this.B.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f13372e = true;
            dVar.f13373f = null;
            dVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f13373f = new c(this, dVar, callableC0255a);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public c b(String str) throws IOException {
        return a(str, -1L);
    }

    public synchronized e c(String str) throws IOException {
        i();
        d dVar = this.B.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f13372e) {
            return null;
        }
        for (File file : dVar.f13370c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.C++;
        this.A.append((CharSequence) "READ");
        this.A.append(' ');
        this.A.append((CharSequence) str);
        this.A.append('\n');
        if (j()) {
            this.E.submit(this.F);
        }
        return new e(this, str, dVar.f13374g, dVar.f13370c, dVar.b, null);
    }

    public synchronized boolean d(String str) throws IOException {
        i();
        d dVar = this.B.get(str);
        if (dVar != null && dVar.f13373f == null) {
            for (int i2 = 0; i2 < this.f13365y; i2++) {
                File fileA = dVar.a(i2);
                if (fileA.exists() && !fileA.delete()) {
                    throw new IOException("failed to delete " + fileA);
                }
                this.f13366z -= dVar.b[i2];
                dVar.b[i2] = 0;
            }
            this.C++;
            this.A.append((CharSequence) "REMOVE");
            this.A.append(' ');
            this.A.append((CharSequence) str);
            this.A.append('\n');
            this.B.remove(str);
            if (j()) {
                this.E.submit(this.F);
            }
            return true;
        }
        return false;
    }

    @TargetApi(26)
    private static void b(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static a a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i2, i3, j2);
            if (aVar.f13360t.exists()) {
                try {
                    aVar.l();
                    aVar.k();
                    return aVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.delete();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i2, i3, j2);
            aVar2.m();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z2) throws IOException {
        if (z2) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private synchronized c a(String str, long j2) throws IOException {
        i();
        d dVar = this.B.get(str);
        CallableC0255a callableC0255a = null;
        if (j2 != -1 && (dVar == null || dVar.f13374g != j2)) {
            return null;
        }
        if (dVar != null) {
            if (dVar.f13373f != null) {
                return null;
            }
        } else {
            dVar = new d(this, str, callableC0255a);
            this.B.put(str, dVar);
        }
        c cVar = new c(this, dVar, callableC0255a);
        dVar.f13373f = cVar;
        this.A.append((CharSequence) "DIRTY");
        this.A.append(' ');
        this.A.append((CharSequence) str);
        this.A.append('\n');
        b(this.A);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z2) throws IOException {
        d dVar = cVar.a;
        if (dVar.f13373f == cVar) {
            if (z2 && !dVar.f13372e) {
                for (int i2 = 0; i2 < this.f13365y; i2++) {
                    if (cVar.b[i2]) {
                        if (!dVar.b(i2).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f13365y; i3++) {
                File fileB = dVar.b(i3);
                if (z2) {
                    if (fileB.exists()) {
                        File fileA = dVar.a(i3);
                        fileB.renameTo(fileA);
                        long j2 = dVar.b[i3];
                        long length = fileA.length();
                        dVar.b[i3] = length;
                        this.f13366z = (this.f13366z - j2) + length;
                    }
                } else {
                    a(fileB);
                }
            }
            this.C++;
            dVar.f13373f = null;
            if (!(dVar.f13372e | z2)) {
                this.B.remove(dVar.a);
                this.A.append((CharSequence) "REMOVE");
                this.A.append(' ');
                this.A.append((CharSequence) dVar.a);
                this.A.append('\n');
            } else {
                dVar.f13372e = true;
                this.A.append((CharSequence) "CLEAN");
                this.A.append(' ');
                this.A.append((CharSequence) dVar.a);
                this.A.append((CharSequence) dVar.a());
                this.A.append('\n');
                if (z2) {
                    long j3 = this.D;
                    this.D = 1 + j3;
                    dVar.f13374g = j3;
                }
            }
            b(this.A);
            if (this.f13366z > this.f13364x || j()) {
                this.E.submit(this.F);
            }
            return;
        }
        throw new IllegalStateException();
    }

    @TargetApi(26)
    private static void a(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}

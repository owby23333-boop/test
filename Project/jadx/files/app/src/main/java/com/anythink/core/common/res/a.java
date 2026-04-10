package com.anythink.core.common.res;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Closeable {
    static final String a = "journal";
    static final String b = "journal.tmp";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f7855c = "libcore.io.DiskLruCache";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String f7856d = "1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final long f7857e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f7858f = "CLEAN";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f7859g = "DIRTY";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f7860h = "REMOVE";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f7861i = "READ";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Charset f7862j = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f7863k = 8192;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final File f7864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final File f7865m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final File f7866n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f7868p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Writer f7871s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f7873u;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f7870r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final LinkedHashMap<String, b> f7872t = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f7874v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ExecutorService f7875w = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Callable<Void> f7876x = new Callable<Void>() { // from class: com.anythink.core.common.res.a.1
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                if (a.this.f7871s == null) {
                    return null;
                }
                a.this.l();
                if (a.this.h()) {
                    a.this.d();
                    a.e(a.this);
                }
                return null;
            }
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f7867o = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f7869q = 1;

    /* JADX INFO: renamed from: com.anythink.core.common.res.a$a, reason: collision with other inner class name */
    public final class C0168a {
        private final b b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f7877c;

        /* JADX INFO: renamed from: com.anythink.core.common.res.a$a$a, reason: collision with other inner class name */
        private class C0169a extends FilterOutputStream {
            /* synthetic */ C0169a(C0168a c0168a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0168a.b(C0168a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0168a.b(C0168a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (IOException unused) {
                    C0168a.b(C0168a.this);
                }
            }

            private C0169a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i2, int i3) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    C0168a.b(C0168a.this);
                }
            }
        }

        /* synthetic */ C0168a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        static /* synthetic */ boolean b(C0168a c0168a) {
            c0168a.f7877c = true;
            return true;
        }

        private String c(int i2) {
            InputStream inputStreamB = b(i2);
            if (inputStreamB != null) {
                return a.a(inputStreamB);
            }
            return null;
        }

        private C0168a(b bVar) {
            this.b = bVar;
        }

        private InputStream b(int i2) {
            synchronized (a.this) {
                if (this.b.f7880e != this) {
                    throw new IllegalStateException();
                }
                if (!this.b.f7879d) {
                    return null;
                }
                return new FileInputStream(this.b.a(i2));
            }
        }

        public final OutputStream a(int i2) {
            C0169a c0169a;
            synchronized (a.this) {
                if (this.b.f7880e != this) {
                    throw new IllegalStateException();
                }
                c0169a = new C0169a(this, new FileOutputStream(this.b.b(i2)), (byte) 0);
            }
            return c0169a;
        }

        private void a(int i2, String str) throws Throwable {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(a(i2), a.f7862j);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                a.a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                a.a(outputStreamWriter2);
                throw th;
            }
        }

        public final void b() {
            a.this.a(this, false);
        }

        public final void a() {
            if (this.f7877c) {
                a.this.a(this, false);
                a.this.c(this.b.b);
            } else {
                a.this.a(this, true);
            }
        }
    }

    private final class b {
        private final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f7878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f7879d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private C0168a f7880e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f7881f;

        /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        private b(String str) {
            this.b = str;
            this.f7878c = new long[a.this.f7869q];
        }

        private static IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ boolean a(b bVar) {
            bVar.f7879d = true;
            return true;
        }

        public final File b(int i2) {
            return new File(a.this.f7864l, this.b + "." + i2 + ".tmp");
        }

        public final String a() {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f7878c) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        private void a(String[] strArr) throws IOException {
            if (strArr.length == a.this.f7869q) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.f7878c[i2] = Long.parseLong(strArr[i2]);
                    } catch (NumberFormatException unused) {
                        throw b(strArr);
                    }
                }
                return;
            }
            throw b(strArr);
        }

        public final File a(int i2) {
            return new File(a.this.f7864l, this.b + "." + i2);
        }

        static /* synthetic */ void a(b bVar, String[] strArr) throws IOException {
            if (strArr.length == a.this.f7869q) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        bVar.f7878c[i2] = Long.parseLong(strArr[i2]);
                    } catch (NumberFormatException unused) {
                        throw b(strArr);
                    }
                }
                return;
            }
            throw b(strArr);
        }
    }

    public final class c implements Closeable {
        private final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f7882c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final InputStream[] f7883d;

        /* synthetic */ c(a aVar, String str, long j2, InputStream[] inputStreamArr, byte b) {
            this(str, j2, inputStreamArr);
        }

        private C0168a b() {
            return a.this.a(this.b, this.f7882c);
        }

        public final InputStream a() {
            return this.f7883d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f7883d) {
                a.a((Closeable) inputStream);
            }
        }

        private c(String str, long j2, InputStream[] inputStreamArr) {
            this.b = str;
            this.f7882c = j2;
            this.f7883d = inputStreamArr;
        }

        private String a(int i2) {
            return a.a(this.f7883d[i2]);
        }
    }

    private a(File file, long j2) {
        this.f7864l = file;
        this.f7865m = new File(file, a);
        this.f7866n = new File(file, b);
        this.f7868p = j2;
    }

    static /* synthetic */ int e(a aVar) {
        aVar.f7873u = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        int i2 = this.f7873u;
        return i2 >= 2000 && i2 >= this.f7872t.size();
    }

    private boolean i() {
        return this.f7871s == null;
    }

    private void j() {
        if (this.f7871s == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private synchronized void k() {
        j();
        l();
        this.f7871s.flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        while (this.f7870r > this.f7868p) {
            c(this.f7872t.entrySet().iterator().next().getKey());
        }
    }

    private void m() throws IOException {
        close();
        a(this.f7864l);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f7871s == null) {
            return;
        }
        for (b bVar : new ArrayList(this.f7872t.values())) {
            if (bVar.f7880e != null) {
                bVar.f7880e.b();
            }
        }
        l();
        this.f7871s.close();
        this.f7871s = null;
    }

    private static String b(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int i2 = inputStream.read();
            if (i2 == -1) {
                throw new EOFException();
            }
            if (i2 == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i3 = length - 1;
                    if (sb.charAt(i3) == '\r') {
                        sb.setLength(i3);
                    }
                }
                return sb.toString();
            }
            sb.append((char) i2);
        }
    }

    private void c() throws IOException {
        b(this.f7866n);
        Iterator<b> it = this.f7872t.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i2 = 0;
            if (next.f7880e == null) {
                while (i2 < this.f7869q) {
                    this.f7870r += next.f7878c[i2];
                    i2++;
                }
            } else {
                next.f7880e = null;
                while (i2 < this.f7869q) {
                    b(next.a(i2));
                    b(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    private void d(String str) throws IOException {
        String[] strArrSplit = str.split(" ");
        if (strArrSplit.length < 2) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
        String str2 = strArrSplit[1];
        byte b2 = 0;
        if (strArrSplit[0].equals(f7860h) && strArrSplit.length == 2) {
            this.f7872t.remove(str2);
            return;
        }
        b bVar = this.f7872t.get(str2);
        if (bVar == null) {
            bVar = new b(this, str2, b2);
            this.f7872t.put(str2, bVar);
        }
        if (!strArrSplit[0].equals(f7858f) || strArrSplit.length != this.f7869q + 2) {
            if (strArrSplit[0].equals(f7859g) && strArrSplit.length == 2) {
                bVar.f7880e = new C0168a(this, bVar, b2);
                return;
            } else {
                if (!strArrSplit[0].equals(f7861i) || strArrSplit.length != 2) {
                    throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
                }
                return;
            }
        }
        b.a(bVar);
        bVar.f7880e = null;
        int length = strArrSplit.length;
        int length2 = strArrSplit.length;
        if (2 > length) {
            throw new IllegalArgumentException();
        }
        if (2 > length2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = length - 2;
        int iMin = Math.min(i2, length2 - 2);
        Object[] objArr = (Object[]) Array.newInstance(strArrSplit.getClass().getComponentType(), i2);
        System.arraycopy(strArrSplit, 2, objArr, 0, iMin);
        b.a(bVar, (String[]) objArr);
    }

    private File e() {
        return this.f7864l;
    }

    private long f() {
        return this.f7868p;
    }

    private synchronized long g() {
        return this.f7870r;
    }

    private static void e(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    private static <T> T[] a(T[] tArr, int i2) {
        int length = tArr.length;
        if (2 > i2) {
            throw new IllegalArgumentException();
        }
        if (2 <= length) {
            int i3 = i2 - 2;
            int iMin = Math.min(i3, length - 2);
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
            System.arraycopy(tArr, 2, tArr2, 0, iMin);
            return tArr2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private void b() {
        String strB;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.f7865m), 8192);
        try {
            String strB2 = b(bufferedInputStream);
            String strB3 = b(bufferedInputStream);
            String strB4 = b(bufferedInputStream);
            String strB5 = b(bufferedInputStream);
            String strB6 = b(bufferedInputStream);
            if (f7855c.equals(strB2) && "1".equals(strB3) && Integer.toString(this.f7867o).equals(strB4) && Integer.toString(this.f7869q).equals(strB5) && "".equals(strB6)) {
                while (true) {
                    try {
                        strB = b(bufferedInputStream);
                        String[] strArrSplit = strB.split(" ");
                        if (strArrSplit.length >= 2) {
                            String str = strArrSplit[1];
                            byte b2 = 0;
                            if (strArrSplit[0].equals(f7860h) && strArrSplit.length == 2) {
                                this.f7872t.remove(str);
                            } else {
                                b bVar = this.f7872t.get(str);
                                if (bVar == null) {
                                    bVar = new b(this, str, b2);
                                    this.f7872t.put(str, bVar);
                                }
                                if (strArrSplit[0].equals(f7858f) && strArrSplit.length == this.f7869q + 2) {
                                    b.a(bVar);
                                    bVar.f7880e = null;
                                    int length = strArrSplit.length;
                                    int length2 = strArrSplit.length;
                                    if (2 > length) {
                                        throw new IllegalArgumentException();
                                    }
                                    if (2 <= length2) {
                                        int i2 = length - 2;
                                        int iMin = Math.min(i2, length2 - 2);
                                        Object[] objArr = (Object[]) Array.newInstance(strArrSplit.getClass().getComponentType(), i2);
                                        System.arraycopy(strArrSplit, 2, objArr, 0, iMin);
                                        b.a(bVar, (String[]) objArr);
                                    } else {
                                        throw new ArrayIndexOutOfBoundsException();
                                    }
                                } else if (strArrSplit[0].equals(f7859g) && strArrSplit.length == 2) {
                                    bVar.f7880e = new C0168a(this, bVar, b2);
                                } else if (!strArrSplit[0].equals(f7861i) || strArrSplit.length != 2) {
                                    break;
                                }
                            }
                        } else {
                            throw new IOException("unexpected journal line: ".concat(String.valueOf(strB)));
                        }
                    } catch (EOFException unused) {
                        return;
                    }
                }
                throw new IOException("unexpected journal line: ".concat(String.valueOf(strB)));
            }
            throw new IOException("unexpected journal header: [" + strB2 + ", " + strB3 + ", " + strB5 + ", " + strB6 + "]");
        } finally {
            a((Closeable) bufferedInputStream);
        }
    }

    private static String a(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int i2 = reader.read(cArr);
                if (i2 != -1) {
                    stringWriter.write(cArr, 0, i2);
                } else {
                    return stringWriter.toString();
                }
            }
        } finally {
            reader.close();
        }
    }

    public final synchronized boolean c(String str) {
        j();
        e(str);
        b bVar = this.f7872t.get(str);
        if (bVar != null && bVar.f7880e == null) {
            for (int i2 = 0; i2 < this.f7869q; i2++) {
                File fileA = bVar.a(i2);
                if (fileA.delete()) {
                    this.f7870r -= bVar.f7878c[i2];
                    bVar.f7878c[i2] = 0;
                } else {
                    throw new IOException("failed to delete ".concat(String.valueOf(fileA)));
                }
            }
            this.f7873u++;
            this.f7871s.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f7872t.remove(str);
            if (h()) {
                this.f7875w.submit(this.f7876x);
            }
            return true;
        }
        return false;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static void a(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IllegalArgumentException("not a directory: ".concat(String.valueOf(file)));
    }

    public static a a(File file, long j2) throws IOException {
        if (j2 > 0) {
            a aVar = new a(file, j2);
            if (aVar.f7865m.exists()) {
                try {
                    aVar.b();
                    aVar.c();
                    aVar.f7871s = new BufferedWriter(new FileWriter(aVar.f7865m, true), 8192);
                    return aVar;
                } catch (IOException unused) {
                    aVar.close();
                    a(aVar.f7864l);
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, j2);
            aVar2.d();
            return aVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (this.f7871s != null) {
            this.f7871s.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.f7866n), 8192);
        bufferedWriter.write(f7855c);
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f7867o));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f7869q));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (b bVar : this.f7872t.values()) {
            if (bVar.f7880e != null) {
                bufferedWriter.write("DIRTY " + bVar.b + '\n');
            } else {
                bufferedWriter.write("CLEAN " + bVar.b + bVar.a() + '\n');
            }
        }
        bufferedWriter.close();
        this.f7866n.renameTo(this.f7865m);
        this.f7871s = new BufferedWriter(new FileWriter(this.f7865m, true), 8192);
    }

    private static String c(InputStream inputStream) {
        return a((Reader) new InputStreamReader(inputStream, f7862j));
    }

    public final synchronized c a(String str) {
        j();
        e(str);
        b bVar = this.f7872t.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.f7879d) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f7869q];
        for (int i2 = 0; i2 < this.f7869q; i2++) {
            try {
                inputStreamArr[i2] = new FileInputStream(bVar.a(i2));
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        this.f7873u++;
        this.f7871s.append((CharSequence) ("READ " + str + '\n'));
        if (h()) {
            this.f7875w.submit(this.f7876x);
        }
        this.f7871s.flush();
        return new c(this, str, bVar.f7881f, inputStreamArr, (byte) 0);
    }

    private static void b(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final C0168a b(String str) {
        return a(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized C0168a a(String str, long j2) {
        j();
        e(str);
        b bVar = this.f7872t.get(str);
        if (j2 != -1 && (bVar == null || bVar.f7881f != j2)) {
            return null;
        }
        byte b2 = 0;
        if (bVar != null) {
            if (bVar.f7880e != null) {
                return null;
            }
        } else {
            bVar = new b(this, str, b2);
            this.f7872t.put(str, bVar);
        }
        C0168a c0168a = new C0168a(this, bVar, b2);
        bVar.f7880e = c0168a;
        this.f7871s.write("DIRTY " + str + '\n');
        this.f7871s.flush();
        return c0168a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0168a c0168a, boolean z2) {
        b bVar = c0168a.b;
        if (bVar.f7880e == c0168a) {
            if (z2 && !bVar.f7879d) {
                for (int i2 = 0; i2 < this.f7869q; i2++) {
                    if (!bVar.b(i2).exists()) {
                        c0168a.b();
                        throw new IllegalStateException("edit didn't create file ".concat(String.valueOf(i2)));
                    }
                }
            }
            for (int i3 = 0; i3 < this.f7869q; i3++) {
                File fileB = bVar.b(i3);
                if (z2) {
                    if (fileB.exists()) {
                        File fileA = bVar.a(i3);
                        fileB.renameTo(fileA);
                        long j2 = bVar.f7878c[i3];
                        long length = fileA.length();
                        bVar.f7878c[i3] = length;
                        this.f7870r = (this.f7870r - j2) + length;
                    }
                } else {
                    b(fileB);
                }
            }
            this.f7873u++;
            bVar.f7880e = null;
            if (!(bVar.f7879d | z2)) {
                this.f7872t.remove(bVar.b);
                this.f7871s.write("REMOVE " + bVar.b + '\n');
            } else {
                b.a(bVar);
                this.f7871s.write("CLEAN " + bVar.b + bVar.a() + '\n');
                if (z2) {
                    long j3 = this.f7874v;
                    this.f7874v = 1 + j3;
                    bVar.f7881f = j3;
                }
            }
            this.f7871s.flush();
            if (this.f7870r > this.f7868p || h()) {
                this.f7875w.submit(this.f7876x);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    static /* synthetic */ String a(InputStream inputStream) {
        return a((Reader) new InputStreamReader(inputStream, f7862j));
    }
}

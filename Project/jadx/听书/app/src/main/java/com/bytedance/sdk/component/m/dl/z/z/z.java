package com.bytedance.sdk.component.m.dl.z.z;

import com.bytedance.sdk.component.utils.wp;
import com.funny.audio.core.utils.FileUtils;
import com.kuaishou.weapon.p0.bi;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f772a;
    private final File e;
    private long fo;
    final ExecutorService g;
    private final File gc;
    private final int gz;
    private final File m;
    private final int uy;
    private int v;
    private Writer wp;
    static final Pattern z = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream dl = new OutputStream() { // from class: com.bytedance.sdk.component.m.dl.z.z.z.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private long kb = 0;
    private final LinkedHashMap<String, g> i = new LinkedHashMap<>(0, 0.75f, true);
    private long pf = -1;
    private long ls = 0;
    private final Callable<Void> p = new Callable<Void>() { // from class: com.bytedance.sdk.component.m.dl.z.z.z.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (z.this) {
                if (z.this.wp == null) {
                    return null;
                }
                z.this.e();
                if (z.this.gc()) {
                    z.this.a();
                    z.this.v = 0;
                }
                return null;
            }
        }
    };

    private z(File file, int i, int i2, long j, ExecutorService executorService) {
        this.f772a = file;
        this.gz = i;
        this.gc = new File(file, "journal");
        this.m = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.uy = i2;
        this.fo = j;
        this.g = executorService;
    }

    public static z z(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                z(file2, file3, false);
            }
        }
        z zVar = new z(file, i, i2, j, executorService);
        if (zVar.gc.exists()) {
            try {
                zVar.g();
                zVar.dl();
                return zVar;
            } catch (IOException e) {
                wp.g("DiskLruCache ", file + " is corrupt: " + e.getMessage() + ", removing");
                zVar.delete();
            }
        }
        file.mkdirs();
        z zVar2 = new z(file, i, i2, j, executorService);
        zVar2.a();
        return zVar2;
    }

    private void g() throws IOException {
        com.bytedance.sdk.component.m.dl.z.z.dl dlVar = new com.bytedance.sdk.component.m.dl.z.z.dl(new FileInputStream(this.gc), a.z);
        try {
            String strZ = dlVar.z();
            String strZ2 = dlVar.z();
            String strZ3 = dlVar.z();
            String strZ4 = dlVar.z();
            String strZ5 = dlVar.z();
            if (!"libcore.io.DiskLruCache".equals(strZ) || !"1".equals(strZ2) || !Integer.toString(this.gz).equals(strZ3) || !Integer.toString(this.uy).equals(strZ4) || !"".equals(strZ5)) {
                throw new IOException("unexpected journal header: [" + strZ + ", " + strZ2 + ", " + strZ4 + ", " + strZ5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    a(dlVar.z());
                    i++;
                } catch (EOFException unused) {
                    this.v = i - this.i.size();
                    if (dlVar.g()) {
                        a();
                    } else {
                        this.wp = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.gc, true), a.z));
                    }
                    com.bytedance.sdk.component.m.dl.dl.g.z(dlVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.m.dl.dl.g.z(dlVar);
            throw th;
        }
    }

    private void a(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.i.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        g gVar = this.i.get(strSubstring);
        if (gVar == null) {
            gVar = new g(strSubstring);
            this.i.put(strSubstring, gVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            gVar.f774a = true;
            gVar.gc = null;
            gVar.z(strArrSplit);
            return;
        }
        if (iIndexOf2 != -1 || iIndexOf != 5 || !str.startsWith("DIRTY")) {
            if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
            }
            return;
        }
        gVar.gc = new C0139z(gVar);
    }

    private void dl() throws IOException {
        z(this.m);
        Iterator<g> it = this.i.values().iterator();
        while (it.hasNext()) {
            g next = it.next();
            int i = 0;
            if (next.gc == null) {
                while (i < this.uy) {
                    this.kb += next.dl[i];
                    i++;
                }
            } else {
                next.gc = null;
                while (i < this.uy) {
                    z(next.z(i));
                    z(next.g(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() throws IOException {
        Writer writer = this.wp;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.m), a.z));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.gz));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.uy));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (g gVar : this.i.values()) {
                if (gVar.gc != null) {
                    bufferedWriter.write("DIRTY " + gVar.g + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + gVar.g + gVar.z() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.gc.exists()) {
                z(this.gc, this.e, true);
            }
            z(this.m, this.gc, false);
            this.e.delete();
            this.wp = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.gc, true), a.z));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void z(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void z(File file, File file2, boolean z2) throws IOException {
        if (z2) {
            z(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized dl z(String str) throws IOException {
        InputStream inputStream;
        m();
        gc(str);
        g gVar = this.i.get(str);
        if (gVar == null) {
            return null;
        }
        if (!gVar.f774a) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.uy];
        for (int i = 0; i < this.uy; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(gVar.z(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.uy && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    com.bytedance.sdk.component.m.dl.dl.g.z(inputStream);
                }
                return null;
            }
        }
        this.v++;
        this.wp.append((CharSequence) ("READ " + str + '\n'));
        if (gc()) {
            this.g.submit(this.p);
        }
        return new dl(str, gVar.m, inputStreamArr, gVar.dl);
    }

    public C0139z g(String str) throws IOException {
        return z(str, -1L);
    }

    private synchronized C0139z z(String str, long j) throws IOException {
        m();
        gc(str);
        g gVar = this.i.get(str);
        if (j != -1 && (gVar == null || gVar.m != j)) {
            return null;
        }
        if (gVar == null) {
            gVar = new g(str);
            this.i.put(str, gVar);
        } else if (gVar.gc != null) {
            return null;
        }
        C0139z c0139z = new C0139z(gVar);
        gVar.gc = c0139z;
        this.wp.write("DIRTY " + str + '\n');
        this.wp.flush();
        return c0139z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z(C0139z c0139z, boolean z2) throws IOException {
        g gVar = c0139z.g;
        if (gVar.gc != c0139z) {
            throw new IllegalStateException();
        }
        if (z2 && !gVar.f774a) {
            for (int i = 0; i < this.uy; i++) {
                if (!c0139z.dl[i]) {
                    c0139z.g();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!gVar.g(i).exists()) {
                    c0139z.g();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.uy; i2++) {
            File fileG = gVar.g(i2);
            if (z2) {
                if (fileG.exists()) {
                    File fileZ = gVar.z(i2);
                    fileG.renameTo(fileZ);
                    long j = gVar.dl[i2];
                    long length = fileZ.length();
                    gVar.dl[i2] = length;
                    this.kb = (this.kb - j) + length;
                }
            } else {
                z(fileG);
            }
        }
        this.v++;
        gVar.gc = null;
        if (gVar.f774a | z2) {
            gVar.f774a = true;
            this.wp.write("CLEAN " + gVar.g + gVar.z() + '\n');
            if (z2) {
                long j2 = this.ls;
                this.ls = 1 + j2;
                gVar.m = j2;
            }
        } else {
            this.i.remove(gVar.g);
            this.wp.write("REMOVE " + gVar.g + '\n');
        }
        this.wp.flush();
        if (this.kb > this.fo || gc()) {
            this.g.submit(this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gc() {
        int i = this.v;
        return i >= 2000 && i >= this.i.size();
    }

    public synchronized boolean dl(String str) throws IOException {
        m();
        gc(str);
        g gVar = this.i.get(str);
        if (gVar != null && gVar.gc == null) {
            for (int i = 0; i < this.uy; i++) {
                File fileZ = gVar.z(i);
                if (fileZ.exists() && !fileZ.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(fileZ)));
                }
                this.kb -= gVar.dl[i];
                gVar.dl[i] = 0;
            }
            this.v++;
            this.wp.append((CharSequence) ("REMOVE " + str + '\n'));
            this.i.remove(str);
            if (gc()) {
                this.g.submit(this.p);
            }
            return true;
        }
        return false;
    }

    private void m() {
        if (this.wp == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void z() throws IOException {
        m();
        e();
        this.wp.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.wp == null) {
            return;
        }
        for (g gVar : new ArrayList(this.i.values())) {
            if (gVar.gc != null) {
                gVar.gc.g();
            }
        }
        e();
        this.wp.close();
        this.wp = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() throws IOException {
        long j = this.fo;
        long j2 = this.pf;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.kb > j) {
            dl(this.i.entrySet().iterator().next().getKey());
        }
        this.pf = -1L;
    }

    public void z(long j) {
        this.pf = j;
        this.g.submit(this.p);
    }

    public void delete() throws IOException {
        close();
        a.z(this.f772a);
    }

    private void gc(String str) {
        if (!z.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final class dl implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream[] f773a;
        private final long dl;
        private final String g;
        private final long[] gc;

        private dl(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.g = str;
            this.dl = j;
            this.f773a = inputStreamArr;
            this.gc = jArr;
        }

        public InputStream z(int i) {
            return this.f773a[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f773a) {
                com.bytedance.sdk.component.m.dl.dl.g.z(inputStream);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.m.dl.z.z.z$z, reason: collision with other inner class name */
    public final class C0139z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f775a;
        private final boolean[] dl;
        private final g g;
        private boolean gc;

        private C0139z(g gVar) {
            this.g = gVar;
            this.dl = gVar.f774a ? null : new boolean[z.this.uy];
        }

        public OutputStream z(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0140z c0140z;
            if (i < 0 || i >= z.this.uy) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + z.this.uy);
            }
            synchronized (z.this) {
                if (this.g.gc != this) {
                    throw new IllegalStateException();
                }
                if (!this.g.f774a) {
                    this.dl[i] = true;
                }
                File fileG = this.g.g(i);
                try {
                    fileOutputStream = new FileOutputStream(fileG);
                } catch (FileNotFoundException unused) {
                    z.this.f772a.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileG);
                    } catch (FileNotFoundException unused2) {
                        return z.dl;
                    }
                }
                c0140z = new C0140z(fileOutputStream);
            }
            return c0140z;
        }

        public void z() throws IOException {
            if (this.f775a) {
                z.this.z(this, false);
                z.this.dl(this.g.g);
            } else {
                z.this.z(this, true);
            }
            this.gc = true;
        }

        public void g() throws IOException {
            z.this.z(this, false);
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.component.m.dl.z.z.z$z$z, reason: collision with other inner class name */
        private class C0140z extends FilterOutputStream {
            private C0140z(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    C0139z.this.f775a = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0139z.this.f775a = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C0139z.this.f775a = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C0139z.this.f775a = true;
                }
            }
        }
    }

    private final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f774a;
        private final long[] dl;
        private final String g;
        private C0139z gc;
        private long m;

        private g(String str) {
            this.g = str;
            this.dl = new long[z.this.uy];
        }

        public String z() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.dl) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(String[] strArr) throws IOException {
            if (strArr.length != z.this.uy) {
                throw g(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.dl[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw g(strArr);
                }
            }
        }

        private IOException g(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File z(int i) {
            return new File(z.this.f772a, this.g + FileUtils.FILE_EXTENSION_SEPARATOR + i);
        }

        public File g(int i) {
            return new File(z.this.f772a, this.g + FileUtils.FILE_EXTENSION_SEPARATOR + i + bi.k);
        }
    }
}

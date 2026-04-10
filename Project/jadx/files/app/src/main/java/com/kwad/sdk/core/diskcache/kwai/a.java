package com.kwad.sdk.core.diskcache.kwai;

import com.kwad.sdk.utils.p;
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
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Closeable {
    static final Pattern adT = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream aei = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.kwai.a.3
        @Override // java.io.OutputStream
        public final void write(int i2) {
        }
    };
    private final File adU;
    private final File adV;
    private final File adW;
    private final File adX;
    private final int adY;
    private int adZ;
    private final int aea;
    private Writer aec;
    private int aee;
    private long maxSize;
    private long size = 0;
    private int aeb = 0;
    private final LinkedHashMap<String, b> aed = new LinkedHashMap<>(0, 0.75f, true);
    private long aef = 0;
    final ThreadPoolExecutor aeg = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.kwai.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> aeh = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.kwai.a.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: vu, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                if (a.this.aec == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.vA();
                if (a.this.vz()) {
                    a.this.vx();
                    a.a(a.this, 0);
                }
                return null;
            }
        }
    };

    /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.kwai.a$a, reason: collision with other inner class name */
    public final class C0435a {
        private final b aek;
        private final boolean[] ael;
        private boolean aem;
        private boolean aen;

        /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.kwai.a$a$a, reason: collision with other inner class name */
        class C0436a extends FilterOutputStream {
            private C0436a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C0436a(C0435a c0435a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0435a.b(C0435a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0435a.b(C0435a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (IOException unused) {
                    C0435a.b(C0435a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i2, int i3) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    C0435a.b(C0435a.this, true);
                }
            }
        }

        private C0435a(b bVar) {
            this.aek = bVar;
            this.ael = bVar.aeq ? null : new boolean[a.this.aea];
        }

        /* synthetic */ C0435a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        static /* synthetic */ boolean b(C0435a c0435a, boolean z2) {
            c0435a.aem = true;
            return true;
        }

        public final OutputStream aS(int i2) {
            FileOutputStream fileOutputStream;
            C0436a c0436a;
            synchronized (a.this) {
                if (this.aek.aer != this) {
                    throw new IllegalStateException();
                }
                byte b = 0;
                if (!this.aek.aeq) {
                    this.ael[0] = true;
                }
                File fileAU = this.aek.aU(0);
                try {
                    fileOutputStream = new FileOutputStream(fileAU);
                } catch (FileNotFoundException unused) {
                    a.this.adU.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileAU);
                    } catch (FileNotFoundException unused2) {
                        return a.aei;
                    }
                }
                c0436a = new C0436a(this, fileOutputStream, b);
            }
            return c0436a;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final void commit() {
            if (this.aem) {
                a.this.a(this, false);
                a.this.remove(this.aek.key);
            } else {
                a.this.a(this, true);
            }
            this.aen = true;
        }
    }

    final class b {
        private final long[] aep;
        private boolean aeq;
        private C0435a aer;
        private long aes;
        private final String key;

        private b(String str) {
            this.key = str;
            this.aep = new long[a.this.aea];
        }

        /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        static /* synthetic */ boolean a(b bVar, boolean z2) {
            bVar.aeq = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.aea) {
                throw c(strArr);
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.aep[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    throw c(strArr);
                }
            }
        }

        private static IOException c(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File aT(int i2) {
            return new File(a.this.adU, this.key + i2);
        }

        public final File aU(int i2) {
            return new File(a.this.adU, this.key + i2 + ".tmp");
        }

        public final String vC() {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.aep) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }
    }

    public final class c implements Closeable {
        private final long[] aep;
        private final long aes;
        private File[] aet;
        private final InputStream[] aeu;
        private final String key;

        private c(String str, long j2, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aes = j2;
            this.aet = fileArr;
            this.aeu = inputStreamArr;
            this.aep = jArr;
        }

        /* synthetic */ c(a aVar, String str, long j2, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j2, fileArr, inputStreamArr, jArr);
        }

        public final File aV(int i2) {
            return this.aet[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.aeu) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }
    }

    private a(File file, int i2, int i3, long j2, int i4) {
        this.adU = file;
        this.adY = i2;
        this.adV = new File(file, "journal");
        this.adW = new File(file, "journal.tmp");
        this.adX = new File(file, "journal.bkp");
        this.aea = i3;
        this.maxSize = j2;
        this.adZ = i4;
    }

    static /* synthetic */ int a(a aVar, int i2) {
        aVar.aee = 0;
        return 0;
    }

    public static a a(File file, int i2, int i3, long j2) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i2, int i3, long j2, int i4) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, i2, i3, j2, i4);
        if (aVar.adV.exists()) {
            try {
                aVar.vv();
                aVar.vw();
                aVar.aec = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.adV, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                return aVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                aVar.delete();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i2, i3, j2, i4);
        aVar2.vx();
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0435a c0435a, boolean z2) {
        b bVar = c0435a.aek;
        if (bVar.aer != c0435a) {
            throw new IllegalStateException();
        }
        if (z2 && !bVar.aeq) {
            for (int i2 = 0; i2 < this.aea; i2++) {
                if (!c0435a.ael[i2]) {
                    c0435a.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                }
                if (!bVar.aU(i2).exists()) {
                    c0435a.abort();
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < this.aea; i3++) {
            File fileAU = bVar.aU(i3);
            if (!z2) {
                k(fileAU);
            } else if (fileAU.exists()) {
                File fileAT = bVar.aT(i3);
                fileAU.renameTo(fileAT);
                long j2 = bVar.aep[i3];
                long length = fileAT.length();
                bVar.aep[i3] = length;
                this.size = (this.size - j2) + length;
                this.aeb++;
            }
        }
        this.aee++;
        bVar.aer = null;
        if (bVar.aeq || z2) {
            b.a(bVar, true);
            this.aec.write("CLEAN " + bVar.key + bVar.vC() + '\n');
            if (z2) {
                long j3 = this.aef;
                this.aef = 1 + j3;
                bVar.aes = j3;
            }
        } else {
            this.aed.remove(bVar.key);
            this.aec.write("REMOVE " + bVar.key + '\n');
        }
        this.aec.flush();
        if (this.size > this.maxSize || this.aeb > this.adZ || vz()) {
            this.aeg.submit(this.aeh);
        }
    }

    private static void a(File file, File file2, boolean z2) throws IOException {
        if (z2) {
            k(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void bp(String str) throws IOException {
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
                this.aed.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iIndexOf2);
        }
        b bVar = this.aed.get(strSubstring);
        byte b2 = 0;
        if (bVar == null) {
            bVar = new b(this, strSubstring, b2);
            this.aed.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            b.a(bVar, true);
            bVar.aer = null;
            bVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            bVar.aer = new C0435a(this, bVar, b2);
        } else {
            if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private static void bs(String str) {
        if (adT.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private void checkNotClosed() {
        if (this.aec == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private synchronized C0435a e(String str, long j2) {
        checkNotClosed();
        bs(str);
        b bVar = this.aed.get(str);
        byte b2 = 0;
        if (bVar == null) {
            bVar = new b(this, str, b2);
            this.aed.put(str, bVar);
        } else if (bVar.aer != null) {
            return null;
        }
        C0435a c0435a = new C0435a(this, bVar, b2);
        bVar.aer = c0435a;
        this.aec.write("DIRTY " + str + '\n');
        this.aec.flush();
        return c0435a;
    }

    private static void k(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.aed.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vA() {
        while (this.aeb > this.adZ) {
            remove(this.aed.entrySet().iterator().next().getKey());
        }
    }

    private void vv() {
        com.kwad.sdk.core.diskcache.kwai.b bVar = new com.kwad.sdk.core.diskcache.kwai.b(new FileInputStream(this.adV), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String line = bVar.readLine();
            String line2 = bVar.readLine();
            String line3 = bVar.readLine();
            String line4 = bVar.readLine();
            String line5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(line) || !"1".equals(line2) || !Integer.toString(this.adY).equals(line3) || !Integer.toString(this.aea).equals(line4) || !"".equals(line5)) {
                throw new IOException("unexpected journal header: [" + line + ", " + line2 + ", " + line4 + ", " + line5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    bp(bVar.readLine());
                    i2++;
                } catch (EOFException unused) {
                    this.aee = i2 - this.aed.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void vw() throws IOException {
        k(this.adW);
        Iterator<b> it = this.aed.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i2 = 0;
            if (next.aer == null) {
                while (i2 < this.aea) {
                    this.size += next.aep[i2];
                    this.aeb++;
                    i2++;
                }
            } else {
                next.aer = null;
                while (i2 < this.aea) {
                    k(next.aT(i2));
                    k(next.aU(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void vx() {
        if (this.aec != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(this.aec);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.adW), com.kwad.sdk.crash.utils.a.US_ASCII));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.adY));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.aea));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.aed.values()) {
                bufferedWriter.write(bVar.aer != null ? "DIRTY " + bVar.key + '\n' : "CLEAN " + bVar.key + bVar.vC() + '\n');
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            if (this.adV.exists()) {
                a(this.adV, this.adX, true);
            }
            a(this.adW, this.adV, false);
            this.adX.delete();
            this.aec = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.adV, true), com.kwad.sdk.crash.utils.a.US_ASCII));
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vz() {
        int i2 = this.aee;
        return i2 >= 2000 && i2 >= this.aed.size();
    }

    public final synchronized c bq(String str) {
        checkNotClosed();
        bs(str);
        b bVar = this.aed.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.aeq) {
            return null;
        }
        File[] fileArr = new File[this.aea];
        InputStream[] inputStreamArr = new InputStream[this.aea];
        for (int i2 = 0; i2 < this.aea; i2++) {
            try {
                File fileAT = bVar.aT(i2);
                fileArr[i2] = fileAT;
                inputStreamArr[i2] = new FileInputStream(fileAT);
            } catch (FileNotFoundException unused) {
                for (int i3 = 0; i3 < this.aea && inputStreamArr[i3] != null; i3++) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamArr[i3]);
                }
                return null;
            }
        }
        this.aee++;
        this.aec.append((CharSequence) ("READ " + str + '\n'));
        if (vz()) {
            this.aeg.submit(this.aeh);
        }
        return new c(this, str, bVar.aes, fileArr, inputStreamArr, bVar.aep, (byte) 0);
    }

    public final C0435a br(String str) {
        return e(str, -1L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.aec == null) {
            return;
        }
        for (b bVar : new ArrayList(this.aed.values())) {
            if (bVar.aer != null) {
                bVar.aer.abort();
            }
        }
        trimToSize();
        vA();
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aec);
        this.aec = null;
    }

    public final void delete() {
        close();
        p.deleteContents(this.adU);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        vA();
        this.aec.flush();
    }

    public final File getDirectory() {
        return this.adU;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean remove(String str) {
        checkNotClosed();
        bs(str);
        b bVar = this.aed.get(str);
        if (bVar != null && bVar.aer == null) {
            for (int i2 = 0; i2 < this.aea; i2++) {
                File fileAT = bVar.aT(i2);
                if (fileAT.exists() && !fileAT.delete()) {
                    throw new IOException("failed to delete " + fileAT);
                }
                this.size -= bVar.aep[i2];
                this.aeb--;
                bVar.aep[i2] = 0;
            }
            this.aee++;
            this.aec.append((CharSequence) ("REMOVE " + str + '\n'));
            this.aed.remove(str);
            if (vz()) {
                this.aeg.submit(this.aeh);
            }
            return true;
        }
        return false;
    }

    public final synchronized int vy() {
        return this.adZ;
    }
}

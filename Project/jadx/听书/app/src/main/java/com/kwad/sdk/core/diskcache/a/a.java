package com.kwad.sdk.core.diskcache.a;

import com.kuaishou.weapon.p0.bi;
import com.kwad.sdk.utils.w;
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

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Closeable {
    static final Pattern aCC = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream aCR = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i) {
        }
    };
    private final File aCD;
    private final File aCE;
    private final File aCF;
    private final File aCG;
    private final int aCH;
    private int aCI;
    private final int aCJ;
    private Writer aCL;
    private int aCN;
    private long maxSize;
    private long size = 0;
    private int aCK = 0;
    private final LinkedHashMap<String, b> aCM = new LinkedHashMap<>(0, 0.75f, true);
    private long aCO = 0;
    final ThreadPoolExecutor aCP = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> aCQ = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: GF, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                if (a.this.aCL == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.GL();
                if (a.this.GK()) {
                    a.this.GI();
                    a.a(a.this, 0);
                }
                return null;
            }
        }
    };

    static /* synthetic */ int a(a aVar, int i) {
        aVar.aCN = 0;
        return 0;
    }

    private a(File file, int i, int i2, long j, int i3) {
        this.aCD = file;
        this.aCH = i;
        this.aCE = new File(file, "journal");
        this.aCF = new File(file, "journal.tmp");
        this.aCG = new File(file, "journal.bkp");
        this.aCJ = i2;
        this.maxSize = j;
        this.aCI = i3;
    }

    public static a a(File file, int i, int i2, long j) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i, int i2, long j, int i3) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
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
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, i, i2, j, i3);
        if (aVar.aCE.exists()) {
            try {
                aVar.GG();
                aVar.GH();
                aVar.aCL = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.aCE, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                return aVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                aVar.delete();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j, i3);
        aVar2.GI();
        return aVar2;
    }

    private void GG() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.aCE), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String line = bVar.readLine();
            String line2 = bVar.readLine();
            String line3 = bVar.readLine();
            String line4 = bVar.readLine();
            String line5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(line) || !"1".equals(line2) || !Integer.toString(this.aCH).equals(line3) || !Integer.toString(this.aCJ).equals(line4) || !"".equals(line5)) {
                throw new IOException("unexpected journal header: [" + line + ", " + line2 + ", " + line4 + ", " + line5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    dC(bVar.readLine());
                    i++;
                } catch (EOFException unused) {
                    this.aCN = i - this.aCM.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void dC(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.aCM.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.aCM.get(strSubstring);
        byte b2 = 0;
        if (bVar == null) {
            bVar = new b(this, strSubstring, b2);
            this.aCM.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            b.a(bVar, true);
            bVar.aDa = null;
            bVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 != -1 || iIndexOf != 5 || !str.startsWith("DIRTY")) {
            if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
            return;
        }
        bVar.aDa = new C0395a(this, bVar, b2);
    }

    private void GH() throws IOException {
        p(this.aCF);
        Iterator<b> it = this.aCM.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.aDa == null) {
                while (i < this.aCJ) {
                    this.size += next.aCY[i];
                    this.aCK++;
                    i++;
                }
            } else {
                next.aDa = null;
                while (i < this.aCJ) {
                    p(next.dt(i));
                    p(next.du(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void GI() {
        Writer writer = this.aCL;
        if (writer != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aCF), com.kwad.sdk.crash.utils.a.US_ASCII));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.aCH));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.aCJ));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.aCM.values()) {
                if (bVar.aDa != null) {
                    bufferedWriter.write("DIRTY " + bVar.key + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + bVar.key + bVar.GN() + '\n');
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            if (this.aCE.exists()) {
                a(this.aCE, this.aCG, true);
            }
            a(this.aCF, this.aCE, false);
            this.aCG.delete();
            this.aCL = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aCE, true), com.kwad.sdk.crash.utils.a.US_ASCII));
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            throw th;
        }
    }

    private static void p(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized c dD(String str) {
        InputStream inputStream;
        if (this.aCL == null) {
            return null;
        }
        dF(str);
        b bVar = this.aCM.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.aCZ) {
            return null;
        }
        int i = this.aCJ;
        File[] fileArr = new File[i];
        InputStream[] inputStreamArr = new InputStream[i];
        for (int i2 = 0; i2 < this.aCJ; i2++) {
            try {
                File fileDt = bVar.dt(i2);
                fileArr[i2] = fileDt;
                inputStreamArr[i2] = new FileInputStream(fileDt);
            } catch (FileNotFoundException unused) {
                for (int i3 = 0; i3 < this.aCJ && (inputStream = inputStreamArr[i3]) != null; i3++) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                }
                return null;
            }
        }
        this.aCN++;
        this.aCL.append((CharSequence) ("READ " + str + '\n'));
        if (GK()) {
            this.aCP.submit(this.aCQ);
        }
        return new c(this, str, bVar.aDb, fileArr, inputStreamArr, bVar.aCY, (byte) 0);
    }

    public final C0395a dE(String str) {
        return e(str, -1L);
    }

    private synchronized C0395a e(String str, long j) {
        checkNotClosed();
        dF(str);
        b bVar = this.aCM.get(str);
        byte b2 = 0;
        if (bVar == null) {
            bVar = new b(this, str, b2);
            this.aCM.put(str, bVar);
        } else if (bVar.aDa != null) {
            return null;
        }
        C0395a c0395a = new C0395a(this, bVar, b2);
        bVar.aDa = c0395a;
        this.aCL.write("DIRTY " + str + '\n');
        this.aCL.flush();
        return c0395a;
    }

    public final File getDirectory() {
        return this.aCD;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized int GJ() {
        return this.aCI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0395a c0395a, boolean z) {
        b bVar = c0395a.aCT;
        if (bVar.aDa != c0395a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.aCZ) {
            for (int i = 0; i < this.aCJ; i++) {
                if (!c0395a.aCU[i]) {
                    c0395a.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!bVar.du(i).exists()) {
                    c0395a.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.aCJ; i2++) {
            File fileDu = bVar.du(i2);
            if (z) {
                if (fileDu.exists()) {
                    File fileDt = bVar.dt(i2);
                    fileDu.renameTo(fileDt);
                    long j = bVar.aCY[i2];
                    long length = fileDt.length();
                    bVar.aCY[i2] = length;
                    this.size = (this.size - j) + length;
                    this.aCK++;
                }
            } else {
                p(fileDu);
            }
        }
        this.aCN++;
        bVar.aDa = null;
        if (bVar.aCZ | z) {
            b.a(bVar, true);
            this.aCL.write("CLEAN " + bVar.key + bVar.GN() + '\n');
            if (z) {
                long j2 = this.aCO;
                this.aCO = 1 + j2;
                bVar.aDb = j2;
            }
        } else {
            this.aCM.remove(bVar.key);
            this.aCL.write("REMOVE " + bVar.key + '\n');
        }
        this.aCL.flush();
        if (this.size > this.maxSize || this.aCK > this.aCI || GK()) {
            this.aCP.submit(this.aCQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GK() {
        int i = this.aCN;
        return i >= 2000 && i >= this.aCM.size();
    }

    public final synchronized boolean remove(String str) {
        checkNotClosed();
        dF(str);
        b bVar = this.aCM.get(str);
        if (bVar != null && bVar.aDa == null) {
            for (int i = 0; i < this.aCJ; i++) {
                File fileDt = bVar.dt(i);
                if (fileDt.exists() && !fileDt.delete()) {
                    throw new IOException("failed to delete " + fileDt);
                }
                this.size -= bVar.aCY[i];
                this.aCK--;
                bVar.aCY[i] = 0;
            }
            this.aCN++;
            this.aCL.append((CharSequence) ("REMOVE " + str + '\n'));
            this.aCM.remove(str);
            if (GK()) {
                this.aCP.submit(this.aCQ);
            }
            return true;
        }
        return false;
    }

    private void checkNotClosed() {
        if (this.aCL == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        GL();
        this.aCL.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.aCL == null) {
            return;
        }
        for (b bVar : new ArrayList(this.aCM.values())) {
            if (bVar.aDa != null) {
                bVar.aDa.abort();
            }
        }
        trimToSize();
        GL();
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aCL);
        this.aCL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.aCM.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GL() {
        while (this.aCK > this.aCI) {
            remove(this.aCM.entrySet().iterator().next().getKey());
        }
    }

    public final void delete() {
        close();
        w.deleteContents(this.aCD);
    }

    private static void dF(String str) {
        if (!aCC.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    public final class c implements Closeable {
        private final long[] aCY;
        private final long aDb;
        private File[] aDc;
        private final InputStream[] aDd;
        private final String key;

        /* synthetic */ c(a aVar, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        private c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aDb = j;
            this.aDc = fileArr;
            this.aDd = inputStreamArr;
            this.aCY = jArr;
        }

        public final File dv(int i) {
            return this.aDc[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.aDd) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.a.a$a, reason: collision with other inner class name */
    public final class C0395a {
        private final b aCT;
        private final boolean[] aCU;
        private boolean aCV;
        private boolean aCW;

        /* synthetic */ C0395a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        static /* synthetic */ boolean b(C0395a c0395a, boolean z) {
            c0395a.aCV = true;
            return true;
        }

        private C0395a(b bVar) {
            this.aCT = bVar;
            this.aCU = bVar.aCZ ? null : new boolean[a.this.aCJ];
        }

        public final OutputStream ds(int i) {
            FileOutputStream fileOutputStream;
            C0396a c0396a;
            synchronized (a.this) {
                if (this.aCT.aDa != this) {
                    throw new IllegalStateException();
                }
                byte b = 0;
                if (!this.aCT.aCZ) {
                    this.aCU[0] = true;
                }
                File fileDu = this.aCT.du(0);
                try {
                    fileOutputStream = new FileOutputStream(fileDu);
                } catch (FileNotFoundException unused) {
                    a.this.aCD.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileDu);
                    } catch (FileNotFoundException unused2) {
                        return a.aCR;
                    }
                }
                c0396a = new C0396a(this, fileOutputStream, b);
            }
            return c0396a;
        }

        public final void commit() {
            if (this.aCV) {
                a.this.a(this, false);
                a.this.remove(this.aCT.key);
            } else {
                a.this.a(this, true);
            }
            this.aCW = true;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.a.a$a$a, reason: collision with other inner class name */
        class C0396a extends FilterOutputStream {
            /* synthetic */ C0396a(C0395a c0395a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            private C0396a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    C0395a.b(C0395a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0395a.b(C0395a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C0395a.b(C0395a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C0395a.b(C0395a.this, true);
                }
            }
        }
    }

    final class b {
        private final long[] aCY;
        private boolean aCZ;
        private C0395a aDa;
        private long aDb;
        private final String key;

        /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        static /* synthetic */ boolean a(b bVar, boolean z) {
            bVar.aCZ = true;
            return true;
        }

        private b(String str) {
            this.key = str;
            this.aCY = new long[a.this.aCJ];
        }

        public final String GN() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.aCY) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.aCJ) {
                throw c(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.aCY[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw c(strArr);
                }
            }
        }

        private static IOException c(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File dt(int i) {
            return new File(a.this.aCD, this.key + i);
        }

        public final File du(int i) {
            return new File(a.this.aCD, this.key + i + bi.k);
        }
    }
}

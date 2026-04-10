package com.bytedance.sdk.component.ga.d.e.e;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.duokan.download.domain.DownloadCenterTask;
import com.xiaomi.ad.common.util.SignatureUtils;
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

/* JADX INFO: loaded from: classes.dex */
public final class e implements Closeable {
    final ExecutorService bf;
    private final File ga;
    private final int m;
    private final File p;
    private int t;
    private final File tg;
    private final int v;
    private final File vn;
    private Writer xu;
    private long zk;
    static final Pattern e = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream d = new OutputStream() { // from class: com.bytedance.sdk.component.ga.d.e.e.e.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private long wu = 0;
    private final LinkedHashMap<String, bf> bh = new LinkedHashMap<>(0, 0.75f, true);
    private long s = -1;
    private long w = 0;
    private final Callable<Void> l = new Callable<Void>() { // from class: com.bytedance.sdk.component.ga.d.e.e.e.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (e.this) {
                if (e.this.xu == null) {
                    return null;
                }
                e.this.p();
                if (e.this.ga()) {
                    e.this.tg();
                    e.this.t = 0;
                }
                return null;
            }
        }
    };

    public final class bf {
        private final String bf;
        private final long[] d;
        private C0100e ga;
        private boolean tg;
        private long vn;

        private bf(String str) {
            this.bf = str;
            this.d = new long[e.this.m];
        }

        private IOException bf(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File bf(int i) {
            return new File(e.this.tg, this.bf + Consts.DOT + i + DownloadCenterTask.f);
        }

        public String e() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.d) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(String[] strArr) throws IOException {
            if (strArr.length == e.this.m) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.d[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw bf(strArr);
                    }
                }
                return;
            }
            throw bf(strArr);
        }

        public File e(int i) {
            return new File(e.this.tg, this.bf + Consts.DOT + i);
        }
    }

    public final class d implements Closeable {
        private final String bf;
        private final long d;
        private final long[] ga;
        private final InputStream[] tg;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.tg) {
                com.bytedance.sdk.component.ga.d.d.bf.e(inputStream);
            }
        }

        public InputStream e(int i) {
            return this.tg[i];
        }

        private d(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.bf = str;
            this.d = j;
            this.tg = inputStreamArr;
            this.ga = jArr;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.ga.d.e.e.e$e, reason: collision with other inner class name */
    public final class C0100e {
        private final bf bf;
        private final boolean[] d;
        private boolean ga;
        private boolean tg;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.ga.d.e.e.e$e$e, reason: collision with other inner class name */
        public class C0101e extends FilterOutputStream {
            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0100e.this.tg = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0100e.this.tg = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0100e.this.tg = true;
                }
            }

            private C0101e(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0100e.this.tg = true;
                }
            }
        }

        private C0100e(bf bfVar) {
            this.bf = bfVar;
            this.d = bfVar.tg ? null : new boolean[e.this.m];
        }

        public void bf() throws IOException {
            e.this.e(this, false);
        }

        public OutputStream e(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0101e c0101e;
            if (i < 0 || i >= e.this.m) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + e.this.m);
            }
            synchronized (e.this) {
                if (this.bf.ga == this) {
                    if (!this.bf.tg) {
                        this.d[i] = true;
                    }
                    File fileBf = this.bf.bf(i);
                    try {
                        fileOutputStream = new FileOutputStream(fileBf);
                    } catch (FileNotFoundException unused) {
                        e.this.tg.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(fileBf);
                        } catch (FileNotFoundException unused2) {
                            return e.d;
                        }
                    }
                    c0101e = new C0101e(fileOutputStream);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0101e;
        }

        public void e() throws IOException {
            if (this.tg) {
                e.this.e(this, false);
                e.this.d(this.bf.bf);
            } else {
                e.this.e(this, true);
            }
            this.ga = true;
        }
    }

    private e(File file, int i, int i2, long j, ExecutorService executorService) {
        this.tg = file;
        this.v = i;
        this.ga = new File(file, "journal");
        this.vn = new File(file, "journal.tmp");
        this.p = new File(file, "journal.bkp");
        this.m = i2;
        this.zk = j;
        this.bf = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() throws IOException {
        long j = this.zk;
        long j2 = this.s;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.wu > j) {
            d(this.bh.entrySet().iterator().next().getKey());
        }
        this.s = -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.xu == null) {
            return;
        }
        for (bf bfVar : new ArrayList(this.bh.values())) {
            if (bfVar.ga != null) {
                bfVar.ga.bf();
            }
        }
        p();
        this.xu.close();
        this.xu = null;
    }

    public void delete() throws IOException {
        close();
        tg.e(this.tg);
    }

    private void bf() throws IOException {
        com.bytedance.sdk.component.ga.d.e.e.d dVar = new com.bytedance.sdk.component.ga.d.e.e.d(new FileInputStream(this.ga), tg.e);
        try {
            String strE = dVar.e();
            String strE2 = dVar.e();
            String strE3 = dVar.e();
            String strE4 = dVar.e();
            String strE5 = dVar.e();
            if (!"libcore.io.DiskLruCache".equals(strE) || !"1".equals(strE2) || !Integer.toString(this.v).equals(strE3) || !Integer.toString(this.m).equals(strE4) || !"".equals(strE5)) {
                throw new IOException("unexpected journal header: [" + strE + ", " + strE2 + ", " + strE4 + ", " + strE5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    tg(dVar.e());
                    i++;
                } catch (EOFException unused) {
                    this.t = i - this.bh.size();
                    if (dVar.bf()) {
                        tg();
                    } else {
                        this.xu = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ga, true), tg.e));
                    }
                    com.bytedance.sdk.component.ga.d.d.bf.e(dVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.ga.d.d.bf.e(dVar);
            throw th;
        }
    }

    private void d() throws IOException {
        e(this.vn);
        Iterator<bf> it = this.bh.values().iterator();
        while (it.hasNext()) {
            bf next = it.next();
            int i = 0;
            if (next.ga == null) {
                while (i < this.m) {
                    this.wu += next.d[i];
                    i++;
                }
            } else {
                next.ga = null;
                while (i < this.m) {
                    e(next.e(i));
                    e(next.bf(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ga() {
        int i = this.t;
        return i >= 2000 && i >= this.bh.size();
    }

    private void tg(String str) throws IOException {
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
                this.bh.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        bf bfVar = this.bh.get(strSubstring);
        if (bfVar == null) {
            bfVar = new bf(strSubstring);
            this.bh.put(strSubstring, bfVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            bfVar.tg = true;
            bfVar.ga = null;
            bfVar.e(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            bfVar.ga = new C0100e(bfVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void vn() {
        if (this.xu == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static e e(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    e(file2, file3, false);
                }
            }
            e eVar = new e(file, i, i2, j, executorService);
            if (eVar.ga.exists()) {
                try {
                    eVar.bf();
                    eVar.d();
                    return eVar;
                } catch (IOException e2) {
                    Log.w("DiskLruCache ", file + " is corrupt: " + e2.getMessage() + ", removing");
                    eVar.delete();
                }
            }
            file.mkdirs();
            e eVar2 = new e(file, i, i2, j, executorService);
            eVar2.tg();
            return eVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private void ga(String str) {
        if (e.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized boolean d(String str) throws IOException {
        vn();
        ga(str);
        bf bfVar = this.bh.get(str);
        if (bfVar != null && bfVar.ga == null) {
            for (int i = 0; i < this.m; i++) {
                File fileE = bfVar.e(i);
                if (fileE.exists() && !fileE.delete()) {
                    throw new IOException("failed to delete " + fileE);
                }
                this.wu -= bfVar.d[i];
                bfVar.d[i] = 0;
            }
            this.t++;
            this.xu.append((CharSequence) ("REMOVE " + str + '\n'));
            this.bh.remove(str);
            if (ga()) {
                this.bf.submit(this.l);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void tg() throws IOException {
        Writer writer = this.xu;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.vn), tg.e));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(SignatureUtils.DELIMITER);
            bufferedWriter.write("1");
            bufferedWriter.write(SignatureUtils.DELIMITER);
            bufferedWriter.write(Integer.toString(this.v));
            bufferedWriter.write(SignatureUtils.DELIMITER);
            bufferedWriter.write(Integer.toString(this.m));
            bufferedWriter.write(SignatureUtils.DELIMITER);
            bufferedWriter.write(SignatureUtils.DELIMITER);
            for (bf bfVar : this.bh.values()) {
                if (bfVar.ga != null) {
                    bufferedWriter.write("DIRTY " + bfVar.bf + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + bfVar.bf + bfVar.e() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.ga.exists()) {
                e(this.ga, this.p, true);
            }
            e(this.vn, this.ga, false);
            this.p.delete();
            this.xu = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ga, true), tg.e));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    public C0100e bf(String str) throws IOException {
        return e(str, -1L);
    }

    private static void e(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void e(File file, File file2, boolean z) throws IOException {
        if (z) {
            e(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized d e(String str) throws IOException {
        InputStream inputStream;
        vn();
        ga(str);
        bf bfVar = this.bh.get(str);
        if (bfVar == null) {
            return null;
        }
        if (!bfVar.tg) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.m];
        for (int i = 0; i < this.m; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(bfVar.e(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.m && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    com.bytedance.sdk.component.ga.d.d.bf.e(inputStream);
                }
                return null;
            }
        }
        this.t++;
        this.xu.append((CharSequence) ("READ " + str + '\n'));
        if (ga()) {
            this.bf.submit(this.l);
        }
        return new d(str, bfVar.vn, inputStreamArr, bfVar.d);
    }

    private synchronized C0100e e(String str, long j) throws IOException {
        vn();
        ga(str);
        bf bfVar = this.bh.get(str);
        if (j != -1 && (bfVar == null || bfVar.vn != j)) {
            return null;
        }
        if (bfVar != null) {
            if (bfVar.ga != null) {
                return null;
            }
        } else {
            bfVar = new bf(str);
            this.bh.put(str, bfVar);
        }
        C0100e c0100e = new C0100e(bfVar);
        bfVar.ga = c0100e;
        this.xu.write("DIRTY " + str + '\n');
        this.xu.flush();
        return c0100e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(C0100e c0100e, boolean z) throws IOException {
        bf bfVar = c0100e.bf;
        if (bfVar.ga == c0100e) {
            if (z && !bfVar.tg) {
                for (int i = 0; i < this.m; i++) {
                    if (c0100e.d[i]) {
                        if (!bfVar.bf(i).exists()) {
                            c0100e.bf();
                            return;
                        }
                    } else {
                        c0100e.bf();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.m; i2++) {
                File fileBf = bfVar.bf(i2);
                if (z) {
                    if (fileBf.exists()) {
                        File fileE = bfVar.e(i2);
                        fileBf.renameTo(fileE);
                        long j = bfVar.d[i2];
                        long length = fileE.length();
                        bfVar.d[i2] = length;
                        this.wu = (this.wu - j) + length;
                    }
                } else {
                    e(fileBf);
                }
            }
            this.t++;
            bfVar.ga = null;
            if (bfVar.tg | z) {
                bfVar.tg = true;
                this.xu.write("CLEAN " + bfVar.bf + bfVar.e() + '\n');
                if (z) {
                    long j2 = this.w;
                    this.w = 1 + j2;
                    bfVar.vn = j2;
                }
            } else {
                this.bh.remove(bfVar.bf);
                this.xu.write("REMOVE " + bfVar.bf + '\n');
            }
            this.xu.flush();
            if (this.wu > this.zk || ga()) {
                this.bf.submit(this.l);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public synchronized void e() throws IOException {
        vn();
        p();
        this.xu.flush();
    }
}

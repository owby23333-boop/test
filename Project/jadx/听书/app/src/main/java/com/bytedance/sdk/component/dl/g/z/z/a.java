package com.bytedance.sdk.component.dl.g.z.z;

import com.bytedance.sdk.component.dl.z.fv;
import com.bytedance.sdk.component.dl.z.js;
import com.bytedance.sdk.component.dl.z.wp;
import com.kuaishou.weapon.p0.bi;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Closeable, Flushable {
    static final /* synthetic */ boolean i = true;
    static final Pattern z = Pattern.compile("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f686a;
    final File dl;
    int e;
    boolean fo;
    private long fv;
    final com.bytedance.sdk.component.dl.g.z.m.z g;
    com.bytedance.sdk.component.dl.z.a gc;
    boolean gz;
    private final Runnable iq;
    private long js;
    boolean kb;
    private final File ls;
    final LinkedHashMap<String, g> m;
    private final int p;
    private final File pf;
    private final Executor q;
    private long tb;
    boolean uy;
    private final File v;
    boolean wp;

    public synchronized void z() throws IOException {
        if (!i && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.fo) {
            return;
        }
        if (this.g.a(this.ls)) {
            if (this.g.a(this.v)) {
                this.g.delete(this.ls);
            } else {
                this.g.z(this.ls, this.v);
            }
        }
        if (this.g.a(this.v)) {
            try {
                m();
                gz();
                this.fo = true;
                return;
            } catch (IOException e) {
                com.bytedance.sdk.component.dl.g.z.e.gc.g().z(5, "DiskLruCache " + this.dl + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    delete();
                    this.uy = false;
                    g();
                    this.fo = true;
                } catch (Throwable th) {
                    this.uy = false;
                    throw th;
                }
            }
        }
        g();
        this.fo = true;
    }

    private void m() throws IOException {
        com.bytedance.sdk.component.dl.z.gc gcVarZ = wp.z(this.g.z(this.v));
        try {
            String strLs = gcVarZ.ls();
            String strLs2 = gcVarZ.ls();
            String strLs3 = gcVarZ.ls();
            String strLs4 = gcVarZ.ls();
            String strLs5 = gcVarZ.ls();
            if (!"libcore.io.DiskLruCache".equals(strLs) || !"1".equals(strLs2) || !Integer.toString(this.p).equals(strLs3) || !Integer.toString(this.f686a).equals(strLs4) || !"".equals(strLs5)) {
                throw new IOException("unexpected journal header: [" + strLs + ", " + strLs2 + ", " + strLs4 + ", " + strLs5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    z(gcVarZ.ls());
                    i2++;
                } catch (EOFException unused) {
                    this.e = i2 - this.m.size();
                    if (!gcVarZ.gc()) {
                        g();
                    } else {
                        this.gc = e();
                    }
                    com.bytedance.sdk.component.dl.g.z.dl.z(gcVarZ);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.dl.g.z.dl.z(gcVarZ);
            throw th;
        }
    }

    private com.bytedance.sdk.component.dl.z.a e() throws FileNotFoundException {
        return wp.z(new gc(this.g.dl(this.v)) { // from class: com.bytedance.sdk.component.dl.g.z.z.a.1
            static final /* synthetic */ boolean z = true;

            @Override // com.bytedance.sdk.component.dl.g.z.z.gc
            protected void z(IOException iOException) {
                if (!z && !Thread.holdsLock(a.this)) {
                    throw new AssertionError();
                }
                a.this.gz = true;
            }
        });
    }

    private void z(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
        int i2 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i2);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i2);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.m.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iIndexOf2);
        }
        g gVar = this.m.get(strSubstring);
        if (gVar == null) {
            gVar = new g(strSubstring);
            this.m.put(strSubstring, gVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            gVar.gc = true;
            gVar.m = null;
            gVar.z(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            gVar.m = new z(gVar);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
    }

    private void gz() throws IOException {
        this.g.delete(this.pf);
        Iterator<g> it = this.m.values().iterator();
        while (it.hasNext()) {
            g next = it.next();
            int i2 = 0;
            if (next.m == null) {
                while (i2 < this.f686a) {
                    this.js += next.g[i2];
                    i2++;
                }
            } else {
                next.m = null;
                while (i2 < this.f686a) {
                    this.g.delete(next.dl[i2]);
                    this.g.delete(next.f688a[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    synchronized void g() throws IOException {
        com.bytedance.sdk.component.dl.z.a aVar = this.gc;
        if (aVar != null) {
            aVar.close();
        }
        com.bytedance.sdk.component.dl.z.a aVarZ = wp.z(this.g.g(this.pf));
        try {
            aVarZ.g("libcore.io.DiskLruCache").fo(10);
            aVarZ.g("1").fo(10);
            aVarZ.wp(this.p).fo(10);
            aVarZ.wp(this.f686a).fo(10);
            aVarZ.fo(10);
            for (g gVar : this.m.values()) {
                if (gVar.m != null) {
                    aVarZ.g("DIRTY").fo(32);
                    aVarZ.g(gVar.z);
                    aVarZ.fo(10);
                } else {
                    aVarZ.g("CLEAN").fo(32);
                    aVarZ.g(gVar.z);
                    gVar.z(aVarZ);
                    aVarZ.fo(10);
                }
            }
            aVarZ.close();
            if (this.g.a(this.v)) {
                this.g.z(this.v, this.ls);
            }
            this.g.z(this.pf, this.v);
            this.g.delete(this.ls);
            this.gc = e();
            this.gz = false;
            this.wp = false;
        } catch (Throwable th) {
            aVarZ.close();
            throw th;
        }
    }

    synchronized z z(String str, long j) throws IOException {
        z();
        fo();
        g(str);
        g gVar = this.m.get(str);
        if (j != -1 && (gVar == null || gVar.e != j)) {
            return null;
        }
        if (gVar != null && gVar.m != null) {
            return null;
        }
        if (!this.kb && !this.wp) {
            this.gc.g("DIRTY").fo(32).g(str).fo(10);
            this.gc.flush();
            if (this.gz) {
                return null;
            }
            if (gVar == null) {
                gVar = new g(str);
                this.m.put(str, gVar);
            }
            z zVar = new z(gVar);
            gVar.m = zVar;
            return zVar;
        }
        this.q.execute(this.iq);
        return null;
    }

    synchronized void z(z zVar, boolean z2) throws IOException {
        g gVar = zVar.z;
        if (gVar.m != zVar) {
            throw new IllegalStateException();
        }
        if (z2 && !gVar.gc) {
            for (int i2 = 0; i2 < this.f686a; i2++) {
                if (!zVar.g[i2]) {
                    zVar.dl();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i2)));
                }
                if (!this.g.a(gVar.f688a[i2])) {
                    zVar.dl();
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < this.f686a; i3++) {
            File file = gVar.f688a[i3];
            if (z2) {
                if (this.g.a(file)) {
                    File file2 = gVar.dl[i3];
                    this.g.z(file, file2);
                    long j = gVar.g[i3];
                    long jGc = this.g.gc(file2);
                    gVar.g[i3] = jGc;
                    this.js = (this.js - j) + jGc;
                }
            } else {
                this.g.delete(file);
            }
        }
        this.e++;
        gVar.m = null;
        if (gVar.gc | z2) {
            gVar.gc = true;
            this.gc.g("CLEAN").fo(32);
            this.gc.g(gVar.z);
            gVar.z(this.gc);
            this.gc.fo(10);
            if (z2) {
                long j2 = this.tb;
                this.tb = 1 + j2;
                gVar.e = j2;
            }
        } else {
            this.m.remove(gVar.z);
            this.gc.g("REMOVE").fo(32);
            this.gc.g(gVar.z);
            this.gc.fo(10);
        }
        this.gc.flush();
        if (this.js > this.fv || dl()) {
            this.q.execute(this.iq);
        }
    }

    boolean dl() {
        int i2 = this.e;
        return i2 >= 2000 && i2 >= this.m.size();
    }

    boolean z(g gVar) throws IOException {
        if (gVar.m != null) {
            gVar.m.z();
        }
        for (int i2 = 0; i2 < this.f686a; i2++) {
            this.g.delete(gVar.dl[i2]);
            this.js -= gVar.g[i2];
            gVar.g[i2] = 0;
        }
        this.e++;
        this.gc.g("REMOVE").fo(32).g(gVar.z).fo(10);
        this.m.remove(gVar.z);
        if (dl()) {
            this.q.execute(this.iq);
        }
        return true;
    }

    public synchronized boolean a() {
        return this.uy;
    }

    private synchronized void fo() {
        if (a()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.fo) {
            fo();
            gc();
            this.gc.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.fo && !this.uy) {
            for (g gVar : (g[]) this.m.values().toArray(new g[this.m.size()])) {
                if (gVar.m != null) {
                    gVar.m.dl();
                }
            }
            gc();
            this.gc.close();
            this.gc = null;
            this.uy = true;
            return;
        }
        this.uy = true;
    }

    void gc() throws IOException {
        while (this.js > this.fv) {
            z(this.m.values().iterator().next());
        }
        this.kb = false;
    }

    public void delete() throws IOException {
        close();
        this.g.m(this.dl);
    }

    private void g(String str) {
        if (!z.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final class dl implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final js[] f687a;
        private final long dl;
        private final String g;
        final /* synthetic */ a z;

        public z z() throws IOException {
            return this.z.z(this.g, this.dl);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (js jsVar : this.f687a) {
                com.bytedance.sdk.component.dl.g.z.dl.z(jsVar);
            }
        }
    }

    public final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f689a;
        final boolean[] g;
        final g z;

        z(g gVar) {
            this.z = gVar;
            this.g = gVar.gc ? null : new boolean[a.this.f686a];
        }

        void z() {
            if (this.z.m == this) {
                for (int i = 0; i < a.this.f686a; i++) {
                    try {
                        a.this.g.delete(this.z.f688a[i]);
                    } catch (IOException unused) {
                    }
                }
                this.z.m = null;
            }
        }

        public fv z(int i) {
            synchronized (a.this) {
                if (this.f689a) {
                    throw new IllegalStateException();
                }
                if (this.z.m != this) {
                    return wp.z();
                }
                if (!this.z.gc) {
                    this.g[i] = true;
                }
                try {
                    return new gc(a.this.g.g(this.z.f688a[i])) { // from class: com.bytedance.sdk.component.dl.g.z.z.a.z.1
                        @Override // com.bytedance.sdk.component.dl.g.z.z.gc
                        protected void z(IOException iOException) {
                            synchronized (a.this) {
                                z.this.z();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return wp.z();
                }
            }
        }

        public void g() throws IOException {
            synchronized (a.this) {
                if (this.f689a) {
                    throw new IllegalStateException();
                }
                if (this.z.m == this) {
                    a.this.z(this, true);
                }
                this.f689a = true;
            }
        }

        public void dl() throws IOException {
            synchronized (a.this) {
                if (this.f689a) {
                    throw new IllegalStateException();
                }
                if (this.z.m == this) {
                    a.this.z(this, false);
                }
                this.f689a = true;
            }
        }
    }

    private final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final File[] f688a;
        final File[] dl;
        long e;
        final long[] g;
        boolean gc;
        z m;
        final String z;

        g(String str) {
            this.z = str;
            this.g = new long[a.this.f686a];
            this.dl = new File[a.this.f686a];
            this.f688a = new File[a.this.f686a];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < a.this.f686a; i++) {
                sbAppend.append(i);
                this.dl[i] = new File(a.this.dl, sbAppend.toString());
                sbAppend.append(bi.k);
                this.f688a[i] = new File(a.this.dl, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        void z(String[] strArr) throws IOException {
            if (strArr.length != a.this.f686a) {
                throw g(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.g[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw g(strArr);
                }
            }
        }

        void z(com.bytedance.sdk.component.dl.z.a aVar) throws IOException {
            for (long j : this.g) {
                aVar.fo(32).wp(j);
            }
        }

        private IOException g(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }
}

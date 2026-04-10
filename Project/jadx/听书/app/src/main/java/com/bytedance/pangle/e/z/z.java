package com.bytedance.pangle.e.z;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
class z {
    private boolean e;
    private int[] fo;
    private g gz;
    private m kb;
    private int m;
    private boolean uy = false;
    private final dl wp = new dl();
    int z = 0;
    int g = 1;
    int dl = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f509a = 3;
    int gc = 4;

    public z() {
        a();
    }

    public void z(InputStream inputStream) {
        z();
        if (inputStream != null) {
            this.gz = new g(inputStream);
        }
    }

    public void z() {
        if (this.uy) {
            this.uy = false;
            this.gz.z();
            this.kb = null;
            this.gz = null;
            this.wp.z();
            a();
        }
    }

    public int g() throws IOException {
        try {
            if (this.gz != null) {
                gc();
                return this.m;
            }
            throw new IOException("Parser is not opened.");
        } catch (IOException e) {
            z();
            throw e;
        }
    }

    public int dl() {
        if (this.m != 2) {
            return -1;
        }
        return this.fo.length / 5;
    }

    public String z(int i) {
        int i2 = this.fo[gc(i) + 1];
        return i2 == -1 ? "" : this.kb.z(i2);
    }

    public int g(int i) {
        return this.fo[gc(i) + 3];
    }

    public int dl(int i) {
        return this.fo[gc(i) + 4];
    }

    public String a(int i) {
        int iGc = gc(i);
        int[] iArr = this.fo;
        if (iArr[iGc + 3] != 3) {
            return "";
        }
        return this.kb.z(iArr[iGc + 2]);
    }

    private int gc(int i) {
        if (this.m != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.fo.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    private void a() {
        this.fo = null;
        this.m = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x016f, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r2 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void gc() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.e.z.z.gc():void");
    }
}

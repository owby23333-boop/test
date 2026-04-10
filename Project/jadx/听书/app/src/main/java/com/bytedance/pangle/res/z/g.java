package com.bytedance.pangle.res.z;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final byte[] fo;
    private final gz gz;
    private int[] ls;
    private int p;
    private int pf;
    private e uy;
    private boolean v;
    private int[] wp;
    HashMap<Integer, Integer> z = new HashMap<>();
    boolean g = false;
    private boolean kb = false;
    private final z i = new z();
    int dl = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f529a = 1;
    int gc = 2;
    int m = 3;
    int e = 4;

    public g(byte[] bArr, gz gzVar) {
        this.gz = gzVar;
        this.fo = bArr;
        a();
    }

    public void z(InputStream inputStream) {
        z();
        if (inputStream != null) {
            this.uy = new e(new fo(new gc(inputStream)));
        }
    }

    public void z() {
        if (this.kb) {
            this.kb = false;
            this.uy = null;
            this.wp = null;
            this.i.z();
            a();
        }
    }

    public int g() throws IOException {
        if (this.uy == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            gc();
            return this.pf;
        } catch (IOException e) {
            z();
            throw e;
        }
    }

    public int dl() throws IOException {
        return g();
    }

    public void g(InputStream inputStream) {
        z(inputStream);
    }

    private static final class z {
        private int dl;
        private int g;
        private int[] z = new int[32];

        public void z() {
            this.g = 0;
            this.dl = 0;
        }

        public int g() {
            int i = this.g;
            if (i == 0) {
                return 0;
            }
            return this.z[i - 1];
        }

        public void z(int i, int i2) {
            if (this.dl == 0) {
                gc();
            }
            z(2);
            int i3 = this.g;
            int i4 = i3 - 1;
            int[] iArr = this.z;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.g = i3 + 2;
        }

        public boolean dl() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.g;
            if (i3 == 0 || (i2 = (iArr = this.z)[i3 - 1]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.g = i3 - 2;
            return true;
        }

        public int a() {
            return this.dl;
        }

        public void gc() {
            z(2);
            int i = this.g;
            int[] iArr = this.z;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.g = i + 2;
            this.dl++;
        }

        public void m() {
            int i = this.g;
            if (i == 0) {
                return;
            }
            int i2 = i - 1;
            int i3 = this.z[i2] * 2;
            if ((i2 - 1) - i3 == 0) {
                return;
            }
            this.g = i - (i3 + 2);
            this.dl--;
        }

        private void z(int i) {
            int[] iArr = this.z;
            int length = iArr.length;
            int i2 = this.g;
            int i3 = length - i2;
            if (i3 > i) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.z = iArr2;
        }
    }

    private void a() {
        this.pf = -1;
        this.ls = null;
        this.p = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e7, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0217, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r2 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void gc() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.z.g.gc():void");
    }
}

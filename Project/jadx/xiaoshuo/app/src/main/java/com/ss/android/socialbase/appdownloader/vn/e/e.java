package com.ss.android.socialbase.appdownloader.vn.e;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
class e implements zk {
    private tg bf;
    private int bh;
    private int[] ga;
    private int m;
    private boolean p;
    private int s;
    private int t;
    private vn tg;
    private int v;
    private int wu;
    private int[] xu;
    private int zk;
    private boolean d = false;
    private C0497e vn = new C0497e();

    public e() {
        p();
    }

    private final void p() {
        this.v = -1;
        this.zk = -1;
        this.m = -1;
        this.wu = -1;
        this.xu = null;
        this.bh = -1;
        this.t = -1;
        this.s = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0093, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x018a, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void v() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.vn.e.e.v():void");
    }

    public int bf() throws v, IOException {
        if (this.bf == null) {
            throw new v("Parser is not opened.", this, null);
        }
        try {
            v();
            return this.v;
        } catch (IOException e) {
            e();
            throw e;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.vn.e.p
    public int d() {
        return this.zk;
    }

    public void e(InputStream inputStream) {
        e();
        if (inputStream != null) {
            this.bf = new tg(inputStream, false);
        }
    }

    public int ga() {
        if (this.v != 2) {
            return -1;
        }
        return this.xu.length / 5;
    }

    @Override // com.ss.android.socialbase.appdownloader.vn.e.p
    public String tg() {
        return "XML line #" + d();
    }

    @Override // com.ss.android.socialbase.appdownloader.vn.e.p
    public int vn() {
        return -1;
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.vn.e.e$e, reason: collision with other inner class name */
    public static final class C0497e {
        private int bf;
        private int d;
        private int[] e = new int[32];

        public final int bf() {
            int i = this.bf;
            if (i == 0) {
                return 0;
            }
            return this.e[i - 1];
        }

        public final boolean d() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.bf;
            if (i3 == 0 || (i2 = (iArr = this.e)[i3 - 1]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.bf = i3 - 2;
            return true;
        }

        public final void e() {
            this.bf = 0;
            this.d = 0;
        }

        public final void ga() {
            e(2);
            int i = this.bf;
            int[] iArr = this.e;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.bf = i + 2;
            this.d++;
        }

        public final int tg() {
            return this.d;
        }

        public final void vn() {
            int i = this.bf;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.e[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.bf = i - (i3 + 2);
                    this.d--;
                }
            }
        }

        public final void e(int i, int i2) {
            if (this.d == 0) {
                ga();
            }
            e(2);
            int i3 = this.bf;
            int i4 = i3 - 1;
            int[] iArr = this.e;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.bf = i3 + 2;
        }

        private void e(int i) {
            int[] iArr = this.e;
            int length = iArr.length;
            int i2 = this.bf;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.e = iArr2;
            }
        }
    }

    private final int ga(int i) {
        if (this.v != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.xu.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    public int d(int i) {
        return this.xu[ga(i) + 4];
    }

    public String tg(int i) {
        int iGa = ga(i);
        int[] iArr = this.xu;
        if (iArr[iGa + 3] == 3) {
            return this.tg.e(iArr[iGa + 2]);
        }
        int i2 = iArr[iGa + 4];
        return "";
    }

    public void e() {
        if (this.d) {
            this.d = false;
            this.bf.e();
            this.bf = null;
            this.tg = null;
            this.ga = null;
            this.vn.e();
            p();
        }
    }

    public int bf(int i) {
        return this.xu[ga(i) + 3];
    }

    public String e(int i) {
        int i2 = this.xu[ga(i) + 1];
        return i2 == -1 ? "" : this.tg.e(i2);
    }
}

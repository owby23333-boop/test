package com.ss.android.socialbase.appdownloader.u.mb;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
class mb implements lz {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f18089h;
    private u hj;
    private int jb;
    private int[] je;
    private boolean ko;
    private int lc;
    private int lz;
    private int nk;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f18090o;
    private hj ox;
    private int ww;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f18092x;
    private boolean b = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private C0525mb f18091u = new C0525mb();

    public mb() {
        ko();
    }

    private final void ko() {
        this.ww = -1;
        this.lz = -1;
        this.f18092x = -1;
        this.jb = -1;
        this.je = null;
        this.nk = -1;
        this.f18090o = -1;
        this.lc = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0095, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0190, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void ww() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.mb.mb.ww():void");
    }

    @Override // com.ss.android.socialbase.appdownloader.u.mb.ko
    public int b() {
        return this.lz;
    }

    public int h() {
        if (this.ww != 2) {
            return -1;
        }
        return this.je.length / 5;
    }

    @Override // com.ss.android.socialbase.appdownloader.u.mb.ko
    public String hj() {
        return "XML line #" + b();
    }

    public void mb(InputStream inputStream) {
        mb();
        if (inputStream != null) {
            this.ox = new hj(inputStream, false);
        }
    }

    public int ox() throws ww, IOException {
        if (this.ox == null) {
            throw new ww("Parser is not opened.", this, null);
        }
        try {
            ww();
            return this.ww;
        } catch (IOException e2) {
            mb();
            throw e2;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.u.mb.ko
    public int u() {
        return -1;
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.u.mb.mb$mb, reason: collision with other inner class name */
    private static final class C0525mb {
        private int b;
        private int[] mb = new int[32];
        private int ox;

        public final boolean b() {
            int i2;
            int[] iArr;
            int i3;
            int i4 = this.ox;
            if (i4 == 0 || (i3 = (iArr = this.mb)[i4 - 1]) == 0) {
                return false;
            }
            int i5 = i3 - 1;
            int i6 = i2 - 2;
            iArr[i6] = i5;
            iArr[i6 - ((i5 * 2) + 1)] = i5;
            this.ox = i4 - 2;
            return true;
        }

        public final void h() {
            mb(2);
            int i2 = this.ox;
            int[] iArr = this.mb;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.ox = i2 + 2;
            this.b++;
        }

        public final int hj() {
            return this.b;
        }

        public final void mb() {
            this.ox = 0;
            this.b = 0;
        }

        public final int ox() {
            int i2 = this.ox;
            if (i2 == 0) {
                return 0;
            }
            return this.mb[i2 - 1];
        }

        public final void u() {
            int i2 = this.ox;
            if (i2 != 0) {
                int i3 = i2 - 1;
                int i4 = this.mb[i3] * 2;
                if ((i3 - 1) - i4 != 0) {
                    this.ox = i2 - (i4 + 2);
                    this.b--;
                }
            }
        }

        public final void mb(int i2, int i3) {
            if (this.b == 0) {
                h();
            }
            mb(2);
            int i4 = this.ox;
            int i5 = i4 - 1;
            int[] iArr = this.mb;
            int i6 = iArr[i5];
            int i7 = (i5 - 1) - (i6 * 2);
            int i8 = i6 + 1;
            iArr[i7] = i8;
            iArr[i5] = i2;
            iArr[i5 + 1] = i3;
            iArr[i5 + 2] = i8;
            this.ox = i4 + 2;
        }

        private void mb(int i2) {
            int[] iArr = this.mb;
            int length = iArr.length;
            int i3 = this.ox;
            int i4 = length - i3;
            if (i4 <= i2) {
                int[] iArr2 = new int[(iArr.length + i4) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.mb = iArr2;
            }
        }
    }

    private final int h(int i2) {
        if (this.ww != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i3 = i2 * 5;
        if (i3 < this.je.length) {
            return i3;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
    }

    public int b(int i2) {
        return this.je[h(i2) + 4];
    }

    public String hj(int i2) {
        int iH = h(i2);
        int[] iArr = this.je;
        if (iArr[iH + 3] == 3) {
            return this.hj.mb(iArr[iH + 2]);
        }
        int i3 = iArr[iH + 4];
        return "";
    }

    public void mb() {
        if (this.b) {
            this.b = false;
            this.ox.mb();
            this.ox = null;
            this.hj = null;
            this.f18089h = null;
            this.f18091u.mb();
            ko();
        }
    }

    public int ox(int i2) {
        return this.je[h(i2) + 3];
    }

    public String mb(int i2) {
        int i3 = this.je[h(i2) + 1];
        return i3 == -1 ? "" : this.hj.mb(i3);
    }
}

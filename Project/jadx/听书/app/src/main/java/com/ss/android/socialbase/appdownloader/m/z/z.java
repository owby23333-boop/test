package com.ss.android.socialbase.appdownloader.m.z;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
class z implements fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f2042a;
    private boolean e;
    private int fo;
    private a g;
    private int[] gc;
    private int gz;
    private int i;
    private int kb;
    private int pf;
    private int uy;
    private int v;
    private int[] wp;
    private boolean dl = false;
    private C0455z m = new C0455z();

    @Override // com.ss.android.socialbase.appdownloader.m.z.e
    public int m() {
        return -1;
    }

    public z() {
        e();
    }

    public void z(InputStream inputStream) {
        z();
        if (inputStream != null) {
            this.g = new a(inputStream, false);
        }
    }

    public void z() {
        if (this.dl) {
            this.dl = false;
            this.g.z();
            this.g = null;
            this.f2042a = null;
            this.gc = null;
            this.m.z();
            e();
        }
    }

    public int g() throws IOException, gz {
        if (this.g == null) {
            throw new gz("Parser is not opened.", this, null);
        }
        try {
            gz();
            return this.gz;
        } catch (IOException e) {
            z();
            throw e;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.m.z.e
    public int dl() {
        return this.fo;
    }

    @Override // com.ss.android.socialbase.appdownloader.m.z.e
    public String a() {
        return "XML line #" + dl();
    }

    public int gc() {
        if (this.gz != 2) {
            return -1;
        }
        return this.wp.length / 5;
    }

    public String z(int i) {
        int i2 = this.wp[gc(i) + 1];
        return i2 == -1 ? "" : this.f2042a.z(i2);
    }

    public int g(int i) {
        return this.wp[gc(i) + 3];
    }

    public int dl(int i) {
        return this.wp[gc(i) + 4];
    }

    public String a(int i) {
        int iGc = gc(i);
        int[] iArr = this.wp;
        if (iArr[iGc + 3] != 3) {
            return "";
        }
        return this.f2042a.z(iArr[iGc + 2]);
    }

    private final int gc(int i) {
        if (this.gz != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.wp.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    private final void e() {
        this.gz = -1;
        this.fo = -1;
        this.uy = -1;
        this.kb = -1;
        this.wp = null;
        this.i = -1;
        this.v = -1;
        this.pf = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0184, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void gz() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.m.z.z.gz():void");
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.m.z.z$z, reason: collision with other inner class name */
    private static final class C0455z {
        private int dl;
        private int g;
        private int[] z = new int[32];

        public final void z() {
            this.g = 0;
            this.dl = 0;
        }

        public final int g() {
            int i = this.g;
            if (i == 0) {
                return 0;
            }
            return this.z[i - 1];
        }

        public final void z(int i, int i2) {
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

        public final boolean dl() {
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

        public final int a() {
            return this.dl;
        }

        public final void gc() {
            z(2);
            int i = this.g;
            int[] iArr = this.z;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.g = i + 2;
            this.dl++;
        }

        public final void m() {
            int i = this.g;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.z[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.g = i - (i3 + 2);
                    this.dl--;
                }
            }
        }

        private void z(int i) {
            int[] iArr = this.z;
            int length = iArr.length;
            int i2 = this.g;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.z = iArr2;
            }
        }
    }
}

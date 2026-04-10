package com.bytedance.sdk.openadsdk.core.v;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1393a = 2;
    public static int dl = 1;
    public static int g = 0;
    public static int gc = 3;
    public static int z = -1;
    private int m = z;
    private long e = 0;
    private long gz = 0;
    private long fo = 0;
    private final List<m> uy = new ArrayList();

    public void z(long j) {
        this.m = g;
        this.e = j;
    }

    public void g(long j) {
        int i;
        int i2 = this.m;
        if (i2 == z || i2 == (i = gc)) {
            return;
        }
        this.m = i;
        this.fo = j;
    }

    public void dl(long j) {
        int i;
        int i2 = this.m;
        if (i2 == z || i2 == (i = f1393a) || i2 == gc) {
            return;
        }
        this.m = i;
        this.gz = j;
    }

    public void a(long j) {
        int i = this.m;
        if (i == z || i != f1393a) {
            return;
        }
        this.m = dl;
        this.uy.add(new m(this.gz, j));
        this.gz = 0L;
    }

    public long z(long j, long j2) {
        long j3;
        long j4;
        long jG;
        long j5 = this.fo;
        if (j5 != 0 && j > j5) {
            return 0L;
        }
        int i = 0;
        for (m mVar : this.uy) {
            if (mVar.g() > j) {
                if (j < mVar.z()) {
                    j4 = i;
                    jG = mVar.g() - mVar.z();
                } else {
                    j4 = i;
                    jG = mVar.g() - j;
                }
                i = (int) (j4 + jG);
            }
        }
        long j6 = this.e;
        if (j6 < j) {
            long j7 = this.gz;
            if (j7 == 0) {
                j7 = this.fo;
                if (j7 == 0) {
                    j3 = j2 - j;
                }
            } else if (j7 <= j) {
                return 0L;
            }
            return (j7 - j) - ((long) i);
        }
        long j8 = this.gz;
        if (j8 == 0) {
            j8 = this.fo;
            if (j8 == 0) {
                j3 = j2 - j6;
            }
        } else if (j8 <= j6) {
            return 0L;
        }
        return (j8 - j6) - ((long) i);
        return j3 - ((long) i);
    }

    public int z() {
        return this.m;
    }
}

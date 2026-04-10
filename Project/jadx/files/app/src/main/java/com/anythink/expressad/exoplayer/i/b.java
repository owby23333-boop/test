package com.anythink.expressad.exoplayer.i;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.ae;
import com.anythink.expressad.exoplayer.m;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements f {
    private final m[] a;
    private final long[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9511c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final ae f9512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final int f9513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final int[] f9514i;

    private static final class a implements Comparator<m> {
        private a() {
        }

        private static int a(m mVar, m mVar2) {
            return mVar2.f9986d - mVar.f9986d;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(m mVar, m mVar2) {
            return mVar2.f9986d - mVar.f9986d;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public b(ae aeVar, int... iArr) {
        int i2 = 0;
        byte b = 0;
        com.anythink.expressad.exoplayer.k.a.b(iArr.length > 0);
        this.f9512g = (ae) com.anythink.expressad.exoplayer.k.a.a(aeVar);
        this.f9513h = iArr.length;
        this.a = new m[this.f9513h];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.a[i3] = aeVar.a(iArr[i3]);
        }
        Arrays.sort(this.a, new a(b == true ? 1 : 0));
        this.f9514i = new int[this.f9513h];
        while (true) {
            int i4 = this.f9513h;
            if (i2 >= i4) {
                this.b = new long[i4];
                return;
            } else {
                this.f9514i[i2] = aeVar.a(this.a[i2]);
                i2++;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final m a(int i2) {
        return this.a[i2];
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public void a() {
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public void a(float f2) {
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int b(int i2) {
        return this.f9514i[i2];
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int c(int i2) {
        for (int i3 = 0; i3 < this.f9513h; i3++) {
            if (this.f9514i[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final void e() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f9512g == bVar.f9512g && Arrays.equals(this.f9514i, bVar.f9514i)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final ae f() {
        return this.f9512g;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int g() {
        return this.f9514i.length;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final m h() {
        return this.a[b()];
    }

    public int hashCode() {
        if (this.f9511c == 0) {
            this.f9511c = (System.identityHashCode(this.f9512g) * 31) + Arrays.hashCode(this.f9514i);
        }
        return this.f9511c;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int i() {
        return this.f9514i[b()];
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int a(m mVar) {
        for (int i2 = 0; i2 < this.f9513h; i2++) {
            if (this.a[i2] == mVar) {
                return i2;
            }
        }
        return -1;
    }

    protected final boolean b(int i2, long j2) {
        return this.b[i2] > j2;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public int a(long j2, List<? extends com.anythink.expressad.exoplayer.h.b.i> list) {
        return list.size();
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final boolean a(int i2, long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zB = b(i2, jElapsedRealtime);
        int i3 = 0;
        while (i3 < this.f9513h && !zB) {
            zB = (i3 == i2 || b(i3, jElapsedRealtime)) ? false : true;
            i3++;
        }
        if (!zB) {
            return false;
        }
        long[] jArr = this.b;
        jArr[i2] = Math.max(jArr[i2], jElapsedRealtime + j2);
        return true;
    }
}

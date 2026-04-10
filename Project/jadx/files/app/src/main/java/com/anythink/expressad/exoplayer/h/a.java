package com.anythink.expressad.exoplayer.h;

import android.util.Pair;
import com.anythink.expressad.exoplayer.ae;

/* JADX INFO: loaded from: classes2.dex */
abstract class a extends com.anythink.expressad.exoplayer.ae {
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final aa f9162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f9163d;

    public a(boolean z2, aa aaVar) {
        this.f9163d = z2;
        this.f9162c = aaVar;
        this.b = aaVar.a();
    }

    protected abstract int a(int i2);

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(int i2, int i3, boolean z2) {
        if (this.f9163d) {
            if (i3 == 1) {
                i3 = 2;
            }
            z2 = false;
        }
        int iB = b(i2);
        int iE = e(iB);
        int iA = c(iB).a(i2 - iE, i3 != 2 ? i3 : 0, z2);
        if (iA != -1) {
            return iE + iA;
        }
        int iA2 = a(iB, z2);
        while (iA2 != -1 && c(iA2).a()) {
            iA2 = a(iA2, z2);
        }
        if (iA2 != -1) {
            return e(iA2) + c(iA2).b(z2);
        }
        if (i3 == 2) {
            return b(z2);
        }
        return -1;
    }

    protected abstract int b(int i2);

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b(int i2, int i3, boolean z2) {
        if (this.f9163d) {
            if (i3 == 1) {
                i3 = 2;
            }
            z2 = false;
        }
        int iB = b(i2);
        int iE = e(iB);
        int iB2 = c(iB).b(i2 - iE, i3 != 2 ? i3 : 0, z2);
        if (iB2 != -1) {
            return iE + iB2;
        }
        int iB3 = b(iB, z2);
        while (iB3 != -1 && c(iB3).a()) {
            iB3 = b(iB3, z2);
        }
        if (iB3 != -1) {
            return e(iB3) + c(iB3).a(z2);
        }
        if (i3 == 2) {
            return a(z2);
        }
        return -1;
    }

    protected abstract int b(Object obj);

    protected abstract com.anythink.expressad.exoplayer.ae c(int i2);

    protected abstract int d(int i2);

    protected abstract int e(int i2);

    protected abstract Object f(int i2);

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(boolean z2) {
        if (this.b == 0) {
            return -1;
        }
        if (this.f9163d) {
            z2 = false;
        }
        int iB = z2 ? this.f9162c.b() : this.b - 1;
        while (c(iB).a()) {
            iB = b(iB, z2);
            if (iB == -1) {
                return -1;
            }
        }
        return e(iB) + c(iB).a(z2);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b(boolean z2) {
        if (this.b == 0) {
            return -1;
        }
        if (this.f9163d) {
            z2 = false;
        }
        int iC = z2 ? this.f9162c.c() : 0;
        while (c(iC).a()) {
            iC = a(iC, z2);
            if (iC == -1) {
                return -1;
            }
        }
        return e(iC) + c(iC).b(z2);
    }

    private int b(int i2, boolean z2) {
        if (z2) {
            return this.f9162c.b(i2);
        }
        if (i2 > 0) {
            return i2 - 1;
        }
        return -1;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final ae.b a(int i2, ae.b bVar, boolean z2, long j2) {
        int iB = b(i2);
        int iE = e(iB);
        int iD = d(iB);
        c(iB).a(i2 - iE, bVar, z2, j2);
        bVar.f8476f += iD;
        bVar.f8477g += iD;
        return bVar;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final ae.a a(int i2, ae.a aVar, boolean z2) {
        int iA = a(i2);
        int iE = e(iA);
        c(iA).a(i2 - d(iA), aVar, z2);
        aVar.f8469c += iE;
        if (z2) {
            aVar.b = Pair.create(f(iA), aVar.b);
        }
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(Object obj) {
        int iA;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int iB = b(obj2);
        if (iB == -1 || (iA = c(iB).a(obj3)) == -1) {
            return -1;
        }
        return d(iB) + iA;
    }

    private int a(int i2, boolean z2) {
        if (z2) {
            return this.f9162c.a(i2);
        }
        if (i2 < this.b - 1) {
            return i2 + 1;
        }
        return -1;
    }
}

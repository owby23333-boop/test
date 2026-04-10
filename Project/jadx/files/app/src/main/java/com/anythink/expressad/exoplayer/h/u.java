package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.h.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

/* JADX INFO: loaded from: classes2.dex */
final class u implements r, r.a {
    public final r[] a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f9441c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private r.a f9443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private af f9444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private r[] f9445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private z f9446h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList<r> f9442d = new ArrayList<>();
    private final IdentityHashMap<y, Integer> b = new IdentityHashMap<>();

    public u(h hVar, r... rVarArr) {
        this.f9441c = hVar;
        this.a = rVarArr;
        this.f9446h = hVar.a(new z[0]);
    }

    private void f() {
        this.f9443e.a(this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(r.a aVar, long j2) {
        this.f9443e = aVar;
        Collections.addAll(this.f9442d, this.a);
        for (r rVar : this.a) {
            rVar.a(this, j2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j2) {
        this.f9446h.a_(j2);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final af b() {
        return this.f9444f;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j2) {
        if (this.f9442d.isEmpty()) {
            return this.f9446h.c(j2);
        }
        int size = this.f9442d.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f9442d.get(i2).c(j2);
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        return this.f9446h.d();
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        return this.f9446h.e();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long b(long j2) {
        long jB = this.f9445g[0].b(j2);
        int i2 = 1;
        while (true) {
            r[] rVarArr = this.f9445g;
            if (i2 >= rVarArr.length) {
                return jB;
            }
            if (rVarArr[i2].b(jB) != jB) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i2++;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
        for (r rVar : this.a) {
            rVar.a();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        long jC = this.a[0].c();
        int i2 = 1;
        while (true) {
            r[] rVarArr = this.a;
            if (i2 >= rVarArr.length) {
                if (jC != com.anythink.expressad.exoplayer.b.b) {
                    for (r rVar : this.f9445g) {
                        if (rVar != this.a[0] && rVar.b(jC) != jC) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                }
                return jC;
            }
            if (rVarArr[i2].c() != com.anythink.expressad.exoplayer.b.b) {
                throw new IllegalStateException("Child reported discontinuity.");
            }
            i2++;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j2) {
        int[] iArr = new int[fVarArr.length];
        int[] iArr2 = new int[fVarArr.length];
        for (int i2 = 0; i2 < fVarArr.length; i2++) {
            iArr[i2] = yVarArr[i2] == null ? -1 : this.b.get(yVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                ae aeVarF = fVarArr[i2].f();
                int i3 = 0;
                while (true) {
                    r[] rVarArr = this.a;
                    if (i3 >= rVarArr.length) {
                        break;
                    }
                    if (rVarArr[i3].b().a(aeVarF) != -1) {
                        iArr2[i2] = i3;
                        break;
                    }
                    i3++;
                }
            }
        }
        this.b.clear();
        y[] yVarArr2 = new y[fVarArr.length];
        y[] yVarArr3 = new y[fVarArr.length];
        com.anythink.expressad.exoplayer.i.f[] fVarArr2 = new com.anythink.expressad.exoplayer.i.f[fVarArr.length];
        ArrayList arrayList = new ArrayList(this.a.length);
        long j3 = j2;
        int i4 = 0;
        while (i4 < this.a.length) {
            for (int i5 = 0; i5 < fVarArr.length; i5++) {
                com.anythink.expressad.exoplayer.i.f fVar = null;
                yVarArr3[i5] = iArr[i5] == i4 ? yVarArr[i5] : null;
                if (iArr2[i5] == i4) {
                    fVar = fVarArr[i5];
                }
                fVarArr2[i5] = fVar;
            }
            com.anythink.expressad.exoplayer.i.f[] fVarArr3 = fVarArr2;
            ArrayList arrayList2 = arrayList;
            com.anythink.expressad.exoplayer.i.f[] fVarArr4 = fVarArr2;
            int i6 = i4;
            long jA = this.a[i4].a(fVarArr3, zArr, yVarArr3, zArr2, j3);
            if (i6 == 0) {
                j3 = jA;
            } else if (jA != j3) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z2 = false;
            for (int i7 = 0; i7 < fVarArr.length; i7++) {
                if (iArr2[i7] == i6) {
                    com.anythink.expressad.exoplayer.k.a.b(yVarArr3[i7] != null);
                    yVarArr2[i7] = yVarArr3[i7];
                    this.b.put(yVarArr3[i7], Integer.valueOf(i6));
                    z2 = true;
                } else if (iArr[i7] == i6) {
                    com.anythink.expressad.exoplayer.k.a.b(yVarArr3[i7] == null);
                }
            }
            if (z2) {
                arrayList2.add(this.a[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            fVarArr2 = fVarArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(yVarArr2, 0, yVarArr, 0, yVarArr2.length);
        this.f9445g = new r[arrayList3.size()];
        arrayList3.toArray(this.f9445g);
        this.f9446h = this.f9441c.a(this.f9445g);
        return j3;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j2, boolean z2) {
        for (r rVar : this.f9445g) {
            rVar.a(j2, z2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j2, com.anythink.expressad.exoplayer.ac acVar) {
        return this.f9445g[0].a(j2, acVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.r.a
    public final void a(r rVar) {
        this.f9442d.remove(rVar);
        if (this.f9442d.isEmpty()) {
            int i2 = 0;
            for (r rVar2 : this.a) {
                i2 += rVar2.b().b;
            }
            ae[] aeVarArr = new ae[i2];
            r[] rVarArr = this.a;
            int length = rVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                af afVarB = rVarArr[i3].b();
                int i5 = afVarB.b;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    aeVarArr[i6] = afVarB.a(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.f9444f = new af(aeVarArr);
            this.f9443e.a((r) this);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.z.a
    public final /* bridge */ /* synthetic */ void a(z zVar) {
        this.f9443e.a(this);
    }
}

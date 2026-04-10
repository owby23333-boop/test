package com.anythink.expressad.exoplayer.h.b;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.b.g;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.h.x;
import com.anythink.expressad.exoplayer.h.y;
import com.anythink.expressad.exoplayer.h.z;
import com.anythink.expressad.exoplayer.j.t;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.m;
import com.anythink.expressad.exoplayer.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f<T extends g> implements y, z, t.a<c>, t.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9259d = "ChunkSampleStream";
    public final int a;
    long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f9260c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f9261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m[] f9262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean[] f9263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final T f9264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final z.a<f<T>> f9265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final t.a f9266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f9267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.t f9268l = new com.anythink.expressad.exoplayer.j.t("Loader:ChunkSampleStream");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final e f9269m = new e();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ArrayList<com.anythink.expressad.exoplayer.h.b.a> f9270n = new ArrayList<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List<com.anythink.expressad.exoplayer.h.b.a> f9271o = Collections.unmodifiableList(this.f9270n);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final x f9272p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final x[] f9273q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.h.b.b f9274r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private m f9275s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private b<T> f9276t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f9277u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f9278v;

    public interface b<T extends g> {
        void a();
    }

    private f(int i2, int[] iArr, m[] mVarArr, T t2, z.a<f<T>> aVar, com.anythink.expressad.exoplayer.j.b bVar, long j2, int i3, t.a aVar2) {
        this.a = i2;
        this.f9261e = iArr;
        this.f9262f = mVarArr;
        this.f9264h = t2;
        this.f9265i = aVar;
        this.f9266j = aVar2;
        this.f9267k = i3;
        int i4 = 0;
        int length = iArr == null ? 0 : iArr.length;
        this.f9273q = new x[length];
        this.f9263g = new boolean[length];
        int i5 = length + 1;
        int[] iArr2 = new int[i5];
        x[] xVarArr = new x[i5];
        this.f9272p = new x(bVar);
        iArr2[0] = i2;
        xVarArr[0] = this.f9272p;
        while (i4 < length) {
            x xVar = new x(bVar);
            this.f9273q[i4] = xVar;
            int i6 = i4 + 1;
            xVarArr[i6] = xVar;
            iArr2[i6] = iArr[i4];
            i4 = i6;
        }
        this.f9274r = new com.anythink.expressad.exoplayer.h.b.b(iArr2, xVarArr);
        this.f9277u = j2;
        this.f9278v = j2;
    }

    private T f() {
        return this.f9264h;
    }

    private long h() {
        return this.f9264h.a();
    }

    private void i() {
        this.f9276t = null;
        this.f9272p.j();
        for (x xVar : this.f9273q) {
            xVar.j();
        }
        this.f9268l.a(this);
    }

    private com.anythink.expressad.exoplayer.h.b.a j() {
        return this.f9270n.get(r0.size() - 1);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ int a(t.c cVar, long j2, long j3, IOException iOException) {
        boolean z2;
        c cVar2 = (c) cVar;
        long jD = cVar2.d();
        boolean z3 = cVar2 instanceof com.anythink.expressad.exoplayer.h.b.a;
        int size = this.f9270n.size() - 1;
        boolean z4 = (jD != 0 && z3 && a(size)) ? false : true;
        if (this.f9264h.f() && z4) {
            if (z3) {
                com.anythink.expressad.exoplayer.k.a.b(d(size) == cVar2);
                if (this.f9270n.isEmpty()) {
                    this.f9277u = this.f9278v;
                }
            }
            z2 = true;
        } else {
            z2 = false;
        }
        this.f9266j.a(cVar2.b, cVar2.f9243c, this.a, cVar2.f9244d, cVar2.f9245e, cVar2.f9246f, cVar2.f9247g, cVar2.f9248h, j2, j3, jD, iOException, z2);
        if (!z2) {
            return 0;
        }
        this.f9265i.a(this);
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final void a_(long j2) {
        int size;
        int iC;
        if (this.f9268l.a() || a() || (size = this.f9270n.size()) <= (iC = this.f9264h.c())) {
            return;
        }
        while (true) {
            if (iC >= size) {
                iC = size;
                break;
            } else if (!a(iC)) {
                break;
            } else {
                iC++;
            }
        }
        if (iC == size) {
            return;
        }
        long j3 = j().f9248h;
        com.anythink.expressad.exoplayer.h.b.a aVarD = d(iC);
        if (this.f9270n.isEmpty()) {
            this.f9277u = this.f9278v;
        }
        this.f9260c = false;
        this.f9266j.a(this.a, aVarD.f9247g, j3);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.d
    public final void g() {
        this.f9272p.a();
        for (x xVar : this.f9273q) {
            xVar.a();
        }
    }

    private void b(long j2) {
        boolean zB;
        this.f9278v = j2;
        this.f9272p.i();
        if (a()) {
            zB = false;
        } else {
            com.anythink.expressad.exoplayer.h.b.a aVar = null;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f9270n.size()) {
                    break;
                }
                com.anythink.expressad.exoplayer.h.b.a aVar2 = this.f9270n.get(i2);
                long j3 = aVar2.f9247g;
                if (j3 == j2 && aVar2.a == com.anythink.expressad.exoplayer.b.b) {
                    aVar = aVar2;
                    break;
                } else if (j3 > j2) {
                    break;
                } else {
                    i2++;
                }
            }
            if (aVar != null) {
                zB = this.f9272p.b(aVar.a(0));
                this.b = Long.MIN_VALUE;
            } else {
                boolean z2 = this.f9272p.a(j2, (j2 > e() ? 1 : (j2 == e() ? 0 : -1)) < 0) != -1;
                this.b = this.f9278v;
                zB = z2;
            }
        }
        if (zB) {
            for (x xVar : this.f9273q) {
                xVar.i();
                xVar.a(j2, false);
            }
            return;
        }
        this.f9277u = j2;
        this.f9260c = false;
        this.f9270n.clear();
        if (this.f9268l.a()) {
            this.f9268l.b();
            return;
        }
        this.f9272p.a();
        for (x xVar2 : this.f9273q) {
            xVar2.a();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final void c() throws IOException {
        this.f9268l.c();
        this.f9268l.a();
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long d() {
        if (this.f9260c) {
            return Long.MIN_VALUE;
        }
        if (a()) {
            return this.f9277u;
        }
        long jMax = this.f9278v;
        com.anythink.expressad.exoplayer.h.b.a aVarJ = j();
        if (!aVarJ.f()) {
            if (this.f9270n.size() > 1) {
                aVarJ = this.f9270n.get(r2.size() - 2);
            } else {
                aVarJ = null;
            }
        }
        if (aVarJ != null) {
            jMax = Math.max(jMax, aVarJ.f9248h);
        }
        return Math.max(jMax, this.f9272p.g());
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long e() {
        if (a()) {
            return this.f9277u;
        }
        if (this.f9260c) {
            return Long.MIN_VALUE;
        }
        return j().f9248h;
    }

    public final class a implements y {
        public final f<T> a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final x f9279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f9280d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f9281e;

        public a(f<T> fVar, x xVar, int i2) {
            this.a = fVar;
            this.f9279c = xVar;
            this.f9280d = i2;
        }

        private void d() {
            if (this.f9281e) {
                return;
            }
            f.this.f9266j.a(f.this.f9261e[this.f9280d], f.this.f9262f[this.f9280d], 0, (Object) null, f.this.f9278v);
            this.f9281e = true;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j2) {
            int iA;
            if (!f.this.f9260c || j2 <= this.f9279c.g()) {
                iA = this.f9279c.a(j2, true);
                if (iA == -1) {
                    iA = 0;
                }
            } else {
                iA = this.f9279c.k();
            }
            if (iA > 0) {
                d();
            }
            return iA;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            f fVar = f.this;
            if (fVar.f9260c) {
                return true;
            }
            return !fVar.a() && this.f9279c.c();
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() {
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z2) {
            if (f.this.a()) {
                return -3;
            }
            x xVar = this.f9279c;
            f fVar = f.this;
            int iA = xVar.a(nVar, eVar, z2, fVar.f9260c, fVar.b);
            if (iA == -4) {
                d();
            }
            return iA;
        }

        private void a() {
            com.anythink.expressad.exoplayer.k.a.b(f.this.f9263g[this.f9280d]);
            f.this.f9263g[this.f9280d] = false;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j2) {
        if (this.f9260c || this.f9268l.a()) {
            return false;
        }
        boolean zA = a();
        if (!zA) {
            j();
        }
        e eVar = this.f9269m;
        boolean z2 = eVar.b;
        c cVar = eVar.a;
        eVar.a = null;
        eVar.b = false;
        if (z2) {
            this.f9277u = com.anythink.expressad.exoplayer.b.b;
            this.f9260c = true;
            return true;
        }
        if (cVar == null) {
            return false;
        }
        if (cVar instanceof com.anythink.expressad.exoplayer.h.b.a) {
            com.anythink.expressad.exoplayer.h.b.a aVar = (com.anythink.expressad.exoplayer.h.b.a) cVar;
            if (zA) {
                this.b = aVar.f9247g == this.f9277u ? Long.MIN_VALUE : this.f9277u;
                this.f9277u = com.anythink.expressad.exoplayer.b.b;
            }
            aVar.a(this.f9274r);
            this.f9270n.add(aVar);
        }
        this.f9266j.a(cVar.b, cVar.f9243c, this.a, cVar.f9244d, cVar.f9245e, cVar.f9246f, cVar.f9247g, cVar.f9248h, this.f9268l.a(cVar, this, this.f9267k));
        return true;
    }

    private com.anythink.expressad.exoplayer.h.b.a d(int i2) {
        com.anythink.expressad.exoplayer.h.b.a aVar = this.f9270n.get(i2);
        ArrayList<com.anythink.expressad.exoplayer.h.b.a> arrayList = this.f9270n;
        af.a((List) arrayList, i2, arrayList.size());
        int i3 = 0;
        this.f9272p.a(aVar.a(0));
        while (true) {
            x[] xVarArr = this.f9273q;
            if (i3 >= xVarArr.length) {
                return aVar;
            }
            x xVar = xVarArr[i3];
            i3++;
            xVar.a(aVar.a(i3));
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(t.c cVar, long j2, long j3) {
        c cVar2 = (c) cVar;
        this.f9266j.a(cVar2.b, cVar2.f9243c, this.a, cVar2.f9244d, cVar2.f9245e, cVar2.f9246f, cVar2.f9247g, cVar2.f9248h, j2, j3, cVar2.d());
        this.f9265i.a(this);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(t.c cVar, long j2, long j3, boolean z2) {
        c cVar2 = (c) cVar;
        this.f9266j.b(cVar2.b, cVar2.f9243c, this.a, cVar2.f9244d, cVar2.f9245e, cVar2.f9246f, cVar2.f9247g, cVar2.f9248h, j2, j3, cVar2.d());
        if (z2) {
            return;
        }
        this.f9272p.a();
        for (x xVar : this.f9273q) {
            xVar.a();
        }
        this.f9265i.a(this);
    }

    private void c(int i2) {
        com.anythink.expressad.exoplayer.h.b.a aVar = this.f9270n.get(i2);
        m mVar = aVar.f9244d;
        if (!mVar.equals(this.f9275s)) {
            this.f9266j.a(this.a, mVar, aVar.f9245e, aVar.f9246f, aVar.f9247g);
        }
        this.f9275s = mVar;
    }

    private void a(long j2, boolean z2) {
        int iD = this.f9272p.d();
        this.f9272p.a(j2, z2, true);
        int iD2 = this.f9272p.d();
        if (iD2 > iD) {
            long jH = this.f9272p.h();
            int i2 = 0;
            while (true) {
                x[] xVarArr = this.f9273q;
                if (i2 >= xVarArr.length) {
                    break;
                }
                xVarArr[i2].a(jH, z2, this.f9263g[i2]);
                i2++;
            }
            int iB = b(iD2, 0);
            if (iB > 0) {
                af.a((List) this.f9270n, 0, iB);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final boolean b() {
        if (this.f9260c) {
            return true;
        }
        return !a() && this.f9272p.c();
    }

    private void b(int i2) {
        int iB = b(i2, 0);
        if (iB > 0) {
            af.a((List) this.f9270n, 0, iB);
        }
    }

    private int b(int i2, int i3) {
        do {
            i3++;
            if (i3 >= this.f9270n.size()) {
                return this.f9270n.size() - 1;
            }
        } while (this.f9270n.get(i3).a(0) <= i2);
        return i3 - 1;
    }

    private f<T>.a a(long j2, int i2) {
        for (int i3 = 0; i3 < this.f9273q.length; i3++) {
            if (this.f9261e[i3] == i2) {
                com.anythink.expressad.exoplayer.k.a.b(!this.f9263g[i3]);
                this.f9263g[i3] = true;
                this.f9273q[i3].i();
                this.f9273q[i3].a(j2, true);
                return new a(this, this.f9273q[i3], i3);
            }
        }
        throw new IllegalStateException();
    }

    private void a(@Nullable b<T> bVar) {
        this.f9276t = bVar;
        this.f9272p.j();
        for (x xVar : this.f9273q) {
            xVar.j();
        }
        this.f9268l.a(this);
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final int a(n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z2) {
        if (a()) {
            return -3;
        }
        int iA = this.f9272p.a(nVar, eVar, z2, this.f9260c, this.b);
        if (iA == -4) {
            a(this.f9272p.e(), 1);
        }
        return iA;
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final int a(long j2) {
        int iK = 0;
        if (a()) {
            return 0;
        }
        if (this.f9260c && j2 > this.f9272p.g()) {
            iK = this.f9272p.k();
        } else {
            int iA = this.f9272p.a(j2, true);
            if (iA != -1) {
                iK = iA;
            }
        }
        if (iK > 0) {
            a(this.f9272p.e(), iK);
        }
        return iK;
    }

    private void a(c cVar, long j2, long j3) {
        this.f9266j.a(cVar.b, cVar.f9243c, this.a, cVar.f9244d, cVar.f9245e, cVar.f9246f, cVar.f9247g, cVar.f9248h, j2, j3, cVar.d());
        this.f9265i.a(this);
    }

    private void a(c cVar, long j2, long j3, boolean z2) {
        this.f9266j.b(cVar.b, cVar.f9243c, this.a, cVar.f9244d, cVar.f9245e, cVar.f9246f, cVar.f9247g, cVar.f9248h, j2, j3, cVar.d());
        if (z2) {
            return;
        }
        this.f9272p.a();
        for (x xVar : this.f9273q) {
            xVar.a();
        }
        this.f9265i.a(this);
    }

    private int a(c cVar, long j2, long j3, IOException iOException) {
        boolean z2;
        long jD = cVar.d();
        boolean z3 = cVar instanceof com.anythink.expressad.exoplayer.h.b.a;
        int size = this.f9270n.size() - 1;
        boolean z4 = (jD != 0 && z3 && a(size)) ? false : true;
        if (this.f9264h.f() && z4) {
            if (z3) {
                com.anythink.expressad.exoplayer.k.a.b(d(size) == cVar);
                if (this.f9270n.isEmpty()) {
                    this.f9277u = this.f9278v;
                }
            }
            z2 = true;
        } else {
            z2 = false;
        }
        this.f9266j.a(cVar.b, cVar.f9243c, this.a, cVar.f9244d, cVar.f9245e, cVar.f9246f, cVar.f9247g, cVar.f9248h, j2, j3, jD, iOException, z2);
        if (!z2) {
            return 0;
        }
        this.f9265i.a(this);
        return 2;
    }

    private static boolean a(c cVar) {
        return cVar instanceof com.anythink.expressad.exoplayer.h.b.a;
    }

    private boolean a(int i2) {
        int iE;
        com.anythink.expressad.exoplayer.h.b.a aVar = this.f9270n.get(i2);
        if (this.f9272p.e() > aVar.a(0)) {
            return true;
        }
        int i3 = 0;
        do {
            x[] xVarArr = this.f9273q;
            if (i3 >= xVarArr.length) {
                return false;
            }
            iE = xVarArr[i3].e();
            i3++;
        } while (iE <= aVar.a(i3));
        return true;
    }

    final boolean a() {
        return this.f9277u != com.anythink.expressad.exoplayer.b.b;
    }

    private void a(int i2, int i3) {
        int iB = b(i2 - i3, 0);
        int iB2 = i3 == 1 ? iB : b(i2 - 1, iB);
        while (iB <= iB2) {
            c(iB);
            iB++;
        }
    }
}

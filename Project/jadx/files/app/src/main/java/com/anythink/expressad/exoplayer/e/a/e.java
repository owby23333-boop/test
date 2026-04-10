package com.anythink.expressad.exoplayer.e.a;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.d.e;
import com.anythink.expressad.exoplayer.e.a.a;
import com.anythink.expressad.exoplayer.e.k;
import com.anythink.expressad.exoplayer.e.m;
import com.anythink.expressad.exoplayer.k.ac;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.o;
import com.anythink.expressad.exoplayer.k.p;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.t;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.anythink.expressad.exoplayer.e.e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8889e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8890f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8891g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f8892h = 16;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f8893i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f8894j = "FragmentedMp4Extractor";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f8898n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f8899o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f8900p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f8901q = 3;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f8902r = 4;

    @Nullable
    private final ac A;
    private final s B;
    private final byte[] C;
    private final ArrayDeque<a.C0187a> D;
    private final ArrayDeque<b> E;

    @Nullable
    private final com.anythink.expressad.exoplayer.e.m F;
    private int G;
    private int H;
    private long I;
    private int J;
    private s K;
    private long L;
    private int M;
    private long N;
    private long O;
    private long P;
    private c Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private com.anythink.expressad.exoplayer.e.g V;
    private com.anythink.expressad.exoplayer.e.m[] W;
    private com.anythink.expressad.exoplayer.e.m[] X;
    private boolean Y;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f8903s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private final j f8904t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final List<com.anythink.expressad.exoplayer.m> f8905u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private final com.anythink.expressad.exoplayer.d.e f8906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final SparseArray<c> f8907w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final s f8908x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final s f8909y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final s f8910z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.anythink.expressad.exoplayer.e.h f8888d = new com.anythink.expressad.exoplayer.e.h() { // from class: com.anythink.expressad.exoplayer.e.a.e.1
        @Override // com.anythink.expressad.exoplayer.e.h
        public final com.anythink.expressad.exoplayer.e.e[] a() {
            return new com.anythink.expressad.exoplayer.e.e[]{new e()};
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f8895k = af.f("seig");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final byte[] f8896l = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final com.anythink.expressad.exoplayer.m f8897m = com.anythink.expressad.exoplayer.m.a((String) null, o.ai);

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    private static final class b {
        public final long a;
        public final int b;

        public b(long j2, int i2) {
            this.a = j2;
            this.b = i2;
        }
    }

    public e() {
        this(0);
    }

    private boolean b(com.anythink.expressad.exoplayer.e.f fVar) throws t {
        if (this.J == 0) {
            if (!fVar.a(this.B.a, 0, 8, true)) {
                return false;
            }
            this.J = 8;
            this.B.c(0);
            this.I = this.B.h();
            this.H = this.B.i();
        }
        long j2 = this.I;
        if (j2 == 1) {
            fVar.b(this.B.a, 8, 8);
            this.J += 8;
            this.I = this.B.n();
        } else if (j2 == 0) {
            long jD = fVar.d();
            if (jD == -1 && !this.D.isEmpty()) {
                jD = this.D.peek().aV;
            }
            if (jD != -1) {
                this.I = (jD - fVar.c()) + ((long) this.J);
            }
        }
        if (this.I < this.J) {
            throw new t("Atom size less than header length (unsupported).");
        }
        long jC = fVar.c() - ((long) this.J);
        if (this.H == com.anythink.expressad.exoplayer.e.a.a.P) {
            int size = this.f8907w.size();
            for (int i2 = 0; i2 < size; i2++) {
                l lVar = this.f8907w.valueAt(i2).b;
                lVar.b = jC;
                lVar.f8985d = jC;
                lVar.f8984c = jC;
            }
        }
        int i3 = this.H;
        if (i3 == com.anythink.expressad.exoplayer.e.a.a.f8846m) {
            this.Q = null;
            this.L = this.I + jC;
            if (!this.Y) {
                this.V.a(new k.b(this.O, jC));
                this.Y = true;
            }
            this.G = 2;
            return true;
        }
        if (i3 == com.anythink.expressad.exoplayer.e.a.a.G || i3 == com.anythink.expressad.exoplayer.e.a.a.I || i3 == com.anythink.expressad.exoplayer.e.a.a.J || i3 == com.anythink.expressad.exoplayer.e.a.a.K || i3 == com.anythink.expressad.exoplayer.e.a.a.L || i3 == com.anythink.expressad.exoplayer.e.a.a.P || i3 == com.anythink.expressad.exoplayer.e.a.a.Q || i3 == com.anythink.expressad.exoplayer.e.a.a.R || i3 == com.anythink.expressad.exoplayer.e.a.a.U) {
            long jC2 = (fVar.c() + this.I) - 8;
            this.D.push(new a.C0187a(this.H, jC2));
            if (this.I == this.J) {
                a(jC2);
            } else {
                a();
            }
        } else {
            int i4 = this.H;
            if (i4 == com.anythink.expressad.exoplayer.e.a.a.X || i4 == com.anythink.expressad.exoplayer.e.a.a.W || i4 == com.anythink.expressad.exoplayer.e.a.a.H || i4 == com.anythink.expressad.exoplayer.e.a.a.F || i4 == com.anythink.expressad.exoplayer.e.a.a.Y || i4 == com.anythink.expressad.exoplayer.e.a.a.B || i4 == com.anythink.expressad.exoplayer.e.a.a.C || i4 == com.anythink.expressad.exoplayer.e.a.a.T || i4 == com.anythink.expressad.exoplayer.e.a.a.D || i4 == com.anythink.expressad.exoplayer.e.a.a.E || i4 == com.anythink.expressad.exoplayer.e.a.a.Z || i4 == com.anythink.expressad.exoplayer.e.a.a.ah || i4 == com.anythink.expressad.exoplayer.e.a.a.ai || i4 == com.anythink.expressad.exoplayer.e.a.a.am || i4 == com.anythink.expressad.exoplayer.e.a.a.al || i4 == com.anythink.expressad.exoplayer.e.a.a.aj || i4 == com.anythink.expressad.exoplayer.e.a.a.ak || i4 == com.anythink.expressad.exoplayer.e.a.a.V || i4 == com.anythink.expressad.exoplayer.e.a.a.S || i4 == com.anythink.expressad.exoplayer.e.a.a.aL) {
                if (this.J != 8) {
                    throw new t("Leaf atom defines extended atom size (unsupported).");
                }
                long j3 = this.I;
                if (j3 > 2147483647L) {
                    throw new t("Leaf atom with length > 2147483647 (unsupported).");
                }
                this.K = new s((int) j3);
                System.arraycopy(this.B.a, 0, this.K.a, 0, 8);
                this.G = 1;
            } else {
                if (this.I > 2147483647L) {
                    throw new t("Skipping atom with length > 2147483647 (unsupported).");
                }
                this.K = null;
                this.G = 1;
            }
        }
        return true;
    }

    private void c(com.anythink.expressad.exoplayer.e.f fVar) throws t {
        long jN;
        long jN2;
        int i2 = ((int) this.I) - this.J;
        s sVar = this.K;
        if (sVar != null) {
            fVar.b(sVar.a, 8, i2);
            a.b bVar = new a.b(this.H, this.K);
            long jC = fVar.c();
            if (this.D.isEmpty()) {
                int i3 = bVar.aU;
                int i4 = 0;
                if (i3 == com.anythink.expressad.exoplayer.e.a.a.F) {
                    s sVar2 = bVar.aV;
                    sVar2.c(8);
                    int iA = com.anythink.expressad.exoplayer.e.a.a.a(sVar2.i());
                    sVar2.d(4);
                    long jH = sVar2.h();
                    if (iA == 0) {
                        jN = sVar2.h();
                        jN2 = sVar2.h();
                    } else {
                        jN = sVar2.n();
                        jN2 = sVar2.n();
                    }
                    long j2 = jC + jN2;
                    long j3 = jN;
                    long jA = af.a(j3, 1000000L, jH);
                    sVar2.d(2);
                    int iE = sVar2.e();
                    int[] iArr = new int[iE];
                    long[] jArr = new long[iE];
                    long[] jArr2 = new long[iE];
                    long[] jArr3 = new long[iE];
                    long j4 = jA;
                    while (i4 < iE) {
                        int i5 = sVar2.i();
                        if ((i5 & Integer.MIN_VALUE) != 0) {
                            throw new t("Unhandled indirect reference");
                        }
                        long jH2 = sVar2.h();
                        iArr[i4] = i5 & Integer.MAX_VALUE;
                        jArr[i4] = j2;
                        jArr3[i4] = j4;
                        long j5 = j3 + jH2;
                        long[] jArr4 = jArr3;
                        long[] jArr5 = jArr2;
                        long jA2 = af.a(j5, 1000000L, jH);
                        jArr5[i4] = jA2 - jArr4[i4];
                        sVar2.d(4);
                        j2 += (long) iArr[i4];
                        i4++;
                        jArr = jArr;
                        jArr3 = jArr4;
                        jArr2 = jArr5;
                        j4 = jA2;
                        iE = iE;
                        j3 = j5;
                    }
                    Pair pairCreate = Pair.create(Long.valueOf(jA), new com.anythink.expressad.exoplayer.e.a(iArr, jArr, jArr2, jArr3));
                    this.P = ((Long) pairCreate.first).longValue();
                    this.V.a((com.anythink.expressad.exoplayer.e.k) pairCreate.second);
                    this.Y = true;
                } else if (i3 == com.anythink.expressad.exoplayer.e.a.a.aL) {
                    s sVar3 = bVar.aV;
                    com.anythink.expressad.exoplayer.e.m[] mVarArr = this.W;
                    if (mVarArr != null && mVarArr.length != 0) {
                        sVar3.c(12);
                        int iA2 = sVar3.a();
                        sVar3.p();
                        sVar3.p();
                        long jA3 = af.a(sVar3.h(), 1000000L, sVar3.h());
                        for (com.anythink.expressad.exoplayer.e.m mVar : this.W) {
                            sVar3.c(12);
                            mVar.a(sVar3, iA2);
                        }
                        long j6 = this.P;
                        if (j6 != com.anythink.expressad.exoplayer.b.b) {
                            long jB = j6 + jA3;
                            ac acVar = this.A;
                            if (acVar != null) {
                                jB = acVar.b(jB);
                            }
                            com.anythink.expressad.exoplayer.e.m[] mVarArr2 = this.W;
                            int length = mVarArr2.length;
                            while (i4 < length) {
                                mVarArr2[i4].a(jB, 1, iA2, 0, null);
                                i4++;
                            }
                        } else {
                            this.E.addLast(new b(jA3, iA2));
                            this.M += iA2;
                        }
                    }
                }
            } else {
                this.D.peek().a(bVar);
            }
        } else {
            fVar.c(i2);
        }
        a(fVar.c());
    }

    private static long d(s sVar) {
        sVar.c(8);
        return com.anythink.expressad.exoplayer.e.a.a.a(sVar.i()) == 1 ? sVar.n() : sVar.h();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean e(com.anythink.expressad.exoplayer.e.f fVar) throws t {
        int i2;
        m.a aVar;
        int iA;
        int i3 = 1;
        if (this.G == 3) {
            if (this.Q == null) {
                SparseArray<c> sparseArray = this.f8907w;
                int size = sparseArray.size();
                long j2 = Long.MAX_VALUE;
                c cVar = null;
                for (int i4 = 0; i4 < size; i4++) {
                    c cVarValueAt = sparseArray.valueAt(i4);
                    int i5 = cVarValueAt.f8915g;
                    l lVar = cVarValueAt.b;
                    if (i5 != lVar.f8986e) {
                        long j3 = lVar.f8988g[i5];
                        if (j3 < j2) {
                            cVar = cVarValueAt;
                            j2 = j3;
                        }
                    }
                }
                if (cVar == null) {
                    int iC = (int) (this.L - fVar.c());
                    if (iC < 0) {
                        throw new t("Offset to end of mdat was negative.");
                    }
                    fVar.c(iC);
                    a();
                    return false;
                }
                int iC2 = (int) (cVar.b.f8988g[cVar.f8915g] - fVar.c());
                if (iC2 < 0) {
                    iC2 = 0;
                }
                fVar.c(iC2);
                this.Q = cVar;
            }
            c cVar2 = this.Q;
            int[] iArr = cVar2.b.f8990i;
            int i6 = cVar2.f8913e;
            this.R = iArr[i6];
            if (i6 < cVar2.f8916h) {
                fVar.c(this.R);
                c.a(this.Q);
                if (!this.Q.b()) {
                    this.Q = null;
                }
                this.G = 3;
                return true;
            }
            if (cVar2.f8911c.f8975i == 1) {
                this.R -= 8;
                fVar.c(8);
            }
            this.S = this.Q.c();
            this.R += this.S;
            this.G = 4;
            this.T = 0;
        }
        c cVar3 = this.Q;
        l lVar2 = cVar3.b;
        j jVar = cVar3.f8911c;
        com.anythink.expressad.exoplayer.e.m mVar = cVar3.a;
        int i7 = cVar3.f8913e;
        long jB = lVar2.b(i7) * 1000;
        ac acVar = this.A;
        if (acVar != null) {
            jB = acVar.b(jB);
        }
        long j4 = jB;
        int i8 = jVar.f8978l;
        if (i8 == 0) {
            while (true) {
                int i9 = this.S;
                int i10 = this.R;
                if (i9 >= i10) {
                    break;
                }
                this.S += mVar.a(fVar, i10 - i9, false);
            }
        } else {
            byte[] bArr = this.f8909y.a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i11 = i8 + 1;
            int i12 = 4 - i8;
            while (this.S < this.R) {
                int i13 = this.T;
                if (i13 == 0) {
                    fVar.b(bArr, i12, i11);
                    this.f8909y.c(0);
                    this.T = this.f8909y.m() - i3;
                    this.f8908x.c(0);
                    mVar.a(this.f8908x, 4);
                    mVar.a(this.f8909y, i3);
                    this.U = this.X.length > 0 && p.a(jVar.f8974h.f9990h, bArr[4]);
                    this.S += 5;
                    this.R += i12;
                } else {
                    if (this.U) {
                        this.f8910z.a(i13);
                        fVar.b(this.f8910z.a, 0, this.T);
                        mVar.a(this.f8910z, this.T);
                        iA = this.T;
                        s sVar = this.f8910z;
                        int iA2 = p.a(sVar.a, sVar.b());
                        this.f8910z.c(o.f9864i.equals(jVar.f8974h.f9990h) ? 1 : 0);
                        this.f8910z.b(iA2);
                    } else {
                        iA = mVar.a(fVar, i13, false);
                    }
                    this.S += iA;
                    this.T -= iA;
                    i3 = 1;
                }
            }
        }
        boolean z2 = lVar2.f8993l[i7];
        if (lVar2.f8994m) {
            int i14 = (z2 ? 1 : 0) | 1073741824;
            k kVarA = lVar2.f8996o;
            if (kVarA == null) {
                kVarA = jVar.a(lVar2.a.a);
            }
            i2 = i14;
            aVar = kVarA.f8981c;
        } else {
            i2 = z2 ? 1 : 0;
            aVar = null;
        }
        mVar.a(j4, i2, this.R, 0, aVar);
        while (!this.E.isEmpty()) {
            b bVarRemoveFirst = this.E.removeFirst();
            this.M -= bVarRemoveFirst.b;
            long jB2 = j4 + bVarRemoveFirst.a;
            ac acVar2 = this.A;
            if (acVar2 != null) {
                jB2 = acVar2.b(jB2);
            }
            for (com.anythink.expressad.exoplayer.e.m mVar2 : this.W) {
                mVar2.a(jB2, 1, bVarRemoveFirst.b, this.M, null);
            }
        }
        if (!this.Q.b()) {
            this.Q = null;
        }
        this.G = 3;
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final boolean a(com.anythink.expressad.exoplayer.e.f fVar) {
        return i.a(fVar);
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void c() {
    }

    public e(int i2) {
        this(i2, null);
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(com.anythink.expressad.exoplayer.e.g gVar) {
        this.V = gVar;
        j jVar = this.f8904t;
        if (jVar != null) {
            c cVar = new c(gVar.a(0, jVar.f8970d));
            cVar.a(this.f8904t, new com.anythink.expressad.exoplayer.e.a.c(0, 0, 0, 0));
            this.f8907w.put(0, cVar);
            b();
            this.V.c_();
        }
    }

    private e(int i2, @Nullable ac acVar) {
        this(i2, acVar, null, null);
    }

    private static final class c {
        public final com.anythink.expressad.exoplayer.e.m a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j f8911c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.anythink.expressad.exoplayer.e.a.c f8912d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8913e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8914f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8915g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8916h;
        public final l b = new l();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final s f8917i = new s(1);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final s f8918j = new s();

        public c(com.anythink.expressad.exoplayer.e.m mVar) {
            this.a = mVar;
        }

        private void d() {
            l lVar = this.b;
            if (lVar.f8994m) {
                s sVar = lVar.f8998q;
                int i2 = e().f8982d;
                if (i2 != 0) {
                    sVar.d(i2);
                }
                if (this.b.f8995n[this.f8913e]) {
                    sVar.d(sVar.e() * 6);
                }
            }
        }

        private k e() {
            l lVar = this.b;
            int i2 = lVar.a.a;
            k kVar = lVar.f8996o;
            return kVar != null ? kVar : this.f8911c.a(i2);
        }

        public final void a(j jVar, com.anythink.expressad.exoplayer.e.a.c cVar) {
            this.f8911c = (j) com.anythink.expressad.exoplayer.k.a.a(jVar);
            this.f8912d = (com.anythink.expressad.exoplayer.e.a.c) com.anythink.expressad.exoplayer.k.a.a(cVar);
            this.a.a(jVar.f8974h);
            a();
        }

        public final boolean b() {
            this.f8913e++;
            this.f8914f++;
            int i2 = this.f8914f;
            int[] iArr = this.b.f8989h;
            int i3 = this.f8915g;
            if (i2 != iArr[i3]) {
                return true;
            }
            this.f8915g = i3 + 1;
            this.f8914f = 0;
            return false;
        }

        public final int c() {
            s sVar;
            int length;
            if (!this.b.f8994m) {
                return 0;
            }
            k kVarE = e();
            int i2 = kVarE.f8982d;
            if (i2 != 0) {
                sVar = this.b.f8998q;
                length = i2;
            } else {
                byte[] bArr = kVarE.f8983e;
                this.f8918j.a(bArr, bArr.length);
                sVar = this.f8918j;
                length = bArr.length;
            }
            boolean z2 = this.b.f8995n[this.f8913e];
            this.f8917i.a[0] = (byte) ((z2 ? 128 : 0) | length);
            this.f8917i.c(0);
            this.a.a(this.f8917i, 1);
            this.a.a(sVar, length);
            if (!z2) {
                return length + 1;
            }
            s sVar2 = this.b.f8998q;
            int iE = sVar2.e();
            sVar2.d(-2);
            int i3 = (iE * 6) + 2;
            this.a.a(sVar2, i3);
            return length + 1 + i3;
        }

        public final void a(com.anythink.expressad.exoplayer.d.e eVar) {
            k kVarA = this.f8911c.a(this.b.a.a);
            this.a.a(this.f8911c.f8974h.a(eVar.a(kVarA != null ? kVarA.b : null)));
        }

        public final void a() {
            this.b.a();
            this.f8913e = 0;
            this.f8915g = 0;
            this.f8914f = 0;
            this.f8916h = 0;
        }

        public final void a(long j2) {
            long jA = com.anythink.expressad.exoplayer.b.a(j2);
            int i2 = this.f8913e;
            while (true) {
                l lVar = this.b;
                if (i2 >= lVar.f8987f || lVar.b(i2) >= jA) {
                    return;
                }
                if (this.b.f8993l[i2]) {
                    this.f8916h = i2;
                }
                i2++;
            }
        }

        static /* synthetic */ void a(c cVar) {
            l lVar = cVar.b;
            if (lVar.f8994m) {
                s sVar = lVar.f8998q;
                int i2 = cVar.e().f8982d;
                if (i2 != 0) {
                    sVar.d(i2);
                }
                if (cVar.b.f8995n[cVar.f8913e]) {
                    sVar.d(sVar.e() * 6);
                }
            }
        }
    }

    private e(int i2, @Nullable ac acVar, @Nullable j jVar, @Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        this(i2, acVar, jVar, eVar, Collections.emptyList());
    }

    private void d(com.anythink.expressad.exoplayer.e.f fVar) throws t {
        int size = this.f8907w.size();
        long j2 = Long.MAX_VALUE;
        c cVarValueAt = null;
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = this.f8907w.valueAt(i2).b;
            if (lVar.f8999r) {
                long j3 = lVar.f8985d;
                if (j3 < j2) {
                    cVarValueAt = this.f8907w.valueAt(i2);
                    j2 = j3;
                }
            }
        }
        if (cVarValueAt == null) {
            this.G = 3;
            return;
        }
        int iC = (int) (j2 - fVar.c());
        if (iC >= 0) {
            fVar.c(iC);
            l lVar2 = cVarValueAt.b;
            fVar.b(lVar2.f8998q.a, 0, lVar2.f8997p);
            lVar2.f8998q.c(0);
            lVar2.f8999r = false;
            return;
        }
        throw new t("Offset to encryption data was negative.");
    }

    private e(int i2, @Nullable ac acVar, @Nullable j jVar, @Nullable com.anythink.expressad.exoplayer.d.e eVar, List<com.anythink.expressad.exoplayer.m> list) {
        this(i2, acVar, jVar, eVar, list, null);
    }

    private e(int i2, @Nullable ac acVar, @Nullable j jVar, @Nullable com.anythink.expressad.exoplayer.d.e eVar, List<com.anythink.expressad.exoplayer.m> list, @Nullable com.anythink.expressad.exoplayer.e.m mVar) {
        this.f8903s = i2 | (jVar != null ? 8 : 0);
        this.A = acVar;
        this.f8904t = jVar;
        this.f8906v = eVar;
        this.f8905u = Collections.unmodifiableList(list);
        this.F = mVar;
        this.B = new s(16);
        this.f8908x = new s(p.a);
        this.f8909y = new s(5);
        this.f8910z = new s();
        this.C = new byte[16];
        this.D = new ArrayDeque<>();
        this.E = new ArrayDeque<>();
        this.f8907w = new SparseArray<>();
        this.O = com.anythink.expressad.exoplayer.b.b;
        this.N = com.anythink.expressad.exoplayer.b.b;
        this.P = com.anythink.expressad.exoplayer.b.b;
        a();
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(long j2, long j3) {
        int size = this.f8907w.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f8907w.valueAt(i2).a();
        }
        this.E.clear();
        this.M = 0;
        this.N = j3;
        this.D.clear();
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0223 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x05c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x05cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0192 A[LOOP:9: B:61:0x0192->B:63:0x0198, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x021a  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.anythink.expressad.exoplayer.e.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.anythink.expressad.exoplayer.e.f r26, com.anythink.expressad.exoplayer.e.j r27) throws com.anythink.expressad.exoplayer.t {
        /*
            Method dump skipped, instruction units count: 1497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.e.a(com.anythink.expressad.exoplayer.e.f, com.anythink.expressad.exoplayer.e.j):int");
    }

    private void b(a.C0187a c0187a) throws t {
        int i2;
        int i3;
        int i4 = 0;
        com.anythink.expressad.exoplayer.k.a.b(this.f8904t == null, "Unexpected moov box.");
        com.anythink.expressad.exoplayer.d.e eVarA = this.f8906v;
        if (eVarA == null) {
            eVarA = a(c0187a.aW);
        }
        a.C0187a c0187aE = c0187a.e(com.anythink.expressad.exoplayer.e.a.a.R);
        SparseArray sparseArray = new SparseArray();
        int size = c0187aE.aW.size();
        long jC = -9223372036854775807L;
        for (int i5 = 0; i5 < size; i5++) {
            a.b bVar = c0187aE.aW.get(i5);
            int i6 = bVar.aU;
            if (i6 == com.anythink.expressad.exoplayer.e.a.a.D) {
                Pair<Integer, com.anythink.expressad.exoplayer.e.a.c> pairB = b(bVar.aV);
                sparseArray.put(((Integer) pairB.first).intValue(), (com.anythink.expressad.exoplayer.e.a.c) pairB.second);
            } else if (i6 == com.anythink.expressad.exoplayer.e.a.a.S) {
                jC = c(bVar.aV);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c0187a.aX.size();
        int i7 = 0;
        while (i7 < size2) {
            a.C0187a c0187a2 = c0187a.aX.get(i7);
            if (c0187a2.aU == com.anythink.expressad.exoplayer.e.a.a.I) {
                i2 = i7;
                i3 = size2;
                j jVarA = com.anythink.expressad.exoplayer.e.a.b.a(c0187a2, c0187a.d(com.anythink.expressad.exoplayer.e.a.a.H), jC, eVarA, (this.f8903s & 16) != 0, false);
                if (jVarA != null) {
                    sparseArray2.put(jVarA.f8969c, jVarA);
                }
            } else {
                i2 = i7;
                i3 = size2;
            }
            i7 = i2 + 1;
            size2 = i3;
        }
        int size3 = sparseArray2.size();
        if (this.f8907w.size() == 0) {
            while (i4 < size3) {
                j jVar = (j) sparseArray2.valueAt(i4);
                c cVar = new c(this.V.a(i4, jVar.f8970d));
                cVar.a(jVar, a((SparseArray<com.anythink.expressad.exoplayer.e.a.c>) sparseArray, jVar.f8969c));
                this.f8907w.put(jVar.f8969c, cVar);
                this.O = Math.max(this.O, jVar.f8973g);
                i4++;
            }
            b();
            this.V.c_();
            return;
        }
        com.anythink.expressad.exoplayer.k.a.b(this.f8907w.size() == size3);
        while (i4 < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i4);
            this.f8907w.get(jVar2.f8969c).a(jVar2, a((SparseArray<com.anythink.expressad.exoplayer.e.a.c>) sparseArray, jVar2.f8969c));
            i4++;
        }
    }

    private void c(a.C0187a c0187a) throws t {
        a(c0187a, this.f8907w, this.f8903s, this.C);
        com.anythink.expressad.exoplayer.d.e eVarA = this.f8906v != null ? null : a(c0187a.aW);
        if (eVarA != null) {
            int size = this.f8907w.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f8907w.valueAt(i2).a(eVarA);
            }
        }
        if (this.N != com.anythink.expressad.exoplayer.b.b) {
            int size2 = this.f8907w.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f8907w.valueAt(i3).a(this.N);
            }
            this.N = com.anythink.expressad.exoplayer.b.b;
        }
    }

    private static long c(s sVar) {
        sVar.c(8);
        return com.anythink.expressad.exoplayer.e.a.a.a(sVar.i()) == 0 ? sVar.h() : sVar.n();
    }

    private void b() {
        int i2;
        if (this.W == null) {
            this.W = new com.anythink.expressad.exoplayer.e.m[2];
            com.anythink.expressad.exoplayer.e.m mVar = this.F;
            if (mVar != null) {
                this.W[0] = mVar;
                i2 = 1;
            } else {
                i2 = 0;
            }
            if ((this.f8903s & 4) != 0) {
                this.W[i2] = this.V.a(this.f8907w.size(), 4);
                i2++;
            }
            this.W = (com.anythink.expressad.exoplayer.e.m[]) Arrays.copyOf(this.W, i2);
            for (com.anythink.expressad.exoplayer.e.m mVar2 : this.W) {
                mVar2.a(f8897m);
            }
        }
        if (this.X == null) {
            this.X = new com.anythink.expressad.exoplayer.e.m[this.f8905u.size()];
            for (int i3 = 0; i3 < this.X.length; i3++) {
                com.anythink.expressad.exoplayer.e.m mVarA = this.V.a(this.f8907w.size() + 1 + i3, 3);
                mVarA.a(this.f8905u.get(i3));
                this.X[i3] = mVarA;
            }
        }
    }

    private static Pair<Integer, com.anythink.expressad.exoplayer.e.a.c> b(s sVar) {
        sVar.c(12);
        return Pair.create(Integer.valueOf(sVar.i()), new com.anythink.expressad.exoplayer.e.a.c(sVar.m() - 1, sVar.m(), sVar.m(), sVar.i()));
    }

    private static void b(a.C0187a c0187a, SparseArray<c> sparseArray, int i2, byte[] bArr) throws t {
        c cVarA = a(c0187a.d(com.anythink.expressad.exoplayer.e.a.a.C).aV, sparseArray);
        if (cVarA == null) {
            return;
        }
        l lVar = cVarA.b;
        long jD = lVar.f9000s;
        cVarA.a();
        if (c0187a.d(com.anythink.expressad.exoplayer.e.a.a.B) != null && (i2 & 2) == 0) {
            jD = d(c0187a.d(com.anythink.expressad.exoplayer.e.a.a.B).aV);
        }
        a(c0187a, cVarA, jD, i2);
        k kVarA = cVarA.f8911c.a(lVar.a.a);
        a.b bVarD = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.ah);
        if (bVarD != null) {
            a(kVarA, bVarD.aV, lVar);
        }
        a.b bVarD2 = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.ai);
        if (bVarD2 != null) {
            a(bVarD2.aV, lVar);
        }
        a.b bVarD3 = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.am);
        if (bVarD3 != null) {
            a(bVarD3.aV, 0, lVar);
        }
        a.b bVarD4 = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.aj);
        a.b bVarD5 = c0187a.d(com.anythink.expressad.exoplayer.e.a.a.ak);
        if (bVarD4 != null && bVarD5 != null) {
            a(bVarD4.aV, bVarD5.aV, kVarA != null ? kVarA.b : null, lVar);
        }
        int size = c0187a.aW.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = c0187a.aW.get(i3);
            if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.al) {
                a(bVar.aV, lVar, bArr);
            }
        }
    }

    @Nullable
    private static c b(SparseArray<c> sparseArray, int i2) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return sparseArray.get(i2);
    }

    private static void b(s sVar, l lVar) throws t {
        a(sVar, 0, lVar);
    }

    private void b(long j2) {
        while (!this.E.isEmpty()) {
            b bVarRemoveFirst = this.E.removeFirst();
            this.M -= bVarRemoveFirst.b;
            long jB = bVarRemoveFirst.a + j2;
            ac acVar = this.A;
            if (acVar != null) {
                jB = acVar.b(jB);
            }
            for (com.anythink.expressad.exoplayer.e.m mVar : this.W) {
                mVar.a(jB, 1, bVarRemoveFirst.b, this.M, null);
            }
        }
    }

    private static boolean b(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.G || i2 == com.anythink.expressad.exoplayer.e.a.a.I || i2 == com.anythink.expressad.exoplayer.e.a.a.J || i2 == com.anythink.expressad.exoplayer.e.a.a.K || i2 == com.anythink.expressad.exoplayer.e.a.a.L || i2 == com.anythink.expressad.exoplayer.e.a.a.P || i2 == com.anythink.expressad.exoplayer.e.a.a.Q || i2 == com.anythink.expressad.exoplayer.e.a.a.R || i2 == com.anythink.expressad.exoplayer.e.a.a.U;
    }

    private void a() {
        this.G = 0;
        this.J = 0;
    }

    private void a(long j2) throws t {
        while (!this.D.isEmpty() && this.D.peek().aV == j2) {
            a(this.D.pop());
        }
        a();
    }

    private void a(a.b bVar, long j2) throws t {
        long jN;
        long jN2;
        if (!this.D.isEmpty()) {
            this.D.peek().a(bVar);
            return;
        }
        int i2 = bVar.aU;
        int i3 = 0;
        if (i2 == com.anythink.expressad.exoplayer.e.a.a.F) {
            s sVar = bVar.aV;
            sVar.c(8);
            int iA = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
            sVar.d(4);
            long jH = sVar.h();
            if (iA == 0) {
                jN = sVar.h();
                jN2 = sVar.h();
            } else {
                jN = sVar.n();
                jN2 = sVar.n();
            }
            long j3 = jN;
            long j4 = j2 + jN2;
            long jA = af.a(j3, 1000000L, jH);
            sVar.d(2);
            int iE = sVar.e();
            int[] iArr = new int[iE];
            long[] jArr = new long[iE];
            long[] jArr2 = new long[iE];
            long[] jArr3 = new long[iE];
            long jA2 = jA;
            while (i3 < iE) {
                int i4 = sVar.i();
                if ((i4 & Integer.MIN_VALUE) == 0) {
                    long jH2 = sVar.h();
                    iArr[i3] = i4 & Integer.MAX_VALUE;
                    jArr[i3] = j4;
                    jArr3[i3] = jA2;
                    long j5 = j3 + jH2;
                    int i5 = iE;
                    long[] jArr4 = jArr2;
                    long[] jArr5 = jArr3;
                    int[] iArr2 = iArr;
                    jA2 = af.a(j5, 1000000L, jH);
                    jArr4[i3] = jA2 - jArr5[i3];
                    sVar.d(4);
                    j4 += (long) iArr2[i3];
                    i3++;
                    jArr3 = jArr5;
                    jArr2 = jArr4;
                    iArr = iArr2;
                    jArr = jArr;
                    j3 = j5;
                    iE = i5;
                } else {
                    throw new t("Unhandled indirect reference");
                }
            }
            Pair pairCreate = Pair.create(Long.valueOf(jA), new com.anythink.expressad.exoplayer.e.a(iArr, jArr, jArr2, jArr3));
            this.P = ((Long) pairCreate.first).longValue();
            this.V.a((com.anythink.expressad.exoplayer.e.k) pairCreate.second);
            this.Y = true;
            return;
        }
        if (i2 == com.anythink.expressad.exoplayer.e.a.a.aL) {
            s sVar2 = bVar.aV;
            com.anythink.expressad.exoplayer.e.m[] mVarArr = this.W;
            if (mVarArr == null || mVarArr.length == 0) {
                return;
            }
            sVar2.c(12);
            int iA2 = sVar2.a();
            sVar2.p();
            sVar2.p();
            long jA3 = af.a(sVar2.h(), 1000000L, sVar2.h());
            for (com.anythink.expressad.exoplayer.e.m mVar : this.W) {
                sVar2.c(12);
                mVar.a(sVar2, iA2);
            }
            long j6 = this.P;
            if (j6 != com.anythink.expressad.exoplayer.b.b) {
                long jB = j6 + jA3;
                ac acVar = this.A;
                if (acVar != null) {
                    jB = acVar.b(jB);
                }
                com.anythink.expressad.exoplayer.e.m[] mVarArr2 = this.W;
                int length = mVarArr2.length;
                while (i3 < length) {
                    mVarArr2[i3].a(jB, 1, iA2, 0, null);
                    i3++;
                }
                return;
            }
            this.E.addLast(new b(jA3, iA2));
            this.M += iA2;
        }
    }

    private void a(a.C0187a c0187a) throws t {
        int i2 = c0187a.aU;
        if (i2 == com.anythink.expressad.exoplayer.e.a.a.G) {
            b(c0187a);
        } else if (i2 == com.anythink.expressad.exoplayer.e.a.a.P) {
            c(c0187a);
        } else {
            if (this.D.isEmpty()) {
                return;
            }
            this.D.peek().a(c0187a);
        }
    }

    private static com.anythink.expressad.exoplayer.e.a.c a(SparseArray<com.anythink.expressad.exoplayer.e.a.c> sparseArray, int i2) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (com.anythink.expressad.exoplayer.e.a.c) com.anythink.expressad.exoplayer.k.a.a(sparseArray.get(i2));
    }

    private void a(s sVar) {
        com.anythink.expressad.exoplayer.e.m[] mVarArr = this.W;
        if (mVarArr == null || mVarArr.length == 0) {
            return;
        }
        sVar.c(12);
        int iA = sVar.a();
        sVar.p();
        sVar.p();
        long jA = af.a(sVar.h(), 1000000L, sVar.h());
        for (com.anythink.expressad.exoplayer.e.m mVar : this.W) {
            sVar.c(12);
            mVar.a(sVar, iA);
        }
        long j2 = this.P;
        if (j2 != com.anythink.expressad.exoplayer.b.b) {
            long j3 = j2 + jA;
            ac acVar = this.A;
            long jB = acVar != null ? acVar.b(j3) : j3;
            for (com.anythink.expressad.exoplayer.e.m mVar2 : this.W) {
                mVar2.a(jB, 1, iA, 0, null);
            }
            return;
        }
        this.E.addLast(new b(jA, iA));
        this.M += iA;
    }

    private static void a(a.C0187a c0187a, SparseArray<c> sparseArray, int i2, byte[] bArr) throws t {
        int size = c0187a.aX.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.C0187a c0187a2 = c0187a.aX.get(i3);
            if (c0187a2.aU == com.anythink.expressad.exoplayer.e.a.a.Q) {
                b(c0187a2, sparseArray, i2, bArr);
            }
        }
    }

    private static void a(a.C0187a c0187a, c cVar, long j2, int i2) {
        List<a.b> list = c0187a.aW;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            a.b bVar = list.get(i5);
            if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.E) {
                s sVar = bVar.aV;
                sVar.c(12);
                int iM = sVar.m();
                if (iM > 0) {
                    i4 += iM;
                    i3++;
                }
            }
        }
        cVar.f8915g = 0;
        cVar.f8914f = 0;
        cVar.f8913e = 0;
        cVar.b.a(i3, i4);
        int i6 = 0;
        int iA = 0;
        for (int i7 = 0; i7 < size; i7++) {
            a.b bVar2 = list.get(i7);
            if (bVar2.aU == com.anythink.expressad.exoplayer.e.a.a.E) {
                iA = a(cVar, i6, j2, i2, bVar2.aV, iA);
                i6++;
            }
        }
    }

    private static void a(k kVar, s sVar, l lVar) throws t {
        int i2;
        int i3 = kVar.f8982d;
        sVar.c(8);
        if ((com.anythink.expressad.exoplayer.e.a.a.b(sVar.i()) & 1) == 1) {
            sVar.d(8);
        }
        int iD = sVar.d();
        int iM = sVar.m();
        if (iM == lVar.f8987f) {
            if (iD == 0) {
                boolean[] zArr = lVar.f8995n;
                i2 = 0;
                for (int i4 = 0; i4 < iM; i4++) {
                    int iD2 = sVar.d();
                    i2 += iD2;
                    zArr[i4] = iD2 > i3;
                }
            } else {
                i2 = (iD * iM) + 0;
                Arrays.fill(lVar.f8995n, 0, iM, iD > i3);
            }
            lVar.a(i2);
            return;
        }
        throw new t("Length mismatch: " + iM + ", " + lVar.f8987f);
    }

    private static void a(s sVar, l lVar) throws t {
        sVar.c(8);
        int i2 = sVar.i();
        if ((com.anythink.expressad.exoplayer.e.a.a.b(i2) & 1) == 1) {
            sVar.d(8);
        }
        int iM = sVar.m();
        if (iM == 1) {
            lVar.f8985d += com.anythink.expressad.exoplayer.e.a.a.a(i2) == 0 ? sVar.h() : sVar.n();
            return;
        }
        throw new t("Unexpected saio entry count: ".concat(String.valueOf(iM)));
    }

    private static c a(s sVar, SparseArray<c> sparseArray) {
        sVar.c(8);
        int iB = com.anythink.expressad.exoplayer.e.a.a.b(sVar.i());
        c cVarB = b(sparseArray, sVar.i());
        if (cVarB == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jN = sVar.n();
            l lVar = cVarB.b;
            lVar.f8984c = jN;
            lVar.f8985d = jN;
        }
        com.anythink.expressad.exoplayer.e.a.c cVar = cVarB.f8912d;
        cVarB.b.a = new com.anythink.expressad.exoplayer.e.a.c((iB & 2) != 0 ? sVar.m() - 1 : cVar.a, (iB & 8) != 0 ? sVar.m() : cVar.b, (iB & 16) != 0 ? sVar.m() : cVar.f8882c, (iB & 32) != 0 ? sVar.m() : cVar.f8883d);
        return cVarB;
    }

    private static int a(c cVar, int i2, long j2, int i3, s sVar, int i4) {
        int iM;
        boolean z2;
        int iM2;
        boolean z3;
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        sVar.c(8);
        int iB = com.anythink.expressad.exoplayer.e.a.a.b(sVar.i());
        j jVar = cVar.f8911c;
        l lVar = cVar.b;
        com.anythink.expressad.exoplayer.e.a.c cVar2 = lVar.a;
        lVar.f8989h[i2] = sVar.m();
        long[] jArr = lVar.f8988g;
        jArr[i2] = lVar.f8984c;
        if ((iB & 1) != 0) {
            jArr[i2] = jArr[i2] + ((long) sVar.i());
        }
        boolean z7 = (iB & 4) != 0;
        int iM3 = cVar2.f8883d;
        if (z7) {
            iM3 = sVar.m();
        }
        boolean z8 = (iB & 256) != 0;
        boolean z9 = (iB & 512) != 0;
        boolean z10 = (iB & 1024) != 0;
        boolean z11 = (iB & 2048) != 0;
        long[] jArr2 = jVar.f8976j;
        long jA = 0;
        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
            jA = af.a(jVar.f8977k[0], 1000L, jVar.f8971e);
        }
        int[] iArr = lVar.f8990i;
        int[] iArr2 = lVar.f8991j;
        long[] jArr3 = lVar.f8992k;
        boolean[] zArr = lVar.f8993l;
        int i6 = iM3;
        boolean z12 = jVar.f8970d == 2 && (i3 & 1) != 0;
        int i7 = i4 + lVar.f8989h[i2];
        long j3 = jA;
        long j4 = jVar.f8971e;
        long j5 = i2 > 0 ? lVar.f9000s : j2;
        int i8 = i4;
        while (i8 < i7) {
            if (z8) {
                iM = sVar.m();
            } else {
                iM = cVar2.b;
            }
            if (z9) {
                z2 = z8;
                iM2 = sVar.m();
            } else {
                z2 = z8;
                iM2 = cVar2.f8882c;
            }
            if (i8 == 0 && z7) {
                z3 = z7;
                i5 = i6;
            } else if (z10) {
                z3 = z7;
                i5 = sVar.i();
            } else {
                z3 = z7;
                i5 = cVar2.f8883d;
            }
            if (z11) {
                z4 = z11;
                z5 = z9;
                z6 = z10;
                iArr2[i8] = (int) ((((long) sVar.i()) * 1000) / j4);
            } else {
                z4 = z11;
                z5 = z9;
                z6 = z10;
                iArr2[i8] = 0;
            }
            jArr3[i8] = af.a(j5, 1000L, j4) - j3;
            iArr[i8] = iM2;
            zArr[i8] = ((i5 >> 16) & 1) == 0 && (!z12 || i8 == 0);
            i8++;
            j5 += (long) iM;
            z8 = z2;
            z7 = z3;
            z11 = z4;
            z9 = z5;
            z10 = z6;
            i7 = i7;
        }
        int i9 = i7;
        lVar.f9000s = j5;
        return i9;
    }

    private static void a(s sVar, l lVar, byte[] bArr) throws t {
        sVar.c(8);
        sVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, f8896l)) {
            a(sVar, 16, lVar);
        }
    }

    private static void a(s sVar, int i2, l lVar) throws t {
        sVar.c(i2 + 8);
        int iB = com.anythink.expressad.exoplayer.e.a.a.b(sVar.i());
        if ((iB & 1) == 0) {
            boolean z2 = (iB & 2) != 0;
            int iM = sVar.m();
            if (iM == lVar.f8987f) {
                Arrays.fill(lVar.f8995n, 0, iM, z2);
                lVar.a(sVar.a());
                lVar.a(sVar);
                return;
            } else {
                throw new t("Length mismatch: " + iM + ", " + lVar.f8987f);
            }
        }
        throw new t("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    private static void a(s sVar, s sVar2, String str, l lVar) throws t {
        byte[] bArr;
        sVar.c(8);
        int i2 = sVar.i();
        if (sVar.i() != f8895k) {
            return;
        }
        if (com.anythink.expressad.exoplayer.e.a.a.a(i2) == 1) {
            sVar.d(4);
        }
        if (sVar.i() == 1) {
            sVar2.c(8);
            int i3 = sVar2.i();
            if (sVar2.i() != f8895k) {
                return;
            }
            int iA = com.anythink.expressad.exoplayer.e.a.a.a(i3);
            if (iA == 1) {
                if (sVar2.h() == 0) {
                    throw new t("Variable length description in sgpd found (unsupported)");
                }
            } else if (iA >= 2) {
                sVar2.d(4);
            }
            if (sVar2.h() == 1) {
                sVar2.d(1);
                int iD = sVar2.d();
                int i4 = (iD & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >> 4;
                int i5 = iD & 15;
                if (sVar2.d() == 1) {
                    int iD2 = sVar2.d();
                    byte[] bArr2 = new byte[16];
                    sVar2.a(bArr2, 0, 16);
                    if (iD2 == 0) {
                        int iD3 = sVar2.d();
                        byte[] bArr3 = new byte[iD3];
                        sVar2.a(bArr3, 0, iD3);
                        bArr = bArr3;
                    } else {
                        bArr = null;
                    }
                    lVar.f8994m = true;
                    lVar.f8996o = new k(true, str, iD2, bArr2, i4, i5, bArr);
                    return;
                }
                return;
            }
            throw new t("Entry count in sgpd != 1 (unsupported).");
        }
        throw new t("Entry count in sbgp != 1 (unsupported).");
    }

    private static Pair<Long, com.anythink.expressad.exoplayer.e.a> a(s sVar, long j2) throws t {
        long jN;
        long jN2;
        sVar.c(8);
        int iA = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        sVar.d(4);
        long jH = sVar.h();
        if (iA == 0) {
            jN = sVar.h();
            jN2 = sVar.h();
        } else {
            jN = sVar.n();
            jN2 = sVar.n();
        }
        long j3 = jN;
        long j4 = j2 + jN2;
        long jA = af.a(j3, 1000000L, jH);
        sVar.d(2);
        int iE = sVar.e();
        int[] iArr = new int[iE];
        long[] jArr = new long[iE];
        long[] jArr2 = new long[iE];
        long[] jArr3 = new long[iE];
        long j5 = j3;
        long jA2 = jA;
        int i2 = 0;
        while (i2 < iE) {
            int i3 = sVar.i();
            if ((i3 & Integer.MIN_VALUE) == 0) {
                long jH2 = sVar.h();
                iArr[i2] = i3 & Integer.MAX_VALUE;
                jArr[i2] = j4;
                jArr3[i2] = jA2;
                j5 += jH2;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i4 = iE;
                int[] iArr2 = iArr;
                jA2 = af.a(j5, 1000000L, jH);
                jArr4[i2] = jA2 - jArr5[i2];
                sVar.d(4);
                j4 += (long) iArr2[i2];
                i2++;
                iArr = iArr2;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                iE = i4;
            } else {
                throw new t("Unhandled indirect reference");
            }
        }
        return Pair.create(Long.valueOf(jA), new com.anythink.expressad.exoplayer.e.a(iArr, jArr, jArr2, jArr3));
    }

    private static c a(SparseArray<c> sparseArray) {
        int size = sparseArray.size();
        c cVar = null;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            c cVarValueAt = sparseArray.valueAt(i2);
            int i3 = cVarValueAt.f8915g;
            l lVar = cVarValueAt.b;
            if (i3 != lVar.f8986e) {
                long j3 = lVar.f8988g[i3];
                if (j3 < j2) {
                    cVar = cVarValueAt;
                    j2 = j3;
                }
            }
        }
        return cVar;
    }

    private static com.anythink.expressad.exoplayer.d.e a(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = list.get(i2);
            if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.Z) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.aV.a;
                UUID uuidA = h.a(bArr);
                if (uuidA != null) {
                    arrayList.add(new e.a(uuidA, o.f9860e, bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.d.e(arrayList);
    }

    private static boolean a(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.X || i2 == com.anythink.expressad.exoplayer.e.a.a.W || i2 == com.anythink.expressad.exoplayer.e.a.a.H || i2 == com.anythink.expressad.exoplayer.e.a.a.F || i2 == com.anythink.expressad.exoplayer.e.a.a.Y || i2 == com.anythink.expressad.exoplayer.e.a.a.B || i2 == com.anythink.expressad.exoplayer.e.a.a.C || i2 == com.anythink.expressad.exoplayer.e.a.a.T || i2 == com.anythink.expressad.exoplayer.e.a.a.D || i2 == com.anythink.expressad.exoplayer.e.a.a.E || i2 == com.anythink.expressad.exoplayer.e.a.a.Z || i2 == com.anythink.expressad.exoplayer.e.a.a.ah || i2 == com.anythink.expressad.exoplayer.e.a.a.ai || i2 == com.anythink.expressad.exoplayer.e.a.a.am || i2 == com.anythink.expressad.exoplayer.e.a.a.al || i2 == com.anythink.expressad.exoplayer.e.a.a.aj || i2 == com.anythink.expressad.exoplayer.e.a.a.ak || i2 == com.anythink.expressad.exoplayer.e.a.a.V || i2 == com.anythink.expressad.exoplayer.e.a.a.S || i2 == com.anythink.expressad.exoplayer.e.a.a.aL;
    }
}

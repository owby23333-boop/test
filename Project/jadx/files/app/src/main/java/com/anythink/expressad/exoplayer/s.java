package com.anythink.expressad.exoplayer;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.s;

/* JADX INFO: loaded from: classes2.dex */
final class s {
    private static final int a = 100;
    private final ae.a b = new ae.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ae.b f10029c = new ae.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ae f10031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private q f10034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private q f10035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private q f10036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10037k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Object f10038l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f10039m;

    private boolean i() {
        q qVar;
        q qVarE = e();
        if (qVarE == null) {
            return true;
        }
        while (true) {
            int iA = this.f10031e.a(qVarE.f10016h.a.a, this.b, this.f10029c, this.f10032f, this.f10033g);
            while (true) {
                q qVar2 = qVarE.f10017i;
                if (qVar2 == null || qVarE.f10016h.f10027f) {
                    break;
                }
                qVarE = qVar2;
            }
            if (iA == -1 || (qVar = qVarE.f10017i) == null || qVar.f10016h.a.a != iA) {
                break;
            }
            qVarE = qVar;
        }
        boolean zA = a(qVarE);
        r rVar = qVarE.f10016h;
        qVarE.f10016h = a(rVar, rVar.a);
        return (zA && f()) ? false : true;
    }

    public final void a(ae aeVar) {
        this.f10031e = aeVar;
    }

    public final q b() {
        return this.f10036j;
    }

    public final q c() {
        return this.f10034h;
    }

    public final q d() {
        return this.f10035i;
    }

    public final q e() {
        return f() ? this.f10034h : this.f10036j;
    }

    public final boolean f() {
        return this.f10034h != null;
    }

    public final q g() {
        q qVar = this.f10035i;
        com.anythink.expressad.exoplayer.k.a.b((qVar == null || qVar.f10017i == null) ? false : true);
        this.f10035i = this.f10035i.f10017i;
        return this.f10035i;
    }

    public final q h() {
        q qVar = this.f10034h;
        if (qVar != null) {
            if (qVar == this.f10035i) {
                this.f10035i = qVar.f10017i;
            }
            this.f10034h.c();
            this.f10037k--;
            if (this.f10037k == 0) {
                this.f10036j = null;
                q qVar2 = this.f10034h;
                this.f10038l = qVar2.b;
                this.f10039m = qVar2.f10016h.a.f9419d;
            }
            this.f10034h = this.f10034h.f10017i;
        } else {
            q qVar3 = this.f10036j;
            this.f10034h = qVar3;
            this.f10035i = qVar3;
        }
        return this.f10034h;
    }

    public final boolean a(int i2) {
        this.f10032f = i2;
        return i();
    }

    public final void b(boolean z2) {
        q qVarE = e();
        if (qVarE != null) {
            this.f10038l = z2 ? qVarE.b : null;
            this.f10039m = qVarE.f10016h.a.f9419d;
            qVarE.c();
            a(qVarE);
        } else if (!z2) {
            this.f10038l = null;
        }
        this.f10034h = null;
        this.f10036j = null;
        this.f10035i = null;
        this.f10037k = 0;
    }

    public final boolean a(boolean z2) {
        this.f10033g = z2;
        return i();
    }

    public final boolean a(com.anythink.expressad.exoplayer.h.r rVar) {
        q qVar = this.f10036j;
        return qVar != null && qVar.a == rVar;
    }

    public final void a(long j2) {
        q qVar = this.f10036j;
        if (qVar == null || !qVar.f10014f) {
            return;
        }
        qVar.a.a_(j2 - qVar.f10013e);
    }

    private long b(int i2) {
        int iA;
        Object obj = this.f10031e.a(i2, this.b, true).b;
        int i3 = this.b.f8469c;
        Object obj2 = this.f10038l;
        if (obj2 != null && (iA = this.f10031e.a(obj2)) != -1 && this.f10031e.a(iA, this.b, false).f8469c == i3) {
            return this.f10039m;
        }
        for (q qVarE = e(); qVarE != null; qVarE = qVarE.f10017i) {
            if (qVarE.b.equals(obj)) {
                return qVarE.f10016h.a.f9419d;
            }
        }
        for (q qVarE2 = e(); qVarE2 != null; qVarE2 = qVarE2.f10017i) {
            int iA2 = this.f10031e.a(qVarE2.b);
            if (iA2 != -1 && this.f10031e.a(iA2, this.b, false).f8469c == i3) {
                return qVarE2.f10016h.a.f9419d;
            }
        }
        long j2 = this.f10030d;
        this.f10030d = 1 + j2;
        return j2;
    }

    public final boolean a() {
        q qVar = this.f10036j;
        if (qVar != null) {
            return !qVar.f10016h.f10028g && qVar.a() && this.f10036j.f10016h.f10026e != b.b && this.f10037k < 100;
        }
        return true;
    }

    @Nullable
    public final r a(long j2, u uVar) {
        q qVar = this.f10036j;
        if (qVar == null) {
            return a(uVar.f10060c, uVar.f10062e, uVar.f10061d);
        }
        return a(qVar, j2);
    }

    public final com.anythink.expressad.exoplayer.h.r a(z[] zVarArr, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.j.b bVar, com.anythink.expressad.exoplayer.h.s sVar, Object obj, r rVar) {
        long j2;
        q qVar = this.f10036j;
        if (qVar == null) {
            j2 = rVar.b;
        } else {
            j2 = qVar.f10013e + qVar.f10016h.f10026e;
        }
        q qVar2 = new q(zVarArr, j2, hVar, bVar, sVar, obj, rVar);
        if (this.f10036j != null) {
            com.anythink.expressad.exoplayer.k.a.b(f());
            this.f10036j.f10017i = qVar2;
        }
        this.f10038l = null;
        this.f10036j = qVar2;
        this.f10037k++;
        return qVar2.a;
    }

    public final boolean a(q qVar) {
        boolean z2 = false;
        com.anythink.expressad.exoplayer.k.a.b(qVar != null);
        this.f10036j = qVar;
        while (true) {
            qVar = qVar.f10017i;
            if (qVar != null) {
                if (qVar == this.f10035i) {
                    this.f10035i = this.f10034h;
                    z2 = true;
                }
                qVar.c();
                this.f10037k--;
            } else {
                this.f10036j.f10017i = null;
                return z2;
            }
        }
    }

    private r b(int i2, long j2, long j3) {
        s.a aVar = new s.a(i2, j3);
        this.f10031e.a(aVar.a, this.b, false);
        int iB = this.b.b(j2);
        long jA = iB == -1 ? Long.MIN_VALUE : this.b.a(iB);
        boolean zB = b(aVar, jA);
        return new r(aVar, j2, jA, b.b, jA == Long.MIN_VALUE ? this.b.f8470d : jA, zB, a(aVar, zB));
    }

    public final boolean a(s.a aVar, long j2) {
        int iA = aVar.a;
        q qVar = null;
        q qVarE = e();
        while (qVarE != null) {
            if (qVar == null) {
                qVarE.f10016h = a(qVarE.f10016h, iA);
            } else {
                if (iA == -1 || !qVarE.b.equals(this.f10031e.a(iA, this.b, true).b)) {
                    return !a(qVar);
                }
                r rVarA = a(qVar, j2);
                if (rVarA == null) {
                    return !a(qVar);
                }
                qVarE.f10016h = a(qVarE.f10016h, iA);
                r rVar = qVarE.f10016h;
                if (!(rVar.b == rVarA.b && rVar.f10024c == rVarA.f10024c && rVar.a.equals(rVarA.a))) {
                    return !a(qVar);
                }
            }
            if (qVarE.f10016h.f10027f) {
                iA = this.f10031e.a(iA, this.b, this.f10029c, this.f10032f, this.f10033g);
            }
            q qVar2 = qVarE;
            qVarE = qVarE.f10017i;
            qVar = qVar2;
        }
        return true;
    }

    private boolean b(s.a aVar, long j2) {
        int iC = this.f10031e.a(aVar.a, this.b, false).c();
        if (iC == 0) {
            return true;
        }
        int i2 = iC - 1;
        boolean zA = aVar.a();
        if (this.b.a(i2) != Long.MIN_VALUE) {
            return !zA && j2 == Long.MIN_VALUE;
        }
        int iD = this.b.d(i2);
        if (iD == -1) {
            return false;
        }
        return (zA && aVar.b == i2 && aVar.f9418c == iD + (-1)) || (!zA && this.b.b(i2) == iD);
    }

    public final r a(r rVar, int i2) {
        return a(rVar, rVar.a.a(i2));
    }

    private s.a a(int i2, long j2, long j3) {
        this.f10031e.a(i2, this.b, false);
        int iA = this.b.a(j2);
        if (iA == -1) {
            return new s.a(i2, j3);
        }
        return new s.a(i2, iA, this.b.b(iA), j3);
    }

    private static boolean a(q qVar, r rVar) {
        r rVar2 = qVar.f10016h;
        return rVar2.b == rVar.b && rVar2.f10024c == rVar.f10024c && rVar2.a.equals(rVar.a);
    }

    private r a(u uVar) {
        return a(uVar.f10060c, uVar.f10062e, uVar.f10061d);
    }

    @Nullable
    private r a(q qVar, long j2) {
        int i2;
        long j3;
        long j4;
        r rVar = qVar.f10016h;
        if (rVar.f10027f) {
            int iA = this.f10031e.a(rVar.a.a, this.b, this.f10029c, this.f10032f, this.f10033g);
            if (iA == -1) {
                return null;
            }
            int i3 = this.f10031e.a(iA, this.b, true).f8469c;
            Object obj = this.b.b;
            long j5 = rVar.a.f9419d;
            long j6 = 0;
            if (this.f10031e.a(i3, this.f10029c, false).f8476f == iA) {
                Pair<Integer, Long> pairA = this.f10031e.a(this.f10029c, this.b, i3, b.b, Math.max(0L, (qVar.f10013e + rVar.f10026e) - j2));
                if (pairA == null) {
                    return null;
                }
                int iIntValue = ((Integer) pairA.first).intValue();
                long jLongValue = ((Long) pairA.second).longValue();
                q qVar2 = qVar.f10017i;
                if (qVar2 != null && qVar2.b.equals(obj)) {
                    j4 = qVar.f10017i.f10016h.a.f9419d;
                } else {
                    j4 = this.f10030d;
                    this.f10030d = 1 + j4;
                }
                j6 = jLongValue;
                j3 = j4;
                i2 = iIntValue;
            } else {
                i2 = iA;
                j3 = j5;
            }
            long j7 = j6;
            return a(a(i2, j7, j3), j7, j6);
        }
        s.a aVar = rVar.a;
        this.f10031e.a(aVar.a, this.b, false);
        if (aVar.a()) {
            int i4 = aVar.b;
            int iD = this.b.d(i4);
            if (iD == -1) {
                return null;
            }
            int iA2 = this.b.a(i4, aVar.f9418c);
            if (iA2 < iD) {
                if (this.b.b(i4, iA2)) {
                    return a(aVar.a, i4, iA2, rVar.f10025d, aVar.f9419d);
                }
                return null;
            }
            return b(aVar.a, rVar.f10025d, aVar.f9419d);
        }
        long j8 = rVar.f10024c;
        if (j8 != Long.MIN_VALUE) {
            int iA3 = this.b.a(j8);
            if (iA3 == -1) {
                return b(aVar.a, rVar.f10024c, aVar.f9419d);
            }
            int iB = this.b.b(iA3);
            if (this.b.b(iA3, iB)) {
                return a(aVar.a, iA3, iB, rVar.f10024c, aVar.f9419d);
            }
            return null;
        }
        int iC = this.b.c();
        if (iC == 0) {
            return null;
        }
        int i5 = iC - 1;
        if (this.b.a(i5) != Long.MIN_VALUE || this.b.c(i5)) {
            return null;
        }
        int iB2 = this.b.b(i5);
        if (!this.b.b(i5, iB2)) {
            return null;
        }
        return a(aVar.a, i5, iB2, this.b.f8470d, aVar.f9419d);
    }

    private r a(r rVar, s.a aVar) {
        long j2;
        long jC;
        long j3 = rVar.b;
        long j4 = rVar.f10024c;
        boolean zB = b(aVar, j4);
        boolean zA = a(aVar, zB);
        this.f10031e.a(aVar.a, this.b, false);
        if (aVar.a()) {
            jC = this.b.c(aVar.b, aVar.f9418c);
        } else if (j4 == Long.MIN_VALUE) {
            jC = this.b.f8470d;
        } else {
            j2 = j4;
            return new r(aVar, j3, j4, rVar.f10025d, j2, zB, zA);
        }
        j2 = jC;
        return new r(aVar, j3, j4, rVar.f10025d, j2, zB, zA);
    }

    private r a(s.a aVar, long j2, long j3) {
        this.f10031e.a(aVar.a, this.b, false);
        if (aVar.a()) {
            if (this.b.b(aVar.b, aVar.f9418c)) {
                return a(aVar.a, aVar.b, aVar.f9418c, j2, aVar.f9419d);
            }
            return null;
        }
        return b(aVar.a, j3, aVar.f9419d);
    }

    private r a(int i2, int i3, int i4, long j2, long j3) {
        s.a aVar = new s.a(i2, i3, i4, j3);
        boolean zB = b(aVar, Long.MIN_VALUE);
        boolean zA = a(aVar, zB);
        return new r(aVar, i4 == this.b.b(i3) ? this.b.d() : 0L, Long.MIN_VALUE, j2, this.f10031e.a(aVar.a, this.b, false).c(aVar.b, aVar.f9418c), zB, zA);
    }

    private boolean a(s.a aVar, boolean z2) {
        return !this.f10031e.a(this.f10031e.a(aVar.a, this.b, false).f8469c, this.f10029c, false).f8475e && this.f10031e.b(aVar.a, this.b, this.f10029c, this.f10032f, this.f10033g) && z2;
    }

    public final s.a a(int i2, long j2) {
        long j3;
        int iA;
        Object obj = this.f10031e.a(i2, this.b, true).b;
        int i3 = this.b.f8469c;
        Object obj2 = this.f10038l;
        if (obj2 != null && (iA = this.f10031e.a(obj2)) != -1 && this.f10031e.a(iA, this.b, false).f8469c == i3) {
            j3 = this.f10039m;
        } else {
            q qVarE = e();
            while (true) {
                if (qVarE != null) {
                    if (qVarE.b.equals(obj)) {
                        j3 = qVarE.f10016h.a.f9419d;
                        break;
                    }
                    qVarE = qVarE.f10017i;
                } else {
                    q qVarE2 = e();
                    while (true) {
                        if (qVarE2 != null) {
                            int iA2 = this.f10031e.a(qVarE2.b);
                            if (iA2 != -1 && this.f10031e.a(iA2, this.b, false).f8469c == i3) {
                                j3 = qVarE2.f10016h.a.f9419d;
                                break;
                            }
                            qVarE2 = qVarE2.f10017i;
                        } else {
                            j3 = this.f10030d;
                            this.f10030d = 1 + j3;
                            break;
                        }
                    }
                }
            }
        }
        return a(i2, j2, j3);
    }
}

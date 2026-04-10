package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class f implements d {
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.e a;
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b f1832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g f1833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c f1834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.f f1835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1839j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1840k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1841l;

    public f(Queue<String> queue) {
        j.l().e();
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.d()) {
            this.f1836g = j.l().f();
            this.a = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.e(this.f1836g, queue);
        }
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.b()) {
            this.f1838i = j.l().g();
            this.f1832c = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b(this.f1838i, queue);
        }
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a()) {
            this.f1837h = j.l().g();
            this.b = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a(this.f1837h, queue);
        }
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.f()) {
            this.f1839j = j.l().g();
            this.f1833d = new g(this.f1839j, queue);
        }
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.c()) {
            this.f1840k = j.l().c();
            this.f1834e = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c(this.f1840k, queue);
        }
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.e()) {
            this.f1841l = j.l().h();
            this.f1835f = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.f(this.f1841l, queue);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> a(int i2, int i3) {
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> listB;
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> listB2;
        AtomicLong atomicLongL;
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> listB3;
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.d() && this.a.a(i2, i3) && (listB2 = this.a.b(i2, i3)) != null && listB2.size() != 0) {
            atomicLongL = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.A();
        } else {
            if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.b() && this.f1832c.a(i2, i3) && (listB3 = this.f1832c.b(i2, i3)) != null && listB3.size() != 0) {
                return listB3;
            }
            if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a() && this.b.a(i2, i3) && (listB2 = this.b.b(i2, i3)) != null && listB2.size() != 0) {
                atomicLongL = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.c();
            } else if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.f() && this.f1833d.a(i2, i3) && (listB2 = this.f1833d.b(i2, i3)) != null && listB2.size() != 0) {
                atomicLongL = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.X();
            } else {
                if (!bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.c() || !this.f1834e.a(i2, i3) || (listB2 = this.f1834e.b(i2, i3)) == null || listB2.size() == 0) {
                    if (!bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.e() || !this.f1835f.a(i2, i3) || (listB = this.f1835f.b(i2, i3)) == null || listB.size() == 0) {
                        return null;
                    }
                    return listB;
                }
                atomicLongL = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.l();
            }
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(atomicLongL, 1);
        return listB2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list) {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d dVar;
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar = list.get(0);
        byte bE = aVar.e();
        byte b = aVar.b();
        if (b == 0 && bE == 1 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.d()) {
            dVar = this.a;
        } else if (b == 3 && bE == 2 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.b()) {
            dVar = this.f1832c;
        } else if (b == 0 && bE == 2 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a()) {
            dVar = this.b;
        } else if (b == 1 && bE == 2 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.f()) {
            dVar = this.f1833d;
        } else if (b == 1 && bE == 3 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.c()) {
            dVar = this.f1834e;
        } else if (b != 2 || bE != 3 || !bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.e()) {
            return;
        } else {
            dVar = this.f1835f;
        }
        dVar.a(i2, list);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, int i2) {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d dVar;
        try {
            byte b = aVar.b();
            byte bE = aVar.e();
            if (b == 0 && bE == 1 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.d()) {
                dVar = this.a;
            } else if (b == 3 && bE == 2 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.b()) {
                dVar = this.f1832c;
            } else if (b == 0 && bE == 2 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a()) {
                dVar = this.b;
            } else if (b == 1 && bE == 2 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.f()) {
                dVar = this.f1833d;
            } else if (b == 1 && bE == 3 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.c()) {
                dVar = this.f1834e;
            } else if (b != 2 || bE != 3 || !bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.e()) {
                return;
            } else {
                dVar = this.f1835f;
            }
            dVar.a(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public boolean a(int i2, boolean z2) {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.f fVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c cVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar2;
        g gVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar3;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a aVar4;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar5;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b bVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar6;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.e eVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar7;
        return (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.d() && (eVar = this.a) != null && (aVar7 = this.f1836g) != null && eVar.a(i2, aVar7.b())) || (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.b() && (bVar = this.f1832c) != null && (aVar6 = this.f1838i) != null && bVar.a(i2, aVar6.b())) || ((bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a() && (aVar4 = this.b) != null && (aVar5 = this.f1837h) != null && aVar4.a(i2, aVar5.b())) || ((bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.f() && (gVar = this.f1833d) != null && (aVar3 = this.f1839j) != null && gVar.a(i2, aVar3.b())) || ((bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.c() && (cVar = this.f1834e) != null && (aVar2 = this.f1840k) != null && cVar.a(i2, aVar2.b())) || (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.e() && (fVar = this.f1835f) != null && (aVar = this.f1841l) != null && fVar.a(i2, aVar.b())))));
    }
}

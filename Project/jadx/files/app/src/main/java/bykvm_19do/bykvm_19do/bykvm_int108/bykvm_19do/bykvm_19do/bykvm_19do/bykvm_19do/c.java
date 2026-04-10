package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class c implements d {
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d a;
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b f1822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g f1823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.f f1824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e f1825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1830k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1831l;

    public c() {
        Context contextD = j.l().d();
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.d()) {
            this.f1826g = j.l().f();
            this.a = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d(contextD, this.f1826g);
        }
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.b()) {
            this.f1828i = j.l().g();
            this.f1822c = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b(contextD, this.f1828i);
        }
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a()) {
            this.f1827h = j.l().g();
            this.b = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a(contextD, this.f1827h);
        }
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.f()) {
            this.f1829j = j.l().g();
            this.f1823d = new g(contextD, this.f1829j);
        }
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.c()) {
            this.f1830k = j.l().c();
            this.f1824e = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.f(contextD, this.f1830k);
        }
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.e()) {
            this.f1831l = j.l().h();
            this.f1825f = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e(contextD, this.f1831l);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> a(int i2, int i3) {
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> listA;
        StringBuilder sb;
        String str;
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> listA2;
        AtomicLong atomicLongJ;
        if (!bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.d() || (listA2 = this.a.a("_id")) == null || listA2.size() == 0) {
            if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.b() && (listA = this.f1822c.a("_id")) != null && listA.size() != 0) {
                sb = new StringBuilder();
                str = "v3ad db get :";
            } else if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a() && (listA2 = this.b.a("_id")) != null && listA2.size() != 0) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("adevent db get :" + listA2.size());
                atomicLongJ = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.a();
            } else if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.f() && (listA2 = this.f1823d.a("_id")) != null && listA2.size() != 0) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("real stats db get :" + listA2.size());
                atomicLongJ = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.V();
            } else if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.c() && (listA2 = this.f1824e.a("_id")) != null && listA2.size() != 0) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("batch db get :" + listA2.size());
                atomicLongJ = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.j();
            } else {
                if (!bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.e() || (listA = this.f1825f.a("_id")) == null || listA.size() == 0) {
                    return null;
                }
                sb = new StringBuilder();
                str = "other db get :";
            }
            sb.append(str);
            sb.append(listA.size());
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(sb.toString());
            return listA;
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("high db get size:" + listA2.size());
        atomicLongJ = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.y();
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(atomicLongJ, 1);
        return listA2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list) {
        g gVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a aVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("dbCache handleResult start");
        if (list != null && list.size() != 0 && list.get(0) != null) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar2 = list.get(0);
            if (i2 == 200 || i2 == -1) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.i(), list.size());
                if (i2 != 200) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.D(), list.size());
                }
                if (aVar2.b() == 0 && aVar2.e() == 1) {
                    if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.d()) {
                        aVar = this.a;
                        aVar.a(list);
                    }
                } else if (aVar2.b() == 3 && aVar2.e() == 2) {
                    if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.b()) {
                        aVar = this.f1822c;
                        aVar.a(list);
                    }
                } else if (aVar2.b() == 0 && aVar2.e() == 2) {
                    if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a()) {
                        aVar = this.b;
                        aVar.a(list);
                    }
                } else if (aVar2.b() == 1 && aVar2.e() == 2) {
                    if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.f()) {
                        gVar = this.f1823d;
                        gVar.a(list);
                    }
                } else if (aVar2.b() == 1 && aVar2.e() == 3) {
                    if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.c()) {
                        gVar = this.f1824e;
                        gVar.a(list);
                    }
                } else if (aVar2.b() == 2 && aVar2.e() == 3 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.e()) {
                    gVar = this.f1825f;
                    gVar.a(list);
                }
            }
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("dbCache handleResult end");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, int i2) {
        g gVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a aVar2;
        if (aVar == null) {
            return;
        }
        try {
            aVar.b(System.currentTimeMillis());
            if (aVar.b() == 0 && aVar.e() == 1) {
                if (!bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.d()) {
                    return;
                } else {
                    aVar2 = this.a;
                }
            } else if (aVar.b() == 3 && aVar.e() == 2) {
                if (!bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.b()) {
                    return;
                } else {
                    aVar2 = this.f1822c;
                }
            } else {
                if (aVar.b() != 0 || aVar.e() != 2) {
                    if (aVar.b() == 1 && aVar.e() == 2) {
                        if (!bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.f()) {
                            return;
                        } else {
                            gVar = this.f1823d;
                        }
                    } else if (aVar.b() == 1 && aVar.e() == 3) {
                        if (!bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.c()) {
                            return;
                        } else {
                            gVar = this.f1824e;
                        }
                    } else if (aVar.b() != 2 || aVar.e() != 3 || !bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.e()) {
                        return;
                    } else {
                        gVar = this.f1825f;
                    }
                    gVar.a(aVar);
                    return;
                }
                if (!bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a()) {
                    return;
                } else {
                    aVar2 = this.b;
                }
            }
            aVar2.a(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.J(), 1);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public boolean a(int i2, boolean z2) {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e eVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.f fVar;
        AtomicLong atomicLongK;
        g gVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a aVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b bVar;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d dVar;
        if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.d() && (dVar = this.a) != null && dVar.a(i2)) {
            atomicLongK = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.z();
        } else {
            if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.b() && (bVar = this.f1822c) != null && bVar.a(i2)) {
                return true;
            }
            if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a() && (aVar = this.b) != null && aVar.a(i2)) {
                atomicLongK = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.b();
            } else if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.f() && (gVar = this.f1823d) != null && gVar.a(i2)) {
                atomicLongK = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.W();
            } else {
                if (!bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.c() || (fVar = this.f1824e) == null || !fVar.a(i2)) {
                    return bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.e() && (eVar = this.f1825f) != null && eVar.a(i2);
                }
                atomicLongK = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.k();
            }
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(atomicLongK, 1);
        return true;
    }

    public List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> b(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, int i2) {
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> listA;
        AtomicLong atomicLongM;
        if (aVar.b() == 0 && aVar.e() == 1 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.d()) {
            if (this.f1826g.a() > i2) {
                listA = this.a.a(this.f1826g.a() - i2, "_id");
                if (listA == null || listA.size() == 0) {
                    return listA;
                }
                atomicLongM = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.B();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(atomicLongM, 1);
                return listA;
            }
            return null;
        }
        if (aVar.b() == 3 && aVar.e() == 2 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.b()) {
            if (this.f1828i.a() > i2) {
                return this.f1822c.a(this.f1828i.a() - i2, "_id");
            }
        } else if (aVar.b() == 0 && aVar.e() == 2 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a()) {
            if (this.f1827h.a() > i2) {
                listA = this.b.a(this.f1827h.a() - i2, "_id");
                if (listA == null || listA.size() == 0) {
                    return listA;
                }
                atomicLongM = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.d();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(atomicLongM, 1);
                return listA;
            }
        } else if (aVar.b() == 1 && aVar.e() == 2 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.f()) {
            if (this.f1829j.a() > i2) {
                listA = this.f1823d.a(this.f1829j.a() - i2, "_id");
                if (listA == null || listA.size() == 0) {
                    return listA;
                }
                atomicLongM = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.Y();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(atomicLongM, 1);
                return listA;
            }
        } else if (aVar.b() == 1 && aVar.e() == 3 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.c()) {
            if (this.f1830k.a() > i2) {
                listA = this.f1824e.a(this.f1830k.a() - i2, "_id");
                if (listA == null || listA.size() == 0) {
                    return listA;
                }
                atomicLongM = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.m();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(atomicLongM, 1);
                return listA;
            }
        } else if (aVar.b() == 2 && aVar.e() == 3 && bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.e() && this.f1831l.a() > i2) {
            return this.f1825f.a(this.f1831l.a() - i2, "_id");
        }
        return null;
    }
}

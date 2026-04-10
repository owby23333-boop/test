package com.google.zxing.pdf417.decoder;

/* JADX INFO: compiled from: DetectionResultRowIndicatorColumn.java */
/* JADX INFO: loaded from: classes2.dex */
final class g extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16310c;

    g(c cVar, boolean z2) {
        super(cVar);
        this.f16310c = z2;
    }

    private void b(a aVar) {
        c cVarA = a();
        com.google.zxing.i iVarG = this.f16310c ? cVarA.g() : cVarA.h();
        com.google.zxing.i iVarA = this.f16310c ? cVarA.a() : cVarA.b();
        int iC = c((int) iVarA.b());
        d[] dVarArrB = b();
        int iC2 = -1;
        int i2 = 0;
        int iMax = 1;
        for (int iC3 = c((int) iVarG.b()); iC3 < iC; iC3++) {
            if (dVarArrB[iC3] != null) {
                d dVar = dVarArrB[iC3];
                dVar.h();
                int iC4 = dVar.c() - iC2;
                if (iC4 == 0) {
                    i2++;
                } else {
                    if (iC4 == 1) {
                        iMax = Math.max(iMax, i2);
                        iC2 = dVar.c();
                    } else if (dVar.c() >= aVar.c()) {
                        dVarArrB[iC3] = null;
                    } else {
                        iC2 = dVar.c();
                    }
                    i2 = 1;
                }
            }
        }
    }

    private void f() {
        for (d dVar : b()) {
            if (dVar != null) {
                dVar.h();
            }
        }
    }

    void a(a aVar) {
        d[] dVarArrB = b();
        f();
        a(dVarArrB, aVar);
        c cVarA = a();
        com.google.zxing.i iVarG = this.f16310c ? cVarA.g() : cVarA.h();
        com.google.zxing.i iVarA = this.f16310c ? cVarA.a() : cVarA.b();
        int iC = c((int) iVarG.b());
        int iC2 = c((int) iVarA.b());
        int iC3 = -1;
        int i2 = 0;
        int iMax = 1;
        while (iC < iC2) {
            if (dVarArrB[iC] != null) {
                d dVar = dVarArrB[iC];
                int iC4 = dVar.c() - iC3;
                if (iC4 == 0) {
                    i2++;
                } else {
                    if (iC4 == 1) {
                        iMax = Math.max(iMax, i2);
                        iC3 = dVar.c();
                    } else if (iC4 < 0 || dVar.c() >= aVar.c() || iC4 > iC) {
                        dVarArrB[iC] = null;
                    } else {
                        if (iMax > 2) {
                            iC4 *= iMax - 2;
                        }
                        boolean z2 = iC4 >= iC;
                        for (int i3 = 1; i3 <= iC4 && !z2; i3++) {
                            z2 = dVarArrB[iC - i3] != null;
                        }
                        if (z2) {
                            dVarArrB[iC] = null;
                        } else {
                            iC3 = dVar.c();
                        }
                    }
                    i2 = 1;
                }
            }
            iC++;
        }
    }

    a c() {
        d[] dVarArrB = b();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : dVarArrB) {
            if (dVar != null) {
                dVar.h();
                int iE = dVar.e() % 30;
                int iC = dVar.c();
                if (!this.f16310c) {
                    iC += 2;
                }
                int i2 = iC % 3;
                if (i2 == 0) {
                    bVar2.a((iE * 3) + 1);
                } else if (i2 == 1) {
                    bVar4.a(iE / 3);
                    bVar3.a(iE % 3);
                } else if (i2 == 2) {
                    bVar.a(iE + 1);
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] <= 0 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        a(dVarArrB, aVar);
        return aVar;
    }

    int[] d() {
        int iC;
        a aVarC = c();
        if (aVarC == null) {
            return null;
        }
        b(aVarC);
        int[] iArr = new int[aVarC.c()];
        for (d dVar : b()) {
            if (dVar != null && (iC = dVar.c()) < iArr.length) {
                iArr[iC] = iArr[iC] + 1;
            }
        }
        return iArr;
    }

    boolean e() {
        return this.f16310c;
    }

    @Override // com.google.zxing.pdf417.decoder.f
    public String toString() {
        return "IsLeft: " + this.f16310c + '\n' + super.toString();
    }

    private void a(d[] dVarArr, a aVar) {
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            d dVar = dVarArr[i2];
            if (dVarArr[i2] != null) {
                int iE = dVar.e() % 30;
                int iC = dVar.c();
                if (iC > aVar.c()) {
                    dVarArr[i2] = null;
                } else {
                    if (!this.f16310c) {
                        iC += 2;
                    }
                    int i3 = iC % 3;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2 && iE + 1 != aVar.a()) {
                                dVarArr[i2] = null;
                            }
                        } else if (iE / 3 != aVar.b() || iE % 3 != aVar.d()) {
                            dVarArr[i2] = null;
                        }
                    } else if ((iE * 3) + 1 != aVar.e()) {
                        dVarArr[i2] = null;
                    }
                }
            }
        }
    }
}

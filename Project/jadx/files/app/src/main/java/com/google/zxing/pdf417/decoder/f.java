package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* JADX INFO: compiled from: DetectionResultColumn.java */
/* JADX INFO: loaded from: classes2.dex */
class f {
    private final c a;
    private final d[] b;

    f(c cVar) {
        this.a = new c(cVar);
        this.b = new d[(cVar.d() - cVar.f()) + 1];
    }

    final void a(int i2, d dVar) {
        this.b[c(i2)] = dVar;
    }

    final d b(int i2) {
        d dVar;
        d dVar2;
        d dVarA = a(i2);
        if (dVarA != null) {
            return dVarA;
        }
        for (int i3 = 1; i3 < 5; i3++) {
            int iC = c(i2) - i3;
            if (iC >= 0 && (dVar2 = this.b[iC]) != null) {
                return dVar2;
            }
            int iC2 = c(i2) + i3;
            d[] dVarArr = this.b;
            if (iC2 < dVarArr.length && (dVar = dVarArr[iC2]) != null) {
                return dVar;
            }
        }
        return null;
    }

    final int c(int i2) {
        return i2 - this.a.f();
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i2 = 0;
            for (d dVar : this.b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i2));
                    i2++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i2), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i2++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    final d a(int i2) {
        return this.b[c(i2)];
    }

    final c a() {
        return this.a;
    }

    final d[] b() {
        return this.b;
    }
}

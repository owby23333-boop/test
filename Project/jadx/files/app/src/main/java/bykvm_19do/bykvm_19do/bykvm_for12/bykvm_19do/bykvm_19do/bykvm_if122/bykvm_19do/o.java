package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

/* JADX INFO: loaded from: classes.dex */
final class o {
    final byte[] a;
    int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    o f880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    o f881g;

    o() {
        this.a = new byte[8192];
        this.f879e = true;
        this.f878d = false;
    }

    o(byte[] bArr, int i2, int i3, boolean z2, boolean z3) {
        this.a = bArr;
        this.b = i2;
        this.f877c = i3;
        this.f878d = z2;
        this.f879e = z3;
    }

    public final o a(int i2) {
        o oVarA;
        if (i2 <= 0 || i2 > this.f877c - this.b) {
            throw new IllegalArgumentException();
        }
        if (i2 >= 1024) {
            oVarA = c();
        } else {
            oVarA = p.a();
            System.arraycopy(this.a, this.b, oVarA.a, 0, i2);
        }
        oVarA.f877c = oVarA.b + i2;
        this.b += i2;
        this.f881g.a(oVarA);
        return oVarA;
    }

    public final o a(o oVar) {
        oVar.f881g = this;
        oVar.f880f = this.f880f;
        this.f880f.f881g = oVar;
        this.f880f = oVar;
        return oVar;
    }

    public final void a() {
        o oVar = this.f881g;
        if (oVar == this) {
            throw new IllegalStateException();
        }
        if (oVar.f879e) {
            int i2 = this.f877c - this.b;
            if (i2 <= (oVar.f878d ? 0 : oVar.b) + (8192 - oVar.f877c)) {
                a(this.f881g, i2);
                b();
                p.a(this);
            }
        }
    }

    public final void a(o oVar, int i2) {
        if (!oVar.f879e) {
            throw new IllegalArgumentException();
        }
        int i3 = oVar.f877c;
        int i4 = i3 + i2;
        if (i4 > 8192) {
            if (oVar.f878d) {
                throw new IllegalArgumentException();
            }
            int i5 = oVar.b;
            if (i4 - i5 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = oVar.a;
            System.arraycopy(bArr, i5, bArr, 0, i3 - i5);
            oVar.f877c -= oVar.b;
            oVar.b = 0;
        }
        System.arraycopy(this.a, this.b, oVar.a, oVar.f877c, i2);
        oVar.f877c += i2;
        this.b += i2;
    }

    public final o b() {
        o oVar = this.f880f;
        if (oVar == this) {
            oVar = null;
        }
        o oVar2 = this.f881g;
        if (oVar2 != null) {
            oVar2.f880f = this.f880f;
        }
        o oVar3 = this.f880f;
        if (oVar3 != null) {
            oVar3.f881g = this.f881g;
        }
        this.f880f = null;
        this.f881g = null;
        return oVar;
    }

    final o c() {
        this.f878d = true;
        return new o(this.a, this.b, this.f877c, true, false);
    }
}

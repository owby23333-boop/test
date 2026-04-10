package com.google.zxing.common.l;

import com.google.zxing.NotFoundException;
import com.google.zxing.i;

/* JADX INFO: compiled from: WhiteRectangleDetector.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private final com.google.zxing.common.b a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16170g;

    public b(com.google.zxing.common.b bVar) throws NotFoundException {
        this(bVar, 10, bVar.e() / 2, bVar.c() / 2);
    }

    public i[] a() throws NotFoundException {
        boolean z2;
        int i2 = this.f16167d;
        int i3 = this.f16168e;
        int i4 = this.f16170g;
        int i5 = this.f16169f;
        boolean z3 = false;
        int i6 = i2;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        for (boolean z9 = true; z9; z9 = z2) {
            boolean zA = true;
            z2 = false;
            while (true) {
                if ((!zA && z4) || i3 >= this.f16166c) {
                    break;
                }
                zA = a(i4, i5, i3, false);
                if (zA) {
                    i3++;
                    z4 = true;
                    z2 = true;
                } else if (!z4) {
                    i3++;
                }
            }
            if (i3 < this.f16166c) {
                boolean zA2 = true;
                while (true) {
                    if ((!zA2 && z5) || i5 >= this.b) {
                        break;
                    }
                    zA2 = a(i6, i3, i5, true);
                    if (zA2) {
                        i5++;
                        z5 = true;
                        z2 = true;
                    } else if (!z5) {
                        i5++;
                    }
                }
                if (i5 < this.b) {
                    boolean zA3 = true;
                    while (true) {
                        if ((!zA3 && z6) || i6 < 0) {
                            break;
                        }
                        zA3 = a(i4, i5, i6, false);
                        if (zA3) {
                            i6--;
                            z6 = true;
                            z2 = true;
                        } else if (!z6) {
                            i6--;
                        }
                    }
                    if (i6 >= 0) {
                        boolean zA4 = true;
                        while (true) {
                            if ((!zA4 && z8) || i4 < 0) {
                                break;
                            }
                            zA4 = a(i6, i3, i4, true);
                            if (zA4) {
                                i4--;
                                z8 = true;
                                z2 = true;
                            } else if (!z8) {
                                i4--;
                            }
                        }
                        if (i4 >= 0) {
                            if (z2) {
                                z7 = true;
                            }
                        }
                    }
                }
            }
            z3 = true;
            break;
        }
        if (z3 || !z7) {
            throw NotFoundException.f();
        }
        int i7 = i3 - i6;
        i iVarA = null;
        i iVarA2 = null;
        for (int i8 = 1; iVarA2 == null && i8 < i7; i8++) {
            iVarA2 = a(i6, i5 - i8, i6 + i8, i5);
        }
        if (iVarA2 == null) {
            throw NotFoundException.f();
        }
        i iVarA3 = null;
        for (int i9 = 1; iVarA3 == null && i9 < i7; i9++) {
            iVarA3 = a(i6, i4 + i9, i6 + i9, i4);
        }
        if (iVarA3 == null) {
            throw NotFoundException.f();
        }
        i iVarA4 = null;
        for (int i10 = 1; iVarA4 == null && i10 < i7; i10++) {
            iVarA4 = a(i3, i4 + i10, i3 - i10, i4);
        }
        if (iVarA4 == null) {
            throw NotFoundException.f();
        }
        for (int i11 = 1; iVarA == null && i11 < i7; i11++) {
            iVarA = a(i3, i5 - i11, i3 - i11, i5);
        }
        if (iVarA != null) {
            return a(iVarA, iVarA2, iVarA4, iVarA3);
        }
        throw NotFoundException.f();
    }

    public b(com.google.zxing.common.b bVar, int i2, int i3, int i4) throws NotFoundException {
        this.a = bVar;
        this.b = bVar.c();
        this.f16166c = bVar.e();
        int i5 = i2 / 2;
        this.f16167d = i3 - i5;
        this.f16168e = i3 + i5;
        this.f16170g = i4 - i5;
        this.f16169f = i4 + i5;
        if (this.f16170g < 0 || this.f16167d < 0 || this.f16169f >= this.b || this.f16168e >= this.f16166c) {
            throw NotFoundException.f();
        }
    }

    private i a(float f2, float f3, float f4, float f5) {
        int iA = a.a(a.a(f2, f3, f4, f5));
        float f6 = iA;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < iA; i2++) {
            float f9 = i2;
            int iA2 = a.a((f9 * f7) + f2);
            int iA3 = a.a((f9 * f8) + f3);
            if (this.a.b(iA2, iA3)) {
                return new i(iA2, iA3);
            }
        }
        return null;
    }

    private i[] a(i iVar, i iVar2, i iVar3, i iVar4) {
        float fA = iVar.a();
        float fB = iVar.b();
        float fA2 = iVar2.a();
        float fB2 = iVar2.b();
        float fA3 = iVar3.a();
        float fB3 = iVar3.b();
        float fA4 = iVar4.a();
        float fB4 = iVar4.b();
        return fA < ((float) this.f16166c) / 2.0f ? new i[]{new i(fA4 - 1.0f, fB4 + 1.0f), new i(fA2 + 1.0f, fB2 + 1.0f), new i(fA3 - 1.0f, fB3 - 1.0f), new i(fA + 1.0f, fB - 1.0f)} : new i[]{new i(fA4 + 1.0f, fB4 + 1.0f), new i(fA2 + 1.0f, fB2 - 1.0f), new i(fA3 - 1.0f, fB3 + 1.0f), new i(fA - 1.0f, fB - 1.0f)};
    }

    private boolean a(int i2, int i3, int i4, boolean z2) {
        if (z2) {
            while (i2 <= i3) {
                if (this.a.b(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.a.b(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }
}

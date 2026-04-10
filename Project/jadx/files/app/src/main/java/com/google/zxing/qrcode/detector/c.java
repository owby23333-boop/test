package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.f;
import com.google.zxing.common.h;
import com.google.zxing.i;
import com.google.zxing.j;
import com.google.zxing.qrcode.decoder.g;
import java.util.Map;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private final com.google.zxing.common.b a;
    private j b;

    public c(com.google.zxing.common.b bVar) {
        this.a = bVar;
    }

    private float b(int i2, int i3, int i4, int i5) {
        int iE;
        float fE;
        float fC;
        float fA = a(i2, i3, i4, i5);
        int i6 = i2 - (i4 - i2);
        int iC = 0;
        if (i6 < 0) {
            fE = i2 / (i2 - i6);
            iE = 0;
        } else if (i6 >= this.a.e()) {
            fE = ((this.a.e() - 1) - i2) / (i6 - i2);
            iE = this.a.e() - 1;
        } else {
            iE = i6;
            fE = 1.0f;
        }
        float f2 = i3;
        int i7 = (int) (f2 - ((i5 - i3) * fE));
        if (i7 < 0) {
            fC = f2 / (i3 - i7);
        } else if (i7 >= this.a.c()) {
            fC = ((this.a.c() - 1) - i3) / (i7 - i3);
            iC = this.a.c() - 1;
        } else {
            iC = i7;
            fC = 1.0f;
        }
        return (fA + a(i2, i3, (int) (i2 + ((iE - i2) * fC)), iC)) - 1.0f;
    }

    public final f a(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.b = map == null ? null : (j) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return a(new FinderPatternFinder(this.a, this.b).a(map));
    }

    protected final f a(e eVar) throws NotFoundException, FormatException {
        d dVarB = eVar.b();
        d dVarC = eVar.c();
        d dVarA = eVar.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA >= 1.0f) {
            int iA = a(dVarB, dVarC, dVarA, fA);
            g gVarB = g.b(iA);
            int iC = gVarB.c() - 7;
            a aVarA = null;
            if (gVarB.b().length > 0) {
                float fA2 = (dVarC.a() - dVarB.a()) + dVarA.a();
                float fB = (dVarC.b() - dVarB.b()) + dVarA.b();
                float f2 = 1.0f - (3.0f / iC);
                int iA2 = (int) (dVarB.a() + ((fA2 - dVarB.a()) * f2));
                int iB = (int) (dVarB.b() + (f2 * (fB - dVarB.b())));
                for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                    try {
                        aVarA = a(fA, iA2, iB, i2);
                        break;
                    } catch (NotFoundException unused) {
                    }
                }
            }
            return new f(a(this.a, a(dVarB, dVarC, dVarA, aVarA, iA), iA), aVarA == null ? new i[]{dVarA, dVarB, dVarC} : new i[]{dVarA, dVarB, dVarC, aVarA});
        }
        throw NotFoundException.f();
    }

    private static com.google.zxing.common.j a(i iVar, i iVar2, i iVar3, i iVar4, int i2) {
        float fA;
        float fB;
        float f2;
        float f3 = i2 - 3.5f;
        if (iVar4 != null) {
            fA = iVar4.a();
            fB = iVar4.b();
            f2 = f3 - 3.0f;
        } else {
            fA = (iVar2.a() - iVar.a()) + iVar3.a();
            fB = (iVar2.b() - iVar.b()) + iVar3.b();
            f2 = f3;
        }
        return com.google.zxing.common.j.a(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, iVar.a(), iVar.b(), iVar2.a(), iVar2.b(), fA, fB, iVar3.a(), iVar3.b());
    }

    private static com.google.zxing.common.b a(com.google.zxing.common.b bVar, com.google.zxing.common.j jVar, int i2) throws NotFoundException {
        return h.a().a(bVar, i2, i2, jVar);
    }

    private static int a(i iVar, i iVar2, i iVar3, float f2) throws NotFoundException {
        int iA = ((com.google.zxing.common.l.a.a(i.a(iVar, iVar2) / f2) + com.google.zxing.common.l.a.a(i.a(iVar, iVar3) / f2)) / 2) + 7;
        int i2 = iA & 3;
        if (i2 == 0) {
            return iA + 1;
        }
        if (i2 == 2) {
            return iA - 1;
        }
        if (i2 != 3) {
            return iA;
        }
        throw NotFoundException.f();
    }

    protected final float a(i iVar, i iVar2, i iVar3) {
        return (a(iVar, iVar2) + a(iVar, iVar3)) / 2.0f;
    }

    private float a(i iVar, i iVar2) {
        float fB = b((int) iVar.a(), (int) iVar.b(), (int) iVar2.a(), (int) iVar2.b());
        float fB2 = b((int) iVar2.a(), (int) iVar2.b(), (int) iVar.a(), (int) iVar.b());
        return Float.isNaN(fB) ? fB2 / 7.0f : Float.isNaN(fB2) ? fB / 7.0f : (fB + fB2) / 14.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0085, code lost:
    
        if (r14 != 2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008d, code lost:
    
        return com.google.zxing.common.l.a.a(r19, r5, r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r6 = r18
            r4 = r19
            r5 = r20
            r1 = r21
            goto L25
        L1d:
            r4 = r18
            r6 = r19
            r1 = r20
            r5 = r21
        L25:
            int r7 = r1 - r4
            int r7 = java.lang.Math.abs(r7)
            int r8 = r5 - r6
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r4 >= r1) goto L39
            r12 = 1
            goto L3a
        L39:
            r12 = -1
        L3a:
            if (r6 >= r5) goto L3d
            r11 = 1
        L3d:
            int r1 = r1 + r12
            r13 = r6
            r15 = r9
            r14 = 0
            r9 = r4
        L42:
            if (r9 == r1) goto L80
            if (r0 == 0) goto L48
            r2 = r13
            goto L49
        L48:
            r2 = r9
        L49:
            if (r0 == 0) goto L4d
            r10 = r9
            goto L4e
        L4d:
            r10 = r13
        L4e:
            if (r14 != r3) goto L58
            r3 = r17
            r16 = r0
            r19 = r1
            r0 = 1
            goto L5f
        L58:
            r3 = r17
            r16 = r0
            r19 = r1
            r0 = 0
        L5f:
            com.google.zxing.common.b r1 = r3.a
            boolean r1 = r1.b(r2, r10)
            if (r0 != r1) goto L71
            r0 = 2
            if (r14 != r0) goto L6f
            float r0 = com.google.zxing.common.l.a.a(r9, r13, r4, r6)
            return r0
        L6f:
            int r14 = r14 + 1
        L71:
            int r15 = r15 + r8
            if (r15 <= 0) goto L78
            if (r13 == r5) goto L84
            int r13 = r13 + r11
            int r15 = r15 - r7
        L78:
            int r9 = r9 + r12
            r1 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L42
        L80:
            r3 = r17
            r19 = r1
        L84:
            r0 = 2
            if (r14 != r0) goto L8e
            r1 = r19
            float r0 = com.google.zxing.common.l.a.a(r1, r5, r4, r6)
            return r0
        L8e:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.c.a(int, int, int, int):float");
    }

    protected final a a(float f2, int i2, int i3, float f3) throws NotFoundException {
        int i4 = (int) (f3 * f2);
        int iMax = Math.max(0, i2 - i4);
        int iMin = Math.min(this.a.e() - 1, i2 + i4) - iMax;
        float f4 = 3.0f * f2;
        if (iMin >= f4) {
            int iMax2 = Math.max(0, i3 - i4);
            int iMin2 = Math.min(this.a.c() - 1, i3 + i4) - iMax2;
            if (iMin2 >= f4) {
                return new b(this.a, iMax, iMax2, iMin, iMin2, f2, this.b).a();
            }
            throw NotFoundException.f();
        }
        throw NotFoundException.f();
    }
}

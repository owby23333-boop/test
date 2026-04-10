package com.google.zxing;

import com.umeng.message.proguard.ad;

/* JADX INFO: compiled from: ResultPoint.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    private final float a;
    private final float b;

    public i(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    public final float a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.a == iVar.a && this.b == iVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return ad.f20405r + this.a + ',' + this.b + ')';
    }

    public static void a(i[] iVarArr) {
        i iVar;
        i iVar2;
        i iVar3;
        float fA = a(iVarArr[0], iVarArr[1]);
        float fA2 = a(iVarArr[1], iVarArr[2]);
        float fA3 = a(iVarArr[0], iVarArr[2]);
        if (fA2 >= fA && fA2 >= fA3) {
            iVar = iVarArr[0];
            iVar2 = iVarArr[1];
            iVar3 = iVarArr[2];
        } else if (fA3 < fA2 || fA3 < fA) {
            iVar = iVarArr[2];
            iVar2 = iVarArr[0];
            iVar3 = iVarArr[1];
        } else {
            iVar = iVarArr[1];
            iVar2 = iVarArr[0];
            iVar3 = iVarArr[2];
        }
        if (a(iVar2, iVar, iVar3) < 0.0f) {
            i iVar4 = iVar3;
            iVar3 = iVar2;
            iVar2 = iVar4;
        }
        iVarArr[0] = iVar2;
        iVarArr[1] = iVar;
        iVarArr[2] = iVar3;
    }

    public static float a(i iVar, i iVar2) {
        return com.google.zxing.common.l.a.a(iVar.a, iVar.b, iVar2.a, iVar2.b);
    }

    private static float a(i iVar, i iVar2, i iVar3) {
        float f2 = iVar2.a;
        float f3 = iVar2.b;
        return ((iVar3.a - f2) * (iVar.b - f3)) - ((iVar3.b - f3) * (iVar.a - f2));
    }
}

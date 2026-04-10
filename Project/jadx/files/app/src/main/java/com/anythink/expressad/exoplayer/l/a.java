package com.anythink.expressad.exoplayer.l;

import com.anythink.expressad.exoplayer.k.p;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final List<byte[]> a;
    public final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f9933e;

    private a(List<byte[]> list, int i2, int i3, int i4, float f2) {
        this.a = list;
        this.b = i2;
        this.f9931c = i3;
        this.f9932d = i4;
        this.f9933e = f2;
    }

    public static a a(s sVar) throws t {
        int i2;
        int i3;
        float f2;
        try {
            sVar.d(4);
            int iD = (sVar.d() & 3) + 1;
            if (iD == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iD2 = sVar.d() & 31;
            for (int i4 = 0; i4 < iD2; i4++) {
                arrayList.add(b(sVar));
            }
            int iD3 = sVar.d();
            for (int i5 = 0; i5 < iD3; i5++) {
                arrayList.add(b(sVar));
            }
            if (iD2 > 0) {
                p.b bVarA = p.a((byte[]) arrayList.get(0), iD, ((byte[]) arrayList.get(0)).length);
                int i6 = bVarA.b;
                int i7 = bVarA.f9891c;
                f2 = bVarA.f9892d;
                i2 = i6;
                i3 = i7;
            } else {
                i2 = -1;
                i3 = -1;
                f2 = 1.0f;
            }
            return new a(arrayList, iD, i2, i3, f2);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new t("Error parsing AVC config", e2);
        }
    }

    private static byte[] b(s sVar) {
        int iE = sVar.e();
        int iC = sVar.c();
        sVar.d(iE);
        return com.anythink.expressad.exoplayer.k.d.a(sVar.a, iC, iE);
    }
}

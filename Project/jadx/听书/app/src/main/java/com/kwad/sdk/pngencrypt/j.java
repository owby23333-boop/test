package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends DeflatedChunksSet {
    protected byte[] aUU;
    protected byte[] aUV;
    protected final k aUW;
    final p aUX;
    protected int[] aUY;
    protected final e aUa;

    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
    }

    private j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, (eVar != null ? eVar.Oo() : kVar.aVi) + 1, kVar.aVi + 1, null, null);
        this.aUY = new int[5];
        this.aUW = kVar;
        this.aUa = eVar;
        this.aUX = new p(kVar, eVar);
    }

    private void Op() {
        ej(this.aUX.aVE);
    }

    private void ej(int i) {
        byte[] bArr = this.aUU;
        if (bArr == null || bArr.length < this.aUt.length) {
            this.aUU = new byte[this.aUt.length];
            this.aUV = new byte[this.aUt.length];
        }
        if (this.aUX.aVB == 0) {
            Arrays.fill(this.aUU, (byte) 0);
        }
        byte[] bArr2 = this.aUU;
        this.aUU = this.aUV;
        this.aUV = bArr2;
        byte b = this.aUt[0];
        if (!FilterType.isValidStandard(b)) {
            throw new PngjException("Filter type " + ((int) b) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b);
        int[] iArr = this.aUY;
        iArr[b] = iArr[b] + 1;
        this.aUU[0] = this.aUt[0];
        int i2 = AnonymousClass1.aUZ[byVal.ordinal()];
        if (i2 == 1) {
            el(i);
            return;
        }
        if (i2 == 2) {
            en(i);
            return;
        }
        if (i2 == 3) {
            eo(i);
        } else if (i2 == 4) {
            ek(i);
        } else {
            if (i2 == 5) {
                em(i);
                return;
            }
            throw new PngjException("Filter type " + ((int) b) + " not implemented");
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.pngencrypt.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aUZ;

        static {
            int[] iArr = new int[FilterType.values().length];
            aUZ = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aUZ[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aUZ[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aUZ[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                aUZ[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void ek(int i) {
        int i2 = 1;
        int i3 = 1 - this.aUW.aVh;
        while (i2 <= i) {
            this.aUU[i2] = (byte) (this.aUt[i2] + (((i3 > 0 ? this.aUU[i3] & 255 : 0) + (this.aUV[i2] & 255)) / 2));
            i2++;
            i3++;
        }
    }

    private void el(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.aUU[i2] = this.aUt[i2];
        }
    }

    private void em(int i) {
        int i2 = 1;
        int i3 = 1 - this.aUW.aVh;
        while (i2 <= i) {
            int i4 = 0;
            int i5 = i3 > 0 ? this.aUU[i3] & 255 : 0;
            if (i3 > 0) {
                i4 = this.aUV[i3] & 255;
            }
            this.aUU[i2] = (byte) (this.aUt[i2] + n.b(i5, this.aUV[i2] & 255, i4));
            i2++;
            i3++;
        }
    }

    private void en(int i) {
        for (int i2 = 1; i2 <= this.aUW.aVh; i2++) {
            this.aUU[i2] = this.aUt[i2];
        }
        int i3 = this.aUW.aVh + 1;
        int i4 = 1;
        while (i3 <= i) {
            this.aUU[i3] = (byte) (this.aUt[i3] + this.aUU[i4]);
            i3++;
            i4++;
        }
    }

    private void eo(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.aUU[i2] = (byte) (this.aUt[i2] + this.aUV[i2]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final void Od() {
        super.Od();
        this.aUX.update(Og());
        Op();
        p pVar = this.aUX;
        pVar.h(this.aUU, pVar.aVE + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final int Oe() {
        return Oq();
    }

    private int Oq() {
        int iOo;
        e eVar = this.aUa;
        int i = 0;
        if (eVar == null) {
            if (Og() < this.aUW.aUH - 1) {
                iOo = this.aUW.aVi;
                i = iOo + 1;
            }
        } else if (eVar.Oh()) {
            iOo = this.aUa.Oo();
            i = iOo + 1;
        }
        if (!this.aUd) {
            ef(i);
        }
        return i;
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.aUU = null;
        this.aUV = null;
    }
}

package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends DeflatedChunksSet {
    protected final e aun;
    protected byte[] avh;
    protected byte[] avi;
    protected final k avj;
    final p avk;
    protected int[] avl;

    /* JADX INFO: renamed from: com.kwad.sdk.pngencrypt.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] avm = new int[FilterType.values().length];

        static {
            try {
                avm[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                avm[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                avm[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                avm[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                avm[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public j(String str, boolean z2, k kVar, e eVar) {
        this(str, z2, kVar, eVar, null, null);
    }

    private j(String str, boolean z2, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z2, (eVar != null ? eVar.BT() : kVar.avv) + 1, kVar.avv + 1, null, null);
        this.avl = new int[5];
        this.avj = kVar;
        this.aun = eVar;
        this.avk = new p(kVar, eVar);
        com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", "Creating IDAT set ");
    }

    private void BU() {
        bK(this.avk.avR);
    }

    private int BV() {
        int iBT;
        e eVar = this.aun;
        int i2 = 0;
        if (eVar == null) {
            int iBL = BL();
            k kVar = this.avj;
            if (iBL < kVar.auU - 1) {
                iBT = kVar.avv;
                i2 = iBT + 1;
            }
        } else if (eVar.BM()) {
            iBT = this.aun.BT();
            i2 = iBT + 1;
        }
        if (!this.auq) {
            bG(i2);
        }
        return i2;
    }

    private void bK(int i2) {
        byte[] bArr = this.avh;
        if (bArr == null || bArr.length < this.auG.length) {
            byte[] bArr2 = this.auG;
            this.avh = new byte[bArr2.length];
            this.avi = new byte[bArr2.length];
        }
        if (this.avk.avO == 0) {
            Arrays.fill(this.avh, (byte) 0);
        }
        byte[] bArr3 = this.avh;
        this.avh = this.avi;
        this.avi = bArr3;
        byte b = this.auG[0];
        if (!FilterType.isValidStandard(b)) {
            throw new PngjException("Filter type " + ((int) b) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b);
        int[] iArr = this.avl;
        iArr[b] = iArr[b] + 1;
        this.avh[0] = this.auG[0];
        int i3 = AnonymousClass1.avm[byVal.ordinal()];
        if (i3 == 1) {
            bM(i2);
            return;
        }
        if (i3 == 2) {
            bO(i2);
            return;
        }
        if (i3 == 3) {
            bP(i2);
            return;
        }
        if (i3 == 4) {
            bL(i2);
        } else {
            if (i3 == 5) {
                bN(i2);
                return;
            }
            throw new PngjException("Filter type " + ((int) b) + " not implemented");
        }
    }

    private void bL(int i2) {
        int i3 = 1;
        int i4 = 1 - this.avj.avu;
        while (i3 <= i2) {
            this.avh[i3] = (byte) (this.auG[i3] + (((i4 > 0 ? this.avh[i4] & 255 : 0) + (this.avi[i3] & 255)) / 2));
            i3++;
            i4++;
        }
    }

    private void bM(int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            this.avh[i3] = this.auG[i3];
        }
    }

    private void bN(int i2) {
        int i3 = 1;
        int i4 = 1 - this.avj.avu;
        while (i3 <= i2) {
            int i5 = 0;
            int i6 = i4 > 0 ? this.avh[i4] & 255 : 0;
            if (i4 > 0) {
                i5 = this.avi[i4] & 255;
            }
            this.avh[i3] = (byte) (this.auG[i3] + n.b(i6, this.avi[i3] & 255, i5));
            i3++;
            i4++;
        }
    }

    private void bO(int i2) {
        int i3;
        int i4 = 1;
        while (true) {
            i3 = this.avj.avu;
            if (i4 > i3) {
                break;
            }
            this.avh[i4] = this.auG[i4];
            i4++;
        }
        int i5 = i3 + 1;
        int i6 = 1;
        while (i5 <= i2) {
            byte[] bArr = this.avh;
            bArr[i5] = (byte) (this.auG[i5] + bArr[i6]);
            i5++;
            i6++;
        }
    }

    private void bP(int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            this.avh[i3] = (byte) (this.auG[i3] + this.avi[i3]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final void BI() {
        super.BI();
        this.avk.update(BL());
        BU();
        p pVar = this.avk;
        pVar.h(this.avh, pVar.avR + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final int BJ() {
        return BV();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.avh = null;
        this.avi = null;
    }
}

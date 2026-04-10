package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: classes4.dex */
public final class k {
    public final int aUH;
    public final int aUI;
    public final int aVa;
    public final int aVb;
    public final boolean aVc;
    public final boolean aVd;
    public final boolean aVe;
    public final boolean aVf;
    public final int aVg;
    public final int aVh;
    public final int aVi;
    public final int aVj;
    public final int aVk;
    private long aVl = -1;
    private long aVm = -1;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.aUI = i;
        this.aUH = i2;
        this.aVc = z;
        this.aVe = z3;
        this.aVd = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        int i4 = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.aVb = i4;
        this.aVa = i3;
        boolean z4 = i3 < 8;
        this.aVf = z4;
        int i5 = i4 * i3;
        this.aVg = i5;
        this.aVh = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.aVi = i6;
        int i7 = i4 * i;
        this.aVj = i7;
        this.aVk = z4 ? i6 : i7;
        if (i3 == 1 || i3 == 2 || i3 == 4) {
            if (!z3 && !z2) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + i3);
            }
        } else if (i3 != 8) {
            if (i3 != 16) {
                throw new PngjException("invalid bitdepth=" + i3);
            }
            if (z3) {
                throw new PngjException("indexed can't have bitdepth=" + i3);
            }
        }
        if (i <= 0 || i > 16777216) {
            throw new PngjException("invalid cols=" + i + " ???");
        }
        if (i2 <= 0 || i2 > 16777216) {
            throw new PngjException("invalid rows=" + i2 + " ???");
        }
        if (i7 <= 0) {
            throw new PngjException("invalid image parameters (overflow?)");
        }
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.aUI + ", rows=" + this.aUH + ", bitDepth=" + this.aVa + ", channels=" + this.aVb + ", alpha=" + this.aVc + ", greyscale=" + this.aVd + ", indexed=" + this.aVe + "]";
    }

    public final int hashCode() {
        return (((((((((((this.aVc ? 1231 : 1237) + 31) * 31) + this.aVa) * 31) + this.aUI) * 31) + (this.aVd ? 1231 : 1237)) * 31) + (this.aVe ? 1231 : 1237)) * 31) + this.aUH;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.aVc == kVar.aVc && this.aVa == kVar.aVa && this.aUI == kVar.aUI && this.aVd == kVar.aVd && this.aVe == kVar.aVe && this.aUH == kVar.aUH;
    }
}

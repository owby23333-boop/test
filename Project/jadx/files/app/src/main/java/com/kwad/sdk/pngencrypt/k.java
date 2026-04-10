package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public final int auU;
    public final int auV;
    public final int avn;
    public final int avo;
    public final boolean avp;
    public final boolean avq;
    public final boolean avr;
    public final boolean avs;
    public final int avt;
    public final int avu;
    public final int avv;
    public final int avw;
    public final int avx;
    private long avy = -1;
    private long avz = -1;

    public k(int i2, int i3, int i4, boolean z2, boolean z3, boolean z4) {
        this.auV = i2;
        this.auU = i3;
        this.avp = z2;
        this.avr = z4;
        this.avq = z3;
        if (this.avq && z4) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.avo = (z3 || z4) ? z2 ? 2 : 1 : z2 ? 4 : 3;
        this.avn = i4;
        this.avs = i4 < 8;
        int i5 = this.avo;
        this.avt = this.avn * i5;
        int i6 = this.avt;
        this.avu = (i6 + 7) / 8;
        this.avv = ((i6 * i2) + 7) / 8;
        this.avw = i5 * this.auV;
        this.avx = this.avs ? this.avv : this.avw;
        int i7 = this.avn;
        if (i7 == 1 || i7 == 2 || i7 == 4) {
            if (!this.avr && !this.avq) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.avn);
            }
        } else if (i7 != 8) {
            if (i7 != 16) {
                throw new PngjException("invalid bitdepth=" + this.avn);
            }
            if (this.avr) {
                throw new PngjException("indexed can't have bitdepth=" + this.avn);
            }
        }
        if (i2 <= 0 || i2 > 16777216) {
            throw new PngjException("invalid cols=" + i2 + " ???");
        }
        if (i3 > 0 && i3 <= 16777216) {
            if (this.avw <= 0) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i3 + " ???");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.avp == kVar.avp && this.avn == kVar.avn && this.auV == kVar.auV && this.avq == kVar.avq && this.avr == kVar.avr && this.auU == kVar.auU;
    }

    public final int hashCode() {
        return (((((((((((this.avp ? 1231 : 1237) + 31) * 31) + this.avn) * 31) + this.auV) * 31) + (this.avq ? 1231 : 1237)) * 31) + (this.avr ? 1231 : 1237)) * 31) + this.auU;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.auV + ", rows=" + this.auU + ", bitDepth=" + this.avn + ", channels=" + this.avo + ", alpha=" + this.avp + ", greyscale=" + this.avq + ", indexed=" + this.avr + "]";
    }
}

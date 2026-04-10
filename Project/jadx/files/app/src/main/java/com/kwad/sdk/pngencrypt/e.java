package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    final k auS;
    private int auU;
    private int auV;
    int auW;
    int auX;
    int auY;
    int auZ;
    int ava;
    int avb;
    private boolean avg;
    private int auT = 0;
    private int avc = -1;
    private int avd = -1;
    private int ave = 0;
    int avf = 0;

    public e(k kVar) {
        this.avg = false;
        this.auS = kVar;
        this.avg = false;
        bI(1);
        bH(0);
    }

    private int BS() {
        return BR();
    }

    private void bH(int i2) {
        this.avc = i2;
        this.avd = (i2 * this.auW) + this.auY;
        int i3 = this.avd;
        if (i3 < 0 || i3 >= this.auS.auU) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void bI(int i2) {
        int i3;
        int i4;
        if (this.auT == i2) {
            return;
        }
        this.auT = i2;
        byte[] bArrBJ = bJ(i2);
        this.auX = bArrBJ[0];
        this.auW = bArrBJ[1];
        this.auZ = bArrBJ[2];
        this.auY = bArrBJ[3];
        int i5 = this.auS.auU;
        int i6 = this.auY;
        if (i5 > i6) {
            int i7 = this.auW;
            i3 = (((i5 + i7) - 1) - i6) / i7;
        } else {
            i3 = 0;
        }
        this.auU = i3;
        int i8 = this.auS.auV;
        int i9 = this.auZ;
        if (i8 > i9) {
            int i10 = this.auX;
            i4 = (((i8 + i10) - 1) - i9) / i10;
        } else {
            i4 = 0;
        }
        this.auV = i4;
        if (this.auV == 0) {
            this.auU = 0;
        }
        int i11 = this.auX;
        int i12 = this.auS.avo;
        this.avb = i11 * i12;
        this.ava = this.auZ * i12;
    }

    private static byte[] bJ(int i2) {
        switch (i2) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i2);
        }
    }

    final boolean BM() {
        int i2;
        while (true) {
            this.ave++;
            int i3 = this.auU;
            if (i3 != 0 && (i2 = this.avc) < i3 - 1) {
                bH(i2 + 1);
                break;
            }
            int i4 = this.auT;
            if (i4 != 7) {
                bI(i4 + 1);
                if (this.auU != 0) {
                    bH(0);
                    break;
                }
                this.ave--;
            } else {
                this.avg = true;
                return false;
            }
        }
        return true;
    }

    final int BN() {
        return this.avc;
    }

    final int BO() {
        return this.avd;
    }

    final int BP() {
        return this.auT;
    }

    final int BQ() {
        return this.auU;
    }

    final int BR() {
        return this.auV;
    }

    public final int BT() {
        return ((this.auS.avt * BS()) + 7) / 8;
    }
}

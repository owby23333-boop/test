package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    final k aUF;
    private int aUH;
    private int aUI;
    int aUJ;
    int aUK;
    int aUL;
    int aUM;
    int aUN;
    int aUO;
    private int aUG = 0;
    private int aUP = -1;
    private int aUQ = -1;
    private int aUR = 0;
    private boolean aUT = false;
    int aUS = 0;

    public e(k kVar) {
        this.aUF = kVar;
        eh(1);
        eg(0);
    }

    private void eg(int i) {
        this.aUP = i;
        int i2 = (i * this.aUJ) + this.aUL;
        this.aUQ = i2;
        if (i2 < 0 || i2 >= this.aUF.aUH) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    final boolean Oh() {
        int i;
        while (true) {
            this.aUR++;
            int i2 = this.aUH;
            if (i2 == 0 || (i = this.aUP) >= i2 - 1) {
                int i3 = this.aUG;
                if (i3 == 7) {
                    this.aUT = true;
                    return false;
                }
                eh(i3 + 1);
                if (this.aUH == 0) {
                    this.aUR--;
                } else {
                    eg(0);
                    break;
                }
            } else {
                eg(i + 1);
                break;
            }
        }
        return true;
    }

    private void eh(int i) {
        int i2;
        int i3;
        if (this.aUG == i) {
            return;
        }
        this.aUG = i;
        byte[] bArrEi = ei(i);
        this.aUK = bArrEi[0];
        this.aUJ = bArrEi[1];
        this.aUM = bArrEi[2];
        this.aUL = bArrEi[3];
        if (this.aUF.aUH > this.aUL) {
            int i4 = this.aUF.aUH;
            int i5 = this.aUJ;
            i2 = (((i4 + i5) - 1) - this.aUL) / i5;
        } else {
            i2 = 0;
        }
        this.aUH = i2;
        if (this.aUF.aUI > this.aUM) {
            int i6 = this.aUF.aUI;
            int i7 = this.aUK;
            i3 = (((i6 + i7) - 1) - this.aUM) / i7;
        } else {
            i3 = 0;
        }
        this.aUI = i3;
        if (i3 == 0) {
            this.aUH = 0;
        }
        this.aUO = this.aUK * this.aUF.aVb;
        this.aUN = this.aUM * this.aUF.aVb;
    }

    private static byte[] ei(int i) {
        switch (i) {
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
                throw new PngjException("bad interlace pass" + i);
        }
    }

    final int Oi() {
        return this.aUP;
    }

    final int Oj() {
        return this.aUQ;
    }

    final int Ok() {
        return this.aUG;
    }

    final int Ol() {
        return this.aUH;
    }

    final int Om() {
        return this.aUI;
    }

    private int On() {
        return Om();
    }

    public final int Oo() {
        return ((this.aUF.aVg * On()) + 7) / 8;
    }
}

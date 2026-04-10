package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends k {
    private String awD;
    private int awE;
    private int[] awF;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    public final String Cr() {
        return this.awD;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i2;
        int iE;
        int iE2;
        int iE3;
        int iE4;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i4 >= bArr.length) {
                i4 = -1;
                break;
            } else if (bArr[i4] == 0) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 > 0) {
            byte[] bArr2 = dVar.data;
            if (i4 <= bArr2.length - 2) {
                this.awD = b.d(bArr2, 0, i4);
                this.awE = com.kwad.sdk.pngencrypt.n.e(dVar.data, i4 + 1);
                int i5 = i4 + 2;
                int length = (dVar.data.length - i5) / (this.awE == 8 ? 6 : 10);
                this.awF = new int[length * 5];
                int i6 = 0;
                while (i3 < length) {
                    if (this.awE == 8) {
                        int i7 = i5 + 1;
                        iE = com.kwad.sdk.pngencrypt.n.e(dVar.data, i5);
                        int i8 = i7 + 1;
                        iE2 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i7);
                        int i9 = i8 + 1;
                        iE3 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i8);
                        i2 = i9 + 1;
                        iE4 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i9);
                    } else {
                        int iF = com.kwad.sdk.pngencrypt.n.f(dVar.data, i5);
                        int i10 = i5 + 2;
                        int iF2 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i10);
                        int i11 = i10 + 2;
                        int iF3 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i11);
                        int i12 = i11 + 2;
                        int iF4 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i12);
                        i2 = i12 + 2;
                        iE = iF;
                        iE2 = iF2;
                        iE3 = iF3;
                        iE4 = iF4;
                    }
                    int iF5 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i2);
                    int[] iArr = this.awF;
                    int i13 = i6 + 1;
                    iArr[i6] = iE;
                    int i14 = i13 + 1;
                    iArr[i13] = iE2;
                    int i15 = i14 + 1;
                    iArr[i14] = iE3;
                    int i16 = i15 + 1;
                    iArr[i15] = iE4;
                    i6 = i16 + 1;
                    iArr[i16] = iF5;
                    i3++;
                    i5 = i2 + 2;
                }
                return;
            }
        }
        throw new PngjException("bad sPLT chunk: no separator found");
    }
}

package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends t {
    private boolean awv;
    private String aww;
    private String awx;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.awv = false;
        this.aww = "";
        this.awx = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int[] iArr = new int[3];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i2 >= bArr.length) {
                break;
            }
            if (bArr[i2] == 0) {
                iArr[i3] = i2;
                i3++;
                if (i3 == 1) {
                    i2 += 2;
                }
                if (i3 == 3) {
                    break;
                }
            }
            i2++;
        }
        if (i3 != 3) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk"));
        }
        this.key = b.d(dVar.data, 0, iArr[0]);
        int i4 = iArr[0] + 1;
        this.awv = dVar.data[i4] != 0;
        int i5 = i4 + 1;
        if (this.awv && dVar.data[i5] != 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
        }
        this.aww = b.d(dVar.data, i5, iArr[1] - i5);
        this.awx = b.e(dVar.data, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
        int i6 = iArr[2] + 1;
        boolean z2 = this.awv;
        byte[] bArr2 = dVar.data;
        this.awP = z2 ? b.j(b.b(bArr2, i6, bArr2.length - i6, false)) : b.e(bArr2, i6, bArr2.length - i6);
    }
}

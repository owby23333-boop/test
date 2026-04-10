package com.google.zxing.qrcode.decoder;

import com.google.zxing.i;

/* JADX INFO: compiled from: QRCodeDecoderMetaData.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private final boolean a;

    f(boolean z2) {
        this.a = z2;
    }

    public void a(i[] iVarArr) {
        if (!this.a || iVarArr == null || iVarArr.length < 3) {
            return;
        }
        i iVar = iVarArr[0];
        iVarArr[0] = iVarArr[2];
        iVarArr[2] = iVar;
    }
}

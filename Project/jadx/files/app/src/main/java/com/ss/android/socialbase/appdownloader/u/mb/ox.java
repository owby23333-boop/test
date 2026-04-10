package com.ss.android.socialbase.appdownloader.u.mb;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ox {
    public static final void mb(hj hjVar, int i2) throws IOException {
        int iOx = hjVar.ox();
        if (iOx == i2) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i2) + ", read 0x" + Integer.toHexString(iOx) + ".");
    }
}

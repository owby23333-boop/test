package com.bytedance.adsdk.z.z.g;

import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class z extends gc {
    private static ThreadLocal<byte[]> g = new ThreadLocal<>();

    protected static byte[] z() {
        byte[] bArr = g.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        g.set(bArr2);
        return bArr2;
    }

    public z(m mVar) {
        super(mVar);
    }

    public int g() throws IOException {
        byte[] bArrZ = z();
        z(bArrZ, 0, 4);
        return ((bArrZ[0] & 255) << 24) | (bArrZ[3] & 255) | ((bArrZ[2] & 255) << 8) | ((bArrZ[1] & 255) << 16);
    }

    public short a_() throws IOException {
        byte[] bArrZ = z();
        z(bArrZ, 0, 2);
        return (short) (((bArrZ[0] & 255) << 8) | (bArrZ[1] & 255));
    }

    public boolean z(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int iB_ = b_();
        for (int i = 0; i < 4; i++) {
            if (((iB_ >> (i * 8)) & 255) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public int b_() throws IOException {
        byte[] bArrZ = z();
        z(bArrZ, 0, 4);
        return ((bArrZ[3] & 255) << 24) | (bArrZ[0] & 255) | ((bArrZ[1] & 255) << 8) | ((bArrZ[2] & 255) << 16);
    }
}

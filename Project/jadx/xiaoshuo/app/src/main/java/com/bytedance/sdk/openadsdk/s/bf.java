package com.bytedance.sdk.openadsdk.s;

import com.bytedance.embedapplog.util.TTEncryptUtils;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    public static byte[] e(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTEncryptUtils.a(bArr, i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}

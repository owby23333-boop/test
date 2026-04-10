package com.bytedance.sdk.openadsdk.hh;

import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static byte[] z(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTEncryptUtils.a(bArr, i);
                }
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        return null;
    }
}

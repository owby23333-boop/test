package com.bytedance.sdk.component.dl.g;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class hh {
    public long g() throws IOException {
        return -1L;
    }

    public abstract q z();

    public abstract void z(com.bytedance.sdk.component.dl.z.a aVar) throws IOException;

    public static hh z(q qVar, String str) {
        Charset charsetDl = com.bytedance.sdk.component.dl.g.z.dl.gc;
        if (qVar != null && (charsetDl = qVar.dl()) == null) {
            charsetDl = com.bytedance.sdk.component.dl.g.z.dl.gc;
            qVar = q.z(qVar + "; charset=utf-8");
        }
        return z(qVar, str.getBytes(charsetDl));
    }

    public static hh z(q qVar, byte[] bArr) {
        return z(qVar, bArr, 0, bArr.length);
    }

    public static hh z(final q qVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        com.bytedance.sdk.component.dl.g.z.dl.z(bArr.length, i, i2);
        return new hh() { // from class: com.bytedance.sdk.component.dl.g.hh.1
            @Override // com.bytedance.sdk.component.dl.g.hh
            public q z() {
                return qVar;
            }

            @Override // com.bytedance.sdk.component.dl.g.hh
            public long g() {
                return i2;
            }

            @Override // com.bytedance.sdk.component.dl.g.hh
            public void z(com.bytedance.sdk.component.dl.z.a aVar) throws IOException {
                aVar.dl(bArr, i, i2);
            }
        };
    }
}

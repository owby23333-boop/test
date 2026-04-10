package com.bytedance.pangle.gz;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestException;

/* JADX INFO: loaded from: classes2.dex */
class gz implements kb {
    private final ByteBuffer z;

    gz(ByteBuffer byteBuffer) {
        this.z = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.gz.kb
    public long z() {
        return this.z.capacity();
    }

    @Override // com.bytedance.pangle.gz.kb
    public void z(uy uyVar, long j, int i) throws DigestException, IOException {
        ByteBuffer byteBufferSlice;
        synchronized (this.z) {
            this.z.position(0);
            int i2 = (int) j;
            this.z.limit(i + i2);
            this.z.position(i2);
            byteBufferSlice = this.z.slice();
        }
        uyVar.z(byteBufferSlice);
    }
}

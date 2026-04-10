package com.bytedance.adsdk.z.z.g;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class a implements e {
    protected ByteBuffer z;

    public a() {
        dl(10240);
    }

    public void z(byte b) {
        this.z.put(b);
    }

    public void z(byte[] bArr) {
        this.z.put(bArr);
    }

    public int z() {
        return this.z.position();
    }

    public void a(int i) {
        this.z.position(i + z());
    }

    public byte[] g() {
        return this.z.array();
    }

    public void dl(int i) {
        ByteBuffer byteBuffer = this.z;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            this.z = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.z.clear();
    }
}

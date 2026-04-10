package com.bytedance.adsdk.z.z.g;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements m {
    private final ByteBuffer z;

    public dl(ByteBuffer byteBuffer) {
        this.z = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public long z(long j) throws IOException {
        ByteBuffer byteBuffer = this.z;
        byteBuffer.position((int) (((long) byteBuffer.position()) + j));
        return j;
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public byte c_() throws IOException {
        return this.z.get();
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public void d_() throws IOException {
        this.z.position(0);
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public int dl() {
        return this.z.position();
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public int z(byte[] bArr, int i, int i2) throws IOException {
        this.z.get(bArr, i, i2);
        return i2;
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public int a() throws IOException {
        return this.z.limit() - this.z.position();
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public InputStream gc() throws IOException {
        return new ByteArrayInputStream(this.z.array());
    }
}

package com.bytedance.adsdk.z.z.g;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements m {
    protected m z;

    public gc(m mVar) {
        this.z = mVar;
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public long z(long j) throws IOException {
        return this.z.z(j);
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public byte c_() throws IOException {
        return this.z.c_();
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public void d_() throws IOException {
        this.z.d_();
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public int dl() {
        return this.z.dl();
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public int z(byte[] bArr, int i, int i2) throws IOException {
        return this.z.z(bArr, i, i2);
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public int a() throws IOException {
        return this.z.a();
    }

    @Override // com.bytedance.adsdk.z.z.g.m
    public InputStream gc() throws IOException {
        d_();
        return this.z.gc();
    }
}

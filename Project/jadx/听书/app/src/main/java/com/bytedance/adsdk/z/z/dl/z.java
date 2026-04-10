package com.bytedance.adsdk.z.z.dl;

import com.bytedance.adsdk.z.z.g.dl;
import com.bytedance.adsdk.z.z.g.m;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements g {
    public abstract ByteBuffer z();

    @Override // com.bytedance.adsdk.z.z.dl.g
    public m g() throws IOException {
        return new dl(z());
    }
}

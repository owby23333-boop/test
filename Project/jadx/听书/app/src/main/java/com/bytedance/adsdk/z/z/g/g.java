package com.bytedance.adsdk.z.z.g;

import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a {
    public void z(int i) {
        z((byte) (i & 255));
        z((byte) ((i >> 8) & 255));
        z((byte) ((i >> 16) & 255));
        z((byte) ((i >> 24) & 255));
    }

    public void g(int i) {
        z((byte) ((i >> 24) & 255));
        z((byte) ((i >> 16) & 255));
        z((byte) ((i >> 8) & 255));
        z((byte) (i & 255));
    }

    @Override // com.bytedance.adsdk.z.z.g.a
    public void dl(int i) {
        super.dl(i);
        this.z.order(ByteOrder.BIG_ENDIAN);
    }
}

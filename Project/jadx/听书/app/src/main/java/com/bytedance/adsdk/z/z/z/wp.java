package com.bytedance.adsdk.z.z.z;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class wp extends gc {
    static final int z = gc.z("IHDR");
    int dl;
    int g;
    byte[] gz = new byte[5];

    wp() {
    }

    @Override // com.bytedance.adsdk.z.z.z.gc
    void z(com.bytedance.adsdk.z.z.g.z zVar) throws IOException {
        this.g = zVar.g();
        this.dl = zVar.g();
        byte[] bArr = this.gz;
        zVar.z(bArr, 0, bArr.length);
    }
}

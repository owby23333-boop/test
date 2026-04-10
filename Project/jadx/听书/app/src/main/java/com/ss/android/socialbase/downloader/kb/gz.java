package com.ss.android.socialbase.downloader.kb;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
class gz implements gc {
    private final gc g;
    private final gc z;

    gz(gc gcVar, gc gcVar2) {
        this.z = gcVar;
        this.g = gcVar2;
    }

    @Override // com.ss.android.socialbase.downloader.kb.gc
    public void g(z zVar) throws IOException {
        zVar.g = this.g;
        this.z.g(zVar);
    }
}

package com.ss.android.socialbase.downloader.uy;

import com.ss.android.socialbase.downloader.pf.m;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class dl implements g {
    private final com.ss.android.socialbase.downloader.kb.z g;
    private final InputStream z;

    @Override // com.ss.android.socialbase.downloader.uy.g
    public void z(com.ss.android.socialbase.downloader.kb.z zVar) {
    }

    public dl(InputStream inputStream, int i) {
        this.z = inputStream;
        this.g = new com.ss.android.socialbase.downloader.kb.z(i);
    }

    @Override // com.ss.android.socialbase.downloader.uy.g
    public com.ss.android.socialbase.downloader.kb.z z() throws IOException {
        com.ss.android.socialbase.downloader.kb.z zVar = this.g;
        zVar.dl = this.z.read(zVar.z);
        return this.g;
    }

    @Override // com.ss.android.socialbase.downloader.uy.g
    public void g() {
        m.z(this.z);
    }
}

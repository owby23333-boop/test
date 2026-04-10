package com.ss.android.socialbase.downloader.kb;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
class wp implements gc {
    private final gc dl;
    private final com.ss.android.socialbase.downloader.e.e g;
    private final fo z;

    public wp(com.ss.android.socialbase.downloader.e.dl dlVar, g gVar, fo foVar) throws com.ss.android.socialbase.downloader.gc.z {
        this.z = foVar;
        this.g = z(dlVar, foVar);
        this.dl = new gz(gVar, this);
    }

    public gc z() {
        return this.dl;
    }

    @Override // com.ss.android.socialbase.downloader.kb.gc
    public void g(z zVar) throws IOException {
        this.g.z(zVar.z, 0, zVar.dl);
        this.z.g(zVar.dl);
    }

    public void g() throws IOException {
        this.g.g();
    }

    public void dl() throws IOException {
        this.g.dl();
    }

    public void a() {
        com.ss.android.socialbase.downloader.pf.m.z(this.g);
    }

    public fo gc() {
        return this.z;
    }

    private com.ss.android.socialbase.downloader.e.e z(com.ss.android.socialbase.downloader.e.dl dlVar, fo foVar) throws com.ss.android.socialbase.downloader.gc.z {
        com.ss.android.socialbase.downloader.e.e eVarZ = com.ss.android.socialbase.downloader.pf.m.z(dlVar, dlVar.wp(), dlVar.i(), com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("flush_buffer_size_byte", -1));
        try {
            eVarZ.z(foVar.gc());
            return eVarZ;
        } catch (IOException e) {
            throw new com.ss.android.socialbase.downloader.gc.z(1054, e);
        }
    }
}

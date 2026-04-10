package com.ss.android.socialbase.downloader.a;

/* JADX INFO: loaded from: classes4.dex */
public abstract class gc extends dl implements tb {
    protected abstract com.ss.android.socialbase.downloader.notification.z z();

    @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        super.z(dlVar);
        kb(dlVar);
        z(1, dlVar, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        super.g(dlVar);
        z(2, dlVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
        super.dl(dlVar);
        wp(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void a(com.ss.android.socialbase.downloader.e.dl dlVar) {
        super.a(dlVar);
        z(-2, dlVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void gc(com.ss.android.socialbase.downloader.e.dl dlVar) {
        super.gc(dlVar);
        z(-3, dlVar, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
        super.z(dlVar, zVar);
        z(-1, dlVar, zVar, false);
    }

    private void kb(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null || !dlVar.k()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.z zVarGc = com.ss.android.socialbase.downloader.notification.g.z().gc(dlVar.e());
        if (zVarGc == null) {
            com.ss.android.socialbase.downloader.notification.g.z().z(z());
        } else {
            zVarGc.z(dlVar);
        }
    }

    private void z(int i, com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar, boolean z) {
        if (dlVar == null || !dlVar.k() || i == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.z zVarGc = com.ss.android.socialbase.downloader.notification.g.z().gc(dlVar.e());
        if (zVarGc == null) {
            zVarGc = z();
        }
        zVarGc.g(dlVar.s());
        if (i == -3) {
            zVarGc.z(dlVar.s());
        } else {
            zVarGc.z(dlVar.sf());
        }
        zVarGc.z(i, zVar, z);
    }

    private void wp(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar != null && dlVar.k() && dlVar.p() == 4) {
            com.ss.android.socialbase.downloader.notification.z zVarGc = com.ss.android.socialbase.downloader.notification.g.z().gc(dlVar.e());
            if (zVarGc == null) {
                zVarGc = z();
            }
            zVarGc.z(dlVar.sf(), dlVar.s());
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.tb
    public void e(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null || dlVar.cb()) {
            return;
        }
        z(11, dlVar, null, true);
    }
}

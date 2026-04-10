package com.ss.android.socialbase.downloader.a;

/* JADX INFO: loaded from: classes4.dex */
public abstract class dl implements hh {
    private static final String z = "dl";

    @Override // com.ss.android.socialbase.downloader.a.hh
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g(z, " onPrepare -- " + dlVar.gz());
    }

    @Override // com.ss.android.socialbase.downloader.a.hh
    public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g(z, " onStart -- " + dlVar.gz());
    }

    @Override // com.ss.android.socialbase.downloader.a.hh
    public void dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null || dlVar.s() == 0) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g(z, String.format("onProgress %s %.2f%%", dlVar.gz(), Float.valueOf((dlVar.sf() / dlVar.s()) * 100.0f)));
    }

    @Override // com.ss.android.socialbase.downloader.a.hh
    public void a(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g(z, " onPause -- " + dlVar.gz());
    }

    @Override // com.ss.android.socialbase.downloader.a.hh
    public void gc(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g(z, " onSuccessed -- " + dlVar.gz() + " " + dlVar.u());
    }

    @Override // com.ss.android.socialbase.downloader.a.hh
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null) {
            return;
        }
        String str = z;
        Object[] objArr = new Object[2];
        objArr[0] = dlVar.gz();
        objArr[1] = zVar != null ? zVar.g() : "unkown";
        com.ss.android.socialbase.downloader.m.z.g(str, String.format("onFailed on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.a.hh
    public void m(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g(z, " onCanceled -- " + dlVar.gz());
    }

    @Override // com.ss.android.socialbase.downloader.a.hh
    public void gz(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g(z, " onFirstStart -- " + dlVar.gz());
    }

    @Override // com.ss.android.socialbase.downloader.a.hh
    public void fo(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g(z, " onFirstSuccess -- " + dlVar.gz());
    }

    @Override // com.ss.android.socialbase.downloader.a.hh
    public void g(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null) {
            return;
        }
        String str = z;
        Object[] objArr = new Object[2];
        objArr[0] = dlVar.gz();
        objArr[1] = zVar != null ? zVar.g() : "unkown";
        com.ss.android.socialbase.downloader.m.z.g(str, String.format("onRetry on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.a.hh
    public void dl(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null) {
            return;
        }
        String str = z;
        Object[] objArr = new Object[2];
        objArr[0] = dlVar.gz();
        objArr[1] = zVar != null ? zVar.g() : "unkown";
        com.ss.android.socialbase.downloader.m.z.g(str, String.format("onRetryDelay on %s because of : %s", objArr));
    }

    public void uy(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (!com.ss.android.socialbase.downloader.m.z.z() || dlVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g(z, " onIntercept -- " + dlVar.gz());
    }
}

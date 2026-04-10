package com.ss.android.downloadlib.m;

import com.ss.android.downloadlib.addownload.g.m;
import com.ss.android.socialbase.appdownloader.dl.kb;
import com.ss.android.socialbase.appdownloader.dl.uy;

/* JADX INFO: loaded from: classes4.dex */
public class g implements kb {
    @Override // com.ss.android.socialbase.appdownloader.dl.kb
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, uy uyVar) {
        com.ss.android.g.z.g.g gVarZ;
        if (dlVar != null && (gVarZ = m.z().z(dlVar)) != null) {
            dlVar.dl(gVarZ.j());
        }
        if (uyVar != null) {
            uyVar.z();
        }
    }
}

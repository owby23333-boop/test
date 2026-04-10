package com.ss.android.downloadlib.m;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.g.m;
import com.ss.android.downloadlib.g.fo;
import com.ss.android.socialbase.appdownloader.dl.kb;
import com.ss.android.socialbase.appdownloader.dl.uy;

/* JADX INFO: loaded from: classes4.dex */
public class z implements kb {
    @Override // com.ss.android.socialbase.appdownloader.dl.kb
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, final uy uyVar) {
        z(dlVar, new com.ss.android.downloadlib.guide.install.z() { // from class: com.ss.android.downloadlib.m.z.1
            @Override // com.ss.android.downloadlib.guide.install.z
            public void z() {
                uyVar.z();
            }
        });
    }

    public void z(final com.ss.android.socialbase.downloader.e.dl dlVar, final com.ss.android.downloadlib.guide.install.z zVar) {
        com.ss.android.g.z.g.g gVarZ = m.z().z(dlVar);
        if (gVarZ != null && fo.z(gVarZ)) {
            TTDelegateActivity.z(gVarZ, new com.ss.android.downloadlib.guide.install.z() { // from class: com.ss.android.downloadlib.m.z.2
                @Override // com.ss.android.downloadlib.guide.install.z
                public void z() {
                    z.this.g(dlVar, zVar);
                }
            });
        } else {
            g(dlVar, zVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.ss.android.socialbase.downloader.e.dl dlVar, final com.ss.android.downloadlib.guide.install.z zVar) {
        com.ss.android.g.z.g.g gVarZ = m.z().z(dlVar);
        boolean z = com.ss.android.downloadlib.g.m.z(gVarZ);
        boolean zG = com.ss.android.downloadlib.g.m.g(gVarZ);
        if (!z || !zG) {
            zVar.z();
        } else {
            com.ss.android.downloadlib.g.dl.z(gVarZ, new com.ss.android.downloadlib.guide.install.z() { // from class: com.ss.android.downloadlib.m.z.3
                @Override // com.ss.android.downloadlib.guide.install.z
                public void z() {
                    zVar.z();
                }
            });
        }
    }
}

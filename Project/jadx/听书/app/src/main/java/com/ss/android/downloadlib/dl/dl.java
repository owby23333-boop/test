package com.ss.android.downloadlib.dl;

import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import com.ss.android.socialbase.downloader.a.v;
import com.ss.android.z.z.g.pf;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class dl implements v {
    @Override // com.ss.android.socialbase.downloader.a.v
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) throws com.ss.android.socialbase.downloader.gc.z {
        pf pfVarKb = wp.kb();
        if (dlVar == null || pfVarKb == null) {
            return;
        }
        File fileZ = z(dlVar.x(), dlVar.v());
        com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar);
        if (gVarZ != null) {
            i.z(gVarZ.e());
        }
        dlVar.uy("application/vnd.android.package-archive");
        dlVar.m(fileZ.getName());
        dlVar.kb((String) null);
    }

    @Override // com.ss.android.socialbase.downloader.a.v
    public boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar != null) {
            return com.ss.android.z.z.m.g.z(com.ss.android.socialbase.downloader.i.z.z(dlVar.e()), dlVar.yt());
        }
        return false;
    }

    private File z(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            str = name.substring(0, iLastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}

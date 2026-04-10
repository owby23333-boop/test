package com.ss.android.downloadlib.addownload.a;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.pf;

/* JADX INFO: loaded from: classes4.dex */
public class wp implements fo {
    @Override // com.ss.android.downloadlib.addownload.a.fo
    public boolean z(com.ss.android.g.z.g.g gVar, int i, gz gzVar) {
        com.ss.android.socialbase.downloader.e.dl dlVarG;
        if (gVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(gVar.tc())) {
            dlVarG = com.ss.android.downloadlib.uy.z((Context) null).z(gVar.tc(), null, true);
        } else {
            dlVarG = com.ss.android.downloadlib.uy.z((Context) null).g(gVar.z());
        }
        return pf.z(gVar, dlVarG, i, gzVar, false, null);
    }
}

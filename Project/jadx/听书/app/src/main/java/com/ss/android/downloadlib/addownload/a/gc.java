package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.pf;

/* JADX INFO: loaded from: classes4.dex */
public class gc implements e {
    @Override // com.ss.android.downloadlib.addownload.a.e
    public boolean z(com.ss.android.g.z.g.g gVar, int i, gz gzVar, com.ss.android.downloadlib.addownload.z.dl dlVar) {
        com.ss.android.socialbase.downloader.e.dl dlVarG;
        if (gVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(gVar.tc())) {
            dlVarG = com.ss.android.downloadlib.uy.z(com.ss.android.downloadlib.addownload.wp.getContext()).z(gVar.tc(), null, true);
        } else {
            dlVarG = com.ss.android.downloadlib.uy.z(com.ss.android.downloadlib.addownload.wp.getContext()).g(gVar.z());
        }
        return pf.z(gVar, dlVarG, i, gzVar, true, dlVar);
    }
}

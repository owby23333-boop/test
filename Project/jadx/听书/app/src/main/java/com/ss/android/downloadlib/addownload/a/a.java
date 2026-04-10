package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static a z;
    private List<e> g;

    public static a z() {
        if (z == null) {
            synchronized (kb.class) {
                if (z == null) {
                    z = new a();
                }
            }
        }
        return z;
    }

    private a() {
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.add(new gc());
        this.g.add(new g());
        this.g.add(new dl());
    }

    public void z(com.ss.android.g.z.g.g gVar, int i, gz gzVar, com.ss.android.downloadlib.addownload.z.dl dlVar) {
        com.ss.android.socialbase.downloader.e.dl dlVarG;
        List<e> list = this.g;
        if (list == null || list.size() == 0 || gVar == null) {
            gzVar.z(gVar);
        }
        if (!TextUtils.isEmpty(gVar.tc())) {
            dlVarG = com.ss.android.downloadlib.uy.z(com.ss.android.downloadlib.addownload.wp.getContext()).z(gVar.tc(), null, true);
        } else {
            dlVarG = com.ss.android.downloadlib.uy.z(com.ss.android.downloadlib.addownload.wp.getContext()).g(gVar.z());
        }
        if (dlVarG == null) {
            dlVarG = com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.downloadlib.addownload.wp.getContext()).gz(gVar.js());
        }
        if (dlVarG == null || !"application/vnd.android.package-archive".equals(dlVarG.yt())) {
            gzVar.z(gVar);
            return;
        }
        if (new uy().z(gVar, i, gzVar)) {
            return;
        }
        Iterator<e> it = this.g.iterator();
        while (it.hasNext()) {
            if (it.next().z(gVar, i, gzVar, dlVar)) {
                return;
            }
        }
        gzVar.z(gVar);
    }
}

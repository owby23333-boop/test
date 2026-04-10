package com.ss.android.downloadlib.addownload.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class kb {
    private static kb z;
    private List<fo> g;

    public static kb z() {
        if (z == null) {
            synchronized (kb.class) {
                if (z == null) {
                    z = new kb();
                }
            }
        }
        return z;
    }

    private kb() {
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.add(new uy());
        this.g.add(new wp());
        this.g.add(new m());
        this.g.add(new z());
    }

    public void z(com.ss.android.g.z.g.g gVar, int i, gz gzVar) {
        com.ss.android.socialbase.downloader.e.dl dlVarG;
        List<fo> list = this.g;
        if (list == null || list.size() == 0 || gVar == null) {
            gzVar.z(gVar);
            return;
        }
        if (!TextUtils.isEmpty(gVar.tc())) {
            dlVarG = com.ss.android.downloadlib.uy.z((Context) null).z(gVar.tc(), null, true);
        } else {
            dlVarG = com.ss.android.downloadlib.uy.z((Context) null).g(gVar.z());
        }
        if (dlVarG == null || !"application/vnd.android.package-archive".equals(dlVarG.yt())) {
            gzVar.z(gVar);
            return;
        }
        boolean z2 = com.ss.android.socialbase.downloader.i.z.z(gVar.js()).z("pause_optimise_switch", 0) == 1;
        for (fo foVar : this.g) {
            if (z2 || (foVar instanceof wp)) {
                if (foVar.z(gVar, i, gzVar)) {
                    return;
                }
            }
        }
        gzVar.z(gVar);
    }
}

package com.ss.android.downloadlib.m;

import com.ss.android.socialbase.appdownloader.dl.kb;
import com.ss.android.socialbase.appdownloader.dl.uy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dl implements kb {
    private static volatile dl z;
    private List<kb> g;

    public static dl z() {
        if (z == null) {
            synchronized (dl.class) {
                if (z == null) {
                    z = new dl();
                }
            }
        }
        return z;
    }

    private dl() {
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.add(new g());
        this.g.add(new z());
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.kb
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, uy uyVar) {
        if (dlVar != null && this.g.size() != 0) {
            z(dlVar, 0, uyVar);
        } else if (uyVar != null) {
            uyVar.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final com.ss.android.socialbase.downloader.e.dl dlVar, final int i, final uy uyVar) {
        if (i == this.g.size() || i < 0) {
            uyVar.z();
        } else {
            this.g.get(i).z(dlVar, new uy() { // from class: com.ss.android.downloadlib.m.dl.1
                @Override // com.ss.android.socialbase.appdownloader.dl.uy
                public void z() {
                    dl.this.z(dlVar, i + 1, uyVar);
                }
            });
        }
    }
}

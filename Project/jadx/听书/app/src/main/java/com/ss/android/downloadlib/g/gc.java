package com.ss.android.downloadlib.g;

import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.socialbase.downloader.z.z;

/* JADX INFO: loaded from: classes4.dex */
public class gc implements z.InterfaceC0484z {
    private long z;

    @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
    public void dl() {
    }

    private static class z {
        private static gc z = new gc();
    }

    public static gc z() {
        return z.z;
    }

    private gc() {
        this.z = 0L;
        com.ss.android.socialbase.downloader.z.z.z().z(this);
    }

    @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
    public void g() {
        this.z = System.currentTimeMillis();
    }

    public void z(final a aVar, final long j) {
        if (aVar == null) {
            return;
        }
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.g.gc.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.ss.android.socialbase.downloader.z.z.z().dl() || System.currentTimeMillis() - gc.this.z <= j) {
                    aVar.z(true);
                } else {
                    aVar.z(false);
                }
            }
        }, j);
    }

    public void z(a aVar) {
        z(aVar, 5000L);
    }

    public void g(a aVar) {
        if (aVar == null) {
            return;
        }
        z(aVar, wp.fo().optInt("check_an_result_delay", 1200) > 0 ? r0 : 1200);
    }
}

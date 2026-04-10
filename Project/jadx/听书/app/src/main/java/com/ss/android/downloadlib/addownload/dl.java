package com.ss.android.downloadlib.addownload;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class dl {
    private static volatile dl g = null;
    private static String z = "dl";
    private ConcurrentHashMap<Long, Runnable> dl;

    public dl() {
        this.dl = null;
        this.dl = new ConcurrentHashMap<>();
    }

    public static dl z() {
        if (g == null) {
            synchronized (dl.class) {
                if (g == null) {
                    g = new dl();
                }
            }
        }
        return g;
    }

    public void z(gc gcVar, boolean z2, int i, com.ss.android.z.z.dl.dl dlVar) {
        if (dlVar instanceof com.ss.android.g.z.z.dl) {
            ((com.ss.android.g.z.z.dl) dlVar).dl(3);
        }
        long jA = dlVar.a();
        if (i == 4) {
            if (!z2) {
                z(jA, false, 2);
                gcVar.g(false);
                return;
            } else {
                z(jA, true, 2);
                return;
            }
        }
        if (i == 5) {
            if (!z2) {
                z(jA, false, 1);
                gcVar.dl(false);
                return;
            } else {
                z(jA, true, 1);
                return;
            }
        }
        if (i != 7) {
            return;
        }
        Runnable runnableRemove = this.dl.remove(Long.valueOf(jA));
        if (z2) {
            com.ss.android.downloadlib.a.z.z().z(jA, 1);
            z(jA, true, 1);
        } else {
            if (runnableRemove != null) {
                com.ss.android.downloadlib.gz.z().g().post(runnableRemove);
            }
            z(jA, false, 1);
        }
    }

    private void z(long j, boolean z2, int i) {
        com.ss.android.downloadlib.a.z.z().z(j, z2, i);
        if (z2) {
            wp.q();
        }
    }

    public void z(final gc gcVar, final int i, final com.ss.android.z.z.dl.dl dlVar) {
        com.ss.android.downloadlib.g.gc.z().z(new com.ss.android.downloadlib.g.a() { // from class: com.ss.android.downloadlib.addownload.dl.1
            @Override // com.ss.android.downloadlib.g.a
            public void z(boolean z2) {
                dl.this.z(gcVar, z2, i, dlVar);
            }
        }, g());
    }

    public long g() {
        return wp.fo().optLong("quick_app_check_internal", 1200L);
    }

    public static boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        return dlVar == null || dlVar.p() == 0 || dlVar.p() == -4;
    }
}

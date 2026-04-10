package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: loaded from: classes4.dex */
public class wp {
    private static volatile com.ss.android.socialbase.downloader.downloader.pf g;
    private static volatile com.ss.android.socialbase.downloader.downloader.pf z;

    public static com.ss.android.socialbase.downloader.downloader.pf z(boolean z2) {
        if (z2 && com.ss.android.socialbase.downloader.downloader.dl.y()) {
            if (g == null) {
                synchronized (wp.class) {
                    if (g == null) {
                        g = com.ss.android.socialbase.downloader.downloader.dl.ec().g();
                    }
                }
            }
            return g;
        }
        if (z == null) {
            synchronized (wp.class) {
                if (z == null) {
                    z = new ls();
                }
            }
        }
        return z;
    }
}

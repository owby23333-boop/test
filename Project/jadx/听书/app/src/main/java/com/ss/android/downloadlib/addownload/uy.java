package com.ss.android.downloadlib.addownload;

/* JADX INFO: loaded from: classes4.dex */
public class uy {
    public static int z(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !z(i)) ? i2 : (int) (Math.sqrt(i2) * 10.0d);
    }

    public static long z(int i, long j, long j2) {
        if (!z(i)) {
            return j;
        }
        if (j <= 0) {
            return 0L;
        }
        return j2 <= 0 ? j : (j2 * ((long) z(i, (int) ((j * 100) / j2)))) / 100;
    }

    public static com.ss.android.z.z.gc.gc z(com.ss.android.z.z.gc.gc gcVar) {
        if (gcVar != null && z((int) gcVar.z)) {
            gcVar.f2124a = z((int) gcVar.z, gcVar.f2124a, gcVar.dl);
        }
        return gcVar;
    }

    private static boolean z(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.ss.android.socialbase.downloader.i.z.z(i).z("pause_optimise_switch", 0) == 1;
    }
}

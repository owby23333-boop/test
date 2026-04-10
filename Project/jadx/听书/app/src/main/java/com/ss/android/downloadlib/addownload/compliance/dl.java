package com.ss.android.downloadlib.addownload.compliance;

/* JADX INFO: loaded from: classes4.dex */
public class dl extends com.ss.android.socialbase.downloader.pf.gz<Long, com.ss.android.downloadlib.addownload.g.g> {

    private static class z {
        private static dl z = new dl();
    }

    public static dl z() {
        return z.z;
    }

    private dl() {
        super(16, 16);
    }

    public void z(com.ss.android.downloadlib.addownload.g.g gVar) {
        if (gVar == null) {
            return;
        }
        put(Long.valueOf(gVar.z()), gVar);
    }

    public com.ss.android.downloadlib.addownload.g.g z(long j, long j2) {
        return (com.ss.android.downloadlib.addownload.g.g) get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public com.ss.android.downloadlib.addownload.g.g z(long j) {
        return (com.ss.android.downloadlib.addownload.g.g) get(Long.valueOf(j));
    }
}

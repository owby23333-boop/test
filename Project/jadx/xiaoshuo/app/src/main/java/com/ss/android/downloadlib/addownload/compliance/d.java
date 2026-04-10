package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.zk.v;

/* JADX INFO: loaded from: classes4.dex */
public class d extends v<Long, com.ss.android.downloadlib.addownload.bf.bf> {

    public static class e {
        private static d e = new d();
    }

    public static d e() {
        return e.e;
    }

    private d() {
        super(16, 16);
    }

    public void e(com.ss.android.downloadlib.addownload.bf.bf bfVar) {
        if (bfVar == null) {
            return;
        }
        put(Long.valueOf(bfVar.e()), bfVar);
    }

    public com.ss.android.downloadlib.addownload.bf.bf e(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public com.ss.android.downloadlib.addownload.bf.bf e(long j) {
        return get(Long.valueOf(j));
    }
}

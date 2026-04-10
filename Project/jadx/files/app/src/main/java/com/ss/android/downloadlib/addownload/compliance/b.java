package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.utils.LruCache;

/* JADX INFO: loaded from: classes3.dex */
public class b extends LruCache<Long, com.ss.android.downloadlib.addownload.model.ox> {

    private static class mb {
        private static b mb = new b();
    }

    public static b mb() {
        return mb.mb;
    }

    private b() {
        super(16, 16);
    }

    public void mb(com.ss.android.downloadlib.addownload.model.ox oxVar) {
        if (oxVar == null) {
            return;
        }
        put(Long.valueOf(oxVar.mb()), oxVar);
    }

    public com.ss.android.downloadlib.addownload.model.ox mb(long j2, long j3) {
        return get(get(Long.valueOf(j2)) != null ? Long.valueOf(j2) : Long.valueOf(j3));
    }

    public com.ss.android.downloadlib.addownload.model.ox mb(long j2) {
        return get(Long.valueOf(j2));
    }
}

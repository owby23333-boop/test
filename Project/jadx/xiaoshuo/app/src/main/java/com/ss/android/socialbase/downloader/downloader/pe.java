package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.network.IDownloadHttpService;

/* JADX INFO: loaded from: classes4.dex */
public interface pe {

    public static class e implements pe {
        @Override // com.ss.android.socialbase.downloader.downloader.pe
        public IDownloadHttpService bf() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.pe
        public com.ss.android.socialbase.downloader.network.v d() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.pe
        public com.ss.android.socialbase.downloader.exception.p e(Throwable th, String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.pe
        public boolean e() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.pe
        public boolean e(Throwable th) {
            return false;
        }
    }

    IDownloadHttpService bf();

    com.ss.android.socialbase.downloader.network.v d();

    com.ss.android.socialbase.downloader.exception.p e(Throwable th, String str);

    boolean e();

    boolean e(Throwable th);
}

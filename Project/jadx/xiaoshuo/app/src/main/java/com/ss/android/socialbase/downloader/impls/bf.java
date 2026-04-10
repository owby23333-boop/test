package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: loaded from: classes4.dex */
public class bf implements com.ss.android.socialbase.downloader.downloader.p {
    @Override // com.ss.android.socialbase.downloader.downloader.p
    public int e(int i, com.ss.android.socialbase.downloader.network.xu xuVar) {
        if (xuVar.ordinal() <= com.ss.android.socialbase.downloader.network.xu.MODERATE.ordinal()) {
            return 1;
        }
        return xuVar == com.ss.android.socialbase.downloader.network.xu.GOOD ? i - 1 : i;
    }
}

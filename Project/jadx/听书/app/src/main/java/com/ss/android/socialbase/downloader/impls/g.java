package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: loaded from: classes4.dex */
public class g implements com.ss.android.socialbase.downloader.downloader.fo {
    @Override // com.ss.android.socialbase.downloader.downloader.fo
    public int z(int i, com.ss.android.socialbase.downloader.fo.i iVar) {
        if (iVar.ordinal() <= com.ss.android.socialbase.downloader.fo.i.MODERATE.ordinal()) {
            return 1;
        }
        return iVar == com.ss.android.socialbase.downloader.fo.i.GOOD ? i - 1 : i;
    }
}

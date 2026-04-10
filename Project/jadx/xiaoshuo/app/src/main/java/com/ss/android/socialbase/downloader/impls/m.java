package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.k;
import com.yuewen.mw3;

/* JADX INFO: loaded from: classes4.dex */
public class m implements k {
    @Override // com.ss.android.socialbase.downloader.downloader.k
    public long e(int i, int i2) {
        if (i == 1) {
            return 3000L;
        }
        if (i == 2) {
            return mw3.f;
        }
        if (i == 3) {
            return 30000L;
        }
        return i > 3 ? 300000L : 0L;
    }
}

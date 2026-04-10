package com.ss.android.socialbase.downloader.impls;

import com.anythink.expressad.video.module.a.a.m;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultRetryDelayTimeCalculator implements IRetryDelayTimeCalculator {
    @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
    public long calculateRetryDelayTime(int i2, int i3) {
        if (i2 == 1) {
            return m.ag;
        }
        if (i2 == 2) {
            return 15000L;
        }
        if (i2 == 3) {
            return 30000L;
        }
        return i2 > 3 ? 300000L : 0L;
    }
}

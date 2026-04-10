package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;

/* JADX INFO: loaded from: classes3.dex */
public class RetryDelayTimeParamCalculator implements IRetryDelayTimeCalculator {
    private final long[] mTimeArray;

    public RetryDelayTimeParamCalculator(String str) {
        this.mTimeArray = parseTimeArray(str);
    }

    private long[] parseTimeArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length == 0) {
                return null;
            }
            long[] jArr = new long[strArrSplit.length];
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                jArr[i2] = Long.parseLong(strArrSplit[i2]);
            }
            return jArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
    public long calculateRetryDelayTime(int i2, int i3) {
        long[] jArr = this.mTimeArray;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int length = i2 - 1;
        if (length < 0) {
            length = 0;
        }
        long[] jArr2 = this.mTimeArray;
        if (length > jArr2.length - 1) {
            length = jArr2.length - 1;
        }
        return this.mTimeArray[length];
    }
}

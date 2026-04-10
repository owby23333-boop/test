package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.k;

/* JADX INFO: loaded from: classes4.dex */
public class l implements k {
    private final long[] e;

    public l(String str) {
        this.e = e(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public long e(int i, int i2) {
        long[] jArr = this.e;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int length = i - 1;
        if (length < 0) {
            length = 0;
        }
        if (length > jArr.length - 1) {
            length = jArr.length - 1;
        }
        return jArr[length];
    }

    private long[] e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length == 0) {
                return null;
            }
            long[] jArr = new long[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                jArr[i] = Long.parseLong(strArrSplit[i]);
            }
            return jArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}

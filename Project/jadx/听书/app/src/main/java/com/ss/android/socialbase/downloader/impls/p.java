package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.tb;

/* JADX INFO: loaded from: classes4.dex */
public class p implements tb {
    private final long[] z;

    public p(String str) {
        this.z = z(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tb
    public long z(int i, int i2) {
        long[] jArr = this.z;
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

    private long[] z(String str) {
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
            com.bytedance.sdk.component.utils.wp.z(th);
            return null;
        }
    }
}

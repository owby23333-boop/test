package com.yuewen;

import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class q61 {
    public static String a(long j, long... jArr) {
        for (int i = 0; i < jArr.length; i++) {
            if (j < jArr[i]) {
                if (i == 0) {
                    return Constants.ACCEPT_TIME_SEPARATOR_SERVER + jArr[i];
                }
                return jArr[i - 1] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + jArr[i];
            }
        }
        return jArr[jArr.length - 1] + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    }
}

package com.dangdang.zframework.utils;

/* JADX INFO: loaded from: classes10.dex */
public class ClickUtil {
    private static long mLastClickTime;

    public static boolean checkFastClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - mLastClickTime;
        if (0 >= j || j >= 500) {
            mLastClickTime = jCurrentTimeMillis;
            return false;
        }
        mLastClickTime = jCurrentTimeMillis;
        return true;
    }
}

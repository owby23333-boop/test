package com.market.sdk.utils;

import android.os.Build;
import com.market.sdk.MarketManager;
import com.xiaomi.onetrack.util.z;

/* JADX INFO: loaded from: classes7.dex */
public class VersionUtils {
    public static boolean isDevVersionLaterThan(String str) {
        try {
            if (!str.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}(-internal)?")) {
                return false;
            }
            String str2 = Build.VERSION.INCREMENTAL;
            if (!str2.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}(-internal)?")) {
                return false;
            }
            String strReplace = str2.replace("-internal", "");
            String strReplace2 = str.replace("-internal", "");
            String[] strArrSplit = strReplace.split(z.f7779a);
            String[] strArrSplit2 = strReplace2.split(z.f7779a);
            return ((Long.parseLong(strArrSplit[0]) * 10000) + (Long.parseLong(strArrSplit[1]) * 100)) + Long.parseLong(strArrSplit[2]) >= ((Long.parseLong(strArrSplit2[0]) * 10000) + (Long.parseLong(strArrSplit2[1]) * 100)) + Long.parseLong(strArrSplit2[2]);
        } catch (Throwable th) {
            android.util.Log.d(MarketManager.TAG, th.toString());
            return false;
        }
    }

    public static boolean isStableVersionLaterThan(String str) {
        try {
            if (!str.matches("V\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}")) {
                Log.d(MarketManager.TAG, "targetVersion: " + str);
                return false;
            }
            String str2 = Build.VERSION.INCREMENTAL;
            if (!str2.matches("V\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}\\..*")) {
                Log.d(MarketManager.TAG, "currVersion: " + str2);
                Log.d(MarketManager.TAG, "targetVersion: " + str);
                return false;
            }
            String[] strArrSplit = str2.split(z.f7779a);
            String[] strArrSplit2 = str.split(z.f7779a);
            long j = (Long.parseLong(strArrSplit[0].substring(1)) * 1000000) + (Long.parseLong(strArrSplit[1]) * 10000) + (Long.parseLong(strArrSplit[2]) * 100) + Long.parseLong(strArrSplit[3]);
            long j2 = (Long.parseLong(strArrSplit2[0].substring(1)) * 1000000) + (Long.parseLong(strArrSplit2[1]) * 10000) + (Long.parseLong(strArrSplit2[2]) * 100) + Long.parseLong(strArrSplit2[3]);
            Log.d(MarketManager.TAG, "currVersionValue: " + j);
            Log.d(MarketManager.TAG, "targetVersionValue: " + j2);
            return j >= j2;
        } catch (Throwable th) {
            android.util.Log.d(MarketManager.TAG, th.toString());
            return false;
        }
    }
}

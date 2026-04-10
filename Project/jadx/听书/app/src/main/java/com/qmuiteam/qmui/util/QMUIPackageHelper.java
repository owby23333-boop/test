package com.qmuiteam.qmui.util;

import android.content.Context;
import com.funny.audio.core.utils.FileUtils;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIPackageHelper {
    private static String appVersionName = null;
    private static int fixVersion = -1;
    private static String majorMinorVersion = null;
    private static int majorVersion = -1;
    private static int minorVersion = -1;

    public static String getAppVersion(Context context) {
        if (appVersionName == null) {
            try {
                appVersionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String str = appVersionName;
        return str == null ? "" : str;
    }

    public static String getMajorMinorVersion(Context context) {
        String str = majorMinorVersion;
        if (str == null || str.equals("")) {
            majorMinorVersion = getMajorVersion(context) + FileUtils.FILE_EXTENSION_SEPARATOR + getMinorVersion(context);
        }
        return majorMinorVersion;
    }

    private static int getMajorVersion(Context context) {
        if (majorVersion == -1) {
            String[] strArrSplit = getAppVersion(context).split("\\.");
            if (strArrSplit.length != 0) {
                majorVersion = Integer.parseInt(strArrSplit[0]);
            }
        }
        return majorVersion;
    }

    private static int getMinorVersion(Context context) {
        if (minorVersion == -1) {
            String[] strArrSplit = getAppVersion(context).split("\\.");
            if (strArrSplit.length >= 2) {
                minorVersion = Integer.parseInt(strArrSplit[1]);
            }
        }
        return minorVersion;
    }

    public static int getFixVersion(Context context) {
        if (fixVersion == -1) {
            String[] strArrSplit = getAppVersion(context).split("\\.");
            if (strArrSplit.length >= 3) {
                fixVersion = Integer.parseInt(strArrSplit[2]);
            }
        }
        return fixVersion;
    }
}

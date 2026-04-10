package com.msa.sdk.tool;

import android.content.Context;
import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes3.dex */
public class MsaUtils {
    public static final String MSA_GLOBAL_PACKAGE_NAME = "com.miui.msa.global";
    public static final String MSA_PACKAGE_NAME = "com.miui.systemAdSolution";

    private MsaUtils() {
    }

    public static String getMsaPackageName(Context context) {
        return (isInternationalBuild() && isPackageInstalled(context, MSA_GLOBAL_PACKAGE_NAME)) ? MSA_GLOBAL_PACKAGE_NAME : "com.miui.systemAdSolution";
    }

    public static PackageInfo getPackageInfo(Context context, String str, int i) {
        try {
            return context.getPackageManager().getPackageInfo(str, i);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean isInternationalBuild() {
        try {
            Object obj = Class.forName("miui.os.Build").getField("IS_INTERNATIONAL_BUILD").get(null);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean isPackageInstalled(Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str, 0);
        return (packageInfo == null || packageInfo.applicationInfo == null) ? false : true;
    }
}

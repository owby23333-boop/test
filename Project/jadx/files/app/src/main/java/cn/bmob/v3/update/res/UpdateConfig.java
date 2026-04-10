package cn.bmob.v3.update.res;

import android.content.Context;
import android.text.TextUtils;
import cn.bmob.v3.util.ManifestUtils;

/* JADX INFO: loaded from: classes.dex */
public class UpdateConfig {
    private static String channel = null;
    private static boolean isSilentDownload = false;
    private static boolean isUpdateCheck = true;
    private static boolean isUpdateForce = false;
    private static boolean updateOnlyWifi = true;

    public static String getChannel(Context context) {
        if (TextUtils.isEmpty(channel)) {
            channel = ManifestUtils.getMetaData("BMOB_CHANNEL");
        }
        return channel;
    }

    public static boolean isSilentDownload() {
        return isSilentDownload;
    }

    public static boolean isUpdateCheck() {
        return isUpdateCheck;
    }

    public static boolean isUpdateForce() {
        return isUpdateForce;
    }

    public static boolean isUpdateOnlyWifi() {
        return updateOnlyWifi;
    }

    public static void setChannel(String str) {
        channel = str;
    }

    public static void setSilentDownload(boolean z2) {
        isSilentDownload = z2;
    }

    public static void setUpdateCheck(boolean z2) {
        isUpdateCheck = z2;
    }

    public static void setUpdateForce(boolean z2) {
        isUpdateForce = z2;
    }

    public static void setUpdateOnlyWifi(boolean z2) {
        updateOnlyWifi = z2;
    }
}

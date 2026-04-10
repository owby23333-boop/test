package com.xuexiang.xupdate.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.xuexiang.xupdate._XUpdate;
import com.xuexiang.xupdate.utils.ShellUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class ApkInstallUtils {
    private static final int APP_INSTALL_AUTO = 0;
    private static final int APP_INSTALL_EXTERNAL = 2;
    private static final int APP_INSTALL_INTERNAL = 1;
    public static final int REQUEST_CODE_INSTALL_APP = 999;
    private static boolean sSupportSilentInstall = true;

    public static boolean isSupportSilentInstall() {
        return sSupportSilentInstall;
    }

    public static void setSupportSilentInstall(boolean z) {
        sSupportSilentInstall = z;
    }

    private ApkInstallUtils() {
        throw new UnsupportedOperationException("Do not need instantiate!");
    }

    public static boolean install(Context context, File file) throws IOException {
        boolean zIsSupportSilentInstall = isSupportSilentInstall();
        String canonicalPath = file.getCanonicalPath();
        return zIsSupportSilentInstall ? install(context, canonicalPath) : installNormal(context, canonicalPath);
    }

    public static boolean install(Context context, String str) {
        if (isSystemApplication(context) || ShellUtils.checkRootPermission()) {
            return installAppSilent(context, str);
        }
        return installNormal(context, str);
    }

    public static boolean installAppSilent(Context context, String str) {
        return installAppSilentAbove24(context.getPackageName(), str);
    }

    private static boolean installAppSilentBelow24(Context context, String str) {
        if (!FileUtils.isFileExists(FileUtils.getFileByPath(str))) {
            return false;
        }
        ShellUtils.CommandResult commandResultExecCommand = ShellUtils.execCommand("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install " + (" -r " + getInstallLocationParams()) + " " + str.replace(" ", "\\ "), !isSystemApplication(context), true);
        if (commandResultExecCommand.successMsg != null) {
            return commandResultExecCommand.successMsg.contains("Success") || commandResultExecCommand.successMsg.contains("success");
        }
        return false;
    }

    private static String getInstallLocationParams() {
        int installLocation = getInstallLocation();
        return installLocation != 1 ? installLocation != 2 ? "" : "-s" : "-f";
    }

    public static int getInstallLocation() {
        int i = 1;
        ShellUtils.CommandResult commandResultExecCommand = ShellUtils.execCommand("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm get-install-location", false, true);
        if (commandResultExecCommand.result == 0 && commandResultExecCommand.successMsg != null && commandResultExecCommand.successMsg.length() > 0) {
            try {
                int i2 = Integer.parseInt(commandResultExecCommand.successMsg.substring(0, 1));
                if (i2 != 1) {
                    i = 2;
                    if (i2 != 2) {
                    }
                }
                return i;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private static boolean installAppSilentAbove24(String str, String str2) {
        if (!FileUtils.isFileExists(FileUtils.getFileByPath(str2))) {
            return false;
        }
        ShellUtils.CommandResult commandResultExecCommand = ShellUtils.execCommand("pm install -i " + str + " --user 0 " + str2, isDeviceRooted());
        return commandResultExecCommand.successMsg != null && commandResultExecCommand.successMsg.toLowerCase().contains("success");
    }

    private static boolean installNormal(Context context, String str) {
        File fileByPath = FileUtils.getFileByPath(str);
        return FileUtils.isFileExists(fileByPath) && installNormal(context, fileByPath);
    }

    private static boolean installNormal(Context context, File file) {
        try {
            Intent installAppIntent = getInstallAppIntent(file);
            if (context.getPackageManager().queryIntentActivities(installAppIntent, 0).size() > 0) {
                if (context instanceof Activity) {
                    ((Activity) context).startActivityForResult(installAppIntent, 999);
                    return true;
                }
                context.startActivity(installAppIntent);
                return true;
            }
        } catch (Exception unused) {
            _XUpdate.onUpdateError(5000, "Apk installation failed using the intent of the system!");
        }
        return false;
    }

    public static Intent getInstallAppIntent(File file) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.addFlags(65);
            intent.setDataAndType(FileUtils.getUriByFile(file), "application/vnd.android.package-archive");
            return intent;
        } catch (Exception unused) {
            _XUpdate.onUpdateError(5000, "Failed to get intent for installation！");
            return null;
        }
    }

    private static boolean isDeviceRooted() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/"};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i] + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSystemApplication(Context context) {
        return context != null && isSystemApplication(context, context.getPackageName());
    }

    private static boolean isSystemApplication(Context context, String str) {
        return context != null && isSystemApplication(context.getPackageManager(), str);
    }

    private static boolean isSystemApplication(PackageManager packageManager, String str) {
        if (packageManager != null && str != null && str.length() != 0) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
                if (applicationInfo != null) {
                    return (applicationInfo.flags & 1) > 0;
                }
                return false;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

package com.iflytek.aikit.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.iflytek.aikit.core.Auth;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceIdUtil {
    public static String fa() {
        return "";
    }

    @SuppressLint({"HardwareIds"})
    public static String fb() {
        return "";
    }

    @SuppressLint({"HardwareIds"})
    public static String fc() {
        return "";
    }

    public static String fd() {
        return "";
    }

    public static String fe() {
        return "";
    }

    public static boolean ff() {
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String fg() {
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
            if (packageInfo == null) {
                return "";
            }
            try {
                return Arrays.toString(packageInfo.signatures[0].toByteArray());
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static String fh() {
        return getContext().getPackageName();
    }

    public static Context getContext() {
        return Auth.getInst().getContext();
    }

    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }
}

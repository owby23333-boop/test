package com.xiaomi.verificationsdk.internal;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Build;
import com.xiaomi.accountsdk.utils.AccountLogger;
import com.xiaomi.ad.common.util.SignatureUtils;

/* JADX INFO: loaded from: classes8.dex */
public class EmulatorDetector {
    private static final String TAG = "EmulatorDetector";
    private static int rating = -1;

    public static String getDeviceListing() {
        return "Build.PRODUCT: " + Build.PRODUCT + "\nBuild.MANUFACTURER: " + Build.MANUFACTURER + "\nBuild.BRAND: " + Build.BRAND + "\nBuild.DEVICE: " + Build.DEVICE + "\nBuild.MODEL: " + Build.MODEL + "\nBuild.HARDWARE: " + Build.HARDWARE + "\nBuild.FINGERPRINT: " + Build.FINGERPRINT + "\nBuild.TAGS: " + Build.TAGS + "\nGL_RENDERER: " + GLES20.glGetString(7937) + "\nGL_VENDOR: " + GLES20.glGetString(7936) + "\nGL_VERSION: " + GLES20.glGetString(7938) + "\nGL_EXTENSIONS: " + GLES20.glGetString(7939) + SignatureUtils.DELIMITER;
    }

    private static final String getProp(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isEmulator(android.content.Context r15) {
        /*
            Method dump skipped, instruction units count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.verificationsdk.internal.EmulatorDetector.isEmulator(android.content.Context):boolean");
    }

    public static boolean isEmulatorAbsoluly(Context context) {
        if (mayOnEmulatorViaQEMU(context)) {
            return true;
        }
        String str = Build.PRODUCT;
        if (!str.contains("sdk") && !str.contains("sdk_x86") && !str.contains("sdk_google") && !str.contains("Andy") && !str.contains("Droid4X") && !str.contains("nox") && !str.contains("vbox86p") && !str.contains("aries")) {
            String str2 = Build.MANUFACTURER;
            if (str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("nox") || str2.contains("TiantianVM") || Build.BRAND.contains("Andy")) {
                return true;
            }
            String str3 = Build.DEVICE;
            if (!str3.contains("Andy") && !str3.contains("Droid4X") && !str3.contains("nox") && !str3.contains("vbox86p") && !str3.contains("aries")) {
                String str4 = Build.MODEL;
                if (!str4.contains("Emulator") && !str4.equals("google_sdk") && !str4.contains("Droid4X") && !str4.contains("TiantianVM") && !str4.contains("Andy") && !str4.equals("Android SDK built for x86_64") && !str4.equals("Android SDK built for x86")) {
                    String str5 = Build.HARDWARE;
                    if (!str5.equals("vbox86") && !str5.contains("nox") && !str5.contains("ttVM_x86")) {
                        String str6 = Build.FINGERPRINT;
                        if (!str6.contains("generic/sdk/generic") && !str6.contains("generic_x86/sdk_x86/generic_x86") && !str6.contains("Andy") && !str6.contains("ttVM_Hdragon") && !str6.contains("generic/google_sdk/generic") && !str6.contains("vbox86p") && !str6.contains("generic/vbox86p/vbox86p")) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void logcat() {
        AccountLogger.log(TAG, getDeviceListing());
    }

    private static final boolean mayOnEmulatorViaQEMU(Context context) {
        return "1".equals(getProp(context, "ro.kernel.qemu"));
    }
}

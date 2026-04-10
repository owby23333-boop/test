package cn.bmob.v3.http;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import cn.bmob.v3.helper.BmobNative;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.EncryptMD5;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class RequestUtils {
    public static String decryDataWithSecretKey(String str) {
        return BmobNative.decryptByKey(str);
    }

    public static String decrySecretDataWithKey2(String str, String str2) {
        return BmobNative.decrypt(str, str2);
    }

    public static String encryDataWithSecretKey(String str) {
        return BmobNative.encryptByKey(str);
    }

    public static String encrySecretDataWithKey1(String str, String str2) {
        return BmobNative.encrypt(str, str2);
    }

    public static String getAcceptId() {
        return BmobNative.getAcceptId();
    }

    public static String getAppKey() {
        return BmobNative.getAppId();
    }

    public static String getAppSign(Context context) {
        String str;
        if (isDebuggable(context)) {
            str = getSignature(context) + "/0";
        } else {
            str = getSignature(context) + "/1";
        }
        BLog.e("appSign:" + getSignature(context));
        return str;
    }

    public static String getCombinedDeviceID(Context context) {
        String fakeUniqueID = getFakeUniqueID();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(fakeUniqueID.getBytes(), 0, fakeUniqueID.length());
            byte[] bArrDigest = messageDigest.digest();
            String str = new String();
            for (byte b : bArrDigest) {
                int i2 = b & 255;
                if (i2 <= 15) {
                    str = str + "0";
                }
                str = str + Integer.toHexString(i2);
            }
            return str.toUpperCase(Locale.CHINA);
        } catch (Exception e2) {
            e2.printStackTrace();
            return fakeUniqueID.toLowerCase(Locale.CHINA);
        }
    }

    private static String getFakeUniqueID() {
        return "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }

    public static String getId() {
        return BmobNative.getAppId().substring(r0.length() - 6);
    }

    public static String getInstallationId(Context context) {
        String fakeUniqueID = getFakeUniqueID();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(fakeUniqueID.getBytes(), 0, fakeUniqueID.length());
            byte[] bArrDigest = messageDigest.digest();
            String str = new String();
            for (byte b : bArrDigest) {
                int i2 = b & 255;
                if (i2 <= 15) {
                    str = str + "0";
                }
                str = str + Integer.toHexString(i2);
            }
            return str.toUpperCase(Locale.CHINA);
        } catch (Exception e2) {
            e2.printStackTrace();
            return fakeUniqueID.toUpperCase(Locale.CHINA);
        }
    }

    private static String getSignature(Context context) {
        try {
            return EncryptMD5.hexdigest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static long getTimeStamp() {
        return (System.currentTimeMillis() / 1000) - ((long) Integer.parseInt(BmobNative.getInterval()));
    }

    private static boolean isDebuggable(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}

package cn.bmob.v3.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import com.anythink.expressad.foundation.g.a;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class EncryptUtils {
    public static String decrypt(String str, String str2, String str3) {
        try {
            if (str.length() != 16 || str2.length() != 16) {
                return null;
            }
            byte[] bytes = str.getBytes(a.bN);
            byte[] bytes2 = str2.getBytes(a.bN);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(str3, 2)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str, String str2, String str3) {
        try {
            if (str.length() != 16 || str2.length() != 16) {
                return null;
            }
            byte[] bytes = str.getBytes(a.bN);
            byte[] bytes2 = str2.getBytes(a.bN);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str3.getBytes()), 2);
        } catch (Exception e2) {
            System.err.println(e2.getMessage());
            return null;
        }
    }

    public static String encryptAgent(String str, String str2) {
        String strSubstring = str.substring(str.length() - 16);
        return encrypt(strSubstring, strSubstring, str2);
    }

    private static String getAndroidId(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getAppSign(Context context) {
        if (isDebuggable(context)) {
            return getSignature(context) + "/0";
        }
        return getSignature(context) + "/1";
    }

    private static String getFakeUniqueID() {
        return "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }

    public static String getInstallationId(Context context) {
        String str = getFakeUniqueID() + getAndroidId(context);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(), 0, str.length());
            byte[] bArrDigest = messageDigest.digest();
            String str2 = new String();
            for (byte b : bArrDigest) {
                int i2 = b & 255;
                if (i2 <= 15) {
                    str2 = str2 + "0";
                }
                str2 = str2 + Integer.toHexString(i2);
            }
            return str2.toUpperCase(Locale.CHINA);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str.toUpperCase(Locale.CHINA);
        }
    }

    private static final String getOldUserAgent(Context context) {
        try {
            String packageName = context.getPackageName();
            return packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "volley/0";
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

    public static final String getUserAgent(Context context) {
        return getOldUserAgent(context) + String.valueOf(System.currentTimeMillis()) + "Androidv3.6.9";
    }

    private static boolean isContains(Context context, String str) {
        String[] strArr;
        try {
            strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            strArr = null;
        }
        ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            for (String str2 : strArr) {
                arrayList.add(str2);
            }
        }
        return arrayList.contains(str);
    }

    private static boolean isDebuggable(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void main(String[] strArr) {
        BLog.e("" + decrypt("c377221481e717db", "c377221481e717db", "p0frH2rtlSUlqSQ3y9NVDL8UopNj+k+fhEXfO5o2R2LU9ZncIixImnHlTYIfakbSfRb3feNLxvgz4Idb9exz3BWmbIgj/b1TPe17bwhWxws2v1rhLxYyHSwRwSzDEN5PtvkJDlSyA=="));
    }
}

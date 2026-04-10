package cn.bmob.v3.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AppUtils {
    private static final String MD5 = "MD5";
    private static final String SHA1 = "SHA1";
    private static final String SHA256 = "SHA256";

    public static String getMD5(Context context, String str) {
        return getSingInfo(context, str, "MD5").get(0);
    }

    public static String getSHA1(Context context, String str) {
        return getSingInfo(context, str, SHA1).get(0);
    }

    public static String getSHA256(Context context, String str) {
        return getSingInfo(context, str, SHA256).get(0);
    }

    public static String getSignature(Context context) {
        return getMD5(context, context.getPackageName());
    }

    public static String getSignatureString(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append((CharSequence) Integer.toHexString((b & 255) | 256), 1, 3);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "error!";
        }
    }

    public static Signature[] getSignatures(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageCodePath(), 64).signatures;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> getSingInfo(Context context, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : getSignatures(context, str)) {
                String signatureString = "error!";
                if ("MD5".equals(str2)) {
                    signatureString = getSignatureString(signature, "MD5");
                } else if (SHA1.equals(str2)) {
                    signatureString = getSignatureString(signature, SHA1);
                } else if (SHA256.equals(str2)) {
                    signatureString = getSignatureString(signature, SHA256);
                }
                arrayList.add(signatureString);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }
}

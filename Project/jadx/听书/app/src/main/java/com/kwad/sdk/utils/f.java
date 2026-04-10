package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    private static HashMap<String, ArrayList<String>> aYr = new HashMap<>();
    private static String aYs;

    private static ArrayList<String> M(Context context, String str) {
        String packageName;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (aYr.get(str) != null) {
            return aYr.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : getSignatures(context, packageName)) {
                String strA = "error!";
                if ("MD5".equals(str)) {
                    strA = a(signature, "MD5");
                } else if ("SHA1".equals(str)) {
                    strA = a(signature, "SHA1");
                } else if ("SHA256".equals(str)) {
                    strA = a(signature, "SHA256");
                }
                arrayList.add(strA);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("AppSigningUtil", "签名信息列表获取失败 " + e.getMessage());
        }
        aYr.put(str, arrayList);
        return arrayList;
    }

    public static String cs(Context context) {
        if (!TextUtils.isEmpty(aYs)) {
            return aYs;
        }
        ArrayList<String> arrayListM = M(context, "SHA1");
        if (arrayListM != null && arrayListM.size() != 0) {
            aYs = arrayListM.get(0);
        }
        return aYs;
    }

    private static Signature[] getSignatures(Context context, String str) {
        try {
            PackageInfo packageInfo = y.getPackageInfo(context, str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("AppSigningUtil", e.getMessage());
            return null;
        }
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("AppSigningUtil", e.getMessage());
            return "error!";
        }
    }
}

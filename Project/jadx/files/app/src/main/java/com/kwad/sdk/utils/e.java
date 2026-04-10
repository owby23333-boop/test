package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static HashMap<String, ArrayList<String>> axM = new HashMap<>();
    private static String axN;

    @Nullable
    private static ArrayList<String> B(Context context, String str) {
        String packageName;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (axM.get(str) != null) {
            return axM.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : C(context, packageName)) {
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
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.e("AppSigningUtil", "签名信息列表获取失败 " + e2.getMessage());
        }
        axM.put(str, arrayList);
        return arrayList;
    }

    private static Signature[] C(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.e("AppSigningUtil", e2.getMessage());
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
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.e("AppSigningUtil", e2.getMessage());
            return "error!";
        }
    }

    @Nullable
    public static String bI(Context context) {
        if (!TextUtils.isEmpty(axN)) {
            return axN;
        }
        ArrayList<String> arrayListB = B(context, "SHA1");
        if (arrayListB != null && arrayListB.size() != 0) {
            axN = arrayListB.get(0);
        }
        return axN;
    }
}

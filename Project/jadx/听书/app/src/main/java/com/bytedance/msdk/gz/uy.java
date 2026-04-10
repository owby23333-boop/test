package com.bytedance.msdk.gz;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    private static HashMap<String, ArrayList<String>> z = new HashMap<>();

    public static ArrayList<String> z(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (z.get(str) != null) {
                return z.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : g(context, packageName)) {
                    String strZ = "error!";
                    if ("MD5".equals(str)) {
                        strZ = z(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        strZ = z(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        strZ = z(signature, "SHA256");
                    }
                    arrayList.add(strZ);
                }
            } catch (Exception e) {
                com.bytedance.msdk.z.gc.dl.dl(e.toString());
            }
            z.put(str, arrayList);
        }
        return arrayList;
    }

    private static Signature[] g(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            com.bytedance.msdk.z.gc.dl.dl(e.toString());
            return null;
        }
    }

    private static String z(Signature signature, String str) {
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
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception e) {
            com.bytedance.msdk.z.gc.dl.dl(e.toString());
            return "error!";
        }
    }
}

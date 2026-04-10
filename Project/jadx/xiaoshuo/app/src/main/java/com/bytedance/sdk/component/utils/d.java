package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import com.yuewen.yg3;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static HashMap<String, ArrayList<String>> e = new HashMap<>();

    private static Signature[] bf(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e2) {
            wu.d(e2.toString());
            return null;
        }
    }

    public static ArrayList<String> e(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (e.get(str) != null) {
                return e.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : bf(context, packageName)) {
                    String strE = "error!";
                    if ("MD5".equals(str)) {
                        strE = e(signature, "MD5");
                    } else if (yg3.b.f20351b.equals(str)) {
                        strE = e(signature, yg3.b.f20351b);
                    } else if ("SHA256".equals(str)) {
                        strE = e(signature, "SHA256");
                    }
                    arrayList.add(strE);
                }
            } catch (Exception e2) {
                wu.d(e2.toString());
            }
            e.put(str, arrayList);
        }
        return arrayList;
    }

    public static String e(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayListE = e(context, yg3.b.f20351b);
        if (arrayListE != null && arrayListE.size() != 0) {
            for (int i = 0; i < arrayListE.size(); i++) {
                sb.append(arrayListE.get(i));
                if (i < arrayListE.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static String e(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception e2) {
            wu.d(e2.toString());
            return "error!";
        }
    }
}

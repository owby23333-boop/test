package com.tramini.plugin.a.k;

import com.umeng.analytics.pro.cb;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (int i2 = 0; i2 < bArrDigest.length; i2++) {
                sb.append(a[(bArrDigest[i2] & 240) >>> 4]);
                sb.append(a[bArrDigest[i2] & cb.f19604m]);
            }
            return sb.toString().toLowerCase();
        } catch (Exception unused) {
            return "";
        }
    }
}

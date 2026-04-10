package com.ss.android.socialbase.appdownloader.vn;

import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(com.ss.android.socialbase.downloader.zk.vn.e(str), 0);
        int length = str2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (byte b2 : bArrDecode) {
            if (i >= length) {
                i %= length;
            }
            sb.append((char) (b2 ^ str2.charAt(i)));
            i++;
        }
        return sb.toString();
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(com.ss.android.socialbase.downloader.zk.vn.e(str), 0));
    }
}

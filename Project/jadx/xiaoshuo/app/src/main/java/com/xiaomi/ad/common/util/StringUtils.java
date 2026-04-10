package com.xiaomi.ad.common.util;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class StringUtils {
    public static String avoidNull(String str) {
        return str == null ? "" : str;
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        if (charArray.length != charArray2.length) {
            return false;
        }
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            char c2 = charArray2[i];
            if (c != c2 && c + ' ' != c2 && c - ' ' != c2) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String toUpperCace(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        boolean z = charSequence instanceof String;
        char[] charArray = ((String) charSequence).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c >= 'a' && c <= 'z') {
                charArray[i] = (char) (c - ' ');
            }
        }
        return new String(charArray);
    }
}

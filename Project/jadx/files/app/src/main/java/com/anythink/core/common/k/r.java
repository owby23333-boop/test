package com.anythink.core.common.k;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    private static String a(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == length2) {
            return str;
        }
        int iAbs = Math.abs(length2 - length);
        StringBuilder sb = new StringBuilder(str);
        for (int i2 = 0; i2 < iAbs; i2++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}

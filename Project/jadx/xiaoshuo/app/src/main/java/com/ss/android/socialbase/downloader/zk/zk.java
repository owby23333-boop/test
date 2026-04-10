package com.ss.android.socialbase.downloader.zk;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
public class zk {
    public static StringBuilder bf(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            e(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder e(StringBuilder sb, String str) {
        sb.append(Typography.quote);
        sb.append(str);
        sb.append(Typography.quote);
        return sb;
    }

    public static StringBuilder e(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append(Typography.quote);
        return sb;
    }

    public static StringBuilder e(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(Typography.quote);
            sb.append(strArr[i]);
            sb.append(Typography.quote);
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String bf(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append(Typography.quote + str + Typography.quote);
        sb.append(" (");
        e(sb, strArr);
        sb.append(") VALUES (");
        e(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static StringBuilder e(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder e(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            e(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String e(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(Typography.quote);
        sb.append(str2);
        sb.append(Typography.quote);
        sb.append(" (");
        e(sb, strArr);
        sb.append(") VALUES (");
        e(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String e(String str, String[] strArr) {
        String str2 = Typography.quote + str + Typography.quote;
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            e(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String e(String str, String[] strArr, String[] strArr2) {
        String str2 = Typography.quote + str + Typography.quote;
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        bf(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            e(sb, str2, strArr2);
        }
        return sb.toString();
    }
}

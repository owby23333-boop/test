package com.ss.android.socialbase.downloader.pf;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
public class fo {
    public static StringBuilder z(StringBuilder sb, String str) {
        sb.append(Typography.quote).append(str).append(Typography.quote);
        return sb;
    }

    public static StringBuilder z(StringBuilder sb, String str, String str2) {
        sb.append(str).append(".\"").append(str2).append(Typography.quote);
        return sb;
    }

    public static StringBuilder z(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(Typography.quote).append(strArr[i]).append(Typography.quote);
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder z(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder g(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            z(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder z(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            z(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String z(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(Typography.quote).append(str2).append("\" (");
        z(sb, strArr);
        sb.append(") VALUES (");
        z(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String z(String str, String[] strArr) {
        String str2 = "\"" + str + Typography.quote;
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            z(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String z(String str, String[] strArr, String[] strArr2) {
        String str2 = "\"" + str + Typography.quote;
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2).append(" SET ");
        g(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            z(sb, str2, strArr2);
        }
        return sb.toString();
    }

    public static String g(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append("\"" + str + Typography.quote).append(" (");
        z(sb, strArr);
        sb.append(") VALUES (");
        z(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }
}

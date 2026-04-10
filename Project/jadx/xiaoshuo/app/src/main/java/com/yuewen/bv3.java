package com.yuewen;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Base64;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes5.dex */
public class bv3 {
    public static String a(String str, int i) {
        return new BigDecimal(str).setScale(i, RoundingMode.CEILING).toString();
    }

    public static String b(String str, int i) {
        return new BigDecimal(str).setScale(i, RoundingMode.FLOOR).toString();
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d(String str) {
        return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(str.getBytes(), 0).trim();
    }

    public static int e(String str, String str2) {
        return f(str, str2, true);
    }

    public static int f(String str, String str2, boolean z) {
        if (str == str2) {
            return 0;
        }
        return str == null ? z ? -1 : 1 : str2 == null ? z ? 1 : -1 : str.compareTo(str2);
    }

    public static String g(String[] strArr, char c) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
            sb.append(c);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String h(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static boolean i(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static String j(String str, int i, boolean z) {
        if (str == null || str.length() <= i) {
            return str;
        }
        if (!z || str.endsWith("…") || str.endsWith("...")) {
            return str.substring(0, i);
        }
        return str.substring(0, i - 1) + "…";
    }

    public static SpannableString k(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), i, i2, 17);
        return spannableString;
    }

    public static SpannableString l(String str, int i) {
        if (str == null) {
            return null;
        }
        return m(str, 0, str.length(), i);
    }

    public static SpannableString m(String str, int i, int i2, int i3) {
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        return spannableString;
    }

    public static String n(String str) {
        return str == null ? "" : str;
    }

    public static boolean o(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }

    public static boolean p(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean q(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.isDigitsOnly(str);
    }

    public static String r(String str) {
        return str.replaceAll("\\s", "").trim();
    }

    public static boolean s(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.equals(str, str2)) {
            return true;
        }
        String strR = r(str);
        String strR2 = r(str2);
        if (strR.endsWith(strR2) || strR.startsWith(strR2) || strR2.startsWith(strR) || strR2.endsWith(strR)) {
            return true;
        }
        String strReplaceAll = strR.replaceAll("[(（].*/+.*[)）]", "");
        String strReplaceAll2 = strR2.replaceAll("[(（].*/+.*[)）]", "");
        return strReplaceAll.endsWith(strReplaceAll2) || strReplaceAll.startsWith(strReplaceAll2) || strReplaceAll2.startsWith(strReplaceAll) || strReplaceAll2.endsWith(strReplaceAll);
    }
}

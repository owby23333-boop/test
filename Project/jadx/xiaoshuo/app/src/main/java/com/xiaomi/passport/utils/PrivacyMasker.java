package com.xiaomi.passport.utils;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes8.dex */
public class PrivacyMasker {
    public static boolean isCommonEmail(String str) {
        String[] strArr = {"gmail.com", "aol.com", "outlook.com", "yahoo.com.cn", "yahoo.com", "hotmail.com", "163.com", "126.com", "qq.com", "sina.com", "sina.cn", "sohu.com"};
        for (int i = 0; i < 12; i++) {
            if (str.equals(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    public static String maskEmail(String str, char c, int i, int i2) {
        Matcher matcher = Pattern.compile("^(\\w+)@(\\w+(\\.\\w+)+)$").matcher(str);
        if (!matcher.find()) {
            return str;
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        int length = strGroup.length();
        StringBuilder sb = new StringBuilder(str.length());
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 < i || i4 >= length - i2) {
                sb.append(str.charAt(i4));
            } else if (i3 < 3) {
                i3++;
                sb.append(c);
            }
        }
        sb.append("@");
        if (isCommonEmail(strGroup2)) {
            sb.append(strGroup2);
        } else {
            String strSubstring = strGroup2.substring(strGroup2.lastIndexOf(Consts.DOT));
            String strSubstring2 = strGroup2.substring(0, strGroup2.lastIndexOf(46));
            for (int i5 = 0; i5 < strSubstring2.length(); i5++) {
                if (i5 <= 0 || i5 >= strSubstring2.length() - 1) {
                    sb.append(strSubstring2.charAt(i5));
                } else {
                    sb.append(c);
                }
            }
            sb.append(strSubstring);
        }
        return sb.toString();
    }

    public static String maskEmailAferLogin(String str) {
        return maskEmail(str, '*', 3, 1);
    }

    public static String maskNumber(CharSequence charSequence, char c, int i, int i2) {
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 < i || i3 > (length - 1) - i2) {
                sb.append(charSequence.charAt(i3));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String maskPlainPhoneAfterLogin(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return String.valueOf(charSequence);
        }
        int length = charSequence.length();
        return length >= 11 ? maskNumber(charSequence, '*', 3, 4) : (length > 10 || length < 9) ? (length > 8 || length < 7) ? String.valueOf(charSequence) : maskNumber(charSequence, '*', 2, 2) : maskNumber(charSequence, '*', 3, 3);
    }

    public static String maskPlainPhoneBeforeLogin(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return String.valueOf(charSequence);
        }
        int length = charSequence.length();
        return length >= 9 ? maskNumber(charSequence, '*', 3, 2) : (length > 8 || length < 7) ? String.valueOf(charSequence) : maskNumber(charSequence, '*', 2, 2);
    }
}

package com.dangdang.reader.utils;

import com.alibaba.android.arouter.utils.Consts;
import com.dangdang.zframework.utils.DateUtil;
import com.dangdang.zframework.utils.StringUtil;
import java.lang.Character;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes10.dex */
public class StringParseUtil {
    public static boolean checkNameChese(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (!isChinese(charArray[i])) {
                return false;
            }
        }
        return true;
    }

    public static String getBarThumbUrl(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        if (!str.contains("ddimg")) {
            return str;
        }
        try {
            int iLastIndexOf = str.lastIndexOf(Consts.DOT);
            return str.substring(0, iLastIndexOf) + "_c" + str.substring(iLastIndexOf, str.length());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getFormatIMTime(long j) {
        return getFormatTime(j, "MM-dd HH:mm", "yyyy-MM-dd HH:mm");
    }

    public static String getFormatTime(long j) {
        return getFormatTime(j, DateUtil.DATE_FORMAT_TYPE_5, "yyyy-MM-dd");
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(c);
        return unicodeBlockOf == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlockOf == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlockOf == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlockOf == Character.UnicodeBlock.GENERAL_PUNCTUATION || unicodeBlockOf == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || unicodeBlockOf == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static double parseDouble(String str, double d) {
        try {
            return Double.valueOf(str.trim()).doubleValue();
        } catch (Exception unused) {
            return d;
        }
    }

    public static float parseFloat(String str, float f) {
        try {
            return Float.valueOf(str.trim()).floatValue();
        } catch (Exception unused) {
            return f;
        }
    }

    public static int parseInt(String str, int i) {
        try {
            return Integer.valueOf(str.trim()).intValue();
        } catch (Exception unused) {
            return i;
        }
    }

    public static long parseLong(String str, long j) {
        try {
            return Long.valueOf(str.trim()).longValue();
        } catch (Exception unused) {
            return j;
        }
    }

    public static String getFormatTime(long j, String str, String str2) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i4 = calendar.get(1);
        int i5 = calendar.get(2);
        int i6 = calendar.get(5);
        if (i == i4 && i2 == i5 && i3 == i6) {
            return DateUtil.dateFormat(j, DateUtil.DATE_FORMAT_TYPE_7, "GMT+8");
        }
        calendar.add(5, -1);
        int i7 = calendar.get(1);
        int i8 = calendar.get(2);
        int i9 = calendar.get(5);
        if (i != i7 || i2 != i8 || i3 != i9) {
            return i == i4 ? DateUtil.dateFormat(j, str, "GMT+8") : DateUtil.dateFormat(j, str2, "GMT+8");
        }
        return "昨天 " + DateUtil.dateFormat(j, DateUtil.DATE_FORMAT_TYPE_7, "GMT+8");
    }

    public static long parseLong(String str) {
        return parseLong(str, -1L);
    }
}

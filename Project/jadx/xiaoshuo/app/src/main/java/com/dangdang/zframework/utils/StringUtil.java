package com.dangdang.zframework.utils;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import com.alibaba.android.arouter.utils.Consts;
import com.yuewen.eq2;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes10.dex */
public class StringUtil {
    private static final int BOOK_STATUS_HAS_DOWNLOAD = 5;

    public static abstract class CommonClickableSpan extends ClickableSpan {
        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    public static String ToDBC(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 12288) {
                charArray[i] = ' ';
            } else if (c > 65280 && c < 65375) {
                charArray[i] = (char) (c - 65248);
            }
        }
        return new String(charArray);
    }

    public static CharSequence colorToText(CharSequence charSequence, List<ForegroundColorSpan> list, String str) {
        if (list == null) {
            return charSequence;
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                charSequence = setSpanBetweenTokens(charSequence, str, list.get(i));
            } catch (Exception unused) {
                return "";
            }
        }
        return charSequence;
    }

    public static String getExpName(String str) {
        try {
            return str.substring(str.lastIndexOf(Consts.DOT) + 1, str.length());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isEmail(String str) {
        return Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[A-Za-z0-9]+((\\.|-|_)*[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$").matcher(str).matches();
    }

    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str) || eq2.g.equals(str);
    }

    public static boolean isMobileNO(String str) {
        return !TextUtils.isEmpty(str) && str.length() == 11 && str.matches("[0-9]+");
    }

    public static boolean isNumeric(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("-?[0-9]*").matcher(str).matches();
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

    private static CharSequence setSpanBetweenTokens(CharSequence charSequence, String str, CharacterStyle... characterStyleArr) {
        int length = str.length();
        int iIndexOf = charSequence.toString().indexOf(str) + length;
        int iIndexOf2 = charSequence.toString().indexOf(str, iIndexOf);
        if (iIndexOf <= -1 || iIndexOf2 <= -1) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        for (CharacterStyle characterStyle : characterStyleArr) {
            spannableStringBuilder.setSpan(characterStyle, iIndexOf, iIndexOf2, 0);
        }
        spannableStringBuilder.delete(iIndexOf2, iIndexOf2 + length);
        spannableStringBuilder.delete(iIndexOf - length, iIndexOf);
        return spannableStringBuilder;
    }

    public static String subStringByLenWithEndFlag(String str, int i, String str2) {
        if (TextUtils.isEmpty(str) || i <= 0) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i) + str2;
    }

    public static long parseLong(String str) {
        return parseLong(str, -1L);
    }
}

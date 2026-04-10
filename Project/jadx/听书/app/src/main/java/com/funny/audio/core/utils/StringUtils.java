package com.funny.audio.core.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class StringUtils {
    private StringUtils() {
        throw new AssertionError();
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static int length(CharSequence str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public static String nullStrToEmpty(Object str) {
        return str == null ? "" : str instanceof String ? (String) str : str.toString();
    }

    public static String capitalizeFirstLetter(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char cCharAt = str.charAt(0);
        return (!Character.isLetter(cCharAt) || Character.isUpperCase(cCharAt)) ? str : new StringBuilder(str.length()).append(Character.toUpperCase(cCharAt)).append(str.substring(1)).toString();
    }

    public static boolean isPhoneNum(String phoneNumber) {
        if (isEmpty(phoneNumber)) {
            return false;
        }
        return Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(14[5-9])|(166)|(19[8,9])|)\\d{8}$").matcher(phoneNumber).matches();
    }

    public static boolean isQQNum(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[1-9][0-9]{4,14}").matcher(str).matches();
    }

    public static boolean isEmail(String email) {
        if (email == null || "".equals(email)) {
            return false;
        }
        return Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(email).matches();
    }

    public static String utf8Encode(String str) {
        if (isEmpty(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
        }
    }

    public static String getHrefInnerHtml(String href) {
        if (isEmpty(href)) {
            return "";
        }
        Matcher matcher = Pattern.compile(".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*", 2).matcher(href);
        return matcher.matches() ? matcher.group(1) : href;
    }

    public static String htmlEscapeCharsToString(String source) {
        return isEmpty(source) ? source : source.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
    }

    public static String fullWidthToHalfWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 12288) {
                charArray[i] = ' ';
            } else if (c >= 65281 && c <= 65374) {
                charArray[i] = (char) (c - 65248);
            } else {
                charArray[i] = c;
            }
        }
        return new String(charArray);
    }

    public static String halfWidthToFullWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                charArray[i] = 12288;
            } else if (c >= '!' && c <= '~') {
                charArray[i] = (char) (c + 65248);
            } else {
                charArray[i] = c;
            }
        }
        return new String(charArray);
    }

    public static String replaceBlanktihuan(String str) {
        return str != null ? Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("") : "";
    }

    public static boolean isEmpty(String string) {
        return string == null || "".equals(string.trim());
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isEmpty(String... strings) {
        for (String str : strings) {
            if (isNotEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(String... strings) {
        for (String str : strings) {
            if (isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public static String filterEmpty(String string) {
        return isNotEmpty(string) ? string : "";
    }

    public static String replace(String string, char oldchar, char newchar) {
        char[] charArray = string.toCharArray();
        int i = 0;
        while (true) {
            if (i >= charArray.length) {
                break;
            }
            if (charArray[i] == oldchar) {
                charArray[i] = newchar;
                break;
            }
            i++;
        }
        return new String(charArray);
    }

    public static String[] split(String string, char ch) {
        ArrayList arrayList = new ArrayList();
        char[] charArray = string.toCharArray();
        int i = 0;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (ch == charArray[i2]) {
                arrayList.add(new String(charArray, i, i2 - i));
                i = i2 + 1;
                if (i == charArray.length) {
                    arrayList.add("");
                }
            }
        }
        if (i < charArray.length) {
            arrayList.add(new String(charArray, i, ((charArray.length - 1) - i) + 1));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static int countLength(String string) {
        char[] charArray = string.toCharArray();
        int i = 0;
        for (int i2 = 0; i2 < string.length(); i2++) {
            char c = charArray[i2];
            if (c >= 913 && c <= 65509) {
                i++;
            }
            i++;
        }
        return i;
    }

    private static char[] getChars(char[] chars, int startIndex) {
        int i = startIndex + 1;
        if (Character.isDigit(chars[startIndex])) {
            while (i < chars.length && Character.isDigit(chars[i])) {
                i++;
            }
        }
        int i2 = i - startIndex;
        char[] cArr = new char[i2];
        System.arraycopy(chars, startIndex, cArr, 0, i2);
        return cArr;
    }

    public static boolean isAllDigital(char[] chars) {
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static String removeChar(String string, char ch) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : string.toCharArray()) {
            if (c != '-') {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    public static String removeChar(String string, int index) {
        char[] charArray = string.toCharArray();
        if (index == 0) {
            return new String(charArray, 1, charArray.length - 1);
        }
        if (index == charArray.length - 1) {
            return new String(charArray, 0, charArray.length - 1);
        }
        return new String(charArray, 0, index).concat(new String(charArray, index + 1, charArray.length - index));
    }

    public static String removeChar(String string, int index, char ch) {
        String str;
        char[] charArray = string.toCharArray();
        if (charArray.length <= 0 || charArray[index] != ch) {
            return string;
        }
        if (index == 0) {
            str = new String(charArray, 1, charArray.length - 1);
        } else if (index == charArray.length - 1) {
            str = new String(charArray, 0, charArray.length - 1);
        } else {
            return new String(charArray, 0, index).concat(new String(charArray, index + 1, charArray.length - index));
        }
        return str;
    }

    public static String filterBlank(String string) {
        if ("".equals(string)) {
            return null;
        }
        return string;
    }

    public static String toLowerCase(String str, int beginIndex, int endIndex) {
        return str.replaceFirst(str.substring(beginIndex, endIndex), str.substring(beginIndex, endIndex).toLowerCase(Locale.getDefault()));
    }

    public static String toUpperCase(String str, int beginIndex, int endIndex) {
        return str.replaceFirst(str.substring(beginIndex, endIndex), str.substring(beginIndex, endIndex).toUpperCase(Locale.getDefault()));
    }

    public static String firstLetterToLowerCase(String str) {
        return toLowerCase(str, 0, 1);
    }

    public static String firstLetterToUpperCase(String str) {
        return toUpperCase(str, 0, 1);
    }

    public static String MD5(String string) {
        try {
            char[] charArray = string.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : MessageDigest.getInstance("MD5").digest(bArr)) {
                int i2 = b & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean startsWithIgnoreCase(String sourceString, String newString) {
        int length = newString.length();
        int length2 = sourceString.length();
        if (length == length2) {
            return newString.equalsIgnoreCase(sourceString);
        }
        if (length >= length2) {
            return false;
        }
        char[] cArr = new char[length];
        sourceString.getChars(0, length, cArr, 0);
        return newString.equalsIgnoreCase(String.valueOf(cArr));
    }

    public static boolean endsWithIgnoreCase(String sourceString, String newString) {
        int length = newString.length();
        int length2 = sourceString.length();
        if (length == length2) {
            return newString.equalsIgnoreCase(sourceString);
        }
        if (length >= length2) {
            return false;
        }
        char[] cArr = new char[length];
        sourceString.getChars(length2 - length, length2, cArr, 0);
        return newString.equalsIgnoreCase(String.valueOf(cArr));
    }

    public static String checkLength(String string, int maxLength, String appendString) {
        if (string.length() <= maxLength) {
            return string;
        }
        String strSubstring = string.substring(0, maxLength);
        return appendString != null ? strSubstring + appendString : strSubstring;
    }

    public static String checkLength(String string, int maxLength) {
        return checkLength(string, maxLength, "…");
    }

    public static String htmlRemoveTag(String inputString) {
        if (inputString == null) {
            return null;
        }
        try {
            return Pattern.compile("<[^>]+>", 2).matcher(Pattern.compile("<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>", 2).matcher(Pattern.compile("<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>", 2).matcher(inputString).replaceAll("")).replaceAll("")).replaceAll("");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}

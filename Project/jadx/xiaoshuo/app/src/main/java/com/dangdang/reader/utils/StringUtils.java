package com.dangdang.reader.utils;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes10.dex */
public class StringUtils {
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;

    public static String clean(String str) {
        return str == null ? "" : str.trim();
    }

    public static boolean isA_Z(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isBlank(String str) {
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

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String replaceBlank(String str) {
        return str != null ? Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("") : "";
    }

    public static String strip(String str, String str2) {
        return isEmpty(str) ? str : stripEnd(stripStart(str, str2), str2);
    }

    public static String stripEnd(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        if (str2 == null) {
            while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        } else {
            if (str2.length() == 0) {
                return str;
            }
            while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static String stripStart(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        int i = 0;
        if (str2 == null) {
            while (i != length && Character.isWhitespace(str.charAt(i))) {
                i++;
            }
        } else {
            if (str2.length() == 0) {
                return str;
            }
            while (i != length && str2.indexOf(str.charAt(i)) != -1) {
                i++;
            }
        }
        return str.substring(i);
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String strip(String str) {
        return strip(str, null);
    }
}

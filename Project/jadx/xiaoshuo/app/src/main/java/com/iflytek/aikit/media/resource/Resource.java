package com.iflytek.aikit.media.resource;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class Resource {
    private static Locale LANGUAGE = Locale.CHINA;
    public static final int TAG_ERROR_CODE = 0;
    public static final int TAG_ERROR_UNKNOWN = 1;
    public static final int TEXT_AGAIN = 9;
    public static final int TEXT_CANCEL = 4;
    public static final int TEXT_DETAIL = 3;
    public static final int TEXT_HELP_LINK = 1;
    public static final int TEXT_HELP_RECO = 13;
    public static final int TEXT_HELP_SMS = 12;
    public static final int TEXT_KNOW = 2;
    public static final int TEXT_MORE = 7;
    public static final int TEXT_PLAYBACK = 10;
    public static final int TEXT_POWER_LINK = 0;
    public static final int TEXT_RETRIEVE = 11;
    public static final int TEXT_RETRY = 8;
    public static final int TEXT_SET = 6;
    public static final int TEXT_STOP = 5;
    public static final int TITLE_AUDIO_PLAYING = 6;
    public static final int TITLE_AUDIO_REQUEST = 4;
    public static final int TITLE_CONNECTING = 1;
    public static final int TITLE_DATA_UPLOAD = 7;
    public static final int TITLE_ERROR = 5;
    public static final int TITLE_HELP = 0;
    public static final int TITLE_RECOGNIZE_WAITING = 3;
    public static final int TITLE_RECORDING = 2;

    private Resource() {
    }

    public static String getErrorDescription(int i) {
        String[] strArr = ResourceCN.errors;
        if (LANGUAGE.equals(Locale.US)) {
            strArr = ResourceEN.errors;
        } else if (LANGUAGE.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = ResourceTW.errors;
        }
        return (i <= 0 || i >= strArr.length) ? getErrorTag(1) : strArr[i];
    }

    public static String getErrorTag(int i) {
        String[] strArr = ResourceCN.error_tag;
        if (LANGUAGE.equals(Locale.US)) {
            strArr = ResourceEN.error_tag;
        } else if (LANGUAGE.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = ResourceTW.error_tag;
        }
        return (i < 0 || i >= strArr.length) ? "" : strArr[i];
    }

    public static String getLanguage() {
        return LANGUAGE.toString();
    }

    public static String getText(int i) {
        String[] strArr = ResourceCN.texts;
        if (LANGUAGE.equals(Locale.US)) {
            strArr = ResourceEN.texts;
        } else if (LANGUAGE.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = ResourceTW.texts;
        }
        return (i < 0 || i >= strArr.length) ? "" : strArr[i];
    }

    public static String getTitle(int i) {
        String[] strArr = ResourceCN.titles;
        if (LANGUAGE.equals(Locale.US)) {
            strArr = ResourceEN.titles;
        } else if (LANGUAGE.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = ResourceTW.titles;
        }
        return (i < 0 || i >= strArr.length) ? "" : strArr[i];
    }

    private static boolean isChinese(String str) {
        return TextUtils.isEmpty(str) || Locale.CHINA.toString().equalsIgnoreCase(str) || Locale.CHINESE.toString().equalsIgnoreCase(str);
    }

    public static boolean matchLanguage(String str) {
        String strTrim = str != null ? str.trim() : "";
        if (LANGUAGE.toString().equalsIgnoreCase(strTrim)) {
            return true;
        }
        return isChinese(strTrim) && isChinese(LANGUAGE.toString());
    }

    public static void setErrorDescription(int i, String str) {
        String[] strArr = ResourceCN.errors;
        if (LANGUAGE.equals(Locale.US)) {
            strArr = ResourceEN.errors;
        } else if (LANGUAGE.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = ResourceTW.errors;
        }
        if (i <= 0 || i >= strArr.length) {
            return;
        }
        strArr[i] = str;
    }

    public static void setText(int i, String str) {
        String[] strArr = ResourceCN.texts;
        if (LANGUAGE.equals(Locale.US)) {
            strArr = ResourceEN.texts;
        } else if (LANGUAGE.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = ResourceTW.texts;
        }
        if (i < 0 || i >= strArr.length) {
            return;
        }
        strArr[i] = str;
    }

    public static void setTitle(int i, String str) {
        String[] strArr = ResourceCN.titles;
        if (LANGUAGE.equals(Locale.US)) {
            strArr = ResourceEN.titles;
        } else if (LANGUAGE.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = ResourceTW.titles;
        }
        if (i < 0 || i >= strArr.length) {
            return;
        }
        strArr[i] = str;
    }

    public static void setUILanguage(Locale locale) {
        if (locale == null) {
            return;
        }
        if (locale.equals(Locale.US) || locale.equals(Locale.CHINA) || locale.equals(Locale.TRADITIONAL_CHINESE)) {
            LANGUAGE = locale;
        }
    }
}

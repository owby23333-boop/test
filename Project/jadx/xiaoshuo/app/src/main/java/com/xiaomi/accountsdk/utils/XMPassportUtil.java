package com.xiaomi.accountsdk.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.iflytek.aikit.media.param.MscKeys;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class XMPassportUtil {
    private static final String KEY_LOCALE = "_locale";

    public enum SimpleDateFormat {
        en_US("MM-dd-yyyy"),
        en_not_US("dd-MM-yyyy"),
        default_not_en("yyyy-MM-dd");

        private String value;

        SimpleDateFormat(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    public static String buildUrlWithLocaleQueryParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String queryParameter = uri.getQueryParameter(KEY_LOCALE);
        Uri.Builder builderBuildUpon = uri.buildUpon();
        String iSOLocaleString = getISOLocaleString(Locale.getDefault());
        if (TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(iSOLocaleString)) {
            builderBuildUpon.appendQueryParameter(KEY_LOCALE, iSOLocaleString);
        }
        return builderBuildUpon.build().toString();
    }

    public static String buildUrlWithNightModeQueryParam(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            throw new IllegalArgumentException("params invalid");
        }
        String str2 = 2 == ((UiModeManager) context.getSystemService("uimode")).getNightMode() ? "night_yes" : "night_no";
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendQueryParameter("_device_name", Build.DEVICE);
        builderBuildUpon.appendQueryParameter("_uiThemeMode", str2);
        return builderBuildUpon.build().toString();
    }

    public static String extractFromCookieString(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (String str3 : str.split(";")) {
                if (str3.contains(str2) && str3.split(MscKeys.KEY_VAL_SEP)[0].trim().equals(str2)) {
                    return str3.substring(str3.indexOf(MscKeys.KEY_VAL_SEP) + 1);
                }
            }
        }
        return null;
    }

    public static String extractPasstokenFromNotificationLoginEndCookie(String str) {
        return extractFromCookieString(str, "passToken");
    }

    public static String extractUserIdFromNotificationLoginEndCookie(String str) {
        return extractFromCookieString(str, "userId");
    }

    public static Map<String, String> getDefaultLocaleParam() {
        HashMap map = new HashMap();
        map.put(KEY_LOCALE, getISOLocaleString(Locale.getDefault()));
        return map;
    }

    public static String getISOLocaleString(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        return TextUtils.isEmpty(country) ? language : String.format("%s_%s", language, country);
    }

    public static String getSimpleDateFormat() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage().equals(Locale.ENGLISH.getLanguage()) ? locale.getCountry().equals(Locale.US.getCountry()) ? SimpleDateFormat.en_US.toString() : SimpleDateFormat.en_not_US.toString() : SimpleDateFormat.default_not_en.toString();
    }
}

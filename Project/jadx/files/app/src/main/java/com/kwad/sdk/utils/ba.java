package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class ba {
    private static final SimpleDateFormat azu = new SimpleDateFormat("MM/dd", Locale.US);
    private static final SimpleDateFormat azv = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
    private static final SimpleDateFormat azw = new SimpleDateFormat("MM月dd日", Locale.US);
    private static final SimpleDateFormat azx = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
    private static final SimpleDateFormat azy = new SimpleDateFormat("HH:mm", Locale.US);
    private static final SimpleDateFormat azz = new SimpleDateFormat("MM-dd", Locale.US);
    private static final SimpleDateFormat azA = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static boolean ex(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean ey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }
}

package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class bp {
    private static final SimpleDateFormat baJ = new SimpleDateFormat("MM/dd", Locale.US);
    private static final SimpleDateFormat baK = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
    private static final SimpleDateFormat baL = new SimpleDateFormat("MM月dd日", Locale.US);
    private static final SimpleDateFormat baM = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
    private static final SimpleDateFormat baN = new SimpleDateFormat("HH:mm", Locale.US);
    private static final SimpleDateFormat baO = new SimpleDateFormat("MM-dd", Locale.US);
    private static final SimpleDateFormat baP = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }

    public static boolean hp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }
}

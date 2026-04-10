package com.yuewen;

import android.content.Context;
import android.text.TextUtils;
import com.yuewen.yt2;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class p61 {
    public static String a(Context context, int i) {
        if (i < 10000) {
            return String.valueOf(i);
        }
        String strSubstring = String.format("%.1f", Float.valueOf(i / 10000.0f));
        int length = strSubstring.length();
        if (strSubstring.charAt(length - 1) == '0') {
            strSubstring = strSubstring.substring(0, length - 2);
        }
        return strSubstring + context.getResources().getString(yt2.r.j8);
    }

    public static String b(Context context, boolean z) {
        return z ? context.getString(yt2.r.eh) : context.getString(yt2.r.nh);
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str.contains("/jpeg/") ? str.replace("/jpeg/", "/webp/") : str.contains("/png/") ? str.replace("/png/", "/webp/") : str;
    }

    public static ArrayList<String> d(Context context, int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (i > 10000) {
            arrayList.add(String.format(Locale.CHINA, "%.1f", Float.valueOf(i / 10000.0f)));
            arrayList.add(context.getString(yt2.r.fh));
        } else {
            arrayList.add(String.valueOf(i));
            arrayList.add(context.getString(yt2.r.gh));
        }
        return arrayList;
    }

    public static String e(Context context, long j) {
        if (j <= 0) {
            return "";
        }
        if (j < 10000) {
            return j + context.getString(yt2.r.ll);
        }
        if (j < 1000000) {
            return String.format("%.1f", Double.valueOf(j / 10000.0d)) + context.getString(yt2.r.nl);
        }
        return (j / 10000) + context.getString(yt2.r.nl);
    }

    public static String[] f(Context context, long j) {
        String[] strArr = {"", ""};
        if (j <= 0) {
            return strArr;
        }
        if (j < 10000) {
            strArr[0] = String.valueOf(j);
            strArr[1] = context.getString(yt2.r.ll);
        } else if (j < 1000000) {
            strArr[0] = String.format("%.1f", Double.valueOf(j / 10000.0d));
            strArr[1] = context.getString(yt2.r.nl);
        } else {
            strArr[0] = String.valueOf(j / 10000);
            strArr[1] = context.getString(yt2.r.nl);
        }
        return strArr;
    }
}

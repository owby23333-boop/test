package com.yuewen;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class cq3 extends yp3 {
    public static final String J = "recommend";
    public static final String K = "store";
    public static final String L = "audio";
    public static final String M = "publish";
    public static final String N = "book";
    public static final String O = "comic";
    public static final String P = "fiction";
    public static final String Q = "male";
    public static final String R = "female";
    public static final String T = "selection";
    public static final String U = "free";
    public static final String V = "vip";
    public static final String W = "yuewen";
    public static final String X = "pay";
    public static final String S = "article";
    public static final String Y = "discovery";
    public static final String Z = "config_tab";
    public static final List<String> a0 = Arrays.asList("audio", "publish", "comic", "fiction", "male", "female", S, "selection", "free", "vip", Y, Z);

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.equals("ch_free")) {
            return "free";
        }
        for (String str2 : a0) {
            if (str.startsWith(str2)) {
                return str2;
            }
        }
        return null;
    }

    public static String e(String str) {
        if (!str.startsWith("free")) {
            return null;
        }
        String strSubstring = str.substring(5);
        if (strSubstring.startsWith("female") || strSubstring.startsWith("male")) {
            return strSubstring;
        }
        return "male/" + strSubstring;
    }

    public static boolean f(String str) {
        return str.startsWith("audio");
    }

    public static boolean g(String str) {
        return str.startsWith("comic");
    }

    public static boolean h(String str) {
        return str.startsWith(Z);
    }

    public static boolean i(String str) {
        return str.startsWith(Y);
    }

    public static boolean j(String str) {
        return str.startsWith("female");
    }

    public static boolean k(String str) {
        return str.startsWith("free");
    }

    public static boolean l(String str) {
        return str.startsWith("male") || str.startsWith("fiction");
    }

    public static boolean m(String str) {
        return str.startsWith("pay");
    }

    public static boolean n(String str) {
        return str.startsWith("publish") || str.startsWith("book");
    }

    public static boolean o(String str) {
        return d(str) != null;
    }

    public static boolean p(String str) {
        return str.startsWith(S);
    }

    public static boolean q(String str) {
        return str.startsWith("vip");
    }

    public static boolean r(String str) {
        return str.startsWith("yuewen");
    }
}

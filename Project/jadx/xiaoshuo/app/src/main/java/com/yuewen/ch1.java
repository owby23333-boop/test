package com.yuewen;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class ch1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9658a = "/store/v0/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9659b = "/drm/v0/";
    public static final String c = "/checkin/";
    public static final String d = "/discover/user/";
    public static final String e = "/sync/";
    public static final String f = "/dk_id/";
    public static final String g = "/soushu/";
    public static final String h = "/hs/v0/rock/dkfree/";
    public static final String i = "/hs/v0/android/fiction/book";
    public static final String j = "/rock/book/search/word";
    public static final String k = "/hs/v3/search";
    public static final String l = "/api/";
    public static final String m = "/hs/v4/";
    public static final String n = "/read-center";
    public static final String[] w = {"/store/v0/", "/drm/v0/", "/checkin/", "/discover/user/", "/sync/", "/dk_id/", "/soushu/", "/hs/v0/rock/dkfree/", "/hs/v0/android/fiction/book", "/rock/book/search/word", "/hs/v3/search", "/api/", "/hs/v4/", n};
    public static final String o = "sfsapi.micloud.xiaomi.net";
    public static final String p = "api.ad.xiaomi.com";
    public static final String q = "api-access.pangolin-sdk-toutiao.com";
    public static final String r = "video-midptf.v.wali.com";
    public static final String[] x = {o, p, q, r};
    public static final String s = "/store/v0/fiction/detail/";
    public static final String t = "/store/v0/audio/detail/";
    public static final String u = "/hs/v4/channel/query/";
    public static final String v = "/store/v0/android/book/";
    public static final String[] y = {s, t, u, v};

    public static boolean a(String str) {
        for (String str2 : x) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str) {
        for (String str2 : y) {
            if (str.contains(str2)) {
                return Pattern.compile("/[^/]+$").matcher(str).replaceAll("");
            }
        }
        return str;
    }

    public static boolean c(String str, String str2) {
        for (String str3 : w) {
            if (str.endsWith(".duokan.com") && str2.startsWith(str3)) {
                return true;
            }
        }
        return false;
    }
}

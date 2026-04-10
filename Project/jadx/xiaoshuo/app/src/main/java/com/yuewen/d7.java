package com.yuewen;

import android.text.TextUtils;
import com.duokan.reader.ui.store.data.cms.Advertisement;

/* JADX INFO: loaded from: classes5.dex */
public class d7 {

    public static class a {
        public static final String A = "30";
        public static final String B = "31";
        public static final String C = "40";
        public static final String D = "9";
        public static final String E = "4";
        public static final String F = "5";
        public static final String G = "0";
        public static final String H = "600";
        public static final String I = "700";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f10106a = "1";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f10107b = "100";
        public static final String c = "10000";
        public static final String d = "100000";
        public static final String e = "2";
        public static final String f = "101";
        public static final String g = "10001";
        public static final String h = "100001";
        public static final String i = "1000";
        public static final String j = "1001";
        public static final String k = "1003";
        public static final String l = "1002";
        public static final String m = "1010";
        public static final String n = "2001";
        public static final String o = "401";
        public static final String p = "402";
        public static final String q = "501";
        public static final String r = "3";
        public static final String s = "201";
        public static final String t = "202";
        public static final String u = "203";
        public static final String v = "11";
        public static final String w = "12";
        public static final String x = "13";
        public static final String y = "13";
        public static final String z = "20";
    }

    public static String a(Advertisement advertisement, boolean z) {
        return b(String.valueOf(advertisement.type), advertisement.id, z);
    }

    public static String b(String str, String str2, boolean z) {
        return str.equals("1") ? g("0", str2, "1") : str.equals("100") ? g("0", str2, "2") : str.equals("10000") ? g("0", str2, "6") : str.equals("100000") ? g("0", str2, "9") : str.equals("2") ? z ? s("vip", str2) : s("book", str2) : str.equals("5") ? s("nested", str2) : str.equals("101") ? s("fiction", str2) : str.equals("10001") ? s("comic", str2) : str.equals("100001") ? s("audio", str2) : str.equals("4") ? m(str2) : str.equals("1000") ? q("store", str2) : str.equals("1001") ? q("fiction", str2) : str.equals("1003") ? q("comic", str2) : str.equals("1002") ? h() : str.equals("1010") ? o() : str.equals("3") ? TextUtils.isEmpty(str2) ? "" : str2.trim() : str.equals("2001") ? f("fiction", str2, null) : str.equals("401") ? i("store", str2) : str.equals("402") ? i("fiction", str2) : str.equals("501") ? n(str2) : str.equals("202") ? k(str2) : str.equals("203") ? e(str2) : str.equals("13") ? l(str2) : "";
    }

    public static String c(Advertisement advertisement) {
        return d(advertisement, false);
    }

    public static String d(Advertisement advertisement, boolean z) {
        if ("change".equals(advertisement.getMoreType()) || advertisement.hideMore()) {
            return null;
        }
        if (!TextUtils.isEmpty(advertisement.getUrl())) {
            return advertisement.getUrl();
        }
        if (advertisement.dataInfo != null) {
            if ((advertisement.getShowCount() > 0 ? advertisement.getShowCount() : advertisement.dataInfo.count) >= advertisement.dataInfo.total) {
                return null;
            }
        }
        return a(advertisement, z);
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("/hs/market/active/%s?native_fullscreen=1", str);
    }

    public static String f(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "作者";
        }
        return String.format("/hs/market/author/%s/%s?name=%s", str, str2, str3);
    }

    public static String g(String str, String str2, String str3) {
        return String.format("/hs/book/%s?source=%s&source_id=%s&native_immersive=1", str, str3, str2);
    }

    public static String h() {
        return "/hs/market/new";
    }

    public static String i(String str, String str2) {
        return TextUtils.isEmpty(str2) ? String.format("/hs/market/cate/%s", str) : String.format("/hs/market/cate/%s/%s", str, str2);
    }

    public static String j(String str) {
        return TextUtils.isEmpty(str) ? "/hs/feed" : String.format("/hs/market/cate/fiction/%s&is_rec=1", str);
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("/hs/market/channel/%s", str);
    }

    public static String l(String str) {
        return "/hs/comment/detail/" + str;
    }

    public static String m(String str) {
        return String.format("/hs/market/copyright/%s", str);
    }

    public static String n(String str) {
        return TextUtils.isEmpty(str) ? "/hs/feed" : String.format("/hs/feed/%s", str);
    }

    public static String o() {
        return "/hs/market/free_latest";
    }

    public static String p(String str, String str2) {
        return TextUtils.isEmpty(str) ? "/hs/feed" : String.format("/hs/market/more_topic/%s&is_rock=%s", str, str2);
    }

    public static String q(String str, String str2) {
        return r(str, str2, null);
    }

    public static String r(String str, String str2, String str3) {
        String str4 = String.format("/hs/market/rank/%s/%s", str, str2);
        if (TextUtils.isEmpty(str3)) {
            return str4;
        }
        return str4 + "?tabs=" + str3;
    }

    public static String s(String str, String str2) {
        String str3;
        if ("vip".equals(str)) {
            return String.format("/hs/market/vip_topic/%s", str2);
        }
        if ("fiction".equals(str)) {
            str3 = "fiction_topic";
        } else if ("nested".equals(str)) {
            str3 = "nested_topic";
        } else if ("super".equals(str)) {
            str3 = "super_topic";
        } else if ("book".equals(str) || "store".equals(str)) {
            str3 = "topic";
        } else if ("comic".equals(str)) {
            str3 = "comic_topic";
        } else {
            if (!"audio".equals(str)) {
                return "";
            }
            str3 = "audio_topic";
        }
        return String.format("/hs/market/%s/%s", str3, str2);
    }

    public static String t() {
        return String.format("/hs/market/free/user_prefer&native_fullscreen=1", new Object[0]);
    }
}

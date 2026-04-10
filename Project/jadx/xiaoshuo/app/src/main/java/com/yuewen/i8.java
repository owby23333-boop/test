package com.yuewen;

import com.duokan.adbridge.bean.CommonAdInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes12.dex */
public class i8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12399a = "template";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12400b = "local-inflate";
    public static final String c = "together-sdk";
    public static final String d = "unknown";
    public static final String e = "unknown";
    public static final String f = "video";
    public static final String g = "image";
    public static final String h = "large-image";
    public static final String i = "small-image";
    public static final String j = "multi-image";
    public static final String k = "fullscreen";
    public static final String l = "vertical-video";
    public static final String m = "horizontal-video";
    public static final int n = 2;
    public static final String o = "download";
    public static final String p = "h5";
    public static final String q = "品牌广告";
    public static final String r = "效果广告";
    public static final String s = "unknown";
    public static final String t = "yimi";
    public static final String u = "custom";
    public static final String v = "csj";
    public static final String w = "ylh";
    public static final String x = "bqt";
    public static final String y = "ks";

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f12401a = "reading-bottom";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f12402b = "reading-page";
        public static final String c = "bookshelf";
        public static final String d = "reward-video";
        public static final String e = "splash";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f12403a = "REQUEST";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f12404b = "RESPONSE";
        public static final String c = "VIEW";
        public static final String d = "AD_HOLDER_VIEW";
        public static final String e = "CLICK";
        public static final String f = "AD_TRACK_READING_PAGE_TURN_CLICK";
        public static final String g = "DOWNLOAD_START";
        public static final String h = "DOWNLOAD_SUCCESS";
        public static final String i = "DOWNLOAD_FAIL";
        public static final String j = "INSTALL_START";
        public static final String k = "INSTALL_SUCCESS";
        public static final String l = "INSTALL_FAIL";
        public static final String m = "CLOSE";
    }

    public static String a(CommonAdInfo commonAdInfo) {
        if (commonAdInfo == null) {
            return "unknown";
        }
        if (commonAdInfo.H()) {
            return commonAdInfo.G() ? l : m;
        }
        int i2 = commonAdInfo.n;
        return i2 != 4 ? i2 != 20 ? i2 != 6 ? i2 != 7 ? "unknown" : j : i : k : h;
    }

    public static String b(int i2) {
        return i2 != 8 ? i2 != 15 ? i2 != 22 ? i2 != 28 ? "unknown" : y : x : "csj" : w;
    }
}

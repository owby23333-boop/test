package com.yuewen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes12.dex */
public final class o5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f15206a = "yimi";
    public static final String c = "yimi-browser";
    public static final String d = "top_on";
    public static final String e = "mediation";
    public static final String f = "mimo";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15207b = "yimi-1";
    public static final String[] g = {f15207b, "yimi"};
    public static final String[] h = {f15207b, "yimi"};
    public static final String[] i = {f15207b, "yimi"};
    public static final String[] j = {f15207b, "yimi"};

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static String[] a() {
        return new String[]{"yimi"};
    }

    public static String[] b() {
        return new String[]{"yimi"};
    }

    public static String[] c() {
        return new String[]{c, "mediation"};
    }

    public static String[] d() {
        return new String[]{"mediation"};
    }

    public static String[] e() {
        return new String[]{"yimi"};
    }

    public static String[] f() {
        return new String[]{"mediation", "videoAd"};
    }

    public static String[] g() {
        return new String[]{"yimi"};
    }
}

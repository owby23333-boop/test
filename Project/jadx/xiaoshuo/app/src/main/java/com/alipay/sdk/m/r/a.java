package com.alipay.sdk.m.r;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1916b;
    public final String c;

    /* JADX INFO: renamed from: com.alipay.sdk.m.r.a$a, reason: collision with other inner class name */
    public static class C0037a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f1917a = "0";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static String f1918b = "1";
        public static String c = "2";
    }

    public a(String str, String str2, String str3) {
        this.f1915a = str;
        this.f1916b = str2;
        this.c = str3;
    }

    public String a() {
        return this.f1915a;
    }

    public String b() {
        return this.f1916b;
    }

    public String c() {
        return this.c;
    }

    @NonNull
    public String toString() {
        return "updateStrategy: " + this.c + " sha256:" + this.f1915a + " sourceUrl:" + this.f1916b;
    }
}

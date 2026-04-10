package me.jessyan.retrofiturlmanager;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
class b {
    static HttpUrl a(String str) {
        HttpUrl httpUrl = HttpUrl.parse(str);
        if (httpUrl != null) {
            return httpUrl;
        }
        throw new InvalidUrlException(str);
    }

    static <T> T a(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }
}

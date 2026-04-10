package com.bytedance.sdk.component.dl.g;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public enum lq {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");

    final String m;

    lq(String str) {
        this.m = str;
    }

    public static lq z(String str) {
        str.hashCode();
        switch (str) {
            case "TLSv1.1":
                return TLS_1_1;
            case "TLSv1.2":
                return TLS_1_2;
            case "TLSv1.3":
                return TLS_1_3;
            case "SSLv3":
                return SSL_3_0;
            case "TLSv1":
                return TLS_1_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: ".concat(String.valueOf(str)));
        }
    }

    static List<lq> z(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(z(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String z() {
        return this.m;
    }
}

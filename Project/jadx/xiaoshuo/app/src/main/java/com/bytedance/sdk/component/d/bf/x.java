package com.bytedance.sdk.component.d.bf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public enum x {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");

    final String vn;

    x(String str) {
        this.vn = str;
    }

    public static x e(String str) {
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
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    public static List<x> e(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(e(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String e() {
        return this.vn;
    }
}

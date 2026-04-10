package com.alipay.sdk.m.v;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public enum a {
    None("none"),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit"),
    LocalWebPay("js://localWebPay");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1959a;

    a(String str) {
        this.f1959a = str;
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return None;
        }
        a aVar = None;
        for (a aVar2 : values()) {
            if (str.startsWith(aVar2.f1959a)) {
                return aVar2;
            }
        }
        return aVar;
    }
}

package com.bytedance.sdk.openadsdk.bh;

import com.yuewen.g72;

/* JADX INFO: loaded from: classes10.dex */
public enum tg {
    TYPE_2G(g72.h),
    TYPE_3G(g72.i),
    TYPE_4G(g72.j),
    TYPE_5G(g72.k),
    TYPE_WIFI(g72.g),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN("unknown");

    private String v;

    tg(String str) {
        this.v = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.v;
    }
}

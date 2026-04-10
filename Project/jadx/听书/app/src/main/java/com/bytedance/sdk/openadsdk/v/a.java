package com.bytedance.sdk.openadsdk.v;

import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    TYPE_2G("2g"),
    TYPE_3G(NetworkUtil.NETWORK_CLASS_3G),
    TYPE_4G(NetworkUtil.NETWORK_CLASS_4G),
    TYPE_5G(NetworkUtil.NETWORK_CLASS_5G),
    TYPE_WIFI("wifi"),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN("unknown");

    private String gz;

    a(String str) {
        this.gz = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.gz;
    }
}

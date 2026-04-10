package com.bytedance.msdk.api.v2.ad.custom.bean;

/* JADX INFO: loaded from: classes2.dex */
public class GMCustomAdConfig {
    private final String a;
    private final Class<?> b;

    public GMCustomAdConfig(String str, Class<?> cls) {
        this.a = str;
        this.b = cls;
    }

    public String getClassName() {
        return this.a;
    }

    public Class<?> getClazz() {
        return this.b;
    }
}

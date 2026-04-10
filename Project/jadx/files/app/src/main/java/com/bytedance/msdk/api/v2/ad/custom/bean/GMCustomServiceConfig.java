package com.bytedance.msdk.api.v2.ad.custom.bean;

/* JADX INFO: loaded from: classes2.dex */
public final class GMCustomServiceConfig {
    private final String a;
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14260e;

    public GMCustomServiceConfig(String str, String str2, int i2, int i3, String str3) {
        this.a = str;
        this.b = str2;
        this.f14258c = i2;
        this.f14259d = i3;
        this.f14260e = str3;
    }

    public String getADNNetworkName() {
        return this.a;
    }

    public String getADNNetworkSlotId() {
        return this.b;
    }

    public int getAdStyleType() {
        return this.f14258c;
    }

    public String getCustomAdapterJson() {
        return this.f14260e;
    }

    public int getSubAdtype() {
        return this.f14259d;
    }
}

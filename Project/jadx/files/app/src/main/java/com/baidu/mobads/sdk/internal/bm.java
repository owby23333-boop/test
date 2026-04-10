package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public enum bm {
    INTERFACE_USE_PROBLEM(1010001, "接口使用问题"),
    SHOW_STANDARD_UNFIT(3040001, "容器大小不达标");


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12928c = "msg";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12931e;

    bm(int i2, String str) {
        this.f12930d = i2;
        this.f12931e = str;
    }

    public int b() {
        return this.f12930d;
    }

    public String c() {
        return this.f12931e;
    }
}

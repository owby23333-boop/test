package com.kwad.sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a XY = new a(10000, "其他异常");
    public static final a XZ = new a(10001, "初始化参数异常");
    public int code;
    public String msg;

    public a(int i2, String str) {
        this.code = i2;
        this.msg = str;
    }
}

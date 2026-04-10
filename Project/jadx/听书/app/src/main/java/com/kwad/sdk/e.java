package com.kwad.sdk;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static final e arU = new e(10000, "其他异常");
    public static final e arV = new e(10001, "初始化参数异常");
    public static final e arW = new e(11001, "SDK未调用init方法");
    public int code;
    public String msg;

    public e(int i, String str) {
        this.code = i;
        this.msg = str;
    }
}

package com.qq.e.comm.constants;

/* JADX INFO: loaded from: classes4.dex */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1944a;

    LoginType(int i) {
        this.f1944a = i;
        ordinal();
    }

    public int getValue() {
        return this.f1944a;
    }
}

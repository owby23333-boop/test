package com.qq.e.ads.cfg;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public enum DownAPPConfirmPolicy {
    Default(0),
    NOConfirm(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1910a;

    DownAPPConfirmPolicy(int i) {
        this.f1910a = i;
    }

    public int value() {
        return this.f1910a;
    }
}

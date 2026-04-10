package com.efs.sdk.base.core.d;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1558a;
    public byte b;
    public int c = 0;
    public String d = "none";
    public int e = 1;
    long f = 0;
    int g = 1;

    a(String str, byte b) {
        this.b = (byte) 2;
        this.f1558a = str;
        if (b <= 0 || 3 < b) {
            throw new IllegalArgumentException("log protocol flag invalid : ".concat(String.valueOf((int) b)));
        }
        this.b = b;
    }
}

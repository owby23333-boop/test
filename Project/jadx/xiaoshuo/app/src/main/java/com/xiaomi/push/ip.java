package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public enum ip {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);


    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int f613a;

    ip(int i) {
        this.f613a = i;
    }

    public int a() {
        return this.f613a;
    }

    public static ip a(int i) {
        if (i == 0) {
            return RegIdExpired;
        }
        if (i == 1) {
            return PackageUnregistered;
        }
        if (i != 2) {
            return null;
        }
        return Init;
    }
}

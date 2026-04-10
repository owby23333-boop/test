package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f7954a = a(1, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f7955b = a(1, 4);
    static final int c = a(2, 0);
    static final int d = a(3, 2);

    public static int a(int i) {
        return i & 7;
    }

    public static int b(int i) {
        return i >>> 3;
    }

    public static int a(int i, int i2) {
        return (i << 3) | i2;
    }
}

package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public class eh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10598b;
    public final int c;
    public final int d;

    public eh0(int i, int i2, int i3, int i4) {
        this.f10597a = i;
        this.f10598b = i2;
        this.c = i3;
        this.d = i4;
    }

    public boolean a(int i) {
        return i >= this.f10597a && i <= this.f10598b;
    }

    public boolean b(int i) {
        return i >= this.c && i <= this.d;
    }
}

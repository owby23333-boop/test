package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public class a34 {
    public static final int d = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8398b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8397a = -1;
    public int c = 5;

    public boolean a(int i, int i2) {
        if (this.f8398b || this.f8397a >= i || this.c + i < i2) {
            return false;
        }
        this.f8397a = i;
        this.f8398b = true;
        return true;
    }

    public void b() {
        this.f8397a = -1;
        this.f8398b = false;
    }

    public void c(int i) {
        this.c = i;
    }
}

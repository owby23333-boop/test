package com.anythink.expressad.exoplayer.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    private int a;

    public void a() {
        this.a = 0;
    }

    public final boolean b() {
        return c(Integer.MIN_VALUE);
    }

    public final boolean c() {
        return c(4);
    }

    public final boolean d() {
        return c(1);
    }

    private void d(int i2) {
        this.a = (i2 ^ (-1)) & this.a;
    }

    public final void a(int i2) {
        this.a = i2;
    }

    public final void b(int i2) {
        this.a = i2 | this.a;
    }

    protected final boolean c(int i2) {
        return (this.a & i2) == i2;
    }
}

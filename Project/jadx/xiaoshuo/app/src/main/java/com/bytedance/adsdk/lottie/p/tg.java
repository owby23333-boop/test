package com.bytedance.adsdk.lottie.p;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    private float bf;
    private float e;

    public tg(float f, float f2) {
        this.e = f;
        this.bf = f2;
    }

    public float bf() {
        return this.bf;
    }

    public float e() {
        return this.e;
    }

    public String toString() {
        return e() + "x" + bf();
    }

    public boolean bf(float f, float f2) {
        return this.e == f && this.bf == f2;
    }

    public void e(float f, float f2) {
        this.e = f;
        this.bf = f2;
    }

    public tg() {
        this(1.0f, 1.0f);
    }
}

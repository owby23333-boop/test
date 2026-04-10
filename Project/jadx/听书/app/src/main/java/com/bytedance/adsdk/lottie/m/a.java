package com.bytedance.adsdk.lottie.m;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private float g;
    private float z;

    public a(float f, float f2) {
        this.z = f;
        this.g = f2;
    }

    public a() {
        this(1.0f, 1.0f);
    }

    public float z() {
        return this.z;
    }

    public float g() {
        return this.g;
    }

    public void z(float f, float f2) {
        this.z = f;
        this.g = f2;
    }

    public boolean g(float f, float f2) {
        return this.z == f && this.g == f2;
    }

    public String toString() {
        return z() + "x" + g();
    }
}

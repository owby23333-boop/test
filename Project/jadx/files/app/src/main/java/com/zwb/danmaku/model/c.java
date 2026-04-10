package com.zwb.danmaku.model;

/* JADX INFO: compiled from: BaseConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f20688e;
    private int a = 24;
    private int b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f20686c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f20687d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f20689f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20690g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20691h = -1;

    public c a(float f2) {
        this.f20688e = f2;
        return this;
    }

    public c b(int i2) {
        this.f20691h = i2;
        return this;
    }

    public c c(int i2) {
        this.f20689f = i2;
        return this;
    }

    public c d(int i2) {
        this.b = i2;
        return this;
    }

    public c e(int i2) {
        this.f20686c = i2;
        return this;
    }

    public c f(int i2) {
        this.f20687d = i2;
        return this;
    }

    public c g(int i2) {
        this.a = i2;
        return this;
    }

    public c a(int i2) {
        this.f20690g = i2;
        return this;
    }

    public void a(BaseDanmaku baseDanmaku, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (baseDanmaku != null) {
            if (baseDanmaku.x() <= 0.0f && (i6 = this.a) > 0) {
                baseDanmaku.m(i6);
            }
            if (baseDanmaku.v() == 0 && (i5 = this.b) != 0) {
                baseDanmaku.f(i5);
            }
            if (baseDanmaku.p() == 0 && (i4 = this.f20686c) != 0) {
                baseDanmaku.d(i4);
            }
            if (baseDanmaku.r() <= 0.0f && (i3 = this.f20687d) > 0) {
                baseDanmaku.k(i3);
            }
            if (baseDanmaku.t() <= 0.0f) {
                float f2 = this.f20688e;
                if (f2 > 0.0f && !z2) {
                    baseDanmaku.l(f2);
                }
            }
            if (baseDanmaku.q() <= 0 && (i2 = this.f20689f) > 0) {
                baseDanmaku.e(i2);
            }
            if (baseDanmaku.h() <= 0) {
                baseDanmaku.c(this.f20691h);
            }
            if (baseDanmaku.g() <= 0) {
                baseDanmaku.b(this.f20690g);
            }
        }
    }
}

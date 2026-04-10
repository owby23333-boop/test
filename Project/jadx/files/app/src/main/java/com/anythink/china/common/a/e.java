package com.anythink.china.common.a;

import android.graphics.Bitmap;
import com.anythink.core.common.e.i;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f6423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f6427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f6428i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f6429j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f6430k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.anythink.core.common.f.b f6431l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f6432m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f6433n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6435p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6436q;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6434o = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile a f6437r = a.IDLE;

    public enum a {
        IDLE,
        LOADING,
        PAUSE,
        STOP,
        FINISH,
        FAIL,
        INSTALLED
    }

    private boolean o() {
        return this.f6437r == a.STOP;
    }

    public final a a() {
        return this.f6437r;
    }

    public final boolean b() {
        return this.f6437r == a.IDLE;
    }

    public final boolean c() {
        return this.f6437r == a.PAUSE;
    }

    public final boolean d() {
        return this.f6437r == a.LOADING;
    }

    public final void e() {
        this.f6437r = a.IDLE;
    }

    public final boolean f() {
        return this.f6437r == a.INSTALLED;
    }

    public final boolean g() {
        return this.f6437r == a.FINISH;
    }

    public final boolean h() {
        return this.f6437r == a.FAIL;
    }

    public final void i() {
        this.f6437r = a.LOADING;
    }

    public final void j() {
        this.f6437r = a.STOP;
    }

    public final void k() {
        this.f6437r = a.PAUSE;
    }

    public final void l() {
        this.f6437r = a.FINISH;
    }

    public final void m() {
        this.f6437r = a.INSTALLED;
    }

    public final void n() {
        this.f6437r = a.FAIL;
    }
}

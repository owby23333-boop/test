package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ViewOffsetHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class a {
    private final View a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14979f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14980g = true;

    public a(View view) {
        this.a = view;
    }

    void a() {
        View view = this.a;
        ViewCompat.offsetTopAndBottom(view, this.f14977d - (view.getTop() - this.b));
        View view2 = this.a;
        ViewCompat.offsetLeftAndRight(view2, this.f14978e - (view2.getLeft() - this.f14976c));
    }

    public boolean b(int i2) {
        if (!this.f14979f || this.f14977d == i2) {
            return false;
        }
        this.f14977d = i2;
        a();
        return true;
    }

    public int c() {
        return this.f14977d;
    }

    void d() {
        this.b = this.a.getTop();
        this.f14976c = this.a.getLeft();
    }

    public boolean a(int i2) {
        if (!this.f14980g || this.f14978e == i2) {
            return false;
        }
        this.f14978e = i2;
        a();
        return true;
    }

    public int b() {
        return this.b;
    }
}

package com.yuewen;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public class zr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f20925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f20926b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public String h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public Bitmap.Config q;

    public zr0() {
        this.f20925a = null;
        this.f20926b = null;
        this.c = 0;
        this.d = -1;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = Bitmap.Config.RGB_565;
    }

    public zr0 a() {
        return new zr0(this);
    }

    public boolean b() {
        return this.j || this.i;
    }

    public boolean c() {
        return this.p;
    }

    public zr0(zr0 zr0Var) {
        this.f20925a = null;
        this.f20926b = null;
        this.c = 0;
        this.d = -1;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = Bitmap.Config.RGB_565;
        this.f20925a = zr0Var.f20925a;
        this.f20926b = zr0Var.f20926b;
        this.c = zr0Var.c;
        this.d = zr0Var.d;
        this.e = zr0Var.e;
        this.f = zr0Var.f;
        this.g = zr0Var.g;
        this.h = zr0Var.h;
        this.i = zr0Var.i;
        this.j = zr0Var.j;
        this.k = zr0Var.k;
        this.l = zr0Var.l;
        this.m = zr0Var.m;
        this.o = zr0Var.o;
        this.p = zr0Var.p;
        this.q = zr0Var.q;
    }
}

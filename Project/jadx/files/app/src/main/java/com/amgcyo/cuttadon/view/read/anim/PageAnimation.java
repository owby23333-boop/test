package com.amgcyo.cuttadon.view.read.anim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.amgcyo.cuttadon.utils.otherutils.g0;

/* JADX INFO: loaded from: classes.dex */
public abstract class PageAnimation {
    protected View a;
    public Scroller b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected a f5186c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f5189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f5190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f5191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f5192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f5193j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f5194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected float f5195l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected float f5196m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected float f5197n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected float f5198o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected float f5199p;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Direction f5187d = Direction.NONE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f5188e = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f5201r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f5202s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f5203t = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected boolean f5200q = g0.a().a("is_allclicknext", false);

    public enum Direction {
        NONE(true),
        NEXT(true),
        PRE(true),
        UP(false),
        DOWN(false);

        Direction(boolean z2) {
        }
    }

    public interface a {
        boolean a();

        void b();

        boolean hasNext();
    }

    public PageAnimation(int i2, int i3, int i4, int i5, View view, a aVar) {
        this.f5189f = i2;
        this.f5190g = i3;
        this.f5191h = i4;
        this.f5192i = i5;
        this.f5193j = this.f5189f - (this.f5191h * 2);
        this.f5194k = this.f5190g - (this.f5192i * 2);
        this.a = view;
        this.f5186c = aVar;
        this.b = new Scroller(this.a.getContext(), new LinearInterpolator());
    }

    public abstract void a();

    public void a(float f2, float f3) {
        this.f5195l = f2;
        this.f5196m = f3;
        this.f5199p = this.f5196m;
    }

    public abstract void a(Canvas canvas);

    public abstract boolean a(MotionEvent motionEvent);

    public void b(float f2, float f3) {
        this.f5199p = this.f5198o;
        this.f5197n = f2;
        this.f5198o = f3;
    }

    public abstract Bitmap c();

    public abstract Bitmap d();

    public boolean e() {
        return this.f5188e;
    }

    public abstract void f();

    public void g() {
        if (this.f5188e) {
            return;
        }
        this.f5188e = true;
    }

    public void a(Direction direction) {
        this.f5187d = direction;
    }

    public void b() {
        this.a = null;
    }

    public void a(int i2, boolean z2) {
        this.f5201r = i2;
        this.f5202s = z2;
        this.a.postInvalidate();
    }
}

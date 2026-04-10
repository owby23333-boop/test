package com.amgcyo.cuttadon.h.i.h;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: SplashZoomOutManager.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile e f4007n;
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4009d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f4012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4014i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ViewGroup f4018m;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f4015j = new int[2];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4010e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4011f = 300;

    /* JADX INFO: compiled from: SplashZoomOutManager.java */
    class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ b f4019s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ View f4020t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ ViewGroup f4021u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final /* synthetic */ float f4022v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final /* synthetic */ int[] f4023w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ float f4024x;

        a(b bVar, View view, ViewGroup viewGroup, float f2, int[] iArr, float f3) {
            this.f4019s = bVar;
            this.f4020t = view;
            this.f4021u = viewGroup;
            this.f4022v = f2;
            this.f4023w = iArr;
            this.f4024x = f3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.a(this.f4020t);
            this.f4020t.setScaleX(1.0f);
            this.f4020t.setScaleY(1.0f);
            this.f4020t.setX(0.0f);
            this.f4020t.setY(0.0f);
            int[] iArr = new int[2];
            this.f4021u.getLocationOnScreen(iArr);
            float f2 = this.f4022v - iArr[0];
            int[] iArr2 = this.f4023w;
            float f3 = f2 + iArr2[0];
            float f4 = (this.f4024x - iArr[1]) + iArr2[1];
            String str = "zoomOut distX:" + f3 + " distY:" + f4;
            String str2 = "zoomOut containerScreenX:" + iArr[0] + " containerScreenY:" + iArr[1];
            e.this.f4018m.addView(this.f4020t, -1, -1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(e.this.a, e.this.b);
            if (e.this.f4018m.getParent() != null) {
                ((ViewGroup) e.this.f4018m.getParent()).removeView(e.this.f4018m);
            }
            this.f4021u.addView(e.this.f4018m, layoutParams);
            e.this.f4018m.setTranslationX(f3);
            e.this.f4018m.setTranslationY(f4);
            b bVar = this.f4019s;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b bVar = this.f4019s;
            if (bVar != null) {
                bVar.a(e.this.f4011f);
            }
        }
    }

    /* JADX INFO: compiled from: SplashZoomOutManager.java */
    public interface b {
        void a();

        void a(int i2);
    }

    private e(Context context) {
        this.a = Math.round(Math.min(com.amgcyo.cuttadon.h.i.h.b.a(context), com.amgcyo.cuttadon.h.i.h.b.b(context)) * 0.3f);
        this.b = Math.round((this.a * 16) / 9);
        this.f4008c = com.amgcyo.cuttadon.h.i.h.b.a(context, 6);
        this.f4009d = com.amgcyo.cuttadon.h.i.h.b.a(context, 100);
        this.f4018m = new d(context, this.f4008c);
    }

    public static e a(Context context) {
        if (f4007n == null) {
            synchronized (e.class) {
                if (f4007n == null) {
                    f4007n = new e(context);
                }
            }
        }
        return f4007n;
    }

    public ViewGroup b() {
        return this.f4018m;
    }

    public void a(View view, View view2) {
        this.f4012g = view;
        view.getLocationOnScreen(this.f4015j);
        this.f4013h = view.getWidth();
        this.f4014i = view.getHeight();
        this.f4016k = view2.getWidth();
        this.f4017l = view2.getHeight();
    }

    public void a(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public void a() {
        this.f4012g = null;
    }

    public ViewGroup a(ViewGroup viewGroup, ViewGroup viewGroup2, b bVar) {
        if (viewGroup == null || viewGroup2 == null || this.f4012g == null) {
            return null;
        }
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int[] iArr2 = this.f4015j;
        int i2 = iArr2[0] - iArr[0];
        int i3 = iArr2[1] - iArr[1];
        c.a(this.f4012g);
        viewGroup.addView(this.f4012g, new FrameLayout.LayoutParams(this.f4013h, this.f4014i));
        this.f4012g.setX(i2);
        this.f4012g.setY(i3);
        return a(this.f4012g, viewGroup, viewGroup2, bVar);
    }

    public ViewGroup a(View view, ViewGroup viewGroup, ViewGroup viewGroup2, b bVar) {
        a();
        if (view == null || viewGroup2 == null) {
            return null;
        }
        viewGroup2.getContext();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        int width2 = viewGroup.getWidth();
        int height2 = viewGroup.getHeight();
        if (width2 == 0) {
            width2 = this.f4016k;
        }
        if (height2 == 0) {
            height2 = this.f4017l;
        }
        float f2 = this.a / width;
        float f3 = this.b / height;
        float f4 = this.f4010e == 0 ? this.f4008c : (width2 - this.f4008c) - r4;
        float f5 = (height2 - this.f4009d) - this.b;
        String str = "zoomOut animationContainerWidth:" + width2 + " animationContainerHeight:" + height2;
        String str2 = "zoomOut splashScreenX:" + iArr[0] + " splashScreenY:" + iArr[1];
        String str3 = "zoomOut splashWidth:" + width + " splashHeight:" + height;
        String str4 = "zoomOut width:" + this.a + " height:" + this.b;
        String str5 = "zoomOut animationDistX:" + f4 + " animationDistY:" + f5;
        c.a(view);
        viewGroup.addView(view, new FrameLayout.LayoutParams(width, height));
        this.f4018m.removeAllViews();
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.animate().scaleX(f2).scaleY(f3).x(f4).y(f5).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(this.f4011f).setListener(new a(bVar, view, viewGroup2, f4, iArr, f5));
        return this.f4018m;
    }
}

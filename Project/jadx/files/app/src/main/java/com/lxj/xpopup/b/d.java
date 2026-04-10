package com.lxj.xpopup.b;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.lxj.xpopup.enums.PopupAnimation;

/* JADX INFO: compiled from: ScaleAlphaAnimator.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends com.lxj.xpopup.b.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f17328e;

    /* JADX INFO: compiled from: ScaleAlphaAnimator.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.d();
        }
    }

    /* JADX INFO: compiled from: ScaleAlphaAnimator.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(d.this.f17324c).setInterpolator(new OvershootInterpolator(1.0f)).start();
        }
    }

    /* JADX INFO: compiled from: ScaleAlphaAnimator.java */
    static /* synthetic */ class c {
        static final /* synthetic */ int[] a = new int[PopupAnimation.values().length];

        static {
            try {
                a[PopupAnimation.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public d(View view, int i2, PopupAnimation popupAnimation) {
        super(view, i2, popupAnimation);
        this.f17328e = 0.85f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i2 = c.a[this.f17325d.ordinal()];
        if (i2 == 1) {
            this.b.setPivotX(r0.getMeasuredWidth() / 2.0f);
            this.b.setPivotY(r0.getMeasuredHeight() / 2.0f);
            return;
        }
        if (i2 == 2) {
            this.b.setPivotX(0.0f);
            this.b.setPivotY(0.0f);
            return;
        }
        if (i2 == 3) {
            this.b.setPivotX(r0.getMeasuredWidth());
            this.b.setPivotY(0.0f);
        } else if (i2 == 4) {
            this.b.setPivotX(0.0f);
            this.b.setPivotY(r0.getMeasuredHeight());
        } else {
            if (i2 != 5) {
                return;
            }
            this.b.setPivotX(r0.getMeasuredWidth());
            this.b.setPivotY(r0.getMeasuredHeight());
        }
    }

    @Override // com.lxj.xpopup.b.c
    public void b() {
        this.b.post(new b());
    }

    @Override // com.lxj.xpopup.b.c
    public void c() {
        this.b.setScaleX(this.f17328e);
        this.b.setScaleY(this.f17328e);
        this.b.setAlpha(0.0f);
        this.b.post(new a());
    }

    @Override // com.lxj.xpopup.b.c
    public void a() {
        if (this.a) {
            return;
        }
        ViewPropertyAnimator interpolator = this.b.animate().scaleX(this.f17328e).scaleY(this.f17328e).alpha(0.0f).setDuration(this.f17324c).setInterpolator(new FastOutSlowInInterpolator());
        a(interpolator);
        interpolator.start();
    }
}

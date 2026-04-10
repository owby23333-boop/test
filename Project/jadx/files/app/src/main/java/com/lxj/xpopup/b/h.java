package com.lxj.xpopup.b;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.lxj.xpopup.enums.PopupAnimation;

/* JADX INFO: compiled from: TranslateAnimator.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f17351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f17352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f17353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f17354h;

    /* JADX INFO: compiled from: TranslateAnimator.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[PopupAnimation.values().length];

        static {
            try {
                a[PopupAnimation.TranslateFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PopupAnimation.TranslateFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PopupAnimation.TranslateFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PopupAnimation.TranslateFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public h(View view, int i2, PopupAnimation popupAnimation) {
        super(view, i2, popupAnimation);
    }

    private void d() {
        int i2 = a.a[this.f17325d.ordinal()];
        if (i2 == 1) {
            this.b.setTranslationX(-r0.getRight());
            return;
        }
        if (i2 == 2) {
            this.b.setTranslationY(-r0.getBottom());
        } else if (i2 == 3) {
            this.b.setTranslationX(((View) r0.getParent()).getMeasuredWidth() - this.b.getLeft());
        } else {
            if (i2 != 4) {
                return;
            }
            this.b.setTranslationY(((View) r0.getParent()).getMeasuredHeight() - this.b.getTop());
        }
    }

    @Override // com.lxj.xpopup.b.c
    public void a() {
        if (this.a) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimatorTranslationX = null;
        int i2 = a.a[this.f17325d.ordinal()];
        if (i2 == 1) {
            this.f17351e = -this.b.getRight();
            viewPropertyAnimatorTranslationX = this.b.animate().translationX(this.f17351e);
        } else if (i2 == 2) {
            this.f17352f = -this.b.getBottom();
            viewPropertyAnimatorTranslationX = this.b.animate().translationY(this.f17352f);
        } else if (i2 == 3) {
            this.f17351e = ((View) this.b.getParent()).getMeasuredWidth() - this.b.getLeft();
            viewPropertyAnimatorTranslationX = this.b.animate().translationX(this.f17351e);
        } else if (i2 == 4) {
            this.f17352f = ((View) this.b.getParent()).getMeasuredHeight() - this.b.getTop();
            viewPropertyAnimatorTranslationX = this.b.animate().translationY(this.f17352f);
        }
        if (viewPropertyAnimatorTranslationX != null) {
            ViewPropertyAnimator interpolator = viewPropertyAnimatorTranslationX.setInterpolator(new FastOutSlowInInterpolator());
            double d2 = this.f17324c;
            Double.isNaN(d2);
            ViewPropertyAnimator viewPropertyAnimatorWithLayer = interpolator.setDuration((long) (d2 * 0.8d)).withLayer();
            a(viewPropertyAnimatorWithLayer);
            viewPropertyAnimatorWithLayer.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    @Override // com.lxj.xpopup.b.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r3 = this;
            int[] r0 = com.lxj.xpopup.b.h.a.a
            com.lxj.xpopup.enums.PopupAnimation r1 = r3.f17325d
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L25
            r1 = 2
            if (r0 == r1) goto L18
            r1 = 3
            if (r0 == r1) goto L25
            r1 = 4
            if (r0 == r1) goto L18
            r0 = 0
            goto L31
        L18:
            android.view.View r0 = r3.b
            android.view.ViewPropertyAnimator r0 = r0.animate()
            float r1 = r3.f17354h
            android.view.ViewPropertyAnimator r0 = r0.translationY(r1)
            goto L31
        L25:
            android.view.View r0 = r3.b
            android.view.ViewPropertyAnimator r0 = r0.animate()
            float r1 = r3.f17353g
            android.view.ViewPropertyAnimator r0 = r0.translationX(r1)
        L31:
            if (r0 == 0) goto L4a
            androidx.interpolator.view.animation.FastOutSlowInInterpolator r1 = new androidx.interpolator.view.animation.FastOutSlowInInterpolator
            r1.<init>()
            android.view.ViewPropertyAnimator r0 = r0.setInterpolator(r1)
            int r1 = r3.f17324c
            long r1 = (long) r1
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r1)
            android.view.ViewPropertyAnimator r0 = r0.withLayer()
            r0.start()
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.b.h.b():void");
    }

    @Override // com.lxj.xpopup.b.c
    public void c() {
        this.f17353g = this.b.getTranslationX();
        this.f17354h = this.b.getTranslationY();
        d();
        this.f17351e = this.b.getTranslationX();
        this.f17352f = this.b.getTranslationY();
    }
}

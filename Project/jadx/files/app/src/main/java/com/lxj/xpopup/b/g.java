package com.lxj.xpopup.b;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.lxj.xpopup.enums.PopupAnimation;

/* JADX INFO: compiled from: TranslateAlphaAnimator.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f17347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f17348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f17349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f17350h;

    /* JADX INFO: compiled from: TranslateAlphaAnimator.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[PopupAnimation.values().length];

        static {
            try {
                a[PopupAnimation.TranslateAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PopupAnimation.TranslateAlphaFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PopupAnimation.TranslateAlphaFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PopupAnimation.TranslateAlphaFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public g(View view, int i2, PopupAnimation popupAnimation) {
        super(view, i2, popupAnimation);
    }

    private void d() {
        int i2 = a.a[this.f17325d.ordinal()];
        if (i2 == 1) {
            this.b.setTranslationX(-r0.getMeasuredWidth());
            return;
        }
        if (i2 == 2) {
            this.b.setTranslationY(-r0.getMeasuredHeight());
        } else if (i2 == 3) {
            this.b.setTranslationX(r0.getMeasuredWidth());
        } else {
            if (i2 != 4) {
                return;
            }
            this.b.setTranslationY(r0.getMeasuredHeight());
        }
    }

    @Override // com.lxj.xpopup.b.c
    public void a() {
        if (this.a) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimatorWithLayer = this.b.animate().translationX(this.f17347e).translationY(this.f17348f).alpha(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(this.f17324c).withLayer();
        a(viewPropertyAnimatorWithLayer);
        viewPropertyAnimatorWithLayer.start();
    }

    @Override // com.lxj.xpopup.b.c
    public void b() {
        this.b.animate().translationX(this.f17349g).translationY(this.f17350h).alpha(1.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(this.f17324c).withLayer().start();
    }

    @Override // com.lxj.xpopup.b.c
    public void c() {
        this.f17349g = this.b.getTranslationX();
        this.f17350h = this.b.getTranslationY();
        this.b.setAlpha(0.0f);
        d();
        this.f17347e = this.b.getTranslationX();
        this.f17348f = this.b.getTranslationY();
    }
}

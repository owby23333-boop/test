package com.lxj.xpopup.b;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.lxj.xpopup.enums.PopupAnimation;

/* JADX INFO: compiled from: ScrollScaleAnimator.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends com.lxj.xpopup.b.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IntEvaluator f17331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f17334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f17335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f17336j;

    /* JADX INFO: compiled from: ScrollScaleAnimator.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.d();
            e eVar = e.this;
            eVar.b.scrollTo(eVar.f17332f, e.this.f17333g);
        }
    }

    /* JADX INFO: compiled from: ScrollScaleAnimator.java */
    class b implements Runnable {

        /* JADX INFO: compiled from: ScrollScaleAnimator.java */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                e.this.b.setAlpha(animatedFraction);
                e eVar = e.this;
                eVar.b.scrollTo(eVar.f17331e.evaluate(animatedFraction, Integer.valueOf(e.this.f17332f), (Integer) 0).intValue(), e.this.f17331e.evaluate(animatedFraction, Integer.valueOf(e.this.f17333g), (Integer) 0).intValue());
                e.this.b.setScaleX(animatedFraction);
                e eVar2 = e.this;
                if (eVar2.f17336j) {
                    return;
                }
                eVar2.b.setScaleY(animatedFraction);
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new a());
            valueAnimatorOfFloat.setDuration(e.this.f17324c).setInterpolator(new FastOutSlowInInterpolator());
            valueAnimatorOfFloat.start();
        }
    }

    /* JADX INFO: compiled from: ScrollScaleAnimator.java */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            float f2 = 1.0f - animatedFraction;
            e.this.b.setAlpha(f2);
            e eVar = e.this;
            eVar.b.scrollTo(eVar.f17331e.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(e.this.f17332f)).intValue(), e.this.f17331e.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(e.this.f17333g)).intValue());
            e.this.b.setScaleX(f2);
            e eVar2 = e.this;
            if (eVar2.f17336j) {
                return;
            }
            eVar2.b.setScaleY(f2);
        }
    }

    /* JADX INFO: compiled from: ScrollScaleAnimator.java */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a = new int[PopupAnimation.values().length];

        static {
            try {
                a[PopupAnimation.ScrollAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromRightTop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromRight.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromRightBottom.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromBottom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromLeftBottom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public e(View view, int i2, PopupAnimation popupAnimation) {
        super(view, i2, popupAnimation);
        this.f17331e = new IntEvaluator();
        this.f17334h = 0.0f;
        this.f17335i = 0.0f;
        this.f17336j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        switch (d.a[this.f17325d.ordinal()]) {
            case 1:
                this.b.setPivotX(0.0f);
                this.b.setPivotY(r0.getMeasuredHeight() / 2);
                this.f17332f = this.b.getMeasuredWidth();
                this.f17333g = 0;
                break;
            case 2:
                this.b.setPivotX(0.0f);
                this.b.setPivotY(0.0f);
                this.f17332f = this.b.getMeasuredWidth();
                this.f17333g = this.b.getMeasuredHeight();
                break;
            case 3:
                this.b.setPivotX(r0.getMeasuredWidth() / 2);
                this.b.setPivotY(0.0f);
                this.f17333g = this.b.getMeasuredHeight();
                break;
            case 4:
                this.b.setPivotX(r0.getMeasuredWidth());
                this.b.setPivotY(0.0f);
                this.f17332f = -this.b.getMeasuredWidth();
                this.f17333g = this.b.getMeasuredHeight();
                break;
            case 5:
                this.b.setPivotX(r0.getMeasuredWidth());
                this.b.setPivotY(r0.getMeasuredHeight() / 2);
                this.f17332f = -this.b.getMeasuredWidth();
                break;
            case 6:
                this.b.setPivotX(r0.getMeasuredWidth());
                this.b.setPivotY(r0.getMeasuredHeight());
                this.f17332f = -this.b.getMeasuredWidth();
                this.f17333g = -this.b.getMeasuredHeight();
                break;
            case 7:
                this.b.setPivotX(r0.getMeasuredWidth() / 2);
                this.b.setPivotY(r0.getMeasuredHeight());
                this.f17333g = -this.b.getMeasuredHeight();
                break;
            case 8:
                this.b.setPivotX(0.0f);
                this.b.setPivotY(r0.getMeasuredHeight());
                this.f17332f = this.b.getMeasuredWidth();
                this.f17333g = -this.b.getMeasuredHeight();
                break;
        }
    }

    @Override // com.lxj.xpopup.b.c
    public void a() {
        if (this.a) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        a(valueAnimatorOfFloat);
        valueAnimatorOfFloat.addUpdateListener(new c());
        valueAnimatorOfFloat.setDuration(this.f17324c).setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfFloat.start();
    }

    @Override // com.lxj.xpopup.b.c
    public void b() {
        this.b.post(new b());
    }

    @Override // com.lxj.xpopup.b.c
    public void c() {
        this.b.setAlpha(this.f17334h);
        this.b.setScaleX(this.f17335i);
        if (!this.f17336j) {
            this.b.setScaleY(this.f17335i);
        }
        this.b.post(new a());
    }
}

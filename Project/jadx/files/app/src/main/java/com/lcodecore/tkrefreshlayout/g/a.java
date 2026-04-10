package com.lcodecore.tkrefreshlayout.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/* JADX INFO: compiled from: AnimProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements com.lcodecore.tkrefreshlayout.g.d, com.lcodecore.tkrefreshlayout.g.c {
    private TwinklingRefreshLayout.d a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f17010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17011g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f17012h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f17015k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f17017m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17007c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17008d = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f17013i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f17014j = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17016l = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f17018n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f17019o = new C0478a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f17020p = new b();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f17021q = new c();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f17022r = new d();
    private DecelerateInterpolator b = new DecelerateInterpolator(8.0f);

    /* JADX INFO: renamed from: com.lcodecore.tkrefreshlayout.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimProcessor.java */
    class C0478a implements ValueAnimator.AnimatorUpdateListener {
        C0478a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (a.this.f17007c && a.this.a.w()) {
                a.this.d(iIntValue);
            } else {
                a.this.a.p().getLayoutParams().height = iIntValue;
                a.this.a.p().requestLayout();
                a.this.a.p().setTranslationY(0.0f);
                a.this.a.a(iIntValue);
            }
            if (a.this.a.A()) {
                return;
            }
            a.this.a.t().setTranslationY(iIntValue);
            a.this.c(iIntValue);
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (a.this.f17008d && a.this.a.w()) {
                a.this.c(iIntValue);
            } else {
                a.this.a.n().getLayoutParams().height = iIntValue;
                a.this.a.n().requestLayout();
                a.this.a.n().setTranslationY(0.0f);
                a.this.a.b(iIntValue);
            }
            a.this.a.t().setTranslationY(-iIntValue);
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (a.this.a.C()) {
                if (a.this.a.p().getVisibility() != 0) {
                    a.this.a.p().setVisibility(0);
                }
            } else if (a.this.a.p().getVisibility() != 8) {
                a.this.a.p().setVisibility(8);
            }
            if (a.this.f17007c && a.this.a.w()) {
                a.this.d(iIntValue);
            } else {
                a.this.a.p().setTranslationY(0.0f);
                a.this.a.p().getLayoutParams().height = iIntValue;
                a.this.a.p().requestLayout();
                a.this.a.a(iIntValue);
            }
            a.this.a.t().setTranslationY(iIntValue);
            a.this.c(iIntValue);
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (a.this.a.B()) {
                if (a.this.a.n().getVisibility() != 0) {
                    a.this.a.n().setVisibility(0);
                }
            } else if (a.this.a.n().getVisibility() != 8) {
                a.this.a.n().setVisibility(8);
            }
            if (a.this.f17008d && a.this.a.w()) {
                a.this.c(iIntValue);
            } else {
                a.this.a.n().getLayoutParams().height = iIntValue;
                a.this.a.n().requestLayout();
                a.this.a.n().setTranslationY(0.0f);
                a.this.a.b(iIntValue);
            }
            a.this.a.t().setTranslationY(-iIntValue);
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f17009e = false;
            if (a.this.a.p().getVisibility() != 0) {
                a.this.a.p().setVisibility(0);
            }
            a.this.a.e(true);
            if (!a.this.a.w()) {
                a.this.a.f(true);
                a.this.a.O();
            } else {
                if (a.this.f17007c) {
                    return;
                }
                a.this.a.f(true);
                a.this.a.O();
                a.this.f17007c = true;
            }
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ boolean f17028s;

        f(boolean z2) {
            this.f17028s = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f17010f = false;
            a.this.a.e(false);
            if (this.f17028s && a.this.f17007c && a.this.a.w()) {
                a.this.a.p().getLayoutParams().height = 0;
                a.this.a.p().requestLayout();
                a.this.a.p().setTranslationY(0.0f);
                a.this.f17007c = false;
                a.this.a.f(false);
                a.this.a.R();
            }
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f17011g = false;
            if (a.this.a.n().getVisibility() != 0) {
                a.this.a.n().setVisibility(0);
            }
            a.this.a.a(true);
            if (!a.this.a.w()) {
                a.this.a.b(true);
                a.this.a.M();
            } else {
                if (a.this.f17008d) {
                    return;
                }
                a.this.a.b(true);
                a.this.a.M();
                a.this.f17008d = true;
            }
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iE;
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (!com.lcodecore.tkrefreshlayout.h.c.a(a.this.a.t(), a.this.a.u()) && (iE = a.this.e() - iIntValue) > 0) {
                if (a.this.a.t() instanceof RecyclerView) {
                    com.lcodecore.tkrefreshlayout.h.c.c(a.this.a.t(), iE);
                } else {
                    com.lcodecore.tkrefreshlayout.h.c.c(a.this.a.t(), iE / 2);
                }
            }
            a.this.f17020p.onAnimationUpdate(valueAnimator);
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ boolean f17032s;

        i(boolean z2) {
            this.f17032s = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f17012h = false;
            a.this.a.a(false);
            if (this.f17032s && a.this.f17008d && a.this.a.w()) {
                a.this.a.n().getLayoutParams().height = 0;
                a.this.a.n().requestLayout();
                a.this.a.n().setTranslationY(0.0f);
                a.this.f17008d = false;
                a.this.a.Q();
                a.this.a.b(false);
            }
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f17013i = false;
            a.this.a.e(false);
            if (a.this.a.w()) {
                return;
            }
            a.this.a.f(false);
            a.this.a.P();
            a.this.a.R();
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class k extends AnimatorListenerAdapter {
        k() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f17014j = false;
            a.this.a.a(false);
            if (a.this.a.w()) {
                return;
            }
            a.this.a.b(false);
            a.this.a.N();
            a.this.a.Q();
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class l extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f17036s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int f17037t;

        /* JADX INFO: renamed from: com.lcodecore.tkrefreshlayout.g.a$l$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AnimProcessor.java */
        class C0479a extends AnimatorListenerAdapter {
            C0479a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f17015k = false;
                a.this.f17016l = false;
            }
        }

        l(int i2, int i3) {
            this.f17036s = i2;
            this.f17037t = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!a.this.f17007c || !a.this.a.w() || !a.this.a.V()) {
                a aVar = a.this;
                aVar.a(this.f17036s, 0, this.f17037t * 2, aVar.f17021q, new C0479a());
            } else {
                a.this.b();
                a.this.f17015k = false;
                a.this.f17016l = false;
            }
        }
    }

    /* JADX INFO: compiled from: AnimProcessor.java */
    class m extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f17040s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int f17041t;

        /* JADX INFO: renamed from: com.lcodecore.tkrefreshlayout.g.a$m$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AnimProcessor.java */
        class C0480a extends AnimatorListenerAdapter {
            C0480a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f17017m = false;
                a.this.f17018n = false;
            }
        }

        m(int i2, int i3) {
            this.f17040s = i2;
            this.f17041t = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!a.this.f17008d || !a.this.a.w() || !a.this.a.U()) {
                a aVar = a.this;
                aVar.a(this.f17040s, 0, this.f17041t * 2, aVar.f17022r, new C0480a());
            } else {
                a.this.a();
                a.this.f17017m = false;
                a.this.f17018n = false;
            }
        }
    }

    public a(TwinklingRefreshLayout.d dVar) {
        this.a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        com.lcodecore.tkrefreshlayout.h.b.a("footer translationY:" + this.a.n().getTranslationY() + "");
        return (int) (this.a.n().getLayoutParams().height - this.a.n().getTranslationY());
    }

    private int f() {
        com.lcodecore.tkrefreshlayout.h.b.a("header translationY:" + this.a.p().getTranslationY() + ",Visible head height:" + (this.a.p().getLayoutParams().height + this.a.p().getTranslationY()));
        return (int) (this.a.p().getLayoutParams().height + this.a.p().getTranslationY());
    }

    public void c() {
        if (!this.a.F() && this.a.g() && f() >= this.a.o() - this.a.u()) {
            b();
        } else {
            b(false);
        }
    }

    public void d() {
        if (!this.a.F() && this.a.e() && e() >= this.a.l() - this.a.u()) {
            a();
        } else {
            a(false);
        }
    }

    public void b(float f2) {
        float interpolation = (this.b.getInterpolation((f2 / this.a.r()) / 2.0f) * f2) / 2.0f;
        if (!this.a.F() && (this.a.g() || this.a.C())) {
            if (this.a.p().getVisibility() != 0) {
                this.a.p().setVisibility(0);
            }
        } else if (this.a.p().getVisibility() != 8) {
            this.a.p().setVisibility(8);
        }
        if (this.f17007c && this.a.w()) {
            this.a.p().setTranslationY(interpolation - this.a.p().getLayoutParams().height);
        } else {
            this.a.p().setTranslationY(0.0f);
            this.a.p().getLayoutParams().height = (int) Math.abs(interpolation);
            this.a.p().requestLayout();
            this.a.c(interpolation);
        }
        if (this.a.A()) {
            return;
        }
        this.a.t().setTranslationY(interpolation);
        c((int) interpolation);
    }

    public void a(float f2) {
        float interpolation = (this.b.getInterpolation((f2 / this.a.q()) / 2.0f) * f2) / 2.0f;
        if (!this.a.F() && (this.a.e() || this.a.B())) {
            if (this.a.n().getVisibility() != 0) {
                this.a.n().setVisibility(0);
            }
        } else if (this.a.n().getVisibility() != 8) {
            this.a.n().setVisibility(8);
        }
        if (this.f17008d && this.a.w()) {
            this.a.n().setTranslationY(this.a.n().getLayoutParams().height - interpolation);
        } else {
            this.a.n().setTranslationY(0.0f);
            this.a.n().getLayoutParams().height = (int) Math.abs(interpolation);
            this.a.n().requestLayout();
            this.a.d(-interpolation);
        }
        this.a.t().setTranslationY(-interpolation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2) {
        this.a.n().setTranslationY(this.a.n().getLayoutParams().height - f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(float f2) {
        this.a.p().setTranslationY(f2 - this.a.p().getLayoutParams().height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        if (this.a.x()) {
            return;
        }
        this.a.m().setTranslationY(i2);
    }

    public void a() {
        com.lcodecore.tkrefreshlayout.h.b.a("animBottomToLoad");
        a(e(), this.a.l(), this.f17020p, new g());
    }

    public void b() {
        com.lcodecore.tkrefreshlayout.h.b.a("animHeadToRefresh:");
        a(f(), this.a.o(), this.f17019o, new e());
    }

    public void a(boolean z2) {
        com.lcodecore.tkrefreshlayout.h.b.a("animBottomBack：finishLoading?->" + z2);
        if (z2 && this.f17008d && this.a.w()) {
            this.a.c(true);
        }
        a(e(), 0, new h(), new i(z2));
    }

    public void b(boolean z2) {
        com.lcodecore.tkrefreshlayout.h.b.a("animHeadBack：finishRefresh?->" + z2);
        if (z2 && this.f17007c && this.a.w()) {
            this.a.d(true);
        }
        a(f(), 0, this.f17019o, new f(z2));
    }

    public void a(int i2) {
        com.lcodecore.tkrefreshlayout.h.b.a("animBottomHideByVy：vy->" + i2);
        if (this.f17014j) {
            return;
        }
        this.f17014j = true;
        int iAbs = Math.abs(i2);
        if (iAbs < 5000) {
            iAbs = 8000;
        }
        a(e(), 0, ((e() * 5) * 1000) / iAbs, this.f17020p, new k());
    }

    public void b(int i2) {
        if (this.f17013i) {
            return;
        }
        this.f17013i = true;
        com.lcodecore.tkrefreshlayout.h.b.a("animHeadHideByVy：vy->" + i2);
        int iAbs = Math.abs(i2);
        if (iAbs < 5000) {
            iAbs = 8000;
        }
        a(f(), 0, Math.abs((f() * 1000) / iAbs) * 5, this.f17019o, new j());
    }

    public void a(float f2, int i2) {
        int i3;
        com.lcodecore.tkrefreshlayout.h.b.a("animOverScrollBottom：vy->" + f2 + ",computeTimes->" + i2);
        if (this.f17018n) {
            return;
        }
        this.a.S();
        int iAbs = (int) Math.abs((f2 / i2) / 2.0f);
        if (iAbs > this.a.s()) {
            iAbs = this.a.s();
        }
        int i4 = iAbs;
        if (i4 <= 50) {
            i3 = 115;
        } else {
            double d2 = i4;
            Double.isNaN(d2);
            i3 = (int) ((d2 * 0.3d) + 100.0d);
        }
        if (!this.f17008d && this.a.d()) {
            this.a.W();
        } else {
            this.f17018n = true;
            a(0, i4, i3, this.f17022r, new m(i4, i3));
        }
    }

    public void b(float f2, int i2) {
        int i3;
        com.lcodecore.tkrefreshlayout.h.b.a("animOverScrollTop：vy->" + f2 + ",computeTimes->" + i2);
        if (this.f17016l) {
            return;
        }
        this.f17016l = true;
        this.a.T();
        int iAbs = (int) Math.abs((f2 / i2) / 2.0f);
        if (iAbs > this.a.s()) {
            iAbs = this.a.s();
        }
        int i4 = iAbs;
        if (i4 <= 50) {
            i3 = 115;
        } else {
            double d2 = i4;
            Double.isNaN(d2);
            i3 = (int) ((d2 * 0.3d) + 100.0d);
        }
        a(f(), i4, i3, this.f17021q, new l(i4, i3));
    }

    public void a(int i2, int i3, long j2, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Animator.AnimatorListener animatorListener) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i2, i3);
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(animatorUpdateListener);
        valueAnimatorOfInt.addListener(animatorListener);
        valueAnimatorOfInt.setDuration(j2);
        valueAnimatorOfInt.start();
    }

    public void a(int i2, int i3, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Animator.AnimatorListener animatorListener) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i2, i3);
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(animatorUpdateListener);
        valueAnimatorOfInt.addListener(animatorListener);
        valueAnimatorOfInt.setDuration((int) (Math.abs(i2 - i3) * 1.0f));
        valueAnimatorOfInt.start();
    }
}

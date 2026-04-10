package com.amgcyo.cuttadon.view.comment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public class AppBarOverScrollViewBehavior extends AppBarLayout.Behavior {
    private boolean A;
    private d B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View f4599s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4600t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4601u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f4602v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f4603w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4604x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f4605y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Toolbar f4606z;

    class a implements AppBarLayout.d {
        a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public final void a(AppBarLayout appBarLayout, int i2) {
            AppBarOverScrollViewBehavior.this.f4606z.setAlpha(Math.abs(i2) / appBarLayout.getTotalScrollRange());
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ AppBarLayout f4607s;

        b(AppBarLayout appBarLayout) {
            this.f4607s = appBarLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ViewCompat.setScaleX(AppBarOverScrollViewBehavior.this.f4599s, fFloatValue);
            ViewCompat.setScaleY(AppBarOverScrollViewBehavior.this.f4599s, fFloatValue);
            this.f4607s.setBottom((int) (AppBarOverScrollViewBehavior.this.f4604x - ((AppBarOverScrollViewBehavior.this.f4604x - AppBarOverScrollViewBehavior.this.f4600t) * valueAnimator.getAnimatedFraction())));
            if (AppBarOverScrollViewBehavior.this.B != null) {
                AppBarOverScrollViewBehavior.this.B.a(Math.min((fFloatValue - 1.0f) / 0.3f, 1.0f), true);
            }
        }
    }

    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AppBarOverScrollViewBehavior.this.A = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public interface d {
        void a(float f2, boolean z2);
    }

    public AppBarOverScrollViewBehavior() {
        this.A = false;
    }

    private void d(AppBarLayout appBarLayout) {
        appBarLayout.setClipChildren(false);
        this.f4600t = appBarLayout.getHeight();
        this.f4601u = this.f4599s.getHeight();
    }

    private void e(AppBarLayout appBarLayout) {
        if (!this.A && this.f4602v > 0.0f) {
            this.A = true;
            this.f4602v = 0.0f;
            if (this.f4605y) {
                ValueAnimator duration = ValueAnimator.ofFloat(this.f4603w, 1.0f).setDuration(200L);
                duration.addUpdateListener(new b(appBarLayout));
                duration.addListener(new c());
                duration.start();
                return;
            }
            ViewCompat.setScaleX(this.f4599s, 1.0f);
            ViewCompat.setScaleY(this.f4599s, 1.0f);
            appBarLayout.setBottom(this.f4600t);
            this.A = false;
            d dVar = this.B;
            if (dVar != null) {
                dVar.a(0.0f, true);
            }
        }
    }

    public AppBarOverScrollViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
        boolean zA = super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
        if (this.f4606z == null) {
            this.f4606z = (Toolbar) coordinatorLayout.findViewWithTag("toolbar");
        }
        if (this.f4599s == null) {
            this.f4599s = coordinatorLayout.findViewWithTag("overScroll");
            if (this.f4599s != null) {
                d(appBarLayout);
            }
        }
        appBarLayout.a((AppBarLayout.d) new a());
        return zA;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i2) {
        this.f4605y = true;
        if (view2 instanceof DisInterceptNestedScrollView) {
            return true;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i2, int i3, @NonNull int[] iArr) {
        if (!this.A && this.f4599s != null && ((i3 < 0 && appBarLayout.getBottom() >= this.f4600t) || (i3 > 0 && appBarLayout.getBottom() > this.f4600t))) {
            a(appBarLayout, view, i3);
        } else {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i2, i3, iArr);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f2, float f3) {
        if (f3 > 100.0f) {
            this.f4605y = false;
        }
        return super.onNestedPreFling(coordinatorLayout, appBarLayout, view, f2, f3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view) {
        e(appBarLayout);
        super.onStopNestedScroll(coordinatorLayout, appBarLayout, view);
    }

    private void a(AppBarLayout appBarLayout, View view, int i2) {
        this.f4602v += -i2;
        this.f4602v = Math.min(this.f4602v, 1500.0f);
        this.f4603w = Math.max(1.0f, (this.f4602v / 1500.0f) + 1.0f);
        ViewCompat.setScaleX(this.f4599s, this.f4603w);
        ViewCompat.setScaleY(this.f4599s, this.f4603w);
        this.f4604x = this.f4600t + ((int) ((this.f4601u / 2) * (this.f4603w - 1.0f)));
        appBarLayout.setBottom(this.f4604x);
        view.setScrollY(0);
        if (this.B != null) {
            this.B.a(Math.min((this.f4603w - 1.0f) / 0.3f, 1.0f), false);
        }
    }

    public void a(d dVar) {
        this.B = dVar;
    }
}

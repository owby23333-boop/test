package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private ViewPropertyAnimator f15001d;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f15001d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.a = 0;
        this.b = 2;
        this.f15000c = 0;
    }

    public void b(@NonNull V v2) {
        if (this.b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f15001d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v2.clearAnimation();
        }
        this.b = 2;
        a(v2, 0, 225L, com.google.android.material.a.a.f14915d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i2) {
        this.a = v2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v2.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v2, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
        if (i3 > 0) {
            a(v2);
        } else if (i3 < 0) {
            b(v2);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, @NonNull View view2, int i2, int i3) {
        return i2 == 2;
    }

    public void a(@NonNull V v2, @Dimension int i2) {
        this.f15000c = i2;
        if (this.b == 1) {
            v2.setTranslationY(this.a + this.f15000c);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 2;
        this.f15000c = 0;
    }

    public void a(@NonNull V v2) {
        if (this.b == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f15001d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v2.clearAnimation();
        }
        this.b = 1;
        a(v2, this.a + this.f15000c, 175L, com.google.android.material.a.a.f14914c);
    }

    private void a(@NonNull V v2, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f15001d = v2.animate().translationY(i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new a());
    }
}

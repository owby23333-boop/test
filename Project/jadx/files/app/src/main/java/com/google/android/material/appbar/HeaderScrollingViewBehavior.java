package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Rect f14967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Rect f14968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14970g;

    public HeaderScrollingViewBehavior() {
        this.f14967d = new Rect();
        this.f14968e = new Rect();
        this.f14969f = 0;
    }

    private static int c(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    @Nullable
    abstract View a(List<View> list);

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    protected void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
        View viewA = a(coordinatorLayout.getDependencies(view));
        if (viewA == null) {
            super.a(coordinatorLayout, view, i2);
            this.f14969f = 0;
            return;
        }
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        Rect rect = this.f14967d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, viewA.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((coordinatorLayout.getHeight() + viewA.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
            rect.left += lastWindowInsets.getSystemWindowInsetLeft();
            rect.right -= lastWindowInsets.getSystemWindowInsetRight();
        }
        Rect rect2 = this.f14968e;
        GravityCompat.apply(c(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
        int iA = a(viewA);
        view.layout(rect2.left, rect2.top - iA, rect2.right, rect2.bottom - iA);
        this.f14969f = rect2.top - viewA.getBottom();
    }

    float b(View view) {
        return 1.0f;
    }

    public final void b(int i2) {
        this.f14970g = i2;
    }

    int c(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    protected boolean d() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4, int i5) {
        View viewA;
        WindowInsetsCompat lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if ((i6 != -1 && i6 != -2) || (viewA = a(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (ViewCompat.getFitsSystemWindows(viewA) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.getSystemWindowInsetTop() + lastWindowInsets.getSystemWindowInsetBottom();
        }
        int iC = size + c(viewA);
        int measuredHeight = viewA.getMeasuredHeight();
        if (d()) {
            view.setTranslationY(-measuredHeight);
        } else {
            iC -= measuredHeight;
        }
        coordinatorLayout.onMeasureChild(view, i2, i3, View.MeasureSpec.makeMeasureSpec(iC, i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
        return true;
    }

    public final int b() {
        return this.f14970g;
    }

    final int c() {
        return this.f14969f;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14967d = new Rect();
        this.f14968e = new Rect();
        this.f14969f = 0;
    }

    final int a(View view) {
        if (this.f14970g == 0) {
            return 0;
        }
        float fB = b(view);
        int i2 = this.f14970g;
        return MathUtils.clamp((int) (fB * i2), 0, i2);
    }
}

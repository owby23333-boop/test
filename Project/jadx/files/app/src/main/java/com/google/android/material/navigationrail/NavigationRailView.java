package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.l;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationRailView extends NavigationBarView {

    @Nullable
    private View A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f15615z;

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationRailStyle);
    }

    private int c(int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i2) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i2;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    private b getNavigationRailMenuView() {
        return (b) getMenuView();
    }

    public void b(@LayoutRes int i2) {
        a(LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) this, false));
    }

    @Nullable
    public View getHeaderView() {
        return this.A;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        b navigationRailMenuView = getNavigationRailMenuView();
        int i6 = 0;
        if (b()) {
            int bottom = this.A.getBottom() + this.f15615z;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i6 = bottom - top;
            }
        } else if (navigationRailMenuView.c()) {
            i6 = this.f15615z;
        }
        if (i6 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i6, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i6);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int iC = c(i2);
        super.onMeasure(iC, i3);
        if (b()) {
            measureChild(getNavigationRailMenuView(), iC, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.A.getMeasuredHeight()) - this.f15615z, Integer.MIN_VALUE));
        }
    }

    public void setMenuGravity(int i2) {
        getNavigationRailMenuView().setMenuGravity(i2);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R$style.Widget_MaterialComponents_NavigationRailView);
    }

    private boolean b() {
        View view = this.A;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    public void a(@NonNull View view) {
        a();
        this.A = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f15615z;
        addView(view, 0, layoutParams);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f15615z = getResources().getDimensionPixelSize(R$dimen.mtrl_navigation_rail_margin);
        TintTypedArray tintTypedArrayD = l.d(getContext(), attributeSet, R$styleable.NavigationRailView, i2, i3, new int[0]);
        int resourceId = tintTypedArrayD.getResourceId(R$styleable.NavigationRailView_headerLayout, 0);
        if (resourceId != 0) {
            b(resourceId);
        }
        setMenuGravity(tintTypedArrayD.getInt(R$styleable.NavigationRailView_menuGravity, 49));
        tintTypedArrayD.recycle();
    }

    public void a() {
        View view = this.A;
        if (view != null) {
            removeView(view);
            this.A = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public b a(@NonNull Context context) {
        return new b(context);
    }
}

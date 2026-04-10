package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.c;

/* JADX INFO: compiled from: NavigationRailMenuView.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b extends c {
    private final FrameLayout.LayoutParams N;

    public b(@NonNull Context context) {
        super(context);
        this.N = new FrameLayout.LayoutParams(-1, -2);
        FrameLayout.LayoutParams layoutParams = this.N;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
    }

    private int b(int i2, int i3, int i4) {
        int iA;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            iA = a(childAt, i2, a(i2, i3, i4));
            i3 -= iA;
            i4--;
        } else {
            iA = 0;
        }
        return iA + a(i2, i3, i4, childAt);
    }

    @Override // com.google.android.material.navigation.c
    @NonNull
    protected com.google.android.material.navigation.a a(@NonNull Context context) {
        return new a(context);
    }

    boolean c() {
        return (this.N.gravity & 112) == 48;
    }

    int getMenuGravity() {
        return this.N.gravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i7;
                childAt.layout(0, i7, i6, measuredHeight);
                i7 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        int size2 = getMenu().getVisibleItems().size();
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i2), i2, 0), View.resolveSizeAndState((size2 <= 1 || !a(getLabelVisibilityMode(), size2)) ? a(i2, size, size2, null) : b(i2, size, size2), i3, 0));
    }

    void setMenuGravity(int i2) {
        FrameLayout.LayoutParams layoutParams = this.N;
        if (layoutParams.gravity != i2) {
            layoutParams.gravity = i2;
            setLayoutParams(layoutParams);
        }
    }

    private int a(int i2, int i3, int i4) {
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), i3 / Math.max(1, i4)), 0);
    }

    private int a(int i2, int i3, int i4, View view) {
        int iMakeMeasureSpec;
        a(i2, i3, i4);
        if (view == null) {
            iMakeMeasureSpec = a(i2, i3, i4);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int iA = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                iA += a(childAt, i2, iMakeMeasureSpec);
            }
        }
        return iA;
    }

    private int a(View view, int i2, int i3) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i2, i3);
        return view.getMeasuredHeight();
    }
}

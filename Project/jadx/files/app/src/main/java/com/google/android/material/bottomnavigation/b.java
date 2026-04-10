package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.navigation.c;

/* JADX INFO: compiled from: BottomNavigationMenuView.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b extends c {
    private final int N;
    private final int O;
    private final int P;
    private final int Q;
    private final int R;
    private boolean S;
    private int[] T;

    public b(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.N = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_max_width);
        this.O = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_min_width);
        this.P = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_max_width);
        this.Q = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_min_width);
        this.R = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_height);
        this.T = new int[5];
    }

    @Override // com.google.android.material.navigation.c
    @NonNull
    protected com.google.android.material.navigation.a a(@NonNull Context context) {
        return new a(context);
    }

    public boolean c() {
        return this.S;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int measuredWidth = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i9 = i6 - measuredWidth;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i7);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i7);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = menu.getVisibleItems().size();
        int childCount = getChildCount();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.R, 1073741824);
        if (a(getLabelVisibilityMode(), size2) && c()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int iMax = this.Q;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.P, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i4 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.O * i4), Math.min(iMax, this.P));
            int i5 = size - iMin;
            int iMin2 = Math.min(i5 / (i4 == 0 ? 1 : i4), this.N);
            int i6 = i5 - (i4 * iMin2);
            int i7 = 0;
            while (i7 < childCount) {
                if (getChildAt(i7).getVisibility() != 8) {
                    this.T[i7] = i7 == getSelectedItemPosition() ? iMin : iMin2;
                    if (i6 > 0) {
                        int[] iArr = this.T;
                        iArr[i7] = iArr[i7] + 1;
                        i6--;
                    }
                } else {
                    this.T[i7] = 0;
                }
                i7++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 == 0 ? 1 : size2), this.P);
            int i8 = size - (size2 * iMin3);
            for (int i9 = 0; i9 < childCount; i9++) {
                if (getChildAt(i9).getVisibility() != 8) {
                    int[] iArr2 = this.T;
                    iArr2[i9] = iMin3;
                    if (i8 > 0) {
                        iArr2[i9] = iArr2[i9] + 1;
                        i8--;
                    }
                } else {
                    this.T[i9] = 0;
                }
            }
        }
        int measuredWidth = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt2 = getChildAt(i10);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.T[i10], 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth, View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), 0), View.resolveSizeAndState(this.R, iMakeMeasureSpec, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        this.S = z2;
    }
}

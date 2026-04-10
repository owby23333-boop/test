package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes5.dex */
public class RightAlignedLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f5513a = false;

    public RightAlignedLinearLayout(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        measureChildWithMargins(childAt2, i, 0, i2, 0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
        measureChildWithMargins(childAt, i, layoutParams.leftMargin + childAt2.getMeasuredWidth() + layoutParams.rightMargin, i2, 0);
        setMeasuredDimension(View.MeasureSpec.getSize(i), childAt2.getMeasuredHeight() > childAt.getMeasuredHeight() ? childAt2.getMeasuredHeight() : childAt.getMeasuredHeight());
    }

    public RightAlignedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
    }
}

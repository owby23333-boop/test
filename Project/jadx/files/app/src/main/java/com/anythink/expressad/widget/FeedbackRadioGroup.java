package com.anythink.expressad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/* JADX INFO: loaded from: classes2.dex */
public class FeedbackRadioGroup extends RadioGroup {
    private static final String a = "FeedbackRadioGroup";

    public FeedbackRadioGroup(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int iMax = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (marginLayoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin + getPaddingRight() > i4 - i2) {
                paddingLeft = getPaddingLeft();
                paddingTop += iMax;
                iMax = getChildAt(i6).getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            } else {
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            }
            int i7 = marginLayoutParams.leftMargin + paddingLeft;
            int i8 = marginLayoutParams.topMargin + paddingTop;
            childAt.layout(i7, i8, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + i8);
            paddingLeft += marginLayoutParams.leftMargin + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        measureChildren(i2, i3);
        int childCount = getChildCount();
        int iMax = 0;
        int i5 = 0;
        int iMax2 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int i8 = i6 + measuredWidth;
            if (getPaddingLeft() + i8 + getPaddingRight() > size) {
                int iMax3 = Math.max(i6, iMax);
                i5 += iMax2;
                iMax2 = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                String str = "maxHeight:" + i5 + "---maxWidth:" + iMax3;
                i4 = iMax3;
                i6 = measuredWidth;
            } else {
                iMax2 = Math.max(iMax2, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                i4 = iMax;
                i6 = i8;
            }
            if (i7 == childCount - 1) {
                i5 += iMax2;
                iMax = Math.max(i6, iMax);
            } else {
                iMax = i4;
            }
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + iMax;
        int paddingTop = getPaddingTop() + getPaddingBottom() + i5;
        if (mode != 1073741824) {
            size = paddingLeft;
        }
        if (mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    public FeedbackRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

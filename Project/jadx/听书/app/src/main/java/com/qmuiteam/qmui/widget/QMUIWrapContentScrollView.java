package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIWrapContentScrollView extends QMUIObservableScrollView {
    private int mMaxHeight;

    public QMUIWrapContentScrollView(Context context) {
        super(context);
        this.mMaxHeight = 536870911;
    }

    public QMUIWrapContentScrollView(Context context, int i) {
        super(context);
        this.mMaxHeight = i;
    }

    public QMUIWrapContentScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxHeight = 536870911;
    }

    public QMUIWrapContentScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxHeight = 536870911;
    }

    public void setMaxHeight(int i) {
        if (this.mMaxHeight != i) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int iMin = Math.min(View.MeasureSpec.getSize(i2), this.mMaxHeight);
        if (layoutParams != null && layoutParams.height > 0 && layoutParams.height <= this.mMaxHeight) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        }
        super.onMeasure(i, iMakeMeasureSpec);
    }
}

package miuix.appcompat.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes7.dex */
public class NestedScrollViewExpander extends ViewGroup {
    private View mExpandView;
    private int mParentHeightMeasureSpec;

    public NestedScrollViewExpander(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i6 = (((((i3 - i) - measuredWidth) / 2) + i) + marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            int i7 = marginLayoutParams.topMargin + i2;
            childAt.layout(i6, i7, measuredWidth + i6, i7 + measuredHeight);
            i2 = i2 + marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(this.mParentHeightMeasureSpec);
        if (mode == 0) {
            mode = Integer.MIN_VALUE;
        }
        int i3 = mode;
        int size = View.MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int measuredHeight = 0;
        int measuredHeight2 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && this.mExpandView != childAt) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                measureChildWithMargins(childAt, i, 0, i2, 0);
                measuredHeight2 += childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
        }
        int size2 = View.MeasureSpec.getSize(this.mParentHeightMeasureSpec) - measuredHeight2;
        View view = this.mExpandView;
        if (view != null && view.getVisibility() != 8) {
            if (size2 < this.mExpandView.getMinimumHeight()) {
                size2 = this.mExpandView.getMinimumHeight();
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mExpandView.getLayoutParams();
            measureChildWithMargins(this.mExpandView, i, 0, View.MeasureSpec.makeMeasureSpec(size2, i3), 0);
            measuredHeight = this.mExpandView.getMeasuredHeight() + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
        }
        setMeasuredDimension(size, measuredHeight + measuredHeight2);
    }

    public void setExpandView(View view) {
        this.mExpandView = view;
    }

    public void setParentHeightMeasureSpec(int i) {
        this.mParentHeightMeasureSpec = i;
    }

    public NestedScrollViewExpander(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NestedScrollViewExpander(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

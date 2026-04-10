package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIContinuousNestedBottomAreaBehavior extends QMUIViewOffsetBehavior<View> {
    private int mTopInset;
    private final Rect tempRect1;
    private final Rect tempRect2;

    private static int resolveGravity(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    public void setTopInset(int i) {
        this.mTopInset = i;
    }

    public QMUIContinuousNestedBottomAreaBehavior() {
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.mTopInset = 0;
    }

    public QMUIContinuousNestedBottomAreaBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.mTopInset = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 != -1 && i5 != -2) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.onMeasureChild(view, i, i2, View.MeasureSpec.makeMeasureSpec(size - this.mTopInset, i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIViewOffsetBehavior
    protected void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        if (!dependencies.isEmpty()) {
            View view2 = dependencies.get(0);
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.tempRect1;
            rect.set(coordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, view2.getBottom() + layoutParams.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - layoutParams.rightMargin, ((coordinatorLayout.getHeight() + view2.getBottom()) - coordinatorLayout.getPaddingBottom()) - layoutParams.bottomMargin);
            Rect rect2 = this.tempRect2;
            GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            return;
        }
        super.layoutChild(coordinatorLayout, view, i);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, view, i);
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        if (!dependencies.isEmpty()) {
            setTopAndBottomOffset(dependencies.get(0).getBottom() - getLayoutTop());
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof IQMUIContinuousNestedTopView;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        setTopAndBottomOffset(view2.getBottom() - getLayoutTop());
        return false;
    }
}

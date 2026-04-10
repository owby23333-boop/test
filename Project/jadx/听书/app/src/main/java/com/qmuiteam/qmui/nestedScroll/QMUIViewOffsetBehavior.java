package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.qmuiteam.qmui.util.QMUIViewOffsetHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private QMUIViewOffsetHelper viewOffsetHelper;

    public QMUIViewOffsetBehavior() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public QMUIViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        layoutChild(coordinatorLayout, v, i);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new QMUIViewOffsetHelper(v);
        }
        this.viewOffsetHelper.onViewLayout();
        int i2 = this.tempTopBottomOffset;
        if (i2 != 0) {
            this.viewOffsetHelper.setTopAndBottomOffset(i2);
            this.tempTopBottomOffset = 0;
        }
        int i3 = this.tempLeftRightOffset;
        if (i3 == 0) {
            return true;
        }
        this.viewOffsetHelper.setLeftAndRightOffset(i3);
        this.tempLeftRightOffset = 0;
        return true;
    }

    protected void layoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    public boolean setTopAndBottomOffset(int i) {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.setTopAndBottomOffset(i);
        }
        this.tempTopBottomOffset = i;
        return false;
    }

    public boolean setLeftAndRightOffset(int i) {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.setLeftAndRightOffset(i);
        }
        this.tempLeftRightOffset = i;
        return false;
    }

    public int getTopAndBottomOffset() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.getTopAndBottomOffset();
        }
        return 0;
    }

    public int getLeftAndRightOffset() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.getLeftAndRightOffset();
        }
        return 0;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            qMUIViewOffsetHelper.setVerticalOffsetEnabled(z);
        }
    }

    public int getLayoutTop() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.getLayoutTop();
        }
        return 0;
    }

    public int getLayoutLeft() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.getLayoutLeft();
        }
        return 0;
    }

    public boolean isVerticalOffsetEnabled() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        return qMUIViewOffsetHelper != null && qMUIViewOffsetHelper.isVerticalOffsetEnabled();
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            qMUIViewOffsetHelper.setHorizontalOffsetEnabled(z);
        }
    }

    public boolean isHorizontalOffsetEnabled() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        return qMUIViewOffsetHelper != null && qMUIViewOffsetHelper.isHorizontalOffsetEnabled();
    }
}

package com.qmuiteam.qmui.util;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes4.dex */
public final class QMUIViewOffsetHelper {
    private int mLayoutLeft;
    private int mLayoutTop;
    private int mOffsetLeft;
    private int mOffsetTop;
    private final View mView;
    private boolean mVerticalOffsetEnabled = true;
    private boolean mHorizontalOffsetEnabled = true;

    public QMUIViewOffsetHelper(View view) {
        this.mView = view;
    }

    public void onViewLayout() {
        onViewLayout(true);
    }

    public void onViewLayout(boolean z) {
        this.mLayoutTop = this.mView.getTop();
        this.mLayoutLeft = this.mView.getLeft();
        if (z) {
            applyOffsets();
        }
    }

    public void applyOffsets() {
        View view = this.mView;
        ViewCompat.offsetTopAndBottom(view, this.mOffsetTop - (view.getTop() - this.mLayoutTop));
        View view2 = this.mView;
        ViewCompat.offsetLeftAndRight(view2, this.mOffsetLeft - (view2.getLeft() - this.mLayoutLeft));
    }

    public boolean setTopAndBottomOffset(int i) {
        if (!this.mVerticalOffsetEnabled || this.mOffsetTop == i) {
            return false;
        }
        this.mOffsetTop = i;
        applyOffsets();
        return true;
    }

    public boolean setLeftAndRightOffset(int i) {
        if (!this.mHorizontalOffsetEnabled || this.mOffsetLeft == i) {
            return false;
        }
        this.mOffsetLeft = i;
        applyOffsets();
        return true;
    }

    public boolean setOffset(int i, int i2) {
        boolean z = this.mHorizontalOffsetEnabled;
        if (!z && !this.mVerticalOffsetEnabled) {
            return false;
        }
        if (!z || !this.mVerticalOffsetEnabled) {
            if (z) {
                return setLeftAndRightOffset(i);
            }
            return setTopAndBottomOffset(i2);
        }
        if (this.mOffsetLeft == i && this.mOffsetTop == i2) {
            return false;
        }
        this.mOffsetLeft = i;
        this.mOffsetTop = i2;
        applyOffsets();
        return true;
    }

    public int getTopAndBottomOffset() {
        return this.mOffsetTop;
    }

    public int getLeftAndRightOffset() {
        return this.mOffsetLeft;
    }

    public int getLayoutTop() {
        return this.mLayoutTop;
    }

    public int getLayoutLeft() {
        return this.mLayoutLeft;
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        this.mHorizontalOffsetEnabled = z;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.mHorizontalOffsetEnabled;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        this.mVerticalOffsetEnabled = z;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.mVerticalOffsetEnabled;
    }
}

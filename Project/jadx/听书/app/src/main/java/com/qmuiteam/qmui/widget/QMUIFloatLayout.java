package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.qmuiteam.qmui.R;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIFloatLayout extends ViewGroup {
    private static final int LINES = 0;
    private static final int NUMBER = 1;
    private int mChildHorizontalSpacing;
    private int mChildVerticalSpacing;
    private int mGravity;
    private int[] mItemNumberInEachLine;
    private int mLineCount;
    private int mMaxMode;
    private int mMaximum;
    private OnLineCountChangeListener mOnLineCountChangeListener;
    private int[] mWidthSumInEachLine;
    private int measuredChildCount;

    public interface OnLineCountChangeListener {
        void onChange(int i, int i2);
    }

    public QMUIFloatLayout(Context context) {
        this(context, null);
    }

    public QMUIFloatLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIFloatLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxMode = 0;
        this.mMaximum = Integer.MAX_VALUE;
        this.mLineCount = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIFloatLayout);
        this.mChildHorizontalSpacing = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIFloatLayout_qmui_childHorizontalSpacing, 0);
        this.mChildVerticalSpacing = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIFloatLayout_qmui_childVerticalSpacing, 0);
        this.mGravity = typedArrayObtainStyledAttributes.getInteger(R.styleable.QMUIFloatLayout_android_gravity, 3);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUIFloatLayout_android_maxLines, -1);
        if (i >= 0) {
            setMaxLines(i);
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUIFloatLayout_qmui_maxNumber, -1);
        if (i2 >= 0) {
            setMaxNumber(i2);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0136  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.widget.QMUIFloatLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = this.mGravity & 7;
        if (i6 == 1) {
            layoutWithGravityCenterHorizontal(i5);
            return;
        }
        if (i6 == 3) {
            layoutWithGravityLeft(i5);
        } else if (i6 == 5) {
            layoutWithGravityRight(i5);
        } else {
            layoutWithGravityLeft(i5);
        }
    }

    private void layoutWithGravityCenterHorizontal(int i) {
        int paddingTop = getPaddingTop();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.mItemNumberInEachLine;
            if (i2 >= iArr.length || iArr[i2] == 0) {
                break;
            }
            int paddingLeft = ((((i - getPaddingLeft()) - getPaddingRight()) - this.mWidthSumInEachLine[i2]) / 2) + getPaddingLeft();
            int i5 = 0;
            int iMax = 0;
            while (i5 < this.mItemNumberInEachLine[i2]) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 8) {
                    i3++;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    iMax = Math.max(iMax, measuredHeight);
                    paddingLeft += measuredWidth + this.mChildHorizontalSpacing;
                    i4++;
                    i5++;
                    i3++;
                    if (i4 == this.measuredChildCount) {
                        break;
                    }
                }
            }
            if (i4 == this.measuredChildCount) {
                break;
            }
            paddingTop += iMax + this.mChildVerticalSpacing;
            i2++;
        }
        int childCount = getChildCount();
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            if (childAt2.getVisibility() != 8) {
                childAt2.layout(0, 0, 0, 0);
            }
            i3++;
        }
    }

    private void layoutWithGravityLeft(int i) {
        int paddingRight = i - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i2 = 0;
        int iMax = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                if (i2 < this.measuredChildCount) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (paddingLeft + measuredWidth > paddingRight) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += iMax + this.mChildVerticalSpacing;
                        iMax = 0;
                    }
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    paddingLeft += measuredWidth + this.mChildHorizontalSpacing;
                    iMax = Math.max(iMax, measuredHeight);
                    i2++;
                } else {
                    childAt.layout(0, 0, 0, 0);
                }
            }
        }
    }

    private void layoutWithGravityRight(int i) {
        int paddingTop = getPaddingTop();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.mItemNumberInEachLine;
            if (i2 >= iArr.length || iArr[i2] == 0) {
                break;
            }
            int paddingRight = (i - getPaddingRight()) - this.mWidthSumInEachLine[i2];
            int i5 = 0;
            int iMax = 0;
            while (i5 < this.mItemNumberInEachLine[i2]) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 8) {
                    i3++;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingRight, paddingTop, paddingRight + measuredWidth, paddingTop + measuredHeight);
                    iMax = Math.max(iMax, measuredHeight);
                    paddingRight += measuredWidth + this.mChildHorizontalSpacing;
                    i4++;
                    i5++;
                    i3++;
                    if (i4 == this.measuredChildCount) {
                        break;
                    }
                }
            }
            if (i4 == this.measuredChildCount) {
                break;
            }
            paddingTop += iMax + this.mChildVerticalSpacing;
            i2++;
        }
        int childCount = getChildCount();
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            if (childAt2.getVisibility() != 8) {
                childAt2.layout(0, 0, 0, 0);
            }
            i3++;
        }
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            this.mGravity = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setMaxNumber(int i) {
        this.mMaximum = i;
        this.mMaxMode = 1;
        requestLayout();
    }

    public int getMaxNumber() {
        if (this.mMaxMode == 1) {
            return this.mMaximum;
        }
        return -1;
    }

    public void setMaxLines(int i) {
        this.mMaximum = i;
        this.mMaxMode = 0;
        requestLayout();
    }

    public void setOnLineCountChangeListener(OnLineCountChangeListener onLineCountChangeListener) {
        this.mOnLineCountChangeListener = onLineCountChangeListener;
    }

    public int getLineCount() {
        return this.mLineCount;
    }

    public int getMaxLines() {
        if (this.mMaxMode == 0) {
            return this.mMaximum;
        }
        return -1;
    }

    public void setChildHorizontalSpacing(int i) {
        this.mChildHorizontalSpacing = i;
        invalidate();
    }

    public void setChildVerticalSpacing(int i) {
        this.mChildVerticalSpacing = i;
        invalidate();
    }
}

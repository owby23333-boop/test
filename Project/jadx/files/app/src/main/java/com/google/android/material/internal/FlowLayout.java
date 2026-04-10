package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f15451s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f15452t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f15453u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f15454v;

    public FlowLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FlowLayout, 0, 0);
        this.f15451s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_lineSpacing, 0);
        this.f15452t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_itemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    protected int getItemSpacing() {
        return this.f15452t;
    }

    protected int getLineSpacing() {
        return this.f15451s;
    }

    protected int getRowCount() {
        return this.f15454v;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int marginEnd;
        int marginStart;
        if (getChildCount() == 0) {
            this.f15454v = 0;
            return;
        }
        this.f15454v = 1;
        boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
        int paddingRight = z3 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z3 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i6 = (i4 - i2) - paddingLeft;
        int measuredWidth = paddingRight;
        int i7 = paddingTop;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R$id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginStart = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    marginEnd = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    marginEnd = 0;
                    marginStart = 0;
                }
                int measuredWidth2 = measuredWidth + marginStart + childAt.getMeasuredWidth();
                if (!this.f15453u && measuredWidth2 > i6) {
                    i7 = paddingTop + this.f15451s;
                    this.f15454v++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(R$id.row_index_key, Integer.valueOf(this.f15454v - 1));
                int i9 = measuredWidth + marginStart;
                int measuredWidth3 = childAt.getMeasuredWidth() + i9;
                int measuredHeight = childAt.getMeasuredHeight() + i7;
                if (z3) {
                    childAt.layout(i6 - measuredWidth3, i7, (i6 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(i9, i7, measuredWidth3, measuredHeight);
                }
                measuredWidth += marginStart + marginEnd + childAt.getMeasuredWidth() + this.f15452t;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i6 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i6 - getPaddingRight();
        int i7 = paddingLeft;
        int i8 = paddingTop;
        int i9 = i8;
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, i3);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i4 = marginLayoutParams.leftMargin + 0;
                    i5 = marginLayoutParams.rightMargin + 0;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                int i12 = i7;
                if (i7 + i4 + childAt.getMeasuredWidth() > paddingRight && !a()) {
                    int paddingLeft2 = getPaddingLeft();
                    i9 = this.f15451s + i8;
                    i12 = paddingLeft2;
                }
                int measuredWidth = i12 + i4 + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i9;
                if (measuredWidth > i10) {
                    i10 = measuredWidth;
                }
                int measuredWidth2 = i12 + i4 + i5 + childAt.getMeasuredWidth() + this.f15452t;
                if (i11 == getChildCount() - 1) {
                    i10 += i5;
                }
                i8 = measuredHeight;
                i7 = measuredWidth2;
            }
        }
        setMeasuredDimension(a(size, mode, i10 + getPaddingRight()), a(size2, mode2, i8 + getPaddingBottom()));
    }

    protected void setItemSpacing(int i2) {
        this.f15452t = i2;
    }

    protected void setLineSpacing(int i2) {
        this.f15451s = i2;
    }

    public void setSingleLine(boolean z2) {
        this.f15453u = z2;
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15453u = false;
        a(context, attributeSet);
    }

    public boolean a() {
        return this.f15453u;
    }

    @TargetApi(21)
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f15453u = false;
        a(context, attributeSet);
    }

    private static int a(int i2, int i3, int i4) {
        if (i3 != Integer.MIN_VALUE) {
            return i3 != 1073741824 ? i4 : i2;
        }
        return Math.min(i4, i2);
    }

    public int a(@NonNull View view) {
        Object tag = view.getTag(R$id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }
}

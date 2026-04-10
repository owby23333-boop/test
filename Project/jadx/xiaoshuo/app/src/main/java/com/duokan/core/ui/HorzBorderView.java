package com.duokan.core.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes12.dex */
public class HorzBorderView extends BorderView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f2889b;
    public Drawable c;
    public Rect d;

    public HorzBorderView(Context context) {
        this(context, null);
    }

    private int getLeftDrawableWidth() {
        Drawable drawable2 = this.f2889b;
        if (drawable2 != null) {
            return drawable2.getIntrinsicWidth();
        }
        return 0;
    }

    private int getRightDrawableWidth() {
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            return drawable2.getIntrinsicWidth();
        }
        return 0;
    }

    public Drawable getLeftDrawable() {
        return this.f2889b;
    }

    public Drawable getRightDrawable() {
        return this.c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable2 = this.f2889b;
        if (drawable2 != null) {
            this.d.set(0, 0, drawable2.getIntrinsicWidth(), getHeight());
            if (this.f2853a == ImageView.ScaleType.CENTER) {
                this.d.inset(0, ((getHeight() - this.f2889b.getIntrinsicHeight()) + 1) / 2);
            }
            canvas.save();
            canvas.clipRect(this.d);
            this.f2889b.setBounds(this.d);
            this.f2889b.draw(canvas);
            canvas.restore();
        }
        if (this.c != null) {
            this.d.set(getWidth() - this.c.getIntrinsicWidth(), 0, getWidth(), getHeight());
            if (this.f2853a == ImageView.ScaleType.CENTER) {
                this.d.inset(0, ((getHeight() - this.c.getIntrinsicHeight()) + 1) / 2);
            }
            canvas.save();
            canvas.clipRect(this.d);
            this.c.setBounds(this.d);
            this.c.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i + getLeftDrawableWidth(), i2, i3 - getRightDrawableWidth(), i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).offsetLeftAndRight(getLeftDrawableWidth());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 0) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((size - getLeftDrawableWidth()) - getRightDrawableWidth(), mode), i2);
        } else {
            super.onMeasure(i, i2);
        }
        setMeasuredDimension(getMeasuredWidth() + getLeftDrawableWidth() + getRightDrawableWidth(), getMeasuredHeight());
    }

    public void setLeftDrawable(Drawable drawable2) {
        this.f2889b = drawable2;
        requestLayout();
    }

    public void setRightDrawable(Drawable drawable2) {
        this.c = drawable2;
        requestLayout();
    }

    public HorzBorderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2889b = null;
        this.c = null;
        this.d = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.scaleType, R.attr.drawableLeft, R.attr.drawableRight});
        this.f2889b = typedArrayObtainStyledAttributes.hasValue(1) ? typedArrayObtainStyledAttributes.getDrawable(1) : this.f2889b;
        this.c = typedArrayObtainStyledAttributes.hasValue(2) ? typedArrayObtainStyledAttributes.getDrawable(2) : this.c;
        typedArrayObtainStyledAttributes.recycle();
    }
}

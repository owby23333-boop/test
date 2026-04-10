package com.duokan.reader.ui.general;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.duokan.core.ui.BorderView;

/* JADX INFO: loaded from: classes5.dex */
public class VertBorderView extends BorderView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f5583b;
    public Drawable c;
    public Rect d;

    public VertBorderView(Context context) {
        this(context, null);
    }

    private int getBottomDrawableHeight() {
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            return drawable2.getIntrinsicHeight();
        }
        return 0;
    }

    private int getTopDrawableHeight() {
        Drawable drawable2 = this.f5583b;
        if (drawable2 != null) {
            return drawable2.getIntrinsicHeight();
        }
        return 0;
    }

    public Drawable getBottomDrawable() {
        return this.c;
    }

    public Drawable getTopDrawable() {
        return this.f5583b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f5583b != null) {
            this.d.set(0, 0, getWidth(), this.f5583b.getIntrinsicHeight());
            if (this.f2853a == ImageView.ScaleType.CENTER) {
                this.d.inset(((getWidth() - this.f5583b.getIntrinsicWidth()) + 1) / 2, 0);
            }
            canvas.save();
            canvas.clipRect(this.d);
            this.f5583b.setBounds(this.d);
            this.f5583b.draw(canvas);
            canvas.restore();
        }
        if (this.c != null) {
            this.d.set(0, getHeight() - this.c.getIntrinsicHeight(), getWidth(), getHeight());
            if (this.f2853a == ImageView.ScaleType.CENTER) {
                this.d.inset(((getWidth() - this.f5583b.getIntrinsicWidth()) + 1) / 2, 0);
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
        super.onLayout(z, i, i2 + getTopDrawableHeight(), i3, i4 - getBottomDrawableHeight());
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).offsetTopAndBottom(getTopDrawableHeight());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((size - getTopDrawableHeight()) - getBottomDrawableHeight(), mode));
        } else {
            super.onMeasure(i, i2);
        }
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + getTopDrawableHeight() + getBottomDrawableHeight());
    }

    public void setBottomDrawable(Drawable drawable2) {
        this.c = drawable2;
        requestLayout();
    }

    public void setTopDrawable(Drawable drawable2) {
        this.f5583b = drawable2;
        requestLayout();
    }

    public VertBorderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5583b = null;
        this.c = null;
        this.d = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.scaleType, R.attr.drawableLeft, R.attr.drawableRight});
        this.f5583b = typedArrayObtainStyledAttributes.hasValue(1) ? typedArrayObtainStyledAttributes.getDrawable(1) : this.f5583b;
        this.c = typedArrayObtainStyledAttributes.hasValue(2) ? typedArrayObtainStyledAttributes.getDrawable(2) : this.c;
        typedArrayObtainStyledAttributes.recycle();
    }
}

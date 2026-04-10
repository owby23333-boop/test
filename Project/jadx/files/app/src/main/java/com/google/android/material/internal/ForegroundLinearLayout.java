package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private Drawable f15455s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Rect f15456t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Rect f15457u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f15458v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected boolean f15459w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f15460x;

    public ForegroundLinearLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f15455s;
        if (drawable != null) {
            if (this.f15460x) {
                this.f15460x = false;
                Rect rect = this.f15456t;
                Rect rect2 = this.f15457u;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f15459w) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f15458v, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    @TargetApi(21)
    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.f15455s;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f15455s;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f15455s.setState(getDrawableState());
    }

    @Override // android.view.View
    @Nullable
    public Drawable getForeground() {
        return this.f15455s;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f15458v;
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f15455s;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f15460x = z2 | this.f15460x;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f15460x = true;
    }

    @Override // android.view.View
    public void setForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f15455s;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f15455s);
            }
            this.f15455s = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f15458v == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i2) {
        if (this.f15458v != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= GravityCompat.START;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f15458v = i2;
            if (this.f15458v == 119 && this.f15455s != null) {
                this.f15455s.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f15455s;
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15456t = new Rect();
        this.f15457u = new Rect();
        this.f15458v = 119;
        this.f15459w = true;
        this.f15460x = false;
        TypedArray typedArrayC = l.c(context, attributeSet, R$styleable.ForegroundLinearLayout, i2, 0, new int[0]);
        this.f15458v = typedArrayC.getInt(R$styleable.ForegroundLinearLayout_android_foregroundGravity, this.f15458v);
        Drawable drawable = typedArrayC.getDrawable(R$styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f15459w = typedArrayC.getBoolean(R$styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayC.recycle();
    }
}

package com.google.android.material.snackbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.s;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class d extends FrameLayout {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final View.OnTouchListener f15821z = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private c f15822s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private b f15823t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f15824u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final float f15825v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final float f15826w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ColorStateList f15827x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private PorterDuff.Mode f15828y;

    /* JADX INFO: compiled from: BaseTransientBottomBar.java */
    static class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    protected d(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private Drawable a() {
        float dimension = getResources().getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(com.google.android.material.c.a.a(this, R$attr.colorSurface, R$attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
        if (this.f15827x == null) {
            return DrawableCompat.wrap(gradientDrawable);
        }
        Drawable drawableWrap = DrawableCompat.wrap(gradientDrawable);
        DrawableCompat.setTintList(drawableWrap, this.f15827x);
        return drawableWrap;
    }

    float getActionTextColorAlpha() {
        return this.f15826w;
    }

    int getAnimationMode() {
        return this.f15824u;
    }

    float getBackgroundOverlayColorAlpha() {
        return this.f15825v;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f15823t;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f15823t;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        c cVar = this.f15822s;
        if (cVar != null) {
            cVar.a(this, i2, i3, i4, i5);
        }
    }

    void setAnimationMode(int i2) {
        this.f15824u = i2;
    }

    @Override // android.view.View
    public void setBackground(@Nullable Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        if (drawable != null && this.f15827x != null) {
            drawable = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTintList(drawable, this.f15827x);
            DrawableCompat.setTintMode(drawable, this.f15828y);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.f15827x = colorStateList;
        if (getBackground() != null) {
            Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintList(drawableWrap, colorStateList);
            DrawableCompat.setTintMode(drawableWrap, this.f15828y);
            if (drawableWrap != getBackground()) {
                super.setBackgroundDrawable(drawableWrap);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        this.f15828y = mode;
        if (getBackground() != null) {
            Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintMode(drawableWrap, mode);
            if (drawableWrap != getBackground()) {
                super.setBackgroundDrawable(drawableWrap);
            }
        }
    }

    void setOnAttachStateChangeListener(b bVar) {
        this.f15823t = bVar;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f15821z);
        super.setOnClickListener(onClickListener);
    }

    void setOnLayoutChangeListener(c cVar) {
        this.f15822s = cVar;
    }

    protected d(@NonNull Context context, AttributeSet attributeSet) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
            ViewCompat.setElevation(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
        }
        this.f15824u = typedArrayObtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
        this.f15825v = typedArrayObtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        setBackgroundTintList(com.google.android.material.i.c.a(context2, typedArrayObtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
        setBackgroundTintMode(s.a(typedArrayObtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
        this.f15826w = typedArrayObtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(f15821z);
        setFocusable(true);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, a());
        }
    }
}

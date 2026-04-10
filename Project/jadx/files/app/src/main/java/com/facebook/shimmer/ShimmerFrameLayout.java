package com.facebook.shimmer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.shimmer.Shimmer;

/* JADX INFO: loaded from: classes2.dex */
public class ShimmerFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Paint f14826s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final a f14827t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f14828u;

    public ShimmerFrameLayout(Context context) {
        super(context);
        this.f14826s = new Paint();
        this.f14827t = new a();
        this.f14828u = true;
        a(context, null);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet) {
        setWillNotDraw(false);
        this.f14827t.setCallback(this);
        if (attributeSet == null) {
            a(new Shimmer.a().a());
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShimmerFrameLayout, 0, 0);
        try {
            a(((typedArrayObtainStyledAttributes.hasValue(R$styleable.ShimmerFrameLayout_shimmer_colored) && typedArrayObtainStyledAttributes.getBoolean(R$styleable.ShimmerFrameLayout_shimmer_colored, false)) ? new Shimmer.c() : new Shimmer.a()).a(typedArrayObtainStyledAttributes).a());
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f14828u) {
            this.f14827t.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f14827t.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f14827t.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f14827t;
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14826s = new Paint();
        this.f14827t = new a();
        this.f14828u = true;
        a(context, attributeSet);
    }

    public ShimmerFrameLayout a(@Nullable Shimmer shimmer) {
        this.f14827t.a(shimmer);
        if (shimmer != null && shimmer.f14819n) {
            setLayerType(2, this.f14826s);
        } else {
            setLayerType(0, null);
        }
        return this;
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14826s = new Paint();
        this.f14827t = new a();
        this.f14828u = true;
        a(context, attributeSet);
    }

    public void a() {
        this.f14827t.c();
    }

    @TargetApi(21)
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f14826s = new Paint();
        this.f14827t = new a();
        this.f14828u = true;
        a(context, attributeSet);
    }
}

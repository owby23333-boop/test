package com.amgcyo.cuttadon.view.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.R$styleable;
import com.amgcyo.cuttadon.view.shimmer.Shimmer;

/* JADX INFO: loaded from: classes.dex */
public class ShimmerFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Paint f5427s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final b f5428t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f5429u;

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5427s = new Paint();
        this.f5428t = new b();
        this.f5429u = true;
        a(context, attributeSet);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet) {
        setWillNotDraw(false);
        this.f5428t.setCallback(this);
        if (attributeSet == null) {
            a(new Shimmer.a().a());
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShimmerFrameLayout, 0, 0);
        try {
            a(((typedArrayObtainStyledAttributes.hasValue(4) && typedArrayObtainStyledAttributes.getBoolean(4, false)) ? new Shimmer.c() : new Shimmer.a()).a(typedArrayObtainStyledAttributes).a());
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f5429u) {
            this.f5428t.draw(canvas);
        }
    }

    @Nullable
    public Shimmer getShimmer() {
        return this.f5428t.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5428t.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f5428t.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 0) {
            this.f5428t.c();
        } else {
            a();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5428t;
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5427s = new Paint();
        this.f5428t = new b();
        this.f5429u = true;
        a(context, attributeSet);
    }

    public ShimmerFrameLayout a(@Nullable Shimmer shimmer) {
        this.f5428t.a(shimmer);
        if (shimmer != null && shimmer.f5419n) {
            setLayerType(2, this.f5427s);
        } else {
            setLayerType(0, null);
        }
        return this;
    }

    public void a() {
        this.f5428t.d();
    }
}

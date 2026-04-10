package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationButton extends TextView implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f545a;
    private float dl;
    private float g;
    private float gc;
    z z;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.g
    public float getShineValue() {
        return this.dl;
    }

    public void setShineValue(float f) {
        this.dl = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.g
    public float getRippleValue() {
        return this.g;
    }

    public void setRippleValue(float f) {
        this.g = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.g
    public float getMarqueeValue() {
        return this.f545a;
    }

    public void setMarqueeValue(float f) {
        this.f545a = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.gc;
    }

    public void setStretchValue(float f) {
        this.gc = f;
        this.z.z(this, f);
    }

    public AnimationButton(Context context) {
        super(context);
        this.z = new z();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.z.z(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.z.z(this, i, i2);
    }
}

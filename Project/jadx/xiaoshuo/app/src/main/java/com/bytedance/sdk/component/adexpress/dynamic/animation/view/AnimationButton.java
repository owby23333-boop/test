package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class AnimationButton extends TextView implements bf {
    private float bf;
    private float d;
    e e;
    private float ga;
    private float tg;

    public AnimationButton(Context context) {
        super(context);
        this.e = new e();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.bf
    public float getMarqueeValue() {
        return this.tg;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.bf
    public float getRippleValue() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.bf
    public float getShineValue() {
        return this.d;
    }

    public float getStretchValue() {
        return this.ga;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.e.e(canvas, this, this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e.e(this, i, i2);
    }

    public void setMarqueeValue(float f) {
        this.tg = f;
        postInvalidate();
    }

    public void setRippleValue(float f) {
        this.bf = f;
        postInvalidate();
    }

    public void setShineValue(float f) {
        this.d = f;
        postInvalidate();
    }

    public void setStretchValue(float f) {
        this.ga = f;
        this.e.e(this, f);
    }
}

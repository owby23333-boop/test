package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.d.p;

/* JADX INFO: loaded from: classes.dex */
public class AnimationImageView extends ImageView implements bf {
    private float bf;
    private float d;
    e e;
    private float ga;
    private float tg;
    private p vn;

    public AnimationImageView(Context context) {
        super(context);
        this.e = new e();
    }

    public p getBrickNativeValue() {
        return this.vn;
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

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        p pVar;
        super.onDraw(canvas);
        this.e.e(canvas, this, this);
        if (getRippleValue() == 0.0f || (pVar = this.vn) == null || pVar.bf() <= 0) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
        ((ViewGroup) getParent().getParent()).setClipChildren(false);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e.e(this, i, i2);
    }

    public void setBrickNativeValue(p pVar) {
        this.vn = pVar;
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

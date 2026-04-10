package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.e;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationImageView extends ImageView implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f546a;
    private float dl;
    private float g;
    private float gc;
    private e m;
    z z;

    public e getBrickNativeValue() {
        return this.m;
    }

    public void setBrickNativeValue(e eVar) {
        this.m = eVar;
    }

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
        return this.f546a;
    }

    public void setMarqueeValue(float f) {
        this.f546a = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.gc;
    }

    public void setStretchValue(float f) {
        this.gc = f;
        this.z.z(this, f);
    }

    public AnimationImageView(Context context) {
        super(context);
        this.z = new z();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        e eVar;
        super.onDraw(canvas);
        this.z.z(canvas, this, this);
        if (getRippleValue() == 0.0f || (eVar = this.m) == null || eVar.g() <= 0) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
        ((ViewGroup) getParent().getParent()).setClipChildren(false);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.z.z(this, i, i2);
    }
}

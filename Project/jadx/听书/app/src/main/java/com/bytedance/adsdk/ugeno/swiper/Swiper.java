package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.g.dl;

/* JADX INFO: loaded from: classes2.dex */
public class Swiper extends BaseSwiper<dl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.dl f246a;

    public Swiper(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View e(int i) {
        return ((dl) this.z.get(i)).fo();
    }

    public void z(com.bytedance.adsdk.ugeno.dl dlVar) {
        this.f246a = dlVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.dl dlVar = this.f246a;
        if (dlVar != null) {
            int[] iArrZ = dlVar.z(i, i2);
            super.onMeasure(iArrZ[0], iArrZ[1]);
        } else {
            super.onMeasure(i, i2);
        }
        com.bytedance.adsdk.ugeno.dl dlVar2 = this.f246a;
        if (dlVar2 != null) {
            dlVar2.dl();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.dl dlVar = this.f246a;
        if (dlVar != null) {
            dlVar.a();
        }
        super.onLayout(z, i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.dl dlVar2 = this.f246a;
        if (dlVar2 != null) {
            dlVar2.z(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.dl dlVar = this.f246a;
        if (dlVar != null) {
            dlVar.gc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.dl dlVar = this.f246a;
        if (dlVar != null) {
            dlVar.m();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.dl dlVar = this.f246a;
        if (dlVar != null) {
            dlVar.g(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.adsdk.ugeno.dl dlVar = this.f246a;
        if (dlVar != null) {
            dlVar.z(z);
        }
    }
}

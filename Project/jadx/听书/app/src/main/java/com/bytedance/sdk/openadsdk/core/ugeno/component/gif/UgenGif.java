package com.bytedance.sdk.openadsdk.core.ugeno.component.gif;

import android.content.Context;
import com.bytedance.adsdk.ugeno.dl;
import com.bytedance.sdk.component.adexpress.widget.GifView;

/* JADX INFO: loaded from: classes2.dex */
public class UgenGif extends GifView {
    private dl z;

    public UgenGif(Context context) {
        super(context);
    }

    public void z(dl dlVar) {
        this.z = dlVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.GifView, android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.dl();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.GifView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(i, i2, i3, i4);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.gc();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.m();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(z);
        }
    }
}

package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.ugeno.dl;

/* JADX INFO: loaded from: classes2.dex */
public class UgenLottieView extends LottieAnimationView {
    private dl z;

    public UgenLottieView(Context context) {
        super(context);
    }

    public void z(dl dlVar) {
        this.z = dlVar;
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.gc();
        }
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.m();
        }
    }
}

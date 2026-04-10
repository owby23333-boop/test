package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.gz.dl;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.gz.g;

/* JADX INFO: loaded from: classes2.dex */
public class SaasAuthEnvelope extends RelativeLayout {
    private ImageView dl;
    private ImageView g;
    private AnimationSet z;

    public SaasAuthEnvelope(Context context) {
        super(context);
        z(context);
        setVisibility(8);
    }

    private void z(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setId(2114387464);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        addView(linearLayout);
        this.dl = new ImageView(context);
        try {
            g.z(dl.z("saas_red_envelope.webp")).to(this.dl);
        } catch (Error unused) {
        }
        linearLayout.addView(this.dl, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        this.g = imageView;
        try {
            imageView.setImageResource(tb.gc(context, "tt_saas_close"));
        } catch (Error unused2) {
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = oq.dl(context, 25.0f);
        linearLayout.addView(this.g, layoutParams2);
    }

    public void z() {
        setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(800L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(800L);
        AnimationSet animationSet = new AnimationSet(true);
        this.z = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.z.addAnimation(scaleAnimation);
        startAnimation(this.z);
    }

    public void g() {
        AnimationSet animationSet = this.z;
        if (animationSet != null) {
            animationSet.cancel();
            this.z = null;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}

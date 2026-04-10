package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class KsSlideArrowView extends c {
    private ImageView Ku;
    private int Kv;
    private int Kw;

    public KsSlideArrowView(Context context) {
        super(context);
        this.Kw = 0;
    }

    public KsSlideArrowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Kw = 0;
    }

    public KsSlideArrowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Kw = 0;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.Kv = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_splash_slide_tag);
        typedArrayObtainStyledAttributes.recycle();
        this.Ku = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.Ku.setScaleType(ImageView.ScaleType.FIT_XY);
        this.Ku.setAlpha(0.0f);
        addView(this.Ku, layoutParams);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nu() {
        ImageView imageView = this.Ku;
        if (imageView != null) {
            imageView.setImageResource(this.Kv);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final Animator fN() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ObjectAnimator.ofFloat(interactionView, "alpha", 0.0f, 1.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 0.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 0.0f, 0.0f).setDuration(200L));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nv() {
        getInteractionView().setAlpha(1.0f);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected View getInteractionView() {
        return this.Ku;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected int getAnimationDelayTime() {
        return this.Kw;
    }

    public void setAnimationDelayTime(int i) {
        this.Kw = i;
    }
}

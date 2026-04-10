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
public class KsSlideRoundView extends c {
    private ImageView KH;
    private int Kv;

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected int getAnimationDelayTime() {
        return 200;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected View getInteractionView() {
        return this;
    }

    public KsSlideRoundView(Context context) {
        super(context);
    }

    public KsSlideRoundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsSlideRoundView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.Kv = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_splash_slide_round_bg);
        typedArrayObtainStyledAttributes.recycle();
        this.KH = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.KH.setScaleType(ImageView.ScaleType.FIT_END);
        addView(this.KH, layoutParams);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nu() {
        ImageView imageView = this.KH;
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
        interactionView.setPivotY(interactionView.getHeight());
        animatorSet.playSequentially(ObjectAnimator.ofFloat(interactionView, "scaleY", 1.0f, 1.1f).setDuration(400L), ObjectAnimator.ofFloat(interactionView, "scaleY", 1.1f, 1.0f).setDuration(400L));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nv() {
        getInteractionView().setScaleY(1.0f);
    }
}

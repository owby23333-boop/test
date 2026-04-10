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
import androidx.constraintlayout.motion.widget.Key;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class KsRotateView extends c {
    private static int Ke = 50;
    private static int Kf = -12;
    private static int Kg = -25;
    private static int Kh = 12;
    private static int Ki = 25;
    private int Kd;
    private ImageView ig;
    private ImageView qg;

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected int getAnimationDelayTime() {
        return 500;
    }

    public KsRotateView(Context context) {
        super(context);
    }

    public KsRotateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsRotateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.Kd = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_rotate_phone);
        typedArrayObtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(getContext());
        this.qg = imageView;
        imageView.setImageResource(R.drawable.ksad_ic_rotate_line);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        addView(this.qg, layoutParams);
        this.ig = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.kwad.sdk.c.a.a.a(context, 22.0f);
        layoutParams2.gravity = 1;
        addView(this.ig, layoutParams2);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nu() {
        this.ig.setImageResource(this.Kd);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final Animator fN() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, Kg).setDuration(500L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(340L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, Kg, 0.0f).setDuration(Ke);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, Kh).setDuration(Ke);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, Kh, 0.0f).setDuration(Ke);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, Kf).setDuration(Ke);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, Kf, 0.0f).setDuration(Ke);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(500L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, Ki).setDuration(500L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(340L);
        animatorSet.playSequentially(duration, objectAnimatorOfFloat, duration2, duration3, duration4, duration5, duration6, objectAnimatorOfFloat2, duration7, objectAnimatorOfFloat3, ObjectAnimator.ofFloat(interactionView, Key.ROTATION, Ki, 0.0f).setDuration(Ke), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, Kf).setDuration(Ke), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, Kf, 0.0f).setDuration(Ke), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, Kh).setDuration(Ke), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, Kh, 0.0f).setDuration(Ke));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nv() {
        getInteractionView().setRotation(0.0f);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected View getInteractionView() {
        return this.ig;
    }
}

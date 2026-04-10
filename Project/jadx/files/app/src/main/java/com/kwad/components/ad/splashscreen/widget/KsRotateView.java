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
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class KsRotateView extends b {
    private static int Fa = 50;
    private static int Fb = -12;
    private static int Fc = -25;
    private static int Fd = 12;
    private static int Fe = 25;
    private ImageView EZ;

    @DrawableRes
    private int Ff;
    private ImageView fo;

    public KsRotateView(@NonNull Context context) {
        super(context);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected int getAnimationDelayTime() {
        return 500;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected View getInteractionView() {
        return this.fo;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected final void init(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i2, 0);
        this.Ff = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_rotate_phone);
        typedArrayObtainStyledAttributes.recycle();
        this.EZ = new ImageView(getContext());
        this.EZ.setImageResource(R.drawable.ksad_ic_rotate_line);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        addView(this.EZ, layoutParams);
        this.fo = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.kwad.sdk.b.kwai.a.a(context, 22.0f);
        layoutParams2.gravity = 1;
        addView(this.fo, layoutParams2);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected final Animator lO() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Fc).setDuration(500L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(340L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, "rotation", Fc, 0.0f).setDuration(Fa);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Fd).setDuration(Fa);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, "rotation", Fd, 0.0f).setDuration(Fa);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Fb).setDuration(Fa);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, "rotation", Fb, 0.0f).setDuration(Fa);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(500L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Fe).setDuration(500L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(340L);
        animatorSet.playSequentially(duration, objectAnimatorOfFloat, duration2, duration3, duration4, duration5, duration6, objectAnimatorOfFloat2, duration7, objectAnimatorOfFloat3, ObjectAnimator.ofFloat(interactionView, "rotation", Fe, 0.0f).setDuration(Fa), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Fb).setDuration(Fa), ObjectAnimator.ofFloat(interactionView, "rotation", Fb, 0.0f).setDuration(Fa), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Fd).setDuration(Fa), ObjectAnimator.ofFloat(interactionView, "rotation", Fd, 0.0f).setDuration(Fa));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected final void lP() {
        getInteractionView().setRotation(0.0f);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected final void lw() {
        this.fo.setImageResource(this.Ff);
    }
}

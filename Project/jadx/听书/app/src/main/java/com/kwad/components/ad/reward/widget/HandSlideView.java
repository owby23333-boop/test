package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public class HandSlideView extends KSFrameLayout {
    private View Dp;
    private AnimatorSet Dq;
    private float Dr;
    private float Ds;
    private float Dt;
    private long Du;
    private long Dv;
    private int Dw;
    private int Dx;
    private ImageView hY;
    private boolean started;

    public interface a {
        void onHandSlideLoopEnd();
    }

    static /* synthetic */ int b(HandSlideView handSlideView) {
        int i = handSlideView.Dx;
        handSlideView.Dx = i + 1;
        return i;
    }

    public HandSlideView(Context context) {
        super(context);
        this.Du = 600L;
        this.Dv = 500L;
        this.Dw = 3;
        this.Dx = 0;
        this.started = false;
    }

    public HandSlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Du = 600L;
        this.Dv = 500L;
        this.Dw = 3;
        this.Dx = 0;
        this.started = false;
    }

    public HandSlideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Du = 600L;
        this.Dv = 500L;
        this.Dw = 3;
        this.Dx = 0;
        this.started = false;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(Context context, AttributeSet attributeSet) {
        super.init(context, attributeSet);
        inflate(getContext(), R.layout.ksad_hand_slide, this);
        this.hY = (ImageView) findViewById(R.id.ksad_hand_slide_hand);
        this.Dp = findViewById(R.id.ksad_hand_slide_tail);
        this.Dr = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_up);
        this.Ds = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_tail_height_start);
        this.Dt = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_tail_height_end);
    }

    public final void a(final a aVar) {
        this.started = true;
        AnimatorSet animatorSetB = b(this.hY, this.Dp);
        this.Dq = animatorSetB;
        animatorSetB.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (HandSlideView.this.Dq == null) {
                    return;
                }
                HandSlideView.b(HandSlideView.this);
                if (HandSlideView.this.Dx < HandSlideView.this.Dw) {
                    HandSlideView.this.Dq.start();
                    return;
                }
                HandSlideView.this.Dq.removeListener(this);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onHandSlideLoopEnd();
                }
            }
        });
        this.Dq.start();
    }

    public final void destroy() {
        this.started = false;
        AnimatorSet animatorSet = this.Dq;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.Dq.cancel();
            this.Dq = null;
        }
    }

    public final boolean isStarted() {
        return this.started;
    }

    private AnimatorSet b(View view, View view2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -this.Dr);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, Key.ROTATION, 30.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setDuration(10L);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.Ds, this.Dt);
        valueAnimatorOfFloat.addUpdateListener(u(view2));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.Du);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, valueAnimatorOfFloat, objectAnimatorOfFloat4);
        animatorSet.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 0.0f));
        animatorSet2.setDuration(this.Dv);
        animatorSet2.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        return animatorSet3;
    }

    private static ValueAnimator.AnimatorUpdateListener u(final View view) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) fFloatValue;
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }
}

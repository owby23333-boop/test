package com.kwad.components.ad.feed.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends FrameLayout {
    private int count;
    private ImageView fe;
    private ImageView ff;
    private ImageView fg;
    private Animator fh;
    private Animator fi;
    private Animation fj;
    private Animation fk;

    public d(@NonNull Context context) {
        this(context, null);
    }

    private d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private d(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, 0);
        this.count = 0;
        D(context);
    }

    private void D(Context context) {
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_promote_ad_click, this);
        this.fe = (ImageView) findViewById(R.id.ksad_inside_circle);
        this.ff = (ImageView) findViewById(R.id.ksad_outside_circle);
        this.fg = (ImageView) findViewById(R.id.ksad_hand);
    }

    private Animation a(final View view, float f2, int i2) {
        float fA = com.kwad.sdk.b.kwai.a.a(getContext(), 10.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, 0.0f);
        float f3 = i2 / fA;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f3, 1.0f, f3, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ad.feed.a.d.3
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        return animationSet;
    }

    private void bw() {
        this.fh = d(this.fg);
        this.fi = e(this.fg);
        this.fj = a(this.fe, 0.45f, com.kwad.sdk.b.kwai.a.a(getContext(), 34.0f));
        this.fk = a(this.ff, 0.5f, com.kwad.sdk.b.kwai.a.a(getContext(), 50.0f));
        this.fh.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.d.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.this.fe.startAnimation(d.this.fj);
                d.this.ff.startAnimation(d.this.fk);
                d.this.fi.start();
            }
        });
        this.fi.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.d.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.f(d.this);
                if (d.this.count >= 5) {
                    return;
                }
                d.this.fh.start();
            }
        });
    }

    private Animator d(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, -10.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f));
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        return animatorSet;
    }

    private Animator e(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "rotation", -10.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "translationY", -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        return animatorSet;
    }

    static /* synthetic */ int f(d dVar) {
        int i2 = dVar.count;
        dVar.count = i2 + 1;
        return i2;
    }

    public final void bu() {
        bw();
        this.fh.start();
    }

    public final void bv() {
        Animator animator = this.fh;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.fi;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animation animation = this.fj;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.fk;
        if (animation2 != null) {
            animation2.cancel();
        }
    }
}

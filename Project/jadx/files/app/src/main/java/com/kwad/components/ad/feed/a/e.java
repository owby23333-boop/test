package com.kwad.components.ad.feed.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.r.o;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends FrameLayout {
    private View fn;
    private ImageView fo;

    @Nullable
    private Animator fp;
    private com.kwad.sdk.widget.c fq;

    public e(@NonNull Context context) {
        this(context, null);
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, 0);
        init(context);
    }

    private Animator a(View view, long j2, float f2) {
        if (view == null) {
            return null;
        }
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        this.fo.setPivotX(view.getWidth());
        this.fo.setPivotY(view.getHeight());
        Animator animatorA = o.a(view, interpolatorCreate, 100L, 16.0f);
        Animator animatorA2 = o.a(view, interpolatorCreate, 100L, 16.0f);
        Animator animatorA3 = o.a(view, interpolatorCreate, 100L, 16.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animatorA, animatorA2, animatorA3);
        return animatorSet;
    }

    private Animator b(final View view, int i2) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float fMin = i2 / Math.min(view.getHeight(), view.getWidth());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", fMin, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fMin, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
                view.setClickable(true);
                new com.kwad.sdk.widget.f(view, e.this.fq);
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator bx() {
        View view = this.fn;
        if (view == null || this.fo == null || view.getWidth() + this.fn.getHeight() == 0 || this.fo.getWidth() + this.fo.getHeight() == 0) {
            return null;
        }
        Animator animatorBy = by();
        Animator animatorA = a(this.fo, 100L, 16.0f);
        Animator animatorBz = bz();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animatorBy, animatorA, animatorBz);
        return animatorSet;
    }

    private Animator by() {
        Animator animatorB = b(this.fn, com.kwad.sdk.b.kwai.a.a(getContext(), 128.0f));
        Animator animatorB2 = b(this.fo, com.kwad.sdk.b.kwai.a.a(getContext(), 71.11f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(animatorB, animatorB2);
        return animatorSet;
    }

    private Animator bz() {
        Animator animatorF = f(this.fn);
        Animator animatorF2 = f(this.fo);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(animatorF, animatorF2);
        return animatorSet;
    }

    private Animator f(final View view) {
        if (view == null) {
            return null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.e.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        return animatorSet;
    }

    private void init(Context context) {
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_feed_shake, this);
        setClickable(false);
        this.fn = findViewById(R.id.ksad_feed_shake_bg);
        this.fo = (ImageView) findViewById(R.id.ksad_feed_shake_icon);
    }

    @MainThread
    public final void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = this.fp;
        if (animator != null) {
            animator.cancel();
            this.fp = null;
        }
        this.fo.post(new Runnable() { // from class: com.kwad.components.ad.feed.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                e eVar = e.this;
                eVar.fp = eVar.bx();
                if (e.this.fp == null) {
                    animatorListenerAdapter.onAnimationEnd(null);
                } else {
                    e.this.fp.addListener(animatorListenerAdapter);
                    e.this.fp.start();
                }
            }
        });
    }

    public final void setOnViewEventListener(com.kwad.sdk.widget.c cVar) {
        this.fq = cVar;
    }
}

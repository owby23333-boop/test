package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends KSFrameLayout {
    private Animator qc;
    private boolean qd;

    protected void a(Context context, AttributeSet attributeSet, int i) {
    }

    protected abstract Animator fN();

    protected abstract int getAnimationDelayTime();

    protected abstract View getInteractionView();

    protected abstract void nu();

    protected abstract void nv();

    public c(Context context) {
        this(context, null, 0);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qd = false;
        a(context, attributeSet, i);
        nu();
    }

    public final void fM() {
        Animator animator = this.qc;
        if (animator != null) {
            animator.cancel();
            this.qc = null;
        }
        Animator animatorFN = fN();
        this.qc = animatorFN;
        if (animatorFN != null) {
            animatorFN.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (c.this.qd) {
                        return;
                    }
                    c.this.getInteractionView().postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.widget.c.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            if (c.this.qc != null) {
                                c.this.qc.start();
                            }
                        }
                    }, c.this.getAnimationDelayTime());
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    c.this.nv();
                }
            });
            this.qc.start();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        Animator animator = this.qc;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void nw() {
        this.qd = true;
        Animator animator = this.qc;
        if (animator != null) {
            animator.cancel();
        }
    }
}

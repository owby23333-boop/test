package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends KSFrameLayout {
    private Animator EV;
    private boolean EW;

    public b(@NonNull Context context) {
        this(context, null, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.EW = false;
        init(context, attributeSet, i2);
        lw();
    }

    protected abstract int getAnimationDelayTime();

    protected abstract View getInteractionView();

    protected void init(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
    }

    protected abstract Animator lO();

    protected abstract void lP();

    public final void lQ() {
        this.EW = true;
        Animator animator = this.EV;
        if (animator != null) {
            animator.cancel();
        }
    }

    @MainThread
    public final void lq() {
        Animator animator = this.EV;
        if (animator != null) {
            animator.cancel();
            this.EV = null;
        }
        this.EV = lO();
        Animator animator2 = this.EV;
        if (animator2 != null) {
            animator2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator3) {
                    super.onAnimationCancel(animator3);
                    b.this.lP();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator3) {
                    super.onAnimationEnd(animator3);
                    if (b.this.EW) {
                        return;
                    }
                    b.this.getInteractionView().postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.EV.start();
                        }
                    }, b.this.getAnimationDelayTime());
                }
            });
            this.EV.start();
        }
    }

    protected abstract void lw();

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        Animator animator = this.EV;
        if (animator != null) {
            animator.cancel();
        }
    }
}

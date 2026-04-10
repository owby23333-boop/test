package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicBaseScrollWidgetImp extends DynamicBaseWidgetImp implements gc {
    ObjectAnimator g;
    private Runnable q;
    private int tb;
    ObjectAnimator z;

    /* JADX INFO: Access modifiers changed from: private */
    public void fo() {
        final View childAt = getChildAt(this.tb);
        final View childAt2 = getChildAt((this.tb + 1) % getChildCount());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(this.gz + getChildAt(this.tb).getHeight())) / 2);
        this.z = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.z.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", (this.gz + childAt2.getHeight()) / 2, 0.0f);
        this.g = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        this.g.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt2.setVisibility(0);
            }
        });
        this.z.setDuration(500L);
        this.g.setDuration(500L);
        this.z.start();
        this.g.start();
        int i = this.tb + 1;
        this.tb = i;
        this.tb = i % getChildCount();
        postDelayed(this.q, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public DynamicBaseScrollWidgetImp(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.tb = 0;
        this.q = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseScrollWidgetImp.this.fo();
            }
        };
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.gz - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.q, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gc
    public void g() {
        removeCallbacks(this.q);
        ObjectAnimator objectAnimator = this.z;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.z.cancel();
        }
        ObjectAnimator objectAnimator2 = this.g;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.g.cancel();
        }
        super.g();
    }
}

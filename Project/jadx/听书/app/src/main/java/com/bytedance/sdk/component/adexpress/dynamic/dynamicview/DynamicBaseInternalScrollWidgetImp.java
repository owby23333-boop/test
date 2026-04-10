package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicBaseInternalScrollWidgetImp extends DynamicBaseWidgetImp implements gc {
    ObjectAnimator g;
    private Runnable iq;
    private boolean q;
    private int tb;
    ObjectAnimator z;

    public DynamicBaseInternalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.tb = 0;
        this.q = false;
        this.iq = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseInternalScrollWidgetImp.this.fo();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo() {
        final View childAt;
        final View childAt2 = getChildAt(this.tb);
        int i = this.tb;
        if (i == 0) {
            this.q = false;
        }
        if (i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.tb + 1)).getChildCount() <= 0) {
            this.q = true;
            childAt = getChildAt(this.tb - 1);
            this.z = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (this.e + getChildAt(this.tb).getWidth()) / 2);
        } else {
            childAt = getChildAt(this.tb + 1);
            this.z = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(this.e + getChildAt(this.tb).getWidth())) / 2);
        }
        this.z.setInterpolator(new LinearInterpolator());
        this.z.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.2
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
                childAt2.setVisibility(8);
            }
        });
        if (this.q) {
            this.g = ObjectAnimator.ofFloat(childAt, "translationX", (-(this.e + childAt.getWidth())) / 2, 0.0f);
        } else {
            this.g = ObjectAnimator.ofFloat(childAt, "translationX", (this.e + childAt.getWidth()) / 2, 0.0f);
        }
        this.g.setInterpolator(new LinearInterpolator());
        this.g.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.3
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
                childAt.setVisibility(0);
            }
        });
        this.z.setDuration(500L);
        this.g.setDuration(500L);
        this.z.start();
        this.g.start();
        if (this.q) {
            this.tb--;
        } else {
            this.tb++;
        }
        postDelayed(this.iq, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
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
        postDelayed(this.iq, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gc
    public void g() {
        removeCallbacks(this.iq);
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

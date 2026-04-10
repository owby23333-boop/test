package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.media3.common.C;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicVerticalScrollWidgetImp extends DynamicBaseWidgetImp implements gc {
    ObjectAnimator g;
    private Runnable iq;
    private boolean q;
    private int tb;
    ObjectAnimator z;

    public DynamicVerticalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.tb = 0;
        this.q = false;
        this.iq = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicVerticalScrollWidgetImp.this.fo();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo() {
        View childAt;
        final View childAt2;
        final View childAt3 = getChildAt(this.tb);
        int i = this.tb;
        if (i == 0) {
            this.q = false;
        }
        boolean z = i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.tb + 1)).getChildCount() <= 0;
        if (!this.i.uy().gc().z() && z) {
            this.q = true;
            childAt2 = getChildAt(this.tb - 1);
            this.z = ObjectAnimator.ofFloat(childAt3, "translationY", 0.0f, (this.gz + getChildAt(this.tb).getHeight()) / 2);
        } else {
            if (z) {
                childAt = getChildAt((this.tb + 2) % getChildCount());
            } else {
                childAt = getChildAt((this.tb + 1) % getChildCount());
            }
            this.z = ObjectAnimator.ofFloat(childAt3, "translationY", 0.0f, (-(this.gz + getChildAt(this.tb).getHeight())) / 2);
            if (z) {
                this.tb++;
            }
            childAt2 = childAt;
        }
        this.z.setInterpolator(new LinearInterpolator());
        this.z.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.2
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
                childAt3.setVisibility(8);
            }
        });
        if (this.q) {
            this.g = ObjectAnimator.ofFloat(childAt2, "translationY", (-(this.gz + childAt2.getHeight())) / 2, 0.0f);
        } else {
            this.g = ObjectAnimator.ofFloat(childAt2, "translationY", (this.gz + childAt2.getHeight()) / 2, 0.0f);
        }
        this.g.setInterpolator(new LinearInterpolator());
        this.g.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.3
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
        if (this.q) {
            this.tb--;
        } else {
            int i2 = this.tb + 1;
            this.tb = i2;
            this.tb = i2 % getChildCount();
        }
        postDelayed(this.iq, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
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

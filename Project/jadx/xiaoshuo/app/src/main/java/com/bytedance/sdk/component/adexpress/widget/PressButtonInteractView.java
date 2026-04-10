package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.d.bf;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes.dex */
public class PressButtonInteractView extends FrameLayout {
    private ImageView bf;
    private SplashDiffuseView d;
    private Context e;
    private boolean ga;
    private AnimatorSet tg;

    public PressButtonInteractView(Context context) {
        super(context);
        this.ga = true;
        this.e = context;
        this.tg = new AnimatorSet();
        d();
        tg();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.bf.getLayoutParams();
                layoutParams.topMargin = (int) ((PressButtonInteractView.this.d.getMeasuredHeight() / 2.0f) - bf.e(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((PressButtonInteractView.this.d.getMeasuredWidth() / 2.0f) - bf.e(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-PressButtonInteractView.this.d.getMeasuredHeight()) / 2.0f) + bf.e(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-PressButtonInteractView.this.d.getMeasuredWidth()) / 2.0f) + bf.e(PressButtonInteractView.this.getContext(), 5.0f));
                PressButtonInteractView.this.bf.setLayoutParams(layoutParams);
            }
        });
    }

    private void tg() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.bf, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.ga) {
                    PressButtonInteractView.this.d.e();
                }
                PressButtonInteractView.this.ga = !r2.ga;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressButtonInteractView.this.bf, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimatorOfFloat2.start();
                PressButtonInteractView.this.bf.setVisibility(0);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.bf, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.tg.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void d() {
        this.d = new SplashDiffuseView(this.e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) bf.e(this.e, 40.0f), (int) bf.e(this.e, 40.0f));
        layoutParams.gravity = 19;
        addView(this.d, layoutParams);
        this.bf = new ImageView(this.e);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) bf.e(this.e, 62.0f), (int) bf.e(this.e, 62.0f));
        layoutParams2.gravity = 16;
        this.bf.setImageResource(dt.tg(this.e, "tt_splash_hand"));
        addView(this.bf, layoutParams2);
    }

    public void bf() {
        AnimatorSet animatorSet = this.tg;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void e() {
        this.tg.start();
    }
}

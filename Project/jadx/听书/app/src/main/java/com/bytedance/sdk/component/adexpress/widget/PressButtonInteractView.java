package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.a.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class PressButtonInteractView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimatorSet f602a;
    private SplashDiffuseView dl;
    private ImageView g;
    private boolean gc;
    private Context z;

    public PressButtonInteractView(Context context) {
        super(context);
        this.gc = true;
        this.z = context;
        this.f602a = new AnimatorSet();
        dl();
        a();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.g.getLayoutParams();
                layoutParams.topMargin = (int) ((PressButtonInteractView.this.dl.getMeasuredHeight() / 2.0f) - gz.z(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((PressButtonInteractView.this.dl.getMeasuredWidth() / 2.0f) - gz.z(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-PressButtonInteractView.this.dl.getMeasuredHeight()) / 2.0f) + gz.z(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-PressButtonInteractView.this.dl.getMeasuredWidth()) / 2.0f) + gz.z(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressButtonInteractView.this.g.setLayoutParams(layoutParams);
            }
        });
    }

    private void dl() {
        this.dl = new SplashDiffuseView(this.z);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) gz.z(this.z, 40.0f), (int) gz.z(this.z, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.dl, layoutParams);
        this.g = new ImageView(this.z);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) gz.z(this.z, 62.0f), (int) gz.z(this.z, 62.0f));
        layoutParams2.gravity = 16;
        this.g.setImageResource(tb.gc(this.z, "tt_splash_hand"));
        addView(this.g, layoutParams2);
    }

    private void a() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, "scaleX", 1.0f, 0.9f);
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
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressButtonInteractView.this.g, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimatorOfFloat2.start();
                PressButtonInteractView.this.g.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.gc) {
                    PressButtonInteractView.this.dl.z();
                }
                PressButtonInteractView.this.gc = !r2.gc;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.g, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f602a.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void z() {
        this.f602a.start();
    }

    public void g() {
        AnimatorSet animatorSet = this.f602a;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SplashDiffuseView splashDiffuseView = this.dl;
        if (splashDiffuseView != null) {
            splashDiffuseView.g();
        }
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }
}

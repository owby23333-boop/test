package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.a.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class PressInteractView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimatorSet f603a;
    private SplashDiffuseView dl;
    private ImageView g;
    private boolean gc;
    private TextView m;
    private Context z;

    public PressInteractView(Context context) {
        super(context);
        this.gc = true;
        this.z = context;
        this.f603a = new AnimatorSet();
        dl();
        a();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                int iZ = (int) gz.z(PressInteractView.this.z, 50.0f);
                int iZ2 = (int) gz.z(PressInteractView.this.z, 50.0f);
                if (PressInteractView.this.dl.getMeasuredHeight() > 0) {
                    iZ = PressInteractView.this.dl.getMeasuredHeight();
                }
                if (PressInteractView.this.dl.getMeasuredWidth() > 0) {
                    iZ2 = PressInteractView.this.dl.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.g.getLayoutParams();
                layoutParams.topMargin = ((int) ((iZ / 2.0f) - gz.z(PressInteractView.this.getContext(), 5.0f))) + ((int) gz.z(PressInteractView.this.z, 40.0f));
                layoutParams.leftMargin = ((int) ((iZ2 / 2.0f) - gz.z(PressInteractView.this.getContext(), 5.0f))) + ((int) gz.z(PressInteractView.this.z, 20.0f));
                layoutParams.bottomMargin = (int) (((-iZ) / 2.0f) + gz.z(PressInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-iZ2) / 2.0f) + gz.z(PressInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressInteractView.this.g.setLayoutParams(layoutParams);
            }
        });
    }

    private void dl() {
        this.dl = new SplashDiffuseView(this.z);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) gz.z(this.z, 50.0f), (int) gz.z(this.z, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) gz.z(this.z, 40.0f);
        layoutParams.leftMargin = (int) gz.z(this.z, 20.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.dl, layoutParams);
        this.g = new ImageView(this.z);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) gz.z(this.z, 78.0f), (int) gz.z(this.z, 78.0f));
        this.g.setImageResource(tb.gc(this.z, "tt_splash_hand"));
        addView(this.g, layoutParams2);
        TextView textView = new TextView(this.z);
        this.m = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) gz.z(this.z, 10.0f);
        addView(this.m, layoutParams3);
        this.m.setVisibility(8);
    }

    private void a() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressInteractView.this.g, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                PressInteractView.this.g.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.gc) {
                    PressInteractView.this.dl.z();
                }
                PressInteractView.this.gc = !r2.gc;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.g, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(600L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.f603a.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.m.setVisibility(0);
        this.m.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.m.setTextColor(i);
    }

    public void z() {
        this.f603a.start();
    }

    public void g() {
        AnimatorSet animatorSet = this.f603a;
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

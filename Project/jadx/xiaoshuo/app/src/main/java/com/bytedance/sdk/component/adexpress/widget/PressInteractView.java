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
import com.bytedance.sdk.component.adexpress.d.bf;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes.dex */
public class PressInteractView extends FrameLayout {
    private ImageView bf;
    private SplashDiffuseView d;
    private Context e;
    private boolean ga;
    private AnimatorSet tg;
    private TextView vn;

    public PressInteractView(Context context) {
        super(context);
        this.ga = true;
        this.e = context;
        this.tg = new AnimatorSet();
        d();
        tg();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.bf.getLayoutParams();
                layoutParams.topMargin = ((int) ((PressInteractView.this.d.getMeasuredHeight() / 2.0f) - bf.e(PressInteractView.this.getContext(), 5.0f))) + ((int) bf.e(PressInteractView.this.e, 20.0f));
                layoutParams.leftMargin = ((int) ((PressInteractView.this.d.getMeasuredWidth() / 2.0f) - bf.e(PressInteractView.this.getContext(), 5.0f))) + ((int) bf.e(PressInteractView.this.e, 20.0f));
                layoutParams.bottomMargin = (int) (((-PressInteractView.this.d.getMeasuredHeight()) / 2.0f) + bf.e(PressInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-PressInteractView.this.d.getMeasuredWidth()) / 2.0f) + bf.e(PressInteractView.this.getContext(), 5.0f));
                PressInteractView.this.bf.setLayoutParams(layoutParams);
            }
        });
    }

    public void setGuideText(String str) {
        this.vn.setVisibility(0);
        this.vn.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.vn.setTextColor(i);
    }

    private void d() {
        this.d = new SplashDiffuseView(this.e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) bf.e(this.e, 50.0f), (int) bf.e(this.e, 50.0f));
        layoutParams.gravity = 51;
        layoutParams.topMargin = (int) bf.e(this.e, 20.0f);
        layoutParams.leftMargin = (int) bf.e(this.e, 20.0f);
        addView(this.d, layoutParams);
        this.bf = new ImageView(this.e);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) bf.e(this.e, 78.0f), (int) bf.e(this.e, 78.0f));
        this.bf.setImageResource(dt.tg(this.e, "tt_splash_hand"));
        addView(this.bf, layoutParams2);
        TextView textView = new TextView(this.e);
        this.vn = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) bf.e(this.e, 10.0f);
        addView(this.vn, layoutParams3);
        this.vn.setVisibility(8);
    }

    private void tg() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.bf, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(1000L);
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
            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.ga) {
                    PressInteractView.this.d.e();
                }
                PressInteractView.this.ga = !r2.ga;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressInteractView.this.bf, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                PressInteractView.this.bf.setVisibility(0);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.bf, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.tg.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
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

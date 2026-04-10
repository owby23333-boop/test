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
public class HandLongPressView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimatorSet f599a;
    private CircleRippleView dl;
    private ImageView g;
    private boolean gc;
    private TextView m;
    private Context z;

    public HandLongPressView(Context context) {
        super(context);
        this.gc = true;
        this.z = context;
        this.f599a = new AnimatorSet();
        dl();
        a();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) HandLongPressView.this.g.getLayoutParams();
                layoutParams.topMargin = ((int) ((HandLongPressView.this.dl.getMeasuredHeight() / 2.0f) - gz.z(HandLongPressView.this.getContext(), 5.0f))) + ((int) gz.z(HandLongPressView.this.z, 20.0f));
                layoutParams.leftMargin = ((int) ((HandLongPressView.this.dl.getMeasuredWidth() / 2.0f) - gz.z(HandLongPressView.this.getContext(), 5.0f))) + ((int) gz.z(HandLongPressView.this.z, 20.0f));
                layoutParams.bottomMargin = (int) (((-HandLongPressView.this.dl.getMeasuredHeight()) / 2.0f) + gz.z(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-HandLongPressView.this.dl.getMeasuredWidth()) / 2.0f) + gz.z(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                HandLongPressView.this.g.setLayoutParams(layoutParams);
            }
        });
    }

    private void dl() {
        this.dl = new CircleRippleView(this.z);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) gz.z(this.z, 80.0f), (int) gz.z(this.z, 80.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) gz.z(this.z, 20.0f);
        layoutParams.leftMargin = (int) gz.z(this.z, 20.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.dl, layoutParams);
        this.dl.z();
        this.g = new ImageView(this.z);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) gz.z(this.z, 80.0f), (int) gz.z(this.z, 80.0f));
        this.g.setImageResource(tb.gc(this.z, "tt_splash_hand"));
        addView(this.g, layoutParams2);
        TextView textView = new TextView(this.z);
        this.m = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) gz.z(this.z, 10.0f);
        addView(this.m, layoutParams3);
    }

    private void a() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, "scaleX", 1.0f, 0.8f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(HandLongPressView.this.g, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                HandLongPressView.this.g.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (HandLongPressView.this.gc) {
                    HandLongPressView.this.dl.z();
                    HandLongPressView.this.dl.setAlpha(1.0f);
                } else {
                    HandLongPressView.this.dl.g();
                    HandLongPressView.this.dl.setAlpha(0.0f);
                }
                HandLongPressView.this.gc = !r2.gc;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.g, "scaleY", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.f599a.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.m.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.m.setTextColor(i);
    }

    public void z() {
        this.f599a.start();
    }

    public void g() {
        AnimatorSet animatorSet = this.f599a;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        CircleRippleView circleRippleView = this.dl;
        if (circleRippleView != null) {
            circleRippleView.g();
        }
    }
}

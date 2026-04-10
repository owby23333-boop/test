package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.bf;
import com.bytedance.sdk.component.utils.dt;
import com.yuewen.pt;

/* JADX INFO: loaded from: classes.dex */
public class SlideRightView extends FrameLayout {
    private ImageView bf;
    private ImageView d;
    private Context e;
    private TextView ga;
    private AnimatorSet p;
    private ImageView tg;
    private AnimatorSet v;
    private AnimatorSet vn;
    private AnimatorSet zk;

    public SlideRightView(Context context) {
        super(context);
        this.vn = new AnimatorSet();
        this.p = new AnimatorSet();
        this.v = new AnimatorSet();
        this.zk = new AnimatorSet();
        this.e = context;
        bf();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setGuideText(String str) {
        this.ga.setText(str);
    }

    private void bf() {
        ImageView imageView = new ImageView(this.e);
        this.tg = imageView;
        imageView.setBackgroundResource(dt.tg(this.e, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) bf.e(this.e, 30.0f);
        addView(this.tg, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.e);
        this.d = imageView2;
        imageView2.setImageResource(dt.tg(this.e, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) bf.e(this.e, 50.0f), (int) bf.e(this.e, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) bf.e(this.e, 30.0f);
        addView(this.d, layoutParams2);
        ImageView imageView3 = new ImageView(this.e);
        this.bf = imageView3;
        imageView3.setImageResource(dt.tg(this.e, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) bf.e(this.e, 80.0f), (int) bf.e(this.e, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) bf.e(this.e, 30.0f);
        addView(this.bf, layoutParams3);
        TextView textView = new TextView(this.e);
        this.ga = textView;
        textView.setTextColor(-1);
        this.ga.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.ga, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) SlideRightView.this.bf.getLayoutParams();
                layoutParams5.topMargin = (int) ((SlideRightView.this.d.getMeasuredHeight() / 2.0f) - bf.e(SlideRightView.this.getContext(), 7.0f));
                layoutParams5.leftMargin = (-SlideRightView.this.d.getMeasuredWidth()) + ((int) bf.e(SlideRightView.this.e, 30.0f));
                SlideRightView.this.bf.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) SlideRightView.this.tg.getLayoutParams();
                layoutParams6.topMargin = (int) ((SlideRightView.this.d.getMeasuredHeight() / 2.0f) - bf.e(SlideRightView.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((SlideRightView.this.d.getMeasuredWidth() / 2.0f) + ((int) bf.e(SlideRightView.this.e, 30.0f)));
                SlideRightView.this.tg.setLayoutParams(layoutParams6);
            }
        });
    }

    private void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.bf, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.d, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.d, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.tg, "alpha", 0.0f, 1.0f);
        this.v.setDuration(300L);
        this.v.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.bf, "translationX", 0.0f, bf.e(getContext(), 90.0f));
        objectAnimatorOfFloat5.setInterpolator(new e(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) bf.e(getContext(), 90.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.tg.getLayoutParams();
                layoutParams.width = num.intValue();
                SlideRightView.this.tg.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new e(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.d, "translationX", 0.0f, bf.e(getContext(), 90.0f));
        objectAnimatorOfFloat6.setInterpolator(new e(0.2f, 0.0f, 0.3f, 1.0f));
        this.zk.setDuration(pt.f16197b);
        this.zk.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.bf, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.tg, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.d, "alpha", 1.0f, 0.0f);
        this.p.setDuration(50L);
        this.p.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.vn.playSequentially(this.v, this.zk, this.p);
    }

    public void e() {
        d();
        this.vn.start();
        this.vn.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideRightView.this.vn.start();
                    }
                }, 200L);
            }
        });
    }
}

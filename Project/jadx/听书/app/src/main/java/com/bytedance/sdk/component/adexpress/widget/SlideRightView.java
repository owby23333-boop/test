package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.a.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class SlideRightView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f607a;
    private ImageView dl;
    private AnimatorSet e;
    private AnimatorSet fo;
    private ImageView g;
    private TextView gc;
    private AnimatorSet gz;
    private AnimatorSet m;
    private Context z;

    public SlideRightView(Context context) {
        super(context);
        this.m = new AnimatorSet();
        this.e = new AnimatorSet();
        this.gz = new AnimatorSet();
        this.fo = new AnimatorSet();
        this.z = context;
        dl();
    }

    private void dl() {
        ImageView imageView = new ImageView(this.z);
        this.f607a = imageView;
        imageView.setBackgroundResource(tb.gc(this.z, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) gz.z(this.z, 30.0f);
        addView(this.f607a, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.z);
        this.dl = imageView2;
        imageView2.setImageResource(tb.gc(this.z, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) gz.z(this.z, 50.0f), (int) gz.z(this.z, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) gz.z(this.z, 30.0f);
        addView(this.dl, layoutParams2);
        ImageView imageView3 = new ImageView(this.z);
        this.g = imageView3;
        imageView3.setImageResource(tb.gc(this.z, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) gz.z(this.z, 80.0f), (int) gz.z(this.z, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) gz.z(this.z, 30.0f);
        addView(this.g, layoutParams3);
        TextView textView = new TextView(this.z);
        this.gc = textView;
        textView.setTextColor(-1);
        this.gc.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.gc, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) SlideRightView.this.g.getLayoutParams();
                layoutParams5.topMargin = (int) ((SlideRightView.this.dl.getMeasuredHeight() / 2.0f) - gz.z(SlideRightView.this.getContext(), 7.0f));
                layoutParams5.leftMargin = (-SlideRightView.this.dl.getMeasuredWidth()) + ((int) gz.z(SlideRightView.this.z, 30.0f));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.g.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) SlideRightView.this.f607a.getLayoutParams();
                layoutParams6.topMargin = (int) ((SlideRightView.this.dl.getMeasuredHeight() / 2.0f) - gz.z(SlideRightView.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((SlideRightView.this.dl.getMeasuredWidth() / 2.0f) + ((int) gz.z(SlideRightView.this.z, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.f607a.setLayoutParams(layoutParams6);
            }
        });
    }

    private void a() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.dl, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.dl, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.f607a, "alpha", 0.0f, 1.0f);
        this.gz.setDuration(300L);
        this.gz.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.g, "translationX", 0.0f, gz.z(getContext(), 90.0f));
        objectAnimatorOfFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) gz.z(getContext(), 90.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.f607a.getLayoutParams();
                layoutParams.width = num.intValue();
                SlideRightView.this.f607a.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.dl, "translationX", 0.0f, gz.z(getContext(), 90.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.fo.setDuration(1500L);
        this.fo.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.g, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.f607a, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.dl, "alpha", 1.0f, 0.0f);
        this.e.setDuration(50L);
        this.e.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.m.playSequentially(this.gz, this.fo, this.e);
    }

    public void z() {
        a();
        this.m.start();
        this.m.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideRightView.this.m.start();
                    }
                }, 200L);
            }
        });
    }

    public void g() {
        try {
            AnimatorSet animatorSet = this.m;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.gz;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.fo;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.e;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }

    public void setGuideText(String str) {
        this.gc.setText(str);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}

package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.bf;
import com.bytedance.sdk.component.adexpress.tg;
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.component.utils.wu;
import com.yuewen.pt;

/* JADX INFO: loaded from: classes.dex */
public class SlideUpView extends RelativeLayout {
    private ImageView bf;
    private ImageView d;
    private ImageView e;
    private TextView ga;
    private String m;
    private AnimatorSet p;
    private TextView tg;
    private AnimatorSet v;
    private AnimatorSet vn;
    private int wu;
    private AnimatorSet zk;

    public SlideUpView(Context context) {
        super(context);
        this.vn = new AnimatorSet();
        this.p = new AnimatorSet();
        this.v = new AnimatorSet();
        this.zk = new AnimatorSet();
        this.wu = 100;
        e(context);
    }

    public void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.e, "translationY", 0.0f, bf.e(getContext(), -this.wu));
        objectAnimatorOfFloat3.setInterpolator(new e(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) bf.e(getContext(), this.wu));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.d.getLayoutParams();
                layoutParams.height = num.intValue();
                SlideUpView.this.d.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new e(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.d, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.bf, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.bf, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.bf, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.bf, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.bf, "translationY", 0.0f, bf.e(getContext(), -this.wu));
        objectAnimatorOfFloat10.setInterpolator(new e(0.2f, 0.0f, 0.3f, 1.0f));
        this.p.setDuration(50L);
        this.zk.setDuration(pt.f16197b);
        this.v.setDuration(50L);
        this.p.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.v.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.zk.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.vn.playSequentially(this.v, this.zk, this.p);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.vn;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bf();
    }

    public void setGuideText(String str) {
        TextView textView = this.tg;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.ga != null) {
            if (TextUtils.isEmpty(str)) {
                this.ga.setText("");
            } else {
                this.ga.setText(str);
            }
        }
    }

    public void bf() {
        try {
            AnimatorSet animatorSet = this.vn;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.v;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.p;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.zk;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            wu.d(e.getMessage());
        }
    }

    public void e(Context context) {
        if (context == null) {
            context = tg.getContext();
        }
        if ("5".equals(this.m)) {
            View.inflate(context, dt.vn(context, "tt_dynamic_splash_slide_up_5"), this);
            this.wu = (int) (((double) this.wu) * 1.25d);
        } else {
            View.inflate(context, dt.vn(context, "tt_dynamic_splash_slide_up"), this);
        }
        this.e = (ImageView) findViewById(dt.ga(context, "tt_splash_slide_up_finger"));
        this.bf = (ImageView) findViewById(dt.ga(context, "tt_splash_slide_up_circle"));
        this.tg = (TextView) findViewById(dt.ga(context, "slide_guide_text"));
        this.d = (ImageView) findViewById(dt.ga(context, "tt_splash_slide_up_bg"));
        this.ga = (TextView) findViewById(dt.ga(context, "slide_text"));
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.vn = new AnimatorSet();
        this.p = new AnimatorSet();
        this.v = new AnimatorSet();
        this.zk = new AnimatorSet();
        this.wu = 100;
        setClipChildren(false);
        this.m = str;
        e(context);
    }

    public void e() {
        d();
        this.vn.start();
        this.vn.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideUpView.this.vn.start();
                    }
                }, 200L);
            }
        });
    }
}

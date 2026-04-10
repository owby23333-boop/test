package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.component.utils.pe;

/* JADX INFO: loaded from: classes.dex */
public class ShakeAnimationView extends LinearLayout {
    private TextView bf;
    private ImageView d;
    private TextView e;
    private TextView ga;
    private int m;
    private e p;
    private pe tg;
    private LinearLayout v;
    private TextView vn;
    private int wu;
    private int zk;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.d != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new bf(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShakeAnimationView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShakeAnimationView.this.d.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                ShakeAnimationView.this.d.startAnimation(rotateAnimation);
            }
        }
    }

    public static class bf implements Interpolator {
        private bf() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.25f ? (f * (-2.0f)) + 0.5f : f <= 0.5f ? (f * 4.0f) - 1.0f : f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }

        public /* synthetic */ bf(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public interface e {
        void e(boolean z);
    }

    public ShakeAnimationView(Context context, int i, int i2, int i3, int i4) {
        super(context);
        this.zk = i2;
        this.m = i3;
        this.wu = i4;
        e(context, i);
    }

    public LinearLayout getShakeLayout() {
        return this.v;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.tg == null) {
                this.tg = new pe(getContext().getApplicationContext(), 1);
            }
            this.tg.e(new pe.e() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.2
                @Override // com.bytedance.sdk.component.utils.pe.e
                public void e(int i) {
                    boolean zD = ShakeAnimationView.this.tg != null ? ShakeAnimationView.this.tg.d() : false;
                    if (i == 1 && ShakeAnimationView.this.isShown() && ShakeAnimationView.this.p != null) {
                        ShakeAnimationView.this.p.e(zD);
                    }
                }
            });
            this.tg.e(this.zk);
            this.tg.d(this.m);
            this.tg.e(this.wu);
            this.tg.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pe peVar = this.tg;
        if (peVar != null) {
            peVar.bf();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        pe peVar = this.tg;
        if (peVar != null) {
            if (z) {
                peVar.e();
            } else {
                peVar.bf();
            }
        }
    }

    public void setOnShakeViewListener(e eVar) {
        this.p = eVar;
    }

    public void setShakeText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ga.setText(str);
        } else {
            this.ga.setVisibility(8);
            this.vn.setVisibility(8);
        }
    }

    public void e(Context context, int i) {
        View.inflate(context, i, this);
        this.v = (LinearLayout) findViewById(dt.ga(context, "tt_hand_container"));
        this.d = (ImageView) findViewById(dt.ga(context, "tt_splash_rock_img"));
        this.e = (TextView) findViewById(dt.ga(context, "tt_splash_rock_top_text"));
        this.bf = (TextView) findViewById(dt.ga(context, "tt_splash_rock_top_text_stub"));
        this.ga = (TextView) findViewById(dt.ga(context, "tt_splash_rock_text"));
        this.vn = (TextView) findViewById(dt.ga(context, "tt_splash_rock_text_stub"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.v.setBackground(gradientDrawable);
    }

    public void e() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }
}

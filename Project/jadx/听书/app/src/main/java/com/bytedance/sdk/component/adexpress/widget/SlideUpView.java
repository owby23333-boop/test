package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.a;
import com.bytedance.sdk.component.adexpress.a.gz;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class SlideUpView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f608a;
    private ImageView dl;
    private AnimatorSet e;
    private AnimatorSet fo;
    private ImageView g;
    private TextView gc;
    private AnimatorSet gz;
    private int kb;
    private AnimatorSet m;
    private String uy;
    private ImageView z;

    public SlideUpView(Context context) {
        super(context);
        this.m = new AnimatorSet();
        this.e = new AnimatorSet();
        this.gz = new AnimatorSet();
        this.fo = new AnimatorSet();
        this.kb = 100;
        z(context);
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.m = new AnimatorSet();
        this.e = new AnimatorSet();
        this.gz = new AnimatorSet();
        this.fo = new AnimatorSet();
        this.kb = 100;
        setClipChildren(false);
        this.uy = str;
        z(context);
    }

    protected void z(Context context) {
        if (context == null) {
            context = a.getContext();
        }
        if ("5".equals(this.uy)) {
            addView(com.bytedance.sdk.component.adexpress.dl.z.m(context));
            this.kb = (int) (((double) this.kb) * 1.25d);
        } else {
            addView(com.bytedance.sdk.component.adexpress.dl.z.gc(context));
        }
        this.z = (ImageView) findViewById(2097610734);
        this.g = (ImageView) findViewById(2097610735);
        this.f608a = (TextView) findViewById(2097610730);
        this.dl = (ImageView) findViewById(2097610733);
        this.gc = (TextView) findViewById(2097610731);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.m;
    }

    public void z() {
        dl();
        this.m.start();
        this.m.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideUpView.this.m.start();
                    }
                }, 200L);
            }
        });
    }

    public void dl() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.z, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.z, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.z, "translationY", 0.0f, gz.z(getContext(), -this.kb));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) gz.z(getContext(), this.kb));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SlideUpView.this.dl != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.dl.getLayoutParams();
                    layoutParams.height = num.intValue();
                    SlideUpView.this.dl.setLayoutParams(layoutParams);
                }
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.dl, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.dl, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.g, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.g, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.g, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.g, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.g, "translationY", 0.0f, gz.z(getContext(), -this.kb));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.e.setDuration(50L);
        this.fo.setDuration(1500L);
        this.gz.setDuration(50L);
        this.e.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.gz.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.fo.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.m.playSequentially(this.gz, this.fo, this.e);
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
            AnimatorSet animatorSet3 = this.e;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.fo;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            wp.dl(e.getMessage());
        }
    }

    public void setGuideText(String str) {
        TextView textView = this.f608a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.gc != null) {
            if (TextUtils.isEmpty(str)) {
                this.gc.setText("");
            } else {
                this.gc.setText(str);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }
}

package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class SlideUpView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f986a;
    private ImageView dl;
    private AnimatorSet e;
    private ImageView g;
    private AnimatorSet gc;
    private AnimatorSet gz;
    private AnimatorSet m;
    private ImageView z;

    public SlideUpView(Context context) {
        super(context);
        g(context);
    }

    private View z(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setGravity(16);
        relativeLayout.setClipChildren(false);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        this.dl = imageView;
        imageView.setId(2114387639);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        layoutParams2.addRule(14);
        layoutParams2.addRule(8, 2114387761);
        layoutParams2.bottomMargin = oq.dl(context, -24.0f);
        tb.z(context, "tt_splash_slide_up_circle", (View) this.dl);
        this.dl.setAlpha(0.0f);
        this.dl.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.dl);
        ImageView imageView2 = new ImageView(context);
        this.g = imageView2;
        imageView2.setId(2114387939);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(14);
        layoutParams3.addRule(1, 2114387761);
        layoutParams3.addRule(8, 2114387761);
        tb.z(context, "tt_splash_slide_up_bg", (View) this.g);
        layoutParams3.leftMargin = oq.dl(context, -7.0f);
        this.g.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.g);
        ImageView imageView3 = new ImageView(context);
        this.z = imageView3;
        imageView3.setId(2114387644);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 91.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 68.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(14);
        layoutParams4.addRule(1, 2114387761);
        layoutParams4.addRule(8, 2114387761);
        tb.z(context, "tt_splash_slide_up_finger", (View) this.z);
        layoutParams4.leftMargin = oq.dl(context, -7.0f);
        layoutParams4.bottomMargin = oq.dl(context, -20.0f);
        this.z.setAlpha(0.0f);
        this.z.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.z);
        ImageView imageView4 = new ImageView(context);
        this.f986a = imageView4;
        imageView4.setId(2114387761);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 124.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        tb.z(context, "tt_splash_slide_up_arrow", (View) this.f986a);
        this.f986a.setLayoutParams(layoutParams5);
        relativeLayout.addView(this.f986a);
        return relativeLayout;
    }

    private void g(Context context) {
        if (context == null) {
            context = zw.getContext();
        }
        View viewZ = z(context);
        if (viewZ == null) {
            return;
        }
        addView(viewZ);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.gc;
    }

    public void z() {
        this.m = new AnimatorSet();
        this.e = new AnimatorSet();
        this.gz = new AnimatorSet();
        this.gc = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.z, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.z, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.z, "translationY", 0.0f, oq.dl(getContext(), -110.0f));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, oq.dl(getContext(), 110.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SlideUpView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.g.getLayoutParams();
                layoutParams.height = num.intValue();
                SlideUpView.this.g.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.g, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.g, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.dl, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.dl, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.dl, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.dl, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.dl, "translationY", 0.0f, oq.dl(getContext(), -110.0f));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.m.setDuration(50L);
        this.gz.setDuration(1500L);
        this.e.setDuration(50L);
        this.m.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.e.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.gz.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.gc.playSequentially(this.e, this.gz, this.m);
    }

    public void g() {
        AnimatorSet animatorSet = this.gc;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.e;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.m;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.gz;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }
}

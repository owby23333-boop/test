package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class SplashClickBarArrow extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f988a;
    private ImageView dl;
    private ImageView e;
    private RelativeLayout fo;
    private RelativeLayout g;
    private ImageView gc;
    private SplashDiffuseView gz;
    private int kb;
    private FrameLayout m;
    private boolean uy;
    private AnimatorSet wp;
    private ImageView z;

    public SplashClickBarArrow(Context context) {
        super(context);
        this.uy = true;
        this.wp = new AnimatorSet();
        g(context);
    }

    public void z(int i) {
        this.kb = i;
        z();
    }

    private View z(Context context) {
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setClipChildren(false);
        frameLayout.setLayoutParams(layoutParams);
        this.z = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics()));
        this.z.setId(2114387592);
        layoutParams2.gravity = 16;
        z(context, "tt_splash_click_bar_go", this.z, true);
        this.z.setLayoutParams(layoutParams2);
        frameLayout.addView(this.z);
        oq.z((View) this.z, 8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.g = relativeLayout;
        relativeLayout.setId(2114387591);
        new FrameLayout.LayoutParams(-2, -2).gravity = 16;
        this.g.setPadding(oq.dl(context, 4.0f), 0, 0, 0);
        frameLayout.addView(this.g);
        oq.z((View) this.g, 8);
        ImageView imageView = new ImageView(context);
        this.dl = imageView;
        imageView.setId(2114387590);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.dl.setAlpha(0.0f);
        z(context, "tt_splash_arrow", this.dl, false);
        this.dl.setLayoutParams(layoutParams3);
        this.g.addView(this.dl);
        ImageView imageView2 = new ImageView(context);
        this.f988a = imageView2;
        imageView2.setId(2114387589);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.f988a.setAlpha(0.0f);
        z(context, "tt_splash_arrow", this.f988a, true);
        this.f988a.setLayoutParams(layoutParams4);
        this.g.addView(this.f988a);
        ImageView imageView3 = new ImageView(context);
        this.gc = imageView3;
        imageView3.setId(2114387588);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.gc.setAlpha(0.0f);
        z(context, "tt_splash_arrow", this.gc, true);
        this.gc.setLayoutParams(layoutParams5);
        this.g.addView(this.gc);
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics())));
        this.g.addView(view);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.m = frameLayout2;
        frameLayout2.setId(2114387587);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        this.m.setClipChildren(false);
        this.m.setLayoutParams(layoutParams6);
        frameLayout.addView(this.m);
        oq.z((View) this.m, 8);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.fo = relativeLayout2;
        relativeLayout2.setId(2114387586);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -1);
        this.fo.setClipChildren(false);
        this.fo.setLayoutParams(layoutParams7);
        this.m.addView(this.fo);
        ImageView imageView4 = new ImageView(context);
        this.e = imageView4;
        imageView4.setId(2114387585);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()));
        z(context, "tt_splash_hand", this.e, false);
        this.e.setLayoutParams(layoutParams8);
        this.fo.addView(this.e);
        oq.z((View) this.e, 4);
        return frameLayout;
    }

    private void g(Context context) {
        View viewZ = z(getContext());
        if (viewZ == null) {
            return;
        }
        addView(viewZ);
        SplashDiffuseView splashDiffuseView = new SplashDiffuseView(getContext());
        this.gz = splashDiffuseView;
        this.m.addView(splashDiffuseView, 0);
        ViewGroup.LayoutParams layoutParams = this.gz.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.gz.setVisibility(4);
    }

    public Animator getAnimator() {
        return this.wp;
    }

    private void z() {
        this.z.setVisibility(8);
        this.g.setVisibility(8);
        int i = this.kb;
        if (i == 1) {
            this.g.setVisibility(0);
            g();
            return;
        }
        if (i == 2) {
            this.m.setVisibility(0);
            post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SplashClickBarArrow.this.fo.getLayoutParams();
                    layoutParams.topMargin = (int) ((SplashClickBarArrow.this.gz.getMeasuredHeight() / 2.0f) - oq.dl(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.leftMargin = (int) ((SplashClickBarArrow.this.gz.getMeasuredWidth() / 2.0f) - oq.dl(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.bottomMargin = (int) (((-SplashClickBarArrow.this.gz.getMeasuredHeight()) / 2.0f) + oq.dl(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.rightMargin = (int) (((-SplashClickBarArrow.this.gz.getMeasuredWidth()) / 2.0f) + oq.dl(SplashClickBarArrow.this.getContext(), 5.0f));
                    SplashClickBarArrow.this.fo.setLayoutParams(layoutParams);
                }
            });
            dl();
        } else {
            if (i == 3 || i == 4 || i == 5 || i == 7) {
                return;
            }
            this.z.setVisibility(0);
        }
    }

    private void g() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.dl, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new z());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.dl, "translationX", 0.0f, oq.dl(getContext(), 20.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f988a, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new z());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.f988a, "translationX", oq.dl(getContext(), 23.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.gc, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat5.setInterpolator(new z());
        objectAnimatorOfFloat5.setDuration(1300L);
        objectAnimatorOfFloat5.setStartDelay(200L);
        objectAnimatorOfFloat5.setRepeatCount(-1);
        objectAnimatorOfFloat5.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.gc, "translationX", oq.dl(getContext(), 25.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat6.setDuration(1300L);
        objectAnimatorOfFloat6.setStartDelay(200L);
        objectAnimatorOfFloat6.setRepeatCount(-1);
        objectAnimatorOfFloat6.setRepeatMode(1);
        this.wp.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat5, objectAnimatorOfFloat2, objectAnimatorOfFloat4, objectAnimatorOfFloat6);
    }

    private void dl() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(SplashClickBarArrow.this.e, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                SplashClickBarArrow.this.e.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (SplashClickBarArrow.this.uy) {
                    SplashClickBarArrow.this.gz.z();
                }
                SplashClickBarArrow.this.uy = !r2.uy;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.wp.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.wp.setStartDelay(1000L);
    }

    private static class z implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }

        private z() {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            AnimatorSet animatorSet = this.wp;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        } catch (Exception e) {
            wp.dl(e.getMessage());
        }
    }

    private void z(final Context context, final String str, final ImageView imageView, final boolean z2) {
        com.bytedance.sdk.component.utils.gz.dl().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.3
            @Override // java.lang.Runnable
            public void run() {
                final Drawable drawableDl = tb.dl(context, str);
                com.bytedance.sdk.component.utils.gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (imageView == null || drawableDl == null) {
                                return;
                            }
                            if (z2) {
                                imageView.setBackground(drawableDl);
                            } else {
                                imageView.setImageDrawable(drawableDl);
                            }
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        });
    }
}

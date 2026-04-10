package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class BluePressInteractView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f588a;
    private boolean dl;
    private ImageView e;
    private int fo;
    private ObjectAnimator g;
    private View gc;
    private int gz;
    private View m;
    private Context uy;
    private AnimatorSet z;

    public BluePressInteractView(Context context, int i, int i2) {
        super(context);
        this.dl = false;
        this.z = new AnimatorSet();
        this.gz = i;
        this.fo = i2;
        this.uy = context;
        dl();
        a();
    }

    private void dl() {
        View view = new View(this.uy);
        this.f588a = view;
        view.setBackground(z("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((double) this.gz) * 0.45d), (int) (((double) this.fo) * 0.45d));
        layoutParams.gravity = 17;
        this.f588a.setLayoutParams(layoutParams);
        addView(this.f588a);
        View view2 = new View(this.uy);
        this.gc = view2;
        view2.setBackground(z("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((double) this.gz) * 0.25d), (int) (((double) this.fo) * 0.25d));
        layoutParams2.gravity = 17;
        this.gc.setLayoutParams(layoutParams2);
        addView(this.gc);
        View view3 = new View(this.uy);
        this.m = view3;
        view3.setBackground(z("#807BBEFF", "#FF7BBEFF"));
        int i = this.gz;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) i) * 0.25d), (int) (((double) i) * 0.25d));
        layoutParams3.gravity = 17;
        this.m.setLayoutParams(layoutParams3);
        addView(this.m);
        ImageView imageView = new ImageView(this.uy);
        this.e = imageView;
        imageView.setImageResource(tb.gc(getContext(), "tt_blue_hand"));
        this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (((double) this.gz) * 0.62d), (int) (((double) this.fo) * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.e.setLayoutParams(layoutParams4);
        addView(this.e);
    }

    private void a() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f588a, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f588a, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.gc, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.gc, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.m, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.m, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.e, Key.ROTATION, 0.0f, -20.0f, 0.0f);
        this.g = objectAnimatorOfFloat7;
        objectAnimatorOfFloat7.setDuration(1000L);
        this.z.setDuration(1500L);
        this.z.setInterpolator(new AccelerateDecelerateInterpolator());
        this.z.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat6);
        this.z.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.BluePressInteractView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BluePressInteractView.this.dl) {
                    return;
                }
                BluePressInteractView.this.g.start();
                BluePressInteractView.this.z.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                BluePressInteractView.this.dl = true;
            }
        });
    }

    private GradientDrawable z(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void z() {
        this.dl = false;
        ObjectAnimator objectAnimator = this.g;
        if (objectAnimator == null || this.z == null) {
            return;
        }
        objectAnimator.start();
        this.z.start();
    }

    public void g() {
        this.dl = true;
        ObjectAnimator objectAnimator = this.g;
        if (objectAnimator == null || this.z == null) {
            return;
        }
        objectAnimator.cancel();
        this.z.cancel();
    }
}

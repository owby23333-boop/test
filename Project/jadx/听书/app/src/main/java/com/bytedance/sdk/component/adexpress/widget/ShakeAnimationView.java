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
import com.bytedance.sdk.component.adexpress.dynamic.dl.uy;
import com.bytedance.sdk.component.utils.iq;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeAnimationView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f606a;
    private TextView dl;
    private TextView e;
    private LinearLayout fo;
    private TextView g;
    private iq gc;
    private z gz;
    private boolean kb;
    private TextView m;
    private uy uy;
    public int z;

    public interface z {
        void z(boolean z);
    }

    public ShakeAnimationView(Context context, View view, uy uyVar, boolean z2, int i) {
        super(context);
        this.uy = uyVar;
        this.kb = z2;
        this.z = i;
        z(context, view);
    }

    protected void z(Context context, View view) {
        addView(view);
        this.fo = (LinearLayout) findViewById(2097610727);
        this.f606a = (ImageView) findViewById(2097610725);
        this.g = (TextView) findViewById(2097610724);
        this.dl = (TextView) findViewById(2097610726);
        this.m = (TextView) findViewById(2097610723);
        this.e = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.fo.setBackground(gradientDrawable);
    }

    public void setShakeText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.m.setVisibility(8);
            this.e.setVisibility(8);
        } else {
            this.m.setText(str);
        }
    }

    public LinearLayout getShakeLayout() {
        return this.fo;
    }

    public void setOnShakeViewListener(z zVar) {
        this.gz = zVar;
    }

    public void z() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.f606a != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new g(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShakeAnimationView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShakeAnimationView.this.f606a.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }
                });
                ShakeAnimationView.this.f606a.startAnimation(rotateAnimation);
            }
        }
    }

    private static class g implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.25f ? (f * (-2.0f)) + 0.5f : f <= 0.5f ? (f * 4.0f) - 1.0f : f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }

        private g() {
        }

        /* synthetic */ g(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.gc == null) {
                this.gc = new iq(getContext().getApplicationContext(), 1, this.kb);
            }
            this.gc.z(new iq.z() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.2
                @Override // com.bytedance.sdk.component.utils.iq.z
                public void z(int i) {
                    boolean z2 = ShakeAnimationView.this.gc != null ? ShakeAnimationView.this.gc.z() : false;
                    if (i == 1 && ShakeAnimationView.this.isShown() && ShakeAnimationView.this.gz != null) {
                        ShakeAnimationView.this.gz.z(z2);
                    }
                }
            });
            if (this.uy != null) {
                this.gc.z(r0.z());
                this.gc.dl(this.uy.e());
                this.gc.dl(this.uy.g());
                this.gc.gc(this.uy.a());
                this.gc.g(this.uy.dl());
                this.gc.m(this.uy.gc());
                this.gc.z(this.uy.m());
                this.gc.g(this.uy.gz());
                this.gc.z(this.z);
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        iq iqVar = this.gc;
        if (iqVar != null) {
            if (z2) {
                iqVar.z(this.z);
            } else {
                iqVar.g(this.z);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        iq iqVar = this.gc;
        if (iqVar != null) {
            iqVar.g(this.z);
        }
    }
}

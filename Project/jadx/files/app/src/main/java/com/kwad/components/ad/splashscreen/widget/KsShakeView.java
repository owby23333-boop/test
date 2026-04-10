package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.r.o;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public class KsShakeView extends KSFrameLayout {
    private int Fg;
    private float Fh;

    @ColorInt
    private int Fi;

    @ColorInt
    private int Fj;

    @ColorInt
    private int Fk;
    private float Fl;
    private float Fm;

    @DrawableRes
    private int Fn;
    private Animator Fo;
    private boolean Fp;
    private ImageView fo;

    @Nullable
    private Animator fp;
    private Paint mPaint;

    public KsShakeView(@NonNull Context context) {
        this(context, null, 0);
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaint = new Paint();
        this.Fp = false;
        init(context, attributeSet, i2);
    }

    private Animator a(View view, long j2, float f2) {
        Interpolator interpolatorCreate;
        float height;
        if (view == null) {
            return null;
        }
        if (this.Fg == 1) {
            interpolatorCreate = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth());
            height = view.getHeight();
        } else {
            interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth() / 2.0f);
            height = view.getHeight() / 2.0f;
        }
        view.setPivotY(height);
        return o.a(view, interpolatorCreate, 100L, 16.0f);
    }

    private static Animator b(View view, long j2, float f2) {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(100L);
        duration.setInterpolator(interpolatorCreate);
        float f3 = -f2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "translationY", f3).setDuration(200L);
        duration2.setInterpolator(interpolatorCreate);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(200L);
        duration3.setInterpolator(interpolatorCreate);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "translationY", f3).setDuration(200L);
        duration4.setInterpolator(interpolatorCreate);
        animatorSet.playSequentially(duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(100L), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(100L));
        return animatorSet;
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i2, 0);
        this.Fh = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_outerStrokeWidth, 1.0f);
        this.Fi = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_outerStrokeColor, Color.parseColor("#4DFFFFFF"));
        this.Fj = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_solidColor, Color.parseColor("#66000000"));
        this.Fg = typedArrayObtainStyledAttributes.getInteger(R.styleable.ksad_KsShakeView_ksad_shakeViewStyle, 1);
        this.Fk = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeColor, Color.parseColor("#B3FFFFFF"));
        this.Fl = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeWidth, 1.0f);
        this.Fn = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_shake_hand);
        this.Fm = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCirclePadding, com.kwad.sdk.b.kwai.a.a(context, 10.0f));
        typedArrayObtainStyledAttributes.recycle();
        this.fo = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.fo, layoutParams);
        lw();
    }

    private void lw() {
        this.fo.setImageResource(this.Fn);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.Fj);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Fl);
        paint.setColor(this.Fk);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Fh);
        paint.setColor(this.Fi);
        paint.setAntiAlias(true);
    }

    public final void ah(int i2) {
        this.Fg = i2;
        setIconDrawableRes(i2 != 2 ? R.drawable.ksad_ic_shake_hand : R.drawable.ksad_ic_shake_phone);
    }

    public final void b(AnimatorListenerAdapter animatorListenerAdapter) {
        this.Fp = true;
        Animator animator = this.fp;
        if (animator != null) {
            animator.cancel();
        }
        this.fo.setRotation(0.0f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_splash_shake_animator_height);
        Animator animator2 = this.Fo;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.Fo = b(this, 100L, dimensionPixelSize);
        this.Fo.addListener(animatorListenerAdapter);
        this.Fo.start();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float fMin = Math.min(getWidth(), getHeight()) / 2.0f;
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, fMin, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, fMin, this.mPaint);
        if (this.Fg == 2) {
            setInnerCirclePaint(this.mPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, fMin - this.Fm, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    public final void ko() {
        Animator animator = this.fp;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.Fo;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.fp = null;
        this.Fo = null;
    }

    @MainThread
    public final void lR() {
        this.Fp = false;
        Animator animator = this.fp;
        if (animator != null) {
            animator.cancel();
            this.fp = null;
        }
        this.fp = a(this.fo, 100L, 16.0f);
        Animator animator2 = this.fp;
        if (animator2 != null) {
            animator2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.KsShakeView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator3) {
                    super.onAnimationCancel(animator3);
                    KsShakeView.this.fo.setRotation(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator3) {
                    super.onAnimationEnd(animator3);
                    if (KsShakeView.this.Fp || KsShakeView.this.fp == null) {
                        return;
                    }
                    KsShakeView.this.fp.start();
                }
            });
            this.fp.start();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        Animator animator = this.fp;
        if (animator != null) {
            animator.cancel();
        }
    }

    @MainThread
    public void setIconDrawableRes(@DrawableRes int i2) {
        ImageView imageView = this.fo;
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
    }
}

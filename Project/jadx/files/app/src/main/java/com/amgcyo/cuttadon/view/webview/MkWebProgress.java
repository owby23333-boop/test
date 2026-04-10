package com.amgcyo.cuttadon.view.webview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.f.o;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkWebProgress extends FrameLayout {
    private static int C = 8000;
    private static int D = 450;
    public static int E = 3;
    private ValueAnimator.AnimatorUpdateListener A;
    private AnimatorListenerAdapter B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f5572s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Paint f5573t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Animator f5574u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5575v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f5576w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5577x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f5578y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f5579z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            MkWebProgress.this.f5579z = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            MkWebProgress.this.invalidate();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MkWebProgress.this.b();
        }
    }

    public MkWebProgress(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f5577x == 2 && this.f5579z == 100.0f) {
            setVisibility(8);
            this.f5579z = 0.0f;
            setAlpha(1.0f);
        }
        this.f5577x = 0;
    }

    private void c() {
        this.f5578y = false;
        this.f5577x = 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (this.f5579z / 100.0f) * Float.valueOf(getWidth()).floatValue(), getHeight(), this.f5573t);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.f5574u;
        if (animator == null || !animator.isStarted()) {
            return;
        }
        this.f5574u.cancel();
        this.f5574u = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE && size > getContext().getResources().getDisplayMetrics().widthPixels) {
            size = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = this.f5576w;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f5575v = getMeasuredWidth();
        int i6 = getContext().getResources().getDisplayMetrics().widthPixels;
        int i7 = this.f5575v;
        if (i7 >= i6) {
            D = 450;
            C = 8000;
        } else {
            float fFloatValue = i7 / Float.valueOf(i6).floatValue();
            C = (int) (8000.0f * fFloatValue);
            D = (int) (fFloatValue * 450.0f);
        }
    }

    public void setColor(int i2) {
        this.f5572s = i2;
        this.f5573t.setColor(i2);
    }

    public void setProgress(int i2) {
        setProgress(Float.valueOf(i2).floatValue());
    }

    public void setWebProgress(int i2) {
        if (i2 < 0 || i2 >= 95) {
            setProgress(i2);
            c();
        } else if (this.f5578y) {
            setProgress(i2);
        } else {
            a();
        }
    }

    public MkWebProgress(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setProgress(float f2) {
        if (this.f5577x == 0 && f2 == 100.0f) {
            setVisibility(8);
            return;
        }
        if (getVisibility() == 8) {
            setVisibility(0);
        }
        if (f2 >= 95.0f && this.f5577x != 2) {
            a(true);
        }
    }

    public MkWebProgress(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5575v = 0;
        this.f5577x = 0;
        this.f5578y = false;
        this.f5579z = 0.0f;
        this.A = new a();
        this.B = new b();
        a(context, attributeSet, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        this.f5573t = new Paint();
        this.f5572s = o.b(R.color.colorPrimary);
        this.f5573t.setAntiAlias(true);
        this.f5573t.setColor(this.f5572s);
        this.f5573t.setDither(true);
        this.f5573t.setStrokeCap(Paint.Cap.SQUARE);
        this.f5575v = context.getResources().getDisplayMetrics().widthPixels;
        this.f5576w = a(E);
    }

    public void setColor(String str) {
        setColor(Color.parseColor(str));
    }

    private void a(boolean z2) {
        AnimatorSet animatorSet;
        float f2 = z2 ? 100.0f : 95.0f;
        Animator animator = this.f5574u;
        if (animator != null && animator.isStarted()) {
            this.f5574u.cancel();
        }
        float f3 = this.f5579z;
        if (f3 == 0.0f) {
            f3 = 1.0E-8f;
        }
        this.f5579z = f3;
        if (!z2) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f5579z, f2);
            float f4 = (1.0f - (this.f5579z / 100.0f)) - 0.05f;
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.setDuration((long) (f4 * C));
            valueAnimatorOfFloat.addUpdateListener(this.A);
            valueAnimatorOfFloat.start();
            this.f5574u = valueAnimatorOfFloat;
        } else {
            ValueAnimator valueAnimatorOfFloat2 = null;
            float f5 = this.f5579z;
            if (f5 < 95.0f) {
                valueAnimatorOfFloat2 = ValueAnimator.ofFloat(f5, 95.0f);
                float f6 = (1.0f - (this.f5579z / 100.0f)) - 0.05f;
                valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                valueAnimatorOfFloat2.setDuration((long) (f6 * D));
                valueAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
                valueAnimatorOfFloat2.addUpdateListener(this.A);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setDuration(630L);
            ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(95.0f, 100.0f);
            valueAnimatorOfFloat3.setDuration(500L);
            valueAnimatorOfFloat3.addUpdateListener(this.A);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(objectAnimatorOfFloat, valueAnimatorOfFloat3);
            if (valueAnimatorOfFloat2 != null) {
                animatorSet = new AnimatorSet();
                animatorSet.play(animatorSet2).after(valueAnimatorOfFloat2);
            } else {
                animatorSet = animatorSet2;
            }
            animatorSet.addListener(this.B);
            animatorSet.start();
            this.f5574u = animatorSet;
        }
        this.f5577x = 1;
    }

    private int a(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void a() {
        this.f5578y = true;
        setVisibility(0);
        this.f5579z = 0.0f;
        a(false);
    }
}

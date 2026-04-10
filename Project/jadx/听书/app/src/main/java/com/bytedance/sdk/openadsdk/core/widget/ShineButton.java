package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import androidx.media3.exoplayer.ExoPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class ShineButton extends Button {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1411a;
    private Matrix dl;
    private LinearGradient g;
    private ValueAnimator gc;
    private float m;
    private Paint z;

    public ShineButton(Context context) {
        super(context);
        this.z = new Paint(1);
        this.dl = new Matrix();
        this.f1411a = 0.0f;
        this.m = 0.3f;
        z(context);
    }

    private void z(Context context) {
        this.z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.z.setColor(-1);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i2 * this.m;
        float f2 = -f;
        LinearGradient linearGradient = new LinearGradient(f2, f2, f, f, new int[]{0, Color.parseColor("#88ffffff"), Color.parseColor("#88ffffff"), 0}, new float[]{0.0f, 0.2f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
        this.g = linearGradient;
        this.z.setShader(linearGradient);
        z();
    }

    private void z() {
        ValueAnimator valueAnimator = this.gc;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.gc.removeAllListeners();
            this.gc.removeAllUpdateListeners();
            this.gc = null;
        }
        float fSqrt = (float) Math.sqrt((getWidth() * getWidth()) + (getHeight() * getHeight()));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(-fSqrt, fSqrt);
        this.gc = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        this.gc.setRepeatCount(-1);
        this.gc.setInterpolator(new LinearInterpolator());
        this.gc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ShineButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ShineButton.this.f1411a = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                ShineButton.this.invalidate();
            }
        });
        this.gc.start();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = this.dl;
        float f = this.f1411a;
        matrix.setTranslate(f, f);
        this.g.setLocalMatrix(this.dl);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.z);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.gc;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.gc.removeAllListeners();
            this.gc.removeAllUpdateListeners();
            this.gc = null;
        }
    }
}

package com.anythink.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ScanningAnimButton extends Button {
    ValueAnimator a;

    public ScanningAnimButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void a() {
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (isShown() && i2 == 0) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (isShown() && i2 == 0) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    public void startAnimation() {
        if (this.a == null) {
            this.a = ValueAnimator.ofFloat(1.0f, 0.95f);
            this.a.setDuration(500L);
            this.a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.ScanningAnimButton.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ScanningAnimButton.this.setScaleX(fFloatValue);
                    ScanningAnimButton.this.setScaleY(fFloatValue);
                }
            });
            this.a.setRepeatMode(2);
            this.a.setRepeatCount(-1);
        }
        if (this.a.isStarted()) {
            return;
        }
        this.a.start();
    }

    public void stopAnimation() {
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}

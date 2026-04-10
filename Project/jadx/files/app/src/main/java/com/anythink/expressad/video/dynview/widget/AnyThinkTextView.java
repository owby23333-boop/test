package com.anythink.expressad.video.dynview.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class AnyThinkTextView extends TextView {
    private ObjectAnimator a;

    public AnyThinkTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.a;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.a;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.a = objectAnimator;
    }

    public AnyThinkTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnyThinkTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

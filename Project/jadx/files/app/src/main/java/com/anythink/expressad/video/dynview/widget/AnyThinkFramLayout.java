package com.anythink.expressad.video.dynview.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class AnyThinkFramLayout extends FrameLayout {
    private AnimatorSet a;

    public AnyThinkFramLayout(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AnimatorSet animatorSet = this.a;
        if (animatorSet != null) {
            try {
                animatorSet.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.a;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.a = animatorSet;
    }

    public AnyThinkFramLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnyThinkFramLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

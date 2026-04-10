package com.anythink.expressad.video.dynview.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class AnyThinkRelativeLayout extends RelativeLayout {
    private boolean a;
    private AnimatorSet b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11762c;

    public AnyThinkRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AnimatorSet animatorSet = this.b;
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
        if (!this.a) {
            this.a = true;
        }
        AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.b = animatorSet;
    }

    public AnyThinkRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnyThinkRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

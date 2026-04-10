package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    @Nullable
    private AnimatorSet b;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.b = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    @NonNull
    protected abstract AnimatorSet b(View view, View view2, boolean z2, boolean z3);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    protected boolean a(View view, View view2, boolean z2, boolean z3) {
        boolean z4 = this.b != null;
        if (z4) {
            this.b.cancel();
        }
        this.b = b(view, view2, z2, z4);
        this.b.addListener(new a());
        this.b.start();
        if (!z3) {
            this.b.end();
        }
        return true;
    }
}

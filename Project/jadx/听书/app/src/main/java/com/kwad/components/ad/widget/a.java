package com.kwad.components.ad.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements ValueAnimator.AnimatorUpdateListener {
    private WeakReference<View> Mt;

    public abstract void a(ViewGroup.LayoutParams layoutParams, Object obj);

    public a(View view) {
        this.Mt = new WeakReference<>(view);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        WeakReference<View> weakReference = this.Mt;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = this.Mt.get();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        a(layoutParams, valueAnimator.getAnimatedValue());
        view.setLayoutParams(layoutParams);
    }
}

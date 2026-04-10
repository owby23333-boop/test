package com.kwad.components.ad.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements ValueAnimator.AnimatorUpdateListener {
    private WeakReference<View> GV;

    public a(View view) {
        this.GV = new WeakReference<>(view);
    }

    public abstract void a(ViewGroup.LayoutParams layoutParams, Object obj);

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        WeakReference<View> weakReference = this.GV;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = this.GV.get();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        a(layoutParams, valueAnimator.getAnimatedValue());
        view.setLayoutParams(layoutParams);
    }
}

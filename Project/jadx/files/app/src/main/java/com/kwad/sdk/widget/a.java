package com.kwad.sdk.widget;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static ValueAnimator ofArgb(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        valueAnimator.setEvaluator(b.Fw());
        return valueAnimator;
    }
}

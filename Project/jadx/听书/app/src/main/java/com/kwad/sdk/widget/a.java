package com.kwad.sdk.widget;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static ValueAnimator ofArgb(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        valueAnimator.setEvaluator(b.SN());
        return valueAnimator;
    }
}

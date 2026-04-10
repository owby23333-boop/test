package com.dangdang.zframework.view.jazzylistview.effects;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes10.dex */
public class GrowEffect implements JazzyEffect {
    private static final float INITIAL_SCALE_FACTOR = 0.8f;

    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void initView(View view, int i, int i2) {
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setScaleX(0.8f);
        view.setScaleY(0.8f);
    }

    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void setupAnimation(View view, int i, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        viewPropertyAnimator.scaleX(1.0f).scaleY(1.0f);
    }
}

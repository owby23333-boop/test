package com.dangdang.zframework.view.jazzylistview.effects;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes10.dex */
public class TiltEffect implements JazzyEffect {
    private static final float INITIAL_SCALE_FACTOR = 0.7f;

    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void initView(View view, int i, int i2) {
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setScaleX(0.7f);
        view.setScaleY(0.7f);
        view.setTranslationY((view.getHeight() / 2) * i2);
        view.setAlpha(127.0f);
    }

    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void setupAnimation(View view, int i, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        viewPropertyAnimator.translationYBy(((-view.getHeight()) / 2) * i2).scaleX(1.0f).scaleY(1.0f).alpha(255.0f);
    }
}

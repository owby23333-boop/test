package com.dangdang.zframework.view.jazzylistview.effects;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes10.dex */
public class FlyEffect implements JazzyEffect {
    private static final int INITIAL_ROTATION_ANGLE = 135;

    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void initView(View view, int i, int i2) {
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setRotationX(i2 * (-135));
        view.setTranslationY(view.getHeight() * 2 * i2);
    }

    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void setupAnimation(View view, int i, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        viewPropertyAnimator.rotationXBy(i2 * 135).translationYBy((-view.getHeight()) * 2 * i2);
    }
}

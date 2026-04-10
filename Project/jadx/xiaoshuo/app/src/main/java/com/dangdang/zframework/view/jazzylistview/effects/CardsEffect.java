package com.dangdang.zframework.view.jazzylistview.effects;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes10.dex */
public class CardsEffect implements JazzyEffect {
    private static final int INITIAL_ROTATION_ANGLE = 90;

    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void initView(View view, int i, int i2) {
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setRotationX(i2 * 90);
        view.setTranslationY(view.getHeight() * i2);
    }

    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void setupAnimation(View view, int i, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        viewPropertyAnimator.rotationXBy(i2 * (-90)).translationYBy((-view.getHeight()) * i2);
    }
}

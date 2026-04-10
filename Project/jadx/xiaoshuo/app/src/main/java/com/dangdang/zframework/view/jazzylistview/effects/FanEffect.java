package com.dangdang.zframework.view.jazzylistview.effects;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes10.dex */
public class FanEffect implements JazzyEffect {
    private static final int INITIAL_ROTATION_ANGLE = 70;

    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void initView(View view, int i, int i2) {
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setRotation(i2 * 70);
    }

    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void setupAnimation(View view, int i, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        viewPropertyAnimator.rotationBy(i2 * (-70));
    }
}

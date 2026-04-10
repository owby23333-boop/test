package com.dangdang.zframework.view.jazzylistview.effects;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes10.dex */
public class SlideInEffect implements JazzyEffect {
    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void initView(View view, int i, int i2) {
        view.setTranslationY((view.getHeight() / 2) * i2);
    }

    @Override // com.dangdang.zframework.view.jazzylistview.effects.JazzyEffect
    public void setupAnimation(View view, int i, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        viewPropertyAnimator.translationYBy(((-view.getHeight()) / 2) * i2);
    }
}

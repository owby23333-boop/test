package com.lcodecore.tkrefreshlayout.footer;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.lcodecore.tkrefreshlayout.R$drawable;
import com.lcodecore.tkrefreshlayout.a;

/* JADX INFO: loaded from: classes3.dex */
public class LoadingView extends ImageView implements a {
    public LoadingView(Context context) {
        this(context, null);
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public void a(float f2, float f3) {
        ((AnimationDrawable) getDrawable()).start();
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public void a(float f2, float f3, float f4) {
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public void b(float f2, float f3, float f4) {
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public View getView() {
        return this;
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public void onFinish() {
        ((AnimationDrawable) getDrawable()).stop();
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public void reset() {
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int iA = com.lcodecore.tkrefreshlayout.h.a.a(context, 100.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setImageResource(R$drawable.anim_loading_view);
    }
}

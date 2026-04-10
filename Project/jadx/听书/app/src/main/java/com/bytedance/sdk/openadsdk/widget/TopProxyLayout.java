package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class TopProxyLayout extends View {
    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public TopProxyLayout(Context context) {
        this(context, null);
    }

    public TopProxyLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopProxyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }
}

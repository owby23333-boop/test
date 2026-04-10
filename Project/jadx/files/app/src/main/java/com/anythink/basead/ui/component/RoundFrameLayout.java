package com.anythink.basead.ui.component;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.anythink.core.common.k.u;

/* JADX INFO: loaded from: classes2.dex */
public class RoundFrameLayout extends FrameLayout {
    int a;

    public RoundFrameLayout(Context context) {
        super(context);
        this.a = dip2px(getContext(), 10.0f);
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        u.a(canvas, getWidth(), getHeight(), this.a);
        canvas.restoreToCount(iSaveLayer);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = dip2px(getContext(), 10.0f);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = dip2px(getContext(), 10.0f);
    }
}

package com.anythink.core.common.ui.component;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.anythink.core.common.k.u;

/* JADX INFO: loaded from: classes2.dex */
public class RoundRelativeLayout extends RelativeLayout {
    int a;

    public RoundRelativeLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.a = dip2px(context, 4.0f);
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.draw(canvas);
        u.a(canvas, getWidth(), getHeight(), this.a);
        canvas.restoreToCount(iSaveLayer);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = dip2px(context, 4.0f);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        this(context);
    }
}

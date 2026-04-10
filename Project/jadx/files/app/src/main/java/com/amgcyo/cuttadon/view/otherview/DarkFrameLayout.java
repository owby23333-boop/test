package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class DarkFrameLayout extends AdFrameLayout {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Paint f4953t;

    public DarkFrameLayout(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.h0()) {
            this.f4953t.setColor(-1728053248);
        } else {
            this.f4953t.setColor(Color.argb(0, 0, 0, 0));
        }
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getHeight(), this.f4953t);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        a(canvas);
    }

    public DarkFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DarkFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4953t = new Paint();
    }
}

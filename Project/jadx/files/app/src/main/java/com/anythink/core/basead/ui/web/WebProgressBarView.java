package com.anythink.core.basead.ui.web;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class WebProgressBarView extends View {
    int a;
    int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Paint f6609c;

    public WebProgressBarView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.b = -14575885;
        this.f6609c = new Paint();
        this.f6609c.setColor(this.b);
        this.f6609c.setAntiAlias(true);
        this.f6609c.setDither(true);
        this.a = 0;
        setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.a) / 100, getHeight(), this.f6609c);
        canvas.restore();
    }

    public void setProgress(int i2) {
        this.a = i2;
        postInvalidate();
    }

    public WebProgressBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public WebProgressBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}

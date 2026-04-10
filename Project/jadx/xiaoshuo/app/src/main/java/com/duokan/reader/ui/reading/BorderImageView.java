package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes5.dex */
public class BorderImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5691b;
    public Paint c;

    public BorderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5690a = false;
        int color = Color.parseColor("#ed6c00");
        this.f5691b = color;
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(color);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(2.0f);
    }

    public boolean a() {
        return this.f5690a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5690a) {
            Rect clipBounds = canvas.getClipBounds();
            clipBounds.top++;
            clipBounds.left++;
            int i = clipBounds.bottom - 1;
            clipBounds.bottom = i;
            clipBounds.right = i;
            canvas.drawRect(clipBounds, this.c);
        }
    }

    public void setSelect(boolean z) {
        this.f5690a = z;
        invalidate();
    }
}

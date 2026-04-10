package com.yuewen;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public class v53 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f18890a = new Paint();

    public void a(int i) {
        this.f18890a.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawRect(getBounds(), this.f18890a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f18890a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}

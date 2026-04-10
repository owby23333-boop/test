package com.duokan.account.free.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.duokan.account.t;

/* JADX INFO: loaded from: classes10.dex */
public class FreePersonNoneView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f2297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2298b;

    public FreePersonNoneView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.f2297a = paint;
        paint.setColor(-13421773);
        this.f2297a.setAntiAlias(true);
        this.f2298b = (int) getResources().getDimension(t.g.Yu);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        float f = measuredHeight;
        canvas.drawRect(0.0f, 0.0f, (measuredWidth - this.f2298b) / 2, f, this.f2297a);
        canvas.drawRect(r2 + this.f2298b, 0.0f, measuredWidth, f, this.f2297a);
    }

    public FreePersonNoneView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FreePersonNoneView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}

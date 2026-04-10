package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class WaveAnimImageView extends ImageView {
    int a;
    int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f6319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f6320d;

    public static class a {
        float a;
        float b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f6321c;

        public a(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.f6321c = f4;
        }
    }

    public WaveAnimImageView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f6319c = new Paint();
        this.f6319c.setAntiAlias(true);
        this.f6319c.setStyle(Paint.Style.STROKE);
        this.f6319c.setColor(Color.parseColor("#FFFFFF"));
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a aVar = this.f6320d;
        if (aVar != null) {
            this.f6319c.setAlpha((int) (aVar.f6321c * 255.0f));
            this.f6319c.setStrokeWidth(this.f6320d.b);
            canvas.drawCircle(this.a, this.b, this.f6320d.a, this.f6319c);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.a = getWidth() / 2;
        this.b = getHeight() / 2;
    }

    public void setWaveAnimParams(a aVar) {
        this.f6320d = aVar;
        invalidate();
    }

    public WaveAnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public WaveAnimImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}

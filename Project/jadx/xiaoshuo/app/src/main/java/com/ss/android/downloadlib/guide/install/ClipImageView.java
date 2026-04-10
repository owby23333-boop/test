package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes4.dex */
public class ClipImageView extends ImageView {
    private Path bf;
    private RectF d;
    private boolean e;
    private float[] ga;
    private Paint tg;

    public ClipImageView(Context context) {
        super(context);
        this.e = true;
        e(context);
    }

    public void e(Context context) {
        this.bf = new Path();
        this.d = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.e) {
            this.bf.reset();
            this.d.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.ga;
            if (fArr != null) {
                this.bf.addRoundRect(this.d, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.bf);
            Paint paint = this.tg;
            if (paint != null) {
                canvas.drawPath(this.bf, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.tg = paint;
        paint.setStyle(Paint.Style.FILL);
        this.tg.setColor(i);
    }

    public void setClip(boolean z) {
        this.e = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.ga = fArr;
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f = i;
            setRadius(new float[]{f, f, f, f, f, f, f, f});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = true;
        e(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = true;
        e(context);
    }
}

package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class ClipImageView extends ImageView {
    private RectF b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f18028h;
    private Paint hj;
    private boolean mb;
    private Path ox;

    public ClipImageView(Context context) {
        super(context);
        this.mb = true;
        mb(context);
    }

    protected void mb(Context context) {
        this.ox = new Path();
        this.b = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mb) {
            this.ox.reset();
            this.b.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f18028h;
            if (fArr != null) {
                this.ox.addRoundRect(this.b, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.ox);
            Paint paint = this.hj;
            if (paint != null) {
                canvas.drawPath(this.ox, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.hj = new Paint(1);
        this.hj.setStyle(Paint.Style.FILL);
        this.hj.setColor(i2);
    }

    public void setClip(boolean z2) {
        this.mb = z2;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f18028h = fArr;
    }

    public void setRoundRadius(int i2) {
        if (i2 > 0) {
            float f2 = i2;
            setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mb = true;
        mb(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mb = true;
        mb(context);
    }
}

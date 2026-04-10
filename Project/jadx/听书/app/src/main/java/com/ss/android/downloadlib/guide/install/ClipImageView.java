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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f2010a;
    private RectF dl;
    private Path g;
    private float[] gc;
    private boolean z;

    public ClipImageView(Context context) {
        super(context);
        this.z = true;
        z(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = true;
        z(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.z = true;
        z(context);
    }

    protected void z(Context context) {
        this.g = new Path();
        this.dl = new RectF();
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.gc = fArr;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.f2010a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f2010a.setColor(i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.z) {
            this.g.reset();
            this.dl.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.gc;
            if (fArr != null) {
                this.g.addRoundRect(this.dl, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.g);
            Paint paint = this.f2010a;
            if (paint != null) {
                canvas.drawPath(this.g, paint);
            }
        }
        super.onDraw(canvas);
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f = i;
            setRadius(new float[]{f, f, f, f, f, f, f, f});
        }
    }

    public void setClip(boolean z) {
        this.z = z;
    }
}

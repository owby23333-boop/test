package com.bytedance.sdk.component.adexpress.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.component.sdk.annotation.RequiresApi;
import com.bytedance.sdk.component.utils.wu;

/* JADX INFO: loaded from: classes.dex */
public class BrushMaskView extends View {
    private static final String e = "BrushMaskView";
    private Paint bf;
    private Bitmap d;
    private Paint ga;
    private Paint m;
    private Paint p;
    private Canvas tg;
    private Path v;
    private BitmapDrawable vn;
    private Path zk;

    public BrushMaskView(Context context) {
        super(context);
        e(context);
    }

    public void d() {
        final int width = getWidth();
        final int height = getHeight();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(400L);
        valueAnimator.setIntValues(0, width);
        valueAnimator.setInterpolator(new TimeInterpolator() { // from class: com.bytedance.sdk.component.adexpress.widget.BrushMaskView.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                int i = (int) (width * f);
                if (BrushMaskView.this.tg != null) {
                    Canvas canvas = BrushMaskView.this.tg;
                    int i2 = height;
                    canvas.drawRect(0.0f, i2 / 2, i - 50, i2 / 2, BrushMaskView.this.p);
                    BrushMaskView.this.tg.drawCircle(i, height / 2, 10.0f, BrushMaskView.this.p);
                }
                BrushMaskView.this.postInvalidate();
                return f;
            }
        });
        valueAnimator.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.d;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.ga);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(e(i), e(i2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        e(i, i2);
    }

    public void setEraserSize(float f) {
        this.p.setStrokeWidth(f);
        this.m.setStrokeWidth(f);
    }

    public void setMaskColor(int i) {
        this.bf.setColor(i);
    }

    @RequiresApi(api = 21)
    public void setWatermark(int i) {
        if (i == -1) {
            this.vn = null;
        } else {
            this.vn = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i));
        }
    }

    private void bf(float f, float f2) {
        this.v.reset();
        this.zk.reset();
        this.v.moveTo(f, f2);
        this.zk.moveTo(f, f2);
    }

    private void e(Context context) {
        Paint paint = new Paint();
        this.bf = paint;
        paint.setAntiAlias(true);
        this.bf.setDither(true);
        setMaskColor(-1426063361);
        Paint paint2 = new Paint();
        this.ga = paint2;
        paint2.setAntiAlias(true);
        this.ga.setDither(true);
        Paint paint3 = new Paint();
        this.m = paint3;
        paint3.setColor(-7829368);
        this.m.setAlpha(100);
        this.m.setAntiAlias(true);
        this.m.setDither(true);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeCap(Paint.Cap.ROUND);
        setWatermark(-1);
        Paint paint4 = new Paint();
        this.p = paint4;
        paint4.setAntiAlias(true);
        this.p.setDither(true);
        this.p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeCap(Paint.Cap.ROUND);
        setEraserSize(60.0f);
        this.v = new Path();
        this.zk = new Path();
    }

    public BrushMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    public BrushMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context);
    }

    public void bf() {
        d();
    }

    @TargetApi(21)
    public BrushMaskView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        e(context);
    }

    public void e(float f, float f2) {
        bf(f, f2);
        invalidate();
    }

    private void e(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.d = bitmapCreateBitmap;
            Canvas canvas = this.tg;
            if (canvas == null) {
                this.tg = new Canvas(this.d);
            } else {
                canvas.setBitmap(bitmapCreateBitmap);
            }
            this.tg.drawRoundRect(new RectF(0.0f, 0.0f, i, i2), 120.0f, 120.0f, this.bf);
            if (this.vn != null) {
                this.vn.setBounds(new Rect(0, 0, i, i2));
                this.vn.draw(this.tg);
            }
        } catch (Exception e2) {
            wu.vn(e, e2.getMessage());
        }
    }

    private int e(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }

    public void e() {
        e(getWidth(), getHeight());
        invalidate();
    }
}

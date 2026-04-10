package com.tencent.smtt.sdk.ui.dialog.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class RoundImageView extends ImageView {
    private Paint a;
    private Xfermode b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f19135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f19136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RectF f19137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WeakReference<Bitmap> f19139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f19140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Path f19141i;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f19138f = Color.parseColor("#eaeaea");
        this.a = new Paint();
        this.a.setAntiAlias(true);
        this.f19141i = new Path();
        this.f19136d = new float[8];
        this.f19137e = new RectF();
        this.f19140h = com.tencent.smtt.sdk.ui.dialog.c.a(context, 16.46f);
        int i2 = 0;
        while (true) {
            float[] fArr = this.f19136d;
            if (i2 >= fArr.length) {
                return;
            }
            fArr[i2] = this.f19140h;
            i2++;
        }
    }

    private Bitmap a() {
        Bitmap bitmapCreateBitmap = null;
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f19140h, this.f19140h, paint);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return bitmapCreateBitmap;
        }
    }

    private void a(int i2, int i3) {
        this.f19141i.reset();
        this.a.setStrokeWidth(i2);
        this.a.setColor(i3);
        this.a.setStyle(Paint.Style.STROKE);
    }

    private void a(Canvas canvas, int i2, int i3, RectF rectF, float[] fArr) {
        a(i2, i3);
        this.f19141i.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.f19141i, this.a);
    }

    @Override // android.view.View
    public void invalidate() {
        this.f19139g = null;
        Bitmap bitmap = this.f19135c;
        if (bitmap != null) {
            bitmap.recycle();
            this.f19135c = null;
        }
        super.invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        WeakReference<Bitmap> weakReference = this.f19139g;
        Bitmap bitmap = weakReference == null ? null : weakReference.get();
        if (bitmap == null || bitmap.isRecycled()) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                float f2 = intrinsicWidth;
                float f3 = intrinsicHeight;
                float fMax = Math.max((getWidth() * 1.0f) / f2, (getHeight() * 1.0f) / f3);
                drawable.setBounds(0, 0, (int) (f2 * fMax), (int) (fMax * f3));
                drawable.draw(canvas2);
                Bitmap bitmap2 = this.f19135c;
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    this.f19135c = a();
                }
                this.a.reset();
                this.a.setFilterBitmap(false);
                this.a.setXfermode(this.b);
                Bitmap bitmap3 = this.f19135c;
                if (bitmap3 != null) {
                    canvas2.drawBitmap(bitmap3, 0.0f, 0.0f, this.a);
                }
                this.a.setXfermode(null);
                canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
                this.f19139g = new WeakReference<>(bitmapCreateBitmap);
            }
        } else {
            this.a.setXfermode(null);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.a);
        }
        a(canvas, 1, this.f19138f, this.f19137e, this.f19136d);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f19137e.set(0.5f, 0.5f, i2 - 0.5f, i3 - 0.5f);
    }
}

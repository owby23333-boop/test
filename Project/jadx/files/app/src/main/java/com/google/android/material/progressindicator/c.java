package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: compiled from: CircularDrawingDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends g<CircularProgressIndicatorSpec> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f15637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f15638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f15639f;

    public c(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.f15636c = 1;
    }

    private int c() {
        S s2 = this.a;
        return ((CircularProgressIndicatorSpec) s2).f15626g + (((CircularProgressIndicatorSpec) s2).f15627h * 2);
    }

    @Override // com.google.android.material.progressindicator.g
    public int a() {
        return c();
    }

    @Override // com.google.android.material.progressindicator.g
    public int b() {
        return c();
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(@NonNull Canvas canvas, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        S s2 = this.a;
        float f3 = (((CircularProgressIndicatorSpec) s2).f15626g / 2.0f) + ((CircularProgressIndicatorSpec) s2).f15627h;
        canvas.translate(f3, f3);
        canvas.rotate(-90.0f);
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        this.f15636c = ((CircularProgressIndicatorSpec) this.a).f15628i == 0 ? 1 : -1;
        S s3 = this.a;
        this.f15637d = ((CircularProgressIndicatorSpec) s3).a * f2;
        this.f15638e = ((CircularProgressIndicatorSpec) s3).b * f2;
        this.f15639f = (((CircularProgressIndicatorSpec) s3).f15626g - ((CircularProgressIndicatorSpec) s3).a) / 2.0f;
        if ((this.b.d() && ((CircularProgressIndicatorSpec) this.a).f15634e == 2) || (this.b.c() && ((CircularProgressIndicatorSpec) this.a).f15635f == 1)) {
            this.f15639f += ((1.0f - f2) * ((CircularProgressIndicatorSpec) this.a).a) / 2.0f;
        } else if ((this.b.d() && ((CircularProgressIndicatorSpec) this.a).f15634e == 1) || (this.b.c() && ((CircularProgressIndicatorSpec) this.a).f15635f == 2)) {
            this.f15639f -= ((1.0f - f2) * ((CircularProgressIndicatorSpec) this.a).a) / 2.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.g
    void a(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f3, @ColorInt int i2) {
        if (f2 == f3) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i2);
        paint.setStrokeWidth(this.f15637d);
        int i3 = this.f15636c;
        float f4 = f2 * 360.0f * i3;
        float f5 = (f3 >= f2 ? f3 - f2 : (f3 + 1.0f) - f2) * 360.0f * i3;
        float f6 = this.f15639f;
        canvas.drawArc(new RectF(-f6, -f6, f6, f6), f4, f5, false, paint);
        if (this.f15638e <= 0.0f || Math.abs(f5) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        float f7 = this.f15638e;
        RectF rectF = new RectF(-f7, -f7, f7, f7);
        a(canvas, paint, this.f15637d, this.f15638e, f4, true, rectF);
        a(canvas, paint, this.f15637d, this.f15638e, f4 + f5, false, rectF);
    }

    @Override // com.google.android.material.progressindicator.g
    void a(@NonNull Canvas canvas, @NonNull Paint paint) {
        int iA = com.google.android.material.c.a.a(((CircularProgressIndicatorSpec) this.a).f15633d, this.b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(iA);
        paint.setStrokeWidth(this.f15637d);
        float f2 = this.f15639f;
        canvas.drawArc(new RectF(-f2, -f2, f2, f2), 0.0f, 360.0f, false, paint);
    }

    private void a(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z2, RectF rectF) {
        float f5 = z2 ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f4);
        float f6 = f2 / 2.0f;
        float f7 = f5 * f3;
        canvas.drawRect((this.f15639f - f6) + f3, Math.min(0.0f, this.f15636c * f7), (this.f15639f + f6) - f3, Math.max(0.0f, f7 * this.f15636c), paint);
        canvas.translate((this.f15639f - f6) + f3, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f5) * 90.0f * this.f15636c, true, paint);
        canvas.translate(f2 - (f3 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f5 * 90.0f * this.f15636c, true, paint);
        canvas.restore();
    }
}

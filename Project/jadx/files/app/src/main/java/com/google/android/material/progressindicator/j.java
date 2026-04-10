package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: compiled from: LinearDrawingDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
final class j extends g<LinearProgressIndicatorSpec> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f15666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f15667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f15668e;

    public j(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.f15666c = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.g
    public int a() {
        return ((LinearProgressIndicatorSpec) this.a).a;
    }

    @Override // com.google.android.material.progressindicator.g
    public int b() {
        return -1;
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(@NonNull Canvas canvas, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        Rect clipBounds = canvas.getClipBounds();
        this.f15666c = clipBounds.width();
        float f3 = ((LinearProgressIndicatorSpec) this.a).a;
        canvas.translate(clipBounds.left + (clipBounds.width() / 2.0f), clipBounds.top + (clipBounds.height() / 2.0f) + Math.max(0.0f, (clipBounds.height() - ((LinearProgressIndicatorSpec) this.a).a) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.a).f15631i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.b.d() && ((LinearProgressIndicatorSpec) this.a).f15634e == 1) || (this.b.c() && ((LinearProgressIndicatorSpec) this.a).f15635f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.b.d() || this.b.c()) {
            canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.a).a * (f2 - 1.0f)) / 2.0f);
        }
        float f4 = this.f15666c;
        canvas.clipRect((-f4) / 2.0f, (-f3) / 2.0f, f4 / 2.0f, f3 / 2.0f);
        S s2 = this.a;
        this.f15667d = ((LinearProgressIndicatorSpec) s2).a * f2;
        this.f15668e = ((LinearProgressIndicatorSpec) s2).b * f2;
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f3, @ColorInt int i2) {
        if (f2 == f3) {
            return;
        }
        float f4 = this.f15666c;
        float f5 = this.f15668e;
        float f6 = ((-f4) / 2.0f) + f5 + ((f4 - (f5 * 2.0f)) * f2);
        float f7 = ((-f4) / 2.0f) + f5 + ((f4 - (f5 * 2.0f)) * f3);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i2);
        float f8 = this.f15667d;
        canvas.drawRect(f6, (-f8) / 2.0f, f7, f8 / 2.0f, paint);
        float f9 = this.f15668e;
        RectF rectF = new RectF(-f9, -f9, f9, f9);
        a(canvas, paint, this.f15667d, this.f15668e, f6, true, rectF);
        a(canvas, paint, this.f15667d, this.f15668e, f7, false, rectF);
    }

    @Override // com.google.android.material.progressindicator.g
    void a(@NonNull Canvas canvas, @NonNull Paint paint) {
        int iA = com.google.android.material.c.a.a(((LinearProgressIndicatorSpec) this.a).f15633d, this.b.getAlpha());
        float f2 = ((-this.f15666c) / 2.0f) + this.f15668e;
        float f3 = -f2;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(iA);
        float f4 = this.f15667d;
        canvas.drawRect(f2, (-f4) / 2.0f, f3, f4 / 2.0f, paint);
        float f5 = this.f15668e;
        RectF rectF = new RectF(-f5, -f5, f5, f5);
        a(canvas, paint, this.f15667d, this.f15668e, f2, true, rectF);
        a(canvas, paint, this.f15667d, this.f15668e, f3, false, rectF);
    }

    private static void a(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z2, RectF rectF) {
        canvas.save();
        canvas.translate(f4, 0.0f);
        if (!z2) {
            canvas.rotate(180.0f);
        }
        float f5 = ((-f2) / 2.0f) + f3;
        float f6 = (f2 / 2.0f) - f3;
        canvas.drawRect(-f3, f5, 0.0f, f6, paint);
        canvas.save();
        canvas.translate(0.0f, f5);
        canvas.drawArc(rectF, 180.0f, 90.0f, true, paint);
        canvas.restore();
        canvas.translate(0.0f, f6);
        canvas.drawArc(rectF, 180.0f, -90.0f, true, paint);
        canvas.restore();
    }
}

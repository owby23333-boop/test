package com.google.android.material.k;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: compiled from: ShadowRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f15559i = new int[3];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float[] f15560j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f15561k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f15562l = {0.0f, 0.0f, 0.5f, 1.0f};

    @NonNull
    private final Paint a;

    @NonNull
    private final Paint b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final Paint f15563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f15567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f15568h;

    public a() {
        this(-16777216);
    }

    public void a(int i2) {
        this.f15564d = ColorUtils.setAlphaComponent(i2, 68);
        this.f15565e = ColorUtils.setAlphaComponent(i2, 20);
        this.f15566f = ColorUtils.setAlphaComponent(i2, 0);
        this.a.setColor(this.f15564d);
    }

    public a(int i2) {
        this.f15567g = new Path();
        this.f15568h = new Paint();
        this.a = new Paint();
        a(i2);
        this.f15568h.setColor(0);
        this.b = new Paint(4);
        this.b.setStyle(Paint.Style.FILL);
        this.f15563c = new Paint(this.b);
    }

    public void a(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i2) {
        rectF.bottom += i2;
        rectF.offset(0.0f, -i2);
        int[] iArr = f15559i;
        iArr[0] = this.f15566f;
        iArr[1] = this.f15565e;
        iArr[2] = this.f15564d;
        Paint paint = this.f15563c;
        float f2 = rectF.left;
        paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, iArr, f15560j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f15563c);
        canvas.restore();
    }

    public void a(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i2, float f2, float f3) {
        boolean z2 = f3 < 0.0f;
        Path path = this.f15567g;
        if (z2) {
            int[] iArr = f15561k;
            iArr[0] = 0;
            iArr[1] = this.f15566f;
            iArr[2] = this.f15565e;
            iArr[3] = this.f15564d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = -i2;
            rectF.inset(f4, f4);
            int[] iArr2 = f15561k;
            iArr2[0] = 0;
            iArr2[1] = this.f15564d;
            iArr2[2] = this.f15565e;
            iArr2[3] = this.f15566f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f5 = 1.0f - (i2 / fWidth);
        float[] fArr = f15562l;
        fArr[1] = f5;
        fArr[2] = ((1.0f - f5) / 2.0f) + f5;
        this.b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f15561k, f15562l, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z2) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f15568h);
        }
        canvas.drawArc(rectF, f2, f3, true, this.b);
        canvas.restore();
    }

    @NonNull
    public Paint a() {
        return this.a;
    }
}

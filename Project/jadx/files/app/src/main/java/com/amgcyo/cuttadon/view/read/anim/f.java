package com.amgcyo.cuttadon.view.read.anim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Region;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import com.amgcyo.cuttadon.view.read.anim.PageAnimation;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: compiled from: SimulationPageAnim.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends c {
    private int C;
    private int D;
    private Path E;
    private Path F;
    private PointF G;
    private PointF H;
    private PointF I;
    private PointF J;
    private PointF K;
    private PointF L;
    private PointF M;
    private PointF N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private ColorMatrixColorFilter S;
    private Matrix T;
    private float[] U;
    private boolean V;
    private float W;
    private GradientDrawable X;
    private GradientDrawable Y;
    private GradientDrawable Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private GradientDrawable f5231a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private GradientDrawable f5232b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private GradientDrawable f5233c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private GradientDrawable f5234d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private GradientDrawable f5235e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private Paint f5236f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private Path f5237g0;

    /* JADX INFO: compiled from: SimulationPageAnim.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[PageAnimation.Direction.values().length];

        static {
            try {
                a[PageAnimation.Direction.PRE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PageAnimation.Direction.NEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public f(int i2, int i3, View view, PageAnimation.a aVar) {
        super(i2, i3, view, aVar);
        this.C = 1;
        this.D = 1;
        this.G = new PointF();
        this.H = new PointF();
        this.I = new PointF();
        this.J = new PointF();
        this.K = new PointF();
        this.L = new PointF();
        this.M = new PointF();
        this.N = new PointF();
        this.U = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.E = new Path();
        this.F = new Path();
        this.f5237g0 = new Path();
        this.W = (float) Math.hypot(this.f5189f, this.f5190g);
        this.f5236f0 = new Paint();
        this.f5236f0.setStyle(Paint.Style.FILL);
        j();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        this.S = new ColorMatrixColorFilter(colorMatrix);
        this.T = new Matrix();
        this.f5197n = 0.01f;
        this.f5198o = 0.01f;
    }

    private void d(Canvas canvas) {
        double dAtan2;
        double d2;
        int i2;
        int i3;
        GradientDrawable gradientDrawable;
        int i4;
        int i5;
        GradientDrawable gradientDrawable2;
        if (this.V) {
            PointF pointF = this.H;
            dAtan2 = Math.atan2(pointF.y - this.f5198o, this.f5197n - pointF.x);
        } else {
            float f2 = this.f5198o;
            PointF pointF2 = this.H;
            dAtan2 = Math.atan2(f2 - pointF2.y, this.f5197n - pointF2.x);
        }
        double d3 = 0.7853981633974483d - dAtan2;
        double dCos = Math.cos(d3) * 35.35d;
        double dSin = Math.sin(d3) * 35.35d;
        double d4 = this.f5197n;
        Double.isNaN(d4);
        float f3 = (float) (d4 + dCos);
        if (this.V) {
            double d5 = this.f5198o;
            Double.isNaN(d5);
            d2 = d5 + dSin;
        } else {
            double d6 = this.f5198o;
            Double.isNaN(d6);
            d2 = d6 - dSin;
        }
        float f4 = (float) d2;
        this.F.reset();
        this.F.moveTo(f3, f4);
        this.F.lineTo(this.f5197n, this.f5198o);
        Path path = this.F;
        PointF pointF3 = this.H;
        path.lineTo(pointF3.x, pointF3.y);
        Path path2 = this.F;
        PointF pointF4 = this.G;
        path2.lineTo(pointF4.x, pointF4.y);
        this.F.close();
        canvas.save();
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f5237g0.reset();
                this.f5237g0.moveTo(0.0f, 0.0f);
                this.f5237g0.lineTo(canvas.getWidth(), 0.0f);
                this.f5237g0.lineTo(canvas.getWidth(), canvas.getHeight());
                this.f5237g0.lineTo(0.0f, canvas.getHeight());
                this.f5237g0.close();
                this.f5237g0.op(this.E, Path.Op.XOR);
                canvas.clipPath(this.f5237g0);
            } else {
                canvas.clipPath(this.E, Region.Op.XOR);
            }
            canvas.clipPath(this.F, Region.Op.INTERSECT);
        } catch (Exception unused) {
        }
        if (this.V) {
            float f5 = this.H.x;
            i2 = (int) f5;
            i3 = ((int) f5) + 25;
            gradientDrawable = this.f5234d0;
        } else {
            float f6 = this.H.x;
            i2 = (int) (f6 - 25.0f);
            i3 = ((int) f6) + 1;
            gradientDrawable = this.f5235e0;
        }
        float f7 = this.f5197n;
        PointF pointF5 = this.H;
        float degrees = (float) Math.toDegrees(Math.atan2(f7 - pointF5.x, pointF5.y - this.f5198o));
        PointF pointF6 = this.H;
        canvas.rotate(degrees, pointF6.x, pointF6.y);
        float f8 = this.H.y;
        gradientDrawable.setBounds(i2, (int) (f8 - this.W), i3, (int) f8);
        gradientDrawable.draw(canvas);
        canvas.restore();
        this.F.reset();
        this.F.moveTo(f3, f4);
        this.F.lineTo(this.f5197n, this.f5198o);
        Path path3 = this.F;
        PointF pointF7 = this.L;
        path3.lineTo(pointF7.x, pointF7.y);
        Path path4 = this.F;
        PointF pointF8 = this.K;
        path4.lineTo(pointF8.x, pointF8.y);
        this.F.close();
        canvas.save();
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f5237g0.reset();
                this.f5237g0.moveTo(0.0f, 0.0f);
                this.f5237g0.lineTo(canvas.getWidth(), 0.0f);
                this.f5237g0.lineTo(canvas.getWidth(), canvas.getHeight());
                this.f5237g0.lineTo(0.0f, canvas.getHeight());
                this.f5237g0.close();
                this.f5237g0.op(this.E, Path.Op.XOR);
                canvas.clipPath(this.f5237g0);
            } else {
                canvas.clipPath(this.E, Region.Op.XOR);
            }
            canvas.clipPath(this.F, Region.Op.INTERSECT);
        } catch (Exception unused2) {
        }
        if (this.V) {
            float f9 = this.L.y;
            i4 = (int) f9;
            i5 = (int) (f9 + 25.0f);
            gradientDrawable2 = this.f5233c0;
        } else {
            float f10 = this.L.y;
            i4 = (int) (f10 - 25.0f);
            i5 = (int) (f10 + 1.0f);
            gradientDrawable2 = this.f5232b0;
        }
        PointF pointF9 = this.L;
        float degrees2 = (float) Math.toDegrees(Math.atan2(pointF9.y - this.f5198o, pointF9.x - this.f5197n));
        PointF pointF10 = this.L;
        canvas.rotate(degrees2, pointF10.x, pointF10.y);
        float f11 = this.L.y;
        if (f11 < 0.0f) {
            f11 -= this.f5190g;
        }
        int iHypot = (int) Math.hypot(this.L.x, f11);
        float f12 = iHypot;
        float f13 = this.W;
        if (f12 > f13) {
            float f14 = this.L.x;
            gradientDrawable2.setBounds(((int) (f14 - 25.0f)) - iHypot, i4, ((int) (f14 + f13)) - iHypot, i5);
        } else {
            float f15 = this.L.x;
            gradientDrawable2.setBounds((int) (f15 - f13), i4, (int) f15, i5);
        }
        gradientDrawable2.draw(canvas);
        canvas.restore();
    }

    private void i() {
        float f2 = this.f5197n;
        int i2 = this.C;
        this.O = (f2 + i2) / 2.0f;
        float f3 = this.f5198o;
        int i3 = this.D;
        this.P = (f3 + i3) / 2.0f;
        PointF pointF = this.H;
        float f4 = this.O;
        float f5 = this.P;
        pointF.x = f4 - (((i3 - f5) * (i3 - f5)) / (i2 - f4));
        pointF.y = i3;
        PointF pointF2 = this.L;
        pointF2.x = i2;
        if (i3 - f5 == 0.0f) {
            pointF2.y = f5 - (((i2 - f4) * (i2 - f4)) / 0.1f);
        } else {
            pointF2.y = f5 - (((i2 - f4) * (i2 - f4)) / (i3 - f5));
        }
        PointF pointF3 = this.G;
        float f6 = this.H.x;
        pointF3.x = f6 - ((this.C - f6) / 2.0f);
        pointF3.y = this.D;
        float f7 = this.f5197n;
        if (f7 > 0.0f) {
            int i4 = this.f5189f;
            if (f7 < i4) {
                float f8 = pointF3.x;
                if (f8 < 0.0f || f8 > i4) {
                    PointF pointF4 = this.G;
                    float f9 = pointF4.x;
                    if (f9 < 0.0f) {
                        pointF4.x = this.f5189f - f9;
                    }
                    float fAbs = Math.abs(this.C - this.f5197n);
                    this.f5197n = Math.abs(this.C - ((this.f5189f * fAbs) / this.G.x));
                    this.f5198o = Math.abs(this.D - ((Math.abs(this.C - this.f5197n) * Math.abs(this.D - this.f5198o)) / fAbs));
                    float f10 = this.f5197n;
                    int i5 = this.C;
                    this.O = (f10 + i5) / 2.0f;
                    float f11 = this.f5198o;
                    int i6 = this.D;
                    this.P = (f11 + i6) / 2.0f;
                    PointF pointF5 = this.H;
                    float f12 = this.O;
                    float f13 = this.P;
                    pointF5.x = f12 - (((i6 - f13) * (i6 - f13)) / (i5 - f12));
                    pointF5.y = i6;
                    PointF pointF6 = this.L;
                    pointF6.x = i5;
                    if (i6 - f13 == 0.0f) {
                        pointF6.y = f13 - (((i5 - f12) * (i5 - f12)) / 0.1f);
                    } else {
                        pointF6.y = f13 - (((i5 - f12) * (i5 - f12)) / (i6 - f13));
                    }
                    PointF pointF7 = this.G;
                    float f14 = this.H.x;
                    pointF7.x = f14 - ((this.C - f14) / 2.0f);
                }
            }
        }
        PointF pointF8 = this.K;
        pointF8.x = this.C;
        float f15 = this.L.y;
        pointF8.y = f15 - ((this.D - f15) / 2.0f);
        this.R = (float) Math.hypot(this.f5197n - r1, this.f5198o - r4);
        this.J = a(new PointF(this.f5197n, this.f5198o), this.H, this.G, this.K);
        this.N = a(new PointF(this.f5197n, this.f5198o), this.L, this.G, this.K);
        PointF pointF9 = this.I;
        PointF pointF10 = this.G;
        float f16 = pointF10.x;
        PointF pointF11 = this.H;
        float f17 = f16 + (pointF11.x * 2.0f);
        PointF pointF12 = this.J;
        pointF9.x = (f17 + pointF12.x) / 4.0f;
        pointF9.y = (((pointF11.y * 2.0f) + pointF10.y) + pointF12.y) / 4.0f;
        PointF pointF13 = this.M;
        PointF pointF14 = this.K;
        float f18 = pointF14.x;
        PointF pointF15 = this.L;
        float f19 = f18 + (pointF15.x * 2.0f);
        PointF pointF16 = this.N;
        pointF13.x = (f19 + pointF16.x) / 4.0f;
        pointF13.y = (((pointF15.y * 2.0f) + pointF14.y) + pointF16.y) / 4.0f;
    }

    private void j() {
        int[] iArr = {3355443, -1338821837};
        this.f5231a0 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, iArr);
        this.f5231a0.setGradientType(0);
        this.Z = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        this.Z.setGradientType(0);
        int[] iArr2 = {-15658735, 1118481};
        this.Y = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, iArr2);
        this.Y.setGradientType(0);
        this.X = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr2);
        this.X.setGradientType(0);
        int[] iArr3 = {-2146365167, 1118481};
        this.f5234d0 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr3);
        this.f5234d0.setGradientType(0);
        this.f5235e0 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, iArr3);
        this.f5235e0.setGradientType(0);
        this.f5233c0 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr3);
        this.f5233c0.setGradientType(0);
        this.f5232b0 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, iArr3);
        this.f5232b0.setGradientType(0);
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void a(PageAnimation.Direction direction) {
        super.a(direction);
        int i2 = a.a[direction.ordinal()];
        if (i2 == 1) {
            float f2 = this.f5195l;
            int i3 = this.f5189f;
            if (f2 > i3 / 2) {
                c(f2, this.f5190g);
                return;
            } else {
                c(i3 - f2, this.f5190g);
                return;
            }
        }
        if (i2 != 2) {
            return;
        }
        int i4 = this.f5189f;
        float f3 = i4 / 2;
        float f4 = this.f5195l;
        if (f3 > f4) {
            c(i4 - f4, this.f5196m);
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.c
    public void b(Canvas canvas) {
        if (this.f5187d == PageAnimation.Direction.NEXT) {
            i();
            a(canvas, this.f5216u, this.E);
            b(canvas, this.f5217v);
            d(canvas);
            a(canvas, this.f5216u);
            return;
        }
        i();
        a(canvas, this.f5217v, this.E);
        b(canvas, this.f5216u);
        d(canvas);
        a(canvas, this.f5217v);
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.c
    public void c(Canvas canvas) {
        if (!this.f5218w) {
            canvas.drawBitmap(this.f5217v, 0.0f, 0.0f, (Paint) null);
        } else {
            this.f5217v = this.f5216u.copy(Bitmap.Config.RGB_565, true);
            canvas.drawBitmap(this.f5216u, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void g() {
        int i2;
        float f2;
        float f3;
        int i3;
        super.g();
        if (this.f5218w) {
            i2 = (this.C <= 0 || !this.f5187d.equals(PageAnimation.Direction.NEXT)) ? -((int) this.f5197n) : (int) (this.f5189f - this.f5197n);
            if (!this.f5187d.equals(PageAnimation.Direction.NEXT)) {
                i2 = (int) (-(this.f5189f + this.f5197n));
            }
            if (this.D <= 0) {
                i3 = -((int) this.f5198o);
                this.b.startScroll((int) this.f5197n, (int) this.f5198o, i2, i3, TbsListener.ErrorCode.INFO_CODE_BASE);
            } else {
                f2 = this.f5190g;
                f3 = this.f5198o;
            }
        } else {
            if (this.C <= 0 || !this.f5187d.equals(PageAnimation.Direction.NEXT)) {
                int i4 = this.f5189f;
                i2 = (int) ((i4 - this.f5197n) + i4);
            } else {
                i2 = -((int) (this.f5189f + this.f5197n));
            }
            if (this.D > 0) {
                f2 = this.f5190g;
                f3 = this.f5198o;
            } else {
                f2 = 1.0f;
                f3 = this.f5198o;
            }
        }
        i3 = (int) (f2 - f3);
        this.b.startScroll((int) this.f5197n, (int) this.f5198o, i2, i3, TbsListener.ErrorCode.INFO_CODE_BASE);
    }

    public void c(float f2, float f3) {
        int i2 = this.f5189f;
        if (f2 <= i2 / 2) {
            this.C = 0;
        } else {
            this.C = i2;
        }
        int i3 = this.f5190g;
        if (f3 <= i3 / 2) {
            this.D = 0;
        } else {
            this.D = i3;
        }
        if ((this.C == 0 && this.D == this.f5190g) || (this.C == this.f5189f && this.D == 0)) {
            this.V = true;
        } else {
            this.V = false;
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void a(float f2, float f3) {
        super.a(f2, f3);
        c(f2, f3);
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        int i2;
        int i3;
        GradientDrawable gradientDrawable;
        float f2 = this.G.x;
        float fAbs = Math.abs((((int) (f2 + r1)) / 2) - this.H.x);
        float f3 = this.K.y;
        float fMin = Math.min(fAbs, Math.abs((((int) (f3 + r2)) / 2) - this.L.y));
        this.F.reset();
        Path path = this.F;
        PointF pointF = this.M;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.F;
        PointF pointF2 = this.I;
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.F;
        PointF pointF3 = this.J;
        path3.lineTo(pointF3.x, pointF3.y);
        this.F.lineTo(this.f5197n, this.f5198o);
        Path path4 = this.F;
        PointF pointF4 = this.N;
        path4.lineTo(pointF4.x, pointF4.y);
        this.F.close();
        if (this.V) {
            float f4 = this.G.x;
            i2 = (int) (f4 - 1.0f);
            i3 = (int) (f4 + fMin + 1.0f);
            gradientDrawable = this.Z;
        } else {
            float f5 = this.G.x;
            i2 = (int) ((f5 - fMin) - 1.0f);
            i3 = (int) (f5 + 1.0f);
            gradientDrawable = this.f5231a0;
        }
        canvas.save();
        try {
            canvas.clipPath(this.E);
            canvas.clipPath(this.F, Region.Op.INTERSECT);
        } catch (Exception unused) {
        }
        this.f5236f0.setColorFilter(this.S);
        int pixel = bitmap.getPixel(1, 1);
        int iArgb = Color.argb(200, (16711680 & pixel) >> 16, (65280 & pixel) >> 8, pixel & 255);
        float fHypot = (float) Math.hypot(this.C - this.H.x, this.L.y - this.D);
        float f6 = (this.C - this.H.x) / fHypot;
        float f7 = (this.L.y - this.D) / fHypot;
        float[] fArr = this.U;
        fArr[0] = 1.0f - ((f7 * 2.0f) * f7);
        float f8 = 2.0f * f6;
        fArr[1] = f7 * f8;
        fArr[3] = fArr[1];
        fArr[4] = 1.0f - (f8 * f6);
        this.T.reset();
        this.T.setValues(this.U);
        Matrix matrix = this.T;
        PointF pointF5 = this.H;
        matrix.preTranslate(-pointF5.x, -pointF5.y);
        Matrix matrix2 = this.T;
        PointF pointF6 = this.H;
        matrix2.postTranslate(pointF6.x, pointF6.y);
        canvas.drawBitmap(bitmap, this.T, this.f5236f0);
        canvas.drawColor(iArgb);
        this.f5236f0.setColorFilter(null);
        float f9 = this.Q;
        PointF pointF7 = this.G;
        canvas.rotate(f9, pointF7.x, pointF7.y);
        float f10 = this.G.y;
        gradientDrawable.setBounds(i2, (int) f10, i3, (int) (f10 + this.W));
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void b(float f2, float f3) {
        super.b(f2, f3);
        float f4 = this.f5196m;
        int i2 = this.f5190g;
        if ((f4 > i2 / 3 && f4 < (i2 * 2) / 3) || this.f5187d.equals(PageAnimation.Direction.PRE)) {
            this.f5198o = this.f5190g;
        }
        float f5 = this.f5196m;
        int i3 = this.f5190g;
        if (f5 <= i3 / 3 || f5 >= i3 / 2 || !this.f5187d.equals(PageAnimation.Direction.NEXT)) {
            return;
        }
        this.f5198o = 1.0f;
    }

    private void b(Canvas canvas, Bitmap bitmap) {
        int i2;
        int i3;
        GradientDrawable gradientDrawable;
        this.F.reset();
        Path path = this.F;
        PointF pointF = this.G;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.F;
        PointF pointF2 = this.I;
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.F;
        PointF pointF3 = this.M;
        path3.lineTo(pointF3.x, pointF3.y);
        Path path4 = this.F;
        PointF pointF4 = this.K;
        path4.lineTo(pointF4.x, pointF4.y);
        this.F.lineTo(this.C, this.D);
        this.F.close();
        this.Q = (float) Math.toDegrees(Math.atan2(this.H.x - this.C, this.L.y - this.D));
        if (this.V) {
            float f2 = this.G.x;
            i2 = (int) f2;
            i3 = (int) (f2 + (this.R / 4.0f));
            gradientDrawable = this.X;
        } else {
            float f3 = this.G.x;
            i2 = (int) (f3 - (this.R / 4.0f));
            i3 = (int) f3;
            gradientDrawable = this.Y;
        }
        canvas.save();
        try {
            canvas.clipPath(this.E);
            canvas.clipPath(this.F, Region.Op.INTERSECT);
        } catch (Exception unused) {
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f4 = this.Q;
        PointF pointF5 = this.G;
        canvas.rotate(f4, pointF5.x, pointF5.y);
        float f5 = this.G.y;
        gradientDrawable.setBounds(i2, (int) f5, i3, (int) (this.W + f5));
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void a(Canvas canvas, Bitmap bitmap, Path path) {
        this.E.reset();
        Path path2 = this.E;
        PointF pointF = this.G;
        path2.moveTo(pointF.x, pointF.y);
        Path path3 = this.E;
        PointF pointF2 = this.H;
        float f2 = pointF2.x;
        float f3 = pointF2.y;
        PointF pointF3 = this.J;
        path3.quadTo(f2, f3, pointF3.x, pointF3.y);
        this.E.lineTo(this.f5197n, this.f5198o);
        Path path4 = this.E;
        PointF pointF4 = this.N;
        path4.lineTo(pointF4.x, pointF4.y);
        Path path5 = this.E;
        PointF pointF5 = this.L;
        float f4 = pointF5.x;
        float f5 = pointF5.y;
        PointF pointF6 = this.K;
        path5.quadTo(f4, f5, pointF6.x, pointF6.y);
        this.E.lineTo(this.C, this.D);
        this.E.close();
        canvas.save();
        if (Build.VERSION.SDK_INT >= 28) {
            this.f5237g0.reset();
            this.f5237g0.moveTo(0.0f, 0.0f);
            this.f5237g0.lineTo(canvas.getWidth(), 0.0f);
            this.f5237g0.lineTo(canvas.getWidth(), canvas.getHeight());
            this.f5237g0.lineTo(0.0f, canvas.getHeight());
            this.f5237g0.close();
            this.f5237g0.op(path, Path.Op.XOR);
            canvas.clipPath(this.f5237g0);
        } else {
            canvas.clipPath(path, Region.Op.XOR);
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        try {
            canvas.restore();
        } catch (Exception unused) {
        }
    }

    private PointF a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        PointF pointF5 = new PointF();
        float f2 = pointF2.y;
        float f3 = pointF.y;
        float f4 = pointF2.x;
        float f5 = pointF.x;
        float f6 = (f2 - f3) / (f4 - f5);
        float f7 = ((f2 * f5) - (f3 * f4)) / (f5 - f4);
        float f8 = pointF4.y;
        float f9 = pointF3.y;
        float f10 = pointF4.x;
        float f11 = pointF3.x;
        pointF5.x = ((((f8 * f11) - (f9 * f10)) / (f11 - f10)) - f7) / (f6 - ((f8 - f9) / (f10 - f11)));
        pointF5.y = (f6 * pointF5.x) + f7;
        return pointF5;
    }
}

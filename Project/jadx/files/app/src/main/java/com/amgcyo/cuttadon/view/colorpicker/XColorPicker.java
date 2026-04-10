package com.amgcyo.cuttadon.view.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class XColorPicker extends View {
    private Bitmap A;
    private Paint B;
    private Paint C;
    private PointF D;
    private a E;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final float[] f4421s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4422t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4423u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4424v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f4425w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f4426x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int[] f4427y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Rect f4428z;

    public XColorPicker(Context context) {
        super(context);
        this.f4421s = new float[]{0.0f, 0.0f, 1.0f};
        this.B = new Paint();
        this.C = new Paint();
        this.D = new PointF();
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.XColorPicker, i2, 0);
        this.f4422t = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, a(12.0f));
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, a(1.0f));
        int color = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        typedArrayObtainStyledAttributes.recycle();
        this.B.setColor(color);
        this.B.setStrokeWidth(dimensionPixelOffset);
        this.f4423u = this.f4422t / 2;
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setStrokeWidth(3.0f);
        this.C.setAntiAlias(true);
        setColor(Color.HSVToColor(this.f4421s));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.A;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f4428z, (Paint) null);
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                this.f4426x = this.f4425w - 2.0f;
                this.C.setColor(((ColorDrawable) background).getColor());
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((getWidth() / 2.0f) - this.f4423u) - 1.0f, this.C);
            }
            float f2 = (this.f4421s[0] / 180.0f) * 3.1415927f;
            PointF pointF = this.D;
            double d2 = this.f4428z.left;
            double d3 = f2;
            double d4 = -Math.cos(d3);
            double d5 = this.f4421s[1];
            Double.isNaN(d5);
            double d6 = d4 * d5;
            double d7 = this.f4426x;
            Double.isNaN(d7);
            double d8 = d6 * d7;
            double d9 = this.f4425w;
            Double.isNaN(d9);
            Double.isNaN(d2);
            pointF.x = (float) (d2 + d8 + d9);
            PointF pointF2 = this.D;
            double d10 = this.f4428z.top;
            double d11 = -Math.sin(d3);
            double d12 = this.f4421s[1];
            Double.isNaN(d12);
            double d13 = d11 * d12;
            double d14 = this.f4426x;
            Double.isNaN(d14);
            double d15 = d13 * d14;
            double d16 = this.f4425w;
            Double.isNaN(d16);
            Double.isNaN(d10);
            pointF2.y = (float) (d10 + d15 + d16);
            PointF pointF3 = this.D;
            float f3 = pointF3.x;
            int i2 = this.f4422t;
            float f4 = pointF3.y;
            canvas.drawLine(f3 - (i2 / 2.0f), f4, f3 + (i2 / 2.0f), f4, this.B);
            PointF pointF4 = this.D;
            float f5 = pointF4.x;
            float f6 = pointF4.y;
            int i3 = this.f4422t;
            canvas.drawLine(f5, f6 - (i3 / 2.0f), f5, f6 + (i3 / 2.0f), this.B);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int iMin = Math.min(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        setMeasuredDimension(iMin, iMin);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = this.f4423u;
        this.f4428z = new Rect(i6, i6, i2 - i6, i3 - i6);
        this.A = Bitmap.createBitmap(this.f4428z.width(), this.f4428z.height(), Bitmap.Config.ARGB_8888);
        this.f4425w = Math.min(this.f4428z.width(), this.f4428z.height()) / 2;
        this.f4426x = this.f4425w;
        this.f4427y = new int[this.f4428z.width() * this.f4428z.height()];
        a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 2) {
            return super.onTouchEvent(motionEvent);
        }
        int iA = a(255, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f4421s);
        int iA2 = a(128, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f4421s);
        a aVar = this.E;
        if (aVar != null) {
            aVar.a(iA, iA2);
        }
        this.f4424v = iA;
        invalidate();
        return true;
    }

    public void setColor(int i2) {
        a aVar = this.E;
        if (aVar != null) {
            aVar.a(i2, this.f4424v);
        }
        this.f4424v = i2;
        Color.colorToHSV(i2, this.f4421s);
        invalidate();
    }

    public void setOnColorSelectListener(a aVar) {
        this.E = aVar;
    }

    public XColorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4421s = new float[]{0.0f, 0.0f, 1.0f};
        this.B = new Paint();
        this.C = new Paint();
        this.D = new PointF();
        a(context, attributeSet, 0);
    }

    public XColorPicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4421s = new float[]{0.0f, 0.0f, 1.0f};
        this.B = new Paint();
        this.C = new Paint();
        this.D = new PointF();
        a(context, attributeSet, i2);
    }

    private void a() {
        int iWidth = this.f4428z.width();
        int iHeight = this.f4428z.height();
        int[] iArr = new int[iWidth * iHeight];
        float[] fArr = {0.0f, 0.0f, 1.0f};
        float f2 = this.f4425w;
        int i2 = (int) (-f2);
        int i3 = (int) (-f2);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (i4 % iWidth == 0) {
                i2 = (int) (-this.f4425w);
                i3++;
            } else {
                i2++;
            }
            double dSqrt = Math.sqrt((i2 * i2) + (i3 * i3));
            if (dSqrt <= this.f4425w) {
                fArr[0] = ((float) ((Math.atan2(i3, i2) / 3.141592653589793d) * 180.0d)) + 180.0f;
                double d2 = this.f4425w;
                Double.isNaN(d2);
                fArr[1] = (float) (dSqrt / d2);
                iArr[i4] = Color.HSVToColor(255, fArr);
            } else {
                iArr[i4] = 0;
            }
        }
        for (int i5 = 0; i5 < iWidth; i5++) {
            for (int i6 = 0; i6 < iHeight; i6++) {
                int i7 = (i5 * iHeight) + i6;
                this.f4427y[i7] = iArr[i7];
            }
        }
        this.A.setPixels(this.f4427y, 0, iWidth, 0, 0, iWidth, iHeight);
        invalidate();
    }

    private int a(int i2, int i3, int i4, float[] fArr) {
        float f2 = this.f4425w;
        int i5 = (int) (i3 - f2);
        int i6 = (int) (i4 - f2);
        double dSqrt = Math.sqrt((i5 * i5) + (i6 * i6));
        fArr[0] = ((float) ((Math.atan2(i6, i5) / 3.141592653589793d) * 180.0d)) + 180.0f;
        double d2 = this.f4425w;
        Double.isNaN(d2);
        fArr[1] = Math.max(0.0f, Math.min(1.0f, (float) (dSqrt / d2)));
        return Color.HSVToColor(i2, fArr);
    }

    private int a(float f2) {
        return (int) ((getResources().getDisplayMetrics().density * f2) + 0.5f);
    }
}

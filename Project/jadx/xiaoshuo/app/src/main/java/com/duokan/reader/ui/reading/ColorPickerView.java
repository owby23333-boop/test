package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.yuewen.mt2;

/* JADX INFO: loaded from: classes5.dex */
public class ColorPickerView extends View {
    public int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f5730b;
    public int c;
    public int d;
    public int[] e;
    public int f;
    public int g;
    public Drawable h;
    public Drawable i;
    public Paint j;
    public final int k;
    public boolean l;
    public boolean m;
    public PointF n;
    public PointF o;
    public a p;
    public boolean q;
    public boolean r;
    public float s;
    public Bitmap t;
    public float u;
    public int v;
    public int w;
    public int x;
    public float y;
    public float z;

    public interface a {
        void a(int i, int i2, float f);
    }

    public ColorPickerView(Context context) {
        this(context, null);
    }

    private Bitmap getGradual() {
        if (this.t == null) {
            Paint paint = new Paint();
            paint.setStrokeWidth(1.0f);
            this.t = com.duokan.core.utils.a.d(this.g, this.c - (this.k * 2), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(this.t);
            int width = this.t.getWidth();
            this.g = width;
            int height = this.t.getHeight();
            float f = height / 2;
            float f2 = width;
            float f3 = width / 2;
            float f4 = height;
            paint.setShader(new ComposeShader(new LinearGradient(0.0f, f, f2, f, new int[]{-65536, InputDeviceCompat.SOURCE_ANY, -16711936, -16711681, -16776961, -65281}, (float[]) null, Shader.TileMode.REPEAT), new LinearGradient(f3, 0.0f, f3, f4, -1, -16777216, Shader.TileMode.CLAMP), PorterDuff.Mode.SCREEN));
            canvas.drawRect(0.0f, 0.0f, f2, f4, paint);
        }
        return this.t;
    }

    public final int a(int i, int i2, float f) {
        return i + Math.round(f * (i2 - i));
    }

    public final int b(float f, float f2) {
        Bitmap gradual = getGradual();
        int width = (int) f;
        int height = (int) f2;
        if (width >= gradual.getWidth()) {
            width = gradual.getWidth() - 1;
        }
        if (height >= gradual.getHeight()) {
            height = gradual.getHeight() - 1;
        }
        return gradual.getPixel(width, height);
    }

    public final int c(float f) {
        int i;
        int i2;
        float f2 = (this.c - (this.k * 2.0f)) / 2.0f;
        if (f < f2) {
            int[] iArr = this.e;
            i = iArr[0];
            i2 = iArr[1];
        } else {
            int[] iArr2 = this.e;
            i = iArr2[1];
            i2 = iArr2[2];
            f -= f2;
        }
        float f3 = f / f2;
        return Color.argb(a(Color.alpha(i), Color.alpha(i2), f3), a(Color.red(i), Color.red(i2), f3), a(Color.green(i), Color.green(i2), f3), a(Color.blue(i), Color.blue(i2), f3));
    }

    public final boolean d(float f, float f2) {
        if (0.0f >= f) {
            return false;
        }
        int i = this.k;
        return f < ((float) ((this.g + i) + (i / 2))) && 0.0f < f2 && f2 < ((float) this.d);
    }

    public final boolean e(float f, float f2) {
        int i = this.d;
        int i2 = this.k;
        return ((float) (((i - i2) - this.f) - (i2 / 2))) < f && f < ((float) i) && 0.0f < f2 && f2 < ((float) this.c);
    }

    public final void f() {
        Paint paint = new Paint();
        this.f5730b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f5730b.setStrokeWidth(1.0f);
        this.e = new int[]{-1, 0, -16777216};
        this.j = new Paint();
        this.h = getResources().getDrawable(mt2.h.Ks);
        this.s = r0.getIntrinsicWidth() / 2;
        int i = this.k;
        this.n = new PointF(i, i);
        this.i = getResources().getDrawable(mt2.h.Ms);
        int i2 = this.k;
        this.o = new PointF(i2, i2);
        this.u = this.i.getIntrinsicHeight() / 2;
        this.f = this.i.getIntrinsicWidth() / 2;
    }

    public final boolean g(float f) {
        return (this.w == this.A && this.x == this.f5730b.getColor() && this.y == f) ? false : true;
    }

    public final void h(float f, float f2) {
        int i = this.k;
        if (f < i) {
            this.n.x = i;
        } else {
            int i2 = this.g;
            if (f > i + i2) {
                this.n.x = i2 + i;
            } else {
                this.n.x = f;
            }
        }
        if (f2 < i) {
            this.n.y = i;
            return;
        }
        int i3 = this.c;
        if (f2 <= i3 - i) {
            this.n.y = f2;
        } else {
            this.n.y = i3 - i;
        }
    }

    public final void i(float f, float f2) {
        int i = this.k;
        if (f < i) {
            this.o.x = i;
        } else {
            int i2 = this.g;
            if (f > i + i2) {
                this.o.x = i2 + i;
            } else {
                this.o.x = f;
            }
        }
        if (f2 < i) {
            this.o.y = i;
            return;
        }
        int i3 = this.c;
        if (f2 <= i3 - i) {
            this.o.y = f2;
        } else {
            this.o.y = i3 - i;
        }
    }

    public void j(int i, float f) {
        this.v = i;
        this.z = f;
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Bitmap bitmap = this.t;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.t.recycle();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap gradual = getGradual();
        int i = this.k;
        canvas.drawBitmap(gradual, (Rect) null, new Rect(i, i, this.g + i, this.c - i), this.j);
        this.e[1] = this.f5730b.getColor();
        int i2 = this.d;
        int i3 = this.k;
        int i4 = this.f;
        this.f5730b.setShader(new LinearGradient((i2 - i3) - (i4 / 2), i3, (i2 - i3) - (i4 / 2), this.c - i3, this.e, (float[]) null, Shader.TileMode.MIRROR));
        int i5 = this.d;
        int i6 = i5 - this.f;
        int i7 = this.k;
        canvas.drawRect(new Rect(i6 - i7, i7, i5 - i7, this.c - i7), this.f5730b);
        int iRound = Math.round(this.n.x - this.s);
        int iRound2 = Math.round(this.n.y - this.s);
        Drawable drawable2 = this.h;
        drawable2.setBounds(iRound, iRound2, drawable2.getIntrinsicWidth() + iRound, this.h.getIntrinsicHeight() + iRound2);
        this.h.draw(canvas);
        int intrinsicWidth = ((this.d - this.f) - this.k) - ((this.i.getIntrinsicWidth() - this.f) / 2);
        int iRound3 = Math.round(this.o.y - this.u);
        Drawable drawable3 = this.i;
        drawable3.setBounds(intrinsicWidth, iRound3, drawable3.getIntrinsicWidth() + intrinsicWidth, this.i.getIntrinsicHeight() + iRound3);
        this.i.draw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        PointF pointF = this.o;
        int i5 = this.c;
        pointF.y = ((i5 - (r2 * 2)) * this.z) + this.k;
        Bitmap gradual = getGradual();
        for (int i6 = 0; i6 < gradual.getWidth(); i6++) {
            for (int i7 = 0; i7 < gradual.getHeight(); i7++) {
                int pixel = gradual.getPixel(i6, i7);
                int i8 = this.v;
                if (pixel == i8) {
                    PointF pointF2 = this.n;
                    int i9 = this.k;
                    pointF2.x = i6 + i9;
                    pointF2.y = i7 + i9;
                    this.f5730b.setColor(i8);
                    super.onLayout(z, i, i2, i3, i4);
                    return;
                }
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.d = size;
        } else {
            this.d = 480;
        }
        if (mode2 == 1073741824) {
            this.c = size2;
        } else {
            this.c = 350;
        }
        int i3 = this.d;
        this.g = (i3 - (this.k * 3)) - this.f;
        setMeasuredDimension(i3, this.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.ui.reading.ColorPickerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnColorChangedListenner(a aVar) {
        this.p = aVar;
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = false;
        this.m = false;
        this.q = false;
        this.r = false;
        this.A = Integer.MAX_VALUE;
        this.f5729a = context;
        f();
        this.k = this.h.getIntrinsicWidth() / 2;
        int i = this.v;
        this.w = i;
        this.x = i;
        this.y = -1.0f;
    }
}
